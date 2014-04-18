/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ProjectCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.messages.Messages;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.plugin.AbstractUIPlugin;



/**
 * Preference page to associate set of style sheets to Papyrus project.
 * <p>
 * The preference is stored in a file with EMF format. The target is file .settings/stylesheets.xmi
 * </p>
 *
 * @author gpascual
 */
public class StyleSheetsPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {


	/** Text for preference page label. */
	private static final String PREFERENCE_PAGE_LABEL = Messages.getString("StyleSheetsPropertyPage.preference.page.label"); //$NON-NLS-1$

	/** Text for preference page title. */
	private static final String PREFERENCE_PAGE_TITLE = Messages.getString("StyleSheetsPropertyPage.preference.page.title"); //$NON-NLS-1$

	/** Icon for delete button. */
	private static final Image DELETE_ICON = Activator.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "/icons/Delete_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for add button. */
	private static final Image ADD_ICON = Activator.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "/icons/Add_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for edit button. */
	private static final Image EDIT_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Edit_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for up action button. */
	private static final Image UP_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Up_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for down action button. */
	private static final Image DOWN_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Down_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Id for add button. */
	private static final int ADD_BUTTON_ID = 1;

	/** Id for delete button. */
	private static final int DELETE_BUTTON_ID = 2;

	/** Id for up button. */
	private static final int UP_BUTTON_ID = 3;

	/** Id for down button. */
	private static final int DOWN_BUTTON_ID = 4;

	/** Id for edit button. */
	private static final int EDIT_BUTTON_ID = 0;

	/** Preference resource of project to load and save. */
	private Resource resource = null;

	/** Style sheets model used to manage style sheets list as container. */
	private ModelStyleSheets modelStyleSheets = null;

	/** Content provider which used for different displays. */
	private IContentProvider contentProvider = null;

	/** Label provider which used for different displays. */
	private ILabelProvider labelProvider = null;

	/** Viewer for style sheets list. */
	private TreeViewer styleSheetsViewer = null;

	/** Map of all buttons of property page. */
	private Map<Integer, Button> buttonsMap = new HashMap<Integer, Button>();

	/** Editor factory to edit Style sheets */
	private ReferenceValueFactory editorFactory = new EcorePropertyEditorFactory(StylesheetsPackage.Literals.MODEL_STYLE_SHEETS__STYLESHEETS);

	/**
	 * Default Constructor.
	 *
	 */
	public StyleSheetsPropertyPage() {
		//This preference is stored with EMF format : .settings/stylesheets.xmi
		setPreferenceStore(null);
		noDefaultAndApplyButton();
	}


