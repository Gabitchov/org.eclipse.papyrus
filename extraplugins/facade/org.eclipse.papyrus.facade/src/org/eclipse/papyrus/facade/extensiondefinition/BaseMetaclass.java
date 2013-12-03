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
package org.eclipse.papyrus.facade.extensiondefinition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Metaclass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getIncompatibleStereotypes <em>Incompatible Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getExtensionDefinition <em>Extension Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getCompatibleStereotypes <em>Compatible Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#isPossible <em>Possible</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getBaseMetaclass()
 * @model
 * @generated
 */
public interface BaseMetaclass extends EObject {
	/**
	 * Returns the value of the '<em><b>Incompatible Stereotypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.extensiondefinition.Combination}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incompatible Stereotypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incompatible Stereotypes</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getBaseMetaclass_IncompatibleStereotypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Combination> getIncompatibleStereotypes();

	/**
	 * Returns the value of the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' reference.
	 * @see #setBase(EObject)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getBaseMetaclass_Base()
	 * @model required="true"
	 * @generated
	 */
	EObject getBase();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getBase <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(EObject value);

	/**
	 * Returns the value of the '<em><b>Extension Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getBaseMetaclasses <em>Base Metaclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Definition</em>' container reference.
	 * @see #setExtensionDefinition(ExtensionDefinition)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getBaseMetaclass_ExtensionDefinition()
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getBaseMetaclasses
	 * @model opposite="baseMetaclasses" required="true" transient="false"
	 * @generated
	 */
	ExtensionDefinition getExtensionDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getExtensionDefinition <em>Extension Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Definition</em>' container reference.
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	void setExtensionDefinition(ExtensionDefinition value);

	/**
	 * Returns the value of the '<em><b>Compatible Stereotypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.extensiondefinition.Combination}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compatible Stereotypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compatible Stereotypes</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getBaseMetaclass_CompatibleStereotypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Combination> getCompatibleStereotypes();

	/**
	 * Returns the value of the '<em><b>Possible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible</em>' attribute.
	 * @see #setPossible(boolean)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getBaseMetaclass_Possible()
	 * @model required="true"
	 * @generated
	 */
	boolean isPossible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#isPossible <em>Possible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Possible</em>' attribute.
	 * @see #isPossible()
	 * @generated
	 */
	void setPossible(boolean value);

} // BaseMetaclass
