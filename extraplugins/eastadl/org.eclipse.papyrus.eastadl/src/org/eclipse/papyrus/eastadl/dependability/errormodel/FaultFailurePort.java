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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.dependability.errormodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin;
import org.eclipse.uml2.uml.Port;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Failure Port</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getFunctionTarget <em>Function Target</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getHwTarget <em>Hw Target</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getFunctionTarget_path <em>Function Target path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getHwTarget_path <em>Hw Target path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePort()
 * @model abstract="true"
 * @generated
 */
public interface FaultFailurePort extends Anomaly {

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(Port)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePort_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort#getBase_Port <em>Base Port</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(Port value);

	/**
	 * Returns the value of the '<em><b>Function Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Target</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Function Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePort_FunctionTarget()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FunctionPort> getFunctionTarget();

	/**
	 * Returns the value of the '<em><b>Hw Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Target</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hw Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePort_HwTarget()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HardwarePin> getHwTarget();

	/**
	 * Returns the value of the '<em><b>Function Target path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Target path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Function Target path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePort_FunctionTarget_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getFunctionTarget_path();

	/**
	 * Returns the value of the '<em><b>Hw Target path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw Target path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hw Target path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getFaultFailurePort_HwTarget_path()
	 * @model
	 * @generated
	 */
	EList<HardwareComponentPrototype> getHwTarget_path();

} // FaultFailurePort
