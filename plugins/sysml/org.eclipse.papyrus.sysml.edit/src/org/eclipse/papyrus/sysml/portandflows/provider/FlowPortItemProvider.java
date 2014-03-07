/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.portandflows.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.portandflows.FlowPort} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class FlowPortItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FlowPortItemProvider(AdapterFactory adapterFactory) {
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

			addBase_PortPropertyDescriptor(object);
			addIsAtomicPropertyDescriptor(object);
			addIsConjugatedPropertyDescriptor(object);
			addDirectionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_PortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_base_Port_feature"), getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_base_Port_feature", "_UI_FlowPort_type"), PortandflowsPackage.Literals.FLOW_PORT__BASE_PORT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Is Atomic feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addIsAtomicPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_isAtomic_feature"), getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_isAtomic_feature", "_UI_FlowPort_type"), PortandflowsPackage.Literals.FLOW_PORT__IS_ATOMIC, false, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Is Conjugated feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addIsConjugatedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_isConjugated_feature"), getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_isConjugated_feature", "_UI_FlowPort_type"), PortandflowsPackage.Literals.FLOW_PORT__IS_CONJUGATED, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Direction feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDirectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_direction_feature"), getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_direction_feature", "_UI_FlowPort_type"), PortandflowsPackage.Literals.FLOW_PORT__DIRECTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns FlowPort.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowPort"));
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
		FlowPort flowPort = (FlowPort)object;
		return getString("_UI_FlowPort_type") + " " + flowPort.isAtomic();
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

		switch(notification.getFeatureID(FlowPort.class)) {
		case PortandflowsPackage.FLOW_PORT__IS_ATOMIC:
		case PortandflowsPackage.FLOW_PORT__IS_CONJUGATED:
		case PortandflowsPackage.FLOW_PORT__DIRECTION:
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SysmlEditPlugin.INSTANCE;
	}

}
