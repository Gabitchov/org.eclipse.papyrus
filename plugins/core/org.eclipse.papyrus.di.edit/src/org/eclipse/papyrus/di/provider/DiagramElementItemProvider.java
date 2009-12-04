/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.provider;


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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.di.DiFactory;
import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.DiagramElement;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.di.DiagramElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramElementItemProvider
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
	 * 
	 * @generated
	 */
	public DiagramElementItemProvider(AdapterFactory adapterFactory) {
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
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIsVisiblePropertyDescriptor(object);
			addReferencePropertyDescriptor(object);
			addFontFamilyPropertyDescriptor(object);
			addFontSizePropertyDescriptor(object);
			addLineStylePropertyDescriptor(object);
			addLineThicknessPropertyDescriptor(object);
			addFontColorPropertyDescriptor(object);
			addForegroundColorPropertyDescriptor(object);
			addBackgroundColorPropertyDescriptor(object);
			addBorderColorPropertyDescriptor(object);
			addTranslucentPropertyDescriptor(object);
			addSemanticParentPropertyDescriptor(object);
			addSemanticChildPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Visible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addIsVisiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_isVisible_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_isVisible_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__IS_VISIBLE,
				true,
				false,
				false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_reference_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_reference_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__REFERENCE,
				true,
				false,
				true,
				null,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Font Family feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFontFamilyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_fontFamily_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_fontFamily_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__FONT_FAMILY,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Font Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFontSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_fontSize_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_fontSize_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__FONT_SIZE,
				true,
				false,
				false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Line Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLineStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_lineStyle_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_lineStyle_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__LINE_STYLE,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Line Thickness feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLineThicknessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_lineThickness_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_lineThickness_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__LINE_THICKNESS,
				true,
				false,
				false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Font Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFontColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_fontColor_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_fontColor_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__FONT_COLOR,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Foreground Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addForegroundColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_foregroundColor_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_foregroundColor_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__FOREGROUND_COLOR,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Background Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBackgroundColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_backgroundColor_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_backgroundColor_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__BACKGROUND_COLOR,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Border Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBorderColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_borderColor_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_borderColor_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__BORDER_COLOR,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Translucent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTranslucentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_translucent_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_translucent_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__TRANSLUCENT,
				true,
				false,
				false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Semantic Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSemanticParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_semanticParent_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_semanticParent_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__SEMANTIC_PARENT,
				true,
				false,
				true,
				null,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the Semantic Child feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSemanticChildPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DiagramElement_semanticChild_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiagramElement_semanticChild_feature", "_UI_DiagramElement_type"),
				DiPackage.Literals.DIAGRAM_ELEMENT__SEMANTIC_CHILD,
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
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if(childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DiPackage.Literals.DIAGRAM_ELEMENT__PROPERTY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DiagramElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DiagramElement"));
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
		DiagramElement diagramElement = (DiagramElement)object;
		return getString("_UI_DiagramElement_type") + " " + diagramElement.isIsVisible();
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

		switch(notification.getFeatureID(DiagramElement.class)) {
		case DiPackage.DIAGRAM_ELEMENT__IS_VISIBLE:
		case DiPackage.DIAGRAM_ELEMENT__FONT_FAMILY:
		case DiPackage.DIAGRAM_ELEMENT__FONT_SIZE:
		case DiPackage.DIAGRAM_ELEMENT__LINE_STYLE:
		case DiPackage.DIAGRAM_ELEMENT__LINE_THICKNESS:
		case DiPackage.DIAGRAM_ELEMENT__FONT_COLOR:
		case DiPackage.DIAGRAM_ELEMENT__FOREGROUND_COLOR:
		case DiPackage.DIAGRAM_ELEMENT__BACKGROUND_COLOR:
		case DiPackage.DIAGRAM_ELEMENT__BORDER_COLOR:
		case DiPackage.DIAGRAM_ELEMENT__TRANSLUCENT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case DiPackage.DIAGRAM_ELEMENT__PROPERTY:
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
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.DIAGRAM_ELEMENT__PROPERTY,
				DiFactory.eINSTANCE.createProperty()));
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
		return DiEditPlugin.INSTANCE;
	}

}
