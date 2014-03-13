/**
 *  Copyright (c) 2011 Mia-Software.
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
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.provider.Efacet2EditPlugin;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtendedEObjectReferenceItemProvider
	extends ItemProviderAdapter
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
	public ExtendedEObjectReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addExtendedEObjectPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Extended EObject feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendedEObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExtendedEObjectReference_extendedEObject_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExtendedEObjectReference_extendedEObject_feature", "_UI_ExtendedEObjectReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES);
			childrenFeatures.add(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES);
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
	 * This returns ExtendedEObjectReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExtendedEObjectReference")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ExtendedEObjectReference_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(ExtendedEObjectReference.class)) {
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES:
			case SerializationPackage.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES:
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
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES,
				 SerializationFactory.eINSTANCE.createAbstractAttributeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES,
				 SerializationFactory.eINSTANCE.createSingleValuedAttributeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES,
				 SerializationFactory.eINSTANCE.createMultiValuedAttributeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES,
				 SerializationFactory.eINSTANCE.createAbstractReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES,
				 SerializationFactory.eINSTANCE.createMultiValuedContainmentReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES,
				 SerializationFactory.eINSTANCE.createMultiValuedReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES,
				 SerializationFactory.eINSTANCE.createSingleValuedContainmentReferenceInstance()));

		newChildDescriptors.add
			(createChildParameter
				(SerializationPackage.Literals.EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES,
				 SerializationFactory.eINSTANCE.createSingleValuedReferenceInstance()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Efacet2EditPlugin.INSTANCE;
	}

}
