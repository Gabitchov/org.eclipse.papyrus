/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RegistryIdDescItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryIdDescItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addIsUniquePropertyDescriptor(object);
			addSetsPropertyDescriptor(object);
			addExtendsPropertyDescriptor(object);
			addParentsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegistryIdDesc_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegistryIdDesc_name_feature", "_UI_RegistryIdDesc_type"),
				 ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegistryIdDesc_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegistryIdDesc_description_feature", "_UI_RegistryIdDesc_type"),
				 ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Unique feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsUniquePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegistryIdDesc_isUnique_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegistryIdDesc_isUnique_feature", "_UI_RegistryIdDesc_type"),
				 ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC__IS_UNIQUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegistryIdDesc_sets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegistryIdDesc_sets_feature", "_UI_RegistryIdDesc_type"),
				 ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC__SETS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extends feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegistryIdDesc_extends_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegistryIdDesc_extends_feature", "_UI_RegistryIdDesc_type"),
				 ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC__EXTENDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parents feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegistryIdDesc_parents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegistryIdDesc_parents_feature", "_UI_RegistryIdDesc_type"),
				 ServicedescriptorswithidPackage.Literals.REGISTRY_ID_DESC__PARENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns RegistryIdDesc.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RegistryIdDesc"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RegistryIdDesc)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_RegistryIdDesc_type") :
			getString("_UI_RegistryIdDesc_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(RegistryIdDesc.class)) {
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__NAME:
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__DESCRIPTION:
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__IS_UNIQUE:
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__SETS:
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__EXTENDS:
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC__PARENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ServicedescriptorswithidEditPlugin.INSTANCE;
	}

}
