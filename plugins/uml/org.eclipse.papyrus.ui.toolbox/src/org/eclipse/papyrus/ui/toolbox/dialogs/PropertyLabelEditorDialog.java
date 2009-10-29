/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.parsers.modelgenerator.PropertyGenerator;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.PropertyLabelSourceViewerConfiguration;
import org.eclipse.papyrus.ui.toolbox.LookForElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 */
// @unused
public class PropertyLabelEditorDialog extends LabelEditorDialog {

	/**
	 * 
	 */
	final private static String TITLE = "Property";

	final public static int CREATE_BUTTON_ID = 3;

	// state variables to define the behavior associated to the
	// "press create button" event
	final private int TYPE_CREATION = 0;

	final private int BINDING_DEFINITION = 1;

	private int CREATION_MODE = TYPE_CREATION;

	// final private static String MESSAGE = "enter Property name";

	/**
	 * 
	 */
	private final Property property;

	/**
	 * The list contains the types that are dynamically created (through the create button) For a
	 * given "dialog session", if the user the cancel button, all the types contained in the list
	 * are deleted.
	 */
	private final List<Type> dynamicallyCreatedTypes;

	/**
	 * 
	 */
	private Document propertyLabelDocument;

	/**
	 * 
	 */
	private final String initialValue;

	/**
	 * // * //
	 */
	private Menu menu;

	//	
	/**
	 * 
	 */
	private List<MenuItem> menuItems;

	/**
	 * 
	 */
	private List<SelectionListener> selectionListeners;

	/**
	 * 
	 */
	private Button createButton;

	/**
	 * 
	 */

	/**
	 * 
	 * 
	 * @param parentShell
	 * @param property
	 * @param initialValue
	 */
	// @unused
	public PropertyLabelEditorDialog(Shell parentShell, Property property, String initialValue) {
		super(parentShell, TITLE, initialValue, new PropertyLabelValidator(property));
		this.property = property;
		this.value = initialValue;
		this.initialValue = initialValue; // used in case of cancel
		this.dynamicallyCreatedTypes = new ArrayList<Type>();
	}

