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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.PropertyPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class PropertyBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Property property;

	/**
	 * The Base part
	 */
	private PropertyPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public PropertyBasePropertiesEditionComponent(EObject property, String editing_mode) {
		if(property instanceof Property) {
			this.property = (Property)property;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.property.eAdapters().add(semanticAdapter);
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
					PropertyBasePropertiesEditionComponent.this.dispose();
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

					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getFeature_IsStatic().equals(msg.getFeature()) && basePart != null)
						basePart.setIsStatic((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(msg.getFeature()) && basePart != null)
						basePart.setIsOrdered((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(msg.getFeature()) && basePart != null)
						basePart.setIsUnique((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().equals(msg.getFeature()) && basePart != null)
						basePart.setIsReadOnly((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment())) {
						basePart.updateDeployment(property);
					}
					if(UMLPackage.eINSTANCE.getProperty_IsDerived().equals(msg.getFeature()) && basePart != null)
						basePart.setIsDerived((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().equals(msg.getFeature()) && basePart != null)
						basePart.setIsDerivedUnion((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getProperty_Aggregation().equals(msg.getFeature()) && basePart != null)
						basePart.setAggregation((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getProperty_RedefinedProperty().equals(msg.getFeature()))
						basePart.updateRedefinedProperty(property);
					if(UMLPackage.eINSTANCE.getProperty_SubsettedProperty().equals(msg.getFeature()))
						basePart.updateSubsettedProperty(property);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getProperty_Qualifier()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getProperty_Qualifier())) {
						basePart.updateQualifier(property);
					}
					if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(msg.getFeature()) && basePart != null)
						basePart.setType((EObject)msg.getNewValue());
					if(UMLPackage.eINSTANCE.getMultiplicityElement_Lower().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setLower(((Integer)msg.getNewValue()).toString());
						} else {
							basePart.setLower("");
						}
					}
					if(UMLPackage.eINSTANCE.getMultiplicityElement_Upper().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setUpper(((Integer)msg.getNewValue()).toString());
						} else {
							basePart.setUpper("");
						}
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
			return UMLViewsRepository.Property.class;
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
		if(property != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (PropertyPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.Property.class, kind, this);
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
		if(key == UMLViewsRepository.Property.class)
			this.basePart = (PropertyPropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.Property.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Property property = (Property)elt;
			// init values
			if(property.getName() != null)
				basePart.setName(property.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), property.getVisibility());
			basePart.setIsLeaf(property.isLeaf());

			basePart.setIsStatic(property.isStatic());

			basePart.setIsOrdered(property.isOrdered());

			basePart.setIsUnique(property.isUnique());

			basePart.setIsReadOnly(property.isReadOnly());

			basePart.initDeployment(property, null, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment());
			basePart.setIsDerived(property.isDerived());

			basePart.setIsDerivedUnion(property.isDerivedUnion());

			basePart.initAggregation((EEnum)UMLPackage.eINSTANCE.getProperty_Aggregation().getEType(), property.getAggregation());
			basePart.initRedefinedProperty(property, null, UMLPackage.eINSTANCE.getProperty_RedefinedProperty());
			basePart.initSubsettedProperty(property, null, UMLPackage.eINSTANCE.getProperty_SubsettedProperty());
			basePart.initQualifier(property, null, UMLPackage.eINSTANCE.getProperty_Qualifier());
			basePart.initType(allResource, property.getType());
			// set the button mode
			basePart.setTypeButtonMode(ButtonsModeEnum.BROWSE);
			basePart.setLower(String.valueOf(property.getLower()));

			basePart.setUpper(String.valueOf(property.getUpper()));


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



			basePart.addFilterToRedefinedProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRedefinedPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRedefinedProperty(new EObjectFilter(UMLPackage.eINSTANCE.getProperty()));
			// Start of user code for additional businessfilters for redefinedProperty

			// End of user code
			basePart.addFilterToSubsettedProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInSubsettedPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToSubsettedProperty(new EObjectFilter(UMLPackage.eINSTANCE.getProperty()));
			// Start of user code for additional businessfilters for subsettedProperty

			// End of user code
			basePart.addFilterToQualifier(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Property); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for qualifier

			// End of user code
			basePart.addFilterToType(new EObjectFilter(UMLPackage.eINSTANCE.getType()));


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
		if(property != null) {
			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getFeature_IsStatic(), basePart.getIsStatic()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), basePart.getIsOrdered()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), basePart.getIsUnique()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), basePart.getIsReadOnly()));

			List deploymentToAddFromDeployment = basePart.getDeploymentToAdd();
			for(Iterator iter = deploymentToAddFromDeployment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getDeployment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_IsDerived(), basePart.getIsDerived()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), basePart.getIsDerivedUnion()));

			cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_Aggregation(), basePart.getAggregation()));

			List redefinedPropertyToAddFromRedefinedProperty = basePart.getRedefinedPropertyToAdd();
			for(Iterator iter = redefinedPropertyToAddFromRedefinedProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), iter.next()));
			List redefinedPropertyToRemoveFromRedefinedProperty = basePart.getRedefinedPropertyToRemove();
			for(Iterator iter = redefinedPropertyToRemoveFromRedefinedProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), iter.next()));
			//List redefinedPropertyToMoveFromRedefinedProperty = basePart.getRedefinedPropertyToMove();
			//for (Iterator iter = redefinedPropertyToMoveFromRedefinedProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List subsettedPropertyToAddFromSubsettedProperty = basePart.getSubsettedPropertyToAdd();
			for(Iterator iter = subsettedPropertyToAddFromSubsettedProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), iter.next()));
			List subsettedPropertyToRemoveFromSubsettedProperty = basePart.getSubsettedPropertyToRemove();
			for(Iterator iter = subsettedPropertyToRemoveFromSubsettedProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), iter.next()));
			//List subsettedPropertyToMoveFromSubsettedProperty = basePart.getSubsettedPropertyToMove();
			//for (Iterator iter = subsettedPropertyToMoveFromSubsettedProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List qualifierToAddFromQualifier = basePart.getQualifierToAdd();
			for(Iterator iter = qualifierToAddFromQualifier.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty_Qualifier(), iter.next()));
			Map qualifierToRefreshFromQualifier = basePart.getQualifierToEdit();
			for(Iterator iter = qualifierToRefreshFromQualifier.keySet().iterator(); iter.hasNext();) {



				Property nextElement = (Property)iter.next();
				Property qualifier = (Property)qualifierToRefreshFromQualifier.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, qualifier.eGet(feature)));
					}
				}



			}
			List qualifierToRemoveFromQualifier = basePart.getQualifierToRemove();
			for(Iterator iter = qualifierToRemoveFromQualifier.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List qualifierToMoveFromQualifier = basePart.getQualifierToMove();
			for(Iterator iter = qualifierToMoveFromQualifier.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getProperty(), moveElement.getElement(), moveElement.getIndex()));
			}
			if(property.eGet(UMLPackage.eINSTANCE.getTypedElement_Type()) == null || !property.eGet(UMLPackage.eINSTANCE.getTypedElement_Type()).equals(basePart.getType())) {
				cc.append(SetCommand.create(editingDomain, property, UMLPackage.eINSTANCE.getTypedElement_Type(), basePart.getType()));
			}
			// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in componentUtils.mtl module, with the values : lower, Property, Property, property.
			// FIXME INVALID CASE INTO template public commandUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent, modelName : String) in componentUtils.mtl module, with the values : upper, Property, Property, property.


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
		if(source instanceof Property) {
			Property propertyToUpdate = (Property)source;
			propertyToUpdate.setName(basePart.getName());

			propertyToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			propertyToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			propertyToUpdate.setIsStatic(new Boolean(basePart.getIsStatic()).booleanValue());

			propertyToUpdate.setIsOrdered(new Boolean(basePart.getIsOrdered()).booleanValue());

			propertyToUpdate.setIsUnique(new Boolean(basePart.getIsUnique()).booleanValue());

			propertyToUpdate.setIsReadOnly(new Boolean(basePart.getIsReadOnly()).booleanValue());

			propertyToUpdate.getDeployments().addAll(basePart.getDeploymentToAdd());
			propertyToUpdate.setIsDerived(new Boolean(basePart.getIsDerived()).booleanValue());

			propertyToUpdate.setIsDerivedUnion(new Boolean(basePart.getIsDerivedUnion()).booleanValue());

			propertyToUpdate.setAggregation((AggregationKind)basePart.getAggregation());

			propertyToUpdate.getRedefinedProperties().addAll(basePart.getRedefinedPropertyToAdd());
			propertyToUpdate.getSubsettedProperties().addAll(basePart.getSubsettedPropertyToAdd());
			propertyToUpdate.getQualifiers().addAll(basePart.getQualifierToAdd());
			propertyToUpdate.setType((Type)basePart.getType());
			// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in componentUtils.mtl module, with the values : lower, Property, Property, property.
			// FIXME INVALID CASE INTO template public partUpdater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in componentUtils.mtl module, with the values : upper, Property, Property, property.


			return propertyToUpdate;
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
			if(UMLViewsRepository.Property.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.Property.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.Property.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.Property.isStatic == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getFeature_IsStatic(), event.getNewValue()));

			if(UMLViewsRepository.Property.isOrdered == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), event.getNewValue()));

			if(UMLViewsRepository.Property.isUnique == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), event.getNewValue()));

			if(UMLViewsRepository.Property.isReadOnly == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly(), event.getNewValue()));

			if(UMLViewsRepository.Property.deployment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Deployment oldValue = (Deployment)event.getOldValue();
					Deployment newValue = (Deployment)event.getNewValue();


					// TODO: Complete the property update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getDeploymentTarget_Deployment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getDeployment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Property.isDerived == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_IsDerived(), event.getNewValue()));

			if(UMLViewsRepository.Property.isDerivedUnion == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), event.getNewValue()));

			if(UMLViewsRepository.Property.aggregation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_Aggregation(), event.getNewValue()));

			if(UMLViewsRepository.Property.redefinedProperty == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_RedefinedProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Property.subsettedProperty == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Property.qualifier == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Property oldValue = (Property)event.getOldValue();
					Property newValue = (Property)event.getNewValue();


					// TODO: Complete the property update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty_Qualifier(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Property.type == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, property, UMLPackage.eINSTANCE.getTypedElement_Type(), event.getNewValue()));
			// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in componentUtils.mtl module, with the values : lower, Property, property.
			// FIXME INVALID CASE INTO template public liveCommandUpdater(editionElement : PropertiesEditionElement, view : View, modelName : String) in componentUtils.mtl module, with the values : upper, Property, property.


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {
				if(UMLViewsRepository.Property.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





				if(UMLViewsRepository.Property.lower == event.getAffectedEditor())
					basePart.setMessageForLower(diag.getMessage(), IMessageProvider.ERROR);
				if(UMLViewsRepository.Property.upper == event.getAffectedEditor())
					basePart.setMessageForUpper(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if(UMLViewsRepository.Property.name == event.getAffectedEditor())
					basePart.unsetMessageForName();





				if(UMLViewsRepository.Property.lower == event.getAffectedEditor())
					basePart.unsetMessageForLower();
				if(UMLViewsRepository.Property.upper == event.getAffectedEditor())
					basePart.unsetMessageForUpper();


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.Property.isLeaf || key == UMLViewsRepository.Property.isStatic || key == UMLViewsRepository.Property.isOrdered || key == UMLViewsRepository.Property.isUnique || key == UMLViewsRepository.Property.isReadOnly || key == UMLViewsRepository.Property.isDerived || key == UMLViewsRepository.Property.isDerivedUnion || key == UMLViewsRepository.Property.aggregation;
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
				if(UMLViewsRepository.Property.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isStatic == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isOrdered == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isUnique == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isReadOnly == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isDerived == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getProperty_IsDerived().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getProperty_IsDerived().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.isDerivedUnion == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.aggregation == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getProperty_Aggregation().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getProperty_Aggregation().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.lower == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_Lower().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_Lower().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.Property.upper == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_Upper().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_Upper().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(property);
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
			property.eAdapters().remove(semanticAdapter);
	}

}
