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
package org.eclipse.papyrus.eastadl.structure.functionmodeling;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.uml2.uml.Connector;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Connector</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The FunctionConnector indicates that the connected FunctionPorts exchange signals or client-server requests/responses.
 * 
 * Semantics:
 * The FunctionConnector connects a pair of FunctionFlowPorts or FunctionClientServerPorts. If two FunctionFlowPorts are connected, data elements of
 * the type of the output FunctionFlowPort flow from the output FunctionFlowPort to the input FunctionFlowPort. If FunctionClientServerPorts are
 * connected, the client calls the server according to the operations of the interfaces. The occurrence of the FunctionType that specifies the
 * occurrence of the FunctionPrototype has to be identified by the FunctionConnector as well.
 * The FunctionConnector is normally routed according to the hardware topology and the allocation of source and destination. If there are redundant
 * paths, a FunctionAllocation may be used to prescribe allocation.
 * 
 * 
 * Constraints:
 * [1] Can connect two FunctionFlowPorts of different direction when this is an assembly FunctionConnector.
 * 
 * [2] Can connect two FunctionFlowPorts of the same direction when this is a delegation FunctionConnector.
 * 
 * [3] Can connect two ClientServerPorts of different kind when this is an assembly FunctionConnector.
 * 
 * [4] Can connect two ClientServerPorts of the same kind when this is a delegation FunctionConnector.
 * 
 * [5] Can connect two FunctionFlowPorts with direction inout.
 * 
 * Notation: FunctionConnector is shown as a solid line
 * 
 * Extension: UML Connector
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort <em>Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getBase_Connector <em>Base Connector</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort1_path <em>Port1 path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getPort2_path <em>Port2 path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionConnector()
 * @model
 * @generated
 */
public interface FunctionConnector extends EAElement, AllocateableElement {

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ports that are connected by this connector.
	 * {derived from UML::Connector::end}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Port</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionConnector_Port()
	 * @model upper="2" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FunctionPort> getPort();

	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionConnector_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector#getBase_Connector
	 * <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>Port1 path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port1 path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Port1 path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionConnector_Port1_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getPort1_path();

	/**
	 * Returns the value of the '<em><b>Port2 path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port2 path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Port2 path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionConnector_Port2_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getPort2_path();

} // FunctionConnector
