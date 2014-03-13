/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimeFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiValuedContainmentReferenceInstanceItemProvider
	extends AbstractReferenceInstanceItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiValuedContainmentReferenceInstanceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MultiValuedContainmentReferenceInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MultiValuedContainmentReferenceInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_MultiValuedContainmentReferenceInstance_type"); //$NON-NLS-1$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MultiValuedContainmentReferenceInstance.class)) {
			case SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createAbstractReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createMultiValuedContainmentReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createMultiValuedReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createAbstractAttributeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createSingleValuedAttributeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createExtendedEObjectReference()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createSingleValuedContainmentReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createSingleValuedReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 SerializationFactory.eINSTANCE.createMultiValuedAttributeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createFacetAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createFacetReference()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createFacetOperation()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createFacetSet()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createFacet()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createCategory()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createParameterValue()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EFacetFactory.eINSTANCE.createDocumentedElement()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createNavigationQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createIsOneOfQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createStringLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createTrueLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createFalseLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createNullLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createIntegerLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createFloatLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createEObjectLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 QueryFactory.eINSTANCE.createOperationCallQuery()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 RuntimeFactory.eINSTANCE.createETypedElementPrimitiveTypeResult()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 RuntimeFactory.eINSTANCE.createETypedElementEObjectResult()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 RuntimeFactory.eINSTANCE.createETypedElementPrimitiveTypeListResult()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 RuntimeFactory.eINSTANCE.createETypedElementEObjectListResult()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS,
				 EcoreFactory.eINSTANCE.createETypeParameter()));
	}

}
