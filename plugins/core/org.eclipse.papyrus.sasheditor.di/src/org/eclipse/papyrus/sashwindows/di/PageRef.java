/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.PageRef#getPageIdentifier <em>Page Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.PageRef#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#getPageRef()
 * @model
 * @generated
 */
public interface PageRef extends EObject {
	/**
	 * Returns the value of the '<em><b>Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Identifier</em>' attribute.
	 * @see #setPageIdentifier(Object)
	 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#getPageRef_PageIdentifier()
	 * @model unique="false" dataType="org.eclipse.papyrus.sashwindows.di.JavaObject" required="true" ordered="false"
	 * @generated
	 */
	Object getPageIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sashwindows.di.PageRef#getPageIdentifier <em>Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Identifier</em>' attribute.
	 * @see #getPageIdentifier()
	 * @generated
	 */
	void setPageIdentifier(Object value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.sashwindows.di.TabFolder#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TabFolder)
	 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#getPageRef_Parent()
	 * @see org.eclipse.papyrus.sashwindows.di.TabFolder#getChildren
	 * @model opposite="children" required="true" transient="false" ordered="false"
	 * @generated
	 */
	TabFolder getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sashwindows.di.PageRef#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TabFolder value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" pageIdentifierDataType="org.eclipse.papyrus.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	boolean isForIdentifier(Object pageIdentifier);

} // PageRef
