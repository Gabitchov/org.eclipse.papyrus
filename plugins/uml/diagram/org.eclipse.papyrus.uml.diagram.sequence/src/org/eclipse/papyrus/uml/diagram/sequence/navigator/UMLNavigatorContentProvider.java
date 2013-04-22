/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
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
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public UMLNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
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
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForPackageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup links = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralOrderingEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		if(!links.isEmpty()) {
			result.add(links);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForInteractionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Interaction_2001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Interaction_2001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForLifelineEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Lifeline_3001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Lifeline_3001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForActionExecutionSpecificationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionExecutionSpecification_3006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionExecutionSpecification_3006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForBehaviorExecutionSpecificationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_BehaviorExecutionSpecification_3003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_BehaviorExecutionSpecification_3003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForStateInvariantEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_StateInvariant_3017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_StateInvariant_3017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCombinedFragment2EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CombinedFragment_3018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CombinedFragment_3018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForTimeConstraintEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_TimeConstraint_3019_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_TimeConstraint_3019_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForDurationObservationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationObservation_3024_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationObservation_3024_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForTimeObservationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_TimeObservation_3020_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_TimeObservation_3020_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForDurationConstraintEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationConstraint_3021_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationConstraint_3021_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForInteractionUseEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InteractionUse_3002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InteractionUse_3002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCombinedFragmentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CombinedFragment_3004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CombinedFragment_3004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForInteractionOperandEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InteractionOperand_3005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InteractionOperand_3005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForContinuationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Continuation_3016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Continuation_3016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConstraintEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForDurationConstraintInMessageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationConstraint_3023_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationConstraint_3023_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCommentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_3009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_3009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConsiderIgnoreFragmentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConsiderIgnoreFragment_3007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConsiderIgnoreFragment_3007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4003_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4003_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessage2EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4004_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4004_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessage3EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4005_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4005_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessage4EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4006_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4006_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessage5EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4007_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4007_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessage6EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4008_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4008_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForMessage7EditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4009_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4009_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Message_4009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCommentAnnotatedElementEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4010_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4010_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForDestructionOccurrenceSpecificationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DestructionOccurrenceSpecification_3022_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DestructionOccurrenceSpecification_3022_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConstraintConstrainedElementEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConstraintConstrainedElement_4011_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConstraintConstrainedElement_4011_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), PackageEditPart.MODEL_ID), file, false));
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
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackageEditPart(view, parentElement);
		}
		case InteractionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInteractionEditPart(view, parentElement);
		}
		case LifelineEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForLifelineEditPart(view, parentElement);
		}
		case InteractionUseEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInteractionUseEditPart(view, parentElement);
		}
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForBehaviorExecutionSpecificationEditPart(view, parentElement);
		}
		case CombinedFragmentEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCombinedFragmentEditPart(view, parentElement);
		}
		case InteractionOperandEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInteractionOperandEditPart(view, parentElement);
		}
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionExecutionSpecificationEditPart(view, parentElement);
		}
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConsiderIgnoreFragmentEditPart(view, parentElement);
		}
		case ConstraintEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintEditPart(view, parentElement);
		}
		case CommentEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentEditPart(view, parentElement);
		}
		case ContinuationEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForContinuationEditPart(view, parentElement);
		}
		case StateInvariantEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForStateInvariantEditPart(view, parentElement);
		}
		case CombinedFragment2EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCombinedFragment2EditPart(view, parentElement);
		}
		case TimeConstraintEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForTimeConstraintEditPart(view, parentElement);
		}
		case TimeObservationEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForTimeObservationEditPart(view, parentElement);
		}
		case DurationConstraintEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDurationConstraintEditPart(view, parentElement);
		}
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDestructionOccurrenceSpecificationEditPart(view, parentElement);
		}
		case DurationConstraintInMessageEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDurationConstraintInMessageEditPart(view, parentElement);
		}
		case DurationObservationEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDurationObservationEditPart(view, parentElement);
		}
		case MessageEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessageEditPart(view, parentElement);
		}
		case Message2EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessage2EditPart(view, parentElement);
		}
		case Message3EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessage3EditPart(view, parentElement);
		}
		case Message4EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessage4EditPart(view, parentElement);
		}
		case Message5EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessage5EditPart(view, parentElement);
		}
		case Message6EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessage6EditPart(view, parentElement);
		}
		case Message7EditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMessage7EditPart(view, parentElement);
		}
		case CommentAnnotatedElementEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentAnnotatedElementEditPart(view, parentElement);
		}
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintConstrainedElementEditPart(view, parentElement);
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for(Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge)it.next();
			View nextEdgeSource = nextEdge.getSource();
			if(type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for(Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge)it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if(type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
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
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for(Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UMLNavigatorItem((View)it.next(), parent, isLeafs));
		}
		return result;
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
