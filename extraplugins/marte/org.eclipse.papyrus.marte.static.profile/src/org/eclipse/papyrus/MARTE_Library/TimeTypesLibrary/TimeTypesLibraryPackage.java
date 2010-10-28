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
package org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary;

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
 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryFactory
 * @model kind="package"
 * @generated
 */
public interface TimeTypesLibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TimeTypesLibrary";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///MARTE_Library/TimeTypesLibrary.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MARTE_Library.TimeTypesLibrary";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimeTypesLibraryPackage eINSTANCE = org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind <em>Time Nature Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getTimeNatureKind()
	 * @generated
	 */
	int TIME_NATURE_KIND = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind <em>Time Interpretation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getTimeInterpretationKind()
	 * @generated
	 */
	int TIME_INTERPRETATION_KIND = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind <em>Event Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getEventKind()
	 * @generated
	 */
	int EVENT_KIND = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind <em>Time Standard Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getTimeStandardKind()
	 * @generated
	 */
	int TIME_STANDARD_KIND = 3;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind <em>Time Nature Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Nature Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind
	 * @generated
	 */
	EEnum getTimeNatureKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind <em>Time Interpretation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Interpretation Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind
	 * @generated
	 */
	EEnum getTimeInterpretationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind <em>Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind
	 * @generated
	 */
	EEnum getEventKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind <em>Time Standard Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Standard Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind
	 * @generated
	 */
	EEnum getTimeStandardKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimeTypesLibraryFactory getTimeTypesLibraryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind <em>Time Nature Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getTimeNatureKind()
		 * @generated
		 */
		EEnum TIME_NATURE_KIND = eINSTANCE.getTimeNatureKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind <em>Time Interpretation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getTimeInterpretationKind()
		 * @generated
		 */
		EEnum TIME_INTERPRETATION_KIND = eINSTANCE.getTimeInterpretationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind <em>Event Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getEventKind()
		 * @generated
		 */
		EEnum EVENT_KIND = eINSTANCE.getEventKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind <em>Time Standard Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind
		 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl#getTimeStandardKind()
		 * @generated
		 */
		EEnum TIME_STANDARD_KIND = eINSTANCE.getTimeStandardKind();

	}

} //TimeTypesLibraryPackage
