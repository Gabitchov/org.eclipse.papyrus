/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#isKept <em>Kept</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getRepresentedElement <em>Represented Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#isUseRepresented <em>Use Represented</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualElement()
 * @model abstract="true"
 * @generated
 */
public interface VirtualElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Alias Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias Name</em>' attribute.
	 * @see #setAliasName(String)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualElement_AliasName()
	 * @model
	 * @generated
	 */
	String getAliasName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getAliasName <em>Alias Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias Name</em>' attribute.
	 * @see #getAliasName()
	 * @generated
	 */
	void setAliasName(String value);

	/**
	 * Returns the value of the '<em><b>Kept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kept</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kept</em>' attribute.
	 * @see #setKept(boolean)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualElement_Kept()
	 * @model required="true"
	 * @generated
	 */
	boolean isKept();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#isKept <em>Kept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kept</em>' attribute.
	 * @see #isKept()
	 * @generated
	 */
	void setKept(boolean value);

	/**
	 * Returns the value of the '<em><b>Represented Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Element</em>' reference.
	 * @see #setRepresentedElement(EObject)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualElement_RepresentedElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getRepresentedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#getRepresentedElement <em>Represented Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Element</em>' reference.
	 * @see #getRepresentedElement()
	 * @generated
	 */
	void setRepresentedElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Use Represented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Represented</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Represented</em>' attribute.
	 * @see #setUseRepresented(boolean)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualElement_UseRepresented()
	 * @model required="true"
	 * @generated
	 */
	boolean isUseRepresented();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement#isUseRepresented <em>Use Represented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Represented</em>' attribute.
	 * @see #isUseRepresented()
	 * @generated
	 */
	void setUseRepresented(boolean value);

} // VirtualElement
