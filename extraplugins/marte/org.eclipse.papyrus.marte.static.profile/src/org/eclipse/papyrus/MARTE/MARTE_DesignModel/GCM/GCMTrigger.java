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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Trigger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getBase_Trigger <em>Base Trigger</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage#getGCMTrigger()
 * @model
 * @generated
 */
public interface GCMTrigger extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Trigger</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Trigger</em>' reference.
	 * @see #setBase_Trigger(Trigger)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage#getGCMTrigger_Base_Trigger()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Trigger getBase_Trigger();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getBase_Trigger <em>Base Trigger</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Trigger</em>' reference.
	 * @see #getBase_Trigger()
	 * @generated
	 */
	void setBase_Trigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage#getGCMTrigger_Feature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

} // GCMTrigger
