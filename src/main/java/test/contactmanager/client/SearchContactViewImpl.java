package test.contactmanager.client;

import test.contactmanager.shared.Contact;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class SearchContactViewImpl extends Composite implements
		SearchContactView {

	private static SearchContactViewImplUiBinder uiBinder = GWT
			.create(SearchContactViewImplUiBinder.class);
	
	interface SearchContactViewImplUiBinder extends
			UiBinder<HTMLPanel, SearchContactViewImpl> {
	}

	private Presenter presenter;

	@UiField
	TextBox nameInput;

	@UiField
	TextBox userInput;
	
	@UiField
	TextBox passwordInput;
	
	@UiField(provided = true)
	DataGrid<Contact> dataGrid;

	@UiField(provided = true)
	SimplePager pager;

	public SearchContactViewImpl() {
		super();

		dataGrid = new DataGrid<Contact>(Contact.KEY_PROVIDER);
		dataGrid.setWidth("700px");
		dataGrid.setHeight("400px");
		dataGrid.setVisible(true);
		dataGrid.setPageSize(50);
		dataGrid.setAutoHeaderRefreshDisabled(true);
		dataGrid.setEmptyTableWidget(new Label("kein Treffer"));

		//ID.
		Column<Contact, String> idColumn = new Column<Contact, String>(
				new EditTextCell()) {
			@Override
			public String getValue(Contact object) {
				return object.getId().toString();
			}
		};
		idColumn.setSortable(true);
		dataGrid.addColumn(idColumn, "ID");
		
		//Name.
		Column<Contact, String> nameColumn = new Column<Contact, String>(
				new EditTextCell()) {
			@Override
			public String getValue(Contact object) {
				return object.getName();
			}
		};
		nameColumn.setSortable(true);
		dataGrid.addColumn(nameColumn, "Name");
		
		
		//Pager
		SimplePager.Resources pagerResources = GWT
				.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0,
				true);
		pager.setDisplay(dataGrid);
		pager.setVisible(false);

		// Add a selection model so we can select cells.
		final SelectionModel<Contact> selectionModel = new MultiSelectionModel<Contact>(
				Contact.KEY_PROVIDER);
		dataGrid.setSelectionModel(selectionModel,
				DefaultSelectionEventManager.<Contact> createCheckboxManager());
		
		//init all widgets
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("searchButton")
	void onSearch(ClickEvent e) {
		presenter.onSearch(nameInput.getValue(), userInput.getValue(), passwordInput.getValue());
		pager.setVisible(true);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasData<Contact> getDataDisplay() {
		return dataGrid;
	}
}
