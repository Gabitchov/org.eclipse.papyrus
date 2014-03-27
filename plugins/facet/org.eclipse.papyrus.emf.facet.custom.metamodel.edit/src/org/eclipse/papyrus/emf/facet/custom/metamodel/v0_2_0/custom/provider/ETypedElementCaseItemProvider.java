/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *       Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.provider;


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
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ETypedElementCaseItemProvider
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
	public ETypedElementCaseItemProvider(AdapterFactory adapterFactory) {
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

			addCasePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Case feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCasePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElementCase_case_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElementCase_case_feature", "_UI_ETypedElementCase_type"),
				 CustomPackage.Literals.ETYPED_ELEMENT_CASE__CASE,
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
			childrenFeatures.add(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE);
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
	 * This returns ETypedElementCase.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ETypedElementCase"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ETypedElementCase_type");
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

		switch (notification.getFeatureID(ETypedElementCase.class)) {
			case CustomPackage.ETYPED_ELEMENT_CASE__VALUE:
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
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 CustomFactory.eINSTANCE.createETypedElementSwitchQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createNavigationQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createIsOneOfQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createStringLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createTrueLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createFalseLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createNullLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createIntegerLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createFloatLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createEObjectLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(CustomPackage.Literals.ETYPED_ELEMENT_CASE__VALUE,
				 QueryFactory.eINSTANCE.createOperationCallQuery()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CustomEditPlugin.INSTANCE;
	}

}
