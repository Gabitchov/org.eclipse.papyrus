/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getRef <em>Ref</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getMatcher <em>Matcher</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenMatcher <em>Gen Matcher</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenHelper <em>Gen Helper</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getSpecializationType()
 * @model
 * @generated
 */
public interface SpecializationType extends ElementType {

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
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getSpecializationType_Ref()
	 * @model
	 * @generated
	 */
	ElementType getRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getRef <em>Ref</em>}' reference.
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
	 * Returns the value of the '<em><b>Matcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Matcher</em>' attribute.
	 * @see #setMatcher(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getSpecializationType_Matcher()
	 * @model
	 * @generated
	 */
	String getMatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getMatcher <em>Matcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Matcher</em>' attribute.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(String value);

	/**
	 * Returns the value of the '<em><b>Gen Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Matcher</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gen Matcher</em>' containment reference.
	 * @see #setGenMatcher(GenMatcher)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getSpecializationType_GenMatcher()
	 * @model containment="true"
	 * @generated
	 */
	GenMatcher getGenMatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenMatcher <em>Gen Matcher</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Gen Matcher</em>' containment reference.
	 * @see #getGenMatcher()
	 * @generated
	 */
	void setGenMatcher(GenMatcher value);

	/**
	 * Returns the value of the '<em><b>Gen Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Helper</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gen Helper</em>' containment reference.
	 * @see #setGenHelper(GenHelper)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getSpecializationType_GenHelper()
	 * @model containment="true"
	 * @generated
	 */
	GenHelper getGenHelper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenHelper <em>Gen Helper</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Gen Helper</em>' containment reference.
	 * @see #getGenHelper()
	 * @generated
	 */
	void setGenHelper(GenHelper value);

} // SpecializationType
