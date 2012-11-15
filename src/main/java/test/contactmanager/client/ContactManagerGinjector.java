package test.contactmanager.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

@GinModules(ContactManagerClientModule.class)
public interface ContactManagerGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceController getPlaceController();

	SearchContactView getSearchView();
	
	ContactManagerServiceAsync getContactManagerService();

}