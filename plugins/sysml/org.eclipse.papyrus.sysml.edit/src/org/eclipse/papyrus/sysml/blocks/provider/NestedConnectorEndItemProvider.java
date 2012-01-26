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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class NestedConnectorEndItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

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

	private static Pattern CONNECTOR_END_PREFIX_PATTERN = Pattern.compile("Connector End");

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
		if(object instanceof NestedConnectorEnd) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addPropertyPathPropertyDescriptor(object);
				addBase_ConnectorEndPropertyDescriptor(object);
			}
		}

		/**
		 * Handle ConnectorEnd stereotyped by NestedConnectorEnd
		 */
		if(object instanceof org.eclipse.uml2.uml.ConnectorEnd) {
			org.eclipse.uml2.uml.ConnectorEnd element = (org.eclipse.uml2.uml.ConnectorEnd)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForconnectorEnd = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForconnectorEnd.addAll(propertyDescriptors);
			NestedConnectorEnd steApplication = UMLUtil.getStereotypeApplication(element, NestedConnectorEnd.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForconnectorEnd.add(createPropertyPathPropertyDescriptorForConnectorEnd(steApplication));

				itemPropertyDescriptorsForconnectorEnd.add(createBase_ConnectorEndPropertyDescriptorForConnectorEnd(steApplication));

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
	 * This adds a property descriptor for the Property Path feature for the UML element ConnectorEnd.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createPropertyPathPropertyDescriptorForConnectorEnd(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_NestedConnectorEnd_propertyPath_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_NestedConnectorEnd_propertyPath_feature", "_UI_NestedConnectorEnd_type"),

		BlocksPackage.Literals.NESTED_CONNECTOR_END__PROPERTY_PATH, true, false, true,

		null,

		null,

		null));

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
	 * This adds a property descriptor for the Base Connector End feature for the UML element ConnectorEnd.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ConnectorEndPropertyDescriptorForConnectorEnd(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_NestedConnectorEnd_base_ConnectorEnd_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_NestedConnectorEnd_base_ConnectorEnd_feature", "_UI_NestedConnectorEnd_type"),

		BlocksPackage.Literals.NESTED_CONNECTOR_END__BASE_CONNECTOR_END, true, false, true,

		null,

		null,

		null));

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
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.ConnectorEnd)object, NestedConnectorEnd.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
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
		 * Notify UML element
		 */
		if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

			/**
			 * Handle ConnectorEnd stereotyped by NestedConnectorEnd
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.ConnectorEnd.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
				ite.notifyChanged(notification);
				return;

			}

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

	/**
	 * Override in order to handle has children for based class
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<?> getChildren(Object object) {
		Collection<Object> result = (Collection<Object>)super.getChildren(object);
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			/**
			 * Handle based elements type
			 */
			if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

				/**
				 * Handle ConnectorEnd stereotyped by NestedConnectorEnd
				 */
				if(UMLPackage.Literals.CONNECTOR_END.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
					result.addAll((Collection<Object>)ite.getChildren(object));
					return result;
				}

			}
		}
		return result;
	}

	/**
	 * Override in order to handle has children for based class
	 * 
	 * @generated
	 */
	@Override
	public boolean hasChildren(Object object) {
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			/**
			 * Handle based elements type
			 */
			if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

				/**
				 * Handle ConnectorEnd stereotyped by NestedConnectorEnd
				 */
				if(UMLPackage.Literals.CONNECTOR_END.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CONNECTOR_END);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
