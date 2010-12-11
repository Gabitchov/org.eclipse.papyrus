/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.Ellipse;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.di.Ellipse} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class EllipseItemProvider
		extends GraphicPrimitiveItemProvider
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
	 * 
	 * @generated
	 */
	public EllipseItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCenterPropertyDescriptor(object);
			addRadiusXPropertyDescriptor(object);
			addRadiusYPropertyDescriptor(object);
			addRotationPropertyDescriptor(object);
			addStartAnglePropertyDescriptor(object);
			addEndAnglePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Center feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCenterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Ellipse_center_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Ellipse_center_feature", "_UI_Ellipse_type"),
				DiPackage.Literals.ELLIPSE__CENTER,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Radius X feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRadiusXPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Ellipse_radiusX_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Ellipse_radiusX_feature", "_UI_Ellipse_type"),
				DiPackage.Literals.ELLIPSE__RADIUS_X,
				true,
				false,
				false,
				ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Radius Y feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRadiusYPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Ellipse_radiusY_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Ellipse_radiusY_feature", "_UI_Ellipse_type"),
				DiPackage.Literals.ELLIPSE__RADIUS_Y,
				true,
				false,
				false,
				ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Rotation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRotationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Ellipse_rotation_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Ellipse_rotation_feature", "_UI_Ellipse_type"),
				DiPackage.Literals.ELLIPSE__ROTATION,
				true,
				false,
				false,
				ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Start Angle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartAnglePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Ellipse_startAngle_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Ellipse_startAngle_feature", "_UI_Ellipse_type"),
				DiPackage.Literals.ELLIPSE__START_ANGLE,
				true,
				false,
				false,
				ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the End Angle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addEndAnglePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Ellipse_endAngle_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Ellipse_endAngle_feature", "_UI_Ellipse_type"),
				DiPackage.Literals.ELLIPSE__END_ANGLE,
				true,
				false,
				false,
				ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This returns Ellipse.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Ellipse"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Ellipse ellipse = (Ellipse)object;
		return getString("_UI_Ellipse_type") + " " + ellipse.isIsVisible();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch(notification.getFeatureID(Ellipse.class)) {
		case DiPackage.ELLIPSE__CENTER:
		case DiPackage.ELLIPSE__RADIUS_X:
		case DiPackage.ELLIPSE__RADIUS_Y:
		case DiPackage.ELLIPSE__ROTATION:
		case DiPackage.ELLIPSE__START_ANGLE:
		case DiPackage.ELLIPSE__END_ANGLE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
