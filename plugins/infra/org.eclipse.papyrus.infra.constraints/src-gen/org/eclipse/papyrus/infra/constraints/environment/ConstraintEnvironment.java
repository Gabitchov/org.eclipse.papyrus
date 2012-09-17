/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints.environment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment#getConstraintTypes <em>Constraint Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.constraints.environment.EnvironmentPackage#getConstraintEnvironment()
 * @model
 * @generated
 */
public interface ConstraintEnvironment extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.constraints.environment.ConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.constraints.environment.EnvironmentPackage#getConstraintEnvironment_ConstraintTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintType> getConstraintTypes();

} // ConstraintEnvironment
