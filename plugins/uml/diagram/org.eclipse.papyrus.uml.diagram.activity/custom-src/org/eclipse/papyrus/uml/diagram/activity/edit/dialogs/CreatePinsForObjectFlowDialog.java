/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.dialogs;

import org.eclipse.papyrus.uml.diagram.activity.helper.CustomObjectFlowEditHelper;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.ui.helper.HelpComponentFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class provides a dialog to initialize a CallBehaviorAction at its
 * creation.
 */
public class CreatePinsForObjectFlowDialog extends FormDialog {

	private static final String TITLE = CustomMessages.CreatePinsForObjectFlowDialog_Title;

	private static final String PIN_CREATION_SECTION_TITLE = CustomMessages.CreatePinsForObjectFlowDialog_PinCreationTitle;

	private static final String NAME_LABEL = CustomMessages.CreatePinsForObjectFlowDialog_Name;

	private static final String TYPE_LABEL = CustomMessages.CreatePinsForObjectFlowDialog_Type;

	/** The initial value for pins name */
	private static final String NAME_INITIAL_VALUE = "data";

	/** The user chosen source node */
	private ActivityNode initialSource = null;

	/** The user chosen target node */
	private ActivityNode initialTarget = null;

	/** The object to use as object flow source */
	private ActivityNode newSource = null;

	/** The object to use as object flow target */
	private ActivityNode newTarget = null;

	private Text creationNameText = null;

	private String creationName = NAME_INITIAL_VALUE;

	private Text creationTypeText = null;

	private Button creationTypeButton = null;

	private Type creationType = null;

	/**
	 * Create a new dialog to initialize a CallBehaviorAction.
	 * 
	 * @param shell
	 *        parent shell
	 * @param source
	 *        the chosen source of the object flow
	 * @param target
	 *        the chosen target of the object flow
	 */
	public CreatePinsForObjectFlowDialog(Shell shell, ActivityNode source, ActivityNode target) {
		super(shell);
		initialSource = source;
		initialTarget = target;
	}

	@Override
	public int open() {
		if(CustomObjectFlowEditHelper.insertPinForStartingNewObjectFlow(initialSource) && CustomObjectFlowEditHelper.insertPinForEndingNewObjectFlow(initialTarget)) {
			// create an object flow between actions : both pins must be created
			return super.open();
		} else {
			boolean needInformation = false;
			// use correct extremities or configure new one
			if(CustomObjectFlowEditHelper.insertPinForStartingNewObjectFlow(initialSource)) {
				newSource = createSource((Action)initialSource, initialTarget);
				if(newSource == null) {
					// ask for missing information
					needInformation = true;
				}
			} else {
				newSource = initialSource;
			}
			if(CustomObjectFlowEditHelper.insertPinForEndingNewObjectFlow(initialTarget)) {
				newTarget = createTarget((Action)initialTarget, initialSource);
				if(newTarget == null) {
					// ask for missing information
					needInformation = true;
				}
			} else {
				newTarget = initialTarget;
			}
			if(needInformation) {
				return super.open();
			}
			return OK;
		}
	}

	/**
	 * Create a pin to use as target if all information is available
	 * 
	 * @param parentAction
	 *        the action containing the pin
	 * @param objectFlowSource
	 *        the source of the object flow
	 * @return the created pin or null if information is missing
	 */
	private InputPin createTarget(Action parentAction, ActivityNode objectFlowSource) {
		if(objectFlowSource instanceof Pin) {
			return createInputPin(parentAction, objectFlowSource.getName(), ((Pin)objectFlowSource).getType());
		} else {
			// Source is not a pin, probably a control node. Ask for information
			return null;
		}
	}

	/**
	 * Create a pin to use as source if all information is available
	 * 
	 * @param parentAction
	 *        the action containing the pin
	 * @param objectFlowTarget
	 *        the target of the object flow
	 * @return the created pin or null if information is missing
	 */
	private OutputPin createSource(Action parentAction, ActivityNode objectFlowTarget) {
		if(objectFlowTarget instanceof Pin) {
			return createOutputPin(parentAction, objectFlowTarget.getName(), ((Pin)objectFlowTarget).getType());
		} else {
			// Source is not a pin, probably a control node. Ask for information
			return null;
		}
	}

	/**
	 * Create an input pin
	 * 
	 * @param parentAction
	 *        the action containing this pin
	 * @param name
	 *        pin name
	 * @param type
	 *        pin type
	 * @return created pin
	 */
	private InputPin createInputPin(Action parentAction, String name, Type type) {
		InputPin result = UMLFactory.eINSTANCE.createInputPin();
		result.setName(name);
		result.setType(type);
		CustomObjectFlowEditHelper.insertInputPin(parentAction, result);
		return result;
	}

