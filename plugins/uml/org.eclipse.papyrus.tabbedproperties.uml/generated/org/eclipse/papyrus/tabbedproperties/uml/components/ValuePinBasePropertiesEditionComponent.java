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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ValuePinPropertiesEditionPart;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ValuePinBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private ValuePin valuePin;

	/**
	 * The Base part
	 */
	private ValuePinPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ValuePinBasePropertiesEditionComponent(EObject valuePin, String editing_mode) {
		if(valuePin instanceof ValuePin) {
			this.valuePin = (ValuePin)valuePin;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.valuePin.eAdapters().add(semanticAdapter);
			}
		}
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
				if(basePart == null)
					ValuePinBasePropertiesEditionComponent.this.dispose();
				else {
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElement_OwnedComment())) {
						basePart.updateOwnedComment(valuePin);
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setName((String)msg.getNewValue());
						} else {
							basePart.setName("");
						}
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
						basePart.setVisibility((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
						basePart.updateClientDependency(valuePin);
					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature()))
						basePart.updateOutgoing(valuePin);
					if(UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature()))
						basePart.updateIncoming(valuePin);
					if(UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature()))
						basePart.updateInPartition(valuePin);
					if(UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature()))
						basePart.updateInInterruptibleRegion(valuePin);
					if(UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature()))
						basePart.updateRedefinedNode(valuePin);
					if(UMLPackage.eINSTANCE.getObjectNode_Ordering().equals(msg.getFeature()) && basePart != null)
						basePart.setOrdering((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getObjectNode_IsControlType().equals(msg.getFeature()) && basePart != null)
						basePart.setIsControlType((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getObjectNode_InState().equals(msg.getFeature()))
						basePart.updateInState(valuePin);
					if(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(msg.getFeature()) && basePart != null)
						basePart.setIsOrdered((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(msg.getFeature()) && basePart != null)
						basePart.setIsUnique((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getPin_IsControl().equals(msg.getFeature()) && basePart != null)
						basePart.setIsControl((Boolean)msg.getNewValue());



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
		if(BASE_PART.equals(key))
			return UMLViewsRepository.ValuePin.class;
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
		if(valuePin != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (ValuePinPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.ValuePin.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent# setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if(key == UMLViewsRepository.ValuePin.class)
			this.basePart = (ValuePinPropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.ValuePin.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final ValuePin valuePin = (ValuePin)elt;
			// init values
			basePart.initOwnedComment(valuePin, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if(valuePin.getName() != null)
				basePart.setName(valuePin.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), valuePin.getVisibility());
			basePart.initClientDependency(valuePin, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.setIsLeaf(valuePin.isLeaf());

			basePart.initOutgoing(valuePin, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());
			basePart.initIncoming(valuePin, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());
			basePart.initInPartition(valuePin, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());
			basePart.initInInterruptibleRegion(valuePin, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
			basePart.initRedefinedNode(valuePin, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());
			basePart.initOrdering((EEnum)UMLPackage.eINSTANCE.getObjectNode_Ordering().getEType(), valuePin.getOrdering());
			basePart.setIsControlType(valuePin.isControlType());

			basePart.initInState(valuePin, null, UMLPackage.eINSTANCE.getObjectNode_InState());
			basePart.setIsOrdered(valuePin.isOrdered());

			basePart.setIsUnique(valuePin.isUnique());

			basePart.setIsControl(valuePin.isControl());


			// init filters
			basePart.addFilterToOwnedComment(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Comment); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedComment

			// End of user code


			basePart.addFilterToClientDependency(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInClientDependencyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToClientDependency(new EObjectFilter(UMLPackage.eINSTANCE.getDependency()));
			// Start of user code for additional businessfilters for clientDependency

			// End of user code

			basePart.addFilterToOutgoing(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInOutgoingTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToOutgoing(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for outgoing

			// End of user code
			basePart.addFilterToIncoming(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInIncomingTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToIncoming(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for incoming

			// End of user code
			basePart.addFilterToInPartition(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInPartitionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInPartition(new EObjectFilter(UMLPackage.eINSTANCE.getActivityPartition()));
			// Start of user code for additional businessfilters for inPartition

			// End of user code
			basePart.addFilterToInInterruptibleRegion(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInInterruptibleRegionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInInterruptibleRegion(new EObjectFilter(UMLPackage.eINSTANCE.getInterruptibleActivityRegion()));
			// Start of user code for additional businessfilters for inInterruptibleRegion

			// End of user code
			basePart.addFilterToRedefinedNode(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRedefinedNodeTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRedefinedNode(new EObjectFilter(UMLPackage.eINSTANCE.getActivityNode()));
			// Start of user code for additional businessfilters for redefinedNode

			// End of user code


			basePart.addFilterToInState(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInStateTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInState(new EObjectFilter(UMLPackage.eINSTANCE.getState()));
			// Start of user code for additional businessfilters for inState

			// End of user code



		}
		// init values for referenced views

		// init filters for referenced views

	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *      (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if(valuePin != null) {
			List ownedCommentToAddFromOwnedComment = basePart.getOwnedCommentToAdd();
			for(Iterator iter = ownedCommentToAddFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
			Map ownedCommentToRefreshFromOwnedComment = basePart.getOwnedCommentToEdit();
			for(Iterator iter = ownedCommentToRefreshFromOwnedComment.keySet().iterator(); iter.hasNext();) {



				Comment nextElement = (Comment)iter.next();
				Comment ownedComment = (Comment)ownedCommentToRefreshFromOwnedComment.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedComment.eGet(feature)));
					}
				}



			}
			List ownedCommentToRemoveFromOwnedComment = basePart.getOwnedCommentToRemove();
			for(Iterator iter = ownedCommentToRemoveFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedCommentToMoveFromOwnedComment = basePart.getOwnedCommentToMove();
			for(Iterator iter = ownedCommentToMoveFromOwnedComment.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAddFromClientDependency = basePart.getClientDependencyToAdd();
			for(Iterator iter = clientDependencyToAddFromClientDependency.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemoveFromClientDependency = basePart.getClientDependencyToRemove();
			for(Iterator iter = clientDependencyToRemoveFromClientDependency.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMoveFromClientDependency = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMoveFromClientDependency.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List outgoingToAddFromOutgoing = basePart.getOutgoingToAdd();
			for(Iterator iter = outgoingToAddFromOutgoing.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemoveFromOutgoing = basePart.getOutgoingToRemove();
			for(Iterator iter = outgoingToRemoveFromOutgoing.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			//List outgoingToMoveFromOutgoing = basePart.getOutgoingToMove();
			//for (Iterator iter = outgoingToMoveFromOutgoing.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List incomingToAddFromIncoming = basePart.getIncomingToAdd();
			for(Iterator iter = incomingToAddFromIncoming.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemoveFromIncoming = basePart.getIncomingToRemove();
			for(Iterator iter = incomingToRemoveFromIncoming.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			//List incomingToMoveFromIncoming = basePart.getIncomingToMove();
			//for (Iterator iter = incomingToMoveFromIncoming.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inPartitionToAddFromInPartition = basePart.getInPartitionToAdd();
			for(Iterator iter = inPartitionToAddFromInPartition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemoveFromInPartition = basePart.getInPartitionToRemove();
			for(Iterator iter = inPartitionToRemoveFromInPartition.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			//List inPartitionToMoveFromInPartition = basePart.getInPartitionToMove();
			//for (Iterator iter = inPartitionToMoveFromInPartition.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inInterruptibleRegionToAddFromInInterruptibleRegion = basePart.getInInterruptibleRegionToAdd();
			for(Iterator iter = inInterruptibleRegionToAddFromInInterruptibleRegion.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemoveFromInInterruptibleRegion = basePart.getInInterruptibleRegionToRemove();
			for(Iterator iter = inInterruptibleRegionToRemoveFromInInterruptibleRegion.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			//List inInterruptibleRegionToMoveFromInInterruptibleRegion = basePart.getInInterruptibleRegionToMove();
			//for (Iterator iter = inInterruptibleRegionToMoveFromInInterruptibleRegion.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedNodeToAddFromRedefinedNode = basePart.getRedefinedNodeToAdd();
			for(Iterator iter = redefinedNodeToAddFromRedefinedNode.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemoveFromRedefinedNode = basePart.getRedefinedNodeToRemove();
			for(Iterator iter = redefinedNodeToRemoveFromRedefinedNode.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			//List redefinedNodeToMoveFromRedefinedNode = basePart.getRedefinedNodeToMove();
			//for (Iterator iter = redefinedNodeToMoveFromRedefinedNode.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_Ordering(), basePart.getOrdering()));

			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_IsControlType(), basePart.getIsControlType()));

			List inStateToAddFromInState = basePart.getInStateToAdd();
			for(Iterator iter = inStateToAddFromInState.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_InState(), iter.next()));
			List inStateToRemoveFromInState = basePart.getInStateToRemove();
			for(Iterator iter = inStateToRemoveFromInState.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_InState(), iter.next()));
			//List inStateToMoveFromInState = basePart.getInStateToMove();
			//for (Iterator iter = inStateToMoveFromInState.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getState(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), basePart.getIsOrdered()));

			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), basePart.getIsUnique()));

			cc.append(SetCommand.create(editingDomain, valuePin, UMLPackage.eINSTANCE.getPin_IsControl(), basePart.getIsControl()));



		}
		if(!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if(source instanceof ValuePin) {
			ValuePin valuePinToUpdate = (ValuePin)source;
			valuePinToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			valuePinToUpdate.setName(basePart.getName());

			valuePinToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			valuePinToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			valuePinToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			valuePinToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			valuePinToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			valuePinToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			valuePinToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			valuePinToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			valuePinToUpdate.setOrdering((ObjectNodeOrderingKind)basePart.getOrdering());

			valuePinToUpdate.setIsControlType(new Boolean(basePart.getIsControlType()).booleanValue());

			valuePinToUpdate.getInStates().addAll(basePart.getInStateToAdd());
			valuePinToUpdate.setIsOrdered(new Boolean(basePart.getIsOrdered()).booleanValue());

			valuePinToUpdate.setIsUnique(new Boolean(basePart.getIsUnique()).booleanValue());

			valuePinToUpdate.setIsControl(new Boolean(basePart.getIsControl()).booleanValue());



			return valuePinToUpdate;
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
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.ValuePin.ownedComment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();


					// TODO: Complete the valuePin update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.clientDependency == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.outgoing == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.incoming == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.inPartition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.inInterruptibleRegion == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.redefinedNode == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.ordering == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_Ordering(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.isControlType == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_IsControlType(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.inState == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getObjectNode_InState(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.ValuePin.isOrdered == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.isUnique == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), event.getNewValue()));

			if(UMLViewsRepository.ValuePin.isControl == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, valuePin, UMLPackage.eINSTANCE.getPin_IsControl(), event.getNewValue()));



			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {

				if(UMLViewsRepository.ValuePin.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {

				if(UMLViewsRepository.ValuePin.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.ValuePin.isLeaf || key == UMLViewsRepository.ValuePin.ordering || key == UMLViewsRepository.ValuePin.isControlType || key == UMLViewsRepository.ValuePin.isOrdered || key == UMLViewsRepository.ValuePin.isUnique || key == UMLViewsRepository.ValuePin.isControl;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if(event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if(UMLViewsRepository.ValuePin.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.ordering == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getObjectNode_Ordering().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getObjectNode_Ordering().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.isControlType == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getObjectNode_IsControlType().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getObjectNode_IsControlType().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.isOrdered == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.isUnique == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.ValuePin.isControl == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getPin_IsControl().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getPin_IsControl().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate = Diagnostician.INSTANCE.validate(copy);
		} else if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(valuePin);
		// Start of user code for custom validation check

		// End of user code

		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if(semanticAdapter != null)
			valuePin.eAdapters().remove(semanticAdapter);
	}

}
