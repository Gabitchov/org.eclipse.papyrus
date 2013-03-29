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
package org.eclipse.papyrus.uml.diagram.activity.navigator;

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
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.part.Messages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
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
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForInputPinInSendSigActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3062_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3062_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForDataStoreNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DataStoreNode_3078_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DataStoreNode_3078_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInSendSigActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3055_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3055_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForConditionalNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConditionalNode_3069_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConditionalNode_3069_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForLoopNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_LoopNode_3071_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_LoopNode_3071_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForAcceptEventActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_AcceptEventAction_3063_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_AcceptEventAction_3063_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForCreateObjectActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CreateObjectAction_3086_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CreateObjectAction_3086_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForSendSignalActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_SendSignalAction_3052_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_SendSignalAction_3052_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInitialNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InitialNode_3004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InitialNode_3004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForCommentEditPartCN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_3080_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_3080_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOpaqueActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OpaqueAction_3007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OpaqueAction_3007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForActionInputPinInSendSigActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3053_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3053_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionInputPinInSendSigActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3061_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3061_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForCallOperationActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CallOperationAction_3010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CallOperationAction_3010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForExpansionNodeAsInEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExpansionNode_3074_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExpansionNode_3074_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInAddVariableValueActionAsInsertAtEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3100_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3100_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForObjectFlowEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ObjectFlow_4003_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ObjectFlow_4003_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ObjectFlow_4003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInputPinInOpaqueActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionInputPinInSendObjActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3050_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3050_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForExpansionNodeAsOutEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExpansionNode_3075_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExpansionNode_3075_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForBroadcastSignalActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_BroadcastSignalAction_3102_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_BroadcastSignalAction_3102_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForActivityParameterNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActivityParameterNode_3059_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActivityParameterNode_3059_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForTimeConstraintAsLocalPrecondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_TimeConstraint_3036_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForValuePinInSendSigActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3060_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3060_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInAddStructuralFeatureValueActionAsValueEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3093_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3093_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInCallOpActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3023_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3023_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOutputPinInReadVariableActionAsResultEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3098_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3098_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForDurationConstraintAsLocalPostcondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationConstraint_3035_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForValuePinInCallOpActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3025_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3025_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForForkNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ForkNode_3040_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ForkNode_3040_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionLocalPostconditionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionLocalPostcondition_4002_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionLocalPostcondition_4002_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInSendObjActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3051_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3051_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForAddStructuralFeatureValueActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_AddStructuralFeatureValueAction_3091_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_AddStructuralFeatureValueAction_3091_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForValueSpecificationActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValueSpecificationAction_3076_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValueSpecificationAction_3076_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForTimeConstraintAsLocalPostcondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_TimeConstraint_3037_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForActivityDiagramEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup links = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		if(!links.isEmpty()) {
			result.add(links);
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
	private Object[] getViewChildrenForActionInputPinInCallOpActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3021_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3021_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForMergeNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_MergeNode_3039_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_MergeNode_3039_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForCentralBufferNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CentralBufferNode_3104_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CentralBufferNode_3104_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOutputPinInCallOpActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3024_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3024_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionInputPinInCallOpActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3026_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3026_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForSendObjectActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_SendObjectAction_3042_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_SendObjectAction_3042_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInputPinInSendObjActAsReqEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3048_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3048_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionLocalPreconditionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionLocalPrecondition_4001_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionLocalPrecondition_4001_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForFlowFinalNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_FlowFinalNode_3006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_FlowFinalNode_3006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInCallBeActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3019_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3019_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForControlFlowEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ControlFlow_4004_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ControlFlow_4004_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ControlFlow_4004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForIntervalConstraintAsLocalPostcondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_IntervalConstraint_3033_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForValuePinInCallOpActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3022_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3022_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInBroadcastSignalActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3103_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3103_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActivityPartitionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActivityPartition_3067_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForIntervalConstraintAsLocalPrecondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_IntervalConstraint_3032_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForCommentLinkEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4006_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4006_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityPartitionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InterruptibleActivityRegionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
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
	private Object[] getViewChildrenForJoinNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_JoinNode_3041_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_JoinNode_3041_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionInputPinInOpaqueActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForReadSelfActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ReadSelfAction_3081_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ReadSelfAction_3081_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForExpansionRegionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExpansionRegion_3070_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExpansionRegion_3070_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForExceptionHandlerEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExceptionHandler_4005_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExceptionHandler_4005_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExceptionHandler_4005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInputPinInAddVariableValueActionAsValueEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3101_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3101_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActivityEditPartCN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Activity_3083_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNParametersCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ParameterEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInActivityAsPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInActivityAsPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityPartitionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InterruptibleActivityRegionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForOutputPinInCreateObjectActionAsResultEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3087_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3087_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForValuePinInOpaqueActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForSequenceNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_SequenceNode_3073_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_SequenceNode_3073_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForOutputPinInCallBeActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3020_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3020_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForValuePinInCallBeActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForValuePinInSendObjActAsReqEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3046_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3046_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOutputPinInValSpecActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3077_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3077_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionInputPinInSendObjActAsReqEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3047_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3047_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForReadVariableActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ReadVariableAction_3097_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ReadVariableAction_3097_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForConstraintAsLocalPostcondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForOutputPinInAcceptEventActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3064_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3064_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForDestroyObjectActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DestroyObjectAction_3095_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DestroyObjectAction_3095_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForReadSelfActionOutputPinEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3084_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3084_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActivityEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Activity_2001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityParametersCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ParameterEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInActivityAsPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInActivityAsPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityPartitionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(InterruptibleActivityRegionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActivityEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForCallBehaviorActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CallBehaviorAction_3008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_CallBehaviorAction_3008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForValuePinInSendSigActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3054_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3054_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForReadStructuralFeatureActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ReadStructuralFeatureAction_3088_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ReadStructuralFeatureAction_3088_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForDurationConstraintAsLocalPrecondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DurationConstraint_3034_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInputPinInCallOpActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3027_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3027_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOutputPinInAddStructuralFeatureValueActionAsResultEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3094_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3094_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOutputPinInOpaqueActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForAddVariableValueActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_AddVariableValueAction_3099_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_AddVariableValueAction_3099_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForConstraintAsLocalPrecondEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInputPinInDestroyObjectActionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3096_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3096_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInReadStructuralFeatureAsObjectEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3089_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3089_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForDecisionNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DecisionNode_3038_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_DecisionNode_3038_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForStructuredActivityNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_StructuredActivityNode_3065_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_StructuredActivityNode_3065_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForInterruptibleActivityRegionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InterruptibleActivityRegion_3068_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
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
	private Object[] getViewChildrenForValuePinInSendObjActAsTargetEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3049_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ValuePin_3049_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForOutputPinInReadStructuralFeatureAsResultEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3090_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_OutputPin_3090_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActivityFinalNodeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActivityFinalNode_3005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActivityFinalNode_3005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForInputPinInAddStructuralFeatureValueActionAsObjectEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3092_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_InputPin_3092_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
	private Object[] getViewChildrenForActionInputPinInCallBeActEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ActionInputPin_3018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
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
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), ActivityDiagramEditPart.MODEL_ID), file, false));
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
		case StructuredActivityNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForStructuredActivityNodeEditPart(view, parentElement);
		}
		case CallOperationActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCallOperationActionEditPart(view, parentElement);
		}
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInReadStructuralFeatureAsResultEditPart(view, parentElement);
		}
		case AddVariableValueActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForAddVariableValueActionEditPart(view, parentElement);
		}
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForIntervalConstraintAsLocalPrecondEditPart(view, parentElement);
		}
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInDestroyObjectActionEditPart(view, parentElement);
		}
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInAddStructuralFeatureValueActionAsObjectEditPart(view, parentElement);
		}
		case AcceptEventActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForAcceptEventActionEditPart(view, parentElement);
		}
		case OutputPinInValSpecActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInValSpecActEditPart(view, parentElement);
		}
		case ObjectFlowEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForObjectFlowEditPart(view, parentElement);
		}
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForTimeConstraintAsLocalPrecondEditPart(view, parentElement);
		}
		case ValuePinInCallOpActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInCallOpActEditPart(view, parentElement);
		}
		case ExceptionHandlerEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExceptionHandlerEditPart(view, parentElement);
		}
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInSendSigActAsTargetEditPart(view, parentElement);
		}
		case ActivityPartitionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActivityPartitionEditPart(view, parentElement);
		}
		case ActivityEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActivityEditPart(view, parentElement);
		}
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInOpaqueActEditPart(view, parentElement);
		}
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForAddStructuralFeatureValueActionEditPart(view, parentElement);
		}
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintAsLocalPostcondEditPart(view, parentElement);
		}
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInOpaqueActEditPart(view, parentElement);
		}
		case ValuePinInCallBeActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInCallBeActEditPart(view, parentElement);
		}
		case InputPinInSendSigActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInSendSigActEditPart(view, parentElement);
		}
		case FlowFinalNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForFlowFinalNodeEditPart(view, parentElement);
		}
		case InitialNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInitialNodeEditPart(view, parentElement);
		}
		case ControlFlowEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForControlFlowEditPart(view, parentElement);
		}
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInCallOpActAsTargetEditPart(view, parentElement);
		}
		case JoinNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForJoinNodeEditPart(view, parentElement);
		}
		case SendSignalActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForSendSignalActionEditPart(view, parentElement);
		}
		case ActionLocalPreconditionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionLocalPreconditionEditPart(view, parentElement);
		}
		case ActivityDiagramEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActivityDiagramEditPart(view, parentElement);
		}
		case OutputPinInCallOpActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInCallOpActEditPart(view, parentElement);
		}
		case ActionLocalPostconditionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionLocalPostconditionEditPart(view, parentElement);
		}
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInSendSigActEditPart(view, parentElement);
		}
		case CommentLinkEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentLinkEditPart(view, parentElement);
		}
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInSendSigActAsTargetEditPart(view, parentElement);
		}
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInAddVariableValueActionAsInsertAtEditPart(view, parentElement);
		}
		case ForkNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForForkNodeEditPart(view, parentElement);
		}
		case InputPinInOpaqueActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInOpaqueActEditPart(view, parentElement);
		}
		case CentralBufferNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCentralBufferNodeEditPart(view, parentElement);
		}
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInAcceptEventActionEditPart(view, parentElement);
		}
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInCallOpActAsTargetEditPart(view, parentElement);
		}
		case CommentEditPartCN.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentEditPartCN(view, parentElement);
		}
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInSendObjActAsReqEditPart(view, parentElement);
		}
		case DataStoreNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDataStoreNodeEditPart(view, parentElement);
		}
		case ValueSpecificationActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValueSpecificationActionEditPart(view, parentElement);
		}
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForReadSelfActionOutputPinEditPart(view, parentElement);
		}
		case InputPinInCallBeActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInCallBeActEditPart(view, parentElement);
		}
		case BroadcastSignalActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForBroadcastSignalActionEditPart(view, parentElement);
		}
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForIntervalConstraintAsLocalPostcondEditPart(view, parentElement);
		}
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInSendObjActAsReqEditPart(view, parentElement);
		}
		case ValuePinInSendSigActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInSendSigActEditPart(view, parentElement);
		}
		case SequenceNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForSequenceNodeEditPart(view, parentElement);
		}
		case OutputPinInCallBeActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInCallBeActEditPart(view, parentElement);
		}
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInSendSigActAsTargetEditPart(view, parentElement);
		}
		case ConditionalNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConditionalNodeEditPart(view, parentElement);
		}
		case OpaqueActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOpaqueActionEditPart(view, parentElement);
		}
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForReadStructuralFeatureActionEditPart(view, parentElement);
		}
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInterruptibleActivityRegionEditPart(view, parentElement);
		}
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInCreateObjectActionAsResultEditPart(view, parentElement);
		}
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInAddStructuralFeatureValueActionAsResultEditPart(view, parentElement);
		}
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInSendObjActAsTargetEditPart(view, parentElement);
		}
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInSendObjActAsReqEditPart(view, parentElement);
		}
		case DecisionNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDecisionNodeEditPart(view, parentElement);
		}
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInCallOpActAsTargetEditPart(view, parentElement);
		}
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInSendObjActAsTargetEditPart(view, parentElement);
		}
		case DestroyObjectActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDestroyObjectActionEditPart(view, parentElement);
		}
		case ReadSelfActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForReadSelfActionEditPart(view, parentElement);
		}
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInCallBeActEditPart(view, parentElement);
		}
		case ExpansionRegionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExpansionRegionEditPart(view, parentElement);
		}
		case LoopNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForLoopNodeEditPart(view, parentElement);
		}
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInAddVariableValueActionAsValueEditPart(view, parentElement);
		}
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActionInputPinInCallOpActEditPart(view, parentElement);
		}
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInOpaqueActEditPart(view, parentElement);
		}
		case CreateObjectActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCreateObjectActionEditPart(view, parentElement);
		}
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForOutputPinInReadVariableActionAsResultEditPart(view, parentElement);
		}
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForValuePinInSendObjActAsTargetEditPart(view, parentElement);
		}
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExpansionNodeAsOutEditPart(view, parentElement);
		}
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInAddStructuralFeatureValueActionAsValueEditPart(view, parentElement);
		}
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForTimeConstraintAsLocalPostcondEditPart(view, parentElement);
		}
		case CallBehaviorActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCallBehaviorActionEditPart(view, parentElement);
		}
		case ExpansionNodeAsInEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExpansionNodeAsInEditPart(view, parentElement);
		}
		case SendObjectActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForSendObjectActionEditPart(view, parentElement);
		}
		case InputPinInCallOpActEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInCallOpActEditPart(view, parentElement);
		}
		case ActivityFinalNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActivityFinalNodeEditPart(view, parentElement);
		}
		case ActivityEditPartCN.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActivityEditPartCN(view, parentElement);
		}
		case MergeNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForMergeNodeEditPart(view, parentElement);
		}
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDurationConstraintAsLocalPrecondEditPart(view, parentElement);
		}
		case ReadVariableActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForReadVariableActionEditPart(view, parentElement);
		}
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintAsLocalPrecondEditPart(view, parentElement);
		}
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInReadStructuralFeatureAsObjectEditPart(view, parentElement);
		}
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForInputPinInBroadcastSignalActionEditPart(view, parentElement);
		}
		case ActivityParameterNodeEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActivityParameterNodeEditPart(view, parentElement);
		}
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
		{
			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDurationConstraintAsLocalPostcondEditPart(view, parentElement);
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
		return ActivityDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
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
