/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Node Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenNode <em>Gen Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenConstraint <em>Gen Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getGenNodeConstraint()
 * @model
 * @generated
 */
public interface GenNodeConstraint extends CommentedElement {

	/**
	 * Returns the value of the '<em><b>Gen Node</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Node</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Node</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getGenNodeConstraint_GenNode()
	 * @model
	 * @generated
	 */
	EList<GenNode> getGenNode();

	/**
	 * Returns the value of the '<em><b>Gen Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Constraint</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Constraint</em>' reference.
	 * @see #setGenConstraint(GenConstraint)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getGenNodeConstraint_GenConstraint()
	 * @model
	 * @generated
	 */
	GenConstraint getGenConstraint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenConstraint <em>Gen Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Constraint</em>' reference.
	 * @see #getGenConstraint()
	 * @generated
	 */
	void setGenConstraint(GenConstraint value);

} // GenNodeConstraint
