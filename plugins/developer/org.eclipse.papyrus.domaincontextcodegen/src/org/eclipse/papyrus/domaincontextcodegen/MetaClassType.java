/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Class Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType#getMetaClass <em>Meta Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getMetaClassType()
 * @model
 * @generated
 */
public interface MetaClassType extends ElementType {

	/**
	 * Returns the value of the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Meta Class</em>' reference.
	 * @see #setMetaClass(EClass)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getMetaClassType_MetaClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getMetaClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType#getMetaClass <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Meta Class</em>' reference.
	 * @see #getMetaClass()
	 * @generated
	 */
	void setMetaClass(EClass value);

} // MetaClassType
