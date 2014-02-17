/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.customization.palette.dialog;

import java.util.Arrays;

import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;

/**
 * Wizard page for information about the new local palette definition
 */
public class LocalPaletteInformationPage extends WizardPage implements Listener {

	/** array list of priorities */
	private static String[] priorityList;

	/** text area for the name of the palette definition */
	protected Text nameText;

	/** text area for the id of the palette definition */
	protected Text idText;

	/** text area for the editor id of the palette definition */
	protected Text editorText;

	/** combo for the priority of the provider */
	private Combo priorityCombo;

	/** parent composite for advanced fields */
	protected Composite advancedComposite;

	/** Button to show/hide advanced fields */
	protected Button advancedButton;

	/** editor part in which the palette is created */
	protected IEditorPart editorPart;

	/** priority value */
	protected ProviderPriority priority;

	/** editor ID value */
	protected String editorID;

	/** palette ID */
	protected String paletteID;

	/** palette name */
	protected String name;

	/** path to the icon */
	protected static final String WIZARD_ICON = "/icons/local_desc_wiz.png";

	/** validate on opening */
	protected boolean validateOnLaunch = false;

	static {
		priorityList = new String[]{ ProviderPriority.LOWEST.getName(), ProviderPriority.LOW.getName(), ProviderPriority.MEDIUM.getName(), ProviderPriority.HIGH.getName(), ProviderPriority.HIGHEST.getName() };
	}

