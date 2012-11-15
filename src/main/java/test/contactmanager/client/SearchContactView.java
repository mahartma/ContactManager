package test.contactmanager.client;

import test.contactmanager.shared.Contact;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;

public interface SearchContactView extends IsWidget {

	void setPresenter(Presenter presenter);

	HasData<Contact> getDataDisplay();	
    
	public interface Presenter {
        void goTo(Place place);

		void onSearch(String name, String user, String password);
    }
    
}
