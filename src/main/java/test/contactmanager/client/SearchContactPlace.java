package test.contactmanager.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SearchContactPlace extends Place {

    public SearchContactPlace(String token) {
		super();
	}

	public static class Tokenizer implements PlaceTokenizer<SearchContactPlace> {
        @Override
        public String getToken(SearchContactPlace place) {
            return "search";
        }

        @Override
        public SearchContactPlace getPlace(String token) {
            return new SearchContactPlace(token);
        }
    }

}
