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
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DerivedTypedElementItemProvider
	extends FacetElementItemProvider
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
	public DerivedTypedElementItemProvider(AdapterFactory adapterFactory) {
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

			addOverridePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Override feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverridePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DerivedTypedElement_override_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DerivedTypedElement_override_feature", "_UI_DerivedTypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__OVERRIDE,
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
			childrenFeatures.add(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DerivedTypedElement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DerivedTypedElement_type") : //$NON-NLS-1$
			getString("_UI_DerivedTypedElement_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(DerivedTypedElement.class)) {
			case EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY:
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
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createNavigationQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createIsOneOfQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createStringLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createTrueLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createFalseLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createNullLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createIntegerLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createFloatLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createEObjectLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createOperationCallQuery()));
	}

}
