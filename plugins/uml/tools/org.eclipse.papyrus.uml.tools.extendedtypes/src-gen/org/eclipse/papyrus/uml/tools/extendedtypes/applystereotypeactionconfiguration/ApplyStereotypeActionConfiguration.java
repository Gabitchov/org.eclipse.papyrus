/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Stereotype Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration#getStereotypesToApply <em>Stereotypes To Apply</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getApplyStereotypeActionConfiguration()
 * @model
 * @generated
 */
public interface ApplyStereotypeActionConfiguration extends SemanticActionConfiguration {
	/**
	 * Returns the value of the '<em><b>Stereotypes To Apply</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes To Apply</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes To Apply</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getApplyStereotypeActionConfiguration_StereotypesToApply()
	 * @model containment="true"
	 * @generated
	 */
	EList<StereotypeToApply> getStereotypesToApply();

} // ApplyStereotypeActionConfiguration
