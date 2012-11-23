package test.contactmanager.shared;

import java.io.Serializable;

import com.google.gwt.view.client.ProvidesKey;

/**
 * 
 * @author max.hartmann
 *
 */
public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	/**
	 * The key provider that provides the unique ID of a contact.
	 */
	public static final ProvidesKey<Contact> KEY_PROVIDER = new ProvidesKey<Contact>() {
		@Override
		public Object getKey(Contact item) {
			return item == null ? null : item.getId();
		}
	};

	public Contact() {
	}
	
	public Contact(String string, String id) {
		name = string;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
