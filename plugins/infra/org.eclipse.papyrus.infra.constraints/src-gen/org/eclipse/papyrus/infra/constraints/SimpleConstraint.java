/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.SimpleConstraint#getConstraintType <em>Constraint Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.SimpleConstraint#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.constraints.ConstraintsPackage#getSimpleConstraint()
 * @model
 * @generated
 */
public interface SimpleConstraint extends ConstraintDescriptor {
	/**
	 * Returns the value of the '<em><b>Constraint Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Type</em>' reference.
	 * @see #setConstraintType(ConstraintType)
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintsPackage#getSimpleConstraint_ConstraintType()
	 * @model required="true"
	 * @generated
	 */
	ConstraintType getConstraintType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.constraints.SimpleConstraint#getConstraintType <em>Constraint Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Type</em>' reference.
	 * @see #getConstraintType()
	 * @generated
	 */
	void setConstraintType(ConstraintType value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.constraints.ConfigProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintsPackage#getSimpleConstraint_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConfigProperty> getProperties();

} // SimpleConstraint
