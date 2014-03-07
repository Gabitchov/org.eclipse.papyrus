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

import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Client Server Port</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The FunctionClientServerPort is a FunctionPort for client-server interaction. A number of FunctionClientServerPorts of clientServerType "client"
 * can be connected to one FunctionClientServerPort of clientServerType "server", i.e. when connected the multiplicity for the connection is n to 1
 * for client and server.
 * 
 * Semantics:
 * The FunctionClientServerPort is a FunctionPort for client-server interaction.
 * 
 * FunctionClientServerPorts are single buffer overwrite and nonconsumable.
 * 
 * Constraints:
 * [1] A FunctionClientServerPort of clientServerType "client" can only be connected to one FunctionClientServerPort of clientServerType "server".
 * 
 * Extension: UML Port
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getClientServerType <em>Client Server Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionClientServerPort()
 * @model
 * @generated
 */
public interface FunctionClientServerPort extends FunctionPort {

	/**
	 * Returns the value of the '<em><b>Client Server Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Server Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Client Server Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind
	 * @see #setClientServerType(ClientServerKind)
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionClientServerPort_ClientServerType()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	ClientServerKind getClientServerType();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The interface of this port.
	 * 
	 * {derived from UML::TypedElement::type}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionClientServerPort_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FunctionClientServerInterface getType();

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
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getFunctionClientServerPort_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getBase_Port <em>Base Port</em>}'
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
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort#getClientServerType
	 * <em>Client Server Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Client Server Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.ClientServerKind
	 * @see #getClientServerType()
	 * @generated
	 */
	void setClientServerType(ClientServerKind value);

} // FunctionClientServerPort
