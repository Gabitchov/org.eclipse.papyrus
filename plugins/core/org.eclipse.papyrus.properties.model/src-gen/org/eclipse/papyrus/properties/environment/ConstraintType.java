/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.environment.ConstraintType#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.ConstraintType#getConstraintClass <em>Constraint Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getConstraintType()
 * @model
 * @generated
 */
public interface ConstraintType extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getConstraintType_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.environment.ConstraintType#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Constraint Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Class</em>' attribute.
	 * @see #setConstraintClass(String)
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getConstraintType_ConstraintClass()
	 * @model required="true"
	 * @generated
	 */
	String getConstraintClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.environment.ConstraintType#getConstraintClass <em>Constraint Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Class</em>' attribute.
	 * @see #getConstraintClass()
	 * @generated
	 */
	void setConstraintClass(String value);

} // ConstraintType
