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
 * A representation of the model object '<em><b>Element Types</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getTypes <em>Types</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypes()
 * @model
 * @generated
 */
public interface ElementTypes extends EObject {

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.ElementType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypes_Types()
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ElementType> getTypes();

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes <em>Element Types</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Domain</em>' container reference.
	 * @see #setDomain(DomainContext)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypes_Domain()
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes
	 * @model opposite="elementTypes" transient="false"
	 * @generated
	 */
	DomainContext getDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getDomain <em>Domain</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Domain</em>' container reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(DomainContext value);

} // ElementTypes
