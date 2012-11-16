package test.contactmanager.server;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import test.contactmanager.shared.Contact;

import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.extensions.FullName;
import com.google.gdata.data.extensions.Name;


public class ContactManagerServiceImplTest {

	@InjectMocks
	private ContactManagerServiceImpl service = new ContactManagerServiceImpl();
	
	@Mock
	private ContactsService contactsServiceMock;

	@Mock
	private ContactFeed feedMock;

	@Mock
	private ContactEntry entryMock;

	@Mock
	private Name nameMock;

	@Mock
	private FullName fullNameMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * test for {@link ContactManagerServiceImpl#queryContacts(String, String, String)}
	 * 
	 * @throws Exception
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnContacts() throws Exception {
		//Given
		given(contactsServiceMock.query(any(Query.class), any(Class.class))).willReturn(feedMock);
		List<ContactEntry> result = new ArrayList<ContactEntry>();
		result.add(entryMock);
		given(feedMock.getEntries()).willReturn(result);
		given(entryMock.getId()).willReturn("4711");
		given(entryMock.getName()).willReturn(nameMock);
		given(nameMock.getFullName()).willReturn(fullNameMock);
		given(fullNameMock.getValue()).willReturn("Mustermann");
		//When
		List<Contact> queryContacts = service.queryContacts("test", "test", "4711");
		//Then
		assertThat(queryContacts.size(), CoreMatchers.is(1));
	}
	
}
