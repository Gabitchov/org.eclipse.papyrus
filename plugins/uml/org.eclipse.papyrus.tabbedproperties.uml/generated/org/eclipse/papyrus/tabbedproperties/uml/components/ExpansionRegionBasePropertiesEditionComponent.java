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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ExpansionRegionPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ExpansionRegionBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private ExpansionRegion expansionRegion;
	
	/**
	 * The Base part
	 */
	private ExpansionRegionPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public ExpansionRegionBasePropertiesEditionComponent(EObject expansionRegion, String mode) {
		if (expansionRegion instanceof ExpansionRegion) {
			this.expansionRegion = (ExpansionRegion)expansionRegion;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.expansionRegion.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())) {
					basePart.updateClientDependency(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature())) {
					basePart.updateOutgoing(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature())) {
					basePart.updateIncoming(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature())) {
					basePart.updateInPartition(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature())) {
					basePart.updateInInterruptibleRegion(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature())) {
					basePart.updateRedefinedNode(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getExecutableNode_Handler()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getExceptionHandler())) {
					basePart.updateHandler(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPrecondition()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getConstraint())) {
					basePart.updateLocalPrecondition(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPostcondition()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getConstraint())) {
					basePart.updateLocalPostcondition(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElementImport())) {
					basePart.updateElementImport(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getPackageImport())) {
					basePart.updatePackageImport(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getConstraint())) {
					basePart.updateOwnedRule(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Variable()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getVariable())) {
					basePart.updateVariable(expansionRegion);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Edge()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getActivityEdge())) {
					basePart.updateEdge(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().equals(msg.getFeature()) && basePart != null)
					basePart.setMustIsolate((Boolean)msg.getNewValue());
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Node()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getActivityNode())) {
					basePart.updateNode(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getExpansionRegion_Mode().equals(msg.getFeature()) && basePart != null)
					basePart.setMode((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getExpansionRegion_InputElement().equals(msg.getFeature())) {
					basePart.updateInputElement(expansionRegion);
				}
				if (UMLPackage.eINSTANCE.getExpansionRegion_OutputElement().equals(msg.getFeature())) {
					basePart.updateOutputElement(expansionRegion);
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
			return UMLViewsRepository.ExpansionRegion.class;
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
		if (expansionRegion != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ExpansionRegionPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.ExpansionRegion.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.ExpansionRegion.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			ExpansionRegion expansionRegion = (ExpansionRegion)elt;
			basePart.initOwnedComment(expansionRegion, null, UMLPackage.eINSTANCE.getElement_OwnedComment());				
			if (expansionRegion.getName() != null)
				basePart.setName(expansionRegion.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), expansionRegion.getVisibility());				
			basePart.initClientDependency(expansionRegion, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());				
			basePart.setIsLeaf(expansionRegion.isLeaf());				
			basePart.initOutgoing(expansionRegion, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());				
			basePart.initIncoming(expansionRegion, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());				
			basePart.initInPartition(expansionRegion, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());				
			basePart.initInInterruptibleRegion(expansionRegion, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());				
			basePart.initRedefinedNode(expansionRegion, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());				
			basePart.initHandler(expansionRegion, null, UMLPackage.eINSTANCE.getExecutableNode_Handler());				
			basePart.initLocalPrecondition(expansionRegion, null, UMLPackage.eINSTANCE.getAction_LocalPrecondition());				
			basePart.initLocalPostcondition(expansionRegion, null, UMLPackage.eINSTANCE.getAction_LocalPostcondition());				
			basePart.initElementImport(expansionRegion, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());				
			basePart.initPackageImport(expansionRegion, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());				
			basePart.initOwnedRule(expansionRegion, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());				
			basePart.initVariable(expansionRegion, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable());				
			basePart.initEdge(expansionRegion, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge());				
			basePart.setMustIsolate(expansionRegion.isMustIsolate());				
			basePart.initNode(expansionRegion, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());				
			basePart.initMode((EEnum) UMLPackage.eINSTANCE.getExpansionRegion_Mode().getEType(), expansionRegion.getMode());				
			basePart.initInputElement(expansionRegion, null, UMLPackage.eINSTANCE.getExpansionRegion_InputElement());				
			basePart.initOutputElement(expansionRegion, null, UMLPackage.eINSTANCE.getExpansionRegion_OutputElement());				
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
		if (expansionRegion != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMove = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));
			List outgoingToAdd = basePart.getOutgoingToAdd();
			for (Iterator iter = outgoingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemove = basePart.getOutgoingToRemove();
			for (Iterator iter = outgoingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			//List outgoingToMove = basePart.getOutgoingToMove();
			//for (Iterator iter = outgoingToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List incomingToAdd = basePart.getIncomingToAdd();
			for (Iterator iter = incomingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemove = basePart.getIncomingToRemove();
			for (Iterator iter = incomingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			//List incomingToMove = basePart.getIncomingToMove();
			//for (Iterator iter = incomingToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inPartitionToAdd = basePart.getInPartitionToAdd();
			for (Iterator iter = inPartitionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemove = basePart.getInPartitionToRemove();
			for (Iterator iter = inPartitionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			//List inPartitionToMove = basePart.getInPartitionToMove();
			//for (Iterator iter = inPartitionToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inInterruptibleRegionToAdd = basePart.getInInterruptibleRegionToAdd();
			for (Iterator iter = inInterruptibleRegionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemove = basePart.getInInterruptibleRegionToRemove();
			for (Iterator iter = inInterruptibleRegionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			//List inInterruptibleRegionToMove = basePart.getInInterruptibleRegionToMove();
			//for (Iterator iter = inInterruptibleRegionToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedNodeToAdd = basePart.getRedefinedNodeToAdd();
			for (Iterator iter = redefinedNodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemove = basePart.getRedefinedNodeToRemove();
			for (Iterator iter = redefinedNodeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			//List redefinedNodeToMove = basePart.getRedefinedNodeToMove();
			//for (Iterator iter = redefinedNodeToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List handlerToAdd = basePart.getHandlerToAdd();
			for (Iterator iter = handlerToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExecutableNode_Handler(), iter.next()));
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
			for (Iterator iter = handlerToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExceptionHandler(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPreconditionToAdd = basePart.getLocalPreconditionToAdd();
			for (Iterator iter = localPreconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), iter.next()));
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
			for (Iterator iter = localPreconditionToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPostconditionToAdd = basePart.getLocalPostconditionToAdd();
			for (Iterator iter = localPostconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), iter.next()));
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
			for (Iterator iter = localPostconditionToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
			Map elementImportToRefresh = basePart.getElementImportToEdit();
			for (Iterator iter = elementImportToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for elementImport reference refreshment
				
				ElementImport nextElement = (ElementImport) iter.next();
				ElementImport elementImport = (ElementImport) elementImportToRefresh.get(nextElement);
				
				// End of user code			
			}
			List elementImportToRemove = basePart.getElementImportToRemove();
			for (Iterator iter = elementImportToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List elementImportToMove = basePart.getElementImportToMove();
			for (Iterator iter = elementImportToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
			Map packageImportToRefresh = basePart.getPackageImportToEdit();
			for (Iterator iter = packageImportToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for packageImport reference refreshment
				
				PackageImport nextElement = (PackageImport) iter.next();
				PackageImport packageImport = (PackageImport) packageImportToRefresh.get(nextElement);
				
				// End of user code			
			}
			List packageImportToRemove = basePart.getPackageImportToRemove();
			for (Iterator iter = packageImportToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List packageImportToMove = basePart.getPackageImportToMove();
			for (Iterator iter = packageImportToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
			Map ownedRuleToRefresh = basePart.getOwnedRuleToEdit();
			for (Iterator iter = ownedRuleToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for ownedRule reference refreshment
				
				Constraint nextElement = (Constraint) iter.next();
				Constraint ownedRule = (Constraint) ownedRuleToRefresh.get(nextElement);
				
				// End of user code			
			}
			List ownedRuleToRemove = basePart.getOwnedRuleToRemove();
			for (Iterator iter = ownedRuleToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedRuleToMove = basePart.getOwnedRuleToMove();
			for (Iterator iter = ownedRuleToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List variableToAdd = basePart.getVariableToAdd();
			for (Iterator iter = variableToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable(), iter.next()));
			Map variableToRefresh = basePart.getVariableToEdit();
			for (Iterator iter = variableToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for variable reference refreshment
				
				Variable nextElement = (Variable) iter.next();
				Variable variable = (Variable) variableToRefresh.get(nextElement);
				
				// End of user code			
			}
			List variableToRemove = basePart.getVariableToRemove();
			for (Iterator iter = variableToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List variableToMove = basePart.getVariableToMove();
			for (Iterator iter = variableToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getVariable(), moveElement.getElement(), moveElement.getIndex()));
			}
			List edgeToAdd = basePart.getEdgeToAdd();
			for (Iterator iter = edgeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge(), iter.next()));
			Map edgeToRefresh = basePart.getEdgeToEdit();
			for (Iterator iter = edgeToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for edge reference refreshment
				
				ActivityEdge nextElement = (ActivityEdge) iter.next();
				ActivityEdge edge = (ActivityEdge) edgeToRefresh.get(nextElement);
				
				// End of user code			
			}
			List edgeToRemove = basePart.getEdgeToRemove();
			for (Iterator iter = edgeToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List edgeToMove = basePart.getEdgeToMove();
			for (Iterator iter = edgeToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate(), basePart.getMustIsolate()));
			List nodeToAdd = basePart.getNodeToAdd();
			for (Iterator iter = nodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), iter.next()));
			Map nodeToRefresh = basePart.getNodeToEdit();
			for (Iterator iter = nodeToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for node reference refreshment
				
				ActivityNode nextElement = (ActivityNode) iter.next();
				ActivityNode node = (ActivityNode) nodeToRefresh.get(nextElement);
				
				// End of user code			
			}
			List nodeToRemove = basePart.getNodeToRemove();
			for (Iterator iter = nodeToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List nodeToMove = basePart.getNodeToMove();
			for (Iterator iter = nodeToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_Mode(), basePart.getMode()));
			List inputElementToAdd = basePart.getInputElementToAdd();
			for (Iterator iter = inputElementToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_InputElement(), iter.next()));
			List inputElementToRemove = basePart.getInputElementToRemove();
			for (Iterator iter = inputElementToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_InputElement(), iter.next()));
			//List inputElementToMove = basePart.getInputElementToMove();
			//for (Iterator iter = inputElementToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List outputElementToAdd = basePart.getOutputElementToAdd();
			for (Iterator iter = outputElementToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_OutputElement(), iter.next()));
			List outputElementToRemove = basePart.getOutputElementToRemove();
			for (Iterator iter = outputElementToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_OutputElement(), iter.next()));
			//List outputElementToMove = basePart.getOutputElementToMove();
			//for (Iterator iter = outputElementToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionNode(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof ExpansionRegion) {
			ExpansionRegion expansionRegionToUpdate = (ExpansionRegion)source;
			expansionRegionToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			expansionRegionToUpdate.setName(basePart.getName());
			expansionRegionToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			expansionRegionToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			expansionRegionToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());
			expansionRegionToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			expansionRegionToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			expansionRegionToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			expansionRegionToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			expansionRegionToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			expansionRegionToUpdate.getHandlers().addAll(basePart.getHandlerToAdd());
			expansionRegionToUpdate.getLocalPreconditions().addAll(basePart.getLocalPreconditionToAdd());
			expansionRegionToUpdate.getLocalPostconditions().addAll(basePart.getLocalPostconditionToAdd());
			expansionRegionToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			expansionRegionToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			expansionRegionToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			expansionRegionToUpdate.getVariables().addAll(basePart.getVariableToAdd());
			expansionRegionToUpdate.getEdges().addAll(basePart.getEdgeToAdd());
			expansionRegionToUpdate.setMustIsolate(new Boolean(basePart.getMustIsolate()).booleanValue());
			expansionRegionToUpdate.getNodes().addAll(basePart.getNodeToAdd());
			expansionRegionToUpdate.setMode((ExpansionKind)basePart.getMode());
			expansionRegionToUpdate.getInputElements().addAll(basePart.getInputElementToAdd());
			expansionRegionToUpdate.getOutputElements().addAll(basePart.getOutputElementToAdd());


			return expansionRegionToUpdate;
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
			if (UMLViewsRepository.ExpansionRegion.ownedComment == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();
					// Start of user code for ownedComment live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.ExpansionRegion.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.ExpansionRegion.clientDependency == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.ExpansionRegion.outgoing == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.incoming == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.inPartition == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.inInterruptibleRegion == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.redefinedNode == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.handler == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					ExceptionHandler oldValue = (ExceptionHandler)event.getOldValue();
					ExceptionHandler newValue = (ExceptionHandler)event.getNewValue();
					// Start of user code for handler live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExecutableNode_Handler(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExceptionHandler(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.localPrecondition == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();
					// Start of user code for localPrecondition live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.localPostcondition == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();
					// Start of user code for localPostcondition live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.elementImport == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport)event.getOldValue();
					ElementImport newValue = (ElementImport)event.getNewValue();
					// Start of user code for elementImport live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.packageImport == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport)event.getOldValue();
					PackageImport newValue = (PackageImport)event.getNewValue();
					// Start of user code for packageImport live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.ownedRule == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();
					// Start of user code for ownedRule live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.variable == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Variable oldValue = (Variable)event.getOldValue();
					Variable newValue = (Variable)event.getNewValue();
					// Start of user code for variable live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getVariable(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.edge == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					ActivityEdge oldValue = (ActivityEdge)event.getOldValue();
					ActivityEdge newValue = (ActivityEdge)event.getNewValue();
					// Start of user code for edge live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityEdge(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.mustIsolate == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate(), event.getNewValue()));

			if (UMLViewsRepository.ExpansionRegion.node == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					ActivityNode oldValue = (ActivityNode)event.getOldValue();
					ActivityNode newValue = (ActivityNode)event.getNewValue();
					// Start of user code for node live update command
					// TODO: Complete the expansionRegion update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getActivityNode(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.mode == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_Mode(), event.getNewValue()));

			if (UMLViewsRepository.ExpansionRegion.inputElement == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_InputElement(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_InputElement(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_InputElement(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExpansionRegion.outputElement == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_OutputElement(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_OutputElement(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, expansionRegion, UMLPackage.eINSTANCE.getExpansionRegion_OutputElement(), event.getNewValue(), event.getNewIndex()));
			}


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (UMLViewsRepository.ExpansionRegion.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				


			} else {
				
				if (UMLViewsRepository.ExpansionRegion.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.ExpansionRegion.isLeaf || key == UMLViewsRepository.ExpansionRegion.mustIsolate || key == UMLViewsRepository.ExpansionRegion.mode || key == UMLViewsRepository.ExpansionRegion.inputElement;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.ExpansionRegion.ownedComment)
				return "The Comments owned by this element."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.clientDependency)
				return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.isLeaf)
				return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.outgoing)
				return "Edges that have the node as source."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.incoming)
				return "Edges that have the node as target."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.inPartition)
				return "Partitions containing the node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.inInterruptibleRegion)
				return "Interruptible regions containing the node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.redefinedNode)
				return "Inherited nodes replaced by this node in a specialization of the activity."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.handler)
				return "A set of exception handlers that are examined if an uncaught exception propagates to the outer level of the executable node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.localPrecondition)
				return "Constraint that must be satisfied when execution is started."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.localPostcondition)
				return "Constraint that must be satisfied when executed is completed."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.elementImport)
				return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.packageImport)
				return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.ownedRule)
				return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.variable)
				return "A variable defined in the scope of the structured activity node. It has no value and may not be accessed"; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.edge)
				return "Edges immediately contained in the structured node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.mustIsolate)
				return "If true, then the actions in the node execute in isolation from actions outside the node."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.node)
				return "Nodes immediately contained in the group."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.mode)
				return "The way in which the executions interact:parallel: all interactions are independentiterative: the interactions occur in order of the elementsstream: a stream of values flows into a single execution"; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.inputElement)
				return "An object node that holds a separate element of the input collection during each of the multiple executions of the region."; //$NON-NLS-1$
			if (key == UMLViewsRepository.ExpansionRegion.outputElement)
				return "An object node that accepts a separate element of the output collection during each of the multiple executions of the region. The values are formed into a collection that is available when the execution of the region is complete."; //$NON-NLS-1$
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
			if (UMLViewsRepository.ExpansionRegion.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ExpansionRegion.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ExpansionRegion.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ExpansionRegion.mustIsolate == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.ExpansionRegion.mode == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getExpansionRegion_Mode().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getExpansionRegion_Mode().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(expansionRegion);
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
			expansionRegion.eAdapters().remove(semanticAdapter);
	}

}

