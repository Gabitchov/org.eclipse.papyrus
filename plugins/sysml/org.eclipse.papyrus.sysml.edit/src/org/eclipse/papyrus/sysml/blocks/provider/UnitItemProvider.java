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
import org.eclipse.papyrus.sysml.blocks.Unit;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.blocks.Unit} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UnitItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of unit
	 * 
	 * @generated
	 */
	private static Pattern UNIT_PREFIX_PATTERN = Pattern.compile("(unit, |<<unit>>|, unit)");

	/**
	 * Get the prefix pattern of INSTANCE_SPECIFICATION_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern INSTANCE_SPECIFICATION_PREFIX_PATTERN = Pattern.compile("Instance Specification");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnitItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Unit) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_InstanceSpecificationPropertyDescriptor(object);
				addDimensionPropertyDescriptor(object);
			}
		}

		/**
		 * Handle InstanceSpecification stereotyped by Unit
		 */
		if(object instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			org.eclipse.uml2.uml.InstanceSpecification element = (org.eclipse.uml2.uml.InstanceSpecification)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForinstanceSpecification = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INSTANCE_SPECIFICATION);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForinstanceSpecification.addAll(propertyDescriptors);
			Unit steApplication = UMLUtil.getStereotypeApplication(element, Unit.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForinstanceSpecification.add(createBase_InstanceSpecificationPropertyDescriptorForInstanceSpecification(steApplication));

				itemPropertyDescriptorsForinstanceSpecification.add(createDimensionPropertyDescriptorForInstanceSpecification(steApplication));

			}
			return itemPropertyDescriptorsForinstanceSpecification;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Instance Specification feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_InstanceSpecificationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Unit_base_InstanceSpecification_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Unit_base_InstanceSpecification_feature", "_UI_Unit_type"), BlocksPackage.Literals.UNIT__BASE_INSTANCE_SPECIFICATION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Instance Specification feature for the UML element InstanceSpecification.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_InstanceSpecificationPropertyDescriptorForInstanceSpecification(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Unit_base_InstanceSpecification_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Unit_base_InstanceSpecification_feature", "_UI_Unit_type"),

		BlocksPackage.Literals.UNIT__BASE_INSTANCE_SPECIFICATION, true, false, true,

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
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Unit_dimension_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Unit_dimension_feature", "_UI_Unit_type"), BlocksPackage.Literals.UNIT__DIMENSION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Dimension feature for the UML element InstanceSpecification.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createDimensionPropertyDescriptorForInstanceSpecification(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Unit_dimension_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Unit_dimension_feature", "_UI_Unit_type"),

		BlocksPackage.Literals.UNIT__DIMENSION, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns Unit.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Unit"));
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
		Unit unit_ = null;

		if(object instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.InstanceSpecification)object, Unit.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INSTANCE_SPECIFICATION);
				String result = ite.getText(object);
				result = UNIT_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return INSTANCE_SPECIFICATION_PREFIX_PATTERN.matcher(result).replaceFirst("Unit");
			}

		}

		if(unit_ == null) {
			unit_ = (Unit)object;
		}

		return getString("_UI_Unit_type");
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
			 * Handle InstanceSpecification stereotyped by Unit
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.InstanceSpecification.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INSTANCE_SPECIFICATION);
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
				 * Handle InstanceSpecification stereotyped by Unit
				 */
				if(UMLPackage.Literals.INSTANCE_SPECIFICATION.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INSTANCE_SPECIFICATION);
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
				 * Handle InstanceSpecification stereotyped by Unit
				 */
				if(UMLPackage.Literals.INSTANCE_SPECIFICATION.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INSTANCE_SPECIFICATION);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
