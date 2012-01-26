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
package org.eclipse.papyrus.sysml.allocations.provider;

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
import org.eclipse.papyrus.sysml.allocations.Allocated;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.allocations.Allocated} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class AllocatedItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of allocated
	 * 
	 * @generated
	 */
	private static Pattern ALLOCATED_PREFIX_PATTERN = Pattern.compile("(allocated, |<<allocated>>|, allocated)");

	/**
	 * Get the prefix pattern of NAMED_ELEMENT_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern NAMED_ELEMENT_PREFIX_PATTERN = Pattern.compile("Named Element");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AllocatedItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Allocated) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_NamedElementPropertyDescriptor(object);
				addAllocatedFromPropertyDescriptor(object);
				addAllocatedToPropertyDescriptor(object);
			}
		}

		/**
		 * Handle NamedElement stereotyped by Allocated
		 */
		if(object instanceof org.eclipse.uml2.uml.NamedElement) {
			org.eclipse.uml2.uml.NamedElement element = (org.eclipse.uml2.uml.NamedElement)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsFornamedElement = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.NAMED_ELEMENT);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsFornamedElement.addAll(propertyDescriptors);
			Allocated steApplication = UMLUtil.getStereotypeApplication(element, Allocated.class);
			if(steApplication != null) {

				itemPropertyDescriptorsFornamedElement.add(createBase_NamedElementPropertyDescriptorForNamedElement(steApplication));

				itemPropertyDescriptorsFornamedElement.add(createAllocatedFromPropertyDescriptorForNamedElement(steApplication));

				itemPropertyDescriptorsFornamedElement.add(createAllocatedToPropertyDescriptorForNamedElement(steApplication));

			}
			return itemPropertyDescriptorsFornamedElement;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Named Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_NamedElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Allocated_base_NamedElement_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Allocated_base_NamedElement_feature", "_UI_Allocated_type"), AllocationsPackage.Literals.ALLOCATED__BASE_NAMED_ELEMENT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Named Element feature for the UML element NamedElement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_NamedElementPropertyDescriptorForNamedElement(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Allocated_base_NamedElement_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Allocated_base_NamedElement_feature", "_UI_Allocated_type"),

		AllocationsPackage.Literals.ALLOCATED__BASE_NAMED_ELEMENT, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Allocated From feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAllocatedFromPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Allocated_allocatedFrom_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Allocated_allocatedFrom_feature", "_UI_Allocated_type"), AllocationsPackage.Literals.ALLOCATED__ALLOCATED_FROM, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Allocated From feature for the UML element NamedElement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createAllocatedFromPropertyDescriptorForNamedElement(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Allocated_allocatedFrom_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Allocated_allocatedFrom_feature", "_UI_Allocated_type"),

		AllocationsPackage.Literals.ALLOCATED__ALLOCATED_FROM, false, false, false,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Allocated To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAllocatedToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Allocated_allocatedTo_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Allocated_allocatedTo_feature", "_UI_Allocated_type"), AllocationsPackage.Literals.ALLOCATED__ALLOCATED_TO, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Allocated To feature for the UML element NamedElement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createAllocatedToPropertyDescriptorForNamedElement(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Allocated_allocatedTo_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Allocated_allocatedTo_feature", "_UI_Allocated_type"),

		AllocationsPackage.Literals.ALLOCATED__ALLOCATED_TO, false, false, false,

		null,

		null,

		null));

	}

	/**
	 * This returns Allocated.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Allocated"));
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
		Allocated allocated_ = null;

		if(object instanceof org.eclipse.uml2.uml.NamedElement) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.NamedElement)object, Allocated.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.NAMED_ELEMENT);
				String result = ite.getText(object);
				result = ALLOCATED_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return NAMED_ELEMENT_PREFIX_PATTERN.matcher(result).replaceFirst("Allocated");
			}

		}

		if(allocated_ == null) {
			allocated_ = (Allocated)object;
		}

		return getString("_UI_Allocated_type");
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
			 * Handle NamedElement stereotyped by Allocated
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.NamedElement.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.NAMED_ELEMENT);
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
				 * Handle NamedElement stereotyped by Allocated
				 */
				if(UMLPackage.Literals.NAMED_ELEMENT.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.NAMED_ELEMENT);
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
				 * Handle NamedElement stereotyped by Allocated
				 */
				if(UMLPackage.Literals.NAMED_ELEMENT.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.NAMED_ELEMENT);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
