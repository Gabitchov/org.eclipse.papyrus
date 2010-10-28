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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsFactory
 * @model kind="package"
 * @generated
 */
public interface NFPsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "NFPs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/NFPs/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "NFPs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NFPsPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpImpl <em>Nfp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getNfp()
	 * @generated
	 */
	int NFP = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Nfp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.UnitImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 1;

	/**
	 * The feature id for the '<em><b>Conv Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CONV_FACTOR = 0;

	/**
	 * The feature id for the '<em><b>Conv Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CONV_OFFSET = 1;

	/**
	 * The feature id for the '<em><b>Base Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__BASE_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Base Enumeration Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__BASE_ENUMERATION_LITERAL = 3;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl <em>Nfp Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getNfpConstraint()
	 * @generated
	 */
	int NFP_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_CONSTRAINT__KIND = 0;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_CONSTRAINT__BASE_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_CONSTRAINT__MODE = 2;

	/**
	 * The number of structural features of the '<em>Nfp Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_CONSTRAINT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl <em>Nfp Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getNfpType()
	 * @generated
	 */
	int NFP_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Tuple Attrib</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_TYPE__TUPLE_ATTRIB = DataTypesPackage.TUPLE_TYPE__TUPLE_ATTRIB;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_TYPE__BASE_DATA_TYPE = DataTypesPackage.TUPLE_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Value Attrib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_TYPE__VALUE_ATTRIB = DataTypesPackage.TUPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit Attrib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_TYPE__UNIT_ATTRIB = DataTypesPackage.TUPLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expr Attrib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_TYPE__EXPR_ATTRIB = DataTypesPackage.TUPLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Nfp Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_TYPE_FEATURE_COUNT = DataTypesPackage.TUPLE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 4;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__SYMBOL = 0;

	/**
	 * The feature id for the '<em><b>Base Dimension</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__BASE_DIMENSION = 1;

	/**
	 * The feature id for the '<em><b>Base Exponent</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__BASE_EXPONENT = 2;

	/**
	 * The feature id for the '<em><b>Base Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__BASE_ENUMERATION = 3;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.ConstraintKind <em>Constraint Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.ConstraintKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getConstraintKind()
	 * @generated
	 */
	int CONSTRAINT_KIND = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Nfp <em>Nfp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nfp</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Nfp
	 * @generated
	 */
	EClass getNfp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Nfp#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Nfp#getBase_Property()
	 * @see #getNfp()
	 * @generated
	 */
	EReference getNfp_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvFactor <em>Conv Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conv Factor</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvFactor()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_ConvFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvOffset <em>Conv Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conv Offset</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getConvOffset()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_ConvOffset();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBaseUnit <em>Base Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Unit</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBaseUnit()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_BaseUnit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBase_EnumerationLiteral <em>Base Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Enumeration Literal</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Unit#getBase_EnumerationLiteral()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Base_EnumerationLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint <em>Nfp Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nfp Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint
	 * @generated
	 */
	EClass getNfpConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint#getKind()
	 * @see #getNfpConstraint()
	 * @generated
	 */
	EAttribute getNfpConstraint_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint#getBase_Constraint()
	 * @see #getNfpConstraint()
	 * @generated
	 */
	EReference getNfpConstraint_Base_Constraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint#getMode()
	 * @see #getNfpConstraint()
	 * @generated
	 */
	EReference getNfpConstraint_Mode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType <em>Nfp Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nfp Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType
	 * @generated
	 */
	EClass getNfpType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType#getValueAttrib <em>Value Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType#getValueAttrib()
	 * @see #getNfpType()
	 * @generated
	 */
	EReference getNfpType_ValueAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType#getUnitAttrib <em>Unit Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType#getUnitAttrib()
	 * @see #getNfpType()
	 * @generated
	 */
	EReference getNfpType_UnitAttrib();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType#getExprAttrib <em>Expr Attrib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expr Attrib</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType#getExprAttrib()
	 * @see #getNfpType()
	 * @generated
	 */
	EReference getNfpType_ExprAttrib();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getSymbol()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Symbol();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getBaseDimension <em>Base Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Base Dimension</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getBaseDimension()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_BaseDimension();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getBaseExponent <em>Base Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Base Exponent</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getBaseExponent()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_BaseExponent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getBase_Enumeration <em>Base Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Enumeration</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.Dimension#getBase_Enumeration()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Base_Enumeration();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.ConstraintKind <em>Constraint Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Constraint Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.ConstraintKind
	 * @generated
	 */
	EEnum getConstraintKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NFPsFactory getNFPsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpImpl <em>Nfp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getNfp()
		 * @generated
		 */
		EClass NFP = eINSTANCE.getNfp();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP__BASE_PROPERTY = eINSTANCE.getNfp_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.UnitImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Conv Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__CONV_FACTOR = eINSTANCE.getUnit_ConvFactor();

		/**
		 * The meta object literal for the '<em><b>Conv Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__CONV_OFFSET = eINSTANCE.getUnit_ConvOffset();

		/**
		 * The meta object literal for the '<em><b>Base Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__BASE_UNIT = eINSTANCE.getUnit_BaseUnit();

		/**
		 * The meta object literal for the '<em><b>Base Enumeration Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__BASE_ENUMERATION_LITERAL = eINSTANCE.getUnit_Base_EnumerationLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl <em>Nfp Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getNfpConstraint()
		 * @generated
		 */
		EClass NFP_CONSTRAINT = eINSTANCE.getNfpConstraint();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NFP_CONSTRAINT__KIND = eINSTANCE.getNfpConstraint_Kind();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_CONSTRAINT__BASE_CONSTRAINT = eINSTANCE.getNfpConstraint_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_CONSTRAINT__MODE = eINSTANCE.getNfpConstraint_Mode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl <em>Nfp Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getNfpType()
		 * @generated
		 */
		EClass NFP_TYPE = eINSTANCE.getNfpType();

		/**
		 * The meta object literal for the '<em><b>Value Attrib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_TYPE__VALUE_ATTRIB = eINSTANCE.getNfpType_ValueAttrib();

		/**
		 * The meta object literal for the '<em><b>Unit Attrib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_TYPE__UNIT_ATTRIB = eINSTANCE.getNfpType_UnitAttrib();

		/**
		 * The meta object literal for the '<em><b>Expr Attrib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_TYPE__EXPR_ATTRIB = eINSTANCE.getNfpType_ExprAttrib();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.DimensionImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__SYMBOL = eINSTANCE.getDimension_Symbol();

		/**
		 * The meta object literal for the '<em><b>Base Dimension</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__BASE_DIMENSION = eINSTANCE.getDimension_BaseDimension();

		/**
		 * The meta object literal for the '<em><b>Base Exponent</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__BASE_EXPONENT = eINSTANCE.getDimension_BaseExponent();

		/**
		 * The meta object literal for the '<em><b>Base Enumeration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__BASE_ENUMERATION = eINSTANCE.getDimension_Base_Enumeration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.ConstraintKind <em>Constraint Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.ConstraintKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl#getConstraintKind()
		 * @generated
		 */
		EEnum CONSTRAINT_KIND = eINSTANCE.getConstraintKind();

	}

} //NFPsPackage
