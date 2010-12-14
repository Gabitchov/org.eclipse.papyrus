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
 * A representation of the model object '<em><b>Advice</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getAdviceID <em>Advice ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getRef <em>Ref</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getAdvicePath <em>Advice Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdvice()
 * @model
 * @generated
 */
public interface Advice extends EObject {

	/**
	 * Returns the value of the '<em><b>Advice ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice ID</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Advice ID</em>' attribute.
	 * @see #setAdviceID(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdvice_AdviceID()
	 * @model
	 * @generated
	 */
	String getAdviceID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getAdviceID <em>Advice ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Advice ID</em>' attribute.
	 * @see #getAdviceID()
	 * @generated
	 */
	void setAdviceID(String value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(ElementType)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdvice_Ref()
	 * @model
	 * @generated
	 */
	ElementType getRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(ElementType value);

	/**
	 * Returns the value of the '<em><b>Advice Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice Path</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Advice Path</em>' attribute.
	 * @see #setAdvicePath(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdvice_AdvicePath()
	 * @model
	 * @generated
	 */
	String getAdvicePath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getAdvicePath <em>Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Advice Path</em>' attribute.
	 * @see #getAdvicePath()
	 * @generated
	 */
	void setAdvicePath(String value);

	/**
	 * Returns the value of the '<em><b>Inheritance</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.domaincontextcodegen.InheritanceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Inheritance</em>' attribute.
	 * @see org.eclipse.papyrus.domaincontextcodegen.InheritanceKind
	 * @see #setInheritance(InheritanceKind)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdvice_Inheritance()
	 * @model
	 * @generated
	 */
	InheritanceKind getInheritance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getInheritance <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Inheritance</em>' attribute.
	 * @see org.eclipse.papyrus.domaincontextcodegen.InheritanceKind
	 * @see #getInheritance()
	 * @generated
	 */
	void setInheritance(InheritanceKind value);

} // Advice
