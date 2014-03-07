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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Node represents the computer nodes of the embedded EE system. Nodes consist of processor(s) and may be connected to sensors, actuators and other
 * ECUs via a BusConnector.
 * 
 * Node denotes an electronic control unit that acts as a computing element executing Functions. In case a single CPU-single core ECU is represented,
 * it is sufficient to have a single, non-hierarchical Node.
 * 
 * Semantics:
 * The Node element represents an ECU, i.e. an Electronic Control Unit and an allocation target of FunctionPrototypes.
 * 
 * The Node executes its allocated FunctionPrototypes at the specified executionRate. The executionRate denotes how many execution seconds of an
 * allocated functionPrototype´s execution time that is processed each real-time second. Actual execution time is thus found by dividing the
 * parameters of the ExecutionTimeConstraint with executionRate.
 * 
 * Example: If an ECU is 25% faster than a standard ECU (e.g., in a certain context, execution times are given assuming a nominal speed of 100 MHz;
 * Our CPU is then 125 MHz), the executionRate is 1.25. An execution time of 5 ms would then become 4 ms on this ECU.
 * 
 * Notation:
 * Node is shown as a solid-outline rectangle with Node at the top right. The rectangle contains the name, and its ports or port groups on the
 * perimeter.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getExecutionRate <em>Execution Rate</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getNonVolatileMemory <em>Non Volatile Memory</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getVolatileMemory <em>Volatile Memory</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends HardwareComponentType {

	/**
	 * Returns the value of the '<em><b>Execution Rate</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ExecutionRate is used to compute an approximate execution time. A nominal execution time divided by executionRate provides the actual execution
	 * time to be used e.g. for timing analysis in feasibility studies.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Execution Rate</em>' attribute.
	 * @see #setExecutionRate(Float)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getNode_ExecutionRate()
	 * @model default="1" unique="false" dataType="org.eclipse.papyrus.eastadl.infrastructure.datatypes.javalangFloat" required="true" ordered="false"
	 * @generated
	 */
	Float getExecutionRate();

	/**
	 * Returns the value of the '<em><b>Non Volatile Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The size in Bytes of the Node’s Non-Volatile memory (ROM, NRAM, EPROM, etc .
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Non Volatile Memory</em>' attribute.
	 * @see #setNonVolatileMemory(int)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getNode_NonVolatileMemory()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getNonVolatileMemory();

	/**
	 * Returns the value of the '<em><b>Volatile Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The size in Bytes of the Node’s Volatile memory (RAM)
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Volatile Memory</em>' attribute.
	 * @see #setVolatileMemory(int)
	 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getNode_VolatileMemory()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Integer" ordered="false"
	 * @generated
	 */
	int getVolatileMemory();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getExecutionRate <em>Execution Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Execution Rate</em>' attribute.
	 * @see #getExecutionRate()
	 * @generated
	 */
	void setExecutionRate(Float value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getNonVolatileMemory <em>Non Volatile Memory</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Non Volatile Memory</em>' attribute.
	 * @see #getNonVolatileMemory()
	 * @generated
	 */
	void setNonVolatileMemory(int value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node#getVolatileMemory <em>Volatile Memory</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Volatile Memory</em>' attribute.
	 * @see #getVolatileMemory()
	 * @generated
	 */
	void setVolatileMemory(int value);
} // Node
