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

import org.eclipse.uml2.uml.LoopNode;

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
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.InputPin;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart;
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
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class LoopNodeBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private LoopNode loopNode;

	/**
	 * The Base part
	 */
	private LoopNodePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public LoopNodeBasePropertiesEditionComponent(EObject loopNode, String editing_mode) {
		if (loopNode instanceof LoopNode) {
			this.loopNode = (LoopNode) loopNode;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.loopNode.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(loopNode);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(loopNode);
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature()))
					basePart.updateOutgoing(loopNode);
				if (UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature()))
					basePart.updateIncoming(loopNode);
				if (UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature()))
					basePart.updateInPartition(loopNode);
				if (UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature()))
					basePart.updateInInterruptibleRegion(loopNode);
				if (UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature()))
					basePart.updateRedefinedNode(loopNode);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getExecutableNode_Handler() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getExceptionHandler())) {
					basePart.updateHandler(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPrecondition() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateLocalPrecondition(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPostcondition() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateLocalPostcondition(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getElementImport())) {
					basePart.updateElementImport(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getPackageImport())) {
					basePart.updatePackageImport(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConstraint())) {
					basePart.updateOwnedRule(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Variable() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getVariable())) {
					basePart.updateVariable(loopNode);
				}
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Edge() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getActivityEdge())) {
					basePart.updateEdge(loopNode);
				}
				if (UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().equals(msg.getFeature()) && basePart != null)
					basePart.setMustIsolate((Boolean) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Node() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getActivityNode())) {
					basePart.updateNode(loopNode);
				}
				if (UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst().equals(msg.getFeature()) && basePart != null)
					basePart.setIsTestedFirst((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getLoopNode_BodyPart().equals(msg.getFeature()))
					basePart.updateBodyPart(loopNode);
				if (UMLPackage.eINSTANCE.getLoopNode_SetupPart().equals(msg.getFeature()))
					basePart.updateSetupPart(loopNode);
				if (UMLPackage.eINSTANCE.getLoopNode_Test().equals(msg.getFeature()))
					basePart.updateTest(loopNode);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getLoopNode_Result() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getOutputPin())) {
					basePart.updateResult(loopNode);
				}
				if (UMLPackage.eINSTANCE.getLoopNode_LoopVariable().equals(msg.getFeature()))
					basePart.updateLoopVariable(loopNode);
				if (UMLPackage.eINSTANCE.getLoopNode_BodyOutput().equals(msg.getFeature()))
					basePart.updateBodyOutput(loopNode);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getInputPin())) {
					basePart.updateLoopVariableInput(loopNode);
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
			return UMLViewsRepository.LoopNode.class;
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
		if (loopNode != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (LoopNodePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.LoopNode.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.LoopNode.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			LoopNode loopNode = (LoopNode) elt;
			basePart.initOwnedComment(loopNode, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (loopNode.getName() != null)
				basePart.setName(loopNode.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), loopNode.getVisibility());
			basePart.initClientDependency(loopNode, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.setIsLeaf(loopNode.isLeaf());

			basePart.initOutgoing(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());
			basePart.initIncoming(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());
			basePart.initInPartition(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());
			basePart.initInInterruptibleRegion(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
			basePart.initRedefinedNode(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());
			basePart.initHandler(loopNode, null, UMLPackage.eINSTANCE.getExecutableNode_Handler());
			basePart.initLocalPrecondition(loopNode, null, UMLPackage.eINSTANCE.getAction_LocalPrecondition());
			basePart.initLocalPostcondition(loopNode, null, UMLPackage.eINSTANCE.getAction_LocalPostcondition());
			basePart.initElementImport(loopNode, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(loopNode, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(loopNode, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.initVariable(loopNode, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable());
			basePart.initEdge(loopNode, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge());
			basePart.setMustIsolate(loopNode.isMustIsolate());

			basePart.initNode(loopNode, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
			basePart.setIsTestedFirst(loopNode.isTestedFirst());

			basePart.initBodyPart(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_BodyPart());
			basePart.initSetupPart(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_SetupPart());
			basePart.initTest(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_Test());
			basePart.initResult(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_Result());
			basePart.initLoopVariable(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_LoopVariable());
			basePart.initBodyOutput(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_BodyOutput());
			basePart.initLoopVariableInput(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (loopNode != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List outgoingToAdd = basePart.getOutgoingToAdd();
			for (Iterator iter = outgoingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemove = basePart.getOutgoingToRemove();
			for (Iterator iter = outgoingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			// List outgoingToMove = basePart.getOutgoingToMove();
			// for (Iterator iter = outgoingToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List incomingToAdd = basePart.getIncomingToAdd();
			for (Iterator iter = incomingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemove = basePart.getIncomingToRemove();
			for (Iterator iter = incomingToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			// List incomingToMove = basePart.getIncomingToMove();
			// for (Iterator iter = incomingToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List inPartitionToAdd = basePart.getInPartitionToAdd();
			for (Iterator iter = inPartitionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemove = basePart.getInPartitionToRemove();
			for (Iterator iter = inPartitionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			// List inPartitionToMove = basePart.getInPartitionToMove();
			// for (Iterator iter = inPartitionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List inInterruptibleRegionToAdd = basePart.getInInterruptibleRegionToAdd();
			for (Iterator iter = inInterruptibleRegionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemove = basePart.getInInterruptibleRegionToRemove();
			for (Iterator iter = inInterruptibleRegionToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			// List inInterruptibleRegionToMove = basePart.getInInterruptibleRegionToMove();
			// for (Iterator iter = inInterruptibleRegionToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List redefinedNodeToAdd = basePart.getRedefinedNodeToAdd();
			for (Iterator iter = redefinedNodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemove = basePart.getRedefinedNodeToRemove();
			for (Iterator iter = redefinedNodeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			// List redefinedNodeToMove = basePart.getRedefinedNodeToMove();
			// for (Iterator iter = redefinedNodeToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List handlerToAdd = basePart.getHandlerToAdd();
			for (Iterator iter = handlerToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode_Handler(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExceptionHandler(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPreconditionToAdd = basePart.getLocalPreconditionToAdd();
			for (Iterator iter = localPreconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPostconditionToAdd = basePart.getLocalPostconditionToAdd();
			for (Iterator iter = localPostconditionToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List elementImportToAdd = basePart.getElementImportToAdd();
			for (Iterator iter = elementImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
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
			for (Iterator iter = elementImportToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAdd = basePart.getPackageImportToAdd();
			for (Iterator iter = packageImportToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
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
			for (Iterator iter = packageImportToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAdd = basePart.getOwnedRuleToAdd();
			for (Iterator iter = ownedRuleToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
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
			for (Iterator iter = ownedRuleToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List variableToAdd = basePart.getVariableToAdd();
			for (Iterator iter = variableToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable(), iter.next()));
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
			for (Iterator iter = variableToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getVariable(), moveElement.getElement(), moveElement.getIndex()));
			}
			List edgeToAdd = basePart.getEdgeToAdd();
			for (Iterator iter = edgeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge(), iter.next()));
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
			for (Iterator iter = edgeToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate(), basePart.getMustIsolate()));

			List nodeToAdd = basePart.getNodeToAdd();
			for (Iterator iter = nodeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), iter.next()));
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
			for (Iterator iter = nodeToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst(), basePart.getIsTestedFirst()));

			List bodyPartToAdd = basePart.getBodyPartToAdd();
			for (Iterator iter = bodyPartToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), iter.next()));
			List bodyPartToRemove = basePart.getBodyPartToRemove();
			for (Iterator iter = bodyPartToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), iter.next()));
			// List bodyPartToMove = basePart.getBodyPartToMove();
			// for (Iterator iter = bodyPartToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List setupPartToAdd = basePart.getSetupPartToAdd();
			for (Iterator iter = setupPartToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), iter.next()));
			List setupPartToRemove = basePart.getSetupPartToRemove();
			for (Iterator iter = setupPartToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), iter.next()));
			// List setupPartToMove = basePart.getSetupPartToMove();
			// for (Iterator iter = setupPartToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List testToAdd = basePart.getTestToAdd();
			for (Iterator iter = testToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), iter.next()));
			List testToRemove = basePart.getTestToRemove();
			for (Iterator iter = testToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), iter.next()));
			// List testToMove = basePart.getTestToMove();
			// for (Iterator iter = testToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List resultToAdd = basePart.getResultToAdd();
			for (Iterator iter = resultToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Result(), iter.next()));
			Map resultToRefresh = basePart.getResultToEdit();
			for (Iterator iter = resultToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for result reference refreshment

				OutputPin nextElement = (OutputPin) iter.next();
				OutputPin result = (OutputPin) resultToRefresh.get(nextElement);

				// End of user code
			}
			List resultToRemove = basePart.getResultToRemove();
			for (Iterator iter = resultToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List resultToMove = basePart.getResultToMove();
			for (Iterator iter = resultToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			}
			List loopVariableToAdd = basePart.getLoopVariableToAdd();
			for (Iterator iter = loopVariableToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), iter.next()));
			List loopVariableToRemove = basePart.getLoopVariableToRemove();
			for (Iterator iter = loopVariableToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), iter.next()));
			// List loopVariableToMove = basePart.getLoopVariableToMove();
			// for (Iterator iter = loopVariableToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List bodyOutputToAdd = basePart.getBodyOutputToAdd();
			for (Iterator iter = bodyOutputToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), iter.next()));
			List bodyOutputToRemove = basePart.getBodyOutputToRemove();
			for (Iterator iter = bodyOutputToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), iter.next()));
			// List bodyOutputToMove = basePart.getBodyOutputToMove();
			// for (Iterator iter = bodyOutputToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List loopVariableInputToAdd = basePart.getLoopVariableInputToAdd();
			for (Iterator iter = loopVariableInputToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput(), iter.next()));
			Map loopVariableInputToRefresh = basePart.getLoopVariableInputToEdit();
			for (Iterator iter = loopVariableInputToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for loopVariableInput reference refreshment

				InputPin nextElement = (InputPin) iter.next();
				InputPin loopVariableInput = (InputPin) loopVariableInputToRefresh.get(nextElement);

				// End of user code
			}
			List loopVariableInputToRemove = basePart.getLoopVariableInputToRemove();
			for (Iterator iter = loopVariableInputToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List loopVariableInputToMove = basePart.getLoopVariableInputToMove();
			for (Iterator iter = loopVariableInputToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getInputPin(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof LoopNode) {
			LoopNode loopNodeToUpdate = (LoopNode) source;
			loopNodeToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			loopNodeToUpdate.setName(basePart.getName());

			loopNodeToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			loopNodeToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			loopNodeToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			loopNodeToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			loopNodeToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			loopNodeToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			loopNodeToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			loopNodeToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			loopNodeToUpdate.getHandlers().addAll(basePart.getHandlerToAdd());
			loopNodeToUpdate.getLocalPreconditions().addAll(basePart.getLocalPreconditionToAdd());
			loopNodeToUpdate.getLocalPostconditions().addAll(basePart.getLocalPostconditionToAdd());
			loopNodeToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			loopNodeToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			loopNodeToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			loopNodeToUpdate.getVariables().addAll(basePart.getVariableToAdd());
			loopNodeToUpdate.getEdges().addAll(basePart.getEdgeToAdd());
			loopNodeToUpdate.setMustIsolate(new Boolean(basePart.getMustIsolate()).booleanValue());

			loopNodeToUpdate.getNodes().addAll(basePart.getNodeToAdd());
			loopNodeToUpdate.setIsTestedFirst(new Boolean(basePart.getIsTestedFirst()).booleanValue());

			loopNodeToUpdate.getBodyParts().addAll(basePart.getBodyPartToAdd());
			loopNodeToUpdate.getSetupParts().addAll(basePart.getSetupPartToAdd());
			loopNodeToUpdate.getTests().addAll(basePart.getTestToAdd());
			loopNodeToUpdate.getResults().addAll(basePart.getResultToAdd());
			loopNodeToUpdate.getLoopVariables().addAll(basePart.getLoopVariableToAdd());
			loopNodeToUpdate.getBodyOutputs().addAll(basePart.getBodyOutputToAdd());
			loopNodeToUpdate.getLoopVariableInputs().addAll(basePart.getLoopVariableInputToAdd());

			return loopNodeToUpdate;
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
			if (UMLViewsRepository.LoopNode.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.LoopNode.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.LoopNode.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.LoopNode.outgoing == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.incoming == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.inPartition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.inInterruptibleRegion == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.redefinedNode == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.handler == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ExceptionHandler oldValue = (ExceptionHandler) event.getOldValue();
					ExceptionHandler newValue = (ExceptionHandler) event.getNewValue();

					// Start of user code for handler live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode_Handler(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getExceptionHandler(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.localPrecondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for localPrecondition live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.localPostcondition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for localPostcondition live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.elementImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport) event.getOldValue();
					ElementImport newValue = (ElementImport) event.getNewValue();

					// Start of user code for elementImport live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.packageImport == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport) event.getOldValue();
					PackageImport newValue = (PackageImport) event.getNewValue();

					// Start of user code for packageImport live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.ownedRule == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint) event.getOldValue();
					Constraint newValue = (Constraint) event.getNewValue();

					// Start of user code for ownedRule live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.variable == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Variable oldValue = (Variable) event.getOldValue();
					Variable newValue = (Variable) event.getNewValue();

					// Start of user code for variable live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getVariable(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.edge == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ActivityEdge oldValue = (ActivityEdge) event.getOldValue();
					ActivityEdge newValue = (ActivityEdge) event.getNewValue();

					// Start of user code for edge live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.mustIsolate == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate(), event.getNewValue()));

			if (UMLViewsRepository.LoopNode.node == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ActivityNode oldValue = (ActivityNode) event.getOldValue();
					ActivityNode newValue = (ActivityNode) event.getNewValue();

					// Start of user code for node live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.isTestedFirst == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst(), event.getNewValue()));

			if (UMLViewsRepository.LoopNode.bodyPart == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.setupPart == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.test == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.result == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					OutputPin oldValue = (OutputPin) event.getOldValue();
					OutputPin newValue = (OutputPin) event.getNewValue();

					// Start of user code for result live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Result(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.loopVariable == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.bodyOutput == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.LoopNode.loopVariableInput == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					InputPin oldValue = (InputPin) event.getOldValue();
					InputPin newValue = (InputPin) event.getNewValue();

					// Start of user code for loopVariableInput live update command
					// TODO: Complete the loopNode update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getInputPin(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.LoopNode.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.LoopNode.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.LoopNode.isLeaf || key == UMLViewsRepository.LoopNode.mustIsolate || key == UMLViewsRepository.LoopNode.isTestedFirst;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.LoopNode.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.outgoing)
			return "Edges that have the node as source."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.incoming)
			return "Edges that have the node as target."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.inPartition)
			return "Partitions containing the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.inInterruptibleRegion)
			return "Interruptible regions containing the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.redefinedNode)
			return "Inherited nodes replaced by this node in a specialization of the activity."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.handler)
			return "A set of exception handlers that are examined if an uncaught exception propagates to the outer level of the executable node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.localPrecondition)
			return "Constraint that must be satisfied when execution is started."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.localPostcondition)
			return "Constraint that must be satisfied when executed is completed."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.elementImport)
			return "References the ElementImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.packageImport)
			return "References the PackageImports owned by the Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.ownedRule)
			return "Specifies a set of Constraints owned by this Namespace."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.variable)
			return "A variable defined in the scope of the structured activity node. It has no value and may not be accessed"; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.edge)
			return "Edges immediately contained in the structured node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.mustIsolate)
			return "If true, then the actions in the node execute in isolation from actions outside the node."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.node)
			return "Nodes immediately contained in the group."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.isTestedFirst)
			return "If true, the test is performed before the first execution of the body.If false, the body is executed once before the test is performed."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.bodyPart)
			return "The set of nodes and edges that perform the repetitive computations of the loop. The body section is executed as long as the test section produces a true value."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.setupPart)
			return "The set of nodes and edges that initialize values or perform other setup computations for the loop."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.test)
			return "The set of nodes, edges, and designated value that compute a Boolean value to determine if another execution of the body will be performed."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.result)
			return "A list of output pins that constitute the data flow output of the entire loop."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.loopVariable)
			return "A list of output pins that hold the values of the loop variables during an execution of the loop. When the test fails, the values are movied to the result pins of the loop."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.bodyOutput)
			return "A list of output pins within the body fragment the values of which are moved to the loop variable pins after completion of execution of the body, before the next iteration of the loop begins or before the loop exits."; //$NON-NLS-1$
		if (key == UMLViewsRepository.LoopNode.loopVariableInput)
			return "A list of values that are moved into the loop variable pins before the first iteration of the loop."; //$NON-NLS-1$
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
			if (UMLViewsRepository.LoopNode.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.LoopNode.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.LoopNode.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.LoopNode.mustIsolate == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.LoopNode.isTestedFirst == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(loopNode);
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
			loopNode.eAdapters().remove(semanticAdapter);
	}

}
