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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage
 * @generated
 */
public interface GQAMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GQAMFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ga Workload Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Workload Generator</em>'.
	 * @generated
	 */
	GaWorkloadGenerator createGaWorkloadGenerator();

	/**
	 * Returns a new object of class '<em>Ga Event Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Event Trace</em>'.
	 * @generated
	 */
	GaEventTrace createGaEventTrace();

	/**
	 * Returns a new object of class '<em>Ga Workload Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Workload Event</em>'.
	 * @generated
	 */
	GaWorkloadEvent createGaWorkloadEvent();

	/**
	 * Returns a new object of class '<em>Ga Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Scenario</em>'.
	 * @generated
	 */
	GaScenario createGaScenario();

	/**
	 * Returns a new object of class '<em>Ga Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Step</em>'.
	 * @generated
	 */
	GaStep createGaStep();

	/**
	 * Returns a new object of class '<em>Ga Exec Host</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Exec Host</em>'.
	 * @generated
	 */
	GaExecHost createGaExecHost();

	/**
	 * Returns a new object of class '<em>Ga Requested Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Requested Service</em>'.
	 * @generated
	 */
	GaRequestedService createGaRequestedService();

	/**
	 * Returns a new object of class '<em>Ga Timed Obs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Timed Obs</em>'.
	 * @generated
	 */
	GaTimedObs createGaTimedObs();

	/**
	 * Returns a new object of class '<em>Ga Comm Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Comm Step</em>'.
	 * @generated
	 */
	GaCommStep createGaCommStep();

	/**
	 * Returns a new object of class '<em>Ga Acq Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Acq Step</em>'.
	 * @generated
	 */
	GaAcqStep createGaAcqStep();

	/**
	 * Returns a new object of class '<em>Ga Rel Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Rel Step</em>'.
	 * @generated
	 */
	GaRelStep createGaRelStep();

	/**
	 * Returns a new object of class '<em>Ga Latency Obs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Latency Obs</em>'.
	 * @generated
	 */
	GaLatencyObs createGaLatencyObs();

	/**
	 * Returns a new object of class '<em>Ga Comm Host</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Comm Host</em>'.
	 * @generated
	 */
	GaCommHost createGaCommHost();

	/**
	 * Returns a new object of class '<em>Ga Comm Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Comm Channel</em>'.
	 * @generated
	 */
	GaCommChannel createGaCommChannel();

	/**
	 * Returns a new object of class '<em>Ga Workload Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Workload Behavior</em>'.
	 * @generated
	 */
	GaWorkloadBehavior createGaWorkloadBehavior();

	/**
	 * Returns a new object of class '<em>Ga Analysis Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Analysis Context</em>'.
	 * @generated
	 */
	GaAnalysisContext createGaAnalysisContext();

	/**
	 * Returns a new object of class '<em>Ga Resources Platform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ga Resources Platform</em>'.
	 * @generated
	 */
	GaResourcesPlatform createGaResourcesPlatform();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GQAMPackage getGQAMPackage();

} //GQAMFactory
