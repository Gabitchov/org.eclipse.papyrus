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
package org.eclipse.papyrus.sysml.constraints.provider;

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
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.constraints.ConstraintProperty} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConstraintPropertyItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of constraintProperty
	 * 
	 * @generated
	 */
	private static Pattern CONSTRAINT_PROPERTY_PREFIX_PATTERN = Pattern.compile("(constraintProperty, |<<constraintProperty>>|, constraintProperty)");

	/**
	 * Get the prefix pattern of PROPERTY_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern PROPERTY_PREFIX_PATTERN = Pattern.compile("Property");

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintPropertyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(object instanceof ConstraintProperty) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_PropertyPropertyDescriptor(object);
			}
		}

		/**
		 * Handle Property stereotyped by ConstraintProperty
		 */
		if(object instanceof org.eclipse.uml2.uml.Property) {
			org.eclipse.uml2.uml.Property element = (org.eclipse.uml2.uml.Property)object;
			/**
			 * This is used to store all the property descriptors for a class
			 * stereotyped with a block. Derived classes should add descriptors
			 * to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForproperty = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PROPERTY);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForproperty.addAll(propertyDescriptors);
			Stereotype ste = (element).getAppliedStereotype(SysmlResource.CONSTRAINT_PROPERTY_ID);
			if(ste != null) {
				EObject steApplication = (element).getStereotypeApplication(ste);

				itemPropertyDescriptorsForproperty.add(createBase_PropertyPropertyDescriptorForProperty(steApplication));

			}
			return itemPropertyDescriptorsForproperty;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Property feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_PropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ConstraintProperty_base_Property_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ConstraintProperty_base_Property_feature", "_UI_ConstraintProperty_type"), ConstraintsPackage.Literals.CONSTRAINT_PROPERTY__BASE_PROPERTY, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Property feature for the UML
	 * element Property. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_PropertyPropertyDescriptorForProperty(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ConstraintProperty_base_Property_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ConstraintProperty_base_Property_feature", "_UI_ConstraintProperty_type"),

		ConstraintsPackage.Literals.CONSTRAINT_PROPERTY__BASE_PROPERTY, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns ConstraintProperty.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/ConstraintProperty"));
		if(object instanceof NamedElement) {
			ComposedImage aux = new ComposedImage(Collections.singletonList(composedImage));
			return (Object)composeVisibilityImage(object, aux);
		}
		return composedImage;
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		/**
		 * Handle Stereotype item and stereoted element
		 */
		ConstraintProperty constraintProperty_ = null;

		if(object instanceof org.eclipse.uml2.uml.Property) {
			Stereotype ste = ((org.eclipse.uml2.uml.Property)object).getAppliedStereotype(SysmlResource.CONSTRAINT_PROPERTY_ID);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PROPERTY);
				String result = ite.getText(object);
				result = CONSTRAINT_PROPERTY_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return PROPERTY_PREFIX_PATTERN.matcher(result).replaceFirst("ConstraintProperty");
			}

		}

		if(constraintProperty_ == null) {
			constraintProperty_ = (ConstraintProperty)object;
		}

		return getString("_UI_ConstraintProperty_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
			 * Handle Property stereotyped by ConstraintProperty
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Property.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PROPERTY);
				ite.notifyChanged(notification);
				return;

			}

		}

		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SysmlEditPlugin.INSTANCE;
	}

}
