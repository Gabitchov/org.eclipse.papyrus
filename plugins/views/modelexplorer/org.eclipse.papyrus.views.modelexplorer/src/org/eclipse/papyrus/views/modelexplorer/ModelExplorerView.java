/*****************************************************************************
= * Copyright (c) 2010, 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - post refreshes for transaction commit asynchronously (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.additional.AdditionalResourcesModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.providers.SemanticFromModelExplorer;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.views.modelexplorer.listener.DoubleClickListener;
import org.eclipse.papyrus.views.modelexplorer.matching.IMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.LinkItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ModelElementItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ReferencableMatchingItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.NavigatorContentService;
import org.eclipse.ui.internal.navigator.extensions.NavigatorContentDescriptor;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Papyrus Model Explorer associated to one {@link IMultiDiagramEditor}.
 * This ModelExplorer is linked to one single {@link IMultiDiagramEditor}. It doesn't change its
 * source when the current Editor change. To allow to explore different Model, use a {@link ModelExplorerPageBookView}.
 * 
 */
public class ModelExplorerView extends CommonNavigator implements IRevealSemanticElement, IEditingDomainProvider {

	/**
	 * The context of the LabelProviderService used by this view
	 * 
	 * @see {@link LabelProviderService}
	 */
	public static final String LABEL_PROVIDER_SERVICE_CONTEXT = "org.eclipse.papyrus.views.modelexplorer.labelProvider.context";

	/**
	 * The associated EditorPart
	 * The View is associated to the ServicesRegistry rather than to an editor.
	 * */
	//	private IMultiDiagramEditor editorPart;

	/**
	 * The {@link ServicesRegistry} associated to the Editor. This view is associated to the
	 * ServicesRegistry rather than to the EditorPart.
	 */
	private final ServicesRegistry serviceRegistry;

	/** The save aservice associated to the editor. */
	private ISaveAndDirtyService saveAndDirtyService;

	/** {@link IUndoContext} used to tag command in the commandStack. */
	private IUndoContext undoContext;

	/** editing domain used to read/write the model */
	private TransactionalEditingDomain editingDomain;

	/** Flag to avoid reentrant call to refresh. */
	private AtomicBoolean isRefreshing = new AtomicBoolean(false);

