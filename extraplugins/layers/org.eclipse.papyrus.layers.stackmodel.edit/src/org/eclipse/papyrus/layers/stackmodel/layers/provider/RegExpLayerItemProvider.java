/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RegExpLayerItemProvider
	extends AbstractLayerItemProvider
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
	public RegExpLayerItemProvider(AdapterFactory adapterFactory) {
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

			addExprPropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addIsDomainChangedEventDependantPropertyDescriptor(object);
			addDomainChangedEventLevelPropertyDescriptor(object);
			addIsDiagramChangedEventDependantPropertyDescriptor(object);
			addDiagramChangedEventLevelPropertyDescriptor(object);
			addExpressionContextObjectTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Expr feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExprPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_expr_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_expr_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__EXPR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_language_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_language_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Domain Changed Event Dependant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDomainChangedEventDependantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_isDomainChangedEventDependant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_isDomainChangedEventDependant_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Domain Changed Event Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainChangedEventLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_domainChangedEventLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_domainChangedEventLevel_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Diagram Changed Event Dependant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDiagramChangedEventDependantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_isDiagramChangedEventDependant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_isDiagramChangedEventDependant_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Diagram Changed Event Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiagramChangedEventLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_diagramChangedEventLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_diagramChangedEventLevel_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expression Context Object Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpressionContextObjectTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RegExpLayer_expressionContextObjectType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RegExpLayer_expressionContextObjectType_feature", "_UI_RegExpLayer_type"),
				 LayersPackage.Literals.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns RegExpLayer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RegExpLayer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RegExpLayer)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_RegExpLayer_type") :
			getString("_UI_RegExpLayer_type") + " " + label;
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

		switch (notification.getFeatureID(RegExpLayer.class)) {
			case LayersPackage.REG_EXP_LAYER__EXPR:
			case LayersPackage.REG_EXP_LAYER__LANGUAGE:
			case LayersPackage.REG_EXP_LAYER__IS_DOMAIN_CHANGED_EVENT_DEPENDANT:
			case LayersPackage.REG_EXP_LAYER__DOMAIN_CHANGED_EVENT_LEVEL:
			case LayersPackage.REG_EXP_LAYER__IS_DIAGRAM_CHANGED_EVENT_DEPENDANT:
			case LayersPackage.REG_EXP_LAYER__DIAGRAM_CHANGED_EVENT_LEVEL:
			case LayersPackage.REG_EXP_LAYER__EXPRESSION_CONTEXT_OBJECT_TYPE:
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

}
