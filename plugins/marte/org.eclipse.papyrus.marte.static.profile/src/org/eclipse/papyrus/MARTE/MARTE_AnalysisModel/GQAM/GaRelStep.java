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

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ga Rel Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getRelRes <em>Rel Res</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getResUnits <em>Res Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaRelStep()
 * @model
 * @generated
 */
public interface GaRelStep extends GaStep {
	/**
	 * Returns the value of the '<em><b>Rel Res</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel Res</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel Res</em>' reference.
	 * @see #setRelRes(Resource)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaRelStep_RelRes()
	 * @model ordered="false"
	 * @generated
	 */
	Resource getRelRes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getRelRes <em>Rel Res</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Res</em>' reference.
	 * @see #getRelRes()
	 * @generated
	 */
	void setRelRes(Resource value);

	/**
	 * Returns the value of the '<em><b>Res Units</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Units</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Units</em>' attribute.
	 * @see #setResUnits(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaRelStep_ResUnits()
	 * @model default="1" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getResUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep#getResUnits <em>Res Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Units</em>' attribute.
	 * @see #getResUnits()
	 * @generated
	 */
	void setResUnits(String value);

} // GaRelStep
