/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.DisplayUnit#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDisplayUnit()
 * @model abstract="true"
 * @generated
 */
public interface DisplayUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDisplayUnit_Constraints()
	 * @see org.eclipse.papyrus.properties.contexts.ConstraintDescriptor#getDisplay
	 * @model opposite="display" containment="true"
	 * @generated
	 */
	EList<ConstraintDescriptor> getConstraints();

} // DisplayUnit
