package test.contactmanager.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public class AppActivityMapper implements ActivityMapper {

    public AppActivityMapper() {
        super();
    }

    @Override
    public Activity getActivity(Place place) {
    	if (place instanceof SearchContactPlace) {
    		return new SearchContactActivity((SearchContactPlace) place);
    	}
        return null;
    }
}