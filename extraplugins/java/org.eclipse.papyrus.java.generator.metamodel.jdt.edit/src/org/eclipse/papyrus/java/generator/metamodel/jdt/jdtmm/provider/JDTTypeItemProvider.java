/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/ 

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmFactory;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

import org.eclipse.uml2.common.edit.command.SubsetAddCommand;
import org.eclipse.uml2.common.edit.command.SubsetSupersetReplaceCommand;
import org.eclipse.uml2.common.edit.command.SupersetRemoveCommand;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JDTTypeItemProvider
	extends JDTMemberItemProvider
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
	public JDTTypeItemProvider(AdapterFactory adapterFactory) {
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

			addClassPropertyDescriptor(object);
			addInterfacePropertyDescriptor(object);
			addEnumPropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
			addFinalPropertyDescriptor(object);
			addStaticPropertyDescriptor(object);
			addSuperInterfacesPropertyDescriptor(object);
			addSuperClassPropertyDescriptor(object);
			addSuperInterfaceNamesPropertyDescriptor(object);
			addSuperClassNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_class_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_class_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_interface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_interface_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__INTERFACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enum feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_enum_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_enum_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__ENUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_abstract_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Final feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_final_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_final_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__FINAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Static feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_static_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_static_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__STATIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_superInterfaces_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_superInterfaces_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__SUPER_INTERFACES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_superClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_superClass_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__SUPER_CLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Interface Names feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperInterfaceNamesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_superInterfaceNames_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_superInterfaceNames_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__SUPER_INTERFACE_NAMES,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Super Class Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperClassNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JDTType_superClassName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JDTType_superClassName_feature", "_UI_JDTType_type"),
				 JdtmmPackage.Literals.JDT_TYPE__SUPER_CLASS_NAME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(JdtmmPackage.Literals.JDT_TYPE__METHODS);
			childrenFeatures.add(JdtmmPackage.Literals.JDT_TYPE__TYPES);
			childrenFeatures.add(JdtmmPackage.Literals.JDT_TYPE__FIELDS);
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
		String label = ((JDTType)object).getElementName();
		return label == null || label.length() == 0 ?
			getString("_UI_JDTType_type") :
			getString("_UI_JDTType_type") + " " + label;
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

		switch (notification.getFeatureID(JDTType.class)) {
			case JdtmmPackage.JDT_TYPE__CLASS:
			case JdtmmPackage.JDT_TYPE__INTERFACE:
			case JdtmmPackage.JDT_TYPE__ENUM:
			case JdtmmPackage.JDT_TYPE__ABSTRACT:
			case JdtmmPackage.JDT_TYPE__FINAL:
			case JdtmmPackage.JDT_TYPE__STATIC:
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACE_NAMES:
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case JdtmmPackage.JDT_TYPE__METHODS:
			case JdtmmPackage.JDT_TYPE__TYPES:
			case JdtmmPackage.JDT_TYPE__FIELDS:
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
				(JdtmmPackage.Literals.JDT_TYPE__METHODS,
				 JdtmmFactory.eINSTANCE.createJDTMethod()));

		newChildDescriptors.add
			(createChildParameter
				(JdtmmPackage.Literals.JDT_TYPE__TYPES,
				 JdtmmFactory.eINSTANCE.createJDTClass()));

		newChildDescriptors.add
			(createChildParameter
				(JdtmmPackage.Literals.JDT_TYPE__TYPES,
				 JdtmmFactory.eINSTANCE.createJDTInterface()));

		newChildDescriptors.add
			(createChildParameter
				(JdtmmPackage.Literals.JDT_TYPE__TYPES,
				 JdtmmFactory.eINSTANCE.createJDTEnum()));

		newChildDescriptors.add
			(createChildParameter
				(JdtmmPackage.Literals.JDT_TYPE__FIELDS,
				 JdtmmFactory.eINSTANCE.createJDTField()));
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection, int index) {
		if (feature == JdtmmPackage.Literals.JDT_TYPE__METHODS) {
			return new SubsetAddCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_PARENT__CHILDREN}, collection, index);
		}
		if (feature == JdtmmPackage.Literals.JDT_TYPE__TYPES) {
			return new SubsetAddCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_PARENT__CHILDREN}, collection, index);
		}
		if (feature == JdtmmPackage.Literals.JDT_TYPE__FIELDS) {
			return new SubsetAddCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_PARENT__CHILDREN}, collection, index);
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection) {
		if (feature == JdtmmPackage.Literals.JDT_PARENT__CHILDREN) {
			return new SupersetRemoveCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_TYPE__METHODS, JdtmmPackage.Literals.JDT_TYPE__TYPES, JdtmmPackage.Literals.JDT_TYPE__FIELDS}, collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createReplaceCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.util.Collection)
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createReplaceCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, EObject value, Collection<?> collection) {
		if (feature == JdtmmPackage.Literals.JDT_TYPE__METHODS) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_PARENT__CHILDREN}, null, value, collection);
		}
		if (feature == JdtmmPackage.Literals.JDT_TYPE__TYPES) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_PARENT__CHILDREN}, null, value, collection);
		}
		if (feature == JdtmmPackage.Literals.JDT_TYPE__FIELDS) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_PARENT__CHILDREN}, null, value, collection);
		}
		if (feature == JdtmmPackage.Literals.JDT_PARENT__CHILDREN) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature, null, new EStructuralFeature[] {JdtmmPackage.Literals.JDT_TYPE__METHODS, JdtmmPackage.Literals.JDT_TYPE__TYPES, JdtmmPackage.Literals.JDT_TYPE__FIELDS}, value, collection);
		}
		return super.createReplaceCommand(domain, owner, feature, value, collection);
	}

}
