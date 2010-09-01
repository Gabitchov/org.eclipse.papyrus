/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getIClientContextID <em>IClient Context ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getSpecializationOf <em>Specialization Of</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeIDPrefix <em>Element Type ID Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeNamePrefix <em>Element Type Name Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMatcherPatch <em>Matcher Patch</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes <em>Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getDefaultHelperPath <em>Default Helper Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getAdvicebindings <em>Advicebindings</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext()
 * @model
 * @generated
 */
public interface DomainContext extends EObject {
	/**
	 * Returns the value of the '<em><b>IClient Context ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IClient Context ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IClient Context ID</em>' attribute.
	 * @see #setIClientContextID(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_IClientContextID()
	 * @model
	 * @generated
	 */
	String getIClientContextID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getIClientContextID <em>IClient Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IClient Context ID</em>' attribute.
	 * @see #getIClientContextID()
	 * @generated
	 */
	void setIClientContextID(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(EPackage)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(EPackage value);

	/**
	 * Returns the value of the '<em><b>Specialization Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialization Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization Of</em>' reference.
	 * @see #setSpecializationOf(DomainContext)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_SpecializationOf()
	 * @model
	 * @generated
	 */
	DomainContext getSpecializationOf();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getSpecializationOf <em>Specialization Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialization Of</em>' reference.
	 * @see #getSpecializationOf()
	 * @generated
	 */
	void setSpecializationOf(DomainContext value);

	/**
	 * Returns the value of the '<em><b>Element Type ID Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type ID Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type ID Prefix</em>' attribute.
	 * @see #setElementTypeIDPrefix(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ElementTypeIDPrefix()
	 * @model required="true"
	 * @generated
	 */
	String getElementTypeIDPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeIDPrefix <em>Element Type ID Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type ID Prefix</em>' attribute.
	 * @see #getElementTypeIDPrefix()
	 * @generated
	 */
	void setElementTypeIDPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Element Type Name Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Name Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Name Prefix</em>' attribute.
	 * @see #setElementTypeNamePrefix(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ElementTypeNamePrefix()
	 * @model required="true"
	 * @generated
	 */
	String getElementTypeNamePrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeNamePrefix <em>Element Type Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Name Prefix</em>' attribute.
	 * @see #getElementTypeNamePrefix()
	 * @generated
	 */
	void setElementTypeNamePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Matcher Patch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher Patch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher Patch</em>' attribute.
	 * @see #setMatcherPatch(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_MatcherPatch()
	 * @model required="true"
	 * @generated
	 */
	String getMatcherPatch();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMatcherPatch <em>Matcher Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher Patch</em>' attribute.
	 * @see #getMatcherPatch()
	 * @generated
	 */
	void setMatcherPatch(String value);

	/**
	 * Returns the value of the '<em><b>Element Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.ElementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ElementTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementType> getElementTypes();

	/**
	 * Returns the value of the '<em><b>Default Helper Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Helper Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Helper Path</em>' attribute.
	 * @see #setDefaultHelperPath(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_DefaultHelperPath()
	 * @model required="true"
	 * @generated
	 */
	String getDefaultHelperPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getDefaultHelperPath <em>Default Helper Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Helper Path</em>' attribute.
	 * @see #getDefaultHelperPath()
	 * @generated
	 */
	void setDefaultHelperPath(String value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Advicebindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advicebindings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advicebindings</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Advicebindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<AdviceBinding> getAdvicebindings();

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.Binding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Binding> getBindings();

} // DomainContext
