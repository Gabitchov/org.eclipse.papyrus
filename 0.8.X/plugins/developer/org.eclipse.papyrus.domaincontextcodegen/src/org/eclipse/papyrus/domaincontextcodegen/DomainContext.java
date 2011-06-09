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
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getTypeProjectName <em>Type Project Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getHandlerProjectName <em>Handler Project Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getIClientContextID <em>IClient Context ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMetamodel <em>Metamodel</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getSpecializationOf <em>Specialization Of</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeIDPrefix <em>Element Type ID Prefix</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeNamePrefix <em>Element Type Name Prefix</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes <em>Element Types</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getDefaultHelperPath <em>Default Helper Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getAdvices <em>Advices</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getBindings <em>Bindings</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGenHandlers <em>Gen Handlers</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGeneratedSourceFolder <em>Generated Source Folder</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMenu <em>Menu</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext()
 * @model
 * @generated
 */
public interface DomainContext extends EObject {

	/**
	 * Returns the value of the '<em><b>Type Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Project Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type Project Name</em>' attribute.
	 * @see #setTypeProjectName(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_TypeProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getTypeProjectName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getTypeProjectName <em>Type Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type Project Name</em>' attribute.
	 * @see #getTypeProjectName()
	 * @generated
	 */
	void setTypeProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Handler Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler Project Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Handler Project Name</em>' attribute.
	 * @see #setHandlerProjectName(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_HandlerProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getHandlerProjectName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getHandlerProjectName <em>Handler Project Name</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Handler Project Name</em>' attribute.
	 * @see #getHandlerProjectName()
	 * @generated
	 */
	void setHandlerProjectName(String value);

	/**
	 * Returns the value of the '<em><b>IClient Context ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IClient Context ID</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>IClient Context ID</em>' attribute.
	 * @see #setIClientContextID(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_IClientContextID()
	 * @model
	 * @generated
	 */
	String getIClientContextID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getIClientContextID <em>IClient Context ID</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>IClient Context ID</em>' attribute.
	 * @see #getIClientContextID()
	 * @generated
	 */
	void setIClientContextID(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
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
	 * 
	 * @param value
	 *        the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(EPackage value);

	/**
	 * Returns the value of the '<em><b>Specialization Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialization Of</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Specialization Of</em>' reference.
	 * @see #setSpecializationOf(DomainContext)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_SpecializationOf()
	 * @model
	 * @generated
	 */
	DomainContext getSpecializationOf();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getSpecializationOf <em>Specialization Of</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Specialization Of</em>' reference.
	 * @see #getSpecializationOf()
	 * @generated
	 */
	void setSpecializationOf(DomainContext value);

	/**
	 * Returns the value of the '<em><b>Element Type ID Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type ID Prefix</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type ID Prefix</em>' attribute.
	 * @see #setElementTypeIDPrefix(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ElementTypeIDPrefix()
	 * @model required="true"
	 * @generated
	 */
	String getElementTypeIDPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeIDPrefix <em>Element Type ID Prefix</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Type ID Prefix</em>' attribute.
	 * @see #getElementTypeIDPrefix()
	 * @generated
	 */
	void setElementTypeIDPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Element Type Name Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Name Prefix</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type Name Prefix</em>' attribute.
	 * @see #setElementTypeNamePrefix(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ElementTypeNamePrefix()
	 * @model required="true"
	 * @generated
	 */
	String getElementTypeNamePrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeNamePrefix
	 * <em>Element Type Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Type Name Prefix</em>' attribute.
	 * @see #getElementTypeNamePrefix()
	 * @generated
	 */
	void setElementTypeNamePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Element Types</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Types</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Types</em>' containment reference.
	 * @see #setElementTypes(ElementTypes)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_ElementTypes()
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getDomain
	 * @model opposite="domain" containment="true"
	 * @generated
	 */
	ElementTypes getElementTypes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes <em>Element Types</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Types</em>' containment reference.
	 * @see #getElementTypes()
	 * @generated
	 */
	void setElementTypes(ElementTypes value);

	/**
	 * Returns the value of the '<em><b>Default Helper Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Helper Path</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Helper Path</em>' attribute.
	 * @see #setDefaultHelperPath(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_DefaultHelperPath()
	 * @model required="true"
	 * @generated
	 */
	String getDefaultHelperPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getDefaultHelperPath <em>Default Helper Path</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Default Helper Path</em>' attribute.
	 * @see #getDefaultHelperPath()
	 * @generated
	 */
	void setDefaultHelperPath(String value);

	/**
	 * Returns the value of the '<em><b>Advices</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.Advice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advices</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Advices</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Advices()
	 * @model containment="true"
	 * @generated
	 */
	EList<Advice> getAdvices();

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementTypeBindings> getBindings();

	/**
	 * Returns the value of the '<em><b>Gen Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Handlers</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gen Handlers</em>' containment reference.
	 * @see #setGenHandlers(GenHandlers)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_GenHandlers()
	 * @model containment="true"
	 * @generated
	 */
	GenHandlers getGenHandlers();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGenHandlers <em>Gen Handlers</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Gen Handlers</em>' containment reference.
	 * @see #getGenHandlers()
	 * @generated
	 */
	void setGenHandlers(GenHandlers value);

	/**
	 * Returns the value of the '<em><b>Generated Source Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated Source Folder</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Generated Source Folder</em>' attribute.
	 * @see #setGeneratedSourceFolder(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_GeneratedSourceFolder()
	 * @model required="true"
	 * @generated
	 */
	String getGeneratedSourceFolder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGeneratedSourceFolder <em>Generated Source Folder</em>}
	 * ' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Generated Source Folder</em>' attribute.
	 * @see #getGeneratedSourceFolder()
	 * @generated
	 */
	void setGeneratedSourceFolder(String value);

	/**
	 * Returns the value of the '<em><b>Menu</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Menu</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Menu()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuDeclaration> getMenu();

	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Command</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getDomainContext_Command()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommandDeclaration> getCommand();

} // DomainContext
