package org.eclipse.papyrus.diagram.statemachine.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReference2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate10EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate11EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate12EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate13EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate14EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate9EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Region2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.Messages;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;


/**
 * @generated
 */
public class UMLNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public UMLNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain)editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {

			public Object get(Object key) {
				if(!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {

			public void run() {
				if(myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for(Iterator it = myEditingDomain.getResourceSet()
						.getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(
							myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for(Iterator it = myEditingDomain.getResourceSet()
						.getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(
							myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource,
					final URI newURI) {
				for(Iterator it = myEditingDomain.getResourceSet()
						.getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(
							myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for(Iterator it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
			Resource resource = (Resource)it.next();
			resource.unload();
		}
		((TransactionalEditingDomain)myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof IFile) {
			IFile file = (IFile)parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			Collection result = new ArrayList();
			result
					.addAll(createNavigatorItems(selectViewsByType(resource
					.getContents(), StateMachineEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if(parentElement instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)parentElement;
			return group.getChildren();
		}

		if(parentElement instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)parentElement;
			if(navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams.
		 */
		if(parentElement instanceof IAdaptable) {
			View view = (View)((IAdaptable)parentElement)
					.getAdapter(View.class);
			if(view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {

		case StateMachineEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			result.addAll(getForeignShortcuts((Diagram)view, parentElement));
			UMLNavigatorGroup links = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Package_79_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), StateMachine2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					CommentEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					TransitionEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			links
					.addChildren(createNavigatorItems(connectedViews, links,
					false));
			if(!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case StateMachine2EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_StateMachine_1001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_StateMachine_1001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), RegionEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					Pseudostate13EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					Pseudostate14EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case CommentEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Comment_2024_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Comment_2024_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), ElementOwnedCommentEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RegionEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Region_2001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Region_2001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StateEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					State2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					State3EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FinalStateEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PseudostateEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate3EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate4EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate5EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate6EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate7EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate8EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubverticesEditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					State4EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case StateEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case State2EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), Region2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					Pseudostate11EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					Pseudostate12EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Region2EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Region_2004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Region_2004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					StateEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					State2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					State3EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					FinalStateEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					PseudostateEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate3EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate4EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate5EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate6EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate7EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					Pseudostate8EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					RegionSubvertices2EditPart.VISUAL_ID);
			connectedViews = getChildrenByType(connectedViews,
					State4EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case State3EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view),
					ConnectionPointReferenceEditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					ConnectionPointReference2EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ConnectionPointReferenceEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_ConnectionPointReference_2006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_ConnectionPointReference_2006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ConnectionPointReference2EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_ConnectionPointReference_2007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_ConnectionPointReference_2007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FinalStateEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_FinalState_2008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_FinalState_2008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PseudostateEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate2EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate3EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate4EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate5EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate6EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate7EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate8EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case State4EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_State_2017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), Pseudostate9EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					Pseudostate10EditPart.VISUAL_ID);
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate9EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate10EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2019_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2019_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate11EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2020_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2020_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate12EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2021_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2021_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate13EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2022_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2022_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate14EditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2023_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_2023_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), TransitionEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), TransitionEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view),
					ElementOwnedCommentEditPart.VISUAL_ID);
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view),
					CommentAnnotatedElementEditPart.VISUAL_ID);
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TransitionEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Transition_3001_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_Transition_3001_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), StateEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					State2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					State3EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ConnectionPointReferenceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ConnectionPointReference2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					FinalStateEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					PseudostateEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate3EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate4EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate5EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate6EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate7EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate8EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					State4EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate9EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate10EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate11EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate12EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate13EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate14EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StateEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					State2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					State3EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ConnectionPointReferenceEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ConnectionPointReference2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					FinalStateEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					PseudostateEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate3EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate4EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate5EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate6EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate7EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate8EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					State4EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate9EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate10EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate11EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate12EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate13EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate14EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if(!target.isEmpty()) {
				result.add(target);
			}
			if(!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ElementOwnedCommentEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_ElementOwnedComment_3002_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_ElementOwnedComment_3002_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), CommentEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StateMachine2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CommentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					RegionEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StateEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					State2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Region2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					State3EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ConnectionPointReferenceEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					ConnectionPointReference2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					FinalStateEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					PseudostateEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate2EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate3EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate4EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate5EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate6EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate7EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate8EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					State4EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate9EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate10EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate11EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate12EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate13EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					Pseudostate14EditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if(!target.isEmpty()) {
				result.add(target);
			}
			if(!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case CommentAnnotatedElementEditPart.VISUAL_ID:
		{
			Collection result = new ArrayList();
			UMLNavigatorGroup target = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_CommentAnnotatedElement_3003_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			UMLNavigatorGroup source = new UMLNavigatorGroup(
					Messages.NavigatorGroupName_CommentAnnotatedElement_3003_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), StateMachine2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					CommentEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					RegionEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StateEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					State2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Region2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					State3EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ConnectionPointReferenceEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					ConnectionPointReference2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					FinalStateEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					PseudostateEditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate2EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate3EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate4EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate5EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate6EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate7EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate8EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					State4EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate9EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate10EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate11EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate12EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate13EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					Pseudostate14EditPart.VISUAL_ID);
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					CommentEditPart.VISUAL_ID);
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if(!target.isEmpty()) {
				result.add(target);
			}
			if(!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge)it.next();
			View nextEdgeSource = nextEdge.getSource();
			if(type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, int visualID) {
		Collection result = new ArrayList();
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge)it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if(type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, int visualID) {
		Collection result = new ArrayList();
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, int visualID) {
		Collection result = new ArrayList();
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram)it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for(Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View)it.next();
			if(type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return StateMachineEditPart.MODEL_ID.equals(UMLVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent,
			boolean isLeafs) {
		Collection result = new ArrayList();
		for(Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UMLNavigatorItem((View)it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getForeignShortcuts(Diagram diagram, Object parent) {
		Collection result = new ArrayList();
		for(Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = (View)it.next();
			if(!isOwnView(nextView)
					&& nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if(element instanceof UMLAbstractNavigatorItem) {
			UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem)element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
