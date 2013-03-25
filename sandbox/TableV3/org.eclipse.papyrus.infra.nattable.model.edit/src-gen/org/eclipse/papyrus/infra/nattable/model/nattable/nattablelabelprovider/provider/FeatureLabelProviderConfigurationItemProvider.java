/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EModelElementItemProvider;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.provider.NattableEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureLabelProviderConfigurationItemProvider
	extends EModelElementItemProvider
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
	public FeatureLabelProviderConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addLabelProviderContextPropertyDescriptor(object);
			addDisplayIconPropertyDescriptor(object);
			addDisplayTextPropertyDescriptor(object);
			addDisplayIsDerivedPropertyDescriptor(object);
			addDisplayTypePropertyDescriptor(object);
			addDisplayMultiplicityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Label Provider Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelProviderContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ILabelConfiguration_labelProviderContext_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ILabelConfiguration_labelProviderContext_feature", "_UI_ILabelConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablelabelproviderPackage.Literals.ILABEL_CONFIGURATION__LABEL_PROVIDER_CONTEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Icon feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayIconPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EObjectLabelProviderConfiguration_displayIcon_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EObjectLabelProviderConfiguration_displayIcon_feature", "_UI_EObjectLabelProviderConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablelabelproviderPackage.Literals.EOBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EObjectLabelProviderConfiguration_displayText_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EObjectLabelProviderConfiguration_displayText_feature", "_UI_EObjectLabelProviderConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablelabelproviderPackage.Literals.EOBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Is Derived feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayIsDerivedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureLabelProviderConfiguration_displayIsDerived_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureLabelProviderConfiguration_displayIsDerived_feature", "_UI_FeatureLabelProviderConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablelabelproviderPackage.Literals.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureLabelProviderConfiguration_displayType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureLabelProviderConfiguration_displayType_feature", "_UI_FeatureLabelProviderConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablelabelproviderPackage.Literals.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Multiplicity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureLabelProviderConfiguration_displayMultiplicity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureLabelProviderConfiguration_displayMultiplicity_feature", "_UI_FeatureLabelProviderConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablelabelproviderPackage.Literals.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns FeatureLabelProviderConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FeatureLabelProviderConfiguration")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FeatureLabelProviderConfiguration)object).getLabelProviderContext();
		return label == null || label.length() == 0 ?
			getString("_UI_FeatureLabelProviderConfiguration_type") : //$NON-NLS-1$
			getString("_UI_FeatureLabelProviderConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(FeatureLabelProviderConfiguration.class)) {
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__LABEL_PROVIDER_CONTEXT:
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TEXT:
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED:
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE:
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY:
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
		return NattableEditPlugin.INSTANCE;
	}

}
