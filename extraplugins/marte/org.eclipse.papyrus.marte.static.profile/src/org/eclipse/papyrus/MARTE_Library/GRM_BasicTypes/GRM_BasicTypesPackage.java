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
package org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes;

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
 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesFactory
 * @model kind="package"
 * @generated
 */
public interface GRM_BasicTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GRM_BasicTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///MARTE_Library/GRM_BasicTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MARTE_Library.GRM_BasicTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GRM_BasicTypesPackage eINSTANCE = org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind <em>Sched Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getSchedPolicyKind()
	 * @generated
	 */
	int SCHED_POLICY_KIND = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind <em>Protect Protocol Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getProtectProtocolKind()
	 * @generated
	 */
	int PROTECT_PROTOCOL_KIND = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind <em>Periodic Server Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getPeriodicServerKind()
	 * @generated
	 */
	int PERIODIC_SERVER_KIND = 2;

	/**
	 * The meta object id for the '<em>EDF Parameters</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getEDF_Parameters()
	 * @generated
	 */
	int EDF_PARAMETERS = 3;

	/**
	 * The meta object id for the '<em>Sched Parameters</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getSchedParameters()
	 * @generated
	 */
	int SCHED_PARAMETERS = 4;

	/**
	 * The meta object id for the '<em>Fixed Priority Parameters</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getFixedPriorityParameters()
	 * @generated
	 */
	int FIXED_PRIORITY_PARAMETERS = 5;

	/**
	 * The meta object id for the '<em>Periodic Server Parameters</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getPeriodicServerParameters()
	 * @generated
	 */
	int PERIODIC_SERVER_PARAMETERS = 6;

	/**
	 * The meta object id for the '<em>Pooling Parameters</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getPoolingParameters()
	 * @generated
	 */
	int POOLING_PARAMETERS = 7;

	/**
	 * The meta object id for the '<em>Schedule Specification</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getScheduleSpecification()
	 * @generated
	 */
	int SCHEDULE_SPECIFICATION = 8;

	/**
	 * The meta object id for the '<em>Table Driven Schedule</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getTableDrivenSchedule()
	 * @generated
	 */
	int TABLE_DRIVEN_SCHEDULE = 9;

	/**
	 * The meta object id for the '<em>Table Entry Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getTableEntryType()
	 * @generated
	 */
	int TABLE_ENTRY_TYPE = 10;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind <em>Sched Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sched Policy Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
	 * @generated
	 */
	EEnum getSchedPolicyKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind <em>Protect Protocol Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Protect Protocol Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind
	 * @generated
	 */
	EEnum getProtectProtocolKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind <em>Periodic Server Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Periodic Server Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind
	 * @generated
	 */
	EEnum getPeriodicServerKind();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>EDF Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EDF Parameters</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getEDF_Parameters();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Sched Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sched Parameters</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getSchedParameters();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Fixed Priority Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Fixed Priority Parameters</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getFixedPriorityParameters();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Periodic Server Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Periodic Server Parameters</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPeriodicServerParameters();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Pooling Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pooling Parameters</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getPoolingParameters();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Schedule Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Schedule Specification</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getScheduleSpecification();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Table Driven Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Table Driven Schedule</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getTableDrivenSchedule();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Table Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Table Entry Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getTableEntryType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GRM_BasicTypesFactory getGRM_BasicTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind <em>Sched Policy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getSchedPolicyKind()
		 * @generated
		 */
		EEnum SCHED_POLICY_KIND = eINSTANCE.getSchedPolicyKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind <em>Protect Protocol Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getProtectProtocolKind()
		 * @generated
		 */
		EEnum PROTECT_PROTOCOL_KIND = eINSTANCE.getProtectProtocolKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind <em>Periodic Server Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.PeriodicServerKind
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getPeriodicServerKind()
		 * @generated
		 */
		EEnum PERIODIC_SERVER_KIND = eINSTANCE.getPeriodicServerKind();

		/**
		 * The meta object literal for the '<em>EDF Parameters</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getEDF_Parameters()
		 * @generated
		 */
		EDataType EDF_PARAMETERS = eINSTANCE.getEDF_Parameters();

		/**
		 * The meta object literal for the '<em>Sched Parameters</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getSchedParameters()
		 * @generated
		 */
		EDataType SCHED_PARAMETERS = eINSTANCE.getSchedParameters();

		/**
		 * The meta object literal for the '<em>Fixed Priority Parameters</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getFixedPriorityParameters()
		 * @generated
		 */
		EDataType FIXED_PRIORITY_PARAMETERS = eINSTANCE.getFixedPriorityParameters();

		/**
		 * The meta object literal for the '<em>Periodic Server Parameters</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getPeriodicServerParameters()
		 * @generated
		 */
		EDataType PERIODIC_SERVER_PARAMETERS = eINSTANCE.getPeriodicServerParameters();

		/**
		 * The meta object literal for the '<em>Pooling Parameters</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getPoolingParameters()
		 * @generated
		 */
		EDataType POOLING_PARAMETERS = eINSTANCE.getPoolingParameters();

		/**
		 * The meta object literal for the '<em>Schedule Specification</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getScheduleSpecification()
		 * @generated
		 */
		EDataType SCHEDULE_SPECIFICATION = eINSTANCE.getScheduleSpecification();

		/**
		 * The meta object literal for the '<em>Table Driven Schedule</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getTableDrivenSchedule()
		 * @generated
		 */
		EDataType TABLE_DRIVEN_SCHEDULE = eINSTANCE.getTableDrivenSchedule();

		/**
		 * The meta object literal for the '<em>Table Entry Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl#getTableEntryType()
		 * @generated
		 */
		EDataType TABLE_ENTRY_TYPE = eINSTANCE.getTableEntryType();

	}

} //GRM_BasicTypesPackage
