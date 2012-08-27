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
import org.eclipse.papyrus.tabbedproperties.uml.parts.InformationFlowPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InformationFlowBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private InformationFlow informationFlow;

	/**
	 * The Base part
	 */
	private InformationFlowPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public InformationFlowBasePropertiesEditionComponent(EObject informationFlow, String editing_mode) {
		if(informationFlow instanceof InformationFlow) {
			this.informationFlow = (InformationFlow)informationFlow;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.informationFlow.eAdapters().add(semanticAdapter);
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
					InformationFlowBasePropertiesEditionComponent.this.dispose();
				else {
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElement_OwnedComment())) {
						basePart.updateOwnedComment(informationFlow);
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
						basePart.updateClientDependency(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_Realization().equals(msg.getFeature()))
						basePart.updateRealization(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_Conveyed().equals(msg.getFeature()))
						basePart.updateConveyed(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_InformationSource().equals(msg.getFeature()))
						basePart.updateInformationSource(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_InformationTarget().equals(msg.getFeature()))
						basePart.updateInformationTarget(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge().equals(msg.getFeature()))
						basePart.updateRealizingActivityEdge(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector().equals(msg.getFeature()))
						basePart.updateRealizingConnector(informationFlow);
					if(UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage().equals(msg.getFeature()))
						basePart.updateRealizingMessage(informationFlow);


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
			return UMLViewsRepository.InformationFlow.class;
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
		if(informationFlow != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (InformationFlowPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.InformationFlow.class, kind, this);
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
		if(key == UMLViewsRepository.InformationFlow.class)
			this.basePart = (InformationFlowPropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.InformationFlow.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final InformationFlow informationFlow = (InformationFlow)elt;
			// init values
			basePart.initOwnedComment(informationFlow, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if(informationFlow.getName() != null)
				basePart.setName(informationFlow.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), informationFlow.getVisibility());
			basePart.initClientDependency(informationFlow, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initRealization(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_Realization());
			basePart.initConveyed(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_Conveyed());
			basePart.initInformationSource(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_InformationSource());
			basePart.initInformationTarget(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_InformationTarget());
			basePart.initRealizingActivityEdge(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge());
			basePart.initRealizingConnector(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector());
			basePart.initRealizingMessage(informationFlow, null, UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage());

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
			basePart.addFilterToRealization(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRealizationTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRealization(new EObjectFilter(UMLPackage.eINSTANCE.getRelationship()));
			// Start of user code for additional businessfilters for realization

			// End of user code
			basePart.addFilterToConveyed(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInConveyedTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToConveyed(new EObjectFilter(UMLPackage.eINSTANCE.getClassifier()));
			// Start of user code for additional businessfilters for conveyed

			// End of user code
			basePart.addFilterToInformationSource(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInformationSourceTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInformationSource(new EObjectFilter(UMLPackage.eINSTANCE.getNamedElement()));
			// Start of user code for additional businessfilters for informationSource

			// End of user code
			basePart.addFilterToInformationTarget(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInformationTargetTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInformationTarget(new EObjectFilter(UMLPackage.eINSTANCE.getNamedElement()));
			// Start of user code for additional businessfilters for informationTarget

			// End of user code
			basePart.addFilterToRealizingActivityEdge(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRealizingActivityEdgeTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRealizingActivityEdge(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for realizingActivityEdge

			// End of user code
			basePart.addFilterToRealizingConnector(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRealizingConnectorTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRealizingConnector(new EObjectFilter(UMLPackage.eINSTANCE.getConnector()));
			// Start of user code for additional businessfilters for realizingConnector

			// End of user code
			basePart.addFilterToRealizingMessage(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRealizingMessageTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRealizingMessage(new EObjectFilter(UMLPackage.eINSTANCE.getMessage()));
			// Start of user code for additional businessfilters for realizingMessage

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
		if(informationFlow != null) {
			List ownedCommentToAddFromOwnedComment = basePart.getOwnedCommentToAdd();
			for(Iterator iter = ownedCommentToAddFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAddFromClientDependency = basePart.getClientDependencyToAdd();
			for(Iterator iter = clientDependencyToAddFromClientDependency.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemoveFromClientDependency = basePart.getClientDependencyToRemove();
			for(Iterator iter = clientDependencyToRemoveFromClientDependency.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMoveFromClientDependency = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMoveFromClientDependency.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List realizationToAddFromRealization = basePart.getRealizationToAdd();
			for(Iterator iter = realizationToAddFromRealization.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Realization(), iter.next()));
			List realizationToRemoveFromRealization = basePart.getRealizationToRemove();
			for(Iterator iter = realizationToRemoveFromRealization.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Realization(), iter.next()));
			//List realizationToMoveFromRealization = basePart.getRealizationToMove();
			//for (Iterator iter = realizationToMoveFromRealization.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getRelationship(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List conveyedToAddFromConveyed = basePart.getConveyedToAdd();
			for(Iterator iter = conveyedToAddFromConveyed.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Conveyed(), iter.next()));
			List conveyedToRemoveFromConveyed = basePart.getConveyedToRemove();
			for(Iterator iter = conveyedToRemoveFromConveyed.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Conveyed(), iter.next()));
			//List conveyedToMoveFromConveyed = basePart.getConveyedToMove();
			//for (Iterator iter = conveyedToMoveFromConveyed.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List informationSourceToAddFromInformationSource = basePart.getInformationSourceToAdd();
			for(Iterator iter = informationSourceToAddFromInformationSource.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationSource(), iter.next()));
			List informationSourceToRemoveFromInformationSource = basePart.getInformationSourceToRemove();
			for(Iterator iter = informationSourceToRemoveFromInformationSource.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationSource(), iter.next()));
			//List informationSourceToMoveFromInformationSource = basePart.getInformationSourceToMove();
			//for (Iterator iter = informationSourceToMoveFromInformationSource.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List informationTargetToAddFromInformationTarget = basePart.getInformationTargetToAdd();
			for(Iterator iter = informationTargetToAddFromInformationTarget.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationTarget(), iter.next()));
			List informationTargetToRemoveFromInformationTarget = basePart.getInformationTargetToRemove();
			for(Iterator iter = informationTargetToRemoveFromInformationTarget.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationTarget(), iter.next()));
			//List informationTargetToMoveFromInformationTarget = basePart.getInformationTargetToMove();
			//for (Iterator iter = informationTargetToMoveFromInformationTarget.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List realizingActivityEdgeToAddFromRealizingActivityEdge = basePart.getRealizingActivityEdgeToAdd();
			for(Iterator iter = realizingActivityEdgeToAddFromRealizingActivityEdge.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge(), iter.next()));
			List realizingActivityEdgeToRemoveFromRealizingActivityEdge = basePart.getRealizingActivityEdgeToRemove();
			for(Iterator iter = realizingActivityEdgeToRemoveFromRealizingActivityEdge.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge(), iter.next()));
			//List realizingActivityEdgeToMoveFromRealizingActivityEdge = basePart.getRealizingActivityEdgeToMove();
			//for (Iterator iter = realizingActivityEdgeToMoveFromRealizingActivityEdge.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List realizingConnectorToAddFromRealizingConnector = basePart.getRealizingConnectorToAdd();
			for(Iterator iter = realizingConnectorToAddFromRealizingConnector.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector(), iter.next()));
			List realizingConnectorToRemoveFromRealizingConnector = basePart.getRealizingConnectorToRemove();
			for(Iterator iter = realizingConnectorToRemoveFromRealizingConnector.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector(), iter.next()));
			//List realizingConnectorToMoveFromRealizingConnector = basePart.getRealizingConnectorToMove();
			//for (Iterator iter = realizingConnectorToMoveFromRealizingConnector.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getConnector(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List realizingMessageToAddFromRealizingMessage = basePart.getRealizingMessageToAdd();
			for(Iterator iter = realizingMessageToAddFromRealizingMessage.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage(), iter.next()));
			List realizingMessageToRemoveFromRealizingMessage = basePart.getRealizingMessageToRemove();
			for(Iterator iter = realizingMessageToRemoveFromRealizingMessage.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage(), iter.next()));
			//List realizingMessageToMoveFromRealizingMessage = basePart.getRealizingMessageToMove();
			//for (Iterator iter = realizingMessageToMoveFromRealizingMessage.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, informationFlow, UMLPackage.eINSTANCE.getMessage(), moveElement.getElement(), moveElement.getIndex()));
			//}


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
		if(source instanceof InformationFlow) {
			InformationFlow informationFlowToUpdate = (InformationFlow)source;
			informationFlowToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			informationFlowToUpdate.setName(basePart.getName());

			informationFlowToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			informationFlowToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			informationFlowToUpdate.getRealizations().addAll(basePart.getRealizationToAdd());
			informationFlowToUpdate.getConveyeds().addAll(basePart.getConveyedToAdd());
			informationFlowToUpdate.getInformationSources().addAll(basePart.getInformationSourceToAdd());
			informationFlowToUpdate.getInformationTargets().addAll(basePart.getInformationTargetToAdd());
			informationFlowToUpdate.getRealizingActivityEdges().addAll(basePart.getRealizingActivityEdgeToAdd());
			informationFlowToUpdate.getRealizingConnectors().addAll(basePart.getRealizingConnectorToAdd());
			informationFlowToUpdate.getRealizingMessages().addAll(basePart.getRealizingMessageToAdd());


			return informationFlowToUpdate;
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
			if(UMLViewsRepository.InformationFlow.ownedComment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();


					// TODO: Complete the informationFlow update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.InformationFlow.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.InformationFlow.clientDependency == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.realization == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Realization(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Realization(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Realization(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.conveyed == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Conveyed(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Conveyed(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_Conveyed(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.informationSource == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationSource(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationSource(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationSource(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.informationTarget == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationTarget(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationTarget(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_InformationTarget(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.realizingActivityEdge == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingActivityEdge(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.realizingConnector == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingConnector(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InformationFlow.realizingMessage == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, informationFlow, UMLPackage.eINSTANCE.getInformationFlow_RealizingMessage(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {

				if(UMLViewsRepository.InformationFlow.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {

				if(UMLViewsRepository.InformationFlow.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.InformationFlow.conveyed || key == UMLViewsRepository.InformationFlow.informationSource || key == UMLViewsRepository.InformationFlow.informationTarget;
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
				if(UMLViewsRepository.InformationFlow.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.InformationFlow.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(informationFlow);
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
			informationFlow.eAdapters().remove(semanticAdapter);
	}

}
