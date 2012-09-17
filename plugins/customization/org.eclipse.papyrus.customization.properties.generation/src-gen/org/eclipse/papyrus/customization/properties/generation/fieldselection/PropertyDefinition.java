/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.properties.generation.fieldselection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.TernaryButton.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition#getValueSingle <em>Value Single</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition#getValueMultiple <em>Value Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends EObject {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getPropertyDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value Single</b></em>' attribute.
	 * The default value is <code>"DEFAULT"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Single</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Single</em>' attribute.
	 * @see #setValueSingle(State)
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getPropertyDefinition_ValueSingle()
	 * @model default="DEFAULT" dataType="org.eclipse.papyrus.customization.properties.generation.fieldselection.Value" required="true"
	 * @generated
	 */
	State getValueSingle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition#getValueSingle <em>Value Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Single</em>' attribute.
	 * @see #getValueSingle()
	 * @generated
	 */
	void setValueSingle(State value);

	/**
	 * Returns the value of the '<em><b>Value Multiple</b></em>' attribute.
	 * The default value is <code>"DEFAULT"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Multiple</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Multiple</em>' attribute.
	 * @see #setValueMultiple(State)
	 * @see org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage#getPropertyDefinition_ValueMultiple()
	 * @model default="DEFAULT" dataType="org.eclipse.papyrus.customization.properties.generation.fieldselection.Value" required="true"
	 * @generated
	 */
	State getValueMultiple();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition#getValueMultiple <em>Value Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Multiple</em>' attribute.
	 * @see #getValueMultiple()
	 * @generated
	 */
	void setValueMultiple(State value);

} // PropertyDefinition
