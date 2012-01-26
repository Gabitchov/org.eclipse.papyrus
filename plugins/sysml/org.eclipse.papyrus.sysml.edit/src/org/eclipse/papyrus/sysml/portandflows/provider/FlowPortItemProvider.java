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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.portandflows.FlowPort} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class FlowPortItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of flowPort
	 * 
	 * @generated
	 */
	private static Pattern FLOW_PORT_PREFIX_PATTERN = Pattern.compile("(flowPort, |<<flowPort>>|, flowPort)");

	/**
	 * Get the prefix pattern of PORT_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern PORT_PREFIX_PATTERN = Pattern.compile("Port");

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
		if(object instanceof FlowPort) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_PortPropertyDescriptor(object);
				addIsAtomicPropertyDescriptor(object);
				addIsConjugatedPropertyDescriptor(object);
				addDirectionPropertyDescriptor(object);
			}
		}

		/**
		 * Handle Port stereotyped by FlowPort
		 */
		if(object instanceof org.eclipse.uml2.uml.Port) {
			org.eclipse.uml2.uml.Port element = (org.eclipse.uml2.uml.Port)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForport = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PORT);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForport.addAll(propertyDescriptors);
			FlowPort steApplication = UMLUtil.getStereotypeApplication(element, FlowPort.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForport.add(createBase_PortPropertyDescriptorForPort(steApplication));

				itemPropertyDescriptorsForport.add(createIsAtomicPropertyDescriptorForPort(steApplication));

				itemPropertyDescriptorsForport.add(createIsConjugatedPropertyDescriptorForPort(steApplication));

				itemPropertyDescriptorsForport.add(createDirectionPropertyDescriptorForPort(steApplication));

			}
			return itemPropertyDescriptorsForport;

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
	 * This adds a property descriptor for the Base Port feature for the UML element Port.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_PortPropertyDescriptorForPort(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_base_Port_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_base_Port_feature", "_UI_FlowPort_type"),

		PortandflowsPackage.Literals.FLOW_PORT__BASE_PORT, true, false, true,

		null,

		null,

		null));

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
	 * This adds a property descriptor for the Is Atomic feature for the UML element Port.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createIsAtomicPropertyDescriptorForPort(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_isAtomic_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_isAtomic_feature", "_UI_FlowPort_type"),

		PortandflowsPackage.Literals.FLOW_PORT__IS_ATOMIC, false, false, false,

		ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,

		null,

		null));

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
	 * This adds a property descriptor for the Is Conjugated feature for the UML element Port.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createIsConjugatedPropertyDescriptorForPort(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_isConjugated_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_isConjugated_feature", "_UI_FlowPort_type"),

		PortandflowsPackage.Literals.FLOW_PORT__IS_CONJUGATED, true, false, false,

		ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,

		null,

		null));

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
	 * This adds a property descriptor for the Direction feature for the UML element Port.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createDirectionPropertyDescriptorForPort(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FlowPort_direction_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_FlowPort_direction_feature", "_UI_FlowPort_type"),

		PortandflowsPackage.Literals.FLOW_PORT__DIRECTION, true, false, false,

		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,

		null,

		null));

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
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/FlowPort"));
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
		FlowPort flowPort_ = null;

		if(object instanceof org.eclipse.uml2.uml.Port) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Port)object, FlowPort.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PORT);
				String result = ite.getText(object);
				result = FLOW_PORT_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return PORT_PREFIX_PATTERN.matcher(result).replaceFirst("FlowPort");
			}

		}

		if(flowPort_ == null) {
			flowPort_ = (FlowPort)object;
		}

		FlowPort flowPort = (FlowPort)flowPort_;
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

		/**
		 * Notify UML element
		 */
		if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

			/**
			 * Handle Port stereotyped by FlowPort
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Port.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PORT);
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
				 * Handle Port stereotyped by FlowPort
				 */
				if(UMLPackage.Literals.PORT.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PORT);
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
				 * Handle Port stereotyped by FlowPort
				 */
				if(UMLPackage.Literals.PORT.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PORT);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
