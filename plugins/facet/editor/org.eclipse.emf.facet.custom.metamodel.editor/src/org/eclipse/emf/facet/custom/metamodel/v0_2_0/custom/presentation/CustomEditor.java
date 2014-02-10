/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.presentation;


import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.provider.CustomItemProviderAdapterFactory;
import org.eclipse.emf.facet.custom.sdk.ui.dialog.ICustomizationDialogFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.provider.ExtensibleItemProviderAdapterFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.provider.EFacetItemProviderAdapterFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.provider.QueryItemProviderAdapterFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.provider.RuntimeItemProviderAdapterFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.provider.SerializationItemProviderAdapterFactory;
import org.eclipse.emf.facet.efacet.sdk.ui.dialog.IFacetDialogFactory;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;


/**
 * This is an example of a Custom model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomEditor
extends EditorPart
implements IGotoMarker, ISelectionProvider, IMenuListener, IEditingDomainProvider, IViewerProvider {

	protected Customization mainCustomization;

	protected ComposedAdapterFactory adapterFactory;

	protected CustomViewer customizationViewer;

	/**
	 * Resources that have been changed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been removed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * This listens to which ever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to this editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * Controls whether the problem indication should be updated.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * This is the content outline page's viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is a kludge...
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * Map to store the diagnostic associated with a resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented
	 * in Eclipse's Problems View.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	/**
	 * This is the property sheet page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySheetPage propertySheetPage;

	/**
	 * This is the content outline page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	protected Composite buttonsPaneComposite;

	private static final int VERTICAL_SPACE_BETWEEN_BUTTON_GROUPS = 30;
	private static final int VERTICAL_SPACE_BEFORE_FIRST_BUTTON = 10;
	public static final String ID = "org.eclipse.emf.facet.infra.browser.custom.editor"; //$NON-NLS-1$
	private static final int MAIN_FORM_MARGIN_WIDTH = 4;
	private static final int MAIN_FORM_MARGIN_HEIGHT = 6;
	private static final int LEFT_PANE_SASH_WEIGHT = 400;
	private static final int RIGHT_PANE_SASH_WEIGHT = 600;

	private TreeViewer selectionViewer;
	private Button btnEdit;
	private Button btnRemove;
	private Button btnUp;
	private Button btnDown;
	private Button cbAppliesToSubinstances;
	private FormToolkit toolkit;
	private boolean readOnly;

	protected int listenerCounter = 0;

	private Form fForm;
	private AdapterFactoryEditingDomain editingDomain;

	public CustomEditor() {
		super();
		initializeEditingDomain();
	}

	/**
	 * This sets up the editing domain for the model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CustomItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EFacetItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SerializationItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ExtensibleItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new QueryItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new RuntimeItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
		(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getSite().getShell().getDisplay().asyncExec
				(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);
						//setDirty(commandStack.isSaveNeeded());
						// Try to select the affected objects.
						//
						Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
						if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
							propertySheetPage.refresh();
						}
					}
				});
			}
		});

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		setSite(site);
		setInputWithNotify(input);
		setPartName(input.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable =
					new Runnable() {
				public void run() {
					// Try to select the items in the current content viewer of the editor.
					//
					if (selectionViewer != null) {
						selectionViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
					}
				}
			};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	@Override
	public void createPartControl(final Composite parent) {
		java.net.URI locationURI;
		String fileName = ""; //$NON-NLS-1$
		final IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			final IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
			try {
				if (fileEditorInput.getFile().exists()) {
					locationURI = new java.net.URI(URI.createPlatformResourceURI(
							fileEditorInput.getFile().getFullPath().toString(), true).toString());
				} else {
					locationURI = fileEditorInput.getFile().getLocationURI();
				}
			} catch (URISyntaxException e) {
				locationURI = fileEditorInput.getFile().getLocationURI();
			}
			fileName = fileEditorInput.getFile().getName();
		} else if (editorInput instanceof URIEditorInput) {
			final URIEditorInput uriEditorInput = (URIEditorInput) editorInput;
			try {
				locationURI = new java.net.URI(uriEditorInput.getURI().toString());
			} catch (final URISyntaxException e) {
				throw new IllegalArgumentException(e);
			}
			fileName = new Path(locationURI.getPath()).lastSegment();
		} else {
			throw new IllegalStateException("wrong kind of input: " //$NON-NLS-1$
					+ editorInput.getClass().getName());
		}

		loadResource(org.eclipse.emf.common.util.URI.createURI(locationURI.toString()));
		setPartName(fileName);

		createContents(parent);

		this.selectionViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				if(listenerCounter == 0){
					ISelection eventSelection = event.getSelection();
					setSelection(eventSelection);
					final ITreeSelection selection = (ITreeSelection) CustomEditor.this.selectionViewer
							.getSelection();
					listenerCounter++;
					CustomEditor.this.handleSelectionViewerSelectionChanged(selection.getFirstElement());
					listenerCounter = 0;
					CustomEditor.this.customizationViewer.getViewer().getControl()
					.setRedraw(false);
					CustomEditor.this.customizationViewer.getViewer().expandAll();
					CustomEditor.this.customizationViewer.getViewer().getControl()
					.setRedraw(true);
				}else {
					listenerCounter = 0;
				}
			}
		});

		setSelection(selectionViewer == null ? StructuredSelection.EMPTY : selectionViewer.getSelection());
	}

	public void loadResource(URI resourceURI) {
		Exception exception = null;
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			//
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}
		this.mainCustomization = (Customization) resource.getContents().get(0);
	}

	private void createContents(final Composite parent) {
		this.toolkit = new FormToolkit(parent.getDisplay());
		this.fForm = this.toolkit.createForm(parent);
		this.toolkit.decorateFormHeading(this.fForm);

		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginWidth = CustomEditor.MAIN_FORM_MARGIN_WIDTH;
		fillLayout.marginHeight = CustomEditor.MAIN_FORM_MARGIN_HEIGHT;
		this.fForm.getBody().setLayout(fillLayout);
		createBottomPane(this.fForm.getBody());
	}

	protected IResourceChangeListener resourceChangeListener =
			new IResourceChangeListener() {

		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
					protected ResourceSet resourceSet = editingDomain.getResourceSet();
					protected Collection<Resource> changedResources = new ArrayList<Resource>();
					protected Collection<Resource> removedResources = new ArrayList<Resource>();

					public boolean visit(IResourceDelta delta) {
						if (delta.getResource().getType() == IResource.FILE) {
							if (delta.getKind() == IResourceDelta.REMOVED ||
									delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS) {
								Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
								if (resource != null) {
									if (delta.getKind() == IResourceDelta.REMOVED) {
										removedResources.add(resource);
									}
									else if (!savedResources.remove(resource)) {
										changedResources.add(resource);
									}
								}
							}
						}

						return true;
					}

					public Collection<Resource> getChangedResources() {
						return changedResources;
					}

					public Collection<Resource> getRemovedResources() {
						return removedResources;
					}
				}

				final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);

				if (!visitor.getRemovedResources().isEmpty()) {
					getSite().getShell().getDisplay().asyncExec
					(new Runnable() {
						public void run() {
							removedResources.addAll(visitor.getRemovedResources());
							if (!isDirty()) {
								getSite().getPage().closeEditor(CustomEditor.this, false);
							}
						}
					});
				}

				if (!visitor.getChangedResources().isEmpty()) {
					getSite().getShell().getDisplay().asyncExec
					(new Runnable() {
						public void run() {
							changedResources.addAll(visitor.getChangedResources());
							if (getSite().getPage().getActiveEditor() == CustomEditor.this) {
								handleActivate();
							}
						}
					});
				}
			}
			catch (CoreException exception) {
				CustomEditorPlugin.INSTANCE.log(exception);
			}
		}
	};

	private Composite rightPaneComposite;

	private Composite createBottomPane(final Composite parent) {
		final SashForm sashForm = new FormStyleSashForm(parent, SWT.HORIZONTAL, this.toolkit) {
			@Override
			protected void createContents() {
				createLeftPane(this);
				createRightPane(this);
			}
		};

		sashForm.setWeights(new int[] { CustomEditor.LEFT_PANE_SASH_WEIGHT,
				CustomEditor.RIGHT_PANE_SASH_WEIGHT 
		});
		sashForm.setSashWidth(5);

		return sashForm;
	}

	private void createLeftPane(final Composite parent) {
		
		ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), CustomEditor.this) {
			@Override
			public Viewer createViewer(Composite composite) {
				Tree tree = new Tree(composite, SWT.MULTI);
				TreeViewer newTreeViewer = new TreeViewer(tree);
				return newTreeViewer;
			}
		};
		viewerPane.createControl(parent);

		selectionViewer = (TreeViewer)viewerPane.getViewer();
		selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

		selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		selectionViewer.setInput(editingDomain.getResourceSet());
		selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
		viewerPane.setTitle(editingDomain.getResourceSet());

		new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

		createContextMenuFor(selectionViewer);
	}

	/** Right pane : treeviewer + fixed buttons pane */

	private Composite createRightPane(final Composite parent) {
		final Section section = this.toolkit.createSection(parent, ExpandableComposite.TITLE_BAR
				| ExpandableComposite.EXPANDED);

		this.rightPaneComposite = this.toolkit.createComposite(section, SWT.NONE);
		section.setClient(rightPaneComposite);

		final GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		rightPaneComposite.setLayout(gridLayout);

		// tree + bottom options
		final Composite middle = new Composite(rightPaneComposite, SWT.NONE);
		final GridLayout middleLayout = new GridLayout();
		middleLayout.marginHeight = 0;
		middleLayout.marginWidth = 0;
		middle.setLayout(middleLayout);
		middle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.customizationViewer = new CustomViewer(middle);
		this.customizationViewer.getViewer().getControl()
		.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final Composite optionsPane = this.toolkit.createComposite(middle);
		optionsPane.setLayout(new GridLayout());
		optionsPane.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		this.customizationViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				if(listenerCounter == 0){
				ISelection eventSelection = event.getSelection();
				setSelection(eventSelection);
				final ITreeSelection selection = (ITreeSelection) CustomEditor.this.customizationViewer
						.getSelection();
				CustomEditor.this.handleCustomzizationViewerSelectionChanged(selection.getFirstElement());
				listenerCounter++;
			}else{
				listenerCounter = 0;
			}
			}
		});

		if (this.readOnly) {
			this.cbAppliesToSubinstances.setEnabled(false);
		}

		final GridData customizationViewerGridData = new GridData();
		customizationViewerGridData.grabExcessHorizontalSpace = true;
		customizationViewerGridData.grabExcessVerticalSpace = true;
		customizationViewerGridData.horizontalAlignment = SWT.FILL;
		customizationViewerGridData.verticalAlignment = SWT.FILL;
		this.customizationViewer.getViewer().getControl()
		.setLayoutData(customizationViewerGridData);

		if (!this.readOnly) {
			createButtonsPane(rightPaneComposite);
		}


		return rightPaneComposite;
	}
	
	private void setInputInCustomizationTreeviewer(Facet facet){
		List<DerivedTypedElement> inputs = new ArrayList<DerivedTypedElement>();
		inputs.addAll(facet.getFacetOperations());
		EList<EStructuralFeature> facetElements = facet.getFacetElements();
		for (EStructuralFeature eStructuralFeature : facetElements) {
			if(eStructuralFeature instanceof DerivedTypedElement){
				inputs.add((DerivedTypedElement) eStructuralFeature);
			}
		}
		this.customizationViewer.setInput(inputs);
	}
	
	private void handleSelectionViewerSelectionChanged(final Object selectedElement) {
		if (selectedElement instanceof EClassCustomization || selectedElement instanceof FacetCustomization) {
			final Facet facet = (Facet) selectedElement;


			setInputInCustomizationTreeviewer(facet);
			buttonsPaneComposite.dispose();
			createButtonsPaneWhenFacetIsSelected(rightPaneComposite);
			rightPaneComposite.layout();
		}else if(selectedElement instanceof Customization){
			buttonsPaneComposite.dispose();
			createButtonsPaneWhenCustomizationIsSelected(rightPaneComposite);
			rightPaneComposite.layout();
		}
		else if(selectedElement instanceof DerivedTypedElement){
			buttonsPaneComposite.dispose();
			createButtonsPaneWhenDerivedIsSelected(rightPaneComposite);
			rightPaneComposite.layout();
			

			//Update customViewer input
			DerivedTypedElement derivedTypeElement = (DerivedTypedElement)selectedElement;
			Facet facet = (Facet)derivedTypeElement.eContainer();
			List<DerivedTypedElement> inputs = new ArrayList<DerivedTypedElement>();
			inputs.addAll(facet.getFacetOperations());
			EList<EStructuralFeature> facetElements = facet.getFacetElements();
			for (EStructuralFeature eStructuralFeature : facetElements) {
				if(eStructuralFeature instanceof DerivedTypedElement){
					inputs.add((DerivedTypedElement) eStructuralFeature);
				}
			}
			this.customizationViewer.setInput(inputs);
			this.customizationViewer.getViewer().setSelection(getSelection(), true);
			
			
		}
	}
	
	private void handleCustomzizationViewerSelectionChanged(final Object selectedElement) {
		setSelection(this.customizationViewer.getViewer().getSelection());
		
		if (selectedElement instanceof FacetOperation|| selectedElement instanceof FacetElement) {
			buttonsPaneComposite.dispose();
			createButtonsPaneWhenDerivedIsSelected(rightPaneComposite);
			rightPaneComposite.layout();
		}
	}
	
	private void btnEditClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if(selectedElement instanceof TreeSelection){
			final Object selectedObject = ((TreeSelection)selectedElement).getFirstElement();
			if(selectedObject != null){
				if (selectedObject instanceof Facet) {
					IFacetDialogFactory.INSTANCE.openEditFacetDialog();
				}else if(selectedObject instanceof FacetAttribute){
					IFacetDialogFactory.INSTANCE.openEditFacetAttributeDialog();
				}else if(selectedObject instanceof FacetOperation){
					IFacetDialogFactory.INSTANCE.openEditFacetOperationDialog();
				}else if(selectedObject instanceof FacetReference){
					IFacetDialogFactory.INSTANCE.openEditFacetReferenceDialog();
				}else if(selectedObject instanceof DerivedTypedElement){
					IFacetDialogFactory.INSTANCE.openEditFacetOperationParameterDialog();
				}else if(selectedObject instanceof Customization){
					ICustomizationDialogFactory.DEFAULT.openAddCustomizationPropertyDialog(getSite().getShell().getDisplay(), editingDomain);
				}
			}
		}
	}
	
	@Override
	public void doSave(final IProgressMonitor monitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : editingDomain.getResourceSet().getResources()) {
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
						try {
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if (resource.getTimeStamp() != timeStamp) {
								savedResources.add(resource);
							}
						}
						catch (Exception exception) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};

		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			CustomEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}

	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		}
		catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {
				@Override
				public void createControl(Composite parent) {
					super.createControl(parent);
					contentOutlineViewer = getTreeViewer();
					contentOutlineViewer.addSelectionChangedListener(this);

					// Set up the tree viewer.
					//
					contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
					contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
					contentOutlineViewer.setInput(editingDomain.getResourceSet());

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
						// Select the root object in the view.
						//
						contentOutlineViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
					}
				}

				@Override
				public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
					super.makeContributions(menuManager, toolBarManager, statusLineManager);
					contentOutlineStatusLineManager = statusLineManager;
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			}

			contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage.addSelectionChangedListener
			(new ISelectionChangedListener() {
				// This ensures that we handle selections correctly.
				//
				public void selectionChanged(SelectionChangedEvent event) {
					handleContentOutlineSelection(event.getSelection());
				}
			});
		}

		return contentOutlinePage;
	}

	/**
	 * This accesses a cached version of the property sheet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage =
					new ExtendedPropertySheetPage(editingDomain) {
				@Override
				public void setSelectionToViewer(List<?> selection) {
					CustomEditor.this.setSelectionToViewer(selection);
					CustomEditor.this.setFocus();
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			};
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		}

		return propertySheetPage;
	}

	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return showOutlineView() ? getContentOutlinePage() : null;
		}
		else if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else if (key.equals(IGotoMarker.class)) {
			return this;
		}
		else {
			return super.getAdapter(key);
		}
	}

	/**
	 * Returns whether the outline view should be presented to the user.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean showOutlineView() {
		return true;
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the same selection as this selection.
				//
				ArrayList<Object> selectionList = new ArrayList<Object>();
				selectionList.add(selectedElement);
				while (selectedElements.hasNext()) {
					selectionList.add(selectedElements.next());
				}

				// Set the selection to the widget.
				//
				selectionViewer.setSelection(new StructuredSelection(selectionList));

			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor =
				getActionBars().getStatusLineManager() != null ?
						getActionBars().getStatusLineManager().getProgressMonitor() :
							new NullProgressMonitor();
						doSave(progressMonitor);
	}
	//
	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command stack.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
	//
	@Override
	public void setFocus() {
		// nothing
	}

	@Override
	public void dispose() {
		updateProblemIndication = false;

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}

		if (contentOutlinePage != null) {
			contentOutlinePage.dispose();
		}

		super.dispose();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER)) {
				String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
					if (eObject != null) {
						setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
					}
				}
			}
		}
		catch (CoreException exception) {
			CustomEditorPlugin.INSTANCE.log(exception);
		}
	}
	//
	private final IPartListener partListener = 
			new IPartListener() {
		public void partActivated(IWorkbenchPart p) {
			if (p instanceof ContentOutline) {
				if (((ContentOutline)p).getCurrentPage() == contentOutlinePage) {
					getActionBarContributor().setActiveEditor(CustomEditor.this);

					if (selectionChangedListener == null) {
						// Create the listener on demand.
						//
						selectionChangedListener =
								new ISelectionChangedListener() {
							// This just notifies those things that are affected by the section.
							//
							public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
								setSelection(selectionChangedEvent.getSelection());
							}
						};
					}
					setSelection(selectionViewer == null ? StructuredSelection.EMPTY : selectionViewer.getSelection());
				}
			}
			else if (p instanceof PropertySheet) {
				if (((PropertySheet)p).getCurrentPage() == propertySheetPage) {
					getActionBarContributor().setActiveEditor(CustomEditor.this);
					handleActivate();
				}
			}
			else if (p == CustomEditor.this) {
				handleActivate();
				if (selectionChangedListener == null) {
					// Create the listener on demand.
					//
					selectionChangedListener =
							new ISelectionChangedListener() {
						// This just notifies those things that are affected by the section.
						//
						public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
							setSelection(selectionChangedEvent.getSelection());
						}
					};
				}
				selectionViewer.addSelectionChangedListener(selectionChangedListener);
				setSelection(selectionViewer.getSelection());
			}
		}
		public void partBroughtToTop(IWorkbenchPart p) {
			// Ignore.
		}
		public void partClosed(IWorkbenchPart p) {
			// Ignore.
		}
		public void partDeactivated(IWorkbenchPart p) {
			// Ignore.
		}
		public void partOpened(IWorkbenchPart p) {
			// Ignore.
		}
	};

	private Button btnAddFacetSet;

	private Button btnAddFacet;

	private Button btnAddEClassCustom;

	private Button btnAddFacetCustom;

	private Button btnAddFacetAttr;

	private Button btnAddFacetRef;

	private Button btnAddFacetOp;

	private Button btnAddFacetParam;

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISelection getSelection() {
		return editorSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = selectionViewer != null && selectionViewer == contentOutlineViewer ?
				contentOutlineStatusLineManager : getActionBars().getStatusLineManager();

		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection)selection).toList();
				switch (collection.size()) {
				case 0: {
					statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
					break;
				}
				case 1: {
					String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
					statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
					break;
				}
				default: {
					statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
					break;
				}
				}
			}
			else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's overall selection.
	 * Calling this result will notify the listeners.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
		setStatusLineManager(selection);
	}

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource
	 * and the specified exception (if any).
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic =
					new BasicDiagnostic
					(Diagnostic.ERROR,
							"org.eclipse.emf.facet.custom.metamodel.editor",
							0,
							getString("_UI_CreateModelError_message", resource.getURI()),
							new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null) {
			return
					new BasicDiagnostic
					(Diagnostic.ERROR,
							"org.eclipse.emf.facet.custom.metamodel.editor",
							0,
							getString("_UI_CreateModelError_message", resource.getURI()),
							new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	/**
	 * Handles activation of the editor or it's associated views.
	 */
	protected void handleActivate() {
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
			editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
			setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(CustomEditor.this, false);
			}
			else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		}
		else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	}

	/** Shows a dialog that asks if conflicting changes should be discarded. */
	protected boolean handleDirtyConflict() {
		return MessageDialog.openQuestion(getSite().getShell(),
				"CustomEditor_fileConflict",
				"CustomEditor_conflictingUnsavedChanges");
	}

	/**
	 * Updates the problems indication with the information described in the specified diagnostic.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void updateProblemIndication() {
		if (updateProblemIndication) {
			BasicDiagnostic diagnostic =
					new BasicDiagnostic
					(Diagnostic.OK,
							"org.eclipse.emf.facet.custom.metamodel.editor",
							0,
							null,
							new Object [] { editingDomain.getResourceSet() });
			for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
				if (childDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(childDiagnostic);
				}
			}

			if (diagnostic.getSeverity() != Diagnostic.OK) {
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(markerHelper);
			}

			if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
				markerHelper.deleteMarkers(editingDomain.getResourceSet());
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					try {
						markerHelper.createMarkers(diagnostic);
					}
					catch (CoreException exception) {
						CustomEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
	}

	/** Handles what to do with changed resources on activation. */
	protected void handleChangedResources() {
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
			if (isDirty()) {
				changedResources.addAll(editingDomain.getResourceSet().getResources());
			}
			editingDomain.getCommandStack().flush();

			updateProblemIndication = false;
			for (Resource resource : changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					}
					catch (IOException exception) {
						if (!resourceToDiagnosticMap.containsKey(resource)) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
					}
				}
			}

			if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
				setSelection(StructuredSelection.EMPTY);
			}

			updateProblemIndication = true;
			updateProblemIndication();
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key) {
		return CustomEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return CustomEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	private Object buttonsGridData() {
		final GridData buttonsGridData = new GridData();
		buttonsGridData.grabExcessHorizontalSpace = true;
		buttonsGridData.grabExcessVerticalSpace = false;
		buttonsGridData.horizontalAlignment = SWT.FILL;
		buttonsGridData.verticalAlignment = SWT.FILL;
		return buttonsGridData;
	}

	private Composite createButtonsPane(final Composite parent){
		return createButtonsPaneWhenCustomizationIsSelected(parent);
	}

	private Composite createButtonsPaneWhenCustomizationIsSelected(final Composite parent) {
		this.buttonsPaneComposite = new Composite(parent, SWT.NONE);
		final GridData buttonsPaneGridData = new GridData();
		buttonsPaneGridData.grabExcessHorizontalSpace = false;
		buttonsPaneGridData.grabExcessVerticalSpace = true;
		buttonsPaneGridData.horizontalAlignment = SWT.FILL;
		buttonsPaneGridData.verticalAlignment = SWT.FILL;
		buttonsPaneComposite.setLayoutData(buttonsPaneGridData);

		buttonsPaneComposite.setLayout(new GridLayout());

		final Composite spacer1 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer1GridData = new GridData();
		spacer1GridData.heightHint = CustomEditor.VERTICAL_SPACE_BEFORE_FIRST_BUTTON;
		spacer1.setLayoutData(spacer1GridData);

		final Composite spacer2 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer2GridData = new GridData();
		spacer2GridData.heightHint = CustomEditor.VERTICAL_SPACE_BETWEEN_BUTTON_GROUPS;
		spacer2.setLayoutData(spacer2GridData);

		final Label lblConditions = new Label(buttonsPaneComposite, SWT.NONE);
		lblConditions.setText("add");

		this.btnAddFacetSet = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacetSet.setText("FacetSet");
		this.btnAddFacetSet.setLayoutData(buttonsGridData());
		this.btnAddFacetSet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddFacetSetClicked();
			}
		});

		this.btnAddFacet = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacet.setText("Facet");
		this.btnAddFacet.setLayoutData(buttonsGridData());
		this.btnAddFacet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddFacetClicked();
			}
		});

		this.btnAddEClassCustom = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddEClassCustom.setText("EClassCustom");
		this.btnAddEClassCustom.setLayoutData(buttonsGridData());
		this.btnAddEClassCustom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddECLassCustomClicked();
			}
		});

		this.btnAddFacetCustom = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacetCustom.setText("FacetCustom");
		this.btnAddFacetCustom.setLayoutData(buttonsGridData());
		this.btnAddFacetCustom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddFacetCustomClicked();
			}
		});

		return buttonsPaneComposite;
	}

	protected void btnRemoveClicked() {
		if (this.readOnly) {
			return;
		}
		final TreeSelection selectedElement = (TreeSelection)getSelection();
		final Object selectedObject = selectedElement.getFirstElement();
		if (selectedObject instanceof EObject) {
			final EObject eObject = (EObject) selectedObject;
			final EObject eContainer = eObject.eContainer();
			
			if(eContainer instanceof Customization){
				
					Command command = RemoveCommand.create(this.editingDomain,
							eContainer,
							EcorePackage.eINSTANCE.getEPackage_EClassifiers(),
							eObject);
					this.editingDomain.getCommandStack().execute(command);
				//refresh();
			}else if(eContainer instanceof Facet){
				if(selectedObject instanceof FacetOperation){
					Command command = RemoveCommand.create(this.editingDomain,
								eContainer,
								EFacetPackage.eINSTANCE.getFacet_FacetOperations(),
								eObject);
						this.editingDomain.getCommandStack().execute(command);

						setInputInCustomizationTreeviewer((Facet)eContainer);
						this.customizationViewer.getViewer().refresh();
					
				}else if(selectedObject instanceof FacetAttribute || selectedObject instanceof FacetReference){
					Command command = RemoveCommand.create(this.editingDomain,
								eContainer,
								EFacetPackage.eINSTANCE.getFacet_FacetElements(),
								eObject);
						this.editingDomain.getCommandStack().execute(command);

						setInputInCustomizationTreeviewer((Facet)eContainer);
						this.customizationViewer.getViewer().refresh();
				}
			}else if(eContainer instanceof FacetOperation){
				Command command = RemoveCommand.create(this.editingDomain,
							eContainer,
							EcorePackage.eINSTANCE.getEOperation_EParameters(),
							eObject);
					this.editingDomain.getCommandStack().execute(command);

					setInputInCustomizationTreeviewer((Facet)eContainer);
					this.customizationViewer.getViewer().refresh();
				
			}
			
		}
	}

	protected void btnDownClicked() {
		if (this.readOnly) {
			return;
		}
		final TreeSelection selectedElement = (TreeSelection)getSelection();
		final Object selectedObject = selectedElement.getFirstElement();
		if (selectedObject instanceof EObject) {
			final EObject eObject = (EObject) selectedObject;
			final EObject eContainer = eObject.eContainer();
			
			if(eContainer instanceof Customization){
				EList<EClassifier>list = ((Customization)eContainer).getEClassifiers();
				final int index = list.indexOf(eObject);
				if (index + 1 < list.size()) {
					Command command = MoveCommand.create(this.editingDomain,
							eContainer,
							EcorePackage.eINSTANCE.getEPackage_EClassifiers(),
							list.get(index), index + 1);
					this.editingDomain.getCommandStack().execute(command);
				}
				//refresh();
			}else if(eContainer instanceof Facet){
				if(selectedObject instanceof FacetOperation){
					EList<FacetOperation>list = ((Facet)eContainer).getFacetOperations();
					final int index = list.indexOf(eObject);
					if (index + 1 < list.size()) {
						Command command = MoveCommand.create(this.editingDomain,
								eContainer,
								EFacetPackage.eINSTANCE.getFacet_FacetOperations(),
								list.get(index), index + 1);
						this.editingDomain.getCommandStack().execute(command);

						setInputInCustomizationTreeviewer((Facet)eContainer);
						this.customizationViewer.getViewer().refresh();
					}
				}else if(selectedObject instanceof FacetAttribute || selectedObject instanceof FacetReference){
					EList<EStructuralFeature>list = ((Facet)eContainer).getFacetElements();
					final int index = list.indexOf(eObject);
					if (index + 1 < list.size()) {
						Command command = MoveCommand.create(this.editingDomain,
								eContainer,
								EFacetPackage.eINSTANCE.getFacet_FacetElements(),
								list.get(index), index + 1);
						this.editingDomain.getCommandStack().execute(command);

						setInputInCustomizationTreeviewer((Facet)eContainer);
						this.customizationViewer.getViewer().refresh();
					}
				}
			}else if(eContainer instanceof FacetOperation){
				EList<EParameter>list = ((FacetOperation)eContainer).getEParameters();
				final int index = list.indexOf(eObject);
				if (index + 1 < list.size()) {
					Command command = MoveCommand.create(this.editingDomain,
							eContainer,
							EcorePackage.eINSTANCE.getEOperation_EParameters(),
							list.get(index), index + 1);
					this.editingDomain.getCommandStack().execute(command);

					setInputInCustomizationTreeviewer((Facet)eContainer);
					this.customizationViewer.getViewer().refresh();
				}
			}
			
		}
	}

	protected void btnUpClicked() {
		if (this.readOnly) {
			return;
		}
		final TreeSelection selectedElement = (TreeSelection)getSelection();
		final Object selectedObject = selectedElement.getFirstElement();
		if (selectedObject instanceof EObject) {
			final EObject eObject = (EObject) selectedObject;
			final EObject eContainer = eObject.eContainer();
			
			if(eContainer instanceof Customization){
				EList<EClassifier>list = ((Customization)eContainer).getEClassifiers();
				final int index = list.indexOf(eObject);
				if (index - 1 >= 0) {
					Command command = MoveCommand.create(this.editingDomain,
							eContainer,
							EcorePackage.eINSTANCE.getEPackage_EClassifiers(),
							list.get(index), index - 1);
					this.editingDomain.getCommandStack().execute(command);
				}
				//refresh();
			}else if(eContainer instanceof Facet){
				if(selectedObject instanceof FacetOperation){
					EList<FacetOperation>list = ((Facet)eContainer).getFacetOperations();
					final int index = list.indexOf(eObject);
					if (index - 1 >= 0) {
						Command command = MoveCommand.create(this.editingDomain,
								eContainer,
								EFacetPackage.eINSTANCE.getFacet_FacetOperations(),
								list.get(index), index - 1);
						this.editingDomain.getCommandStack().execute(command);

						setInputInCustomizationTreeviewer((Facet)eContainer);
						this.customizationViewer.getViewer().refresh();
					}
				}else if(selectedObject instanceof FacetAttribute || selectedObject instanceof FacetReference){
					EList<EStructuralFeature>list = ((Facet)eContainer).getFacetElements();
					final int index = list.indexOf(eObject);
					if (index - 1 >= 0) {
						Command command = MoveCommand.create(this.editingDomain,
								eContainer,
								EFacetPackage.eINSTANCE.getFacet_FacetElements(),
								list.get(index), index - 1);
						this.editingDomain.getCommandStack().execute(command);

						setInputInCustomizationTreeviewer((Facet)eContainer);
						this.customizationViewer.getViewer().refresh();
					}
				}
			}else if(eContainer instanceof FacetOperation){
				EList<EParameter>list = ((FacetOperation)eContainer).getEParameters();
				final int index = list.indexOf(eObject);
				if (index - 1 >= 0) {
					Command command = MoveCommand.create(this.editingDomain,
							eContainer,
							EcorePackage.eINSTANCE.getEOperation_EParameters(),
							list.get(index), index - 1);
					this.editingDomain.getCommandStack().execute(command);

					setInputInCustomizationTreeviewer((Facet)eContainer);
					this.customizationViewer.getViewer().refresh();
				}
			}
			
		}
		
	}

	protected void btnAddFacetCustomClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Customization) {
			ICustomizationDialogFactory.DEFAULT.openCreateFacetCustomizationDialog(getSite().getShell().getDisplay(), editingDomain);
		}

	}

	protected void btnAddECLassCustomClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Customization) {
			ICustomizationDialogFactory.DEFAULT.openCreateEClassCustomizationDialog(getSite().getShell().getDisplay(), editingDomain);
		}

	}

	protected void btnAddFacetClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Customization) {
			IFacetDialogFactory.INSTANCE.openCreateFacetInFacetSetDialog();
		}
	}

	protected void btnAddFacetSetClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Customization) {
			IFacetDialogFactory.INSTANCE.openCreateFacetSetInFacetSetDialog();
		}
	}

	private Composite createButtonsPaneWhenFacetIsSelected(final Composite parent) {
		this.buttonsPaneComposite = new Composite(parent, SWT.NONE);
		final GridData buttonsPaneGridData = new GridData();
		buttonsPaneGridData.grabExcessHorizontalSpace = false;
		buttonsPaneGridData.grabExcessVerticalSpace = true;
		buttonsPaneGridData.horizontalAlignment = SWT.FILL;
		buttonsPaneGridData.verticalAlignment = SWT.FILL;
		buttonsPaneComposite.setLayoutData(buttonsPaneGridData);

		buttonsPaneComposite.setLayout(new GridLayout());

		final Composite spacer1 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer1GridData = new GridData();
		spacer1GridData.heightHint = CustomEditor.VERTICAL_SPACE_BEFORE_FIRST_BUTTON;
		spacer1.setLayoutData(spacer1GridData);

		final Composite spacer2 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer2GridData = new GridData();
		spacer2GridData.heightHint = CustomEditor.VERTICAL_SPACE_BETWEEN_BUTTON_GROUPS;
		spacer2.setLayoutData(spacer2GridData);

		final Label lblConditions = new Label(buttonsPaneComposite, SWT.NONE);
		lblConditions.setText("add");

		this.btnAddFacetAttr = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacetAttr.setText("Facet Attribute");
		this.btnAddFacetAttr.setLayoutData(buttonsGridData());
		this.btnAddFacetAttr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddFacetAttributeClicked();
			}
		});

		this.btnAddFacetRef = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacetRef.setText("Facet Reference");
		this.btnAddFacetRef.setLayoutData(buttonsGridData());
		this.btnAddFacetRef.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddFacetReferenceClicked();
			}
		});

		this.btnAddFacetOp = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacetOp.setText("Facet Operation");
		this.btnAddFacetOp.setLayoutData(buttonsGridData());
		this.btnAddFacetOp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddFacetOperationClicked();
			}
		});

		final Composite spacer3 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer3GridData = new GridData();
		spacer3GridData.heightHint = CustomEditor.VERTICAL_SPACE_BETWEEN_BUTTON_GROUPS;
		spacer3.setLayoutData(spacer2GridData);

		final Label lblEditions = new Label(buttonsPaneComposite, SWT.NONE);
		lblEditions.setText("edit");

		this.btnEdit = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnEdit.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_edit"));
		this.btnEdit.setLayoutData(buttonsGridData());
		this.btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnEditClicked();
			}
		});

		this.btnRemove = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnRemove.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_remove"));
		this.btnRemove.setLayoutData(buttonsGridData());
		this.btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnRemoveClicked();
			}
		});

		this.btnUp = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnUp.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_up"));
		this.btnUp.setLayoutData(buttonsGridData());
		this.btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnUpClicked();
			}
		});

		this.btnDown = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnDown.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_down"));
		this.btnDown.setLayoutData(buttonsGridData());
		this.btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnDownClicked();
			}
		});

		return buttonsPaneComposite;
	}

	protected void btnAddFacetOperationClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Facet) {
			IFacetDialogFactory.INSTANCE.openAddOperationInFacetDialog();
		}

	}

	protected void btnAddFacetReferenceClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Facet) {
			IFacetDialogFactory.INSTANCE.openAddReferenceInFacetDialog();
		}
	}

	protected void btnAddFacetAttributeClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if (((TreeSelection)selectedElement).getFirstElement() instanceof Facet) {
			IFacetDialogFactory.INSTANCE.openAddAttributeInFacetDialog();
		}
	}

	private Composite createButtonsPaneWhenDerivedIsSelected(final Composite parent) {
		this.buttonsPaneComposite = new Composite(parent, SWT.NONE);
		final GridData buttonsPaneGridData = new GridData();
		buttonsPaneGridData.grabExcessHorizontalSpace = false;
		buttonsPaneGridData.grabExcessVerticalSpace = true;
		buttonsPaneGridData.horizontalAlignment = SWT.FILL;
		buttonsPaneGridData.verticalAlignment = SWT.FILL;
		buttonsPaneComposite.setLayoutData(buttonsPaneGridData);

		buttonsPaneComposite.setLayout(new GridLayout());

		final Composite spacer1 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer1GridData = new GridData();
		spacer1GridData.heightHint = CustomEditor.VERTICAL_SPACE_BEFORE_FIRST_BUTTON;
		spacer1.setLayoutData(spacer1GridData);

		final Composite spacer2 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer2GridData = new GridData();
		spacer2GridData.heightHint = CustomEditor.VERTICAL_SPACE_BETWEEN_BUTTON_GROUPS;
		spacer2.setLayoutData(spacer2GridData);

		final Label lblConditions = new Label(buttonsPaneComposite, SWT.NONE);
		lblConditions.setText("add");

		this.btnAddFacetParam = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnAddFacetParam.setText("Parameter");
		this.btnAddFacetParam.setLayoutData(buttonsGridData());
		this.btnAddFacetParam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnAddParameterClicked();
			}
		});
		
		if(!(((TreeSelection)getSelection()).getFirstElement() instanceof FacetOperation)){
			this.btnAddFacetParam.setEnabled(false);
		}else{
			this.btnAddFacetParam.setEnabled(true);
		}

		final Composite spacer3 = new Composite(buttonsPaneComposite, SWT.NONE);
		final GridData spacer3GridData = new GridData();
		spacer3GridData.heightHint = CustomEditor.VERTICAL_SPACE_BETWEEN_BUTTON_GROUPS;
		spacer3.setLayoutData(spacer2GridData);

		final Label lblEditions = new Label(buttonsPaneComposite, SWT.NONE);
		lblEditions.setText("edit");

		this.btnEdit = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnEdit.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_edit"));
		this.btnEdit.setLayoutData(buttonsGridData());
		this.btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnEditClicked();
			}
		});

		this.btnRemove = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnRemove.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_remove"));
		this.btnRemove.setLayoutData(buttonsGridData());
		this.btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnRemoveClicked();
			}
		});

		this.btnUp = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnUp.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_up"));
		this.btnUp.setLayoutData(buttonsGridData());
		this.btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnUpClicked();
			}
		});

		this.btnDown = new Button(buttonsPaneComposite, SWT.PUSH);
		this.btnDown.setText(CustomEditorPlugin.INSTANCE.getString("CustomizationEditor_down"));
		this.btnDown.setLayoutData(buttonsGridData());
		this.btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				btnDownClicked();
			}
		});

		return buttonsPaneComposite;
	}

	protected void btnAddParameterClicked() {
		if (this.readOnly) {
			return;
		}
		final Object selectedElement = getSelection();
		if(selectedElement instanceof TreeSelection){
			final Object selectedObject = ((TreeSelection)selectedElement).getFirstElement();
			if (selectedObject instanceof FacetOperation) {
				IFacetDialogFactory.INSTANCE.openAddParameterInOperationDialog();
			}
		}
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public Viewer getViewer() {
		return selectionViewer;
	}

	/**
	 * This also changes the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}
	}

}
