/*******************************************************************************
 * Copyright (c) 2009 Obeo.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Francisco Javier Cano Muñoz (Prodevelop) - bugs solving, features implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.navigator.actions.GroupChildrenAction;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.papyrus.navigator.providers.IContentProvider;
import org.eclipse.papyrus.navigator.providers.ToEditorSaveable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.INavigatorContentExtension;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * This class define a view used to navigate in UML model and resource
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class ModelNavigator extends CommonNavigator implements
		IEditingDomainProvider {

	IWorkbenchPage page = null;

	/** {@link TransactionalEditingDomain} used to perform actions and commands. */
	TransactionalEditingDomain editingDomain = null;

	/** Active {@link IEditorPart}. */
	IEditorPart editorPart = null;

	/**
	 * The {@link IPropertySheetPage} this model exploer will use.
	 */
	IPropertySheetPage propertySheetPage = null;

	// //
	// fjcano #290424 :: allow saving from the Model Explorer
	// //
	private ToEditorSaveable toEditorSaveable = new ToEditorSaveable(null, this);

	private Saveable[] toEditorSaveableArray = new Saveable[] { toEditorSaveable };

	public ToEditorSaveable getToEditorSaveable() {
		// fjcano #290424 :: allow saving from the Model Explorer
		return toEditorSaveable;
	}

	/**
	 * Due to the NavigatorSaveablesService not updating correctly the Saveables
	 * available via the ContentProviders, a new and direct way of getting the
	 * Saveables is implemented here.
	 * 
	 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano
	 *         Muñoz</a>
	 */
	@Override
	public Saveable[] getSaveables() {
		// fjcano #290424 :: allow saving from the Model Explorer
		// return a Saveable that targets the doSave action to the Active
		// Editor.
		return toEditorSaveableArray;
	}

	/**
	 * Due to the NavigatorSaveablesService not updating correctly the Saveables
	 * available via the ContentProviders, a new and direct way of getting the
	 * Saveables is implemented here.
	 * 
	 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano
	 *         Muñoz</a>
	 */
	@Override
	public Saveable[] getActiveSaveables() {
		// fjcano #290424 :: allow saving from the Model Explorer
		// return a Saveable that targets the doSave action to the Active
		// Editor.
		return toEditorSaveableArray;
	}

	/**
	 * Method to perform all necessary updates.
	 */
	public void doUpdate() {
		// fjcano #290424 :: allow saving from the Model Explorer
		if (getToEditorSaveable() != null) {
			getToEditorSaveable().setEditor(getEditorPart());
		}
	}

	/**
	 * Gets the active {@link IEditorPart}.
	 * 
	 * @return the editor part
	 */
	public IEditorPart getEditorPart() {
		return editorPart;
	}

	// //
	// fjcano #290422 :: grouping children by type
	// //
	public static final String PROPERTY_GROUPCHILDS = "org.eclipse.papyrus.navigator.view.groupchilds";

	private boolean isGroupingChildsEnabled = false;

	public static final int IS_GROUPINGCHILDS_ENABLED_PROPERTY = 987;

	/**
	 * Sets the grouping of children by type. Fires a property change that makes
	 * the model explorer to refresh.
	 * 
	 * @param toGroupChilds
	 */
	public final void setGroupChildsEnabled(boolean toGroupChilds) {
		// fjcano :: #290422
		isGroupingChildsEnabled = toGroupChilds;
		firePropertyChange(IS_GROUPINGCHILDS_ENABLED_PROPERTY);
		ISelection sel = this.getCommonViewer().getSelection();
		if (sel instanceof ITreeSelection
				&& ((ITreeSelection) sel).getFirstElement() != null) {
			IStructuredSelection s = new StructuredSelection(
					((ITreeSelection) sel).getFirstElement());
			this.getCommonViewer().setSelection(s, true);
		}
		this.refreshViewer();
	}

	/**
	 * Retrieves the value of the grouping children flag.
	 * 
	 * @return
	 */
	public boolean isGroupingChildsEnabled() {
		// fjcano :: #290422
		return this.isGroupingChildsEnabled;
	}

	/**
	 * Retrieves the grouping of children action.
	 * 
	 * @return
	 */
	public IAction getGroupChildrenAction() {
		// fjcano :: #290422
		IAction groupChildsAction = new GroupChildrenAction(this);
		ImageDescriptor folderIcon = PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJ_FOLDER);
		groupChildsAction.setImageDescriptor(folderIcon);
		groupChildsAction.setHoverImageDescriptor(folderIcon);
		return groupChildsAction;
	}

	/**
	 * Add the "Group children" action.
	 */
	public void createPartControl(Composite aParent) {
		super.createPartControl(aParent);
		// fjcano #290422 :: add "Group children" action
		getViewSite().getActionBars().getToolBarManager().add(
				getGroupChildrenAction());
	};

	/**
	 * {@link ResourceSetListener} to listen and react to changes in the
	 * resource set.
	 */
	ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			handleResourceSetChanged(event);
		}
	};

	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		// Refresh global viewer
		refreshViewer();
		// Notify all content providers
		List<Notification> notifications = event.getNotifications();
		int i = 0;
		boolean finish = false;
		while (!finish && i < notifications.size()) {
			Object n = notifications.get(i);
			if (n instanceof Notification) {
				Notification notification = (Notification) n;
				Iterator<?> it = getNavigatorContentService()
						.findRootContentExtensions(notification.getNotifier())
						.iterator();
				while (it.hasNext()) {
					Object obj = it.next();
					finish = true;
					if (obj instanceof INavigatorContentExtension) {
						INavigatorContentExtension nce = (INavigatorContentExtension) obj;
						if (nce.getContentProvider() instanceof IContentProvider) {
							IContentProvider provider = (IContentProvider) nce
									.getContentProvider();
							provider.resourceSetChanged(event);
						}
					}
				}
			}
			i++;
		}
	}

	/**
	 * A new {@link IWorkbenchPart} has been activated, refresh.
	 * 
	 * @param partRef
	 */
	private void handlePartActivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (part instanceof IEditorPart) {
			activate();
		}
	}

	/**
	 * An {@link IWorkbenchPart} has been deactivated, refresh.
	 * 
	 * @param partRef
	 */
	private void handlePartDeactivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (editorPart != null && editorPart.equals(part)) {
			deactivate();
		}
	}

	/**
	 * Activate the Model Explorer.
	 */
	public void activate() {
		this.editorPart = NavigatorUtils.getMultiDiagramEditor();
		this.editingDomain = NavigatorUtils.getTransactionalEditingDomain();
		if (editingDomain != null) {
			editingDomain.addResourceSetListener(resourceSetListener);
		}
		refreshViewer();
		// fjcano #290424 :: allow saving from the Model Explorer
		doUpdate();
	}

	/**
	 * Deactivate the Model Explorer.
	 */
	public void deactivate() {
		editorPart = null;
		if (editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
		}
		// if (propertySheet != null) {
		// propertySheet.dispose();
		// }
		refreshViewer();
		// fjcano #290424 :: allow saving from the Model Explorer
		doUpdate();
	}

	/**
	 * Adapts to {@link IPropertySheetPage}. Other adaptations are handled by
	 * superclasses.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (IPropertySheetPage.class.equals(adapter)) {
			return getPropertySheetPage();
		}
		return super.getAdapter(adapter);
	}

	/**
	 * Forces the viewer to be refreshed.
	 */
	public void refreshViewer() {
		CommonViewer viewer = getCommonViewer();
		if (viewer != null && viewer.getTree().isDisposed() == false) {
			viewer.refresh();
		}
	}

	/**
	 * Adds an {@link IPartListener2} and an {@link ISelectionListener}.
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		page = site.getPage();
		// IPartListener to listen to IWorkbenchParts' life cycle.
		page.addPartListener(new IPartListener2() {

			public void partActivated(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partBroughtToTop(IWorkbenchPartReference partRef) {
			}

			public void partClosed(IWorkbenchPartReference partRef) {
				handlePartDeactivated(partRef);
			}

			public void partDeactivated(IWorkbenchPartReference partRef) {
			}

			public void partHidden(IWorkbenchPartReference partRef) {
			}

			public void partInputChanged(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partOpened(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partVisible(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

		});
		// an ISelectionListener to react to workbench selection changes.
		page.addSelectionListener(new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart part,
					ISelection selection) {
				handleSelectionChangedFromDiagramEditor(part, selection);
			}
		});
		activate();
	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 * 
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		final IMultiDiagramEditor multiDiagramEditor = NavigatorUtils
				.getMultiDiagramEditor();
		if (multiDiagramEditor != null) {
			if (propertySheetPage == null) {
				// An 'EEF' properties view
				if (multiDiagramEditor instanceof ITabbedPropertySheetPageContributor) {
					ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor) multiDiagramEditor;
					this.propertySheetPage = new TabbedPropertySheetPage(
							contributor);
				}
			}
			return propertySheetPage;
		}
		return null;
	}

	/**
	 * Adds an {@link ISelectionChangedListener} to this Model Explorer's viewer
	 * to react to selection changes in the Model Explorer.
	 */
	@Override
	protected CommonViewer createCommonViewer(Composite parent) {
		CommonViewer commonViewer = super.createCommonViewer(parent);
		commonViewer
				.addPostSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						handleSelectionChangedFromCommonViewer(event);
					}
				});
		return commonViewer;
	}

	// optimize selection handling
	private boolean handlingSelectionChanged = false;

	/**
	 * Handle a selection change in the editor.
	 * 
	 * @param part
	 * @param selection
	 */
	protected void handleSelectionChangedFromDiagramEditor(IWorkbenchPart part,
			ISelection selection) {
		// Handle selection from diagram editor
		if (isLinkingEnabled() && !handlingSelectionChanged) {
			this.handlingSelectionChanged = true;
			if (part instanceof IEditorPart) {
				ISelection unwrappedSelection = NavigatorUtils
						.unwrapSelection(selection);
				if (!unwrappedSelection.isEmpty()) {
					getCommonViewer().setSelection(unwrappedSelection, true);
				}
			}
			this.handlingSelectionChanged = false;
		}
	}

	/**
	 * Handle a selection change in the Model Explorer's viewer.
	 * 
	 * @param event
	 */
	protected void handleSelectionChangedFromCommonViewer(
			SelectionChangedEvent event) {
		// Handle selection from common viewer
		if (isLinkingEnabled() && !handlingSelectionChanged) {
			this.handlingSelectionChanged = true;
			IEditorPart editor = NavigatorUtils.getActiveEditor();
			if (editor instanceof IMultiDiagramEditor) {
				IMultiDiagramEditor multiDiagramEditor = (IMultiDiagramEditor) editor;
				IEditorPart activeEditor = multiDiagramEditor.getActiveEditor();
				// TODO break GMF dependency (maybe add a new method in
				// IMultiDiagramEditor) Cedric
				// ?
				if (activeEditor instanceof DiagramEditor) {
					// set editor selection and select the EditParts
					IDiagramGraphicalViewer diagramGraphicalViewer = ((DiagramEditor) activeEditor)
							.getDiagramGraphicalViewer();
					List<?> editPartsToSelect = NavigatorUtils
							.getEditPartsFromSelection(event.getSelection(),
									diagramGraphicalViewer);
					StructuredSelection selectedEditParts = new StructuredSelection(
							editPartsToSelect);
					diagramGraphicalViewer.setSelection(selectedEditParts);
					if (!selectedEditParts.isEmpty()) {
						EditPart editPart = (EditPart) selectedEditParts
								.getFirstElement();
						diagramGraphicalViewer.reveal(editPart);
					}
				}
			}
			this.handlingSelectionChanged = false;
		}
	}

	/**
	 * Handle a double click on an element in the Model Explorer
	 */
	@Override
	protected void handleDoubleClick(DoubleClickEvent anEvent) {
		IAction openHandler = getViewSite().getActionBars()
				.getGlobalActionHandler(ICommonActionConstants.OPEN);
		if (openHandler != null) {
			openHandler.run();
		} else {
			IStructuredSelection selection = (IStructuredSelection) anEvent
					.getSelection();
			Object element = selection.getFirstElement();
			if (element instanceof Diagram) {
				// fjcano #287943 :: handle a double click on a papyrus Diagram
				handleDoubleClickOnDiagram((Diagram) element);
			} else if (element instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				// fjcano #287943 :: handle a double click on a gmf Diagram
				handleDoubleClickOnDiagram((org.eclipse.gmf.runtime.notation.Diagram) element);
			} else if (element instanceof EObject) {
				// Open SWT EEF Properties UI
				// OpenWizardOnDoubleClick openWizardOnDoubleClick = new
				// OpenWizardOnDoubleClick(this.editingDomain);
				// openWizardOnDoubleClick.doubleClick(anEvent);
			} else {
				super.handleDoubleClick(anEvent);
			}
		}
	}

	/**
	 * Handle double click on a Papyrus Diagram.
	 * 
	 * @param diagram
	 */
	protected void handleDoubleClickOnDiagram(Diagram diagram) {
		// fjcano #287943 :: handle double click on a papyrus diagram
		System.out.println("#ModelNavigator-> handleDoubleClickOnDiagram : "
				+ diagram);
		if (!EditorUtils.getIPageMngr().isOpen(diagram)) {
			// open the diagram if not already open
			EditorUtils.getIPageMngr().openPage(diagram);
		}
	}

	/**
	 * Handle double click on a GMF Diagram.
	 * 
	 * @param diagram
	 */
	protected void handleDoubleClickOnDiagram(
			org.eclipse.gmf.runtime.notation.Diagram diagram) {
		// fjcano #287943 :: handle double click on a gmf diagram
		System.out.println("#ModelNavigator-> handleDoubleClickOnDiagram : "
				+ diagram);
		if (!EditorUtils.getIPageMngr().isOpen(diagram)) {
			// open the diagram if not already open
			EditorUtils.getIPageMngr().openPage(diagram);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the EditingDomain used by the properties view
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	// //
	// fjcano #288599# :: enable linking by default in the model explorer
	// //
	private String LINKING_ENABLED = "CommonNavigator.LINKING_ENABLED"; //$NON-NLS-1$ 

	/**
	 * Make the synchronization between the editor and the model explorer active
	 * by default.
	 */
	@Override
	public void init(IViewSite aSite, IMemento aMemento)
			throws PartInitException {
		super.init(aSite, aMemento);
		// fjcano #288599# :: linking enabled by default
		if (memento != null) {
			Integer linkingEnabledInteger = memento.getInteger(LINKING_ENABLED);
			setLinkingEnabled(((linkingEnabledInteger != null) ? linkingEnabledInteger
					.intValue() == 1
					: true));
		} else {
			// fjcano :: linking is enabled by default.
			setLinkingEnabled(true);
		}
	}

}
