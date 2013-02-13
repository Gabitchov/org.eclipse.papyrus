/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage#getPageIdentifier <em>Page Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getAbstractPage()
 * @model
 * @generated
 */
public interface AbstractPage extends EObject {

	/**
	 * Returns the value of the '<em><b>Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Identifier</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Identifier</em>' attribute.
	 * @see #setPageIdentifier(Object)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getAbstractPage_PageIdentifier()
	 * @model unique="false" dataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" required="true" ordered="false"
	 * @generated
	 */
	Object getPageIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage#getPageIdentifier <em>Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Identifier</em>' attribute.
	 * @see #getPageIdentifier()
	 * @generated
	 */
	void setPageIdentifier(Object value);

} // AbstractPage
