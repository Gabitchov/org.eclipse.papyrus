/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.view;

import javax.imageio.spi.ServiceRegistry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainerChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.SashWindowsEventsProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.layers.runtime.ILayersStackApplicationEventListener;
import org.eclipse.papyrus.layers.runtime.LayersStackAndApplicationLifeCycleEventNotifier;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.wb.swt.SWTResourceManager;
import static org.eclipse.papyrus.layers.ui.Activator.log;
import static org.eclipse.papyrus.layers.ui.Activator.log;


/**
 * A view showing a Layers Explorer for the currently selected Papyrus Page.
 * 
 * TODO
 * Refresh the explorer when a LayersStack is added to a diagram.
 * To do that, we need to listen to LayersStack added event. The 
 * notifier is linked to the current LayerModel, thus, we need to track it when the 
 * container change.
 * Each time the container change, we get the attached {@link LayersStackAndApplicationLifeCycleEventNotifier} and
 * we listen to it. Before, we deregister from the old notifier.
 *  
 *  <br>
 *  Events
 *  <ul>
 *    <li>Editor page changed</li>
 *    <li>Container changed - container can be null</li>
 *    <li>LayersStack added</li>
 *    <li>LayersStack removed</li>
 *    <li></li>
 *  </ul>
 *  <br>
 *  State Machine
 *  <ul>
 *    <li>NoContainer</li>
 *    <li>ContainerAndLayersStack</li>
 *    <li>ContainerNoLayerStack</li>
 *    <li></li>
 *    <li></li>
 *  </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class LayersExplorerView extends ViewPart implements ITabbedPropertySheetPageContributor {

	private Label nameLabel;
	private Label containerLabel;
	
	/**
	 * The {@link LayersModel} associated to the current editor. 
	 * Can be null if no Papyrus editor is associated.
	 * Set when the container is changed.
	 */
	private LayersModel currentLayersModel = null;
	
	/**
	 * The {@link ServicesRegistry} associated to the current editor. 
	 * Can be null if no Papyrus editor is associated.
	 * Set when the container is changed.
	 */
	private ServicesRegistry currentServicesRegistry = null;
	
	protected SashWindowsEventsProvider sashEventsProvider;
	
	protected IPageChangedListener pageChangedListener = new IPageChangedListener() {
		
		@Override
		public void pageChanged(IPage newPage) {
			
			setActivePage(newPage);
			
		}
	};
	
	protected ISashWindowsContainerChangedListener containerChangedListener = new ISashWindowsContainerChangedListener() {
		
		@Override
		public void sashWindowsContainerChanged(ISashWindowsContainer newContainer) {

			activeSashWindowContainerChanged(newContainer);
		}
	};
	
	protected TreeViewer layersExplorerTree;
	private DisposeListener disposeListener = new DisposeListener() {
		
		@Override
		public void widgetDisposed(DisposeEvent e) {
			log.info(this.getClass().getName() + " is disposed !!!" + e.widget);
			
		}
	};
	
	protected ISelectionChangedListener selectionChangedListener = new ISelectionChangedListener() {
		
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if(log.isDebugEnabled()) {
				log.debug(LayersExplorerView.this.getClass().getSimpleName() 
						+ ".selectionChanged("+event.getSelection()+")" );
			}
			
			
		}
	};
	
	/**
	 * Current LayersStacke life cycle notifier. This value is changed
	 * when the container change. The value can be null.
	 */
	protected LayersStackAndApplicationLifeCycleEventNotifier currentLayersStackNotifier = null;

	/**
	 * Listen on the current container LayersStack life cycle event.
	 * The observed {@link LayersStackApplication} is changed when the container change.
	 */
	protected ILayersStackApplicationEventListener layersStackLifeCycleEventListener = new ILayersStackApplicationEventListener() {
		
		@Override
		public void layerStackRemoved(Notification msg) {
			refreshLayersExplorerTree();
		}
		
		@Override
		public void layerStackAdded(Notification msg) {
			refreshLayersExplorerTree();
		}
	};


	/**
	 * Constructor.
	 *
	 */
	public LayersExplorerView() {
		super();
	}

	/**
	 * Get the property contributor ID.
	 * This is used by the tabbed properties to identify
	 * wich parts are accepted by a property contributor.
	 * We use Papyrus id.
	 */
	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage"; //$NON-NLS-1$
	}

	/**
	 * Init the view. Called before {@link #createPartControl(Composite)}
	 * 
	 * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite)
	 *
	 * @param site
	 * @throws PartInitException
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
	}
	
	protected void init() {
		
		// Add listeners on container and page changed events
	    sashEventsProvider = new SashWindowsEventsProvider(getSite().getPage());

	    sashEventsProvider.addPageChangedListener(pageChangedListener);
	    sashEventsProvider.addSashWindowsContainerChangedListener(containerChangedListener);

	    // Add listener on LayersStack added or removed event
	    
	    // Set initials values
	    
	    activeSashWindowContainerChanged(sashEventsProvider.activeSashWindowsContainer());
//	    setActivePage(sashEventsProvider.activeSashWindowsPage());
	}
	
	public void dispose() {
		
		super.dispose();
		
		if( sashEventsProvider != null ) {
			sashEventsProvider.removePageChangedListener(pageChangedListener);
			sashEventsProvider.removeSashWindowsContainerChangedListener(containerChangedListener);
			sashEventsProvider = null;
		}
		
	}
	/**
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 *
	 * @param adapter
	 * @return
	 */
	@Override
    public Object getAdapter(Class adapter) {
        if (adapter == IPropertySheetPage.class)
            return new TabbedPropertySheetPage(this);
        return super.getAdapter(adapter);
    }


	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * 
	 */
	protected void createlayersExplorerTreeControl(Composite parent) {
        // Create tree
		
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
//		adapterFactory.addAdapterFactory(new LayersItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new NotationItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
//		AdapterFactory adapterFactory = new LayersItemProviderAdapterFactory();
		layersExplorerTree.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
//		layersExplorerTree.setContentProvider(new MyContentProvider());

		layersExplorerTree.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
//		layersExplorerTree.setLabelProvider(new LabelProvider());
		

	}

