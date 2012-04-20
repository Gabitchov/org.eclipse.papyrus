/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Element Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getIconEntry <em>Icon Entry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getHint <em>Hint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getKindName <em>Kind Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedTypesID <em>Specialized Types ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPreValidation <em>Pre Validation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPreAction <em>Pre Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getPostAction <em>Post Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedDiagramTypeID <em>Specialized Diagram Type ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration()
 * @model
 * @generated
 */
public interface ExtendedElementTypeConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Entry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Entry</em>' containment reference.
	 * @see #setIconEntry(IconEntry)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_IconEntry()
	 * @model containment="true"
	 * @generated
	 */
	IconEntry getIconEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getIconEntry <em>Icon Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Entry</em>' containment reference.
	 * @see #getIconEntry()
	 * @generated
	 */
	void setIconEntry(IconEntry value);

	/**
	 * Returns the value of the '<em><b>Hint</b></em>' attribute.
	 * The default value is <code>"ExtendedElements"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hint</em>' attribute.
	 * @see #setHint(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_Hint()
	 * @model default="ExtendedElements"
	 * @generated
	 */
	String getHint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getHint <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint</em>' attribute.
	 * @see #getHint()
	 * @generated
	 */
	void setHint(String value);

	/**
	 * Returns the value of the '<em><b>Kind Name</b></em>' attribute.
	 * The default value is <code>"org.eclipse.gmf.runtime.emf.type.core.IHintedType"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind Name</em>' attribute.
	 * @see #setKindName(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_KindName()
	 * @model default="org.eclipse.gmf.runtime.emf.type.core.IHintedType"
	 * @generated
	 */
	String getKindName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getKindName <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind Name</em>' attribute.
	 * @see #getKindName()
	 * @generated
	 */
	void setKindName(String value);

	/**
	 * Returns the value of the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Types ID</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialized Types ID</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_SpecializedTypesID()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getSpecializedTypesID();

	/**
	 * Returns the value of the '<em><b>Pre Validation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Validation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Validation</em>' reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_PreValidation()
	 * @model
	 * @generated
	 */
	EList<QueryConfiguration> getPreValidation();

	/**
	 * Returns the value of the '<em><b>Pre Action</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.PreActionConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Action</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_PreAction()
	 * @model containment="true"
	 * @generated
	 */
	EList<PreActionConfiguration> getPreAction();

	/**
	 * Returns the value of the '<em><b>Post Action</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Action</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_PostAction()
	 * @model containment="true"
	 * @generated
	 */
	EList<PostActionConfiguration> getPostAction();

	/**
	 * Returns the value of the '<em><b>Specialized Diagram Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Diagram Type ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialized Diagram Type ID</em>' attribute.
	 * @see #setSpecializedDiagramTypeID(String)
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeConfiguration_SpecializedDiagramTypeID()
	 * @model
	 * @generated
	 */
	String getSpecializedDiagramTypeID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration#getSpecializedDiagramTypeID <em>Specialized Diagram Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialized Diagram Type ID</em>' attribute.
	 * @see #getSpecializedDiagramTypeID()
	 * @generated
	 */
	void setSpecializedDiagramTypeID(String value);

} // ExtendedElementTypeConfiguration
