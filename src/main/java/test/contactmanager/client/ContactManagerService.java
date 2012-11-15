package test.contactmanager.client;

import java.util.List;

import test.contactmanager.shared.Contact;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("contactManagerService")
public interface ContactManagerService extends RemoteService {
	List<Contact> queryContacts(String name, String user, String password);
}
