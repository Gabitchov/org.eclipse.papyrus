/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.design.profile.architecture;

import org.eclipse.uml2.uml.Dependency;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     A dependency between two layers.
 * </p>
 * <p>
 *     This dependency is computed from the dependencies of internal layer or packages.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#isDeprecated <em>Is Deprecated</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#getDeprecatedComment <em>Deprecated Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#getBase_Dependency <em>Base Dependency</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getLayerDependency()
 * @model
 * @generated
 */
public interface LayerDependency extends Element {

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
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getLayerDependency_IsDeprecated()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#isDeprecated <em>Is Deprecated</em>}' attribute.
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
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getLayerDependency_DeprecatedComment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDeprecatedComment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#getDeprecatedComment <em>Deprecated Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated Comment</em>' attribute.
	 * @see #getDeprecatedComment()
	 * @generated
	 */
	void setDeprecatedComment(String value);

	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage#getLayerDependency_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);
} // LayerDependency
