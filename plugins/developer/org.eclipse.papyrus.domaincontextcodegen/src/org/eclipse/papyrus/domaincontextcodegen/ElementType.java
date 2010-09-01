/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getMetaClass <em>Meta Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecificName <em>Specific Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getEdithelper_EditHelperAdvicePath <em>Edithelper Edit Helper Advice Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationof <em>Specializationof</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationIDof <em>Specialization IDof</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType()
 * @model
 * @generated
 */
public interface ElementType extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Class</em>' reference.
	 * @see #setMetaClass(EClass)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType_MetaClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getMetaClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getMetaClass <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Class</em>' reference.
	 * @see #getMetaClass()
	 * @generated
	 */
	void setMetaClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Specific Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Name</em>' attribute.
	 * @see #setSpecificName(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType_SpecificName()
	 * @model
	 * @generated
	 */
	String getSpecificName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecificName <em>Specific Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific Name</em>' attribute.
	 * @see #getSpecificName()
	 * @generated
	 */
	void setSpecificName(String value);

	/**
	 * Returns the value of the '<em><b>Edithelper Edit Helper Advice Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edithelper Edit Helper Advice Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edithelper Edit Helper Advice Path</em>' attribute.
	 * @see #setEdithelper_EditHelperAdvicePath(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType_Edithelper_EditHelperAdvicePath()
	 * @model
	 * @generated
	 */
	String getEdithelper_EditHelperAdvicePath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getEdithelper_EditHelperAdvicePath <em>Edithelper Edit Helper Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edithelper Edit Helper Advice Path</em>' attribute.
	 * @see #getEdithelper_EditHelperAdvicePath()
	 * @generated
	 */
	void setEdithelper_EditHelperAdvicePath(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Specializationof</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializationof</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializationof</em>' reference.
	 * @see #setSpecializationof(ElementType)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType_Specializationof()
	 * @model
	 * @generated
	 */
	ElementType getSpecializationof();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationof <em>Specializationof</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specializationof</em>' reference.
	 * @see #getSpecializationof()
	 * @generated
	 */
	void setSpecializationof(ElementType value);

	/**
	 * Returns the value of the '<em><b>Specialization IDof</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialization IDof</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization IDof</em>' attribute.
	 * @see #setSpecializationIDof(String)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementType_SpecializationIDof()
	 * @model
	 * @generated
	 */
	String getSpecializationIDof();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationIDof <em>Specialization IDof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialization IDof</em>' attribute.
	 * @see #getSpecializationIDof()
	 * @generated
	 */
	void setSpecializationIDof(String value);

} // ElementType
