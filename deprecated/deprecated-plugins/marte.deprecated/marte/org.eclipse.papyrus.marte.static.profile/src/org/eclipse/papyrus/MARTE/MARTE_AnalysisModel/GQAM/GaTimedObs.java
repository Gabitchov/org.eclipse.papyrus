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

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;

import org.eclipse.uml2.uml.TimeObservation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ga Timed Obs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getLaxity <em>Laxity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getStartObs <em>Start Obs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getEndObs <em>End Obs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaTimedObs()
 * @model
 * @generated
 */
public interface GaTimedObs extends NfpConstraint {
	/**
	 * Returns the value of the '<em><b>Laxity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Laxity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Laxity</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind
	 * @see #setLaxity(LaxityKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaTimedObs_Laxity()
	 * @model unique="false"
	 * @generated
	 */
	LaxityKind getLaxity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs#getLaxity <em>Laxity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Laxity</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind
	 * @see #getLaxity()
	 * @generated
	 */
	void setLaxity(LaxityKind value);

	/**
	 * Returns the value of the '<em><b>Start Obs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TimeObservation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Obs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Obs</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaTimedObs_StartObs()
	 * @model
	 * @generated
	 */
	EList<TimeObservation> getStartObs();

	/**
	 * Returns the value of the '<em><b>End Obs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.TimeObservation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Obs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Obs</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaTimedObs_EndObs()
	 * @model
	 * @generated
	 */
	EList<TimeObservation> getEndObs();

} // GaTimedObs
