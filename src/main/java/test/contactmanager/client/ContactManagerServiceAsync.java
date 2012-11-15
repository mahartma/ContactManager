package test.contactmanager.client;

import java.util.List;

import test.contactmanager.shared.Contact;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ContactManagerServiceAsync {
	void queryContacts(String name, String user, String password, AsyncCallback<List<Contact>> callback);
}
