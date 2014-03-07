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
package org.eclipse.papyrus.infra.gmfdiag.css.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;



/**
 * Preference page to associate set of style sheets to Papyrus project.
 * <p>
 * The preference is stored in a file with EMF format. The target is file .settings/stylesheets.xmi
 * </p>
 *
 * @author gpascual
 */
public class StyleSheetsPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

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

	/** Button to delete style sheets in project preferences. */
	private Button removeButton = null;


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
			IPath preferencePath = pageProject.getLocation().append("stylesheets.xmi");

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

		// Initialize data and providers fro page
		initializeDataPage();
		initializeProviders();

		// Create different components
		createStyleSheetsPageViewer(container);
		createStyleSheetsPageButtons(container);

		//Update state buttons
		updateButton();

		return container;
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

		labelProvider = new StylesheetsModelLabelProvider();
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

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButton();

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


		//Add button
		Button addButton = new Button(buttonsComposite, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		addButton.setImage(Activator.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "/icons/Add_12x12.gif").createImage());
		addButton.addSelectionListener(new SelectionListener() {

			/**
			 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 *
			 * @param e
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				ReferenceSelector selector = new ReferenceSelector(true);
				selector.setContentProvider((IStaticContentProvider)contentProvider);
				selector.setLabelProvider(labelProvider);

				// Use common component for add dialog and parameterize it
				MultipleValueSelectorDialog vDialog = new MultipleValueSelectorDialog(getShell(), selector, "CSS Style Sheet");
				vDialog.setContextElement(modelStyleSheets);
				vDialog.setLabelProvider(labelProvider);
				vDialog.setFactory(new EcorePropertyEditorFactory(StylesheetsPackage.Literals.MODEL_STYLE_SHEETS__STYLESHEETS));

				// Handle dialog result
				int result = vDialog.open();
				if(result == Dialog.OK) {

					Object[] resultArray = vDialog.getResult();
					if(resultArray != null) {
						refreshStyleSheets(resultArray);
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing to do
			}
		});

		removeButton = new Button(buttonsComposite, SWT.PUSH);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		removeButton.setImage(Activator.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "/icons/Delete_12x12.gif").createImage());
		removeButton.addSelectionListener(new SelectionListener() {

			/**
			 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 *
			 * @param e
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = styleSheetsViewer.getSelection();
				if(selection instanceof IStructuredSelection) {

					// Handle selection
					Object firstElement = ((IStructuredSelection)selection).getFirstElement();
					if(firstElement instanceof StyleSheet) {
						modelStyleSheets.getStylesheets().remove(firstElement);
					}

					// Refresh viewer
					styleSheetsViewer.setInput(modelStyleSheets);

				}

			}

			/**
			 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 *
			 * @param e
			 */
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do

			}
		});
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
	}




	/**
	 * Update state buttons.
	 */
	protected void updateButton() {
		ISelection selection = styleSheetsViewer.getSelection();

		removeButton.setEnabled(!selection.isEmpty());


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



	/**
	 * 
	 * Label provider for style sheets list in different displays.
	 * 
	 * @author gpascual
	 *
	 */
	public class StylesheetsModelLabelProvider extends EMFLabelProvider {

		/**
		 * Default constructor.
		 *
		 */
		public StylesheetsModelLabelProvider() {
			super();
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 *
		 * @param element
		 * @return
		 */
		@Override
		public String getText(Object element) {
			String text = "";

			if(element instanceof StyleSheetReference) {
				text = ((StyleSheetReference)element).getPath();
			} else if(element instanceof EmbeddedStyleSheet) {
				text = ((EmbeddedStyleSheet)element).getLabel();
			}

			return text;
		}



	}



}
