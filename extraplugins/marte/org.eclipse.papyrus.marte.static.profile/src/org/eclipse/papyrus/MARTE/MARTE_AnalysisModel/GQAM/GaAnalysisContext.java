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
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ga Analysis Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getWorkload <em>Workload</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext#getPlatform <em>Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaAnalysisContext()
 * @model
 * @generated
 */
public interface GaAnalysisContext extends Configuration, ExpressionContext {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaAnalysisContext_Context()
	 * @model dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_String" ordered="false"
	 * @generated
	 */
	EList<String> getContext();

	/**
	 * Returns the value of the '<em><b>Workload</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workload</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workload</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaAnalysisContext_Workload()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<GaWorkloadBehavior> getWorkload();

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage#getGaAnalysisContext_Platform()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<GaResourcesPlatform> getPlatform();

} // GaAnalysisContext