	/**
	 * Get Style sheets model file to manage preference.
	 * 
	 * @return a new style sheets list or the existing one
	 */
	private EList<EObject> getProjectStylesheets() {
		//Get selected project
		Object pageElement = getElement().getAdapter(IProject.class);

		//Initialize preferences data
		ResourceSet resourceSet = new ResourceSetImpl();
		EList<EObject> styleSheetsList = null;

		//Check if element is a project
		if(pageElement instanceof IProject) {
			// Build path of preference file
			ProjectScope pageProject = new ProjectScope((IProject)pageElement);
			IPath preferencePath = pageProject.getLocation().append(ProjectCSSEngine.PROJECT_STYLESHEETS);

			// Check path is valid
			if(preferencePath != null) {

				// Verify presence of file in project
				IPath projectRelativePath = preferencePath.makeRelativeTo(((IProject)pageElement).getLocation());
				IFile preferenceFile = ((IProject)pageElement).getFile(projectRelativePath);
				if(preferenceFile.exists()) {

					//Load existing preference file
					resource = resourceSet.getResource(URI.createPlatformResourceURI(preferenceFile.getFullPath().toOSString(), true), true);
					styleSheetsList = resource.getContents();


				} else {

					//Create default preference file
					resource = resourceSet.createResource(URI.createPlatformResourceURI(preferenceFile.getFullPath().toOSString(), true));
					styleSheetsList = resource.getContents();
				}
			}
		}

		return styleSheetsList;
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createContents(Composite parent) {

		// Create the container composite
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout containerLayout = new GridLayout(2, false);
		container.setLayout(containerLayout);

		// Initialize data and providers for page
		initializeDataPage();
		initializeProviders();

		// Create different components
		createLabelPage(container);
		createStyleSheetsPageViewer(container);
		createStyleSheetsPageButtons(container);

		//Update state buttons
		updateButtons();

		return container;
	}




	/**
	 * Create label for page.
	 * 
	 * @param parent
	 *        Parent composite where compound will added
	 */
	private void createLabelPage(Composite parent) {
		Label labelPage = new Label(parent, SWT.NONE);

		GridData layoutData = new GridData(SWT.FILL);
		layoutData.horizontalSpan = 2;
		labelPage.setLayoutData(layoutData);

		labelPage.setText(PREFERENCE_PAGE_LABEL);

	}


	/**
	 * Initialize preference page.
	 */
	private void initializeDataPage() {

		EList<EObject> stylesheetsModel = getProjectStylesheets();
		modelStyleSheets = (ModelStyleSheets)StylesheetsPackage.eINSTANCE.getEFactoryInstance().create(StylesheetsPackage.Literals.MODEL_STYLE_SHEETS);
		modelStyleSheets.getStylesheets();
		List<EObject> mirrorList = new ArrayList<EObject>();
		mirrorList.addAll(stylesheetsModel);

		for(EObject object : mirrorList) {

			if(object instanceof StyleSheet) {
				modelStyleSheets.getStylesheets().add((StyleSheet)object);
			}
		}



	}




	/**
	 * Initialize the different providers to display style sheets list.
	 */
	private void initializeProviders() {

		contentProvider = new EMFContentProvider(modelStyleSheets, StylesheetsPackage.eINSTANCE.getModelStyleSheets_Stylesheets()) {

			@Override
			protected IStructuredContentProvider getSemanticProvider(final EObject editedEObject, final EStructuralFeature feature) {

				// Use a standard content provider
				return new AbstractStaticContentProvider() {

					public Object[] getElements() {
						List<Object> result = new LinkedList<Object>();
						if(editedEObject instanceof ModelStyleSheets) {
							result.addAll(modelStyleSheets.getStylesheets());
						}
						return result.toArray();
					}
				};
			}
		};

		labelProvider = new CSSStyleSheetLabelProvider();
	}




	/**
	 * Create viewer to display content of style sheets model.
	 * 
	 * @param parent
	 *        Parent composite where compound will added
	 */
	private void createStyleSheetsPageViewer(Composite parent) {


		// Set layout and behavior to tree viewer
		styleSheetsViewer = new TreeViewer(parent);
		styleSheetsViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		styleSheetsViewer.addSelectionChangedListener(new ISelectionChangedListener() {


			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();

			}


		});
		styleSheetsViewer.setContentProvider(contentProvider);
		styleSheetsViewer.setLabelProvider(labelProvider);
		styleSheetsViewer.setInput(modelStyleSheets);
	}




