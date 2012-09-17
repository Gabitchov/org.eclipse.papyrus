/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.services.controlmode.mm.history;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controled Resource</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Represent a Controled Resource.
 * It is a node made of children. The node know its resource URL, and is able to get its children.
 * A child is a Resource controled by this node.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getChildren <em>Children</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getResourceURL <em>Resource URL</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage#getControledResource()
 * @model
 * @generated
 */
public interface ControledResource extends EObject {

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage#getControledResource_Children()
	 * @see org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
	EList<ControledResource> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ControledResource)
	 * @see org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage#getControledResource_Parent()
	 * @see org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getChildren
	 * @model opposite="children" transient="false" ordered="false"
	 * @generated
	 */
	ControledResource getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ControledResource value);

	/**
	 * Returns the value of the '<em><b>Resource URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URL of this ControledResource.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Resource URL</em>' attribute.
	 * @see #setResourceURL(String)
	 * @see org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage#getControledResource_ResourceURL()
	 * @model unique="false" dataType="org.eclipse.papyrus.infra.services.controlmode.mm.history.String" required="true" ordered="false"
	 * @generated
	 */
	String getResourceURL();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource#getResourceURL <em>Resource URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Resource URL</em>' attribute.
	 * @see #getResourceURL()
	 * @generated
	 */
	void setResourceURL(String value);

} // ControledResource
