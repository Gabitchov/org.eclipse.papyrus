/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface DataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/DataTypes/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataTypesPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl <em>Bounded Subtype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getBoundedSubtype()
	 * @generated
	 */
	int BOUNDED_SUBTYPE = 0;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE__BASE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE__MIN_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE__MAX_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Is Min Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE__IS_MIN_OPEN = 3;

	/**
	 * The feature id for the '<em><b>Is Max Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE__IS_MAX_OPEN = 4;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE__BASE_DATA_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Bounded Subtype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_SUBTYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.IntervalTypeImpl <em>Interval Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.IntervalTypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getIntervalType()
	 * @generated
	 */
	int INTERVAL_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Interval Attrib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__INTERVAL_ATTRIB = 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE__BASE_DATA_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Interval Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.CollectionTypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Collection Attrib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__COLLECTION_ATTRIB = 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__BASE_DATA_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl <em>Choice Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getChoiceType()
	 * @generated
	 */
	int CHOICE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Choice Attrib</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__CHOICE_ATTRIB = 0;

	/**
	 * The feature id for the '<em><b>Default Attrib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__DEFAULT_ATTRIB = 1;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE__BASE_DATA_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Choice Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.TupleTypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getTupleType()
	 * @generated
	 */
	int TUPLE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Tuple Attrib</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TUPLE_ATTRIB = 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__BASE_DATA_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype <em>Bounded Subtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Subtype</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype
	 * @generated
	 */
	EClass getBoundedSubtype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBaseType()
	 * @see #getBoundedSubtype()
	 * @generated
	 */
	EReference getBoundedSubtype_BaseType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMinValue()
	 * @see #getBoundedSubtype()
	 * @generated
	 */
	EAttribute getBoundedSubtype_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getMaxValue()
	 * @see #getBoundedSubtype()
	 * @generated
	 */
	EAttribute getBoundedSubtype_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMinOpen <em>Is Min Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Min Open</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMinOpen()
	 * @see #getBoundedSubtype()
	 * @generated
	 */
	EAttribute getBoundedSubtype_IsMinOpen();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMaxOpen <em>Is Max Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Max Open</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#isIsMaxOpen()
	 * @see #getBoundedSubtype()
	 * @generated
	 */
	EAttribute getBoundedSubtype_IsMaxOpen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype#getBase_DataType()
	 * @see #getBoundedSubtype()
	 * @generated
	 */
	EReference getBoundedSubtype_Base_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.IntervalType <em>Interval Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.IntervalType
	 * @generated
	 */
	EClass getIntervalType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.IntervalType#getIntervalAttrib <em>Interval Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interval Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.IntervalType#getIntervalAttrib()
	 * @see #getIntervalType()
	 * @generated
	 */
	EReference getIntervalType_IntervalAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.IntervalType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.IntervalType#getBase_DataType()
	 * @see #getIntervalType()
	 * @generated
	 */
	EReference getIntervalType_Base_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType#getCollectionAttrib <em>Collection Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collection Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType#getCollectionAttrib()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_CollectionAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.CollectionType#getBase_DataType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_Base_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType <em>Choice Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType
	 * @generated
	 */
	EClass getChoiceType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType#getChoiceAttrib <em>Choice Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Choice Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType#getChoiceAttrib()
	 * @see #getChoiceType()
	 * @generated
	 */
	EReference getChoiceType_ChoiceAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType#getDefaultAttrib <em>Default Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType#getDefaultAttrib()
	 * @see #getChoiceType()
	 * @generated
	 */
	EReference getChoiceType_DefaultAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.ChoiceType#getBase_DataType()
	 * @see #getChoiceType()
	 * @generated
	 */
	EReference getChoiceType_Base_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType#getTupleAttrib <em>Tuple Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tuple Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType#getTupleAttrib()
	 * @see #getTupleType()
	 * @generated
	 */
	EReference getTupleType_TupleAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.TupleType#getBase_DataType()
	 * @see #getTupleType()
	 * @generated
	 */
	EReference getTupleType_Base_DataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataTypesFactory getDataTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl <em>Bounded Subtype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getBoundedSubtype()
		 * @generated
		 */
		EClass BOUNDED_SUBTYPE = eINSTANCE.getBoundedSubtype();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_SUBTYPE__BASE_TYPE = eINSTANCE.getBoundedSubtype_BaseType();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_SUBTYPE__MIN_VALUE = eINSTANCE.getBoundedSubtype_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_SUBTYPE__MAX_VALUE = eINSTANCE.getBoundedSubtype_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Is Min Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_SUBTYPE__IS_MIN_OPEN = eINSTANCE.getBoundedSubtype_IsMinOpen();

		/**
		 * The meta object literal for the '<em><b>Is Max Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_SUBTYPE__IS_MAX_OPEN = eINSTANCE.getBoundedSubtype_IsMaxOpen();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_SUBTYPE__BASE_DATA_TYPE = eINSTANCE.getBoundedSubtype_Base_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.IntervalTypeImpl <em>Interval Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.IntervalTypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getIntervalType()
		 * @generated
		 */
		EClass INTERVAL_TYPE = eINSTANCE.getIntervalType();

		/**
		 * The meta object literal for the '<em><b>Interval Attrib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL_TYPE__INTERVAL_ATTRIB = eINSTANCE.getIntervalType_IntervalAttrib();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERVAL_TYPE__BASE_DATA_TYPE = eINSTANCE.getIntervalType_Base_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.CollectionTypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Collection Attrib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__COLLECTION_ATTRIB = eINSTANCE.getCollectionType_CollectionAttrib();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__BASE_DATA_TYPE = eINSTANCE.getCollectionType_Base_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl <em>Choice Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.ChoiceTypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getChoiceType()
		 * @generated
		 */
		EClass CHOICE_TYPE = eINSTANCE.getChoiceType();

		/**
		 * The meta object literal for the '<em><b>Choice Attrib</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_TYPE__CHOICE_ATTRIB = eINSTANCE.getChoiceType_ChoiceAttrib();

		/**
		 * The meta object literal for the '<em><b>Default Attrib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_TYPE__DEFAULT_ATTRIB = eINSTANCE.getChoiceType_DefaultAttrib();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE_TYPE__BASE_DATA_TYPE = eINSTANCE.getChoiceType_Base_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.TupleTypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl#getTupleType()
		 * @generated
		 */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
		 * The meta object literal for the '<em><b>Tuple Attrib</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE__TUPLE_ATTRIB = eINSTANCE.getTupleType_TupleAttrib();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE__BASE_DATA_TYPE = eINSTANCE.getTupleType_Base_DataType();

	}

} //DataTypesPackage
