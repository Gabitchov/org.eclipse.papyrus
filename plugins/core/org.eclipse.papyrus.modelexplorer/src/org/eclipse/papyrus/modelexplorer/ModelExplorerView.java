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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) Vincent.lorenzo@cea.fr - 343950: [Model Explorer] [TableEditor] Function "Link with Editor"
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Rewrite revealSemanticElement to be a lot faster
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.lifecycleevents.IEditorInputChangedListener;
import org.eclipse.papyrus.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.ui.IRevealSemanticElement;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.modelexplorer.listener.DoubleClickListener;
import org.eclipse.papyrus.modelexplorer.matching.IMatchingItem;
import org.eclipse.papyrus.modelexplorer.matching.LinkItemMatchingItem;
import org.eclipse.papyrus.modelexplorer.matching.ModelElementItemMatchingItem;
import org.eclipse.papyrus.modelexplorer.matching.ReferencableMatchingItem;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.additional.AdditionalResourcesModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
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
 * Papyrus Model Explorer associated to one {@link IMultiDiagramEditor}. This
 * ModelExplorer is linked to one single {@link IMultiDiagramEditor}. It doesn't
 * change its source when the current Editor change. To allow to explore
 * different Model, use a {@link ModelExplorerPageBookView}.
 * 
 */
/**
 * @author tfaure
 *
 */
public class ModelExplorerView extends CommonNavigator implements IRevealSemanticElement, IEditingDomainProvider {

	/** The associated EditorPart */
	private IMultiDiagramEditor editorPart;

	/** The save aservice associated to the editor. */
	private ISaveAndDirtyService saveAndDirtyService;

	/** editing domain used to read/write the model */
	private TransactionalEditingDomain editingDomain;

	/** Flag to avoid reentrant call to refresh. */
	private AtomicBoolean isRefreshing = new AtomicBoolean(false);

