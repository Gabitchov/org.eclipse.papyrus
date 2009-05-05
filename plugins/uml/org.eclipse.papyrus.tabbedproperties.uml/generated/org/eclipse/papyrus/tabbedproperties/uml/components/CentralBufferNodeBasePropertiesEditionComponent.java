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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.MoveCommand;

import org.eclipse.uml2.uml.CentralBufferNode;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.uml.parts.CentralBufferNodePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CentralBufferNodeBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private CentralBufferNode centralBufferNode;

	/**
	 * The Base part
	 */
	private CentralBufferNodePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public CentralBufferNodeBasePropertiesEditionComponent(EObject centralBufferNode, String editing_mode) {
		if (centralBufferNode instanceof CentralBufferNode) {
			this.centralBufferNode = (CentralBufferNode) centralBufferNode;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.centralBufferNode.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
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
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getComment())) {
					basePart.updateOwnedComment(centralBufferNode);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(centralBufferNode);
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature()))
					basePart.updateOutgoing(centralBufferNode);
				if (UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature()))
					basePart.updateIncoming(centralBufferNode);
				if (UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature()))
					basePart.updateInPartition(centralBufferNode);
				if (UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature()))
					basePart.updateInInterruptibleRegion(centralBufferNode);
				if (UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature()))
					basePart.updateRedefinedNode(centralBufferNode);
				if (UMLPackage.eINSTANCE.getObjectNode_Ordering().equals(msg.getFeature()) && basePart != null)
					basePart.setOrdering((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getObjectNode_IsControlType().equals(msg.getFeature()) && basePart != null)
					basePart.setIsControlType((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getObjectNode_InState().equals(msg.getFeature()))
					basePart.updateInState(centralBufferNode);

			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.CentralBufferNode.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (centralBufferNode != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (CentralBufferNodePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.CentralBufferNode.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart) basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == UMLViewsRepository.CentralBufferNode.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			CentralBufferNode centralBufferNode = (CentralBufferNode) elt;
			basePart.initOwnedComment(centralBufferNode, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (centralBufferNode.getName() != null)
				basePart.setName(centralBufferNode.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), centralBufferNode.getVisibility());
			basePart.initClientDependency(centralBufferNode, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.setIsLeaf(centralBufferNode.isLeaf());

			basePart.initOutgoing(centralBufferNode, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());
			basePart.initIncoming(centralBufferNode, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());
			basePart.initInPartition(centralBufferNode, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());
			basePart.initInInterruptibleRegion(centralBufferNode, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
			basePart.initRedefinedNode(centralBufferNode, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());
			basePart.initOrdering((EEnum) UMLPackage.eINSTANCE.getObjectNode_Ordering().getEType(), centralBufferNode.getOrdering());
			basePart.setIsControlType(centralBufferNode.isControlType());

			basePart.initInState(centralBufferNode, null, UMLPackage.eINSTANCE.getObjectNode_InState());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (centralBufferNode != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
			for (Iterator iter = ownedCommentToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			cc.append(SetCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List outgoingToAdd = basePart.getOutgoingToAdd();
			for (Iterator iter = outgoingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemove = basePart.getOutgoingToRemove();
			for (Iterator iter = outgoingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			// List outgoingToMove = basePart.getOutgoingToMove();
			// for (Iterator iter = outgoingToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List incomingToAdd = basePart.getIncomingToAdd();
			for (Iterator iter = incomingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemove = basePart.getIncomingToRemove();
			for (Iterator iter = incomingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			// List incomingToMove = basePart.getIncomingToMove();
			// for (Iterator iter = incomingToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List inPartitionToAdd = basePart.getInPartitionToAdd();
			for (Iterator iter = inPartitionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemove = basePart.getInPartitionToRemove();
			for (Iterator iter = inPartitionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			// List inPartitionToMove = basePart.getInPartitionToMove();
			// for (Iterator iter = inPartitionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List inInterruptibleRegionToAdd = basePart.getInInterruptibleRegionToAdd();
			for (Iterator iter = inInterruptibleRegionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemove = basePart.getInInterruptibleRegionToRemove();
			for (Iterator iter = inInterruptibleRegionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			// List inInterruptibleRegionToMove = basePart.getInInterruptibleRegionToMove();
			// for (Iterator iter = inInterruptibleRegionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedNodeToAdd = basePart.getRedefinedNodeToAdd();
			for (Iterator iter = redefinedNodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemove = basePart.getRedefinedNodeToRemove();
			for (Iterator iter = redefinedNodeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			// List redefinedNodeToMove = basePart.getRedefinedNodeToMove();
			// for (Iterator iter = redefinedNodeToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			cc.append(SetCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_Ordering(), basePart.getOrdering()));

			cc.append(SetCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_IsControlType(), basePart.getIsControlType()));

			List inStateToAdd = basePart.getInStateToAdd();
			for (Iterator iter = inStateToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_InState(), iter.next()));
			List inStateToRemove = basePart.getInStateToRemove();
			for (Iterator iter = inStateToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_InState(), iter.next()));
			// List inStateToMove = basePart.getInStateToMove();
			// for (Iterator iter = inStateToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, centralBufferNode, UMLPackage.eINSTANCE.getState(), moveElement.getElement(), moveElement.getIndex()));
			// }

		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof CentralBufferNode) {
			CentralBufferNode centralBufferNodeToUpdate = (CentralBufferNode) source;
			centralBufferNodeToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			centralBufferNodeToUpdate.setName(basePart.getName());

			centralBufferNodeToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			centralBufferNodeToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			centralBufferNodeToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			centralBufferNodeToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			centralBufferNodeToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			centralBufferNodeToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			centralBufferNodeToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			centralBufferNodeToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			centralBufferNodeToUpdate.setOrdering((ObjectNodeOrderingKind) basePart.getOrdering());

			centralBufferNodeToUpdate.setIsControlType(new Boolean(basePart.getIsControlType()).booleanValue());

			centralBufferNodeToUpdate.getInStates().addAll(basePart.getInStateToAdd());

			return centralBufferNodeToUpdate;
		} else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (UMLViewsRepository.CentralBufferNode.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the centralBufferNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.CentralBufferNode.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.CentralBufferNode.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.CentralBufferNode.outgoing == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.incoming == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.inPartition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.inInterruptibleRegion == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.redefinedNode == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.CentralBufferNode.ordering == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_Ordering(), event.getNewValue()));

			if (UMLViewsRepository.CentralBufferNode.isControlType == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_IsControlType(), event.getNewValue()));

			if (UMLViewsRepository.CentralBufferNode.inState == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, centralBufferNode, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.CentralBufferNode.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.CentralBufferNode.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.CentralBufferNode.isLeaf || key == UMLViewsRepository.CentralBufferNode.ordering || key == UMLViewsRepository.CentralBufferNode.isControlType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.CentralBufferNode.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.outgoing)
			return "Edges that have the node as source."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.incoming)
			return "Edges that have the node as target."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.inPartition)
			return "Partitions containing the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.inInterruptibleRegion)
			return "Interruptible regions containing the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.redefinedNode)
			return "Inherited nodes replaced by this node in a specialization of the activity."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.ordering)
			return "Tells whether and how the tokens in the object node are ordered for selection to traverse edges outgoing from the object node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.isControlType)
			return "Tells whether the type of the object node is to be treated as control."; //$NON-NLS-1$
		if (key == UMLViewsRepository.CentralBufferNode.inState)
			return "The required states of the object available at this point in the activity."; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (UMLViewsRepository.CentralBufferNode.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.CentralBufferNode.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.CentralBufferNode.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.CentralBufferNode.ordering == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getObjectNode_Ordering().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getObjectNode_Ordering().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.CentralBufferNode.isControlType == event.getAffectedEditor()) {
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
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		} else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			return Diagnostician.INSTANCE.validate(centralBufferNode);
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
			centralBufferNode.eAdapters().remove(semanticAdapter);
	}

}
