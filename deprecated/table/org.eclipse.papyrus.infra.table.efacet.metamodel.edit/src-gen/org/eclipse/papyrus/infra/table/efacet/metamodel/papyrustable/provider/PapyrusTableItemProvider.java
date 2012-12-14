/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.provider;


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


import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusTableItemProvider
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
	public PapyrusTableItemProvider(AdapterFactory adapterFactory) {
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
			addTypePropertyDescriptor(object);
			addTablePropertyDescriptor(object);
			addFillingModePropertyDescriptor(object);
			addFillModePropertyDescriptor(object);
			addContextFeaturePropertyDescriptor(object);
			addQueriesPropertyDescriptor(object);
			addUsingUserPropertyDescriptor(object);
			addUsingContextFeaturePropertyDescriptor(object);
			addUsingQueriesPropertyDescriptor(object);
			addPastedElementIdPropertyDescriptor(object);
			addPasteElementContainementFeaturePropertyDescriptor(object);
			addPapyrusTableConfigurationPropertyDescriptor(object);
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
				 getString("_UI_PapyrusTable_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_name_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_type_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_type_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Table feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_table_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_table_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__TABLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Filling Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFillingModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_fillingMode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_fillingMode_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__FILLING_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fill Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFillModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_fillMode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_fillMode_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__FILL_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Context Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContextFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_contextFeature_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_contextFeature_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__CONTEXT_FEATURE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Queries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_queries_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_queries_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__QUERIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Using User feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsingUserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_usingUser_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_usingUser_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__USING_USER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Using Context Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsingContextFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_usingContextFeature_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_usingContextFeature_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__USING_CONTEXT_FEATURE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Using Queries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsingQueriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_usingQueries_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_usingQueries_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__USING_QUERIES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pasted Element Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPastedElementIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_pastedElementId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_pastedElementId_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__PASTED_ELEMENT_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Paste Element Containement Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasteElementContainementFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_pasteElementContainementFeature_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_pasteElementContainementFeature_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__PASTE_ELEMENT_CONTAINEMENT_FEATURE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Papyrus Table Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPapyrusTableConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PapyrusTable_papyrusTableConfiguration_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PapyrusTable_papyrusTableConfiguration_feature", "_UI_PapyrusTable_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 PapyrustablePackage.Literals.PAPYRUS_TABLE__PAPYRUS_TABLE_CONFIGURATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns PapyrusTable.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PapyrusTable")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PapyrusTable)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_PapyrusTable_type") : //$NON-NLS-1$
			getString("_UI_PapyrusTable_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(PapyrusTable.class)) {
			case PapyrustablePackage.PAPYRUS_TABLE__NAME:
			case PapyrustablePackage.PAPYRUS_TABLE__TYPE:
			case PapyrustablePackage.PAPYRUS_TABLE__FILLING_MODE:
			case PapyrustablePackage.PAPYRUS_TABLE__FILL_MODE:
			case PapyrustablePackage.PAPYRUS_TABLE__USING_USER:
			case PapyrustablePackage.PAPYRUS_TABLE__USING_CONTEXT_FEATURE:
			case PapyrustablePackage.PAPYRUS_TABLE__USING_QUERIES:
			case PapyrustablePackage.PAPYRUS_TABLE__PASTED_ELEMENT_ID:
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
		return PapyrustableEditPlugin.INSTANCE;
	}

}
