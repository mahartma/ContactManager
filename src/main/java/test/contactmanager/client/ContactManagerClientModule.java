package test.contactmanager.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;


public class ContactManagerClientModule extends AbstractGinModule {
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(SearchContactView.class).to(SearchContactViewImpl.class).in(Singleton.class);
  }
  
  @Provides
  @Singleton
  public PlaceController getPlaceController(EventBus eventBus) {
    return new PlaceController(eventBus);
  }

  @Provides
  @Singleton
  public ContactManagerServiceAsync getContactManagerService() {
	  return GWT.create(ContactManagerService.class);
  }

}