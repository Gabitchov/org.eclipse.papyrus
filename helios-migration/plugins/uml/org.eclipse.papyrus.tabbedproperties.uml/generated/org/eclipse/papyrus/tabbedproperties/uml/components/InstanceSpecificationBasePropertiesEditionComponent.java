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
import org.eclipse.papyrus.tabbedproperties.uml.parts.InstanceSpecificationPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

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
		if(instanceSpecification instanceof InstanceSpecification) {
			this.instanceSpecification = (InstanceSpecification)instanceSpecification;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.instanceSpecification.eAdapters().add(semanticAdapter);
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
					InstanceSpecificationBasePropertiesEditionComponent.this.dispose();
				else {
					if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setName((String)msg.getNewValue());
						} else {
							basePart.setName("");
						}
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
						basePart.setVisibility((Enumerator)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment())) {
						basePart.updateDeployment(instanceSpecification);
					}
					if(UMLPackage.eINSTANCE.getInstanceSpecification_Classifier().equals(msg.getFeature()))
						basePart.updateClassifier(instanceSpecification);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getInstanceSpecification_Slot()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getInstanceSpecification_Slot())) {
						basePart.updateSlot(instanceSpecification);
					}


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
		if(instanceSpecification != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (InstanceSpecificationPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.InstanceSpecification.class, kind, this);
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
		if(key == UMLViewsRepository.InstanceSpecification.class)
			this.basePart = (InstanceSpecificationPropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.InstanceSpecification.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final InstanceSpecification instanceSpecification = (InstanceSpecification)elt;
			// init values
			if(instanceSpecification.getName() != null)
				basePart.setName(instanceSpecification.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), instanceSpecification.getVisibility());
			basePart.initDeployment(instanceSpecification, null, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment());
			basePart.initClassifier(instanceSpecification, null, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier());
			basePart.initSlot(instanceSpecification, null, UMLPackage.eINSTANCE.getInstanceSpecification_Slot());

			// init filters


			basePart.addFilterToDeployment(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Deployment); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for deployment

			// End of user code
			basePart.addFilterToClassifier(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInClassifierTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToClassifier(new EObjectFilter(UMLPackage.eINSTANCE.getClassifier()));
			// Start of user code for additional businessfilters for classifier

			// End of user code
			basePart.addFilterToSlot(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Slot); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for slot

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
		if(instanceSpecification != null) {
			cc.append(SetCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List deploymentToAddFromDeployment = basePart.getDeploymentToAdd();
			for(Iterator iter = deploymentToAddFromDeployment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), iter.next()));
			Map deploymentToRefreshFromDeployment = basePart.getDeploymentToEdit();
			for(Iterator iter = deploymentToRefreshFromDeployment.keySet().iterator(); iter.hasNext();) {



				Deployment nextElement = (Deployment)iter.next();
				Deployment deployment = (Deployment)deploymentToRefreshFromDeployment.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, deployment.eGet(feature)));
					}
				}



			}
			List deploymentToRemoveFromDeployment = basePart.getDeploymentToRemove();
			for(Iterator iter = deploymentToRemoveFromDeployment.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List deploymentToMoveFromDeployment = basePart.getDeploymentToMove();
			for(Iterator iter = deploymentToMoveFromDeployment.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeployment(), moveElement.getElement(), moveElement.getIndex()));
			}
			List classifierToAddFromClassifier = basePart.getClassifierToAdd();
			for(Iterator iter = classifierToAddFromClassifier.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), iter.next()));
			List classifierToRemoveFromClassifier = basePart.getClassifierToRemove();
			for(Iterator iter = classifierToRemoveFromClassifier.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), iter.next()));
			//List classifierToMoveFromClassifier = basePart.getClassifierToMove();
			//for (Iterator iter = classifierToMoveFromClassifier.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List slotToAddFromSlot = basePart.getSlotToAdd();
			for(Iterator iter = slotToAddFromSlot.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Slot(), iter.next()));
			Map slotToRefreshFromSlot = basePart.getSlotToEdit();
			for(Iterator iter = slotToRefreshFromSlot.keySet().iterator(); iter.hasNext();) {



				Slot nextElement = (Slot)iter.next();
				Slot slot = (Slot)slotToRefreshFromSlot.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, slot.eGet(feature)));
					}
				}



			}
			List slotToRemoveFromSlot = basePart.getSlotToRemove();
			for(Iterator iter = slotToRemoveFromSlot.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List slotToMoveFromSlot = basePart.getSlotToMove();
			for(Iterator iter = slotToMoveFromSlot.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, instanceSpecification, UMLPackage.eINSTANCE.getSlot(), moveElement.getElement(), moveElement.getIndex()));
			}


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
		if(source instanceof InstanceSpecification) {
			InstanceSpecification instanceSpecificationToUpdate = (InstanceSpecification)source;
			instanceSpecificationToUpdate.setName(basePart.getName());

			instanceSpecificationToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

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
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.InstanceSpecification.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.InstanceSpecification.deployment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Deployment oldValue = (Deployment)event.getOldValue();
					Deployment newValue = (Deployment)event.getNewValue();


					// TODO: Complete the instanceSpecification update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getDeployment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InstanceSpecification.classifier == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.InstanceSpecification.slot == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Slot oldValue = (Slot)event.getOldValue();
					Slot newValue = (Slot)event.getNewValue();


					// TODO: Complete the instanceSpecification update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getInstanceSpecification_Slot(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, instanceSpecification, UMLPackage.eINSTANCE.getSlot(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {
				if(UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {
				if(UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor())
					basePart.unsetMessageForName();





			}
		}
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
				if(UMLViewsRepository.InstanceSpecification.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.InstanceSpecification.visibility == event.getAffectedEditor()) {
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
			validate = Diagnostician.INSTANCE.validate(instanceSpecification);
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
			instanceSpecification.eAdapters().remove(semanticAdapter);
	}

}
