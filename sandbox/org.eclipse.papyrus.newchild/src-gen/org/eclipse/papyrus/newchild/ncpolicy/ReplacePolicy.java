/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.ncpolicy;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.newchild.MenuItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replace Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.ncpolicy.ReplacePolicy#getReplaceWith <em>Replace With</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.newchild.ncpolicy.NcpolicyPackage#getReplacePolicy()
 * @model
 * @generated
 */
public interface ReplacePolicy extends NewChildPolicy {
	/**
	 * Returns the value of the '<em><b>Replace With</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.newchild.MenuItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace With</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replace With</em>' containment reference list.
	 * @see org.eclipse.papyrus.newchild.ncpolicy.NcpolicyPackage#getReplacePolicy_ReplaceWith()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MenuItem> getReplaceWith();

} // ReplacePolicy