	/*
	 * (non-Javadoc) Method declared on Dialog.
	 */
	/**
	 * 
	 * 
	 * @param buttonId
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == CREATE_BUTTON_ID) {
			value = viewer.getDocument().get();
			createPressed();
		} else if (buttonId == IDialogConstants.CANCEL_ID) {
			value = initialValue;
			final PropertyGenerator generator = new PropertyGenerator(property);
			// command
			RecordingCommand rc = new RecordingCommand(LookForElement.getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {
					generator.parseAndModifyProperty(initialValue);
				}
			};
			LookForElement.getTransactionalEditingDomain().getCommandStack().execute(rc);
			// all the types that have been created during the dialog session
			// are deleted
			for (Type t : dynamicallyCreatedTypes) {
				((org.eclipse.uml2.uml.Package) t.getOwner()).getPackagedElements().remove(t);
				t.setPackage(null);
			}
			super.buttonPressed(buttonId);
		} else {
			super.buttonPressed(buttonId);
		}
	}

	protected void createPressed() {
		// add an additional menu to the add Button
		if (CREATION_MODE == TYPE_CREATION) {
			createMenuForCreateButton();
			menu.setVisible(true);
		} else { // CREATION_MODE == BINDING_DEFINITION
			PropertyGenerator generator = new PropertyGenerator(property);
			TemplateableElement template = generator.parseUnboundPropertyType(getValue());
			// Creation of the dialog box only if all the parameters are
			// ClassifierTemplateParameters
		}
	}

	/**
	 * Adds an additional menu to the addButton. So user can choose which element to create
	 */
	private void createMenuForCreateButton() {
		menu = new Menu(createButton);
		menu.setEnabled(false);
		menuItems = new ArrayList<MenuItem>();
		selectionListeners = new ArrayList<SelectionListener>();
		// add an item for each metaclass that comply with the Type metaclass
		List concreteTypeMetaclasses = LookForElement.getMetaclasses(UMLPackage.eINSTANCE.getType(), false, property);
		for (Iterator i = concreteTypeMetaclasses.iterator(); i.hasNext();) {
			org.eclipse.uml2.uml.Type currentType = (org.eclipse.uml2.uml.Type) i.next();
			menu.setEnabled(true);
			menuItems.add(new MenuItem(menu, SWT.PUSH));
			MenuItem item = menuItems.get(menuItems.size() - 1);
			item.setText(currentType.getName());
			try {
				menuItems.get(menuItems.size() - 1).addSelectionListener(
						new CreateElementSelectionListener(Class.forName("org.eclipse.uml2.uml."
								+ currentType.getName())));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.utils.dialog.LabelEditorDialog#createDialogArea(
	 * org.eclipse.swt.widgets .Composite)
	 */
	/**
	 * 
	 * 
	 * @param parent
	 * 
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Group composite = new Group(parent, SWT.RESIZE);
		composite.setText("Specification");
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		createButton = createButton(parent, CREATE_BUTTON_ID, "create Type", true);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite viewerGroup = new Composite(composite, SWT.RESIZE);
		FillLayout viewerLayout = new FillLayout();
		viewerGroup.setLayout(viewerLayout);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL
				| GridData.VERTICAL_ALIGN_CENTER);
		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		viewerGroup.setLayoutData(data);
		viewer = new SourceViewer(viewerGroup, null, SWT.BORDER | SWT.FILL_EVEN_ODD);

		// configure source viewer
		propertyLabelDocument = new Document();
		propertyLabelDocument.set(value);

		// add completion processor key listener (ctrl+space keys)
		viewer.appendVerifyKeyListener(new PropertyLabelKeyListener(viewer));

		propertyLabelDocument.addDocumentListener(new DocumentListener());

		viewer.configure(new PropertyLabelSourceViewerConfiguration(property));
		viewer.setDocument(propertyLabelDocument);

		viewer.setSelectedRange(0, value.length());
		errorMessageText = new Text(composite, SWT.READ_ONLY);
		errorMessageText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		errorMessageText.setBackground(errorMessageText.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		// Set the error message text
		// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=66292
		setErrorMessage(errorMessage);

		applyDialogFont(composite);
		return composite;
	}

	/**
	 * Sets or clears the error message. If not <code>null</code>, the OK button is disabled.
	 * 
	 * @param errorMessage
	 *            the error message, or <code>null</code> to clear
	 * 
	 * @since 3.0
	 */
	@Override
	public void setErrorMessage(String errorMessage) {
		// this.errorMessage = errorMessage;
		// if ((errorMessageText != null) && !errorMessageText.isDisposed()) {
		//    		errorMessageText.setText(errorMessage == null ? "" : errorMessage); //$NON-NLS-1$
		// errorMessageText.getParent().update();
		// // Access the ok button by id, in case clients have overridden button
		// creation.
		// // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=113643
		// Control button = getButton(IDialogConstants.OK_ID);
		// if (button != null) {
		// button.setEnabled(errorMessage == null);
		// }
		// }
		super.setErrorMessage(errorMessage);
		Control button = getButton(CREATE_BUTTON_ID);
		if (button != null) {
			if (errorMessage == null) {
				button.setEnabled(false);
			} else if (errorMessage.startsWith("Type")) {
				button.setEnabled(true);
				CREATION_MODE = TYPE_CREATION;
			} else if (errorMessage.startsWith("Parameters")) {
				button.setEnabled(true);
				CREATION_MODE = BINDING_DEFINITION;
			} else {
				button.setEnabled(false);
			}
		}
	}

	/**
	 * 
	 */
	private class PropertyLabelKeyListener implements VerifyKeyListener {

		/**
		 * 
		 */
		SourceViewer viewer;

		/**
		 * Default constructor.
		 * 
		 * @param viewer
		 */
		public PropertyLabelKeyListener(SourceViewer viewer) {
			this.viewer = viewer;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt
		 * .events.VerifyEvent)
		 */
		/**
		 * 
		 * 
		 * @param event
		 */
		public void verifyKey(VerifyEvent event) {
			if ((event.stateMask == SWT.CTRL) && (event.character == ' ')) {
				if (viewer.canDoOperation(ISourceViewer.CONTENTASSIST_PROPOSALS)) {
					viewer.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
				}
				event.doit = false;
			} else if (event.character == SWT.CR) {
				event.doit = false;
			}
		}
	}

	/**
	 * 
	 */
	private class DocumentListener implements IDocumentListener {

		/**
		 * 
		 * 
		 * @param event
		 */
		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		/**
		 * 
		 * 
		 * @param event
		 */
		public void documentChanged(DocumentEvent event) {
			validateInput();
		}

	}

	/**
	 * Listener for the menu items.
	 */
	public class CreateElementSelectionListener implements SelectionListener {

		/**
		 * 
		 */
		public Class concreteTypeMetaclass;

		public CreateElementSelectionListener(Class concreteTypeMetaclass) {
			this.concreteTypeMetaclass = concreteTypeMetaclass;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org
		 * .eclipse.swt.events .SelectionEvent)
		 */
		/**
		 * 
		 * 
		 * @param e
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
		 * .swt.events.SelectionEvent )
		 */
		/**
		 * 
		 * 
		 * @param e
		 */
		public void widgetSelected(SelectionEvent e) {
			setReturnCode(CREATE_BUTTON_ID);
			final int[] result = { IDialogConstants.CANCEL_ID };
			// Retrieves the name of the type to be created
			PropertyGenerator generator = new PropertyGenerator(property);
			String typeName = generator.parseUndefinedPropertyType(getValue()); // the
			// name
			// of
			// the
			// type to be
			// created

			// Creation of the dialog box
			/*
			 * final NamespaceTreeSelectionDialog dialog = new
			 * NamespaceTreeSelectionDialog(getShell(), LookForElement.topPackage(property),
			 * typeName, concreteTypeMetaclass.getSimpleName());
			 * 
			 * if (typeName != null) {
			 * 
			 * // open dialog window BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			 * public void run() { result[0] = dialog.open(); } });
			 * 
			 * // if ok was pressed, and a package was selected // A type T with name = typeName
			 * will be created in the package // the type of the property will be set to T
			 * if(IDialogConstants.OK_ID == result[0]){ org.eclipse.uml2.uml.Package selectedPackage
			 * = dialog.getResult(); if(selectedPackage!= null){ // com.cea.utils.Package
			 * utilPackage = new com.cea.utils.Package(selectedPackage) ; // com.cea.utils.Class
			 * createdType = utilPackage.createOwnedClass(typeName, VisibilityKind.PUBLIC) ; //
			 * property.setType(createdType.getUml2Class()) ; UMLElementCreateCommand command ;
			 * CommandStack stack = LookForElement.getCommandStack(); TransactionalEditingDomain
			 * domain= LookForElement.getTransactionalEditingDomain(); command = new
			 * UMLElementCreateCommand(domain,concreteTypeMetaclass, selectedPackage) ;
			 * Assert.isNotNull(stack, "Impossible to adapt current editor into a CommandStack");
			 * stack.execute(new EMFTtoGEFWrapCommand(domain,command));
			 * ((Type)command.getElement()).setName(typeName) ;
			 * property.setType((Type)command.getElement()) ;
			 * dynamicallyCreatedTypes.add((Type)command.getElement()) ; } }
			 * 
			 * // update display of property and error message propertyLabelDocument.set(new
			 * com.cea.papyrus.umlutils.Property(property).getLabel()) ; value = new
			 * com.cea.papyrus.umlutils.Property(property).getLabel() ; String errorMessage ;
			 * errorMessage = generator.parseAndValidateProperty(getValue()) ;
			 * setErrorMessage(errorMessage) ; }
			 */
		}
	}

}
