/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.properties.generation.fieldselection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getContextElement()
 * @model
 * @generated
 */
public interface ContextElement extends EObject {

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getContextElement_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextElement> getElements();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getContextElement_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyDefinition> getProperties();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getContextElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ContextElement
