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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.genericconstraints;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


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
 * 
 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface GenericconstraintsPackage extends EPackage {

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintSetImpl
		 * <em>Generic Constraint Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintSetImpl
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getGenericConstraintSet()
		 * @generated
		 */
		EClass GENERIC_CONSTRAINT_SET = eINSTANCE.getGenericConstraintSet();

		/**
		 * The meta object literal for the '<em><b>Generic Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT_SET__GENERIC_CONSTRAINT = eINSTANCE.getGenericConstraintSet_GenericConstraint();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT_SET__BASE_PACKAGE = eINSTANCE.getGenericConstraintSet_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT_SET__BASE_CLASS = eINSTANCE.getGenericConstraintSet_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.TakeRateConstraintImpl
		 * <em>Take Rate Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.TakeRateConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getTakeRateConstraint()
		 * @generated
		 */
		EClass TAKE_RATE_CONSTRAINT = eINSTANCE.getTakeRateConstraint();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TAKE_RATE_CONSTRAINT__SOURCE = eINSTANCE.getTakeRateConstraint_Source();

		/**
		 * The meta object literal for the '<em><b>Take Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TAKE_RATE_CONSTRAINT__TAKE_RATE = eINSTANCE.getTakeRateConstraint_TakeRate();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintImpl
		 * <em>Generic Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getGenericConstraint()
		 * @generated
		 */
		EClass GENERIC_CONSTRAINT = eINSTANCE.getGenericConstraint();

		/**
		 * The meta object literal for the '<em><b>Design Constraint Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GENERIC_CONSTRAINT__DESIGN_CONSTRAINT_TYPE = eINSTANCE.getGenericConstraint_DesignConstraintType();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT__BASE_CONSTRAINT = eINSTANCE.getGenericConstraint_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Generic Constraint Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GENERIC_CONSTRAINT__GENERIC_CONSTRAINT_VALUE = eINSTANCE.getGenericConstraint_GenericConstraintValue();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT__BASE_CLASS = eINSTANCE.getGenericConstraint_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT__TARGET = eINSTANCE.getGenericConstraint_Target();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_CONSTRAINT__MODE = eINSTANCE.getGenericConstraint_Mode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind
		 * <em>Generic Constraint Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind
		 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getGenericConstraintKind()
		 * @generated
		 */
		EEnum GENERIC_CONSTRAINT_KIND = eINSTANCE.getGenericConstraintKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "genericconstraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/GenericConstraints/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "GenericConstraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	GenericconstraintsPackage eINSTANCE = org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintSetImpl
	 * <em>Generic Constraint Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintSetImpl
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getGenericConstraintSet()
	 * @generated
	 */
	int GENERIC_CONSTRAINT_SET = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintImpl <em>Generic Constraint</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getGenericConstraint()
	 * @generated
	 */
	int GENERIC_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Design Constraint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__DESIGN_CONSTRAINT_TYPE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__BASE_CONSTRAINT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generic Constraint Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__GENERIC_CONSTRAINT_VALUE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__TARGET = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT__MODE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Generic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Generic Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__GENERIC_CONSTRAINT = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Generic Constraint Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTRAINT_SET_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.TakeRateConstraintImpl <em>Take Rate Constraint</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.TakeRateConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getTakeRateConstraint()
	 * @generated
	 */
	int TAKE_RATE_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__NAME = GENERIC_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__BASE_NAMED_ELEMENT = GENERIC_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__OWNED_COMMENT = GENERIC_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__BASE_PACKAGEABLE_ELEMENT = GENERIC_CONSTRAINT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__NOTE = GENERIC_CONSTRAINT__NOTE;

	/**
	 * The feature id for the '<em><b>Design Constraint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__DESIGN_CONSTRAINT_TYPE = GENERIC_CONSTRAINT__DESIGN_CONSTRAINT_TYPE;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__BASE_CONSTRAINT = GENERIC_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Generic Constraint Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__GENERIC_CONSTRAINT_VALUE = GENERIC_CONSTRAINT__GENERIC_CONSTRAINT_VALUE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__BASE_CLASS = GENERIC_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__TARGET = GENERIC_CONSTRAINT__TARGET;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__MODE = GENERIC_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__SOURCE = GENERIC_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Take Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT__TAKE_RATE = GENERIC_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Take Rate Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAKE_RATE_CONSTRAINT_FEATURE_COUNT = GENERIC_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind <em>Generic Constraint Kind</em>}'
	 * enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl#getGenericConstraintKind()
	 * @generated
	 */
	int GENERIC_CONSTRAINT_KIND = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint <em>Generic Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Generic Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint
	 * @generated
	 */
	EClass getGenericConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getDesignConstraintType
	 * <em>Design Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Design Constraint Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getDesignConstraintType()
	 * @see #getGenericConstraint()
	 * @generated
	 */
	EAttribute getGenericConstraint_DesignConstraintType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Constraint
	 * <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Constraint()
	 * @see #getGenericConstraint()
	 * @generated
	 */
	EReference getGenericConstraint_Base_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getGenericConstraintValue
	 * <em>Generic Constraint Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Generic Constraint Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getGenericConstraintValue()
	 * @see #getGenericConstraint()
	 * @generated
	 */
	EAttribute getGenericConstraint_GenericConstraintValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Class()
	 * @see #getGenericConstraint()
	 * @generated
	 */
	EReference getGenericConstraint_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getMode <em>Mode</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getMode()
	 * @see #getGenericConstraint()
	 * @generated
	 */
	EReference getGenericConstraint_Mode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getTarget
	 * <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getTarget()
	 * @see #getGenericConstraint()
	 * @generated
	 */
	EReference getGenericConstraint_Target();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind <em>Generic Constraint Kind</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Generic Constraint Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind
	 * @generated
	 */
	EEnum getGenericConstraintKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet <em>Generic Constraint Set</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Generic Constraint Set</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet
	 * @generated
	 */
	EClass getGenericConstraintSet();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet#getGenericConstraint <em>Generic Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Generic Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet#getGenericConstraint()
	 * @see #getGenericConstraintSet()
	 * @generated
	 */
	EReference getGenericConstraintSet_GenericConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet#getBase_Package()
	 * @see #getGenericConstraintSet()
	 * @generated
	 */
	EReference getGenericConstraintSet_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintSet#getBase_Class()
	 * @see #getGenericConstraintSet()
	 * @generated
	 */
	EReference getGenericConstraintSet_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenericconstraintsFactory getGenericconstraintsFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint <em>Take Rate Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Take Rate Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint
	 * @generated
	 */
	EClass getTakeRateConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getSource
	 * <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getSource()
	 * @see #getTakeRateConstraint()
	 * @generated
	 */
	EReference getTakeRateConstraint_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getTakeRate
	 * <em>Take Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Take Rate</em>'.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint#getTakeRate()
	 * @see #getTakeRateConstraint()
	 * @generated
	 */
	EAttribute getTakeRateConstraint_TakeRate();

} //GenericconstraintsPackage
