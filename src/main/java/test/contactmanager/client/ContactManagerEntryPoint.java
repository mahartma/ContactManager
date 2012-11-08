package test.contactmanager.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * this starts the gwt-application
 * 
 * @author max.hartmann
 *
 */
public class ContactManagerEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get().add(new Label("Hello Contact-Manager"));
	}

}
