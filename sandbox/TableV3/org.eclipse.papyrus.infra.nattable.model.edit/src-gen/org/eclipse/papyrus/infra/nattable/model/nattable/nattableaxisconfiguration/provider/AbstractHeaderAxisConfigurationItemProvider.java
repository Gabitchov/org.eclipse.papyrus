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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

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

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderFactory;

import org.eclipse.papyrus.infra.nattable.model.nattable.provider.NattableEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractHeaderAxisConfigurationItemProvider
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
	public AbstractHeaderAxisConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addIndexStylePropertyDescriptor(object);
			addDisplayLabelPropertyDescriptor(object);
			addDisplayFilterPropertyDescriptor(object);
			addDisplayIndexPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Index Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractHeaderAxisConfiguration_indexStyle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractHeaderAxisConfiguration_indexStyle_feature", "_UI_AbstractHeaderAxisConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractHeaderAxisConfiguration_displayLabel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractHeaderAxisConfiguration_displayLabel_feature", "_UI_AbstractHeaderAxisConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Filter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayFilterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractHeaderAxisConfiguration_displayFilter_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractHeaderAxisConfiguration_displayFilter_feature", "_UI_AbstractHeaderAxisConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Display Index feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayIndexPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractHeaderAxisConfiguration_displayIndex_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractHeaderAxisConfiguration_displayIndex_feature", "_UI_AbstractHeaderAxisConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS);
			childrenFeatures.add(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		AxisIndexStyle labelValue = ((AbstractHeaderAxisConfiguration)object).getIndexStyle();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractHeaderAxisConfiguration_type") : //$NON-NLS-1$
			getString("_UI_AbstractHeaderAxisConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(AbstractHeaderAxisConfiguration.class)) {
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE:
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL:
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER:
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS:
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS:
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
				(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS,
				 NattablelabelproviderFactory.eINSTANCE.createObjectLabelProviderConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS,
				 NattablelabelproviderFactory.eINSTANCE.createFeatureLabelProviderConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS,
				 NattableaxisconfigurationFactory.eINSTANCE.createFeatureAxisConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS,
				 NattableaxisconfigurationFactory.eINSTANCE.createEStructuralFeatureValueFillingConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS,
				 NattableaxisconfigurationFactory.eINSTANCE.createIPasteConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS,
				 NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration()));
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
