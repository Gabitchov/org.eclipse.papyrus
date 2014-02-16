/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime Values Edition Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration#getViewsToDisplay <em>Views To Display</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage#getRuntimeValuesEditionActionConfiguration()
 * @model
 * @generated
 */
public interface RuntimeValuesEditionActionConfiguration extends SemanticActionConfiguration {
	/**
	 * Returns the value of the '<em><b>Views To Display</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views To Display</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views To Display</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage#getRuntimeValuesEditionActionConfiguration_ViewsToDisplay()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewToDisplay> getViewsToDisplay();

} // RuntimeValuesEditionActionConfiguration
