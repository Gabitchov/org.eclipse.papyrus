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
 * A representation of the model object '<em><b>Sash Windows Mngr</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getPageList <em>Page List</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getSashModel <em>Sash Model</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashWindowsMngr()
 * @model
 * @generated
 */
public interface SashWindowsMngr extends EObject {

	/**
	 * Returns the value of the '<em><b>Page List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page List</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Page List</em>' containment reference.
	 * @see #setPageList(PageList)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashWindowsMngr_PageList()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	@Deprecated
	PageList getPageList();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getPageList <em>Page List</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Page List</em>' containment reference.
	 * @see #getPageList()
	 * @generated
	 */
	@Deprecated
	void setPageList(PageList value);

	/**
	 * Returns the value of the '<em><b>Sash Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sash Model</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sash Model</em>' containment reference.
	 * @see #setSashModel(SashModel)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashWindowsMngr_SashModel()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SashModel getSashModel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr#getSashModel <em>Sash Model</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Sash Model</em>' containment reference.
	 * @see #getSashModel()
	 * @generated
	 */
	void setSashModel(SashModel value);

} // SashWindowsMngr
