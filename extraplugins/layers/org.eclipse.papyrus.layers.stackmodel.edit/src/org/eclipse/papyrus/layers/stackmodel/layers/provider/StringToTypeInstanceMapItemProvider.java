/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.provider;


import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;

/**
 * This is the item provider adapter for a {@link java.util.Map.Entry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StringToTypeInstanceMapItemProvider
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
	public StringToTypeInstanceMapItemProvider(AdapterFactory adapterFactory) {
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

			addKeyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StringToTypeInstanceMap_key_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StringToTypeInstanceMap_key_feature", "_UI_StringToTypeInstanceMap_type"),
				 LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE);
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
	 * This returns StringToTypeInstanceMap.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StringToTypeInstanceMap"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Map.Entry<?, ?> stringToTypeInstanceMap = (Map.Entry<?, ?>)object;
//		return "" + stringToTypeInstanceMap.getKey() + " -> " + stringToTypeInstanceMap.getValue();
		
//		TypeInstance instance = (TypeInstance)stringToTypeInstanceMap.getValue();
		
		return "Property '" + stringToTypeInstanceMap.getKey() + "'";
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

		switch (notification.getFeatureID(Map.Entry.class)) {
			case LayersPackage.STRING_TO_TYPE_INSTANCE_MAP__KEY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LayersPackage.STRING_TO_TYPE_INSTANCE_MAP__VALUE:
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
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createIntInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createBooleanInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createStringInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createNullInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createColorInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createFillInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createLineInstance()));

		newChildDescriptors.add
			(createChildParameter
				(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP__VALUE,
				 LayersFactory.eINSTANCE.createFontInstance()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return LayersEditPlugin.INSTANCE;
	}

}
