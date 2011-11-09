/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfigurationPackage
 * @generated
 */
public interface ModifySemanticValuesActionConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifySemanticValuesActionConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl.ModifySemanticValuesActionConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modify Semantic Values Action Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modify Semantic Values Action Configuration</em>'.
	 * @generated
	 */
	ModifySemanticValuesActionConfiguration createModifySemanticValuesActionConfiguration();

	/**
	 * Returns a new object of class '<em>Feature To Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature To Set</em>'.
	 * @generated
	 */
	FeatureToSet createFeatureToSet();

	/**
	 * Returns a new object of class '<em>Dynamic Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Value</em>'.
	 * @generated
	 */
	DynamicValue createDynamicValue();

	/**
	 * Returns a new object of class '<em>Constant Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Value</em>'.
	 * @generated
	 */
	ConstantValue createConstantValue();

	/**
	 * Returns a new object of class '<em>List Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Value</em>'.
	 * @generated
	 */
	ListValue createListValue();

	/**
	 * Returns a new object of class '<em>Query Execution Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Execution Value</em>'.
	 * @generated
	 */
	QueryExecutionValue createQueryExecutionValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModifySemanticValuesActionConfigurationPackage getModifySemanticValuesActionConfigurationPackage();

} //ModifySemanticValuesActionConfigurationFactory
