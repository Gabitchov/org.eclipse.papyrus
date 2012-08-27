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

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sa Analysis Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getIsSched <em>Is Sched</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getOptCriterion <em>Opt Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaAnalysisContext()
 * @model
 * @generated
 */
public interface SaAnalysisContext extends GaAnalysisContext {
	/**
	 * Returns the value of the '<em><b>Is Sched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sched</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sched</em>' attribute.
	 * @see #setIsSched(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaAnalysisContext_IsSched()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Boolean" ordered="false"
	 * @generated
	 */
	String getIsSched();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getIsSched <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sched</em>' attribute.
	 * @see #getIsSched()
	 * @generated
	 */
	void setIsSched(String value);

	/**
	 * Returns the value of the '<em><b>Opt Criterion</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opt Criterion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opt Criterion</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind
	 * @see #setOptCriterion(OptimallityCriterionKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage#getSaAnalysisContext_OptCriterion()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	OptimallityCriterionKind getOptCriterion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext#getOptCriterion <em>Opt Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opt Criterion</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind
	 * @see #getOptCriterion()
	 * @generated
	 */
	void setOptCriterion(OptimallityCriterionKind value);

} // SaAnalysisContext
