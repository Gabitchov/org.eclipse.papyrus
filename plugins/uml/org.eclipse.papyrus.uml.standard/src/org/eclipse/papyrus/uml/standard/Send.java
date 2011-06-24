/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.standard;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Usage;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Send</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.standard.Send#getBase_Usage <em>Base Usage</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.uml.standard.StandardPackage#getSend()
 * @model
 * @generated
 */
public interface Send extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Usage</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Usage</em>' reference.
	 * @see #setBase_Usage(Usage)
	 * @see org.eclipse.papyrus.uml.standard.StandardPackage#getSend_Base_Usage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Usage getBase_Usage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.standard.Send#getBase_Usage <em>Base Usage</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Usage</em>' reference.
	 * @see #getBase_Usage()
	 * @generated
	 */
	void setBase_Usage(Usage value);

} // Send
