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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.portandflows.ItemFlow;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.portandflows.ItemFlow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ItemFlowItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of itemFlow
	 * 
	 * @generated
	 */
	private static Pattern ITEM_FLOW_PREFIX_PATTERN = Pattern.compile("(itemFlow, |<<itemFlow>>|, itemFlow)");

	/**
	 * Get the prefix pattern of INFORMATION_FLOW_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern INFORMATION_FLOW_PREFIX_PATTERN = Pattern.compile("Information Flow");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ItemFlowItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof ItemFlow) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_InformationFlowPropertyDescriptor(object);
				addItemPropertyPropertyDescriptor(object);
			}
		}

		/**
		 * Handle InformationFlow stereotyped by ItemFlow
		 */
		if(object instanceof org.eclipse.uml2.uml.InformationFlow) {
			org.eclipse.uml2.uml.InformationFlow element = (org.eclipse.uml2.uml.InformationFlow)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForinformationFlow = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INFORMATION_FLOW);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForinformationFlow.addAll(propertyDescriptors);
			ItemFlow steApplication = UMLUtil.getStereotypeApplication(element, ItemFlow.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForinformationFlow.add(createBase_InformationFlowPropertyDescriptorForInformationFlow(steApplication));

				itemPropertyDescriptorsForinformationFlow.add(createItemPropertyPropertyDescriptorForInformationFlow(steApplication));

			}
			return itemPropertyDescriptorsForinformationFlow;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Information Flow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_InformationFlowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ItemFlow_base_InformationFlow_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ItemFlow_base_InformationFlow_feature", "_UI_ItemFlow_type"), PortandflowsPackage.Literals.ITEM_FLOW__BASE_INFORMATION_FLOW, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Information Flow feature for the UML element InformationFlow.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_InformationFlowPropertyDescriptorForInformationFlow(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ItemFlow_base_InformationFlow_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ItemFlow_base_InformationFlow_feature", "_UI_ItemFlow_type"),

		PortandflowsPackage.Literals.ITEM_FLOW__BASE_INFORMATION_FLOW, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Item Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addItemPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ItemFlow_itemProperty_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ItemFlow_itemProperty_feature", "_UI_ItemFlow_type"), PortandflowsPackage.Literals.ITEM_FLOW__ITEM_PROPERTY, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Item Property feature for the UML element InformationFlow.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createItemPropertyPropertyDescriptorForInformationFlow(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ItemFlow_itemProperty_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ItemFlow_itemProperty_feature", "_UI_ItemFlow_type"),

		PortandflowsPackage.Literals.ITEM_FLOW__ITEM_PROPERTY, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns ItemFlow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/ItemFlow"));
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
		ItemFlow itemFlow_ = null;

		if(object instanceof org.eclipse.uml2.uml.InformationFlow) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.InformationFlow)object, ItemFlow.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INFORMATION_FLOW);
				String result = ite.getText(object);
				result = ITEM_FLOW_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return INFORMATION_FLOW_PREFIX_PATTERN.matcher(result).replaceFirst("ItemFlow");
			}

		}

		if(itemFlow_ == null) {
			itemFlow_ = (ItemFlow)object;
		}

		return getString("_UI_ItemFlow_type");
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
			 * Handle InformationFlow stereotyped by ItemFlow
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.InformationFlow.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INFORMATION_FLOW);
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
				 * Handle InformationFlow stereotyped by ItemFlow
				 */
				if(UMLPackage.Literals.INFORMATION_FLOW.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INFORMATION_FLOW);
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
				 * Handle InformationFlow stereotyped by ItemFlow
				 */
				if(UMLPackage.Literals.INFORMATION_FLOW.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.INFORMATION_FLOW);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
