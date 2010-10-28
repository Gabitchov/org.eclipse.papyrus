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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pa Res Pass Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaResPassStep#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaResPassStep#getResUnits <em>Res Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaResPassStep()
 * @model
 * @generated
 */
public interface PaResPassStep extends GaStep {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(Resource)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaResPassStep_Resource()
	 * @model ordered="false"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaResPassStep#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

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
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage#getPaResPassStep_ResUnits()
	 * @model default="1" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getResUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaResPassStep#getResUnits <em>Res Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Units</em>' attribute.
	 * @see #getResUnits()
	 * @generated
	 */
	void setResUnits(String value);

} // PaResPassStep
