/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.design.profile.architecture;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getParentFolder <em>Parent Folder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getOriginalParentFolder <em>Original Parent Folder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#isDeprecated <em>Is Deprecated</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getDeprecatedComment <em>Deprecated Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin()
 * @model
 * @generated
 */
public interface Plugin extends Element {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     An alternative name to be used in place of the stereotyped element's name.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The name of the parent folder that will contain the layer, if any.
	 * </p>
	 * <p>
	 *     If no parent is specified, the layer is 'virtual' (no corresponding physical folder)
	 * </p>
	 * <p>
	 *     Ex: plugins
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent Folder</em>' attribute.
	 * @see #setParentFolder(String)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_ParentFolder()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getParentFolder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getParentFolder <em>Parent Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Folder</em>' attribute.
	 * @see #getParentFolder()
	 * @generated
	 */
	void setParentFolder(String value);

	/**
	 * Returns the value of the '<em><b>Original Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The name of the parent folder that was containing the layer before the refactoring, if any.
	 * </p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Original Parent Folder</em>' attribute.
	 * @see #setOriginalParentFolder(String)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_OriginalParentFolder()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getOriginalParentFolder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getOriginalParentFolder <em>Original Parent Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Parent Folder</em>' attribute.
	 * @see #getOriginalParentFolder()
	 * @generated
	 */
	void setOriginalParentFolder(String value);

	/**
	 * Returns the value of the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Deprecated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Deprecated</em>' attribute.
	 * @see #setIsDeprecated(boolean)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_IsDeprecated()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#isDeprecated <em>Is Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Deprecated</em>' attribute.
	 * @see #isDeprecated()
	 * @generated
	 */
	void setIsDeprecated(boolean value);

	/**
	 * Returns the value of the '<em><b>Deprecated Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     A comment associated to the isDeprecated=true
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deprecated Comment</em>' attribute.
	 * @see #setDeprecatedComment(String)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_DeprecatedComment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDeprecatedComment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getDeprecatedComment <em>Deprecated Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated Comment</em>' attribute.
	 * @see #getDeprecatedComment()
	 * @generated
	 */
	void setDeprecatedComment(String value);

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referent</em>' attribute.
	 * @see #setReferent(String)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_Referent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getReferent <em>Referent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' attribute.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(String value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getPlugin_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.Plugin#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // Plugin
