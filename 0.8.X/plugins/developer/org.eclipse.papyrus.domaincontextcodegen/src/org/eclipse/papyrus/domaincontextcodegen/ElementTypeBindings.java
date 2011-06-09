/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type Bindings</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getClientContextID <em>Client Context ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypeBindings()
 * @model
 * @generated
 */
public interface ElementTypeBindings extends EObject {

	/**
	 * Returns the value of the '<em><b>Client Context ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Context ID</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Client Context ID</em>' attribute.
	 * @see #setClientContextID(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypeBindings_ClientContextID()
	 * @model
	 * @generated
	 */
	String getClientContextID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getClientContextID <em>Client Context ID</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Client Context ID</em>' attribute.
	 * @see #getClientContextID()
	 * @generated
	 */
	void setClientContextID(String value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.Binding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypeBindings_Bindings()
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Binding> getBindings();

} // ElementTypeBindings
