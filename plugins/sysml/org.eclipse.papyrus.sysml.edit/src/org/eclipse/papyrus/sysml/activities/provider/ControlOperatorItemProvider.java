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
package org.eclipse.papyrus.sysml.activities.provider;

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
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.ControlOperator;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.activities.ControlOperator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ControlOperatorItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of controlOperator
	 * 
	 * @generated
	 */
	private static Pattern CONTROL_OPERATOR_PREFIX_PATTERN = Pattern.compile("(controlOperator, |<<controlOperator>>|, controlOperator)");

	/**
	 * Get the prefix pattern of OPERATION_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern OPERATION_PREFIX_PATTERN = Pattern.compile("Operation");

	/**
	 * Get the prefix pattern of BEHAVIOR_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern BEHAVIOR_PREFIX_PATTERN = Pattern.compile("Behavior");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ControlOperatorItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof ControlOperator) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_OperationPropertyDescriptor(object);
				addBase_BehaviorPropertyDescriptor(object);
			}
		}

		/**
		 * Handle Operation stereotyped by ControlOperator
		 */
		if(object instanceof org.eclipse.uml2.uml.Operation) {
			org.eclipse.uml2.uml.Operation element = (org.eclipse.uml2.uml.Operation)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForoperation = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.OPERATION);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForoperation.addAll(propertyDescriptors);
			ControlOperator steApplication = UMLUtil.getStereotypeApplication(element, ControlOperator.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForoperation.add(createBase_OperationPropertyDescriptorForOperation(steApplication));

				itemPropertyDescriptorsForoperation.add(createBase_OperationPropertyDescriptorForBehavior(steApplication));

				itemPropertyDescriptorsForoperation.add(createBase_BehaviorPropertyDescriptorForOperation(steApplication));

				itemPropertyDescriptorsForoperation.add(createBase_BehaviorPropertyDescriptorForBehavior(steApplication));

			}
			return itemPropertyDescriptorsForoperation;

		}

		/**
		 * Handle Behavior stereotyped by ControlOperator
		 */
		if(object instanceof org.eclipse.uml2.uml.Behavior) {
			org.eclipse.uml2.uml.Behavior element = (org.eclipse.uml2.uml.Behavior)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForbehavior = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.BEHAVIOR);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForbehavior.addAll(propertyDescriptors);
			ControlOperator steApplication = UMLUtil.getStereotypeApplication(element, ControlOperator.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForbehavior.add(createBase_OperationPropertyDescriptorForOperation(steApplication));

				itemPropertyDescriptorsForbehavior.add(createBase_OperationPropertyDescriptorForBehavior(steApplication));

				itemPropertyDescriptorsForbehavior.add(createBase_BehaviorPropertyDescriptorForOperation(steApplication));

				itemPropertyDescriptorsForbehavior.add(createBase_BehaviorPropertyDescriptorForBehavior(steApplication));

			}
			return itemPropertyDescriptorsForbehavior;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Operation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_OperationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ControlOperator_base_Operation_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ControlOperator_base_Operation_feature", "_UI_ControlOperator_type"), ActivitiesPackage.Literals.CONTROL_OPERATOR__BASE_OPERATION, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Operation feature for the UML element Operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_OperationPropertyDescriptorForOperation(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ControlOperator_base_Operation_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ControlOperator_base_Operation_feature", "_UI_ControlOperator_type"),

		ActivitiesPackage.Literals.CONTROL_OPERATOR__BASE_OPERATION, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Operation feature for the UML element Behavior.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_OperationPropertyDescriptorForBehavior(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ControlOperator_base_Operation_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ControlOperator_base_Operation_feature", "_UI_ControlOperator_type"),

		ActivitiesPackage.Literals.CONTROL_OPERATOR__BASE_OPERATION, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Behavior feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_BehaviorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ControlOperator_base_Behavior_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ControlOperator_base_Behavior_feature", "_UI_ControlOperator_type"), ActivitiesPackage.Literals.CONTROL_OPERATOR__BASE_BEHAVIOR, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Behavior feature for the UML element Operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_BehaviorPropertyDescriptorForOperation(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ControlOperator_base_Behavior_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ControlOperator_base_Behavior_feature", "_UI_ControlOperator_type"),

		ActivitiesPackage.Literals.CONTROL_OPERATOR__BASE_BEHAVIOR, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Behavior feature for the UML element Behavior.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_BehaviorPropertyDescriptorForBehavior(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ControlOperator_base_Behavior_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ControlOperator_base_Behavior_feature", "_UI_ControlOperator_type"),

		ActivitiesPackage.Literals.CONTROL_OPERATOR__BASE_BEHAVIOR, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns ControlOperator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/ControlOperator"));
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
		ControlOperator controlOperator_ = null;

		if(object instanceof org.eclipse.uml2.uml.Operation) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Operation)object, ControlOperator.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.OPERATION);
				String result = ite.getText(object);
				result = CONTROL_OPERATOR_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return OPERATION_PREFIX_PATTERN.matcher(result).replaceFirst("ControlOperator");
			}

		}

		if(object instanceof org.eclipse.uml2.uml.Behavior) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Behavior)object, ControlOperator.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.BEHAVIOR);
				String result = ite.getText(object);
				result = CONTROL_OPERATOR_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return BEHAVIOR_PREFIX_PATTERN.matcher(result).replaceFirst("ControlOperator");
			}

		}

		if(controlOperator_ == null) {
			controlOperator_ = (ControlOperator)object;
		}

		return getString("_UI_ControlOperator_type");
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
			 * Handle Operation stereotyped by ControlOperator
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Operation.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.OPERATION);
				ite.notifyChanged(notification);
				return;

			}

			/**
			 * Handle Behavior stereotyped by ControlOperator
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Behavior.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.BEHAVIOR);
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
				 * Handle Operation stereotyped by ControlOperator
				 */
				if(UMLPackage.Literals.OPERATION.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.OPERATION);
					result.addAll((Collection<Object>)ite.getChildren(object));
					return result;
				}

				/**
				 * Handle Behavior stereotyped by ControlOperator
				 */
				if(UMLPackage.Literals.BEHAVIOR.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.BEHAVIOR);
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
				 * Handle Operation stereotyped by ControlOperator
				 */
				if(UMLPackage.Literals.OPERATION.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.OPERATION);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

				/**
				 * Handle Behavior stereotyped by ControlOperator
				 */
				if(UMLPackage.Literals.BEHAVIOR.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.BEHAVIOR);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
