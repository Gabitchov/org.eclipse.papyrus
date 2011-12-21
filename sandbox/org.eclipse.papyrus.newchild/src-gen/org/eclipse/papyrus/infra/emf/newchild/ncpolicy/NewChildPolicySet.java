/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.ncpolicy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Child Policy Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet#getPolicies <em>Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewChildPolicySet()
 * @model
 * @generated
 */
public interface NewChildPolicySet extends DisplayUnit {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewChildPolicySet_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Policies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policies</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getNewChildPolicySet_Policies()
	 * @model containment="true"
	 * @generated
	 */
	EList<NewChildPolicy> getPolicies();

} // NewChildPolicySet