	/**
	 * Creates a new wizard page with the given name, title, and image.
	 * 
	 * @param part
	 *        the editor part in which the wizard was created
	 */
	public LocalPaletteInformationPage(IEditorPart part) {
		super(Messages.Local_Palette_InfoPage_Name, Messages.Local_Palette_InfoPage_Title, Activator.getImageDescriptor(WIZARD_ICON));
		this.editorPart = part;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IWizardPage getNextPage() {
		LocalPaletteContentPage contentPage = (LocalPaletteContentPage)super.getNextPage();
		if(priority != null) {
			contentPage.setPriority(priority);
			contentPage.profileCombo.deselectAll();
			contentPage.profileCombo.select(contentPage.profileCombo.getItems().length - 1); // select the last one (UML)
		}
		return contentPage;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {

		// initialize dialog units
		initializeDialogUnits(parent);

		// Create a new composite as there is the title bar seperator
		// to deal with
		Composite control = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		control.setLayout(layout);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setControl(control);

		createNameControl(control);

		createAdvancedControls(control);

		// end of the control creation
		Dialog.applyDialogFont(control);

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		if(validateOnLaunch) {
			setPageComplete(validatePage());
		}
		setControl(control);
	}

	/**
	 * initializes fields using context information
	 */
	public void intializeValues() {
		initName("");
		String editorIDValue = "";
		if(editorPart instanceof DiagramEditorWithFlyOutPalette) {
			editorIDValue = ((DiagramEditorWithFlyOutPalette)editorPart).getContributorId();
		}
		initEditorID(editorIDValue);
		initPaletteID(System.getProperty("user.name") + "_" + System.currentTimeMillis());
		initPriority(ProviderPriority.MEDIUM);
	}

	/**
	 * initializes fields using existing descriptor
	 */
	public void intializeValues(PapyrusPaletteService.LocalProviderDescriptor descriptor) {
		initName(descriptor.getContributionName());
		String editorIDValue = "";
		if(editorPart instanceof DiagramEditorWithFlyOutPalette) {
			editorIDValue = ((DiagramEditorWithFlyOutPalette)editorPart).getContributorId();
		}
		initEditorID(editorIDValue);
		initPaletteID(descriptor.getContributionID());
		initPriority(PapyrusPalettePreferences.getLocalPalettePriority(descriptor.getContributionID()));
		validateOnLaunch = true;
	}

	/**
	 * Returns the current value of palette name
	 * 
	 * @return the current value of palette name
	 */
	public String getPaletteName() {
		return name;
	}

	/**
	 * Returns the current value of palette ID
	 * 
	 * @return the current value of palette ID
	 */
	public String getPaletteID() {
		return paletteID;
	}

	/**
	 * Returns the current value of editor ID
	 * 
	 * @return the current value of editor ID
	 */
	public String getEditorID() {
		return editorID;
	}

	/**
	 * Returns the current value of editor ID
	 * 
	 * @return the current value of editor ID
	 */
	public ProviderPriority getPalettePriority() {
		return priority;
	}

	/**
	 * inits the name field value
	 * 
	 * @param value
	 *        value to set
	 */
	protected void initName(String value) {
		name = value;
	}

	/**
	 * inits the priority value
	 * 
	 * @param value
	 *        value to set
	 */
	protected void initPriority(ProviderPriority value) {
		this.priority = value; // by default, Medium
	}

	/**
	 * inits the palette id value
	 * 
	 * @param value
	 *        value to set
	 */
	protected void initPaletteID(String value) {
		paletteID = value;

	}

	/**
	 * inits the editor id value
	 * 
	 * @param value
	 *        value to set
	 */
	protected void initEditorID(String value) {
		editorID = value;
	}

	/**
	 * Validates the content of the fields in this page
	 */
	protected boolean validatePage() {
		boolean valid = true;
		if(advancedComposite != null && !advancedComposite.isDisposed()) {
			if(-1 == priorityCombo.getSelectionIndex()) {
				setErrorMessage(Messages.Local_Palette_Error_Priority);
				valid = false;
			}
			if("".equals(getEditorID())) {
				setErrorMessage(Messages.Local_Palette_Error_EditorId);
				valid = false;
			}

			if("".equals(getPaletteID())) {
				setErrorMessage(Messages.Local_Palette_Error_PaletteId);
				valid = false;
			}
		}

		if("".equals(getPaletteName())) {
			setErrorMessage(Messages.Local_Palette_Error_Name);
			valid = false;
		}

		if(valid) {
			setMessage(null);
			setErrorMessage(null);
		}
		return valid;
	}

	/**
	 * Creates the widget for advanced options.
	 * 
	 * @param parent
	 *        the parent composite
	 */
	protected void createAdvancedControls(Composite parent) {
		advancedButton = new Button(parent, SWT.PUSH);
		advancedButton.setFont(parent.getFont());
		advancedButton.setText(Messages.Dialog_Advanced_Button_Closed);
		GridData data = setButtonLayoutData(advancedButton);
		data.horizontalAlignment = GridData.BEGINNING;
		data.horizontalSpan = 2;
		advancedButton.setLayoutData(data);
		advancedButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleAdvancedButtonSelect();
			}
		});
	}

	public Composite createAdvancedComposite(Composite parent) {
		advancedComposite = new Composite(parent, SWT.NONE);
		advancedComposite.setFont(parent.getFont());
		advancedComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		advancedComposite.setLayout(layout);

		createIDControl(advancedComposite);

		createEditorIDControl(advancedComposite);

		createPriorityControl(advancedComposite);

		advancedComposite.getParent().layout();
		return advancedComposite;
	}

	/**
	 * Shows/hides the advanced option widgets.
	 */
	protected void handleAdvancedButtonSelect() {
		Composite composite = (Composite)getControl();

		if(advancedComposite != null) {
			advancedComposite.dispose();
			advancedComposite = null;
			advancedButton.setText(Messages.Dialog_Advanced_Button_Closed);
		} else {
			createAdvancedComposite(composite);
			advancedButton.setText(Messages.Dialog_Advanced_Button_Opened);
		}
	}

	/**
	 * creates the control area for the priority
	 * 
	 * @param control
	 *        the parent composite
	 */
	protected void createPriorityControl(Composite control) {
		final Label priorityLabel = new Label(control, SWT.NONE);
		priorityLabel.setText(Messages.Local_Palette_Priority);
		priorityLabel.setToolTipText(Messages.Local_Palette_Priority_Tooltip);

		// choice widget among priority values
		priorityCombo = new Combo(control, SWT.READ_ONLY);
		priorityCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		priorityCombo.setToolTipText(Messages.Local_Palette_Priority_Tooltip);
		priorityCombo.setItems(priorityList);

		// initialize, then add the listener...
		initialPopulatePriorityField();

		priorityCombo.addListener(SWT.Modify, this);
	}

	/**
	 * intialize the field using current value of the palette id
	 */
	protected void initialPopulatePriorityField() {
		priorityCombo.select(Arrays.asList(priorityList).indexOf(priority.getName()));
	}

	/**
	 * creates the control area for the id definition
	 * 
	 * @param control
	 *        the parent composite
	 */
	protected void createIDControl(Composite control) {
		final Label idLabel = new Label(control, SWT.NONE);
		idLabel.setText(Messages.Local_Palette_Id);
		idLabel.setToolTipText(Messages.Local_Palette_Id_Tooltip);

		idText = new Text(control, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		idText.setToolTipText(Messages.Local_Palette_Id_Tooltip);

		// initialize, then add the listener...
		initialPopulatePaletteIDField();

		idText.addListener(SWT.Modify, this);
	}

	/**
	 * intialize the field using current value of the palette id
	 */
	protected void initialPopulatePaletteIDField() {
		idText.setText(paletteID);
	}

	/**
	 * creates the control area for the name definition
	 * 
	 * @param control
	 *        the parent composite
	 */
	protected void createNameControl(Composite control) {
		final Label nameLabel = new Label(control, SWT.NONE);
		nameLabel.setText(Messages.Local_Palette_Name);
		nameLabel.setToolTipText(Messages.Local_Palette_Name_Tooltip);

		nameText = new Text(control, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		nameText.setToolTipText(Messages.Local_Palette_Name_Tooltip);

		// initialize, then add the listener...
		initialPopulateNameField();

		nameText.addListener(SWT.Modify, this);

	}

	/**
	 * creates the control area for the name definition
	 * 
	 * @param control
	 *        the parent composite
	 */
	protected void createEditorIDControl(Composite control) {
		final Label editorLabel = new Label(control, SWT.NONE);
		editorLabel.setText(Messages.Local_Palette_Editor_Id);
		editorLabel.setToolTipText(Messages.Local_Palette_Editor_Id_Tooltip);

		editorText = new Text(control, SWT.BORDER);
		editorText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		editorText.setToolTipText(Messages.Local_Palette_Editor_Id_Tooltip);

		// initialize, then add the listener...
		initialPopulateEditorIDField();

		editorText.addListener(SWT.Modify, this);
		// this editor should propose a list of existing editors = looking in the extension point?
	}

	/**
	 * intialize the field using current value of the editor id
	 */
	protected void initialPopulateEditorIDField() {
		editorText.setText(editorID);
	}

	/**
	 * initialize name field
	 */
	protected void initialPopulateNameField() {
		nameText.setText(name);
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this <code>Listener</code> method handles all events and enablements for controls
	 * on this page. Subclasses may extend.
	 */
	public void handleEvent(Event event) {
		Widget widget = event.widget;
		if(widget.equals(nameText)) {
			name = nameText.getText();
		} else if(widget.equals(idText)) {
			paletteID = idText.getText();
		} else if(widget.equals(editorText)) {
			editorID = editorText.getText();
		} else if(widget.equals(priorityCombo)) {
			priority = ProviderPriority.parse(priorityCombo.getText());
		}
		setPageComplete(validatePage());
	}

}
