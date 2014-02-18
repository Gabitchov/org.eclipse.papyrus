/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage
 * @generated
 */
public interface RuntimeValuesEditionActionConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimeValuesEditionActionConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Runtime Values Edition Action Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Runtime Values Edition Action Configuration</em>'.
	 * @generated
	 */
	RuntimeValuesEditionActionConfiguration createRuntimeValuesEditionActionConfiguration();

	/**
	 * Returns a new object of class '<em>View To Display</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View To Display</em>'.
	 * @generated
	 */
	ViewToDisplay createViewToDisplay();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RuntimeValuesEditionActionConfigurationPackage getRuntimeValuesEditionActionConfigurationPackage();

} //RuntimeValuesEditionActionConfigurationFactory
