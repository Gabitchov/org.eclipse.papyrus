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
package org.eclipse.papyrus.sysml.modelelements.provider;

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
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.ViewPoint;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.modelelements.ViewPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ViewPointItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of viewPoint
	 * 
	 * @generated
	 */
	private static Pattern VIEW_POINT_PREFIX_PATTERN = Pattern.compile("(viewPoint, |<<viewPoint>>|, viewPoint)");

	/**
	 * Get the prefix pattern of CLASS_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern CLASS_PREFIX_PATTERN = Pattern.compile("Class");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ViewPointItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof ViewPoint) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_ClassPropertyDescriptor(object);
				addStakeHoldersPropertyDescriptor(object);
				addPurposePropertyDescriptor(object);
				addConcernsPropertyDescriptor(object);
				addLanguagesPropertyDescriptor(object);
				addMethodsPropertyDescriptor(object);
			}
		}

		/**
		 * Handle Class stereotyped by ViewPoint
		 */
		if(object instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class element = (org.eclipse.uml2.uml.Class)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForclass = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForclass.addAll(propertyDescriptors);
			ViewPoint steApplication = UMLUtil.getStereotypeApplication(element, ViewPoint.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForclass.add(createBase_ClassPropertyDescriptorForClass(steApplication));

				itemPropertyDescriptorsForclass.add(createStakeHoldersPropertyDescriptorForClass(steApplication));

				itemPropertyDescriptorsForclass.add(createPurposePropertyDescriptorForClass(steApplication));

				itemPropertyDescriptorsForclass.add(createConcernsPropertyDescriptorForClass(steApplication));

				itemPropertyDescriptorsForclass.add(createLanguagesPropertyDescriptorForClass(steApplication));

				itemPropertyDescriptorsForclass.add(createMethodsPropertyDescriptorForClass(steApplication));

			}
			return itemPropertyDescriptorsForclass;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_base_Class_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_base_Class_feature", "_UI_ViewPoint_type"), ModelelementsPackage.Literals.VIEW_POINT__BASE_CLASS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Class feature for the UML element Class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ClassPropertyDescriptorForClass(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_base_Class_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_base_Class_feature", "_UI_ViewPoint_type"),

		ModelelementsPackage.Literals.VIEW_POINT__BASE_CLASS, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Stake Holders feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStakeHoldersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_stakeHolders_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_stakeHolders_feature", "_UI_ViewPoint_type"), ModelelementsPackage.Literals.VIEW_POINT__STAKE_HOLDERS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Stake Holders feature for the UML element Class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createStakeHoldersPropertyDescriptorForClass(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_stakeHolders_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_stakeHolders_feature", "_UI_ViewPoint_type"),

		ModelelementsPackage.Literals.VIEW_POINT__STAKE_HOLDERS, true, false, false,

		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Purpose feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPurposePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_purpose_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_purpose_feature", "_UI_ViewPoint_type"), ModelelementsPackage.Literals.VIEW_POINT__PURPOSE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Purpose feature for the UML element Class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createPurposePropertyDescriptorForClass(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_purpose_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_purpose_feature", "_UI_ViewPoint_type"),

		ModelelementsPackage.Literals.VIEW_POINT__PURPOSE, true, false, false,

		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Concerns feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addConcernsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_concerns_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_concerns_feature", "_UI_ViewPoint_type"), ModelelementsPackage.Literals.VIEW_POINT__CONCERNS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Concerns feature for the UML element Class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createConcernsPropertyDescriptorForClass(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_concerns_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_concerns_feature", "_UI_ViewPoint_type"),

		ModelelementsPackage.Literals.VIEW_POINT__CONCERNS, true, false, false,

		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Languages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLanguagesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_languages_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_languages_feature", "_UI_ViewPoint_type"), ModelelementsPackage.Literals.VIEW_POINT__LANGUAGES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Languages feature for the UML element Class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createLanguagesPropertyDescriptorForClass(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_languages_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_languages_feature", "_UI_ViewPoint_type"),

		ModelelementsPackage.Literals.VIEW_POINT__LANGUAGES, true, false, false,

		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Methods feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMethodsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_methods_feature"), getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_methods_feature", "_UI_ViewPoint_type"), ModelelementsPackage.Literals.VIEW_POINT__METHODS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Methods feature for the UML element Class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createMethodsPropertyDescriptorForClass(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ViewPoint_methods_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_methods_feature", "_UI_ViewPoint_type"),

		ModelelementsPackage.Literals.VIEW_POINT__METHODS, true, false, false,

		ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,

		null,

		null));

	}

	/**
	 * This returns ViewPoint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/ViewPoint"));
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
		ViewPoint viewPoint_ = null;

		if(object instanceof org.eclipse.uml2.uml.Class) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Class)object, ViewPoint.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
				String result = ite.getText(object);
				result = VIEW_POINT_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return CLASS_PREFIX_PATTERN.matcher(result).replaceFirst("ViewPoint");
			}

		}

		if(viewPoint_ == null) {
			viewPoint_ = (ViewPoint)object;
		}

		String label = ((ViewPoint)viewPoint_).getPurpose();
		return label == null || label.length() == 0 ? getString("_UI_ViewPoint_type") : getString("_UI_ViewPoint_type") + " " + label;
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

		switch(notification.getFeatureID(ViewPoint.class)) {
		case ModelelementsPackage.VIEW_POINT__STAKE_HOLDERS:
		case ModelelementsPackage.VIEW_POINT__PURPOSE:
		case ModelelementsPackage.VIEW_POINT__CONCERNS:
		case ModelelementsPackage.VIEW_POINT__LANGUAGES:
		case ModelelementsPackage.VIEW_POINT__METHODS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}

		/**
		 * Notify UML element
		 */
		if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

			/**
			 * Handle Class stereotyped by ViewPoint
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Class.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
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
				 * Handle Class stereotyped by ViewPoint
				 */
				if(UMLPackage.Literals.CLASS.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
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
				 * Handle Class stereotyped by ViewPoint
				 */
				if(UMLPackage.Literals.CLASS.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
