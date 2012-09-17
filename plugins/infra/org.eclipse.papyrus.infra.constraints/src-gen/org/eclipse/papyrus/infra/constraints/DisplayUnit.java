/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints;

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
 *   <li>{@link org.eclipse.papyrus.infra.constraints.DisplayUnit#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.DisplayUnit#getElementMultiplicity <em>Element Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.constraints.ConstraintsPackage#getDisplayUnit()
 * @model abstract="true"
 * @generated
 */
public interface DisplayUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintsPackage#getDisplayUnit_Constraints()
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getDisplay
	 * @model opposite="display" containment="true"
	 * @generated
	 */
	EList<ConstraintDescriptor> getConstraints();

	/**
	 * Returns the value of the '<em><b>Element Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Multiplicity</em>' attribute.
	 * @see #setElementMultiplicity(int)
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintsPackage#getDisplayUnit_ElementMultiplicity()
	 * @model default="1"
	 * @generated
	 */
	int getElementMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.constraints.DisplayUnit#getElementMultiplicity <em>Element Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Multiplicity</em>' attribute.
	 * @see #getElementMultiplicity()
	 * @generated
	 */
	void setElementMultiplicity(int value);

} // DisplayUnit
