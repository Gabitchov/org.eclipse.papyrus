/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modify Semantic Values Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration#getFeaturesToSet <em>Features To Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage#getModifySemanticValuesActionConfiguration()
 * @model
 * @generated
 */
public interface ModifySemanticValuesActionConfiguration extends PostActionConfiguration {
	/**
	 * Returns the value of the '<em><b>Features To Set</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features To Set</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features To Set</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage#getModifySemanticValuesActionConfiguration_FeaturesToSet()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureToSet> getFeaturesToSet();

} // ModifySemanticValuesActionConfiguration
