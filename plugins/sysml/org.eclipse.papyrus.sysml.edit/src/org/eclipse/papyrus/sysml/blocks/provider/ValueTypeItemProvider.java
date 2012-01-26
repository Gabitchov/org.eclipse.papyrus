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
import org.eclipse.papyrus.sysml.blocks.ValueType;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.blocks.ValueType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ValueTypeItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of valueType
	 * 
	 * @generated
	 */
	private static Pattern VALUE_TYPE_PREFIX_PATTERN = Pattern.compile("(valueType, |<<valueType>>|, valueType)");

	/**
	 * Get the prefix pattern of DATA_TYPE_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern DATA_TYPE_PREFIX_PATTERN = Pattern.compile("Data Type");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueTypeItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof ValueType) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_DataTypePropertyDescriptor(object);
				addUnitPropertyDescriptor(object);
				addDimensionPropertyDescriptor(object);
			}
		}

		/**
		 * Handle DataType stereotyped by ValueType
		 */
		if(object instanceof org.eclipse.uml2.uml.DataType) {
			org.eclipse.uml2.uml.DataType element = (org.eclipse.uml2.uml.DataType)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsFordataType = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.DATA_TYPE);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsFordataType.addAll(propertyDescriptors);
			ValueType steApplication = UMLUtil.getStereotypeApplication(element, ValueType.class);
			if(steApplication != null) {

				itemPropertyDescriptorsFordataType.add(createBase_DataTypePropertyDescriptorForDataType(steApplication));

				itemPropertyDescriptorsFordataType.add(createUnitPropertyDescriptorForDataType(steApplication));

				itemPropertyDescriptorsFordataType.add(createDimensionPropertyDescriptorForDataType(steApplication));

			}
			return itemPropertyDescriptorsFordataType;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Data Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_DataTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ValueType_base_DataType_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ValueType_base_DataType_feature", "_UI_ValueType_type"), BlocksPackage.Literals.VALUE_TYPE__BASE_DATA_TYPE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Data Type feature for the UML element DataType.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_DataTypePropertyDescriptorForDataType(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ValueType_base_DataType_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ValueType_base_DataType_feature", "_UI_ValueType_type"),

		BlocksPackage.Literals.VALUE_TYPE__BASE_DATA_TYPE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Unit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addUnitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ValueType_unit_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ValueType_unit_feature", "_UI_ValueType_type"), BlocksPackage.Literals.VALUE_TYPE__UNIT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Unit feature for the UML element DataType.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createUnitPropertyDescriptorForDataType(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ValueType_unit_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ValueType_unit_feature", "_UI_ValueType_type"),

		BlocksPackage.Literals.VALUE_TYPE__UNIT, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Dimension feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDimensionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ValueType_dimension_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ValueType_dimension_feature", "_UI_ValueType_type"), BlocksPackage.Literals.VALUE_TYPE__DIMENSION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Dimension feature for the UML element DataType.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createDimensionPropertyDescriptorForDataType(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ValueType_dimension_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ValueType_dimension_feature", "_UI_ValueType_type"),

		BlocksPackage.Literals.VALUE_TYPE__DIMENSION, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns ValueType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/ValueType"));
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
		ValueType valueType_ = null;

		if(object instanceof org.eclipse.uml2.uml.DataType) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.DataType)object, ValueType.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.DATA_TYPE);
				String result = ite.getText(object);
				result = VALUE_TYPE_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return DATA_TYPE_PREFIX_PATTERN.matcher(result).replaceFirst("ValueType");
			}

		}

		if(valueType_ == null) {
			valueType_ = (ValueType)object;
		}

		return getString("_UI_ValueType_type");
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
			 * Handle DataType stereotyped by ValueType
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.DataType.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.DATA_TYPE);
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
				 * Handle DataType stereotyped by ValueType
				 */
				if(UMLPackage.Literals.DATA_TYPE.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.DATA_TYPE);
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
				 * Handle DataType stereotyped by ValueType
				 */
				if(UMLPackage.Literals.DATA_TYPE.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.DATA_TYPE);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
