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
 * A representation of the model object '<em><b>Advice Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdvicePath <em>Advice Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdviceID <em>Advice ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getInheritance <em>Inheritance</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeRef <em>Element Type Ref</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeIDref <em>Element Type IDref</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdviceBinding()
 * @model
 * @generated
 */
public interface AdviceBinding extends EObject {

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
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdviceBinding_AdvicePath()
	 * @model
	 * @generated
	 */
	String getAdvicePath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdvicePath <em>Advice Path</em>}' attribute.
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
	 * Returns the value of the '<em><b>Advice ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice ID</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Advice ID</em>' attribute.
	 * @see #setAdviceID(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdviceBinding_AdviceID()
	 * @model
	 * @generated
	 */
	String getAdviceID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdviceID <em>Advice ID</em>}' attribute.
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
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdviceBinding_Inheritance()
	 * @model
	 * @generated
	 */
	InheritanceKind getInheritance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getInheritance <em>Inheritance</em>}' attribute.
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

	/**
	 * Returns the value of the '<em><b>Element Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Ref</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type Ref</em>' reference.
	 * @see #setElementTypeRef(ElementType)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdviceBinding_ElementTypeRef()
	 * @model
	 * @generated
	 */
	ElementType getElementTypeRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeRef <em>Element Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Type Ref</em>' reference.
	 * @see #getElementTypeRef()
	 * @generated
	 */
	void setElementTypeRef(ElementType value);

	/**
	 * Returns the value of the '<em><b>Element Type IDref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type IDref</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type IDref</em>' attribute.
	 * @see #setElementTypeIDref(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getAdviceBinding_ElementTypeIDref()
	 * @model
	 * @generated
	 */
	String getElementTypeIDref();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeIDref <em>Element Type IDref</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Type IDref</em>' attribute.
	 * @see #getElementTypeIDref()
	 * @generated
	 */
	void setElementTypeIDref(String value);

} // AdviceBinding
