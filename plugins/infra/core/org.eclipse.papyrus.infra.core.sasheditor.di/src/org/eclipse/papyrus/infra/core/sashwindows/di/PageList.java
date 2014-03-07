/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageList#getAvailablePage <em>Available Page</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageList()
 * @model
 * @generated
 */
@Deprecated
public interface PageList extends EObject {

	/**
	 * Returns the value of the '<em><b>Available Page</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Page</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Page</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageList_AvailablePage()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PageRef> getAvailablePage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void addPage(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void removePage(Object pageIdentifier);

} // PageList
