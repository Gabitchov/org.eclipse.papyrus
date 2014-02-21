/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
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
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FacetReferenceItemProvider
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
	public FacetReferenceItemProvider(AdapterFactory adapterFactory) {
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
			addOrderedPropertyDescriptor(object);
			addUniquePropertyDescriptor(object);
			addLowerBoundPropertyDescriptor(object);
			addUpperBoundPropertyDescriptor(object);
			addManyPropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
			addETypePropertyDescriptor(object);
			addChangeablePropertyDescriptor(object);
			addVolatilePropertyDescriptor(object);
			addTransientPropertyDescriptor(object);
			addDefaultValueLiteralPropertyDescriptor(object);
			addDefaultValuePropertyDescriptor(object);
			addUnsettablePropertyDescriptor(object);
			addDerivedPropertyDescriptor(object);
			addContainmentPropertyDescriptor(object);
			addContainerPropertyDescriptor(object);
			addResolveProxiesPropertyDescriptor(object);
			addEOppositePropertyDescriptor(object);
			addEReferenceTypePropertyDescriptor(object);
			addEKeysPropertyDescriptor(object);
			addDocumentationPropertyDescriptor(object);
			addCategoriesPropertyDescriptor(object);
			addOverridePropertyDescriptor(object);
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
				 getString("_UI_ENamedElement_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ENamedElement_name_feature", "_UI_ENamedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ENAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ordered feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrderedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_ordered_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_ordered_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__ORDERED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unique feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUniquePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_unique_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_unique_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lower Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLowerBoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_lowerBound_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_lowerBound_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Upper Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpperBoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_upperBound_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_upperBound_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Many feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_many_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_many_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__MANY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_required_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_required_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__REQUIRED,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EType feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addETypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ETypedElement_eType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ETypedElement_eType_feature", "_UI_ETypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ETYPED_ELEMENT__ETYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Changeable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChangeablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_changeable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_changeable_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Volatile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVolatilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_volatile_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_volatile_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transient feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransientPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_transient_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_transient_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Value Literal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultValueLiteralPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_defaultValueLiteral_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_defaultValueLiteral_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_defaultValue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_defaultValue_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unsettable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUnsettablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_unsettable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_unsettable_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Derived feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDerivedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EStructuralFeature_derived_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EStructuralFeature_derived_feature", "_UI_EStructuralFeature_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.ESTRUCTURAL_FEATURE__DERIVED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Containment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EReference_containment_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EReference_containment_feature", "_UI_EReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.EREFERENCE__CONTAINMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EReference_container_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EReference_container_feature", "_UI_EReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.EREFERENCE__CONTAINER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resolve Proxies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolveProxiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EReference_resolveProxies_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EReference_resolveProxies_feature", "_UI_EReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EOpposite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEOppositePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EReference_eOpposite_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EReference_eOpposite_feature", "_UI_EReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.EREFERENCE__EOPPOSITE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EReference Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEReferenceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EReference_eReferenceType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EReference_eReferenceType_feature", "_UI_EReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.EREFERENCE__EREFERENCE_TYPE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EKeys feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEKeysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EReference_eKeys_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EReference_eKeys_feature", "_UI_EReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EcorePackage.Literals.EREFERENCE__EKEYS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Documentation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDocumentationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DocumentedElement_documentation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DocumentedElement_documentation_feature", "_UI_DocumentedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EFacetPackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION,
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
				 getString("_UI_FacetElement_categories_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FacetElement_categories_feature", "_UI_FacetElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EFacetPackage.Literals.FACET_ELEMENT__CATEGORIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Override feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverridePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DerivedTypedElement_override_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_DerivedTypedElement_override_feature", "_UI_DerivedTypedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__OVERRIDE,
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
			childrenFeatures.add(EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
			childrenFeatures.add(EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE);
			childrenFeatures.add(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY);
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
	 * This returns FacetReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FacetReference")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FacetReference)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_FacetReference_type") : //$NON-NLS-1$
			getString("_UI_FacetReference_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(FacetReference.class)) {
			case EFacetPackage.FACET_REFERENCE__NAME:
			case EFacetPackage.FACET_REFERENCE__ORDERED:
			case EFacetPackage.FACET_REFERENCE__UNIQUE:
			case EFacetPackage.FACET_REFERENCE__LOWER_BOUND:
			case EFacetPackage.FACET_REFERENCE__UPPER_BOUND:
			case EFacetPackage.FACET_REFERENCE__MANY:
			case EFacetPackage.FACET_REFERENCE__REQUIRED:
			case EFacetPackage.FACET_REFERENCE__CHANGEABLE:
			case EFacetPackage.FACET_REFERENCE__VOLATILE:
			case EFacetPackage.FACET_REFERENCE__TRANSIENT:
			case EFacetPackage.FACET_REFERENCE__DEFAULT_VALUE_LITERAL:
			case EFacetPackage.FACET_REFERENCE__DEFAULT_VALUE:
			case EFacetPackage.FACET_REFERENCE__UNSETTABLE:
			case EFacetPackage.FACET_REFERENCE__DERIVED:
			case EFacetPackage.FACET_REFERENCE__CONTAINMENT:
			case EFacetPackage.FACET_REFERENCE__CONTAINER:
			case EFacetPackage.FACET_REFERENCE__RESOLVE_PROXIES:
			case EFacetPackage.FACET_REFERENCE__DOCUMENTATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EFacetPackage.FACET_REFERENCE__EANNOTATIONS:
			case EFacetPackage.FACET_REFERENCE__EGENERIC_TYPE:
			case EFacetPackage.FACET_REFERENCE__QUERY:
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
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createNavigationQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createIsOneOfQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createStringLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createTrueLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createFalseLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createNullLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createIntegerLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createFloatLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createEObjectLiteralQuery()));

		newChildDescriptors.add
			(createChildParameter
				(EFacetPackage.Literals.DERIVED_TYPED_ELEMENT__QUERY,
				 QueryFactory.eINSTANCE.createOperationCallQuery()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Efacet2EditPlugin.INSTANCE;
	}

}