	/**
	 * Listener on {@link ISaveAndDirtyService#addInputChangedListener(IEditorInputChangedListener)}
	 */
	protected IEditorInputChangedListener editorInputChangedListener = new IEditorInputChangedListener() {

		/**
		 * This method is called when the editor input is changed from the
		 * ISaveAndDirtyService.
		 * 
		 * @see org.eclipse.papyrus.core.lifecycleevents.IEditorInputChangedListener#editorInputChanged(org.eclipse.ui.part.FileEditorInput)
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
		 * @see org.eclipse.papyrus.core.lifecycleevents.IEditorInputChangedListener#isDirtyChanged()
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
		this.editorPart = part;
		setLinkingEnabled(true);

		try {
			this.saveAndDirtyService = editorPart.getServicesRegistry().getService(ISaveAndDirtyService.class);
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
							// when we are in a table, the selected element are
							// EObject
						} else if(currentSelection instanceof EObject) {
							semanticElementList.add(currentSelection);
						}

					}
					revealSemanticElement(semanticElementList);
				}

			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	// FIXME Use of internal class (NavigatorContentService) - in the hope that
	// the bug gets fixed soon.
	@Override
	protected CommonViewer createCommonViewerObject(Composite aParent) {
		CommonViewer viewer = new CustomCommonViewer(getViewSite().getId(), aParent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// enable tool-tips
		// workaround for bug 311827: the Common Viewer always uses
		// NavigatorDecoratingLabelProvider
		// as a wrapper for the LabelProvider provided by the application. The
		// NavigatorDecoratingLabelProvider
		// does not delegate tooltip related functions but defines them as
		// empty.
		NavigatorContentService contentService = new NavigatorContentService(getViewSite().getId());
		@SuppressWarnings("unchecked")
		// get label provider from content service (which in turn evaluates
		// extension points in
		// function of the input)
		Set<Object> descriptors = contentService.findDescriptorsByTriggerPoint(getInitialInput(), false);
		for(Object descriptor : descriptors) {
			if(descriptor instanceof NavigatorContentDescriptor) {
				try {
					ILabelProvider labelProvider = ((NavigatorContentDescriptor)descriptor).createLabelProvider();
					viewer.setLabelProvider(new DecoratingLabelProviderWTooltips(labelProvider)); // add for decorator and tooltip support
				} catch (CoreException e) {
					Activator.log.error(e);
				}
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
		DoubleClickListener listener = new DoubleClickListener();
		getCommonViewer().addDoubleClickListener(listener);
		Tree tree = getCommonViewer().getTree();
		Activator.getDefault().getCustomizationManager().installCustomPainter(tree);

	}

	/**
	 * Return the control used to render this View
	 * 
	 * @see org.eclipse.papyrus.core.ui.pagebookview.IPageBookNestableViewPart#getControl()
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
		// hookGlobalHistoryHandler(site);

		// page.addPartListener(partListener);
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

		page.addSelectionListener(new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				handleSelectionChangedFromDiagramEditor(part, selection);
			}
		});
	}

	/**
	 * Hook the global undo/redi actions.
	 */
	private void hookGlobalHistoryHandler(IViewSite site) {
		undoHandler = new UndoActionHandler(site, null);
		redoHandler = new RedoActionHandler(site, null);

		IActionBars actionBars = site.getActionBars();

		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoHandler);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoHandler);
	}

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
		// avoid refreshing N times for the same transaction (called for each
		// object in resource)
		Transaction curTrans = event.getTransaction();
		if(lastTrans != null && lastTrans.equals(curTrans)) {
			return;
		}
		lastTrans = curTrans;
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

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
		// (Better alternative?: store refresh event and execute once visible
		// again)
		if(getControl().isDisposed())
			return;

		// avoid reentrant call
		// Refresh only of we are not already refreshing.
		if(isRefreshing.compareAndSet(false, true)) {
			if(!getCommonViewer().isBusy())
				getCommonViewer().refresh();

			isRefreshing.set(false);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getInitialInput() {

		if(editorPart != null) {
			return editorPart.getServicesRegistry();
		} else {
			return super.getInitialInput();
		}

	}

	/**
	 * Activate specified Part.
	 */
	private void activate() {

		if(editorPart != null) {

			try {
				this.editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(editorPart.getServicesRegistry());
				// this.editingDomain =
				// EditorUtils.getTransactionalEditingDomain(editorPart.getServicesRegistry());
				// Set Viewer input if it already exist
				if(getCommonViewer() != null) {
					getCommonViewer().setInput(editorPart.getServicesRegistry());
				}
				editingDomain.addResourceSetListener(resourceSetListener);
			} catch (ServiceException e) {
				// Can't get EditingDomain, skip
			}

			// Listen to isDirty flag
			saveAndDirtyService.addInputChangedListener(editorInputChangedListener);

			// Hook
			// if(undoHandler != null){
			// IUndoContext undoContext = getUndoContext(part);
			// undoHandler.setContext(undoContext);
			// undoHandler.update();
			// redoHandler.setContext(undoContext);
			// redoHandler.update();
			// }
		}
		if(this.getCommonViewer() != null) {
			refresh();
		}

	}

	/**
	 * Get the undo context associated to the part.
	 * 
	 * @param part
	 * @return
	 */
	private IUndoContext getUndoContext(IMultiDiagramEditor part) {
		return (IUndoContext)part.getAdapter(IUndoContext.class);
	}

	/**
	 * Deactivate the Model Explorer.
	 */
	private void deactivate() {
		// deactivate global handler
		if(editorPart != null) {
			if(Activator.log.isDebugEnabled()) {
				Activator.log.debug("deactivate " + editorPart.getTitle()); //$NON-NLS-1$
			}

			// Stop Listenning to isDirty flag
			saveAndDirtyService.removeInputChangedListener(editorInputChangedListener);

			// unhook
			// IUndoContext undoContext = getUndoContext(editorPart);
			// undoHandler.setContext(undoContext);
			// undoHandler.update();
			// redoHandler.setContext(undoContext);
			// redoHandler.update();

		}

		editorPart = null;
		if(editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		deactivate();
		super.dispose();

	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 * 
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		final IMultiDiagramEditor multiDiagramEditor = EditorUtils.getMultiDiagramEditor();

		if(multiDiagramEditor != null) {
			if(propertySheetPage == null) {
				if(multiDiagramEditor instanceof ITabbedPropertySheetPageContributor) {
					ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor)multiDiagramEditor;
					this.propertySheetPage = new TabbedPropertySheetPage(contributor);
				}
			}
			return propertySheetPage;
		}
		return null;
	}

	/**
	 * in order to see element if the property view
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if(IPropertySheetPage.class.equals(adapter)) {
			return getPropertySheetPage();
		}

		if(IUndoContext.class.equals(adapter)) {
			// Return the IUndoContext of the currently selected editor.
			if(editorPart != null) {
				return editorPart.getAdapter(IUndoContext.class);
			}

			// Let the parent return the adapter.
		}

		if(ISaveablePart.class.equals(adapter)) {
			return saveAndDirtyService;
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

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.core.ui.IRevealSemanticElement#revealSemanticElement(java.util.List)
	 */
	public void revealSemanticElement(List<?> elementList) {
		reveal(elementList, getCommonViewer());
	}

	/**
	 * Expands the given CommonViewer to reveal the given elements
	 * @param elementList The elements to reveal
	 * @param commonViewer The CommonViewer they are to be revealed in
	 */
	public static void reveal(Iterable<?> elementList, CommonViewer commonViewer) {
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
				if (!parents.isEmpty()) {
					 r = parents.get(parents.size() - 1).eResource();
				} else {
					r = currentEObject.eResource();
				}

				
				if (r != null) {
					ResourceSet rs = r.getResourceSet();
					if (rs instanceof ModelSet && AdditionalResourcesModel.isAdditionalResource((ModelSet)rs, r.getURI())) {
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
					commonViewer.expandToLevel(new ModelElementItemMatchingItem(parent), 1);
					previousParent = parent;
				}
				commonViewer.expandToLevel(new LinkItemMatchingItem(currentEObject.eContainer(), currentEObject.eContainmentFeature()), 1);
			}
		}

		selectReveal(new StructuredSelection(matchingItemsToSelect), commonViewer);
	}

	/**
	 * Selects the given ISelection in the given CommonViwer
	 * @param structuredSelection The ISelection to select
	 * @param commonViewer The ComonViewer to select it in
	 */
	public static void selectReveal(ISelection structuredSelection, Viewer commonViewer) {
		commonViewer.setSelection(structuredSelection, true);
	}

	/**
	 * Selects and, if possible, reveals the given ISelection in the given CommonViwer
	 * @param selection The ISelection to select
	 * @param viewer The ComonViewer to select it in
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
