package test.contactmanager.client;



import java.util.List;

import test.contactmanager.shared.Contact;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;

public class SearchContactActivity implements Activity, SearchContactView.Presenter {

	private ContactManagerGinjector ginjector = GWT.create(ContactManagerGinjector.class);
	private SearchContactView searchView;
	private ListDataProvider<Contact> listDataProvider;
	
	public SearchContactActivity(SearchContactPlace place) {
	}

	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() {
	}

	@Override
	public void onStop() {
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		searchView = ginjector.getSearchView();
		listDataProvider = new ListDataProvider<Contact>();
		listDataProvider.addDataDisplay(searchView.getDataDisplay());
		searchView.setPresenter(this);
        containerWidget.setWidget(searchView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		ginjector.getPlaceController().goTo(place);
	}

	@Override
	public void onSearch(String name, String user, String password) {
		ginjector.getContactManagerService().queryContacts(name, user, password, new AsyncCallback<List<Contact>>() {
			
			@Override
			public void onSuccess(List<Contact> result) {
				listDataProvider.getList().clear();
				listDataProvider.getList().addAll(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}

}
