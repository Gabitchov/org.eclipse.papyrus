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
 * A representation of the model object '<em><b>Field Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelection#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelection#getContextElements <em>Context Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getFieldSelection()
 * @model
 * @generated
 */
public interface FieldSelection extends EObject {

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getFieldSelection_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyDefinition> getFields();

	/**
	 * Returns the value of the '<em><b>Context Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Elements</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Elements</em>' containment reference list.
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getFieldSelection_ContextElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextElement> getContextElements();

} // FieldSelection
