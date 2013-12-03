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

import org.eclipse.papyrus.facade.Facade;

import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getBaseMetaclasses <em>Base Metaclasses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getFacade <em>Facade</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getExtensionDefinition()
 * @model
 * @generated
 */
public interface ExtensionDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' reference.
	 * @see #setExtension(Extension)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getExtensionDefinition_Extension()
	 * @model required="true"
	 * @generated
	 */
	Extension getExtension();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getExtension <em>Extension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' reference.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(Extension value);

	/**
	 * Returns the value of the '<em><b>Base Metaclasses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getExtensionDefinition <em>Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Metaclasses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Metaclasses</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getExtensionDefinition_BaseMetaclasses()
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getExtensionDefinition
	 * @model opposite="extensionDefinition" containment="true"
	 * @generated
	 */
	EList<BaseMetaclass> getBaseMetaclasses();

	/**
	 * Returns the value of the '<em><b>Facade</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.Facade#getExtensionDefinitions <em>Extension Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facade</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facade</em>' container reference.
	 * @see #setFacade(Facade)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getExtensionDefinition_Facade()
	 * @see org.eclipse.papyrus.facade.Facade#getExtensionDefinitions
	 * @model opposite="extensionDefinitions" required="true" transient="false"
	 * @generated
	 */
	Facade getFacade();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getFacade <em>Facade</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facade</em>' container reference.
	 * @see #getFacade()
	 * @generated
	 */
	void setFacade(Facade value);

	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' reference.
	 * @see #setStereotype(Stereotype)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getExtensionDefinition_Stereotype()
	 * @model required="true"
	 * @generated
	 */
	Stereotype getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getStereotype <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind
	 * @see #setKind(ExtensionDefinitionKind)
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getExtensionDefinition_Kind()
	 * @model required="true"
	 * @generated
	 */
	ExtensionDefinitionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ExtensionDefinitionKind value);

} // ExtensionDefinition
