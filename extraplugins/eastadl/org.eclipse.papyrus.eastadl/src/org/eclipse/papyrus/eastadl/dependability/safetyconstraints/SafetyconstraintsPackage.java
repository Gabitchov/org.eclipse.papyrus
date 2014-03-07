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
package org.eclipse.papyrus.eastadl.dependability.safetyconstraints;

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
 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface SafetyconstraintsPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl
		 * <em>Safety Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getSafetyConstraint()
		 * @generated
		 */
		EClass SAFETY_CONSTRAINT = eINSTANCE.getSafetyConstraint();

		/**
		 * The meta object literal for the '<em><b>Asil Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SAFETY_CONSTRAINT__ASIL_VALUE = eINSTANCE.getSafetyConstraint_AsilValue();

		/**
		 * The meta object literal for the '<em><b>Constrained Fault Failure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE = eINSTANCE.getSafetyConstraint_ConstrainedFaultFailure();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_CONSTRAINT__BASE_CLASS = eINSTANCE.getSafetyConstraint_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SAFETY_CONSTRAINT__BASE_CONSTRAINT = eINSTANCE.getSafetyConstraint_Base_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.QuantitativeSafetyConstraintImpl
		 * <em>Quantitative Safety Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.QuantitativeSafetyConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getQuantitativeSafetyConstraint()
		 * @generated
		 */
		EClass QUANTITATIVE_SAFETY_CONSTRAINT = eINSTANCE.getQuantitativeSafetyConstraint();

		/**
		 * The meta object literal for the '<em><b>Constrained Fault Failure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUANTITATIVE_SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE = eINSTANCE.getQuantitativeSafetyConstraint_ConstrainedFaultFailure();

		/**
		 * The meta object literal for the '<em><b>Failure Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUANTITATIVE_SAFETY_CONSTRAINT__FAILURE_RATE = eINSTANCE.getQuantitativeSafetyConstraint_FailureRate();

		/**
		 * The meta object literal for the '<em><b>Repair Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUANTITATIVE_SAFETY_CONSTRAINT__REPAIR_RATE = eINSTANCE.getQuantitativeSafetyConstraint_RepairRate();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUANTITATIVE_SAFETY_CONSTRAINT__BASE_CLASS = eINSTANCE.getQuantitativeSafetyConstraint_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUANTITATIVE_SAFETY_CONSTRAINT__BASE_CONSTRAINT = eINSTANCE.getQuantitativeSafetyConstraint_Base_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl
		 * <em>Fault Failure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getFaultFailure()
		 * @generated
		 */
		EClass FAULT_FAILURE = eINSTANCE.getFaultFailure();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE__BASE_CLASS = eINSTANCE.getFaultFailure_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Fault Failure Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FAULT_FAILURE__FAULT_FAILURE_VALUE = eINSTANCE.getFaultFailure_FaultFailureValue();

		/**
		 * The meta object literal for the '<em><b>Anomaly</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FAULT_FAILURE__ANOMALY = eINSTANCE.getFaultFailure_Anomaly();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind <em>ASIL Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
		 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getASILKind()
		 * @generated
		 */
		EEnum ASIL_KIND = eINSTANCE.getASILKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "safetyconstraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Dependability/SafetyConstraints/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "SafetyConstraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SafetyconstraintsPackage eINSTANCE = org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl.init();


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl
	 * <em>Safety Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getSafetyConstraint()
	 * @generated
	 */
	int SAFETY_CONSTRAINT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.QuantitativeSafetyConstraintImpl
	 * <em>Quantitative Safety Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.QuantitativeSafetyConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getQuantitativeSafetyConstraint()
	 * @generated
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl <em>Fault Failure</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getFaultFailure()
	 * @generated
	 */
	int FAULT_FAILURE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fault Failure Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__FAULT_FAILURE_VALUE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Anomaly</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE__ANOMALY = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Fault Failure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FAULT_FAILURE_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Asil Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__ASIL_VALUE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constrained Fault Failure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT__BASE_CONSTRAINT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Safety Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SAFETY_CONSTRAINT_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Constrained Fault Failure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Failure Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__FAILURE_RATE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repair Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__REPAIR_RATE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__BASE_CLASS = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT__BASE_CONSTRAINT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Quantitative Safety Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_SAFETY_CONSTRAINT_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind <em>ASIL Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl#getASILKind()
	 * @generated
	 */
	int ASIL_KIND = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure <em>Fault Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Fault Failure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure
	 * @generated
	 */
	EClass getFaultFailure();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getBase_Class()
	 * @see #getFaultFailure()
	 * @generated
	 */
	EReference getFaultFailure_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getAnomaly
	 * <em>Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Anomaly</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getAnomaly()
	 * @see #getFaultFailure()
	 * @generated
	 */
	EReference getFaultFailure_Anomaly();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getFaultFailureValue <em>Fault Failure Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Fault Failure Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure#getFaultFailureValue()
	 * @see #getFaultFailure()
	 * @generated
	 */
	EAttribute getFaultFailure_FaultFailureValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint
	 * <em>Quantitative Safety Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Quantitative Safety Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint
	 * @generated
	 */
	EClass getQuantitativeSafetyConstraint();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getConstrainedFaultFailure
	 * <em>Constrained Fault Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Constrained Fault Failure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getConstrainedFaultFailure()
	 * @see #getQuantitativeSafetyConstraint()
	 * @generated
	 */
	EReference getQuantitativeSafetyConstraint_ConstrainedFaultFailure();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getFailureRate <em>Failure Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Failure Rate</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getFailureRate()
	 * @see #getQuantitativeSafetyConstraint()
	 * @generated
	 */
	EAttribute getQuantitativeSafetyConstraint_FailureRate();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getRepairRate <em>Repair Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Repair Rate</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getRepairRate()
	 * @see #getQuantitativeSafetyConstraint()
	 * @generated
	 */
	EAttribute getQuantitativeSafetyConstraint_RepairRate();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Class()
	 * @see #getQuantitativeSafetyConstraint()
	 * @generated
	 */
	EReference getQuantitativeSafetyConstraint_Base_Class();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint#getBase_Constraint()
	 * @see #getQuantitativeSafetyConstraint()
	 * @generated
	 */
	EReference getQuantitativeSafetyConstraint_Base_Constraint();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind <em>ASIL Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>ASIL Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind
	 * @generated
	 */
	EEnum getASILKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint
	 * <em>Safety Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Safety Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint
	 * @generated
	 */
	EClass getSafetyConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getAsilValue
	 * <em>Asil Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Asil Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getAsilValue()
	 * @see #getSafetyConstraint()
	 * @generated
	 */
	EAttribute getSafetyConstraint_AsilValue();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getConstrainedFaultFailure
	 * <em>Constrained Fault Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Constrained Fault Failure</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getConstrainedFaultFailure()
	 * @see #getSafetyConstraint()
	 * @generated
	 */
	EReference getSafetyConstraint_ConstrainedFaultFailure();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Class()
	 * @see #getSafetyConstraint()
	 * @generated
	 */
	EReference getSafetyConstraint_Base_Class();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint#getBase_Constraint()
	 * @see #getSafetyConstraint()
	 * @generated
	 */
	EReference getSafetyConstraint_Base_Constraint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SafetyconstraintsFactory getSafetyconstraintsFactory();

} //SafetyconstraintsPackage
