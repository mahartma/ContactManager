package test.contactmanager.client;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;


public class ContactManagerEntryPointTest extends GWTTestCase {

	private ContactManagerEntryPoint entryPoint = new ContactManagerEntryPoint();
	
	
	@Test
	public void testCreateLabel() {
		entryPoint.onModuleLoad();
	}


	@Override
	public String getModuleName() {
		return "test.contactmanager.ContactManager";
	}
	
}
