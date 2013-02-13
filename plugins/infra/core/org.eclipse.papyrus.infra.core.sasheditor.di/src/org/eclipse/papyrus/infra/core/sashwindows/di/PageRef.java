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
 * A representation of the model object '<em><b>Page Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getEmfPageIdentifier <em>Emf Page Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getPageIdentifier <em>Page Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getObjectPageIdentifier <em>Object Page Identifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageRef()
 * @model
 * @generated
 */
public interface PageRef extends EObject {

	/**
	 * Returns the value of the '<em><b>Emf Page Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emf Page Identifier</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emf Page Identifier</em>' reference.
	 * @see #setEmfPageIdentifier(EObject)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageRef_EmfPageIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getEmfPageIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getEmfPageIdentifier <em>Emf Page Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emf Page Identifier</em>' reference.
	 * @see #getEmfPageIdentifier()
	 * @generated
	 */
	void setEmfPageIdentifier(EObject value);

	/**
	 * Returns the value of the '<em><b>Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * pageIdentifier can be a plain JavaObject or an EObject.
	 * They are not stored in the same place.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Identifier</em>' attribute.
	 * @see #setPageIdentifier(Object)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageRef_PageIdentifier()
	 * @model unique="false" dataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Object getPageIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getPageIdentifier <em>Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Identifier</em>' attribute.
	 * @see #getPageIdentifier()
	 * @generated
	 */
	void setPageIdentifier(Object value);

	/**
	 * Returns the value of the '<em><b>Object Page Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Storage to store Identifier that are not EObject.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object Page Identifier</em>' attribute.
	 * @see #setObjectPageIdentifier(Object)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageRef_ObjectPageIdentifier()
	 * @model unique="false" dataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" required="true" ordered="false"
	 * @generated
	 */
	Object getObjectPageIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getObjectPageIdentifier <em>Object Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Page Identifier</em>' attribute.
	 * @see #getObjectPageIdentifier()
	 * @generated
	 */
	void setObjectPageIdentifier(Object value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TabFolder)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPageRef_Parent()
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder#getChildren
	 * @model opposite="children" transient="false" ordered="false"
	 * @generated
	 */
	TabFolder getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getParent <em>Parent</em>}' container reference.
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
	 * @model dataType="org.eclipse.papyrus.infra.core.sashwindows.di.boolean" required="true" ordered="false" pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	boolean isForIdentifier(Object pageIdentifier);

} // PageRef
