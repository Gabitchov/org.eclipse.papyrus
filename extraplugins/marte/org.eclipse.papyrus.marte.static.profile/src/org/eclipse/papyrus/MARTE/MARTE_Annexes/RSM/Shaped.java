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
package org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shaped</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Shaped#getShape <em>Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Shaped#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getShaped()
 * @model
 * @generated
 */
public interface Shaped extends EObject {
	/**
	 * Returns the value of the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' attribute.
	 * @see #setShape(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getShaped_Shape()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.RS_Library.ShapeSpecification" required="true" ordered="false"
	 * @generated
	 */
	String getShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Shaped#getShape <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' attribute.
	 * @see #getShape()
	 * @generated
	 */
	void setShape(String value);

	/**
	 * Returns the value of the '<em><b>Base Multiplicity Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Multiplicity Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Multiplicity Element</em>' reference.
	 * @see #setBase_MultiplicityElement(MultiplicityElement)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage#getShaped_Base_MultiplicityElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MultiplicityElement getBase_MultiplicityElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Shaped#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Multiplicity Element</em>' reference.
	 * @see #getBase_MultiplicityElement()
	 * @generated
	 */
	void setBase_MultiplicityElement(MultiplicityElement value);

} // Shaped
