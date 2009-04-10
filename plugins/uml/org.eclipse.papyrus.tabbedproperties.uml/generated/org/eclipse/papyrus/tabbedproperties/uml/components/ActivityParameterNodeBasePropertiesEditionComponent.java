/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ActivityParameterNodePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ActivityParameterNodeBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private ActivityParameterNode activityParameterNode;
	
	/**
	 * The Base part
	 */
	private ActivityParameterNodePropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public ActivityParameterNodeBasePropertiesEditionComponent(EObject activityParameterNode, String mode) {
		if (activityParameterNode instanceof ActivityParameterNode) {
			this.activityParameterNode = (ActivityParameterNode)activityParameterNode;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.activityParameterNode.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.mode = mode;
	}
	
	/**
	 * Initialize the semantic model listener for live editing mode
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getComment())) {
					basePart.updateOwnedComment(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())) {
					basePart.updateClientDependency(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature())) {
					basePart.updateOutgoing(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature())) {
					basePart.updateIncoming(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature())) {
					basePart.updateInPartition(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature())) {
					basePart.updateInInterruptibleRegion(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature())) {
					basePart.updateRedefinedNode(activityParameterNode);
				}
				if (UMLPackage.eINSTANCE.getObjectNode_Ordering().equals(msg.getFeature()) && basePart != null)
					basePart.setOrdering((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getObjectNode_IsControlType().equals(msg.getFeature()) && basePart != null)
					basePart.setIsControlType((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getObjectNode_InState().equals(msg.getFeature())) {
					basePart.updateInState(activityParameterNode);
				}


			}

		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.ActivityParameterNode.class;
		return super.translatePart(key);
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (activityParameterNode != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ActivityParameterNodePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.ActivityParameterNode.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent
	 * 		#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 * 						org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == UMLViewsRepository.ActivityParameterNode.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			ActivityParameterNode activityParameterNode = (ActivityParameterNode)elt;
			basePart.initOwnedComment(activityParameterNode, null, UMLPackage.eINSTANCE.getElement_OwnedComment());				
			if (activityParameterNode.getName() != null)
				basePart.setName(activityParameterNode.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), activityParameterNode.getVisibility());				
			basePart.initClientDependency(activityParameterNode, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());				
			basePart.setIsLeaf(activityParameterNode.isLeaf());				
			basePart.initOutgoing(activityParameterNode, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());				
			basePart.initIncoming(activityParameterNode, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());				
			basePart.initInPartition(activityParameterNode, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());				
			basePart.initInInterruptibleRegion(activityParameterNode, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());				
			basePart.initRedefinedNode(activityParameterNode, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());				
			basePart.initOrdering((EEnum) UMLPackage.eINSTANCE.getObjectNode_Ordering().getEType(), activityParameterNode.getOrdering());				
			basePart.setIsControlType(activityParameterNode.isControlType());				
			basePart.initInState(activityParameterNode, null, UMLPackage.eINSTANCE.getObjectNode_InState());				
		}

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 * (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (activityParameterNode != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
			Map ownedCommentToRefresh = basePart.getOwnedCommentToEdit();
			for (Iterator iter = ownedCommentToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for ownedComment reference refreshment
				
				Comment nextElement = (Comment) iter.next();
				Comment ownedComment = (Comment) ownedCommentToRefresh.get(nextElement);
				
				// End of user code			
			}
			List ownedCommentToRemove = basePart.getOwnedCommentToRemove();
			for (Iterator iter = ownedCommentToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedCommentToMove = basePart.getOwnedCommentToMove();
			for (Iterator iter = ownedCommentToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMove = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));
			List outgoingToAdd = basePart.getOutgoingToAdd();
			for (Iterator iter = outgoingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemove = basePart.getOutgoingToRemove();
			for (Iterator iter = outgoingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			//List outgoingToMove = basePart.getOutgoingToMove();
			//for (Iterator iter = outgoingToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List incomingToAdd = basePart.getIncomingToAdd();
			for (Iterator iter = incomingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemove = basePart.getIncomingToRemove();
			for (Iterator iter = incomingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			//List incomingToMove = basePart.getIncomingToMove();
			//for (Iterator iter = incomingToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inPartitionToAdd = basePart.getInPartitionToAdd();
			for (Iterator iter = inPartitionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemove = basePart.getInPartitionToRemove();
			for (Iterator iter = inPartitionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			//List inPartitionToMove = basePart.getInPartitionToMove();
			//for (Iterator iter = inPartitionToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inInterruptibleRegionToAdd = basePart.getInInterruptibleRegionToAdd();
			for (Iterator iter = inInterruptibleRegionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemove = basePart.getInInterruptibleRegionToRemove();
			for (Iterator iter = inInterruptibleRegionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			//List inInterruptibleRegionToMove = basePart.getInInterruptibleRegionToMove();
			//for (Iterator iter = inInterruptibleRegionToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedNodeToAdd = basePart.getRedefinedNodeToAdd();
			for (Iterator iter = redefinedNodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemove = basePart.getRedefinedNodeToRemove();
			for (Iterator iter = redefinedNodeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			//List redefinedNodeToMove = basePart.getRedefinedNodeToMove();
			//for (Iterator iter = redefinedNodeToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_Ordering(), basePart.getOrdering()));
			cc.append(SetCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_IsControlType(), basePart.getIsControlType()));
			List inStateToAdd = basePart.getInStateToAdd();
			for (Iterator iter = inStateToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_InState(), iter.next()));
			List inStateToRemove = basePart.getInStateToRemove();
			for (Iterator iter = inStateToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_InState(), iter.next()));
			//List inStateToMove = basePart.getInStateToMove();
			//for (Iterator iter = inStateToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, activityParameterNode, UMLPackage.eINSTANCE.getState(), moveElement.getElement(), moveElement.getIndex()));
			//}


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject
	 * ()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof ActivityParameterNode) {
			ActivityParameterNode activityParameterNodeToUpdate = (ActivityParameterNode)source;
			activityParameterNodeToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			activityParameterNodeToUpdate.setName(basePart.getName());
			activityParameterNodeToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			activityParameterNodeToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			activityParameterNodeToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());
			activityParameterNodeToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			activityParameterNodeToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			activityParameterNodeToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			activityParameterNodeToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			activityParameterNodeToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			activityParameterNodeToUpdate.setOrdering((ObjectNodeOrderingKind)basePart.getOrdering());
			activityParameterNodeToUpdate.setIsControlType(new Boolean(basePart.getIsControlType()).booleanValue());
			activityParameterNodeToUpdate.getInStates().addAll(basePart.getInStateToAdd());


			return activityParameterNodeToUpdate;
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PathedPropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
			CompoundCommand command = new CompoundCommand();
			if (UMLViewsRepository.ActivityParameterNode.ownedComment == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();
					// Start of user code for ownedComment live update command
					// TODO: Complete the activityParameterNode update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.ActivityParameterNode.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.ActivityParameterNode.clientDependency == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.ActivityParameterNode.outgoing == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.incoming == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.inPartition == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.inInterruptibleRegion == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.redefinedNode == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ActivityParameterNode.ordering == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_Ordering(), event.getNewValue()));

			if (UMLViewsRepository.ActivityParameterNode.isControlType == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_IsControlType(), event.getNewValue()));

			if (UMLViewsRepository.ActivityParameterNode.inState == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, activityParameterNode, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue(), event.getNewIndex()));
			}


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (UMLViewsRepository.ActivityParameterNode.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				
				
				
				
				
				
				
				


			} else {
				
				if (UMLViewsRepository.ActivityParameterNode.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				
				
				
				
				
				
				
				


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.ActivityParameterNode.isLeaf || key == UMLViewsRepository.ActivityParameterNode.ordering || key == UMLViewsRepository.ActivityParameterNode.isControlType;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.ActivityParameterNode.ownedComment)
				return "The Comments owned by this element."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.clientDependency)
				return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.isLeaf)
				return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.outgoing)
				return "Edges that have the node as source."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.incoming)
				return "Edges that have the node as target."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.inPartition)
				return "Partitions containing the node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.inInterruptibleRegion)
				return "Interruptible regions containing the node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.redefinedNode)
				return "Inherited nodes replaced by this node in a specialization of the activity."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.ordering)
				return "Tells whether and how the tokens in the object node are ordered for selection to traverse edges outgoing from the object node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.isControlType)
				return "Tells whether the type of the object node is to be treated as control."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ActivityParameterNode.inState)
				return "The required states of the object available at this point in the activity."; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PathedPropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (UMLViewsRepository.ActivityParameterNode.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ActivityParameterNode.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ActivityParameterNode.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ActivityParameterNode.ordering == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getObjectNode_Ordering().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getObjectNode_Ordering().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ActivityParameterNode.isControlType == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getObjectNode_IsControlType().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getObjectNode_IsControlType().getEAttributeType(), newValue);
			}

		} catch (IllegalArgumentException iae) {
			ret = BasicDiagnostic.toDiagnostic(iae);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		if (IPropertiesEditionComponent.BATCH_MODE.equals(mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(mode))
			return Diagnostician.INSTANCE.validate(activityParameterNode);
		else
			return null;
	}
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			activityParameterNode.eAdapters().remove(semanticAdapter);
	}

}

