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
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationFactory
 * @model kind="package"
 * @generated
 */
public interface SerializationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "serialization"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/efacet/0.2.incubation/efacet/serialization"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "serialization"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializationPackage eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractReferenceInstanceImpl <em>Abstract Reference Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractReferenceInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getAbstractReferenceInstance()
	 * @generated
	 */
	int ABSTRACT_REFERENCE_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_REFERENCE_INSTANCE__EREFERENCE = 0;

	/**
	 * The number of structural features of the '<em>Abstract Reference Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedContainmentReferenceInstanceImpl <em>Multi Valued Containment Reference Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedContainmentReferenceInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getMultiValuedContainmentReferenceInstance()
	 * @generated
	 */
	int MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__EREFERENCE = ABSTRACT_REFERENCE_INSTANCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Valued Containment Reference Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE_FEATURE_COUNT = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedReferenceInstanceImpl <em>Multi Valued Reference Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedReferenceInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getMultiValuedReferenceInstance()
	 * @generated
	 */
	int MULTI_VALUED_REFERENCE_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_REFERENCE_INSTANCE__EREFERENCE = ABSTRACT_REFERENCE_INSTANCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Referenced Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_REFERENCE_INSTANCE__REFERENCED_ELEMENTS = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Valued Reference Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_REFERENCE_INSTANCE_FEATURE_COUNT = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractAttributeInstanceImpl <em>Abstract Attribute Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractAttributeInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getAbstractAttributeInstance()
	 * @generated
	 */
	int ABSTRACT_ATTRIBUTE_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>EAttribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE = 0;

	/**
	 * The number of structural features of the '<em>Abstract Attribute Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_INSTANCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedAttributeInstanceImpl <em>Single Valued Attribute Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedAttributeInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getSingleValuedAttributeInstance()
	 * @generated
	 */
	int SINGLE_VALUED_ATTRIBUTE_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>EAttribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_ATTRIBUTE_INSTANCE__EATTRIBUTE = ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_ATTRIBUTE_INSTANCE__VALUE = ABSTRACT_ATTRIBUTE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Valued Attribute Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_ATTRIBUTE_INSTANCE_FEATURE_COUNT = ABSTRACT_ATTRIBUTE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl <em>Extended EObject Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getExtendedEObjectReference()
	 * @generated
	 */
	int EXTENDED_EOBJECT_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Extended EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT = 0;

	/**
	 * The feature id for the '<em><b>Attribute Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES = 1;

	/**
	 * The feature id for the '<em><b>Reference Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES = 2;

	/**
	 * The number of structural features of the '<em>Extended EObject Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_EOBJECT_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedContainmentReferenceInstanceImpl <em>Single Valued Containment Reference Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedContainmentReferenceInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getSingleValuedContainmentReferenceInstance()
	 * @generated
	 */
	int SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE__EREFERENCE = ABSTRACT_REFERENCE_INSTANCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENT = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Valued Containment Reference Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE_FEATURE_COUNT = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedReferenceInstanceImpl <em>Single Valued Reference Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedReferenceInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getSingleValuedReferenceInstance()
	 * @generated
	 */
	int SINGLE_VALUED_REFERENCE_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_REFERENCE_INSTANCE__EREFERENCE = ABSTRACT_REFERENCE_INSTANCE__EREFERENCE;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_REFERENCE_INSTANCE__REFERENCED_ELEMENT = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Valued Reference Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUED_REFERENCE_INSTANCE_FEATURE_COUNT = ABSTRACT_REFERENCE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedAttributeInstanceImpl <em>Multi Valued Attribute Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedAttributeInstanceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getMultiValuedAttributeInstance()
	 * @generated
	 */
	int MULTI_VALUED_ATTRIBUTE_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>EAttribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_ATTRIBUTE_INSTANCE__EATTRIBUTE = ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_ATTRIBUTE_INSTANCE__VALUES = ABSTRACT_ATTRIBUTE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multi Valued Attribute Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_ATTRIBUTE_INSTANCE_FEATURE_COUNT = ABSTRACT_ATTRIBUTE_INSTANCE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance <em>Abstract Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Reference Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance
	 * @generated
	 */
	EClass getAbstractReferenceInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance#getEReference <em>EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance#getEReference()
	 * @see #getAbstractReferenceInstance()
	 * @generated
	 */
	EReference getAbstractReferenceInstance_EReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance <em>Multi Valued Containment Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Valued Containment Reference Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance
	 * @generated
	 */
	EClass getMultiValuedContainmentReferenceInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elements</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance#getOwnedElements()
	 * @see #getMultiValuedContainmentReferenceInstance()
	 * @generated
	 */
	EReference getMultiValuedContainmentReferenceInstance_OwnedElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance <em>Multi Valued Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Valued Reference Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance
	 * @generated
	 */
	EClass getMultiValuedReferenceInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance#getReferencedElements <em>Referenced Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Elements</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance#getReferencedElements()
	 * @see #getMultiValuedReferenceInstance()
	 * @generated
	 */
	EReference getMultiValuedReferenceInstance_ReferencedElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance <em>Single Valued Attribute Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Valued Attribute Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance
	 * @generated
	 */
	EClass getSingleValuedAttributeInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance#getValue()
	 * @see #getSingleValuedAttributeInstance()
	 * @generated
	 */
	EAttribute getSingleValuedAttributeInstance_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference <em>Extended EObject Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended EObject Reference</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference
	 * @generated
	 */
	EClass getExtendedEObjectReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getExtendedEObject <em>Extended EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended EObject</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getExtendedEObject()
	 * @see #getExtendedEObjectReference()
	 * @generated
	 */
	EReference getExtendedEObjectReference_ExtendedEObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getAttributeInstances <em>Attribute Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Instances</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getAttributeInstances()
	 * @see #getExtendedEObjectReference()
	 * @generated
	 */
	EReference getExtendedEObjectReference_AttributeInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getReferenceInstances <em>Reference Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Instances</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference#getReferenceInstances()
	 * @see #getExtendedEObjectReference()
	 * @generated
	 */
	EReference getExtendedEObjectReference_ReferenceInstances();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance <em>Single Valued Containment Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Valued Containment Reference Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance
	 * @generated
	 */
	EClass getSingleValuedContainmentReferenceInstance();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance#getOwnedElement <em>Owned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance#getOwnedElement()
	 * @see #getSingleValuedContainmentReferenceInstance()
	 * @generated
	 */
	EReference getSingleValuedContainmentReferenceInstance_OwnedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance <em>Single Valued Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Valued Reference Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance
	 * @generated
	 */
	EClass getSingleValuedReferenceInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance#getReferencedElement <em>Referenced Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance#getReferencedElement()
	 * @see #getSingleValuedReferenceInstance()
	 * @generated
	 */
	EReference getSingleValuedReferenceInstance_ReferencedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance <em>Multi Valued Attribute Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Valued Attribute Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance
	 * @generated
	 */
	EClass getMultiValuedAttributeInstance();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance#getValues()
	 * @see #getMultiValuedAttributeInstance()
	 * @generated
	 */
	EAttribute getMultiValuedAttributeInstance_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance <em>Abstract Attribute Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Attribute Instance</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance
	 * @generated
	 */
	EClass getAbstractAttributeInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance#getEAttribute <em>EAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EAttribute</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance#getEAttribute()
	 * @see #getAbstractAttributeInstance()
	 * @generated
	 */
	EReference getAbstractAttributeInstance_EAttribute();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SerializationFactory getSerializationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractReferenceInstanceImpl <em>Abstract Reference Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractReferenceInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getAbstractReferenceInstance()
		 * @generated
		 */
		EClass ABSTRACT_REFERENCE_INSTANCE = eINSTANCE.getAbstractReferenceInstance();

		/**
		 * The meta object literal for the '<em><b>EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_REFERENCE_INSTANCE__EREFERENCE = eINSTANCE.getAbstractReferenceInstance_EReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedContainmentReferenceInstanceImpl <em>Multi Valued Containment Reference Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedContainmentReferenceInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getMultiValuedContainmentReferenceInstance()
		 * @generated
		 */
		EClass MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE = eINSTANCE.getMultiValuedContainmentReferenceInstance();

		/**
		 * The meta object literal for the '<em><b>Owned Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS = eINSTANCE.getMultiValuedContainmentReferenceInstance_OwnedElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedReferenceInstanceImpl <em>Multi Valued Reference Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedReferenceInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getMultiValuedReferenceInstance()
		 * @generated
		 */
		EClass MULTI_VALUED_REFERENCE_INSTANCE = eINSTANCE.getMultiValuedReferenceInstance();

		/**
		 * The meta object literal for the '<em><b>Referenced Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_VALUED_REFERENCE_INSTANCE__REFERENCED_ELEMENTS = eINSTANCE.getMultiValuedReferenceInstance_ReferencedElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedAttributeInstanceImpl <em>Single Valued Attribute Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedAttributeInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getSingleValuedAttributeInstance()
		 * @generated
		 */
		EClass SINGLE_VALUED_ATTRIBUTE_INSTANCE = eINSTANCE.getSingleValuedAttributeInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_VALUED_ATTRIBUTE_INSTANCE__VALUE = eINSTANCE.getSingleValuedAttributeInstance_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl <em>Extended EObject Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.ExtendedEObjectReferenceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getExtendedEObjectReference()
		 * @generated
		 */
		EClass EXTENDED_EOBJECT_REFERENCE = eINSTANCE.getExtendedEObjectReference();

		/**
		 * The meta object literal for the '<em><b>Extended EObject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_EOBJECT_REFERENCE__EXTENDED_EOBJECT = eINSTANCE.getExtendedEObjectReference_ExtendedEObject();

		/**
		 * The meta object literal for the '<em><b>Attribute Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_EOBJECT_REFERENCE__ATTRIBUTE_INSTANCES = eINSTANCE.getExtendedEObjectReference_AttributeInstances();

		/**
		 * The meta object literal for the '<em><b>Reference Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_EOBJECT_REFERENCE__REFERENCE_INSTANCES = eINSTANCE.getExtendedEObjectReference_ReferenceInstances();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedContainmentReferenceInstanceImpl <em>Single Valued Containment Reference Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedContainmentReferenceInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getSingleValuedContainmentReferenceInstance()
		 * @generated
		 */
		EClass SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE = eINSTANCE.getSingleValuedContainmentReferenceInstance();

		/**
		 * The meta object literal for the '<em><b>Owned Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENT = eINSTANCE.getSingleValuedContainmentReferenceInstance_OwnedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedReferenceInstanceImpl <em>Single Valued Reference Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SingleValuedReferenceInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getSingleValuedReferenceInstance()
		 * @generated
		 */
		EClass SINGLE_VALUED_REFERENCE_INSTANCE = eINSTANCE.getSingleValuedReferenceInstance();

		/**
		 * The meta object literal for the '<em><b>Referenced Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_VALUED_REFERENCE_INSTANCE__REFERENCED_ELEMENT = eINSTANCE.getSingleValuedReferenceInstance_ReferencedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedAttributeInstanceImpl <em>Multi Valued Attribute Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedAttributeInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getMultiValuedAttributeInstance()
		 * @generated
		 */
		EClass MULTI_VALUED_ATTRIBUTE_INSTANCE = eINSTANCE.getMultiValuedAttributeInstance();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_VALUED_ATTRIBUTE_INSTANCE__VALUES = eINSTANCE.getMultiValuedAttributeInstance_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractAttributeInstanceImpl <em>Abstract Attribute Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractAttributeInstanceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl#getAbstractAttributeInstance()
		 * @generated
		 */
		EClass ABSTRACT_ATTRIBUTE_INSTANCE = eINSTANCE.getAbstractAttributeInstance();

		/**
		 * The meta object literal for the '<em><b>EAttribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE = eINSTANCE.getAbstractAttributeInstance_EAttribute();

	}

} //SerializationPackage
