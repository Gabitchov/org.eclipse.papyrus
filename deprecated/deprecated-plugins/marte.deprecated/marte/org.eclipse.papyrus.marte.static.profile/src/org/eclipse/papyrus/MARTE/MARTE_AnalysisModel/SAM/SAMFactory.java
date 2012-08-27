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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage
 * @generated
 */
public interface SAMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SAMFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sa Analysis Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Analysis Context</em>'.
	 * @generated
	 */
	SaAnalysisContext createSaAnalysisContext();

	/**
	 * Returns a new object of class '<em>Sa Endto End Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Endto End Flow</em>'.
	 * @generated
	 */
	SaEndtoEndFlow createSaEndtoEndFlow();

	/**
	 * Returns a new object of class '<em>Sa Comm Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Comm Step</em>'.
	 * @generated
	 */
	SaCommStep createSaCommStep();

	/**
	 * Returns a new object of class '<em>Sa Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Step</em>'.
	 * @generated
	 */
	SaStep createSaStep();

	/**
	 * Returns a new object of class '<em>Sa Shared Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Shared Resource</em>'.
	 * @generated
	 */
	SaSharedResource createSaSharedResource();

	/**
	 * Returns a new object of class '<em>Sa Sched Obs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Sched Obs</em>'.
	 * @generated
	 */
	SaSchedObs createSaSchedObs();

	/**
	 * Returns a new object of class '<em>Sa Comm Host</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Comm Host</em>'.
	 * @generated
	 */
	SaCommHost createSaCommHost();

	/**
	 * Returns a new object of class '<em>Sa Exec Host</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sa Exec Host</em>'.
	 * @generated
	 */
	SaExecHost createSaExecHost();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SAMPackage getSAMPackage();

} //SAMFactory
