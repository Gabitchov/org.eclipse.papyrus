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

import org.eclipse.uml2.uml.InstanceSpecification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Slot;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InstanceSpecificationBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private InstanceSpecification instanceSpecification;

	/**
	 * The Base part
	 */
	private InstanceSpecificationPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public InstanceSpecificationBasePropertiesEditionComponent(EObject instanceSpecification, String editing_mode) {
		if (instanceSpecification instanceof InstanceSpecification) {
			this.instanceSpecification = (InstanceSpecification) instanceSpecification;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.instanceSpecification.eAdapters().add(semanticAdapter);
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
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getDeployment())) {
					basePart.updateDeployment(instanceSpecification);
				}
				if (UMLPackage.eINSTANCE.getInstanceSpecification_Classifier().equals(msg.getFeature()))
					basePart.updateClassifier(instanceSpecification);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getInstanceSpecification_Slot() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getSlot())) {
					basePart.updateSlot(instanceSpecification);
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
			return UMLViewsRepository.InstanceSpecification.class;
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
		if (instanceSpecification != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (InstanceSpecificationPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.InstanceSpecification.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.InstanceSpecification.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			InstanceSpecification instanceSpecification = (InstanceSpecification) elt;
			if (instanceSpecification.getName() != null)
				basePart.setName(instanceSpecification.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), instanceSpecification.getVisibility());
			basePart.initDeployment(instanceSpecification, null, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment());
			basePart.initClassifier(instanceSpecification, null, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier());
			basePart.initSlot(instanceSpecification, null, UMLPackage.eINSTANCE.getInstanceSpecification_Slot());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (instanceSpecification != null) {
			cc.append(SetCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List deploymentToAdd = basePart.getDeploymentToAdd();
			for (Iterator iter = deploymentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), iter.next()));
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
			for (Iterator iter = deploymentToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeployment(), moveElement.getElement(), moveElement.getIndex()));
			}
			List classifierToAdd = basePart.getClassifierToAdd();
			for (Iterator iter = classifierToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), iter.next()));
			List classifierToRemove = basePart.getClassifierToRemove();
			for (Iterator iter = classifierToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), iter.next()));
			// List classifierToMove = basePart.getClassifierToMove();
			// for (Iterator iter = classifierToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List slotToAdd = basePart.getSlotToAdd();
			for (Iterator iter = slotToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Slot(), iter.next()));
			Map slotToRefresh = basePart.getSlotToEdit();
			for (Iterator iter = slotToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for slot reference refreshment

				Slot nextElement = (Slot) iter.next();
				Slot slot = (Slot) slotToRefresh.get(nextElement);

				// End of user code
			}
			List slotToRemove = basePart.getSlotToRemove();
			for (Iterator iter = slotToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List slotToMove = basePart.getSlotToMove();
			for (Iterator iter = slotToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getSlot(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof InstanceSpecification) {
			InstanceSpecification instanceSpecificationToUpdate = (InstanceSpecification) source;
			instanceSpecificationToUpdate.setName(basePart.getName());

			instanceSpecificationToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			instanceSpecificationToUpdate.getDeployments().addAll(basePart.getDeploymentToAdd());
			instanceSpecificationToUpdate.getClassifiers().addAll(basePart.getClassifierToAdd());
			instanceSpecificationToUpdate.getSlots().addAll(basePart.getSlotToAdd());

			return instanceSpecificationToUpdate;
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
			if (UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.InstanceSpecification.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.InstanceSpecification.deployment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Deployment oldValue = (Deployment) event.getOldValue();
					Deployment newValue = (Deployment) event.getNewValue();

					// Start of user code for deployment live update command
					// TODO: Complete the instanceSpecification update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeployment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.InstanceSpecification.classifier == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.InstanceSpecification.slot == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Slot oldValue = (Slot) event.getOldValue();
					Slot newValue = (Slot) event.getNewValue();

					// Start of user code for slot live update command
					// TODO: Complete the instanceSpecification update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Slot(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getSlot(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {
				if (UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.InstanceSpecification.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.InstanceSpecification.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.InstanceSpecification.deployment)
			return "The set of Deployments for a DeploymentTarget."; //$NON-NLS-1$
		if (key == UMLViewsRepository.InstanceSpecification.classifier)
			return "The classifier or classifiers of the represented instance. If multiple classifiers are specified, the instance is classified by all of them."; //$NON-NLS-1$
		if (key == UMLViewsRepository.InstanceSpecification.slot)
			return "A slot giving the value or values of a structural feature of the instance. An instance specification can have one slot per structural feature of its classifiers, including inherited features. It is not necessary to model a slot for each structural feature, in which case the instance specification is a partial description."; //$NON-NLS-1$
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
			if (UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.InstanceSpecification.visibility == event.getAffectedEditor()) {
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
			return Diagnostician.INSTANCE.validate(instanceSpecification);
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
			instanceSpecification.eAdapters().remove(semanticAdapter);
	}

}