	/**
	 * A listener on page (all editors) selection change. This listener is set
	 * in {@link ModelExplorerView#init(IViewSite)}. It should be dispose to remove
	 * hook to the Eclipse page.
	 */
	private ISelectionListener pageSelectionListener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			handleSelectionChangedFromDiagramEditor(part, selection);
		}
	};

	/**
	 * Listener on {@link ISaveAndDirtyService#addInputChangedListener(IEditorInputChangedListener)}
	 */
	protected IEditorInputChangedListener editorInputChangedListener = new IEditorInputChangedListener() {

		/**
		 * This method is called when the editor input is changed from the ISaveAndDirtyService.
		 * 
		 * @see org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener#editorInputChanged(org.eclipse.ui.part.FileEditorInput)
		 * 
		 * @param fileEditorInput
		 */
		public void editorInputChanged(FileEditorInput fileEditorInput) {
			// Change the editor input.
			setPartName(fileEditorInput.getName());
		}

		/**
		 * The isDirty flag has changed, reflect its new value
		 * 
		 * @see org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener#isDirtyChanged()
		 * 
		 */
		public void isDirtyChanged() {
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	};


	/** Undo action handler */
	UndoActionHandler undoHandler;

	/** Redo action handler */
	RedoActionHandler redoHandler;


	/** The {@link IPropertySheetPage} this model explorer will use. */
	private IPropertySheetPage propertySheetPage = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param part
	 *        The part associated to this ModelExplorer
	 */
	public ModelExplorerView(IMultiDiagramEditor part) {

		if(part == null) {
			throw new IllegalArgumentException("A part should be provided.");
		}

		// Try to get the ServicesRegistry
		serviceRegistry = part.getServicesRegistry();
		if(serviceRegistry == null) {
			throw new IllegalArgumentException("The part should have a ServiceRegistry.");
		}

		setLinkingEnabled(true);

		// Get required services from ServicesRegistry
		try {
			saveAndDirtyService = serviceRegistry.getService(ISaveAndDirtyService.class);
			undoContext = serviceRegistry.getService(IUndoContext.class);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handle a selection change in the editor.
	 * 
	 * @param part
	 * @param selection
	 */
	private void handleSelectionChangedFromDiagramEditor(IWorkbenchPart part, ISelection selection) {
		// Handle selection from diagram editor
		if(isLinkingEnabled()) {
			if(part instanceof IEditorPart) {
				if(selection instanceof IStructuredSelection) {
					Iterator<?> selectionIterator = ((IStructuredSelection)selection).iterator();
					ArrayList<Object> semanticElementList = new ArrayList<Object>();
					while(selectionIterator.hasNext()) {
						Object currentSelection = selectionIterator.next();
						if(currentSelection instanceof IAdaptable) {
							Object semanticElement = ((IAdaptable)currentSelection).getAdapter(EObject.class);
							if(semanticElement != null) {
								semanticElementList.add(semanticElement);
							}
						}

					}
					revealSemanticElement(semanticElementList);

				}

			}
		}
	}

	/**
	 * look for the path the list of element (comes from the content provider) to go the eObject
	 * 
	 * @param eobject
	 *        that we look for.
	 * @param objects
	 *        a list of elements where eobject can be wrapped.
	 * @return the list of modelElementItem ( from the root to the element that wrap the eobject)
	 */
	protected List<Object> searchPath(EObject eobject, List<Object> objects) {
		SemanticFromModelExplorer semanticGetter = new SemanticFromModelExplorer();
		List<Object> path = new ArrayList<Object>();
		ITreeContentProvider contentProvider = (ITreeContentProvider)getCommonViewer().getContentProvider();
		//		IPageMngr iPageMngr = EditorUtils.getIPageMngr();
		IPageManager iPageMngr;
		try {
			iPageMngr = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
		} catch (ServiceException e) {
			// This shouldn't happen.
			return Collections.emptyList();
		}
		Object[] result = iPageMngr.allPages().toArray();
		List<Object> editors = Arrays.asList(result);


		for(Object o : objects) {
			// Search matches in this level
			//			if(!(o instanceof Diagram) && o instanceof IAdaptable) {
			if(!editors.contains(o) && o instanceof IAdaptable) {
				if(eobject.equals(((IAdaptable)o).getAdapter(EObject.class))) {
					path.add(o);
					return path;
				}
			}

			// Find childs only for feature container
			for(int i = 0; i < contentProvider.getChildren(o).length; i++) {
				Object treeItem = contentProvider.getChildren(o)[i];

				List<Object> tmppath = new ArrayList<Object>();
				Object element = semanticGetter.getSemanticElement(treeItem);
				if(element != null) {
					if(element instanceof EReference) {
						if(((EReference)element).isContainment() && (!((EReference)element).isDerived())) {
							List<Object> childs = new ArrayList<Object>();
							childs.add(treeItem);
							tmppath = searchPath(eobject, childs);
						}
					}

					else {
						if(element instanceof EObject) {
							List<Object> childs = new ArrayList<Object>();
							childs.add(treeItem);
							tmppath = searchPath(eobject, childs);
						}
					}
				}

				// if tmppath contains the wrapped eobject we have find the good path
				if(tmppath.size() > 0) {
					if(tmppath.get(tmppath.size() - 1) instanceof IAdaptable) {
						if(eobject.equals(((IAdaptable)(tmppath.get(tmppath.size() - 1))).getAdapter(EObject.class))) {
							path.add(o);
							path.addAll(tmppath);
							return path;
						}
					}
				}
			}
		}

		return new ArrayList<Object>();
	}


	/**
	 * {@inheritDoc}
	 */
	// FIXME Use of internal class (NavigatorContentService) - in the hope that the bug gets fixed soon.
	@Override
	protected CommonViewer createCommonViewerObject(Composite aParent) {
		CommonViewer viewer = new CustomCommonViewer(getViewSite().getId(), aParent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// enable tool-tips
		// workaround for bug 311827: the Common Viewer always uses NavigatorDecoratingLabelProvider
		// as a wrapper for the LabelProvider provided by the application. The NavigatorDecoratingLabelProvider
		// does not delegate tooltip related functions but defines them as empty.
		NavigatorContentService contentService = new NavigatorContentService(getViewSite().getId());
		@SuppressWarnings("unchecked")
		// get label provider from content service (which in turn evaluates extension points in
		// function of the input)
		Object input = getInitialInput();
		Set<Object> descriptors = contentService.findDescriptorsByTriggerPoint(input, false);
		for(Object descriptor : descriptors) {
			if(descriptor instanceof NavigatorContentDescriptor) {
				ILabelProvider labelProvider = null;

				if(input instanceof ServicesRegistry) {
					ServicesRegistry registry = (ServicesRegistry)input;
					try {
						labelProvider = registry.getService(LabelProviderService.class).getLabelProvider(LABEL_PROVIDER_SERVICE_CONTEXT);
					} catch (ServiceException ex) {
						Activator.log.error(ex);
					}

					labelProvider = new DecoratingLabelProviderWTooltips(labelProvider, (ServicesRegistry)input);
				}

				if(labelProvider == null) {
					labelProvider = new LabelProvider();
				}

				//ILabelProvider labelProvider = ((NavigatorContentDescriptor)descriptor).createLabelProvider();
				viewer.setLabelProvider(labelProvider); // add for decorator and tooltip support
				break;
			}
		}
		ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE);

		return viewer;
	}

	@Override
	public void createPartControl(Composite aParent) {
		super.createPartControl(aParent);
		getCommonViewer().setSorter(null);
		((CustomCommonViewer)getCommonViewer()).getDropAdapter().setFeedbackEnabled(true);
		getCommonViewer().addDoubleClickListener(new DoubleClickListener(serviceRegistry));
		Tree tree = getCommonViewer().getTree();
		Activator.getDefault().getCustomizationManager().installCustomPainter(tree);

	}

	/**
	 * Return the control used to render this View
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.IPageBookNestableViewPart#getControl()
	 * 
	 * @return the main control of the navigator viewer
	 */
	public Control getControl() {
		return getCommonViewer().getControl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IViewSite site, IMemento aMemento) throws PartInitException {
		super.init(site, aMemento);

		// Hook undo/redo action
		//		hookGlobalHistoryHandler(site);

		//		page.addPartListener(partListener);
		activate();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IWorkbenchPage page = site.getPage();
		// an ISelectionListener to react to workbench selection changes.

		page.addSelectionListener(pageSelectionListener);
	}

	/**
	 * Hook the global undo/redi actions.
	 */
	//	private void hookGlobalHistoryHandler(IViewSite site) {
	//		undoHandler = new UndoActionHandler(site, null);
	//		redoHandler = new RedoActionHandler(site, null);
	//
	//		IActionBars actionBars = site.getActionBars();
	//
	//		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoHandler);
	//		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoHandler);
	//	}

	/**
	 * {@link ResourceSetListener} to listen and react to changes in the
	 * resource set.
	 */
	private final ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			handleResourceSetChanged(event);
		}
	};

	/** cache variable with last transaction which triggered a refresh */
	private Transaction lastTrans = null;

	/**
	 * Run in a UI thread to avoid non UI thread exception.
	 * 
	 * @param event
	 */
	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		// avoid refreshing N times for the same transaction (called for each object in resource)
		Transaction curTrans = event.getTransaction();
		if(lastTrans != null && lastTrans.equals(curTrans)) {
			return;
		}
		lastTrans = curTrans;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			/**
			 * {@inheritDoc}
			 */
			public void run() {
				refresh();
			}
		});
	}

	/**
	 * refresh the view.
	 */
	public void refresh() {
		// Need to refresh, even if (temporarily) invisible
		// (Better alternative?: store refresh event and execute once visible again)
		if(getControl().isDisposed()) {
			return;
		}

		// avoid reentrant call
		// Refresh only of we are not already refreshing.
		if(isRefreshing.compareAndSet(false, true)) {
			if(!getCommonViewer().isBusy()) {
				getCommonViewer().refresh();
			}

			isRefreshing.set(false);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getInitialInput() {

		if(serviceRegistry != null) {
			return serviceRegistry;
		} else {
			return super.getInitialInput();
		}

	}

	/**
	 * Activate specified Part.
	 */
	private void activate() {


		try {
			this.editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
			//			this.editingDomain = EditorUtils.getTransactionalEditingDomain(editorPart.getServicesRegistry());
			// Set Viewer input if it already exist
			if(getCommonViewer() != null) {
				getCommonViewer().setInput(serviceRegistry);
			}
			editingDomain.addResourceSetListener(resourceSetListener);
		} catch (ServiceException e) {
			// Can't get EditingDomain, skip
		}

		// Listen to isDirty flag
		saveAndDirtyService.addInputChangedListener(editorInputChangedListener);

		// Hook
		//			if(undoHandler != null){
		//				IUndoContext undoContext = getUndoContext(part);
		//				undoHandler.setContext(undoContext);
		//				undoHandler.update();
		//				redoHandler.setContext(undoContext);
		//				redoHandler.update();
		//			}
		if(this.getCommonViewer() != null) {
			refresh();
		}

	}

	/**
	 * Deactivate the Model Explorer.
	 */
	private void deactivate() {
		// deactivate global handler
		if(Activator.log.isDebugEnabled()) {
			Activator.log.debug("deactivate ModelExplorerView"); //$NON-NLS-1$
		}

		// Stop listening on change events
		getSite().getPage().removeSelectionListener(pageSelectionListener);
		// Stop Listening to isDirty flag
		saveAndDirtyService.removeInputChangedListener(editorInputChangedListener);

		// unhook
		//			IUndoContext undoContext = getUndoContext(editorPart);
		//			undoHandler.setContext(undoContext);
		//			undoHandler.update();
		//			redoHandler.setContext(undoContext);
		//			redoHandler.update();


		if(editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
			editingDomain = null;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {

		// Stop if we are already disposed
		if(isDisposed()) {
			return;
		}

		deactivate();

		saveAndDirtyService = null;
		undoContext = null;
		editingDomain = null;

		super.dispose();

		// Clean up properties to help GC

	}

	/**
	 * Return true if the component is already disposed.
	 * 
	 * @return
	 */
	public boolean isDisposed() {
		// use editorPart as flag
		return saveAndDirtyService == null;
	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 * 
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		try {
			final IMultiDiagramEditor multiDiagramEditor = ServiceUtils.getInstance().getService(IMultiDiagramEditor.class, serviceRegistry);

			if(multiDiagramEditor != null) {
				if(propertySheetPage == null || propertySheetPage.getControl() == null || propertySheetPage.getControl().isDisposed()) {
					if(multiDiagramEditor instanceof ITabbedPropertySheetPageContributor) {
						ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor)multiDiagramEditor;
						this.propertySheetPage = new TabbedPropertySheetPage(contributor);
					}
				}
				return propertySheetPage;
			}
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
		return null;
	}

	/**
	 * in order to see element if the property view
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if(IPropertySheetPage.class.equals(adapter)) {
			return getPropertySheetPage();
		}

		if(IUndoContext.class == adapter) {
			// Return the IUndoContext of associated model.
			return undoContext;
		}

		if(ISaveablePart.class.equals(adapter)) {
			return saveAndDirtyService;
		}

		if(ServicesRegistry.class == adapter) {
			return serviceRegistry;
		}

		return super.getAdapter(adapter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the EditingDomain used by the properties view
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectReveal(ISelection selection) {
		if(getCommonViewer() != null) {
			getCommonViewer().setSelection(selection, true);
		}
	}

	public void revealSemanticElement(List<?> elementList) {
		reveal(elementList, getCommonViewer());
	}

	/**
	 * Expands the given CommonViewer to reveal the given elements
	 * 
	 * @param elementList
	 *        The elements to reveal
	 * @param commonViewer
	 *        The CommonViewer they are to be revealed in
	 */
	public static void reveal(Iterable<?> elementList, final CommonViewer commonViewer) {
		ArrayList<IMatchingItem> matchingItemsToSelect = new ArrayList<IMatchingItem>();
		// filter out non EMF objects
		Iterable<EObject> list = Iterables.transform(Iterables.filter(elementList, EObject.class), new Function<Object, EObject>() {

			public EObject apply(Object from) {
				return (EObject)from;
			}
		});

		for(EObject currentEObject : list) {
			matchingItemsToSelect.add(new ModelElementItemMatchingItem(currentEObject));

			// the content provider exist?
			if(commonViewer.getContentProvider() != null) {
				// retrieve the ancestors to reveal them
				// and allow the selection of the object
				ArrayList<EObject> parents = new ArrayList<EObject>();
				EObject tmp = currentEObject.eContainer();
				while(tmp != null) {
					parents.add(tmp);
					tmp = tmp.eContainer();
				}

				Iterable<EObject> reverseParents = Iterables.reverse(parents);

				// reveal the resource if necessary
				Resource r = null;
				if(!parents.isEmpty()) {
					r = parents.get(parents.size() - 1).eResource();
				} else {
					r = currentEObject.eResource();
				}

				if(r != null) {
					ResourceSet rs = r.getResourceSet();
					if(rs instanceof ModelSet && AdditionalResourcesModel.isAdditionalResource((ModelSet)rs, r.getURI())) {
						commonViewer.expandToLevel(new ReferencableMatchingItem(rs), 1);
						commonViewer.expandToLevel(new ReferencableMatchingItem(r), 1);
					}
				}

				/*
				 * reveal the ancestors tree using expandToLevel on each of them
				 * in the good order. This is a lot faster than going through the whole tree
				 * using getChildren of the ContentProvider since our Viewer uses a Hashtable
				 * to keep track of the revealed elements.
				 * 
				 * However we need to use a dedicated MatchingItem to do the matching,
				 * and a specific comparer in our viewer so than the equals of MatchingItem is
				 * used in priority.
				 * 
				 * Please refer to MatchingItem for more infos.
				 */
				EObject previousParent = null;
				for(EObject parent : reverseParents) {
					if(parent.eContainingFeature() != null && previousParent != null) {
						commonViewer.expandToLevel(new LinkItemMatchingItem(previousParent, parent.eContainmentFeature()), 1);
					}

					final IMatchingItem itemToExpand = new ModelElementItemMatchingItem(parent);

					commonViewer.getControl().getDisplay().syncExec(new Runnable() {

						public void run() {
							commonViewer.expandToLevel(itemToExpand, 1);
						}
					});

					previousParent = parent;
				}

				final IMatchingItem itemToExpand = new LinkItemMatchingItem(currentEObject.eContainer(), currentEObject.eContainmentFeature());

				commonViewer.getControl().getDisplay().syncExec(new Runnable() {

					public void run() {
						commonViewer.expandToLevel(itemToExpand, 1);
					}
				});
			}
		}

		selectReveal(new StructuredSelection(matchingItemsToSelect), commonViewer);
	}

	/**
	 * Selects the given ISelection in the given CommonViwer
	 * 
	 * @param structuredSelection
	 *        The ISelection to select
	 * @param commonViewer
	 *        The ComonViewer to select it in
	 */
	public static void selectReveal(final ISelection structuredSelection, final Viewer commonViewer) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				commonViewer.setSelection(structuredSelection, true);
			}
		});
	}

	/**
	 * Selects and, if possible, reveals the given ISelection in the given CommonViwer
	 * 
	 * @param selection
	 *        The ISelection to select
	 * @param viewer
	 *        The ComonViewer to select it in
	 */
	public static void reveal(ISelection selection, CommonViewer viewer) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structured = (IStructuredSelection)selection;
			reveal(Lists.newArrayList(structured.iterator()), viewer);
		} else {
			viewer.setSelection(selection);
		}
	}

}
