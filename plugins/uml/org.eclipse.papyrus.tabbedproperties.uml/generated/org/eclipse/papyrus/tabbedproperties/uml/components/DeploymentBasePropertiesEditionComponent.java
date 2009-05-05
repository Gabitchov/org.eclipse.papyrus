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

import org.eclipse.uml2.uml.Deployment;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.DeploymentSpecification;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.DeploymentPropertiesEditionPart;
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
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DeploymentBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Deployment deployment;

	/**
	 * The Base part
	 */
	private DeploymentPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public DeploymentBasePropertiesEditionComponent(EObject deployment, String editing_mode) {
		if (deployment instanceof Deployment) {
			this.deployment = (Deployment) deployment;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.deployment.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(deployment);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(deployment);
				if (UMLPackage.eINSTANCE.getDependency_Supplier().equals(msg.getFeature()))
					basePart.updateSupplier(deployment);
				if (UMLPackage.eINSTANCE.getDependency_Client().equals(msg.getFeature()))
					basePart.updateClient(deployment);
				if (UMLPackage.eINSTANCE.getDeployment_DeployedArtifact().equals(msg.getFeature()))
					basePart.updateDeployedArtifact(deployment);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getDeployment_Configuration() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getDeploymentSpecification())) {
					basePart.updateConfiguration(deployment);
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
			return UMLViewsRepository.Deployment.class;
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
		if (deployment != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (DeploymentPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.Deployment.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Deployment.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			Deployment deployment = (Deployment) elt;
			basePart.initOwnedComment(deployment, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (deployment.getName() != null)
				basePart.setName(deployment.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), deployment.getVisibility());
			basePart.initClientDependency(deployment, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.initSupplier(deployment, null, UMLPackage.eINSTANCE.getDependency_Supplier());
			basePart.initClient(deployment, null, UMLPackage.eINSTANCE.getDependency_Client());
			basePart.initDeployedArtifact(deployment, null, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact());
			basePart.initConfiguration(deployment, null, UMLPackage.eINSTANCE.getDeployment_Configuration());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (deployment != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List supplierToAdd = basePart.getSupplierToAdd();
			for (Iterator iter = supplierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Supplier(), iter.next()));
			List supplierToRemove = basePart.getSupplierToRemove();
			for (Iterator iter = supplierToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Supplier(), iter.next()));
			// List supplierToMove = basePart.getSupplierToMove();
			// for (Iterator iter = supplierToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List clientToAdd = basePart.getClientToAdd();
			for (Iterator iter = clientToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Client(), iter.next()));
			List clientToRemove = basePart.getClientToRemove();
			for (Iterator iter = clientToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Client(), iter.next()));
			// List clientToMove = basePart.getClientToMove();
			// for (Iterator iter = clientToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List deployedArtifactToAdd = basePart.getDeployedArtifactToAdd();
			for (Iterator iter = deployedArtifactToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact(), iter.next()));
			List deployedArtifactToRemove = basePart.getDeployedArtifactToRemove();
			for (Iterator iter = deployedArtifactToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact(), iter.next()));
			// List deployedArtifactToMove = basePart.getDeployedArtifactToMove();
			// for (Iterator iter = deployedArtifactToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDeployedArtifact(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List configurationToAdd = basePart.getConfigurationToAdd();
			for (Iterator iter = configurationToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_Configuration(), iter.next()));
			Map configurationToRefresh = basePart.getConfigurationToEdit();
			for (Iterator iter = configurationToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for configuration reference refreshment

				DeploymentSpecification nextElement = (DeploymentSpecification) iter.next();
				DeploymentSpecification configuration = (DeploymentSpecification) configurationToRefresh.get(nextElement);

				// End of user code
			}
			List configurationToRemove = basePart.getConfigurationToRemove();
			for (Iterator iter = configurationToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List configurationToMove = basePart.getConfigurationToMove();
			for (Iterator iter = configurationToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, deployment, UMLPackage.eINSTANCE.getDeploymentSpecification(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof Deployment) {
			Deployment deploymentToUpdate = (Deployment) source;
			deploymentToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			deploymentToUpdate.setName(basePart.getName());

			deploymentToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			deploymentToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			deploymentToUpdate.getSuppliers().addAll(basePart.getSupplierToAdd());
			deploymentToUpdate.getClients().addAll(basePart.getClientToAdd());
			deploymentToUpdate.getDeployedArtifacts().addAll(basePart.getDeployedArtifactToAdd());
			deploymentToUpdate.getConfigurations().addAll(basePart.getConfigurationToAdd());

			return deploymentToUpdate;
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
			if (UMLViewsRepository.Deployment.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the deployment update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Deployment.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.Deployment.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Deployment.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Deployment.supplier == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Supplier(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Supplier(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Supplier(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Deployment.client == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Client(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Client(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDependency_Client(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Deployment.deployedArtifact == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Deployment.configuration == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					DeploymentSpecification oldValue = (DeploymentSpecification) event.getOldValue();
					DeploymentSpecification newValue = (DeploymentSpecification) event.getNewValue();

					// Start of user code for configuration live update command
					// TODO: Complete the deployment update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDeployment_Configuration(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, deployment, UMLPackage.eINSTANCE.getDeploymentSpecification(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.Deployment.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.Deployment.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.Deployment.supplier || key == UMLViewsRepository.Deployment.client;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.Deployment.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.supplier)
			return "The element(s) independent of the client element(s), in the same respect and the same dependency relationship. In some directed dependency relationships (such as Refinement Abstractions), a common convention in the domain of class-based OO software is to put the more abstract element in this role. Despite this convention, users of UML may stipulate a sense of dependency suitable for their domain, which makes a more abstract element dependent on that which is more specific."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.client)
			return "The element(s) dependent on the supplier element(s). In some cases (such as a Trace Abstraction) the assignment of direction (that is, the designation of the client element) is at the discretion of the modeler, and is a stipulation."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.deployedArtifact)
			return "The Artifacts that are deployed onto a Node. This association specializes the supplier association."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Deployment.configuration)
			return "The specification of properties that parameterize the deployment and execution of one or more Artifacts."; //$NON-NLS-1$
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
			if (UMLViewsRepository.Deployment.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Deployment.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(deployment);
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
			deployment.eAdapters().remove(semanticAdapter);
	}

}
