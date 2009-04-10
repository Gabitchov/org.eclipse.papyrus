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
import org.eclipse.papyrus.tabbedproperties.uml.parts.PortPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class PortBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private Port port;
	
	/**
	 * The Base part
	 */
	private PortPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public PortBasePropertiesEditionComponent(EObject port, String mode) {
		if (port instanceof Port) {
			this.port = (Port)port;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.port.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(port);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())) {
					basePart.updateClientDependency(port);
				}
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getFeature_IsStatic().equals(msg.getFeature()) && basePart != null)
					basePart.setIsStatic((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(msg.getFeature()) && basePart != null)
					basePart.setIsOrdered((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(msg.getFeature()) && basePart != null)
					basePart.setIsUnique((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().equals(msg.getFeature()) && basePart != null)
					basePart.setIsReadOnly((Boolean)msg.getNewValue());
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getDeployment())) {
					basePart.updateDeployment(port);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTemplateBinding())) {
					basePart.updateTemplateBinding(port);
				}
				if (UMLPackage.eINSTANCE.getProperty_IsDerived().equals(msg.getFeature()) && basePart != null)
					basePart.setIsDerived((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().equals(msg.getFeature()) && basePart != null)
					basePart.setIsDerivedUnion((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getProperty_Aggregation().equals(msg.getFeature()) && basePart != null)
					basePart.setAggregation((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getProperty_RedefinedProperty().equals(msg.getFeature())) {
					basePart.updateRedefinedProperty(port);
				}
				if (UMLPackage.eINSTANCE.getProperty_SubsettedProperty().equals(msg.getFeature())) {
					basePart.updateSubsettedProperty(port);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getProperty_Qualifier()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getProperty())) {
					basePart.updateQualifier(port);
				}
				if (UMLPackage.eINSTANCE.getPort_IsBehavior().equals(msg.getFeature()) && basePart != null)
					basePart.setIsBehavior((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getPort_IsService().equals(msg.getFeature()) && basePart != null)
					basePart.setIsService((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getPort_RedefinedPort().equals(msg.getFeature())) {
					basePart.updateRedefinedPort(port);
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
			return UMLViewsRepository.Port.class;
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
		if (port != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (PortPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.Port.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Port.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			Port port = (Port)elt;
			basePart.initOwnedComment(port, null, UMLPackage.eINSTANCE.getElement_OwnedComment());				
			if (port.getName() != null)
				basePart.setName(port.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), port.getVisibility());				
			basePart.initClientDependency(port, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());				
			basePart.setIsLeaf(port.isLeaf());				
			basePart.setIsStatic(port.isStatic());				
			basePart.setIsOrdered(port.isOrdered());				
			basePart.setIsUnique(port.isUnique());				
			basePart.setIsReadOnly(port.isReadOnly());				
			basePart.initDeployment(port, null, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment());				
			basePart.initTemplateBinding(port, null, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding());				
			basePart.setIsDerived(port.isDerived());				
			basePart.setIsDerivedUnion(port.isDerivedUnion());				
			basePart.initAggregation((EEnum) UMLPackage.eINSTANCE.getProperty_Aggregation().getEType(), port.getAggregation());				
			basePart.initRedefinedProperty(port, null, UMLPackage.eINSTANCE.getProperty_RedefinedProperty());				
			basePart.initSubsettedProperty(port, null, UMLPackage.eINSTANCE.getProperty_SubsettedProperty());				
			basePart.initQualifier(port, null, UMLPackage.eINSTANCE.getProperty_Qualifier());				
			basePart.setIsBehavior(port.isBehavior());				
			basePart.setIsService(port.isService());				
			basePart.initRedefinedPort(port, null, UMLPackage.eINSTANCE.getPort_RedefinedPort());				
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
		if (port != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMove = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getFeature_IsStatic(), basePart.getIsStatic()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), basePart.getIsOrdered()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), basePart.getIsUnique()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), basePart.getIsReadOnly()));
			List deploymentToAdd = basePart.getDeploymentToAdd();
			for (Iterator iter = deploymentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), iter.next()));
			Map deploymentToRefresh = basePart.getDeploymentToEdit();
			for (Iterator iter = deploymentToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for deployment reference refreshment
				
				Deployment nextElement = (Deployment) iter.next();
				Deployment deployment = (Deployment) deploymentToRefresh.get(nextElement);
				
				// End of user code			
			}
			List deploymentToRemove = basePart.getDeploymentToRemove();
			for (Iterator iter = deploymentToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List deploymentToMove = basePart.getDeploymentToMove();
			for (Iterator iter = deploymentToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getDeployment(), moveElement.getElement(), moveElement.getIndex()));
			}
			List templateBindingToAdd = basePart.getTemplateBindingToAdd();
			for (Iterator iter = templateBindingToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), iter.next()));
			Map templateBindingToRefresh = basePart.getTemplateBindingToEdit();
			for (Iterator iter = templateBindingToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for templateBinding reference refreshment
				
				TemplateBinding nextElement = (TemplateBinding) iter.next();
				TemplateBinding templateBinding = (TemplateBinding) templateBindingToRefresh.get(nextElement);
				
				// End of user code			
			}
			List templateBindingToRemove = basePart.getTemplateBindingToRemove();
			for (Iterator iter = templateBindingToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List templateBindingToMove = basePart.getTemplateBindingToMove();
			for (Iterator iter = templateBindingToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getTemplateBinding(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_IsDerived(), basePart.getIsDerived()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), basePart.getIsDerivedUnion()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_Aggregation(), basePart.getAggregation()));
			List redefinedPropertyToAdd = basePart.getRedefinedPropertyToAdd();
			for (Iterator iter = redefinedPropertyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), iter.next()));
			List redefinedPropertyToRemove = basePart.getRedefinedPropertyToRemove();
			for (Iterator iter = redefinedPropertyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), iter.next()));
			//List redefinedPropertyToMove = basePart.getRedefinedPropertyToMove();
			//for (Iterator iter = redefinedPropertyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List subsettedPropertyToAdd = basePart.getSubsettedPropertyToAdd();
			for (Iterator iter = subsettedPropertyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), iter.next()));
			List subsettedPropertyToRemove = basePart.getSubsettedPropertyToRemove();
			for (Iterator iter = subsettedPropertyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), iter.next()));
			//List subsettedPropertyToMove = basePart.getSubsettedPropertyToMove();
			//for (Iterator iter = subsettedPropertyToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List qualifierToAdd = basePart.getQualifierToAdd();
			for (Iterator iter = qualifierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty_Qualifier(), iter.next()));
			Map qualifierToRefresh = basePart.getQualifierToEdit();
			for (Iterator iter = qualifierToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for qualifier reference refreshment
				
				Property nextElement = (Property) iter.next();
				Property qualifier = (Property) qualifierToRefresh.get(nextElement);
				
				// End of user code			
			}
			List qualifierToRemove = basePart.getQualifierToRemove();
			for (Iterator iter = qualifierToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List qualifierToMove = basePart.getQualifierToMove();
			for (Iterator iter = qualifierToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getPort_IsBehavior(), basePart.getIsBehavior()));
			cc.append(SetCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getPort_IsService(), basePart.getIsService()));
			List redefinedPortToAdd = basePart.getRedefinedPortToAdd();
			for (Iterator iter = redefinedPortToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getPort_RedefinedPort(), iter.next()));
			List redefinedPortToRemove = basePart.getRedefinedPortToRemove();
			for (Iterator iter = redefinedPortToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getPort_RedefinedPort(), iter.next()));
			//List redefinedPortToMove = basePart.getRedefinedPortToMove();
			//for (Iterator iter = redefinedPortToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, port, UMLPackage.eINSTANCE.getPort(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof Port) {
			Port portToUpdate = (Port)source;
			portToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			portToUpdate.setName(basePart.getName());
			portToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			portToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			portToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());
			portToUpdate.setIsStatic(new Boolean(basePart.getIsStatic()).booleanValue());
			portToUpdate.setIsOrdered(new Boolean(basePart.getIsOrdered()).booleanValue());
			portToUpdate.setIsUnique(new Boolean(basePart.getIsUnique()).booleanValue());
			portToUpdate.setIsReadOnly(new Boolean(basePart.getIsReadOnly()).booleanValue());
			portToUpdate.getDeployments().addAll(basePart.getDeploymentToAdd());
			portToUpdate.getTemplateBindings().addAll(basePart.getTemplateBindingToAdd());
			portToUpdate.setIsDerived(new Boolean(basePart.getIsDerived()).booleanValue());
			portToUpdate.setIsDerivedUnion(new Boolean(basePart.getIsDerivedUnion()).booleanValue());
			portToUpdate.setAggregation((AggregationKind)basePart.getAggregation());
			portToUpdate.getRedefinedProperties().addAll(basePart.getRedefinedPropertyToAdd());
			portToUpdate.getSubsettedProperties().addAll(basePart.getSubsettedPropertyToAdd());
			portToUpdate.getQualifiers().addAll(basePart.getQualifierToAdd());
			portToUpdate.setIsBehavior(new Boolean(basePart.getIsBehavior()).booleanValue());
			portToUpdate.setIsService(new Boolean(basePart.getIsService()).booleanValue());
			portToUpdate.getRedefinedPorts().addAll(basePart.getRedefinedPortToAdd());


			return portToUpdate;
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
			if (UMLViewsRepository.Port.ownedComment == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();
					// Start of user code for ownedComment live update command
					// TODO: Complete the port update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.Port.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Port.clientDependency == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.Port.isStatic == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getFeature_IsStatic(), event.getNewValue()));

			if (UMLViewsRepository.Port.isOrdered == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), event.getNewValue()));

			if (UMLViewsRepository.Port.isUnique == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), event.getNewValue()));

			if (UMLViewsRepository.Port.isReadOnly == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), event.getNewValue()));

			if (UMLViewsRepository.Port.deployment == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Deployment oldValue = (Deployment)event.getOldValue();
					Deployment newValue = (Deployment)event.getNewValue();
					// Start of user code for deployment live update command
					// TODO: Complete the port update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getDeployment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.templateBinding == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					TemplateBinding oldValue = (TemplateBinding)event.getOldValue();
					TemplateBinding newValue = (TemplateBinding)event.getNewValue();
					// Start of user code for templateBinding live update command
					// TODO: Complete the port update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getTemplateBinding(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.isDerived == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_IsDerived(), event.getNewValue()));

			if (UMLViewsRepository.Port.isDerivedUnion == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), event.getNewValue()));

			if (UMLViewsRepository.Port.aggregation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_Aggregation(), event.getNewValue()));

			if (UMLViewsRepository.Port.redefinedProperty == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.subsettedProperty == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.qualifier == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					Property oldValue = (Property)event.getOldValue();
					Property newValue = (Property)event.getNewValue();
					// Start of user code for qualifier live update command
					// TODO: Complete the port update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty_Qualifier(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Port.isBehavior == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getPort_IsBehavior(), event.getNewValue()));

			if (UMLViewsRepository.Port.isService == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getPort_IsService(), event.getNewValue()));

			if (UMLViewsRepository.Port.redefinedPort == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getPort_RedefinedPort(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getPort_RedefinedPort(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, port, UMLPackage.eINSTANCE.getPort_RedefinedPort(), event.getNewValue(), event.getNewIndex()));
			}


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (UMLViewsRepository.Port.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				


			} else {
				
				if (UMLViewsRepository.Port.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.Port.isLeaf || key == UMLViewsRepository.Port.isStatic || key == UMLViewsRepository.Port.isOrdered || key == UMLViewsRepository.Port.isUnique || key == UMLViewsRepository.Port.isReadOnly || key == UMLViewsRepository.Port.isDerived || key == UMLViewsRepository.Port.isDerivedUnion || key == UMLViewsRepository.Port.aggregation || key == UMLViewsRepository.Port.isBehavior || key == UMLViewsRepository.Port.isService;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.Port.ownedComment)
				return "The Comments owned by this element."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.clientDependency)
				return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isLeaf)
				return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isStatic)
				return "Specifies whether this feature characterizes individual instances classified by the classifier (false) or the classifier itself (true)."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isOrdered)
				return "For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this element are sequentially ordered."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isUnique)
				return "For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this element are unique."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isReadOnly)
				return "States whether the feature's value may be modified by a client."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.deployment)
				return "The set of Deployments for a DeploymentTarget."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.templateBinding)
				return "The optional bindings from this element to templates."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isDerived)
				return "If isDerived is true, the value of the attribute is derived from information elsewhere.Specifies whether the Property is derived, i.e., whether its value or values can be computed from other information."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isDerivedUnion)
				return "Specifies whether the property is derived as the union of all of the properties that are constrained to subset it."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.aggregation)
				return "Specifies the kind of aggregation that applies to the Property."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.redefinedProperty)
				return "References the properties that are redefined by this property."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.subsettedProperty)
				return "References the properties of which this property is constrained to be a subset."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.qualifier)
				return "An optional list of ordered qualifier attributes for the end. If the list is empty, then the Association is not qualified."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isBehavior)
				return "Specifies whether requests arriving at this port are sent to the classifier behavior of this classifier. Such ports are referred to as behavior port. Any invocation of a behavioral feature targeted at a behavior port will be handled by the instance of the owning classifier itself, rather than by any instances that this classifier may contain."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.isService)
				return "If true indicates that this port is used to provide the published functionality of a classifier; if false, this port is used to implement the classifier but is not part of the essential externally-visible functionality of the classifier and can, therefore, be altered or deleted along with the internal implementation of the classifier and other properties that are considered part of its implementation."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Port.redefinedPort)
				return "A port may be redefined when its containing classifier is specialized. The redefining port may have additional interfaces to those that are associated with the redefined port or it may replace an interface by one of its subtypes."; //$NON-NLS-1$
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
			if (UMLViewsRepository.Port.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isStatic == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isOrdered == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isUnique == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isReadOnly == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isDerived == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getProperty_IsDerived().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getProperty_IsDerived().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isDerivedUnion == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.aggregation == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getProperty_Aggregation().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getProperty_Aggregation().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isBehavior == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getPort_IsBehavior().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getPort_IsBehavior().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Port.isService == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getPort_IsService().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getPort_IsService().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(port);
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
			port.eAdapters().remove(semanticAdapter);
	}

}

