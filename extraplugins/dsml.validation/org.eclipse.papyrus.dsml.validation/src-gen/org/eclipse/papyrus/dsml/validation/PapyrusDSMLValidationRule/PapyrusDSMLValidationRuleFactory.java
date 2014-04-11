/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage
 * @generated
 */
public interface PapyrusDSMLValidationRuleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusDSMLValidationRuleFactory eINSTANCE = org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRuleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Validation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validation Rule</em>'.
	 * @generated
	 */
	ValidationRule createValidationRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PapyrusDSMLValidationRulePackage getPapyrusDSMLValidationRulePackage();

} //PapyrusDSMLValidationRuleFactory
