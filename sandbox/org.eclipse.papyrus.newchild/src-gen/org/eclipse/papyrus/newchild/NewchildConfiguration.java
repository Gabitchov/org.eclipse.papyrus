/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.newchild.NewchildConfiguration#getRoots <em>Roots</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.newchild.NewchildPackage#getNewchildConfiguration()
 * @model
 * @generated
 */
public interface NewchildConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Roots</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.newchild.MenuRoot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roots</em>' containment reference list.
	 * @see org.eclipse.papyrus.newchild.NewchildPackage#getNewchildConfiguration_Roots()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuRoot> getRoots();

} // NewchildConfiguration
