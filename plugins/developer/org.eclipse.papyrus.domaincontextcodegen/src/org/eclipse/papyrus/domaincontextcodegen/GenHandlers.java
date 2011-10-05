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
 * A representation of the model object '<em><b>Gen Handlers</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getHandlerPackage <em>Handler Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClass <em>Super Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClassPackage <em>Super Class Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumerator <em>Element Type Enumerator</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumeratorPackage <em>Element Type Enumerator Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getVisibleCreateChildHandlers <em>Visible Create Child Handlers</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getParentDomainCreateChild <em>Parent Domain Create Child</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getCreateChildMenuLocationURI <em>Create Child Menu Location URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers()
 * @model
 * @generated
 */
public interface GenHandlers extends EObject {

	/**
	 * Returns the value of the '<em><b>Handler Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler Package</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Handler Package</em>' attribute.
	 * @see #setHandlerPackage(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_HandlerPackage()
	 * @model
	 * @generated
	 */
	String getHandlerPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getHandlerPackage <em>Handler Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Handler Package</em>' attribute.
	 * @see #getHandlerPackage()
	 * @generated
	 */
	void setHandlerPackage(String value);

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Class</em>' attribute.
	 * @see #setSuperClass(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_SuperClass()
	 * @model
	 * @generated
	 */
	String getSuperClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClass <em>Super Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Super Class</em>' attribute.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(String value);

	/**
	 * Returns the value of the '<em><b>Super Class Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Package</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Super Class Package</em>' attribute.
	 * @see #setSuperClassPackage(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_SuperClassPackage()
	 * @model
	 * @generated
	 */
	String getSuperClassPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClassPackage <em>Super Class Package</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Super Class Package</em>' attribute.
	 * @see #getSuperClassPackage()
	 * @generated
	 */
	void setSuperClassPackage(String value);

	/**
	 * Returns the value of the '<em><b>Element Type Enumerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Enumerator</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type Enumerator</em>' attribute.
	 * @see #setElementTypeEnumerator(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_ElementTypeEnumerator()
	 * @model
	 * @generated
	 */
	String getElementTypeEnumerator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumerator <em>Element Type Enumerator</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Type Enumerator</em>' attribute.
	 * @see #getElementTypeEnumerator()
	 * @generated
	 */
	void setElementTypeEnumerator(String value);

	/**
	 * Returns the value of the '<em><b>Element Type Enumerator Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Enumerator Package</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element Type Enumerator Package</em>' attribute.
	 * @see #setElementTypeEnumeratorPackage(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_ElementTypeEnumeratorPackage()
	 * @model
	 * @generated
	 */
	String getElementTypeEnumeratorPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumeratorPackage
	 * <em>Element Type Enumerator Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Element Type Enumerator Package</em>' attribute.
	 * @see #getElementTypeEnumeratorPackage()
	 * @generated
	 */
	void setElementTypeEnumeratorPackage(String value);

	/**
	 * Returns the value of the '<em><b>Visible Create Child Handlers</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.ElementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Create Child Handlers</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Visible Create Child Handlers</em>' reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_VisibleCreateChildHandlers()
	 * @model
	 * @generated
	 */
	EList<ElementType> getVisibleCreateChildHandlers();

	/**
	 * Returns the value of the '<em><b>Parent Domain Create Child</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.ElementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Domain Create Child</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Domain Create Child</em>' reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_ParentDomainCreateChild()
	 * @model
	 * @generated
	 */
	EList<ElementType> getParentDomainCreateChild();

	/**
	 * Returns the value of the '<em><b>Create Child Menu Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Child Menu Location URI</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Create Child Menu Location URI</em>' attribute.
	 * @see #setCreateChildMenuLocationURI(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getGenHandlers_CreateChildMenuLocationURI()
	 * @model
	 * @generated
	 */
	String getCreateChildMenuLocationURI();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getCreateChildMenuLocationURI
	 * <em>Create Child Menu Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Create Child Menu Location URI</em>' attribute.
	 * @see #getCreateChildMenuLocationURI()
	 * @generated
	 */
	void setCreateChildMenuLocationURI(String value);

} // GenHandlers
