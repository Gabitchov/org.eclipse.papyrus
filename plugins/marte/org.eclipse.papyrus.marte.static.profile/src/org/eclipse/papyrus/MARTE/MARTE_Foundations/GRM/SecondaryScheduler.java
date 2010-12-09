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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Secondary Scheduler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler#getVirtualProcessingUnits <em>Virtual Processing Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getSecondaryScheduler()
 * @model
 * @generated
 */
public interface SecondaryScheduler extends Scheduler {
	/**
	 * Returns the value of the '<em><b>Virtual Processing Units</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getDependentScheduler <em>Dependent Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Processing Units</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Processing Units</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getSecondaryScheduler_VirtualProcessingUnits()
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getDependentScheduler
	 * @model opposite="dependentScheduler" ordered="false"
	 * @generated
	 */
	EList<SchedulableResource> getVirtualProcessingUnits();

} // SecondaryScheduler
