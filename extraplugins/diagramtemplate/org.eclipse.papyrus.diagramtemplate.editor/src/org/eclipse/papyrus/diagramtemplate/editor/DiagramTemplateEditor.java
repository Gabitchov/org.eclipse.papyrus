/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate.editor;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.DiagramDefinition;
import org.eclipse.papyrus.diagramtemplate.DiagramTemplateFactory;
import org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage;
import org.eclipse.papyrus.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;
import org.eclipse.papyrus.diagramtemplate.Template;
import org.eclipse.papyrus.diagramtemplate.editor.provider.DiagramDefinitionContentProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.DiagramDefinitionLabelProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.DiagramKindContentProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.ElementsAvailableContentProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.ForContentProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.ForLabelProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.TypesAvailableFromEReferenceContentProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.TypesContentProvider;
import org.eclipse.papyrus.diagramtemplate.editor.provider.WhatContentProvider;
import org.eclipse.papyrus.diagramtemplate.launcher.DiagramTemplateLauncher;
import org.eclipse.papyrus.diagramtemplate.provider.DiagramTemplateItemProviderAdapterFactory;
import org.eclipse.papyrus.diagramtemplate.utils.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.swtdesigner.ResourceManager;


/**
 * The template model editor.
 * 
 */
public class DiagramTemplateEditor extends EditorPart {


	private static final String DEFAULT_NAME = Messages.DiagramTemplateEditor_0;

	private static final String DEFAULT_PREFIX = Messages.DiagramTemplateEditor_1;

	/**
	 * Text widget to show the target model's path
	 */
	private Text targetModelPathText;

	/**
	 * Table widget to edit the diagram definitions
	 */
	private Table diagramDefinitionTable;

	/**
	 * TableViewer widget to edit the diagram definitions
	 */
	private TableViewer diagramDefinitionTableViewer;

	/**
	 * Text widget to edit the diagram definition's name
	 */
	private Text nameText;

	/**
	 * Text widget to edit the prefix used to generate the diagram name
	 */
	private Text prefixText;

	/**
	 * Text widget to edit the root to start the search from
	 */
	private Text rootText;

	/**
	 * Text widget to edit the diagram definition's description
	 */
	private Text descriptionText;

	/**
	 * Table widget to select the diagram kind to generate
	 */
	private Table diagramTable;

	/**
	 * CheckboxTableViewer widget to select the diagram kind to generate
	 */
	private CheckboxTableViewer diagramCheckboxTableViewer;

	/**
	 * Table widget to edit the diagram definition's selection
	 */
	private Table whatTable;

	/**
	 * TableViewer widget to edit the diagram definition's selection
	 */
	private TableViewer whatTableViewer;

	/**
	 * Tree widget to edit the diagram definition's selection
	 */
	private Tree forTree;

	/**
	 * TreeViewer widget to edit the diagram definition's selection
	 */
	private TreeViewer forTreeViewer;

	/**
	 * Button widget to add a diagram definition
	 */
	private Button addDiagramDefinitionButton;

	/**
	 * Button widget to select the root of the diagram definition
	 */
	private Button selectRootButton;

	/**
	 * Button widget to add a specificFor selection
	 */
	private Button specificForButton;

	/**
	 * Button widget to add a specificWhat selection
	 */
	private Button specificWhatButton;

	/**
	 * Button widget to load a target model
	 */
	private Button loadModelButton;

	/**
	 * Button widget to execute the template
	 */
	private Button executeButton;

	/**
	 * List of diagram categories to consider
	 */
	List<String> diagramCategories = new ArrayList<String>();

	/**
	 * The IFile object corresponding to the model to process
	 */
	private IFile modelFile;

	/**
	 * The ResourceSet object corresponding to the model to process
	 */
	private ResourceSet targetModelResourceSet;

	/**
	 * The Resource object corresponding to the model to process
	 */
	private Resource targetModelResource = null;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 * 
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * Map to store the diagnostic associated with a resource.
	 * 
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * The diagram definition under edition
	 */
	private DiagramDefinition currentDiagramDefinition;

	/**
	 * The resource for the template
	 */
	private Resource templateResource;

	/**
	 * The template
	 */
	private Template template;

	private DiagramTemplateFactory diagramtemplateFactory;


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DiagramTemplateEditor() {
		super();
		initializeEditingDomain();

		initializeDiagramCategories();

		DiagramTemplatePackage diagramtemplatePackage = DiagramTemplatePackage.eINSTANCE;
		diagramtemplateFactory = diagramtemplatePackage.getDiagramTemplateFactory();
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * 
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return DiagramTemplateEditorPlugin.INSTANCE.getString(key, new Object[]{ s1 });
	}

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * 
	 * @generated NOT
	 */
	protected boolean createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Exception exception = null;

		try {
			// Load the resource through the editing domain.
			templateResource = editingDomain.getResourceSet().getResource(resourceURI, true);
		} catch (Exception e) {
			exception = e;
			templateResource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		Diagnostic diagnostic = analyzeResourceProblems(templateResource, exception);
		if(diagnostic.getSeverity() != Diagnostic.OK) {
			//Failed to load
			MessageDialog.openError(getSite().getShell(), Messages.DiagramTemplateEditor_2, Messages.DiagramTemplateEditor_3);
			return false;
		} else {

			if(templateResource.getContents().isEmpty()) {
				//Create the template
				template = diagramtemplateFactory.createTemplate();
				templateResource.getContents().add(template);
			} else {
				//Load the template
				template = (Template)templateResource.getContents().get(0);
				if(template.getTargetRoot() != null) {
					Resource res = template.getTargetRoot().eResource();
					if(res != null) {
						targetModelResource = res;
					} else {
						MessageDialog.openError(getSite().getShell(), Messages.DiagramTemplateEditor_4, Messages.DiagramTemplateEditor_5);
					}
				}
			}

		}
		return true;
	}

