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
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimeFactory
 * @model kind="package"
 * @generated
 */
public interface RuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtime"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/efacet/0.2.incubation/efacet/runtime"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "runtime"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimePackage eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl <em>ETyped Element Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementResult()
	 * @generated
	 */
	int ETYPED_ELEMENT_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Derived Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_RESULT__PARAMETER_VALUES = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_RESULT__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_RESULT__EXCEPTION = 3;

	/**
	 * The number of structural features of the '<em>ETyped Element Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_RESULT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeResultImpl <em>ETyped Element Primitive Type Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeResultImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementPrimitiveTypeResult()
	 * @generated
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Derived Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__DERIVED_TYPED_ELEMENT = ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__PARAMETER_VALUES = ETYPED_ELEMENT_RESULT__PARAMETER_VALUES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__SOURCE = ETYPED_ELEMENT_RESULT__SOURCE;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__EXCEPTION = ETYPED_ELEMENT_RESULT__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__RESULT = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ETyped Element Primitive Type Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT_FEATURE_COUNT = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectResultImpl <em>ETyped Element EObject Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectResultImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementEObjectResult()
	 * @generated
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Derived Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT__DERIVED_TYPED_ELEMENT = ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT__PARAMETER_VALUES = ETYPED_ELEMENT_RESULT__PARAMETER_VALUES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT__SOURCE = ETYPED_ELEMENT_RESULT__SOURCE;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT__EXCEPTION = ETYPED_ELEMENT_RESULT__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT__RESULT = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ETyped Element EObject Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_RESULT_FEATURE_COUNT = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeListResultImpl <em>ETyped Element Primitive Type List Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeListResultImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementPrimitiveTypeListResult()
	 * @generated
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Derived Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__DERIVED_TYPED_ELEMENT = ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__PARAMETER_VALUES = ETYPED_ELEMENT_RESULT__PARAMETER_VALUES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__SOURCE = ETYPED_ELEMENT_RESULT__SOURCE;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__EXCEPTION = ETYPED_ELEMENT_RESULT__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Result List</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__RESULT_LIST = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ETyped Element Primitive Type List Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT_FEATURE_COUNT = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectListResultImpl <em>ETyped Element EObject List Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectListResultImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementEObjectListResult()
	 * @generated
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Derived Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT__DERIVED_TYPED_ELEMENT = ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT__PARAMETER_VALUES = ETYPED_ELEMENT_RESULT__PARAMETER_VALUES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT__SOURCE = ETYPED_ELEMENT_RESULT__SOURCE;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT__EXCEPTION = ETYPED_ELEMENT_RESULT__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Result List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT__RESULT_LIST = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ETyped Element EObject List Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPED_ELEMENT_EOBJECT_LIST_RESULT_FEATURE_COUNT = ETYPED_ELEMENT_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Java Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getJavaException()
	 * @generated
	 */
	int JAVA_EXCEPTION = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult <em>ETyped Element Primitive Type Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element Primitive Type Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult
	 * @generated
	 */
	EClass getETypedElementPrimitiveTypeResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult#getResult()
	 * @see #getETypedElementPrimitiveTypeResult()
	 * @generated
	 */
	EAttribute getETypedElementPrimitiveTypeResult_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult <em>ETyped Element EObject Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element EObject Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult
	 * @generated
	 */
	EClass getETypedElementEObjectResult();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult#getResult()
	 * @see #getETypedElementEObjectResult()
	 * @generated
	 */
	EReference getETypedElementEObjectResult_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult <em>ETyped Element Primitive Type List Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element Primitive Type List Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult
	 * @generated
	 */
	EClass getETypedElementPrimitiveTypeListResult();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult#getResultList <em>Result List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Result List</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult#getResultList()
	 * @see #getETypedElementPrimitiveTypeListResult()
	 * @generated
	 */
	EAttribute getETypedElementPrimitiveTypeListResult_ResultList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult <em>ETyped Element EObject List Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element EObject List Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult
	 * @generated
	 */
	EClass getETypedElementEObjectListResult();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult#getResultList <em>Result List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Result List</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult#getResultList()
	 * @see #getETypedElementEObjectListResult()
	 * @generated
	 */
	EReference getETypedElementEObjectListResult_ResultList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult <em>ETyped Element Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETyped Element Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult
	 * @generated
	 */
	EClass getETypedElementResult();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getDerivedTypedElement <em>Derived Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derived Typed Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getDerivedTypedElement()
	 * @see #getETypedElementResult()
	 * @generated
	 */
	EReference getETypedElementResult_DerivedTypedElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getParameterValues()
	 * @see #getETypedElementResult()
	 * @generated
	 */
	EReference getETypedElementResult_ParameterValues();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getSource()
	 * @see #getETypedElementResult()
	 * @generated
	 */
	EReference getETypedElementResult_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult#getException()
	 * @see #getETypedElementResult()
	 * @generated
	 */
	EAttribute getETypedElementResult_Exception();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Java Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Exception</em>'.
	 * @see java.lang.Throwable
	 * @model instanceClass="java.lang.Throwable"
	 * @generated
	 */
	EDataType getJavaException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimeFactory getRuntimeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeResultImpl <em>ETyped Element Primitive Type Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeResultImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementPrimitiveTypeResult()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT = eINSTANCE.getETypedElementPrimitiveTypeResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__RESULT = eINSTANCE.getETypedElementPrimitiveTypeResult_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectResultImpl <em>ETyped Element EObject Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectResultImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementEObjectResult()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_EOBJECT_RESULT = eINSTANCE.getETypedElementEObjectResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_EOBJECT_RESULT__RESULT = eINSTANCE.getETypedElementEObjectResult_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeListResultImpl <em>ETyped Element Primitive Type List Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementPrimitiveTypeListResultImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementPrimitiveTypeListResult()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT = eINSTANCE.getETypedElementPrimitiveTypeListResult();

		/**
		 * The meta object literal for the '<em><b>Result List</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__RESULT_LIST = eINSTANCE.getETypedElementPrimitiveTypeListResult_ResultList();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectListResultImpl <em>ETyped Element EObject List Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementEObjectListResultImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementEObjectListResult()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_EOBJECT_LIST_RESULT = eINSTANCE.getETypedElementEObjectListResult();

		/**
		 * The meta object literal for the '<em><b>Result List</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_EOBJECT_LIST_RESULT__RESULT_LIST = eINSTANCE.getETypedElementEObjectListResult_ResultList();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl <em>ETyped Element Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getETypedElementResult()
		 * @generated
		 */
		EClass ETYPED_ELEMENT_RESULT = eINSTANCE.getETypedElementResult();

		/**
		 * The meta object literal for the '<em><b>Derived Typed Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT = eINSTANCE.getETypedElementResult_DerivedTypedElement();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_RESULT__PARAMETER_VALUES = eINSTANCE.getETypedElementResult_ParameterValues();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPED_ELEMENT_RESULT__SOURCE = eINSTANCE.getETypedElementResult_Source();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETYPED_ELEMENT_RESULT__EXCEPTION = eINSTANCE.getETypedElementResult_Exception();

		/**
		 * The meta object literal for the '<em>Java Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl#getJavaException()
		 * @generated
		 */
		EDataType JAVA_EXCEPTION = eINSTANCE.getJavaException();

	}

} //RuntimePackage
