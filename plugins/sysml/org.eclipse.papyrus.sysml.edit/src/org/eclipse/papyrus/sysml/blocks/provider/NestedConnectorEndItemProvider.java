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
package org.eclipse.papyrus.sysml.blocks.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class NestedConnectorEndItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This is used to store all the property descriptors for aclass stereotyped with a block.
	 * Derived classes should add descriptors to this vector.
	 */
	protected List<IItemPropertyDescriptor> itemPropertyDescriptorsForconnectorEnd;

	/**
	 * Pattern prefix of nestedConnectorEnd
	 * 
	 * @generated
	 */
	private static Pattern NESTED_CONNECTOR_END_PREFIX_PATTERN = Pattern.compile("(nestedConnectorEnd, |<<nestedConnectorEnd>>|, nestedConnectorEnd)");

	/**
	 * Get the prefix pattern of CONNECTOR_END_PREFIX_PATTERN
	 * 
	 * @generated
	 */
	private static Pattern CONNECTOR_END_PREFIX_PATTERN = Pattern.compile("ConnectorEnd");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NestedConnectorEndItemProvider(AdapterFactory adapterFactory) {
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

			addPropertyPathPropertyDescriptor(object);
			addBase_ConnectorEndPropertyDescriptor(object);
		}

		/**
		 * Handle ConnectorEnd stereotyped by NestedConnectorEnd
		 */
		if(object instanceof org.eclipse.uml2.uml.ConnectorEnd) {
			if(itemPropertyDescriptorsForconnectorEnd == null) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
				final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);
				itemPropertyDescriptorsForconnectorEnd = new ArrayList<IItemPropertyDescriptor>();
				itemPropertyDescriptorsForconnectorEnd.addAll(propertyDescriptors);
			}
			return itemPropertyDescriptorsForconnectorEnd;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Property Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPropertyPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_NestedConnectorEnd_propertyPath_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NestedConnectorEnd_propertyPath_feature", "_UI_NestedConnectorEnd_type"), BlocksPackage.Literals.NESTED_CONNECTOR_END__PROPERTY_PATH, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Connector End feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ConnectorEndPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_NestedConnectorEnd_base_ConnectorEnd_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NestedConnectorEnd_base_ConnectorEnd_feature", "_UI_NestedConnectorEnd_type"), BlocksPackage.Literals.NESTED_CONNECTOR_END__BASE_CONNECTOR_END, true, false, true, null, null, null));
	}

	/**
	 * This returns NestedConnectorEnd.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/NestedConnectorEnd"));
		if(object instanceof NamedElement) {
			ComposedImage aux = new ComposedImage(Collections.singletonList(composedImage));
			return (Object)composeVisibilityImage(object, aux);
		}
		return composedImage;
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
		/**
		 * Handle Stereotype item and stereoted element
		 */
		NestedConnectorEnd nestedConnectorEnd_ = null;

		if(object instanceof org.eclipse.uml2.uml.ConnectorEnd) {
			Stereotype ste = ((org.eclipse.uml2.uml.ConnectorEnd)object).getAppliedStereotype(SysmlResource.NESTED_CONNECTOR_END_ID);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
				String result = ite.getText(object);
				result = NESTED_CONNECTOR_END_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return CONNECTOR_END_PREFIX_PATTERN.matcher(result).replaceFirst("NestedConnectorEnd");
			}

		}

		if(nestedConnectorEnd_ == null) {
			nestedConnectorEnd_ = (NestedConnectorEnd)object;
		}

		return getString("_UI_NestedConnectorEnd_type");
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

		/**
		 * Handle ConnectorEnd stereotyped by NestedConnectorEnd
		 */

		if(notification.getFeatureID(org.eclipse.uml2.uml.ConnectorEnd.class) != Notification.NO_FEATURE_ID) {
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
			ite.notifyChanged(notification);
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