	/**
	 * Create an output pin
	 * 
	 * @param parentAction
	 *        the action containing this pin
	 * @param name
	 *        pin name
	 * @param type
	 *        pin type
	 * @return created pin
	 */
	private OutputPin createOutputPin(Action parentAction, String name, Type type) {
		OutputPin result = UMLFactory.eINSTANCE.createOutputPin();
		result.setName(name);
		result.setType(type);
		CustomObjectFlowEditHelper.insertOutputPin(parentAction, result);
		return result;
	}

	/**
	 * Create the form to :
	 * 
	 * - ask the user the name of pins to create.
	 * 
	 * - ask the user the type of pins to create.
	 * 
	 * @see org.eclipse.ui.forms.FormDialog#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm pForm) {
		pForm.getForm().setText(TITLE);
		ScrolledForm scrolledForm = pForm.getForm();
		FormToolkit toolkit = pForm.getToolkit();
		Composite parent = scrolledForm.getBody();
		parent.setLayout(new GridLayout());
		createPinCreationSection(scrolledForm.getBody(), toolkit);
		hookListeners();
		scrolledForm.reflow(true);
	}

	/**
	 * Create the section to ask the user to parameterize the pin.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createPinCreationSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = PIN_CREATION_SECTION_TITLE;
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}
		ImageHyperlink componentHelp = HelpComponentFactory.createHelpComponent(lSection, pToolkit, CustomMessages.CreatePinsForObjectFlowDialog_PinCreationHelp, true);
		lSection.setTextClient(componentHelp);
		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();
		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 3;
		lBody.setLayout(lLayout);
		// content of the section
		pToolkit.createLabel(lBody, NAME_LABEL, SWT.NONE);
		creationNameText = pToolkit.createText(lBody, NAME_INITIAL_VALUE, SWT.BORDER);
		creationNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		creationNameText.setFocus();
		pToolkit.createLabel(lBody, TYPE_LABEL, SWT.NONE);
		creationTypeText = pToolkit.createText(lBody, "", SWT.BORDER | SWT.READ_ONLY);
		creationTypeText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		creationTypeButton = pToolkit.createButton(lBody, "...", SWT.FLAT);
		Image image = UMLElementTypes.getImage(UMLPackage.eINSTANCE.getClass_());
		creationTypeButton.setImage(image);
		creationTypeButton.setLayoutData(new GridData(SWT.NONE));
		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Add listeners to widgets
	 */
	private void hookListeners() {
		// listener to new pin name
		ModifyListener lNameListener = new ModifyListener() {

			/**
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				creationName = creationNameText.getText();
			}
		};
		creationNameText.addModifyListener(lNameListener);
		// listener to select new pin type
		SelectionListener selectTypeBtnListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleChooseType();
			}
		};
		creationTypeButton.addSelectionListener(selectTypeBtnListener);
	}

	/**
	 * Open the dialog to choose the type of the pin(s) to create
	 * 
	 */
	private void handleChooseType() {
		/*
		 * TODO Backport
		 */
		//		UMLMultiEClassifierTreeSelectorDialog dialog = new UMLMultiEClassifierTreeSelectorDialog(getShell(),initialSource, Sets.newHashSet(UMLPackage.Literals.TYPE));
		//		dialog.setMessage(CustomMessages.UMLModelingAssistantProviderMessage);
		//		dialog.setTitle(CustomMessages.UMLModelingAssistantProviderTitle);
		//		if(dialog.open() == Window.OK) {
		//			creationType = (Type)dialog.getTheResult();
		//			creationTypeText.setText(dialog.getText(creationType));
		//		}
	}

	/**
	 * Set correctly the invoked object, by creating it if needed. Then,
	 * notifies that the ok button of this dialog has been pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		// create pins if needed
		if(newSource == null) {
			newSource = createOutputPin((OpaqueAction)initialSource, creationName, creationType);
		}
		if(newTarget == null) {
			newTarget = createInputPin((OpaqueAction)initialTarget, creationName, creationType);
		}
		super.okPressed();
	}

	/**
	 * Get the node to use as object flow source
	 * 
	 * @return new source
	 */
	public ActivityNode getSource() {
		return newSource;
	}

	/**
	 * Get the node to use as object flow target
	 * 
	 * @return new target
	 */
	public ActivityNode getTarget() {
		return newTarget;
	}
}
