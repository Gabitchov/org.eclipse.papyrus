/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype To Apply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#isUpdateName <em>Update Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getRequiredProfiles <em>Required Profiles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getFeaturesToSet <em>Features To Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getStereotypeToApply()
 * @model
 * @generated
 */
public interface StereotypeToApply extends EObject {
	/**
	 * Returns the value of the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Qualified Name</em>' attribute.
	 * @see #setStereotypeQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getStereotypeToApply_StereotypeQualifiedName()
	 * @model
	 * @generated
	 */
	String getStereotypeQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Qualified Name</em>' attribute.
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 */
	void setStereotypeQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Update Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Name</em>' attribute.
	 * @see #setUpdateName(boolean)
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getStereotypeToApply_UpdateName()
	 * @model
	 * @generated
	 */
	boolean isUpdateName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#isUpdateName <em>Update Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Name</em>' attribute.
	 * @see #isUpdateName()
	 * @generated
	 */
	void setUpdateName(boolean value);

	/**
	 * Returns the value of the '<em><b>Required Profiles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Profiles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Profiles</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getStereotypeToApply_RequiredProfiles()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getRequiredProfiles();

	/**
	 * Returns the value of the '<em><b>Features To Set</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features To Set</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features To Set</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getStereotypeToApply_FeaturesToSet()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureToSet> getFeaturesToSet();

} // StereotypeToApply
