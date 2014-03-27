/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusViewpoint;
import org.eclipse.papyrus.infra.viewpoints.configuration.ProfilePropertyDescriptor;
import org.eclipse.papyrus.infra.viewpoints.iso42010.provider.ModelKindItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusViewItemProvider
	extends ModelKindItemProvider
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
	public PapyrusViewItemProvider(AdapterFactory adapterFactory) {
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

			addIconPropertyDescriptor(object);
			addParentPropertyDescriptor(object);
			addProfilesPropertyDescriptor(object);
			addImplementationIDPropertyDescriptor(object);
			addCategoriesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Icon feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusView_icon_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusView_icon_feature", "_UI_PapyrusView_type"),
				 ConfigurationPackage.Literals.PAPYRUS_VIEW__ICON,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusView_parent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusView_parent_feature", "_UI_PapyrusView_type"),
				 ConfigurationPackage.Literals.PAPYRUS_VIEW__PARENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Profiles feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProfilesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ProfilePropertyDescriptor(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusView_profiles_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusView_profiles_feature", "_UI_PapyrusView_type"),
				 ConfigurationPackage.Literals.PAPYRUS_VIEW__PROFILES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)));
	}

	/**
	 * This adds a property descriptor for the Implementation ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementationIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusView_implementationID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusView_implementationID_feature", "_UI_PapyrusView_type"),
				 ConfigurationPackage.Literals.PAPYRUS_VIEW__IMPLEMENTATION_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Categories feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusView_categories_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusView_categories_feature", "_UI_PapyrusView_type"),
				 ConfigurationPackage.Literals.PAPYRUS_VIEW__CATEGORIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConfigurationPackage.Literals.PAPYRUS_VIEW__MODEL_RULES);
			childrenFeatures.add(ConfigurationPackage.Literals.PAPYRUS_VIEW__OWNING_RULES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns PapyrusView.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PapyrusView.png"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getTextFor((PapyrusView) object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected static String getTextFor(PapyrusView view) {
		PapyrusViewpoint vp = (PapyrusViewpoint) view.eContainer();
		if (view.getName() == null)
			return (vp.getName() + " :: <natural> [" + view.getImplementationID() + "]");
		return (vp.getName() + " :: " + view.getName());
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

		switch (notification.getFeatureID(PapyrusView.class)) {
			case ConfigurationPackage.PAPYRUS_VIEW__ICON:
			case ConfigurationPackage.PAPYRUS_VIEW__IMPLEMENTATION_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationPackage.PAPYRUS_VIEW__MODEL_RULES:
			case ConfigurationPackage.PAPYRUS_VIEW__OWNING_RULES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.PAPYRUS_VIEW__MODEL_RULES,
				 ConfigurationFactory.eINSTANCE.createModelRule()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.PAPYRUS_VIEW__OWNING_RULES,
				 ConfigurationFactory.eINSTANCE.createOwningRule()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ConfigurationEditPlugin.INSTANCE;
	}

}