	/**
	 * Create buttons which are associated with viewer.
	 * 
	 * @param parent
	 *        Parent composite where compound will added
	 */
	private void createStyleSheetsPageButtons(Composite parent) {

		//Build composite which contains buttons
		Composite buttonsComposite = new Composite(parent, SWT.NONE);
		buttonsComposite.setLayout(new GridLayout());
		buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));


		// Add all buttons
		createButton(buttonsComposite, ADD_ICON, ADD_BUTTON_ID);
		createButton(buttonsComposite, DELETE_ICON, DELETE_BUTTON_ID);
		createButton(buttonsComposite, UP_ICON, UP_BUTTON_ID);
		createButton(buttonsComposite, DOWN_ICON, DOWN_BUTTON_ID);
		createButton(buttonsComposite, EDIT_ICON, EDIT_BUTTON_ID);
	}

	/**
	 * Method to create button.
	 * 
	 * @param parent
	 *        Composite where will be added
	 * @param icon
	 *        Icon for button
	 * @param id
	 *        Id to identify button
	 */
	private void createButton(Composite parent, Image icon, int id) {
		Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		button.setData(new Integer(id));
		button.setImage(icon);
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				buttonPressed(((Integer)event.widget.getData()).intValue());
			}
		});

		buttonsMap.put(id, button);
	}

	/**
	 * Fill style sheets viewer with selected style sheets.
	 * 
	 * @param result
	 *        Result from dialog selection
	 */
	protected void refreshStyleSheets(Object[] result) {

		// Add selected CSS style sheets
		for(Object object : result) {

			//Check if object is a style sheet
			if(object instanceof StyleSheet) {
				modelStyleSheets.getStylesheets().add((StyleSheet)object);

			}
		}

		// Refresh viewer
		styleSheetsViewer.setInput(modelStyleSheets);
		updateButtons();
	}


	/**
	 * Method call when a button is pressed.
	 * 
	 * @param buttonId
	 */
	protected void buttonPressed(int buttonId) {
		switch(buttonId) {
		case ADD_BUTTON_ID:
			addAction();
			break;
		case DELETE_BUTTON_ID:
			deleteAction();
			break;
		case DOWN_BUTTON_ID:
			downAction();
			break;
		case UP_BUTTON_ID:
			upAction();
			break;
		case EDIT_BUTTON_ID:
			editAction();
			break;
		default:
			break;
		}
	}

	/**
	 * Action to edit selected style sheet.
	 */
	private void editAction() {

		ISelection selection = styleSheetsViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedObject instanceof StyleSheet) {
				// Use editor factory
				editorFactory.edit(buttonsMap.get(EDIT_BUTTON_ID), selectedObject);
			}
		}

	}


	/**
	 * Action to move up a style sheet in list.
	 */
	private void upAction() {
		// Handle selection to extract selected style sheet
		ISelection selection = styleSheetsViewer.getSelection();
		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

			if(selectedElement instanceof StyleSheet) {

				// Get index of selected style sheet in list
				EList<StyleSheet> stylesheetsList = modelStyleSheets.getStylesheets();
				int index = stylesheetsList.indexOf(selectedElement);

				// Check if selected style sheet is not at top of list
				if(index > 0) {
					stylesheetsList.move(--index, (StyleSheet)selectedElement);
					styleSheetsViewer.setInput(stylesheetsList);
				}
			}
		}

	}


	/**
	 * Action to move down selected style sheet in list.
	 */
	private void downAction() {
		// Handle selection to extract selected style sheet
		ISelection selection = styleSheetsViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

			if(selectedElement instanceof StyleSheet) {

				// Get index of selected style sheet in list
				EList<StyleSheet> stylesheetsList = modelStyleSheets.getStylesheets();
				int index = stylesheetsList.indexOf(selectedElement);

				// Check if selected style sheet is not at bottom of list
				if(index < stylesheetsList.size() - 1) {
					stylesheetsList.move(++index, (StyleSheet)selectedElement);
					styleSheetsViewer.setInput(stylesheetsList);
				}
			}
		}

	}


	/**
	 * Action to delete selected style sheet.
	 */
	private void deleteAction() {
		ISelection selection = styleSheetsViewer.getSelection();
		if(selection instanceof IStructuredSelection) {

			// Handle selection
			Object firstElement = ((IStructuredSelection)selection).getFirstElement();
			if(firstElement instanceof StyleSheet) {
				modelStyleSheets.getStylesheets().remove(firstElement);
			}

			// Refresh viewer
			styleSheetsViewer.setInput(modelStyleSheets);

			updateButtons();

		}
	}


	/**
	 * Action to add a style sheet.
	 */
	private void addAction() {
		ReferenceSelector selector = new ReferenceSelector(true);
		selector.setContentProvider((IStaticContentProvider)contentProvider);
		selector.setLabelProvider(labelProvider);

		// Use common component for add dialog and parameterize it
		MultipleValueSelectorDialog vDialog = new MultipleValueSelectorDialog(getShell(), selector, PREFERENCE_PAGE_TITLE);
		vDialog.setContextElement(modelStyleSheets);
		vDialog.setLabelProvider(labelProvider);
		vDialog.setFactory(editorFactory);

		// Handle dialog result
		int result = vDialog.open();
		if(result == Dialog.OK) {

			Object[] resultArray = vDialog.getResult();
			if(resultArray != null) {
				refreshStyleSheets(resultArray);
			}
		}

	}


	/**
	 * Update state buttons.
	 */
	protected void updateButtons() {
		ISelection selection = styleSheetsViewer.getSelection();
		boolean enabled = !selection.isEmpty();
		for(int idButton : buttonsMap.keySet()) {
			switch(idButton) {
			case UP_BUTTON_ID:
			case DOWN_BUTTON_ID:
				EList<StyleSheet> stylesheets = modelStyleSheets.getStylesheets();
				buttonsMap.get(idButton).setEnabled(enabled && !stylesheets.isEmpty() && stylesheets.size() > 1);
				break;
			case EDIT_BUTTON_ID:
			case DELETE_BUTTON_ID:
				buttonsMap.get(idButton).setEnabled(enabled);
				break;

			default:
				break;
			}

		}



	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 *
	 * @return
	 */
	@Override
	public boolean performOk() {
		boolean performOK = false;

		try {
			resource.getContents().addAll(modelStyleSheets.getStylesheets());

			// Save preference file
			resource.save(Collections.EMPTY_MAP);
			performOK = true;
		} catch (IOException e) {
			Activator.log.error(e);
		}

		return performOK;
	}



}
