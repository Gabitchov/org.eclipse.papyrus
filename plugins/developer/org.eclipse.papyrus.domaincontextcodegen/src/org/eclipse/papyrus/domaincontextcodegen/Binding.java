/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getOwner <em>Owner</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding()
 * @model abstract="true"
 * @generated
 */
public interface Binding extends EObject {

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(ElementTypeBindings)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding_Owner()
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getBindings
	 * @model opposite="bindings" required="true" transient="false"
	 * @generated
	 */
	ElementTypeBindings getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ElementTypeBindings value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // Binding
