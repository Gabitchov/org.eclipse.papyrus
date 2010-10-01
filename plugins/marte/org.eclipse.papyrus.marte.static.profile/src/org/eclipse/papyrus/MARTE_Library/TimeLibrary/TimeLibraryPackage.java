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
package org.eclipse.papyrus.MARTE_Library.TimeLibrary;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeLibraryFactory
 * @model kind="package"
 * @generated
 */
public interface TimeLibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TimeLibrary";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///MARTE_Library/TimeLibrary.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MARTE_Library.TimeLibrary";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimeLibraryPackage eINSTANCE = org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.IdealClockImpl <em>Ideal Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.IdealClockImpl
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getIdealClock()
	 * @generated
	 */
	int IDEAL_CLOCK = 0;

	/**
	 * The number of structural features of the '<em>Ideal Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDEAL_CLOCK_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeUnitKind <em>Time Unit Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeUnitKind
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getTimeUnitKind()
	 * @generated
	 */
	int TIME_UNIT_KIND = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.LogicalTimeUnit <em>Logical Time Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.LogicalTimeUnit
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getLogicalTimeUnit()
	 * @generated
	 */
	int LOGICAL_TIME_UNIT = 2;

	/**
	 * The meta object id for the '<em>Timed Value Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getTimedValueType()
	 * @generated
	 */
	int TIMED_VALUE_TYPE = 3;

	/**
	 * The meta object id for the '<em>Clocked Value Specification</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getClockedValueSpecification()
	 * @generated
	 */
	int CLOCKED_VALUE_SPECIFICATION = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.IdealClock <em>Ideal Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ideal Clock</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.IdealClock
	 * @generated
	 */
	EClass getIdealClock();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeUnitKind <em>Time Unit Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Unit Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeUnitKind
	 * @generated
	 */
	EEnum getTimeUnitKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.LogicalTimeUnit <em>Logical Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logical Time Unit</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.LogicalTimeUnit
	 * @generated
	 */
	EEnum getLogicalTimeUnit();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Timed Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Timed Value Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getTimedValueType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Clocked Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Clocked Value Specification</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getClockedValueSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimeLibraryFactory getTimeLibraryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.IdealClockImpl <em>Ideal Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.IdealClockImpl
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getIdealClock()
		 * @generated
		 */
		EClass IDEAL_CLOCK = eINSTANCE.getIdealClock();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeUnitKind <em>Time Unit Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeUnitKind
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getTimeUnitKind()
		 * @generated
		 */
		EEnum TIME_UNIT_KIND = eINSTANCE.getTimeUnitKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeLibrary.LogicalTimeUnit <em>Logical Time Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.LogicalTimeUnit
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getLogicalTimeUnit()
		 * @generated
		 */
		EEnum LOGICAL_TIME_UNIT = eINSTANCE.getLogicalTimeUnit();

		/**
		 * The meta object literal for the '<em>Timed Value Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getTimedValueType()
		 * @generated
		 */
		EDataType TIMED_VALUE_TYPE = eINSTANCE.getTimedValueType();

		/**
		 * The meta object literal for the '<em>Clocked Value Specification</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl#getClockedValueSpecification()
		 * @generated
		 */
		EDataType CLOCKED_VALUE_SPECIFICATION = eINSTANCE.getClockedValueSpecification();

	}

} //TimeLibraryPackage
