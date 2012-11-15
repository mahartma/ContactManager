package test.contactmanager.server;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import test.contactmanager.client.ContactManagerService;
import test.contactmanager.shared.Contact;

import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;

public class ContactManagerServiceImpl implements ContactManagerService {

	private ContactsService contactsService;

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}
	
	@Override
	public List<Contact> queryContacts(String name, String user, String password) {
		try {
			contactsService.setUserCredentials(user, password);

			URL feedUrl = new URL(
					"https://www.google.com/m8/feeds/contacts/" + user + "/full");
			Query myQuery = new Query(feedUrl);
			myQuery.setMaxResults(100);
			ContactFeed resultFeed = contactsService.query(myQuery, ContactFeed.class);


			List<Contact> ret = new ArrayList<Contact>();
			for (ContactEntry e : resultFeed.getEntries()) {
				if (e.getName() != null && e.getName().getFullName() != null) {
					ret.add(new Contact(e.getName().getFullName().getValue(), e.getId()));
				} else if (e.getName() != null && e.getName().getGivenName() != null) {
					ret.add(new Contact(e.getName().getGivenName().getValue(), e.getId()));
				} else if (e.getName() != null && e.getName().getFamilyName() != null) {
					ret.add(new Contact(e.getName().getFamilyName().getValue(), e.getId()));
				} else if (e.getEmailAddresses() != null && e.getEmailAddresses().size() > 0) {
					ret.add(new Contact(e.getEmailAddresses().get(0).getAddress(), e.getId()));
				}
			}
			
			//sorting
			Collections.sort(ret, new Comparator<Contact>() {

				@Override
				public int compare(Contact o1, Contact o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			
			return ret;
		} catch (Exception e) {
			return null;
		}

	}

}
