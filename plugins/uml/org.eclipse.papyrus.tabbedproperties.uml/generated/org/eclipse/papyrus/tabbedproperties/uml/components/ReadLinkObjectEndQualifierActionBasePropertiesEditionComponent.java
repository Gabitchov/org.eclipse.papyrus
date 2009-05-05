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

import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Constraint;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ReadLinkObjectEndQualifierActionPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ReadLinkObjectEndQualifierActionBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction;

	/**
	 * The Base part
	 */
	private ReadLinkObjectEndQualifierActionPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ReadLinkObjectEndQualifierActionBasePropertiesEditionComponent(EObject readLinkObjectEndQualifierAction, String editing_mode) {
		if (readLinkObjectEndQualifierAction instanceof ReadLinkObjectEndQualifierAction) {
			this.readLinkObjectEndQualifierAction = (ReadLinkObjectEndQualifierAction) readLinkObjectEndQualifierAction;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.readLinkObjectEndQualifierAction.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(readLinkObjectEndQualifierAction);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(readLinkObjectEndQualifierAction);
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature()))
					basePart.updateOutgoing(readLinkObjectEndQualifierAction);
				if (UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature()))
					basePart.updateIncoming(readLinkObjectEndQualifierAction);
				if (UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature()))
					basePart.updateInPartition(readLinkObjectEndQualifierAction);
				if (UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature()))
					basePart.updateInInterruptibleRegion(readLinkObjectEndQualifierAction);
				if (UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature()))
					basePart.updateRedefinedNode(readLinkObjectEndQualifierAction);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getExecutableNode_Handler() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getExceptionHandler())) {
					basePart.updateHandler(readLinkObjectEndQualifierAction);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPrecondition() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateLocalPrecondition(readLinkObjectEndQualifierAction);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPostcondition() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateLocalPostcondition(readLinkObjectEndQualifierAction);
				}

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
			return UMLViewsRepository.ReadLinkObjectEndQualifierAction.class;
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
		if (readLinkObjectEndQualifierAction != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ReadLinkObjectEndQualifierActionPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.ReadLinkObjectEndQualifierAction.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction = (ReadLinkObjectEndQualifierAction) elt;
			basePart.initOwnedComment(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (readLinkObjectEndQualifierAction.getName() != null)
				basePart.setName(readLinkObjectEndQualifierAction.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), readLinkObjectEndQualifierAction.getVisibility());
			basePart.initClientDependency(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.setIsLeaf(readLinkObjectEndQualifierAction.isLeaf());

			basePart.initOutgoing(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());
			basePart.initIncoming(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());
			basePart.initInPartition(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());
			basePart.initInInterruptibleRegion(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
			basePart.initRedefinedNode(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());
			basePart.initHandler(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getExecutableNode_Handler());
			basePart.initLocalPrecondition(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getAction_LocalPrecondition());
			basePart.initLocalPostcondition(readLinkObjectEndQualifierAction, null, UMLPackage.eINSTANCE.getAction_LocalPostcondition());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (readLinkObjectEndQualifierAction != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			cc.append(SetCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List outgoingToAdd = basePart.getOutgoingToAdd();
			for (Iterator iter = outgoingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemove = basePart.getOutgoingToRemove();
			for (Iterator iter = outgoingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			// List outgoingToMove = basePart.getOutgoingToMove();
			// for (Iterator iter = outgoingToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List incomingToAdd = basePart.getIncomingToAdd();
			for (Iterator iter = incomingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemove = basePart.getIncomingToRemove();
			for (Iterator iter = incomingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			// List incomingToMove = basePart.getIncomingToMove();
			// for (Iterator iter = incomingToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List inPartitionToAdd = basePart.getInPartitionToAdd();
			for (Iterator iter = inPartitionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemove = basePart.getInPartitionToRemove();
			for (Iterator iter = inPartitionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			// List inPartitionToMove = basePart.getInPartitionToMove();
			// for (Iterator iter = inPartitionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List inInterruptibleRegionToAdd = basePart.getInInterruptibleRegionToAdd();
			for (Iterator iter = inInterruptibleRegionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemove = basePart.getInInterruptibleRegionToRemove();
			for (Iterator iter = inInterruptibleRegionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			// List inInterruptibleRegionToMove = basePart.getInInterruptibleRegionToMove();
			// for (Iterator iter = inInterruptibleRegionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedNodeToAdd = basePart.getRedefinedNodeToAdd();
			for (Iterator iter = redefinedNodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemove = basePart.getRedefinedNodeToRemove();
			for (Iterator iter = redefinedNodeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			// List redefinedNodeToMove = basePart.getRedefinedNodeToMove();
			// for (Iterator iter = redefinedNodeToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List handlerToAdd = basePart.getHandlerToAdd();
			for (Iterator iter = handlerToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getExecutableNode_Handler(), iter.next()));
			Map handlerToRefresh = basePart.getHandlerToEdit();
			for (Iterator iter = handlerToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for handler reference refreshment

				ExceptionHandler nextElement = (ExceptionHandler) iter.next();
				ExceptionHandler handler = (ExceptionHandler) handlerToRefresh.get(nextElement);

				// End of user code
			}
			List handlerToRemove = basePart.getHandlerToRemove();
			for (Iterator iter = handlerToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List handlerToMove = basePart.getHandlerToMove();
			for (Iterator iter = handlerToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getExceptionHandler(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPreconditionToAdd = basePart.getLocalPreconditionToAdd();
			for (Iterator iter = localPreconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), iter.next()));
			Map localPreconditionToRefresh = basePart.getLocalPreconditionToEdit();
			for (Iterator iter = localPreconditionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for localPrecondition reference refreshment

				Constraint nextElement = (Constraint) iter.next();
				Constraint localPrecondition = (Constraint) localPreconditionToRefresh.get(nextElement);

				// End of user code
			}
			List localPreconditionToRemove = basePart.getLocalPreconditionToRemove();
			for (Iterator iter = localPreconditionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List localPreconditionToMove = basePart.getLocalPreconditionToMove();
			for (Iterator iter = localPreconditionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPostconditionToAdd = basePart.getLocalPostconditionToAdd();
			for (Iterator iter = localPostconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), iter.next()));
			Map localPostconditionToRefresh = basePart.getLocalPostconditionToEdit();
			for (Iterator iter = localPostconditionToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for localPostcondition reference refreshment

				Constraint nextElement = (Constraint) iter.next();
				Constraint localPostcondition = (Constraint) localPostconditionToRefresh.get(nextElement);

				// End of user code
			}
			List localPostconditionToRemove = basePart.getLocalPostconditionToRemove();
			for (Iterator iter = localPostconditionToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List localPostconditionToMove = basePart.getLocalPostconditionToMove();
			for (Iterator iter = localPostconditionToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}

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
		if (source instanceof ReadLinkObjectEndQualifierAction) {
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierActionToUpdate = (ReadLinkObjectEndQualifierAction) source;
			readLinkObjectEndQualifierActionToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			readLinkObjectEndQualifierActionToUpdate.setName(basePart.getName());

			readLinkObjectEndQualifierActionToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			readLinkObjectEndQualifierActionToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			readLinkObjectEndQualifierActionToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			readLinkObjectEndQualifierActionToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			readLinkObjectEndQualifierActionToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			readLinkObjectEndQualifierActionToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			readLinkObjectEndQualifierActionToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			readLinkObjectEndQualifierActionToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			readLinkObjectEndQualifierActionToUpdate.getHandlers().addAll(basePart.getHandlerToAdd());
			readLinkObjectEndQualifierActionToUpdate.getLocalPreconditions().addAll(basePart.getLocalPreconditionToAdd());
			readLinkObjectEndQualifierActionToUpdate.getLocalPostconditions().addAll(basePart.getLocalPostconditionToAdd());

			return readLinkObjectEndQualifierActionToUpdate;
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
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the readLinkObjectEndQualifierAction update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event
							.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.outgoing == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.incoming == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.inPartition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand
							.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.inInterruptibleRegion == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event
							.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.redefinedNode == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event
							.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.handler == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ExceptionHandler oldValue = (ExceptionHandler) event.getOldValue();
					ExceptionHandler newValue = (ExceptionHandler) event.getNewValue();

					// Start of user code for handler live update command
					// TODO: Complete the readLinkObjectEndQualifierAction update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getExecutableNode_Handler(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getExceptionHandler(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.localPrecondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for localPrecondition live update command
					// TODO: Complete the readLinkObjectEndQualifierAction update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.localPostcondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for localPostcondition live update command
					// TODO: Complete the readLinkObjectEndQualifierAction update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, readLinkObjectEndQualifierAction, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.isLeaf;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.outgoing)
			return "Edges that have the node as source."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.incoming)
			return "Edges that have the node as target."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.inPartition)
			return "Partitions containing the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.inInterruptibleRegion)
			return "Interruptible regions containing the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.redefinedNode)
			return "Inherited nodes replaced by this node in a specialization of the activity."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.handler)
			return "A set of exception handlers that are examined if an uncaught exception propagates to the outer level of the executable node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.localPrecondition)
			return "Constraint that must be satisfied when execution is started."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ReadLinkObjectEndQualifierAction.localPostcondition)
			return "Constraint that must be satisfied when executed is completed."; //$NON-NLS-1$
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
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ReadLinkObjectEndQualifierAction.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(readLinkObjectEndQualifierAction);
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
			readLinkObjectEndQualifierAction.eAdapters().remove(semanticAdapter);
	}

}
