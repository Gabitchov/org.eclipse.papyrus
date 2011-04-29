/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.extendedtypes.uml.applystereotypeactionconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.extendedtypes.PostActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Stereotype Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.extendedtypes.uml.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration#getStereotypesToApply <em>Stereotypes To Apply</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.extendedtypes.uml.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getApplyStereotypeActionConfiguration()
 * @model
 * @generated
 */
public interface ApplyStereotypeActionConfiguration extends PostActionConfiguration {
	/**
	 * Returns the value of the '<em><b>Stereotypes To Apply</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.extendedtypes.uml.applystereotypeactionconfiguration.StereotypeToApply}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes To Apply</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes To Apply</em>' containment reference list.
	 * @see org.eclipse.papyrus.extendedtypes.uml.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getApplyStereotypeActionConfiguration_StereotypesToApply()
	 * @model containment="true"
	 * @generated
	 */
	EList<StereotypeToApply> getStereotypesToApply();

} // ApplyStereotypeActionConfiguration