/**
 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
 *
 * @param parent
 * 
 * @wbp.parser.entryPoint
 */
	@Override
public void createPartControl(Composite parent) {
	Composite composite = new Composite(parent, SWT.NONE);
	
//	AdapterFactory adapterFactory = new LayersItemProviderAdapterFactory();
    composite.setLayout(new GridLayout(1, false));
    
    Composite headerComposite = new Composite(composite, SWT.BORDER);
    headerComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    headerComposite.setLayout(new GridLayout(2, false));
    
    Label diagramNameLabel = new Label(headerComposite, SWT.NONE);
    diagramNameLabel.setText("Diagram");
    
    nameLabel = new Label(headerComposite, SWT.BORDER);
    GridData gd_nameLabel = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    gd_nameLabel.horizontalIndent = 2;
    nameLabel.setLayoutData(gd_nameLabel);
    nameLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
    nameLabel.setText("Hello World");
    nameLabel.setText("container");
    
    Label containerNameLabel = new Label(headerComposite, SWT.NONE);
    containerNameLabel.setText("Container");
    
    containerLabel = new Label(headerComposite, SWT.BORDER);
    GridData gd_containerLabel = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    gd_containerLabel.horizontalIndent = 2;
    containerLabel.setLayoutData(gd_containerLabel);
    containerLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

    // Create tree
//    layersExplorerTree = LayersTreeViewerFactory.createLayersTreeViewer(composite, SWT.MULTI);
    layersExplorerTree = new TreeViewer(composite, SWT.MULTI /*| SWT.H_SCROLL | SWT.V_SCROLL*/);
    LayersTreeViewerFactory.initContentAndLabelProviders(layersExplorerTree);
    LayersTreeViewerFactory.initContextMenuFor(getSite(), layersExplorerTree);
    Tree tree = layersExplorerTree.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//	createlayersExplorerTreeControl(composite);


	// misc
	parent.addDisposeListener(disposeListener );
	layersExplorerTree.getTree().addDisposeListener(disposeListener );
	
    init();
    
	// Setup properties sheet binding
	getViewSite().setSelectionProvider(layersExplorerTree);
	
	layersExplorerTree.addSelectionChangedListener(selectionChangedListener);
	
	// context menu
//	createContextMenuFor(layersExplorerTree);
}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 *
	 */
	@Override
	public void setFocus() {
		layersExplorerTree.getTree().setFocus();

	}

	/** activeSashWindowContainerChanged
	 * The active {@link ISashWindowsContainer} has changed, reset the internal states accordingly.
	 * 
	 * @param newContainer
	 */
	protected void activeSashWindowContainerChanged(ISashWindowsContainer newContainer) {
		
		if(log.isDebugEnabled()) {
			log.debug("activeSashWindowContainerChanged(" + (newContainer!=null?newContainer:"noContainer") + ")");
		}

		// check if there is a container
		if(newContainer==null) {
			// No container
			currentServicesRegistry = null;
			currentLayersModel = null;
			switchLayersStackLifeCycleEventListener(null);
			setLabels(null);
			setEmptyTreeInput();
			return;
		}
		
		// There is a container
		// Reset states
		currentServicesRegistry = null;
		currentLayersModel = null;
//		currentLayersStackNotifier = null;
		
		try {
			// Compute ServiceRegistry
			currentServicesRegistry = getServiceRegistry();
			// Compute LayersModel
			currentLayersModel = getLayersModel();
		} catch (Exception e) {
			// should not happen, because editor with container always
			// have a registry and models.
			// FIXME log error
			e.printStackTrace();
			// Container, but problems
			currentServicesRegistry = null;
			currentLayersModel = null;
			switchLayersStackLifeCycleEventListener(null);
			setLabels(null);
			setEmptyTreeInput();
			return;

		}
	
		switchLayersStackLifeCycleEventListener(currentLayersModel.getLayersStackLifeCycleEventNotifier());					
		setLabels(newContainer);
		refreshLayersExplorerTree();
		
	}

	/**
	 * Get the LayersModel associated to the ServiceRegistry.
	 * The {@link #currentServicesRegistry} property should have been set
	 * (by {@link #activeSashWindowContainerChanged(ISashWindowsContainer)};
	 * 
	 * 
	 * @return The layersModel
	 * @throws NotFoundException If no LayersModel can be found
	 * @throws ServiceException If {@link ModelSet} can't be found
	 */
	private LayersModel getLayersModel() throws ServiceException, NotFoundException {
		
		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(currentServicesRegistry);
		LayersModel model = (LayersModel)modelSet.getModelChecked(LayersModel.MODEL_ID);

		return model;
	}

	/**
	 * Get the {@link ServiceRegistry} associated to the current IEditorPart found
	 * in the {@link #sashEventsProvider}.
	 * 
	 * @return The associated ServicesRegistry.
	 * 
	 * @throws NotFoundException if the ServicesRegistry can't be found.
	 */
	private ServicesRegistry getServiceRegistry() throws NotFoundException {
		IEditorPart editor = sashEventsProvider.activeSashWindowsContainerOwner();
		if(editor == null) {
			throw new NotFoundException();
		}

		ServicesRegistry registry = (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
		if(registry == null) {
			throw new NotFoundException();
		}
		
		return registry;
	}

	/**
	 * The {@link ISashWindowsContainer} has changed.
	 * Stop listening from the old LayerStackLifeCycleEventProvider, and start listening on the 
	 * new LayerStackLifeCycleEventProvider
	 */
	private void switchLayersStackLifeCycleEventListener(LayersStackAndApplicationLifeCycleEventNotifier newNotifier) {
		
		if( currentLayersStackNotifier != null) {
			currentLayersStackNotifier.removeLayersModelEventListener(layersStackLifeCycleEventListener);
		}		
		
		currentLayersStackNotifier = newNotifier;
		if( currentLayersStackNotifier != null) {
			currentLayersStackNotifier.addLayersModelEventListener(layersStackLifeCycleEventListener);
		}
	}

	/**
	 * @param newPage
	 */
	protected void setActivePage(IPage newPage) {
		setActivePageLabel(newPage);
		refreshLayersExplorerTree();
		
//		if( newPage != null) {
//			System.err.println("setActivePage(" + newPage.getPageTitle() + ")");
//			return;
//		}

	}

	/**
	 * Set the tree input with nothing
	 */
	private void setEmptyTreeInput() {
		setTreeInput(null);
		
	}

	/**
	 * Reset the tree input after a container changed event.
	 */
	protected void resetTreeInput() {

		IEditorPart editor = sashEventsProvider.activeSashWindowsContainerOwner();
		if(editor == null) {
			setEmptyTreeInput();
			return;
		}

		ServicesRegistry registry = (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
		if(registry == null) {
			log.info("New editor has no ServiceRegistry");
			setEmptyTreeInput();
			return;
		}
		ModelSet modelSet;
		try {
			modelSet = ServiceUtils.getInstance().getModelSet(registry);
			LayersModel model = (LayersModel)modelSet.getModelChecked(LayersModel.MODEL_ID);

			Diagram currentDiagram = getCurrentDiagram();
			if(currentDiagram==null) {
				setEmptyTreeInput();
				return;
			}
			
			LayersStackApplication application = model.lookupLayerStackApplication();
			if(application==null) {
				setEmptyTreeInput();
				return;
			}
			
			setTreeInput(application.lookupLayersStackFor(currentDiagram));
			layersExplorerTree.setSelection(new StructuredSelection(model.getLayerStackApplication().getLayersStacks().get(0)), true);

			return;
		} catch (ServiceException e) {
			e.printStackTrace();
			setEmptyTreeInput();
		} catch (NotFoundException e) {
			e.printStackTrace();
			setEmptyTreeInput();
		} catch (org.eclipse.papyrus.layers.stackmodel.NotFoundException e) {
			setEmptyTreeInput();
		}
	}

	/**
	 * Refresh the complete tree
	 */
	public void refreshTreeInput() {
		layersExplorerTree.refresh();
	}
	
	/**
	 * compute the currently selected diagram from the sashEventsProvider state.
	 * 
	 * @return the current diagram or null if there is no diagram.
	 */
	private Diagram getCurrentDiagram() {
		IPage page = sashEventsProvider.activeSashWindowsPage();
		if( ! (page instanceof IEditorPage) 
				|| ! ( ((IEditorPage)page).getIEditorPart() instanceof DiagramDocumentEditor) ) {
			return null;
		}
		
		DiagramDocumentEditor diagramEditor = (DiagramDocumentEditor)((IEditorPage)page).getIEditorPart();

		Diagram diagram = diagramEditor.getDiagram();
		if(diagram == null) {
			return null;			
		}

		return diagram;
	}

	/**
	 * Change the input of the tree
	 * @param layerStackApplication
	 */
	private void setTreeInput(Object input) {
        layersExplorerTree.setInput(input);
	}

	/**
	 * @param newContainer
	 */
	protected void setLabels(ISashWindowsContainer newContainer) {
		if( newContainer != null) {
			containerLabel.setText(newContainer.toString());
			setActivePageLabel(newContainer.getActiveSashWindowsPage());
		}
		else {
			containerLabel.setText("nocontainer");
			setActivePageLabel(null);
		}
	}

	
	/**
	 * @param newContainer
	 */
	protected void setSashWindowContainerLabel(ISashWindowsContainer newContainer) {
		if( newContainer != null) {
			containerLabel.setText(newContainer.toString());
		}
		else {
			containerLabel.setText("nocontainer");
		}
	}

	/**
	 * @param newPage
	 */
	protected void setActivePageLabel(IPage newPage) {
		if( newPage != null ) {
			nameLabel.setText(newPage.getPageTitle());
		}
		else {
			nameLabel.setText("nopage");
		}
	}

	/**
		 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		protected void createContextMenuFor(StructuredViewer viewer) {
			MenuManager contextMenu = new MenuManager("#PopUp");
			contextMenu.add(new Separator("additions"));
			contextMenu.setRemoveAllWhenShown(true);
//			contextMenu.addMenuListener(this);
			Menu menu= contextMenu.createContextMenu(viewer.getControl());
			viewer.getControl().setMenu(menu);
	//		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));
	
			String menuId = "org.eclipse.papyrus.layers.stackmodel.diagram.ui.contextmenu";
//			getSite().registerContextMenu(menuId, contextMenu, new UnwrappingSelectionProvider(viewer));
			getSite().registerContextMenu(menuId, contextMenu, viewer);
	
//			int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
//			Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance(), LocalSelectionTransfer.getTransfer(), FileTransfer.getInstance() };
//			viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
//			viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
		}

		/**
		 * Refresh the internal {@link #layersExplorerTree} according to the current LayersStack found.
		 * Lookup for the current LayerStack, and set the internal {@link #layersExplorerTree} accordingly.
		 * If a LayerStack is found, show it in the tree.
		 * Otherwise,show an empty tree 
		 * TODO rename to resetLayersExplorerTreeInput()
		 */
		public void refreshLayersExplorerTree() {
			
			LayersStack currentLayersStack = lookupCurrentLayersStack();
			if(currentLayersStack != null) {
				setTreeInput(currentLayersStack);
				layersExplorerTree.setSelection(new StructuredSelection(currentLayersStack), true);
			}
			else 
				setEmptyTreeInput();
			}

		/**
		 * Lookup if there is a current {@link LayersStack} attached to the 
		 *  diagram associated to the current page.
		 * Return the {@link LayersStack} if there is one, or null if there is none.
		 * The {@link #currentServicesRegistry} and {@link #currentLayersModel} should be already set.
		 * @return the current {@link LayersStack} or null.
		 */
		private LayersStack lookupCurrentLayersStack() {
			
			if( currentLayersModel==null || currentServicesRegistry==null) {

				// Bad state
				// FIXME Log error ?
				log.info("Error - "+ getClass().getSimpleName() + " - currentLayersModel and currentServicesRegistry should not be null.");
				return null;
			}
			
			try {
				Diagram currentDiagram = getCurrentDiagram();
				if(currentDiagram==null) {
					return null;
				}
				
				LayersStackApplication application = currentLayersModel.lookupLayerStackApplication();
				if(application==null) {
					return null;
				}

				return application.lookupLayersStackFor(currentDiagram);
			} catch (org.eclipse.papyrus.layers.stackmodel.NotFoundException e) {
			}
			// Not found
			return null;
		}
}
