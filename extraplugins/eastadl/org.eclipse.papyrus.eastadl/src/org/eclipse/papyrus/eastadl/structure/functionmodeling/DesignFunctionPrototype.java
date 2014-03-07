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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Design Function Prototype</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The DesignFunctionPrototype represents references to the occurrence of the DesignFunctionType that types it when it acts as a part.
 * The DesignFunctionPrototype is typed by a DesignFunctionType .
 * 
 * Semantics:
 * The DesignFunctionPrototype represents an occurrence of the DesignFunctionType that types it.
 * 
 * Extension:
 * UML Property, specialization of SysML::BlockProperty
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getDesignFunctionPrototype()
 * @model
 * @generated
 */
public interface DesignFunctionPrototype extends FunctionPrototype, AllocateableElement {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getDesignFunctionPrototype_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	DesignFunctionType getType();

} // DesignFunctionPrototype
