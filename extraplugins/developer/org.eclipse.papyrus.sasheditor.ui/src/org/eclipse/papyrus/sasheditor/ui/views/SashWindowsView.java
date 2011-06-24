/**
 * 
 */
package org.eclipse.papyrus.sasheditor.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;


/**
 * An View (from MVC) used to render data from the SashWindows.
 * This view is implemented with SWT.
 * 
 * @author cedric dumoulin
 */
public class SashWindowsView {

	private FormToolkit toolkit;

	private ScrolledForm form;

	private Text selectedElement;

	private Text selectedPage;

	private Text selectedPageName;

	private Text selectedFolder;

	private Text selectedIEditor;

	private Text selectedIEditorName;

	private final String TITLE = "SashWindows";

	/**
	 * Create associated part control.
	 * 
	 * @param parent
	 */
	public void createPartControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.setText(TITLE);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		form.getBody().setLayout(layout);

		//
		selectedElement = createInputText("Selected Element:", "");
		selectedPage = createInputText("selected Page:", "");
		selectedPageName = createInputText("  page name:", "");
		selectedFolder = createInputText("selected Folder:", "");
		selectedIEditor = createInputText("selected IEditor:", "");
		selectedIEditorName = createInputText("  editor name:", "");

	}

	/**
	 * Create a Text with a label and an initial value.
	 * 
	 * @param labelValue
	 * @param textValue
	 * @return
	 */
	private Text createInputText(String labelValue, String textValue) {
		Text text;
		GridData gd = new GridData();
		Label label = toolkit.createLabel(form.getBody(), labelValue);
		label.setLayoutData(gd);
		text = toolkit.createText(form.getBody(), textValue, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return text;
	}

	public void setselectedElement(String newText) {
		selectedElement.setText(newText);
	}

	public void setSelectedPage(String newText) {
		selectedPage.setText(newText);
	}

	public void setSelectedPageName(String newText) {
		selectedPageName.setText(newText);
	}

	public void setSelectedFolder(String newText) {
		selectedFolder.setText(newText);
	}

	public void setSelectedIEditor(String newText) {
		selectedIEditor.setText(newText);
	}

	public void setSelectedIEditorName(String newText) {
		selectedIEditorName.setText(newText);
	}


	/**
	 * Dispose all resources
	 */
	public void dispose() {
		toolkit.dispose();
	}

	/**
	 * Set focus to this element.
	 */
	public void setFocus() {
		form.setFocus();
	}

}