	/**
	 * Helper method to load a model
	 * 
	 * @param resourceSet
	 *        the resourceSet to load the model in
	 * @param file
	 *        the file corresponding to the model to load
	 * @return the resource corresponding to the model
	 */
	protected Resource loadModel(ResourceSet resourceSet, IFile file) {

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.Factory.Registry.DEFAULT_EXTENSION, UMLResource.Factory.INSTANCE);

		return resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
	}

	/**
	 * Helper method to update rootText widget
	 */
	protected void updateRootText() {
		if(currentDiagramDefinition.getFromRoot() instanceof NamedElement) {
			rootText.setText(((NamedElement)currentDiagramDefinition.getFromRoot()).getQualifiedName());
		} else {
			rootText.setText(currentDiagramDefinition.getFromRoot().toString());
		}
	}

	/**
	 * Helper method to update the UI
	 */
	protected void updateUI() {
		diagramDefinitionTableViewer.refresh();
		forTreeViewer.setInput(currentDiagramDefinition.getSelection());
		forTreeViewer.refresh();
		whatTableViewer.refresh();
		diagramCheckboxTableViewer.refresh();

		nameText.setText(currentDiagramDefinition.getName());
		descriptionText.setText(currentDiagramDefinition.getDescription());
		prefixText.setText(currentDiagramDefinition.getPrefix());
		if(currentDiagramDefinition.getFromRoot() != null) {
			updateRootText();
		} else {
			rootText.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * Helper method to initialize the diagram categories (kinds)
	 */
	protected void initializeDiagramCategories() {
		for(DiagramCategoryDescriptor diagramCategoryDescriptor : DiagramCategoryRegistry.getInstance().getDiagramCategories()) {
			diagramCategories.add(diagramCategoryDescriptor.getLabel());
		}
	}

	/**
	 * Helper method used to check if the element is already defined
	 * 
	 * @param object
	 *        the element to find
	 * @param list
	 *        the list to search in
	 * @return
	 *         true if found false else
	 */
	protected boolean containsElement(EObject object, List<?> list) {
		if(list != null) {
			for(Object selection : list) {
				if(((AbstractSelection)selection).getElement() == object) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Helper method to clear the template of specific information
	 */
	protected void clearTemplate() {
		TreeIterator<EObject> it = template.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof DiagramDefinition) {
				((DiagramDefinition)eObject).setFromRoot(null);
			} else if(eObject instanceof Selection) {
				if(((AbstractSelection)eObject).getKind() != SelectionKind.FOR_ALL) {
					RemoveCommand command = new RemoveCommand(editingDomain, ((Selection)eObject).eContainer(), ((Selection)eObject).eContainer().eClass().getEStructuralFeature("selection"), eObject); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);
					it = template.eAllContents();
				}
			} else if(eObject instanceof SelectionRef) {
				if(((AbstractSelection)eObject).getKind() != SelectionKind.FOR_ALL) {
					RemoveCommand command = new RemoveCommand(editingDomain, ((SelectionRef)eObject).eContainer(), ((SelectionRef)eObject).eContainer().eClass().getEStructuralFeature("selectionRef"), eObject); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);
					it = template.eAllContents();
				}
			}



		}

		SetCommand command = new SetCommand(editingDomain, template, template.eClass().getEStructuralFeature("targetRoot"), null); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);


		modelFile = null;
		targetModelPathText.setText(""); //$NON-NLS-1$
		targetModelResourceSet = null;
		targetModelResource = null;

		loadModelButton.setEnabled(true);
		selectRootButton.setEnabled(false);
		executeButton.setEnabled(false);
		specificForButton.setEnabled(false);

		updateUI();
	}

	/**
	 * Helper method to create a new diagram definition
	 */
	protected void createNewDiagramDefinition() {
		currentDiagramDefinition = diagramtemplateFactory.createDiagramDefinition();
		currentDiagramDefinition.setName(DEFAULT_NAME);
		currentDiagramDefinition.setDescription(""); //$NON-NLS-1$
		currentDiagramDefinition.setPrefix(DEFAULT_PREFIX);

		if(targetModelResource != null) {
			currentDiagramDefinition.setFromRoot(targetModelResource.getContents().get(0));
		}

		//Update UI
		updateUI();

		addDiagramDefinitionButton.setEnabled(true);
	}

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource
	 * and the specified exception (if any).
	 * 
	 * @generated
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		if(!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.papyrus.diagramtemplate.editor", 0, getString("_UI_CreateModelError_message", resource.getURI()), new Object[]{ exception == null ? (Object)resource : exception }); //$NON-NLS-1$ //$NON-NLS-2$
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		} else if(exception != null) {
			return new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.papyrus.diagramtemplate.editor", 0, getString("_UI_CreateModelError_message", resource.getURI()), new Object[]{ exception }); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			return Diagnostic.OK_INSTANCE;
		}
	}


	/**
	 * This sets up the editing domain for the model editor.
	 * 
	 * @generated
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new DiagramTemplateItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new UMLItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		commandStack.addCommandStackListener(new CommandStackListener() {

			/**
			 * {@inheritDoc}
			 */
			public void commandStackChanged(EventObject event) {
				updateUI();
				firePropertyChange(IEditorPart.PROP_DIRTY);
			}
		});

		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream.
	 * 
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if(stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for(Resource resource : editingDomain.getResourceSet().getResources()) {
					if((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
						try {
							resource.save(saveOptions);
						} catch (Exception exception) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};

		try {

			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			DiagramTemplateEditorPlugin.INSTANCE.log(exception);
		}

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInputWithNotify(input);
		setPartName(input.getName());
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	private void createloadPart(Composite parent) {

		Composite loadComposite = new Composite(parent, SWT.NONE);
		loadComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		loadComposite.setLayout(new GridLayout(5, false));

		executeButton = new Button(loadComposite, SWT.NONE);
		executeButton.setText(Messages.DiagramTemplateEditor_15);
		executeButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/execute.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		executeButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if(targetModelResource != null) {
					DiagramTemplateLauncher launcher = DiagramTemplateLauncher.getInstance();
					launcher.execute(template);
				} else {
					MessageDialog.openInformation(getSite().getShell(), Messages.DiagramTemplateEditor_18, Messages.DiagramTemplateEditor_19);
				}
			}
		});
		executeButton.setEnabled(false);

		Label loadLabel = new Label(loadComposite, SWT.NONE);
		loadLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		loadLabel.setText(Messages.DiagramTemplateEditor_20);

		targetModelPathText = new Text(loadComposite, SWT.BORDER);
		targetModelPathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		targetModelPathText.setEditable(false);

		loadModelButton = new Button(loadComposite, SWT.NONE);
		loadModelButton.setText(Messages.DiagramTemplateEditor_21);
		loadModelButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getSite().getShell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
				dialog.addFilter(new ViewerFilter() {

					//Show only element with UML extension
					@Override
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if(element instanceof IContainer) {
							return true;
						} else {
							if(((IFile)element).getFileExtension().compareToIgnoreCase("uml") == 0) { //$NON-NLS-1$
								return true;
							} else {
								return false;
							}
						}

					}
				});
				dialog.setAllowMultiple(false);
				dialog.setTitle(Messages.DiagramTemplateEditor_23);
				dialog.setMessage(Messages.DiagramTemplateEditor_24);
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.open();

				Object result = dialog.getFirstResult();
				if(result instanceof IFile) {
					modelFile = (IFile)dialog.getFirstResult();
					targetModelResourceSet = new ResourceSetImpl();
					targetModelResource = loadModel(targetModelResourceSet, modelFile);
					targetModelPathText.setText(targetModelResource.getURI().toString());

					SetCommand command = new SetCommand(editingDomain, template, template.eClass().getEStructuralFeature("targetRoot"), targetModelResource.getContents().get(0)); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);

					//Set fromRoots automatically
					for(DiagramDefinition diagramDefinition : template.getDiagramDefinitions()) {
						diagramDefinition.setFromRoot(targetModelResource.getContents().get(0));
					}

					selectRootButton.setEnabled(true);
					loadModelButton.setEnabled(false);
					specificForButton.setEnabled(true);
					executeButton.setEnabled(true);

					updateUI();
				}
			}
		});

		Button clearButton = new Button(loadComposite, SWT.NONE);
		clearButton.setText(Messages.DiagramTemplateEditor_26);
		clearButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if(MessageDialog.openConfirm(getSite().getShell(), Messages.DiagramTemplateEditor_27, Messages.DiagramTemplateEditor_28)) {
					clearTemplate();
				}
			}
		});
	}

	private void createDiagramDefinitionPart(Composite parent) {
		Composite diagramDefinitionPartComposite = new Composite(parent, SWT.NONE);
		diagramDefinitionPartComposite.setLayout(new GridLayout(1, false));

		Composite diagramDefinitionButtonsComposite = new Composite(diagramDefinitionPartComposite, SWT.NONE);
		GridLayout gl_diagramDefinitionButtonsComposite = new GridLayout(6, false);
		gl_diagramDefinitionButtonsComposite.horizontalSpacing = 0;
		gl_diagramDefinitionButtonsComposite.verticalSpacing = 1;
		gl_diagramDefinitionButtonsComposite.marginWidth = 0;
		gl_diagramDefinitionButtonsComposite.marginHeight = 0;
		diagramDefinitionButtonsComposite.setLayout(gl_diagramDefinitionButtonsComposite);
		diagramDefinitionButtonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Button newDiagramDefinitionButton = new Button(diagramDefinitionButtonsComposite, SWT.NONE);
		newDiagramDefinitionButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/new.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		newDiagramDefinitionButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				createNewDiagramDefinition();
				addDiagramDefinitionButton.setEnabled(true);
			}
		});

		addDiagramDefinitionButton = new Button(diagramDefinitionButtonsComposite, SWT.NONE);
		addDiagramDefinitionButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/add.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		addDiagramDefinitionButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if(currentDiagramDefinition.getDiagramKind() != null) {
					if(template != null) {
						AddCommand command = new AddCommand(editingDomain, template, template.eClass().getEStructuralFeature("diagramDefinitions"), currentDiagramDefinition); //$NON-NLS-1$
						editingDomain.getCommandStack().execute(command);
					}
					createNewDiagramDefinition();
				} else {
					MessageDialog.openWarning(getSite().getShell(), Messages.DiagramTemplateEditor_34, Messages.DiagramTemplateEditor_35);
				}
			}
		});

		Button removeDiagramDefinitionButton = new Button(diagramDefinitionButtonsComposite, SWT.NONE);
		removeDiagramDefinitionButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/delete.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		removeDiagramDefinitionButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = diagramDefinitionTableViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					Iterator it = ((IStructuredSelection)selection).iterator();
					while(it.hasNext()) {
						Object object = it.next();

						RemoveCommand command = new RemoveCommand(editingDomain, template, template.eClass().getEStructuralFeature("diagramDefinitions"), object); //$NON-NLS-1$
						editingDomain.getCommandStack().execute(command);

					}

					diagramDefinitionTableViewer.refresh();
					createNewDiagramDefinition();
				}
			}
		});

		Button moveUpDiagramDefinitionButton = new Button(diagramDefinitionButtonsComposite, SWT.NONE);
		moveUpDiagramDefinitionButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/up.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		moveUpDiagramDefinitionButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = diagramDefinitionTableViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					DiagramDefinition diagramDefinition = (DiagramDefinition)((IStructuredSelection)selection).getFirstElement();
					MoveCommand command = new MoveCommand(editingDomain, template, template.eClass().getEStructuralFeature("diagramDefinitions"), diagramDefinition, template.getDiagramDefinitions().indexOf(diagramDefinition) - 1); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);

					diagramDefinitionTableViewer.refresh();
				}
			}
		});

		Button moveDownDiagramDefinitionButton = new Button(diagramDefinitionButtonsComposite, SWT.NONE);
		moveDownDiagramDefinitionButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/down.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		moveDownDiagramDefinitionButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = diagramDefinitionTableViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					DiagramDefinition diagramDefinition = (DiagramDefinition)((IStructuredSelection)selection).getFirstElement();
					MoveCommand command = new MoveCommand(editingDomain, template, template.eClass().getEStructuralFeature("diagramDefinitions"), diagramDefinition, template.getDiagramDefinitions().indexOf(diagramDefinition) + 1); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);

					diagramDefinitionTableViewer.refresh();
				}
			}
		});

		Button copyDiagramDefinitionButton = new Button(diagramDefinitionButtonsComposite, SWT.NONE);
		copyDiagramDefinitionButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/copy.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		copyDiagramDefinitionButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = diagramDefinitionTableViewer.getSelection();

				if(selection != null && !selection.isEmpty()) {
					if(selection instanceof IStructuredSelection) {
						DiagramDefinition diagramDefinition = (DiagramDefinition)((IStructuredSelection)selection).getFirstElement();

						Copier copier = new Copier();
						DiagramDefinition diagramDefinitionCopy = (DiagramDefinition)copier.copy(diagramDefinition);
						copier.copyReferences();

						diagramDefinitionCopy.setName(Messages.DiagramTemplateEditor_47 + diagramDefinitionCopy.getName());

						if(template != null) {
							AddCommand command = new AddCommand(editingDomain, template, template.eClass().getEStructuralFeature("diagramDefinitions"), diagramDefinitionCopy); //$NON-NLS-1$
							editingDomain.getCommandStack().execute(command);
						}
						createNewDiagramDefinition();
					}
				}
			}
		});

		diagramDefinitionTableViewer = new TableViewer(diagramDefinitionPartComposite, SWT.BORDER | SWT.FULL_SELECTION);
		diagramDefinitionTable = diagramDefinitionTableViewer.getTable();
		diagramDefinitionTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		diagramDefinitionTableViewer.setContentProvider(new DiagramDefinitionContentProvider());
		diagramDefinitionTableViewer.setLabelProvider(new DiagramDefinitionLabelProvider());
		diagramDefinitionTableViewer.setInput(template.getDiagramDefinitions());
		diagramDefinitionTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection && !event.getSelection().isEmpty()) {

					currentDiagramDefinition = (DiagramDefinition)((IStructuredSelection)event.getSelection()).getFirstElement();

					//Update UI
					updateUI();

					//We are under edition of an existing diagram definition: we cannot add
					addDiagramDefinitionButton.setEnabled(false);
				}
			}
		});


	}

	private void createDiagramInformationPart(Composite parent) {
		Composite diagramInformationComposite = new Composite(parent, SWT.NONE);
		diagramInformationComposite.setLayout(new GridLayout(5, false));

		Label nameLabel = new Label(diagramInformationComposite, SWT.NONE);
		nameLabel.setText(Messages.DiagramTemplateEditor_49);

		nameText = new Text(diagramInformationComposite, SWT.BORDER);
		nameText.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				SetCommand command = new SetCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("name"), nameText.getText()); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(command);
			}
		});
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		Label descriptionLabel = new Label(diagramInformationComposite, SWT.NONE);
		descriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 3));
		descriptionLabel.setText(Messages.DiagramTemplateEditor_51);

		descriptionText = new Text(diagramInformationComposite, SWT.BORDER | SWT.MULTI);
		descriptionText.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				SetCommand command = new SetCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("description"), descriptionText.getText()); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(command);
			}
		});
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));

		Label prefixLabel = new Label(diagramInformationComposite, SWT.NONE);
		prefixLabel.setText(Messages.DiagramTemplateEditor_53);

		prefixText = new Text(diagramInformationComposite, SWT.BORDER);
		prefixText.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				SetCommand command = new SetCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("prefix"), prefixText.getText()); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(command);
			}
		});
		prefixText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		Label rootLabel = new Label(diagramInformationComposite, SWT.NONE);
		rootLabel.setText(Messages.DiagramTemplateEditor_55);

		rootText = new Text(diagramInformationComposite, SWT.BORDER);
		rootText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		rootText.setEditable(false);

		selectRootButton = new Button(diagramInformationComposite, SWT.NONE);
		selectRootButton.setText(Messages.DiagramTemplateEditor_56);
		selectRootButton.setEnabled(false);
		selectRootButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {

				ElementTreeSelectionDialog dlg = new ElementTreeSelectionDialog(getSite().getShell(), new AdapterFactoryLabelProvider(adapterFactory), new AdapterFactoryContentProvider(adapterFactory));
				dlg.addFilter(new ViewerFilter() {

					//Show only eObject element
					@Override
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if(element instanceof EObject) {
							return true;
						} else {
							return false;
						}
					}
				});
				dlg.setAllowMultiple(false);
				dlg.setTitle(Messages.DiagramTemplateEditor_57);
				dlg.setMessage(Messages.DiagramTemplateEditor_58);
				dlg.setInput(targetModelResource);
				dlg.open();

				Object result = dlg.getFirstResult();
				if(result instanceof EObject) {
					SetCommand command = new SetCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("fromRoot"), result); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);

					updateRootText();
				}

			}

		});

		Label diagramLabel = new Label(diagramInformationComposite, SWT.NONE);
		diagramLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
		diagramLabel.setText(Messages.DiagramTemplateEditor_60);

		diagramCheckboxTableViewer = CheckboxTableViewer.newCheckList(diagramInformationComposite, SWT.BORDER | SWT.FULL_SELECTION);
		diagramTable = diagramCheckboxTableViewer.getTable();
		diagramTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
		diagramCheckboxTableViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				if(element instanceof CreationCommandDescriptor) {
					SetCommand command = new SetCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("diagramKind"), ((CreationCommandDescriptor)element).getCommandId()); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);
				}

				diagramCheckboxTableViewer.setCheckedElements(new Object[0]);
				diagramCheckboxTableViewer.setChecked(element, true);
			}
		});
		diagramCheckboxTableViewer.setContentProvider(new DiagramKindContentProvider());
		diagramCheckboxTableViewer.setLabelProvider(new DiagramKindLabelProvider());
		diagramCheckboxTableViewer.setInput(diagramCategories);

		diagramCheckboxTableViewer.setCheckStateProvider(new ICheckStateProvider() {

			public boolean isGrayed(Object element) {
				return false;
			}

			public boolean isChecked(Object element) {
				if(currentDiagramDefinition != null) {
					if(element instanceof CreationCommandDescriptor && currentDiagramDefinition.getDiagramKind() != null) {
						return ((CreationCommandDescriptor)element).getCommandId().equals(currentDiagramDefinition.getDiagramKind());
					}
				}
				return false;
			}
		});
	}

	private void createSelectionPart(Composite parent) {
		SashForm selectionPartSashForm = new SashForm(parent, SWT.NONE);

		Composite forPartComposite = new Composite(selectionPartSashForm, SWT.NONE);
		forPartComposite.setLayout(new GridLayout(1, false));

		Composite forButtonsComposite = new Composite(forPartComposite, SWT.NONE);
		GridLayout gl_forButtonsComposite = new GridLayout(6, false);
		gl_forButtonsComposite.verticalSpacing = 0;
		gl_forButtonsComposite.horizontalSpacing = 0;
		gl_forButtonsComposite.marginHeight = 0;
		gl_forButtonsComposite.marginWidth = 0;
		forButtonsComposite.setLayout(gl_forButtonsComposite);
		forButtonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label forLabel = new Label(forButtonsComposite, SWT.NONE);
		forLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		forLabel.setText(Messages.DiagramTemplateEditor_64);

		Button allForButton = new Button(forButtonsComposite, SWT.NONE);
		allForButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/forAll.png")); //$NON-NLS-1$ //$NON-NLS-2$
		allForButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {

				List<EObject> listOfTypes = new ArrayList<EObject>();
				UMLPackage umlPackage = UMLPackage.eINSTANCE;
				TreeIterator<EObject> it = umlPackage.eAllContents();
				while(it.hasNext()) {
					EObject typeInUML = it.next();
					if(typeInUML instanceof EClass) {
						if(targetModelResource != null) {
							if(!targetModelResource.getContents().isEmpty()) {
								//If the element is a type available in the model
								TreeIterator<EObject> itTarget = targetModelResource.getAllContents();
								while(itTarget.hasNext()) {
									EObject elementInTargetModel = itTarget.next();

									if(typeInUML == elementInTargetModel.eClass() && !listOfTypes.contains(typeInUML)) {
										listOfTypes.add(typeInUML);
									}
								}
							}
						} else {
							listOfTypes.add(typeInUML);
						}
					}
				}

				ListSelectionDialog dlg = new ListSelectionDialog(getSite().getShell(), listOfTypes, new TypesContentProvider(), new AdapterFactoryLabelProvider(adapterFactory), Messages.DiagramTemplateEditor_67);
				dlg.setTitle(Messages.DiagramTemplateEditor_68);
				dlg.open();

				Object[] results = dlg.getResult();
				if(results != null) {
					for(Object object : results) {
						if(object instanceof EClass) {

							if(!containsElement((EClass)object, currentDiagramDefinition.getSelection())) {

								Selection selection = diagramtemplateFactory.createSelection();
								selection.setKind(SelectionKind.FOR_ALL);
								selection.setRecursively(false);
								selection.setSubTypes(false);
								selection.setStereotypedBy(""); //$NON-NLS-1$
								selection.setElement((EClass)object);

								AddCommand command = new AddCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("selection"), selection); //$NON-NLS-1$
								editingDomain.getCommandStack().execute(command);


							}
						}
					}
					forTreeViewer.refresh();
				}
			}

		});
		allForButton.setText(Messages.DiagramTemplateEditor_71);

		specificForButton = new Button(forButtonsComposite, SWT.NONE);
		specificForButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/specific.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		specificForButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if(targetModelResource != null) {
					CheckedTreeSelectionDialog dlg = new CheckedTreeSelectionDialog(getSite().getShell(), new AdapterFactoryLabelProvider(adapterFactory), new AdapterFactoryContentProvider(adapterFactory));
					dlg.setInput(targetModelResource);
					dlg.setTitle(Messages.DiagramTemplateEditor_74);
					dlg.open();

					Object[] results = dlg.getResult();
					if(results != null) {
						for(Object object : results) {
							if(object instanceof EObject) {

								if(!containsElement((EObject)object, currentDiagramDefinition.getSelection())) {
									Selection selection = diagramtemplateFactory.createSelection();
									selection.setKind(SelectionKind.SPECIFIC);
									selection.setRecursively(false);
									selection.setSubTypes(false);
									selection.setStereotypedBy(""); //$NON-NLS-1$
									selection.setElement((EObject)object);

									//									currentDiagramDefinition.getSelection().add(selection);
									AddCommand command = new AddCommand(editingDomain, currentDiagramDefinition, currentDiagramDefinition.eClass().getEStructuralFeature("selection"), selection); //$NON-NLS-1$
									editingDomain.getCommandStack().execute(command);
								}
							}
						}
						forTreeViewer.refresh();
					}
				}
			}

		});
		specificForButton.setText(Messages.DiagramTemplateEditor_77);
		specificForButton.setEnabled(false);

		Button removeForButton = new Button(forButtonsComposite, SWT.NONE);
		removeForButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = forTreeViewer.getSelection();
				if(selection != null && selection instanceof ITreeSelection) {
					Iterator it = ((ITreeSelection)selection).iterator();
					while(it.hasNext()) {
						Object object = it.next();
						//						removeSelection((AbstractSelection)object);
						if(object instanceof Selection) {
							RemoveCommand command = new RemoveCommand(editingDomain, ((Selection)object).eContainer(), ((Selection)object).eContainer().eClass().getEStructuralFeature("selection"), object); //$NON-NLS-1$
							editingDomain.getCommandStack().execute(command);
						} else if(object instanceof SelectionRef) {
							RemoveCommand command = new RemoveCommand(editingDomain, ((SelectionRef)object).eContainer(), ((SelectionRef)object).eContainer().eClass().getEStructuralFeature("selectionRef"), object); //$NON-NLS-1$
							editingDomain.getCommandStack().execute(command);
						}
					}
					forTreeViewer.refresh();
				}
			}
		});
		removeForButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/delete.gif")); //$NON-NLS-1$ //$NON-NLS-2$


		Button moveUpForButton = new Button(forButtonsComposite, SWT.NONE);
		moveUpForButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = forTreeViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					AbstractSelection abstractSelection = (AbstractSelection)((IStructuredSelection)selection).getFirstElement();
					if(abstractSelection instanceof Selection) {
						MoveCommand command = new MoveCommand(editingDomain, abstractSelection.eContainer(), abstractSelection.eContainer().eClass().getEStructuralFeature("selection"), abstractSelection, ((DiagramDefinition)abstractSelection.eContainer()).getSelection().indexOf(abstractSelection) - 1); //$NON-NLS-1$
						editingDomain.getCommandStack().execute(command);
					} else if(abstractSelection instanceof SelectionRef) {
						MoveCommand command = new MoveCommand(editingDomain, abstractSelection.eContainer(), abstractSelection.eContainer().eClass().getEStructuralFeature("selectionRef"), abstractSelection, ((AbstractSelection)abstractSelection.eContainer()).getSelectionRef().indexOf(abstractSelection) - 1); //$NON-NLS-1$
						editingDomain.getCommandStack().execute(command);
					}
					forTreeViewer.refresh();
				}
			}
		});
		moveUpForButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/up.gif")); //$NON-NLS-1$ //$NON-NLS-2$

		Button moveDownForButton = new Button(forButtonsComposite, SWT.NONE);
		moveDownForButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = forTreeViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					AbstractSelection abstractSelection = (AbstractSelection)((IStructuredSelection)selection).getFirstElement();
					if(abstractSelection instanceof Selection) {
						MoveCommand command = new MoveCommand(editingDomain, abstractSelection.eContainer(), abstractSelection.eContainer().eClass().getEStructuralFeature("selection"), abstractSelection, ((DiagramDefinition)abstractSelection.eContainer()).getSelection().indexOf(abstractSelection) + 1); //$NON-NLS-1$
						editingDomain.getCommandStack().execute(command);
					} else if(abstractSelection instanceof SelectionRef) {
						MoveCommand command = new MoveCommand(editingDomain, abstractSelection.eContainer(), abstractSelection.eContainer().eClass().getEStructuralFeature("selectionRef"), abstractSelection, ((AbstractSelection)abstractSelection.eContainer()).getSelectionRef().indexOf(abstractSelection) + 1); //$NON-NLS-1$
						editingDomain.getCommandStack().execute(command);
					}
					forTreeViewer.refresh();
				}
			}
		});
		moveDownForButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/down.gif")); //$NON-NLS-1$ //$NON-NLS-2$

		forTreeViewer = new TreeViewer(forPartComposite, SWT.BORDER | SWT.FULL_SELECTION);
		forTree = forTreeViewer.getTree();
		forTree.setHeaderVisible(true);
		forTreeViewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
		forTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TreeViewerColumn selectionTreeViewerColumn = new TreeViewerColumn(forTreeViewer, SWT.NONE);
		TreeColumn selectionTreeColumn = selectionTreeViewerColumn.getColumn();
		selectionTreeColumn.setWidth(200);
		selectionTreeColumn.setText(Messages.DiagramTemplateEditor_90);

		TreeViewerColumn recursivelyTreeViewerColumn = new TreeViewerColumn(forTreeViewer, SWT.NONE);
		TreeColumn recursivelyTreeColumn = recursivelyTreeViewerColumn.getColumn();
		recursivelyTreeColumn.setWidth(70);
		recursivelyTreeColumn.setText(Messages.DiagramTemplateEditor_91);
		recursivelyTreeViewerColumn.setEditingSupport(new EditingSupport(forTreeViewer) {

			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof Selection) {
					SetCommand command = new SetCommand(editingDomain, (Selection)element, ((Selection)element).eClass().getEStructuralFeature("recursively"), (Boolean)value); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);
					//					((AbstractSelection)element).setRecursively((Boolean)value);
					getViewer().update(element, null);
				}
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof Selection) {
					return Boolean.valueOf(((Selection)element).isRecursively());
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				if(element instanceof Selection) {
					if(((Selection)element).getKind() == SelectionKind.FOR_ALL) {
						return new CheckboxCellEditor(forTree);
					}
				}

				return null;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});

		TreeViewerColumn subTypesTreeViewerColumn = new TreeViewerColumn(forTreeViewer, SWT.NONE);
		TreeColumn subTypesTreeColumn = subTypesTreeViewerColumn.getColumn();
		subTypesTreeColumn.setWidth(70);
		subTypesTreeColumn.setText(Messages.DiagramTemplateEditor_93);
		subTypesTreeViewerColumn.setEditingSupport(new EditingSupport(forTreeViewer) {

			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof AbstractSelection) {
					SetCommand command = new SetCommand(editingDomain, (AbstractSelection)element, ((AbstractSelection)element).eClass().getEStructuralFeature("subTypes"), (Boolean)value); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);
					//					((AbstractSelection)element).setSubTypes((Boolean)value);
					getViewer().update(element, null);
				}
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof AbstractSelection) {
					return Boolean.valueOf(((AbstractSelection)element).isSubTypes());
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				if(element instanceof AbstractSelection) {
					if(((AbstractSelection)element).getKind() == SelectionKind.FOR_ALL) {
						return new CheckboxCellEditor(forTree);
					}
				}
				return null;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});

		TreeViewerColumn stereotypeTreeViewerColumn = new TreeViewerColumn(forTreeViewer, SWT.NONE);
		TreeColumn stereotypeTreeColumn = stereotypeTreeViewerColumn.getColumn();
		stereotypeTreeColumn.setWidth(200);
		stereotypeTreeColumn.setText(Messages.DiagramTemplateEditor_95);
		stereotypeTreeViewerColumn.setEditingSupport(new EditingSupport(forTreeViewer) {



			@Override
			protected void setValue(Object element, Object value) {
				if(element instanceof AbstractSelection) {
					SetCommand command = new SetCommand(editingDomain, (AbstractSelection)element, ((AbstractSelection)element).eClass().getEStructuralFeature("stereotypedBy"), (String)value); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(command);
					getViewer().update(element, null);
				}
			}

			@Override
			protected Object getValue(Object element) {
				if(element instanceof AbstractSelection) {
					if(((AbstractSelection)element).getStereotypedBy() == null) {
						return ""; //$NON-NLS-1$
					} else {
						return ((AbstractSelection)element).getStereotypedBy();
					}
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				if(element instanceof AbstractSelection) {
					if(((AbstractSelection)element).getKind() == SelectionKind.FOR_ALL) {
						return new TextCellEditor(forTree);
					}
				}
				return null;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});

		forTreeViewer.setContentProvider(new ForContentProvider());
		forTreeViewer.setLabelProvider(new ForLabelProvider());
		forTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection != null && !selection.isEmpty()) {
					whatTableViewer.setInput(selection);
					whatTableViewer.refresh();

					if(selection instanceof IStructuredSelection) {
						Object selectionItem = ((IStructuredSelection)selection).getFirstElement();
						if(selectionItem instanceof AbstractSelection) {
							if(((AbstractSelection)selectionItem).getKind() == SelectionKind.FOR_ALL) {
								specificWhatButton.setEnabled(false);
							} else if(((AbstractSelection)selectionItem).getKind() == SelectionKind.SPECIFIC) {
								specificWhatButton.setEnabled(true);
							}
						}
					}
				}
			}
		});

		Composite whatPartComposite = new Composite(selectionPartSashForm, SWT.NONE);
		whatPartComposite.setLayout(new GridLayout(1, false));

		Composite whatButtonsComposite = new Composite(whatPartComposite, SWT.NONE);
		GridLayout gl_whatButtonsComposite = new GridLayout(3, false);
		gl_whatButtonsComposite.marginHeight = 0;
		gl_whatButtonsComposite.marginWidth = 0;
		gl_whatButtonsComposite.verticalSpacing = 0;
		gl_whatButtonsComposite.horizontalSpacing = 0;
		whatButtonsComposite.setLayout(gl_whatButtonsComposite);
		whatButtonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		whatButtonsComposite.setBounds(0, 0, 64, 64);

		Label whatLabel = new Label(whatButtonsComposite, SWT.NONE);
		whatLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		whatLabel.setText(Messages.DiagramTemplateEditor_98);

		Button allWhatButton = new Button(whatButtonsComposite, SWT.NONE);
		allWhatButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = whatTableViewer.getSelection();
				if(selection != null) {
					if(selection instanceof IStructuredSelection && !selection.isEmpty()) {

						EReference eReference = (EReference)((IStructuredSelection)selection).getFirstElement();

						ListSelectionDialog dlg = new ListSelectionDialog(getSite().getShell(), eReference, new TypesAvailableFromEReferenceContentProvider(), new AdapterFactoryLabelProvider(adapterFactory), Messages.DiagramTemplateEditor_99);
						dlg.setTitle(Messages.DiagramTemplateEditor_100);
						dlg.open();

						ISelection forSelection = forTreeViewer.getSelection();
						if(forSelection != null) {
							if(forSelection instanceof ITreeSelection) {

								AbstractSelection selectionItem = (AbstractSelection)((ITreeSelection)forSelection).getFirstElement();
								if(selectionItem != null) {

									Object[] results = dlg.getResult();
									if(results != null) {

										for(Object object : results) {
											if(object instanceof EClass) {

												if(!containsElement((EClass)object, selectionItem.getSelectionRef())) {
													SelectionRef selectionRef = diagramtemplateFactory.createSelectionRef();

													selectionRef.setKind(SelectionKind.FOR_ALL);
													selectionRef.setElement((EClass)object);
													selectionRef.setSubTypes(false);
													selectionRef.setStereotypedBy(""); //$NON-NLS-1$
													selectionRef.setEReference(eReference);

													AddCommand command = new AddCommand(editingDomain, selectionItem, selectionItem.eClass().getEStructuralFeature("selectionRef"), selectionRef); //$NON-NLS-1$
													editingDomain.getCommandStack().execute(command);

												}

											}
										}
									}
								}

							}

							forTreeViewer.refresh();

						}
					}
				}
			}
		});
		allWhatButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/forAllRef.png")); //$NON-NLS-1$ //$NON-NLS-2$
		allWhatButton.setText(Messages.DiagramTemplateEditor_105);

		specificWhatButton = new Button(whatButtonsComposite, SWT.NONE);
		specificWhatButton.setImage(ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/specificRef.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		specificWhatButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = whatTableViewer.getSelection();
				if(selection != null) {
					if(selection instanceof IStructuredSelection && !selection.isEmpty()) {

						ISelection forSelection = forTreeViewer.getSelection();
						if(forSelection != null) {
							if(forSelection instanceof ITreeSelection) {

								AbstractSelection selectionItem = (AbstractSelection)((ITreeSelection)forSelection).getFirstElement();
								if(selectionItem != null) {

									EReference eReference = (EReference)((IStructuredSelection)selection).getFirstElement();

									Object value = selectionItem.getElement().eGet(eReference);

									List<EObject> valueToShow = new ArrayList<EObject>();
									if(value instanceof List) {
										valueToShow.addAll((Collection<? extends EObject>)value);
									} else if(value instanceof EObject) {
										valueToShow.add((EObject)value);
									}

									ListSelectionDialog dlg = new ListSelectionDialog(getSite().getShell(), valueToShow, new ElementsAvailableContentProvider(), new AdapterFactoryLabelProvider(adapterFactory), Messages.DiagramTemplateEditor_108);
									dlg.setTitle(Messages.DiagramTemplateEditor_109);
									dlg.open();

									Object[] results = dlg.getResult();
									if(results != null) {

										for(Object object : results) {
											if(object instanceof EObject) {

												if(!containsElement((EObject)object, selectionItem.getSelectionRef())) {
													SelectionRef selectionRef = diagramtemplateFactory.createSelectionRef();

													selectionRef.setKind(SelectionKind.SPECIFIC);
													selectionRef.setElement((EObject)object);
													selectionRef.setEReference(eReference);
													selectionRef.setStereotypedBy(""); //$NON-NLS-1$
													selectionRef.setSubTypes(false);

													AddCommand command = new AddCommand(editingDomain, selectionItem, selectionItem.eClass().getEStructuralFeature("selectionRef"), selectionRef); //$NON-NLS-1$
													editingDomain.getCommandStack().execute(command);
												}
											}
										}
									}
								}

							}

							forTreeViewer.refresh();

						}
					}
				}
			}

		});
		specificWhatButton.setText(Messages.DiagramTemplateEditor_112);
		specificWhatButton.setEnabled(false);

		whatTableViewer = new TableViewer(whatPartComposite, SWT.BORDER | SWT.FULL_SELECTION);
		whatTable = whatTableViewer.getTable();
		whatTableViewer.setContentProvider(new WhatContentProvider());
		whatTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		whatTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		//Balance the sashForm
		selectionPartSashForm.setWeights(new int[]{ 1, 1 });
	}

	private void createEditionPart(Composite parent) {
		SashForm editionPartSashForm = new SashForm(parent, SWT.VERTICAL);

		createDiagramInformationPart(editionPartSashForm);
		createSelectionPart(editionPartSashForm);

		//Balance the sashForm
		editionPartSashForm.setWeights(new int[]{ 1, 1 });
	}

	private void createTemplatePart(Composite parent) {
		SashForm templatePartSashForm = new SashForm(parent, SWT.NONE);
		templatePartSashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		createDiagramDefinitionPart(templatePartSashForm);
		createEditionPart(templatePartSashForm);

		//Balance the sashForm
		templatePartSashForm.setWeights(new int[]{ 140, 808 });
	}

	@Override
	public void createPartControl(Composite parent) {

		if(createModel()) {

			parent.setLayout(new GridLayout(1, false));

			createloadPart(parent);
			createTemplatePart(parent);

			//Create the initial diagram definition
			createNewDiagramDefinition();

			if(targetModelResource != null) {
				targetModelPathText.setText(targetModelResource.getURI().toString());
				selectRootButton.setEnabled(true);
				loadModelButton.setEnabled(false);
				specificForButton.setEnabled(true);
				executeButton.setEnabled(true);
			} else {
				clearTemplate();
			}
		}
	}

	@Override
	public void setFocus() {
	}
}
