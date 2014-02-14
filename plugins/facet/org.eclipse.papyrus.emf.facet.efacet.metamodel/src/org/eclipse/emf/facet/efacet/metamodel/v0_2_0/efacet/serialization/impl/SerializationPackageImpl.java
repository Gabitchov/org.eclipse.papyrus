/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.ExtensiblePackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SerializationPackageImpl extends EPackageImpl implements SerializationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractReferenceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiValuedContainmentReferenceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiValuedReferenceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleValuedAttributeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedEObjectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleValuedContainmentReferenceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleValuedReferenceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiValuedAttributeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractAttributeInstanceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SerializationPackageImpl() {
		super(eNS_URI, SerializationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SerializationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SerializationPackage init() {
		if (isInited) return (SerializationPackage)EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI);

		// Obtain or create and register package
		SerializationPackageImpl theSerializationPackage = (SerializationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SerializationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SerializationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EFacetPackageImpl theEFacetPackage = (EFacetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI) instanceof EFacetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI) : EFacetPackage.eINSTANCE);
		ExtensiblePackageImpl theExtensiblePackage = (ExtensiblePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) instanceof ExtensiblePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) : ExtensiblePackage.eINSTANCE);
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);
		RuntimePackageImpl theRuntimePackage = (RuntimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI) instanceof RuntimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI) : RuntimePackage.eINSTANCE);

		// Create package meta-data objects
		theSerializationPackage.createPackageContents();
		theEFacetPackage.createPackageContents();
		theExtensiblePackage.createPackageContents();
		theQueryPackage.createPackageContents();
		theRuntimePackage.createPackageContents();

		// Initialize created meta-data
		theSerializationPackage.initializePackageContents();
		theEFacetPackage.initializePackageContents();
		theExtensiblePackage.initializePackageContents();
		theQueryPackage.initializePackageContents();
		theRuntimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSerializationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SerializationPackage.eNS_URI, theSerializationPackage);
		return theSerializationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractReferenceInstance() {
		return abstractReferenceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractReferenceInstance_EReference() {
		return (EReference)abstractReferenceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiValuedContainmentReferenceInstance() {
		return multiValuedContainmentReferenceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiValuedContainmentReferenceInstance_OwnedElements() {
		return (EReference)multiValuedContainmentReferenceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiValuedReferenceInstance() {
		return multiValuedReferenceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiValuedReferenceInstance_ReferencedElements() {
		return (EReference)multiValuedReferenceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleValuedAttributeInstance() {
		return singleValuedAttributeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleValuedAttributeInstance_Value() {
		return (EAttribute)singleValuedAttributeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedEObjectReference() {
		return extendedEObjectReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedEObjectReference_ExtendedEObject() {
		return (EReference)extendedEObjectReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedEObjectReference_AttributeInstances() {
		return (EReference)extendedEObjectReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedEObjectReference_ReferenceInstances() {
		return (EReference)extendedEObjectReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleValuedContainmentReferenceInstance() {
		return singleValuedContainmentReferenceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleValuedContainmentReferenceInstance_OwnedElement() {
		return (EReference)singleValuedContainmentReferenceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleValuedReferenceInstance() {
		return singleValuedReferenceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleValuedReferenceInstance_ReferencedElement() {
		return (EReference)singleValuedReferenceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiValuedAttributeInstance() {
		return multiValuedAttributeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiValuedAttributeInstance_Values() {
		return (EAttribute)multiValuedAttributeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAttributeInstance() {
		return abstractAttributeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAttributeInstance_EAttribute() {
		return (EReference)abstractAttributeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializationFactory getSerializationFactory() {
		return (SerializationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractReferenceInstanceEClass = createEClass(ABSTRACT_REFERENCE_INSTANCE);
		createEReference(abstractReferenceInstanceEClass, ABSTRACT_REFERENCE_INSTANCE__EREFERENCE);

		multiValuedContainmentReferenceInstanceEClass = createEClass(MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE);
		createEReference(multiValuedContainmentReferenceInstanceEClass, MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS);

		multiValuedReferenceInstanceEClass = createEClass(MULTI_VALUED_REFERENCE_INSTANCE);
		createEReference(multiValuedReferenceInstanceEClass, MULTI_VALUED_REFERENCE_INSTANCE__REFERENCED_ELEMENTS);

		singleValuedAttributeInstanceEClass = createEClass(SINGLE_VALUED_ATTRIBUTE_INSTANCE);
		createEAttribute(singleValuedAttributeInstanceEClass, SINGLE_VALUED_ATTRIBUTE_INSTANCE__VALUE);

		extendedEObjectReferenceEClass = createEClass(EXTENDED_EOBJECT_REFERENCE);
		createEReference(extendedEObjectReferenceEClass, EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT);
		createEReference(extendedEObjectReferenceEClass, EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES);
		createEReference(extendedEObjectReferenceEClass, EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES);

		singleValuedContainmentReferenceInstanceEClass = createEClass(SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE);
		createEReference(singleValuedContainmentReferenceInstanceEClass, SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENT);

		singleValuedReferenceInstanceEClass = createEClass(SINGLE_VALUED_REFERENCE_INSTANCE);
		createEReference(singleValuedReferenceInstanceEClass, SINGLE_VALUED_REFERENCE_INSTANCE__REFERENCED_ELEMENT);

		multiValuedAttributeInstanceEClass = createEClass(MULTI_VALUED_ATTRIBUTE_INSTANCE);
		createEAttribute(multiValuedAttributeInstanceEClass, MULTI_VALUED_ATTRIBUTE_INSTANCE__VALUES);

		abstractAttributeInstanceEClass = createEClass(ABSTRACT_ATTRIBUTE_INSTANCE);
		createEReference(abstractAttributeInstanceEClass, ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		multiValuedContainmentReferenceInstanceEClass.getESuperTypes().add(this.getAbstractReferenceInstance());
		multiValuedReferenceInstanceEClass.getESuperTypes().add(this.getAbstractReferenceInstance());
		singleValuedAttributeInstanceEClass.getESuperTypes().add(this.getAbstractAttributeInstance());
		singleValuedContainmentReferenceInstanceEClass.getESuperTypes().add(this.getAbstractReferenceInstance());
		singleValuedReferenceInstanceEClass.getESuperTypes().add(this.getAbstractReferenceInstance());
		multiValuedAttributeInstanceEClass.getESuperTypes().add(this.getAbstractAttributeInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractReferenceInstanceEClass, AbstractReferenceInstance.class, "AbstractReferenceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractReferenceInstance_EReference(), ecorePackage.getEReference(), null, "eReference", null, 1, 1, AbstractReferenceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiValuedContainmentReferenceInstanceEClass, MultiValuedContainmentReferenceInstance.class, "MultiValuedContainmentReferenceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMultiValuedContainmentReferenceInstance_OwnedElements(), ecorePackage.getEObject(), null, "ownedElements", null, 0, -1, MultiValuedContainmentReferenceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiValuedReferenceInstanceEClass, MultiValuedReferenceInstance.class, "MultiValuedReferenceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMultiValuedReferenceInstance_ReferencedElements(), ecorePackage.getEObject(), null, "referencedElements", null, 0, -1, MultiValuedReferenceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(singleValuedAttributeInstanceEClass, SingleValuedAttributeInstance.class, "SingleValuedAttributeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSingleValuedAttributeInstance_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, SingleValuedAttributeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(extendedEObjectReferenceEClass, ExtendedEObjectReference.class, "ExtendedEObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExtendedEObjectReference_ExtendedEObject(), ecorePackage.getEObject(), null, "extendedEObject", null, 1, 1, ExtendedEObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExtendedEObjectReference_AttributeInstances(), this.getAbstractAttributeInstance(), null, "attributeInstances", null, 0, -1, ExtendedEObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExtendedEObjectReference_ReferenceInstances(), this.getAbstractReferenceInstance(), null, "referenceInstances", null, 0, -1, ExtendedEObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(singleValuedContainmentReferenceInstanceEClass, SingleValuedContainmentReferenceInstance.class, "SingleValuedContainmentReferenceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSingleValuedContainmentReferenceInstance_OwnedElement(), ecorePackage.getEObject(), null, "ownedElement", null, 0, 1, SingleValuedContainmentReferenceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(singleValuedReferenceInstanceEClass, SingleValuedReferenceInstance.class, "SingleValuedReferenceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSingleValuedReferenceInstance_ReferencedElement(), ecorePackage.getEObject(), null, "referencedElement", null, 0, 1, SingleValuedReferenceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiValuedAttributeInstanceEClass, MultiValuedAttributeInstance.class, "MultiValuedAttributeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMultiValuedAttributeInstance_Values(), ecorePackage.getEJavaObject(), "values", null, 0, -1, MultiValuedAttributeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractAttributeInstanceEClass, AbstractAttributeInstance.class, "AbstractAttributeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractAttributeInstance_EAttribute(), ecorePackage.getEAttribute(), null, "eAttribute", null, 1, 1, AbstractAttributeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
	}

} //SerializationPackageImpl
