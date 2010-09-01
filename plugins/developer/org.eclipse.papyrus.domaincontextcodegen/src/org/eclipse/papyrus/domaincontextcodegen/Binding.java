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
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getAdvice <em>Advice</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getElementTypePattern <em>Element Type Pattern</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getAdviceID <em>Advice ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends EObject {
	/**
	 * Returns the value of the '<em><b>Advice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice</em>' reference.
	 * @see #setAdvice(AdviceBinding)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding_Advice()
	 * @model
	 * @generated
	 */
	AdviceBinding getAdvice();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getAdvice <em>Advice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice</em>' reference.
	 * @see #getAdvice()
	 * @generated
	 */
	void setAdvice(AdviceBinding value);

	/**
	 * Returns the value of the '<em><b>Element Type Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Pattern</em>' attribute.
	 * @see #setElementTypePattern(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding_ElementTypePattern()
	 * @model
	 * @generated
	 */
	String getElementTypePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getElementTypePattern <em>Element Type Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Pattern</em>' attribute.
	 * @see #getElementTypePattern()
	 * @generated
	 */
	void setElementTypePattern(String value);

	/**
	 * Returns the value of the '<em><b>Advice ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice ID</em>' attribute.
	 * @see #setAdviceID(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getBinding_AdviceID()
	 * @model
	 * @generated
	 */
	String getAdviceID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getAdviceID <em>Advice ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice ID</em>' attribute.
	 * @see #getAdviceID()
	 * @generated
	 */
	void setAdviceID(String value);

} // Binding
