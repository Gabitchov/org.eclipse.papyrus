/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRuleFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusDSMLValidationRulePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PapyrusDSMLValidationRule";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/dsmlvalidation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PapyrusDSMLValidationRule";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusDSMLValidationRulePackage eINSTANCE = org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl <em>Validation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl#getValidationRule()
	 * @generated
	 */
	int VALIDATION_RULE = 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__SEVERITY = 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__MODE = 1;

	/**
	 * The feature id for the '<em><b>Is Enabled By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__IS_ENABLED_BY_DEFAULT = 2;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__BASE_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Status Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__STATUS_CODE = 4;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__MESSAGE = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__TARGET = 7;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__CLASS = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE__ID = 9;

	/**
	 * The number of structural features of the '<em>Validation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Validation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity <em>Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode <em>Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl#getMode()
	 * @generated
	 */
	int MODE = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule <em>Validation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation Rule</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule
	 * @generated
	 */
	EClass getValidationRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getSeverity()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMode()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#isEnabledByDefault <em>Is Enabled By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enabled By Default</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#isEnabledByDefault()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_IsEnabledByDefault();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getBase_Constraint()
	 * @see #getValidationRule()
	 * @generated
	 */
	EReference getValidationRule_Base_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getStatusCode <em>Status Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Code</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getStatusCode()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_StatusCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMessage()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getDescription()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Description();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Target</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getTarget()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getClass_()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getId()
	 * @see #getValidationRule()
	 * @generated
	 */
	EAttribute getValidationRule_Id();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mode</em>'.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode
	 * @generated
	 */
	EEnum getMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrusDSMLValidationRuleFactory getPapyrusDSMLValidationRuleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl <em>Validation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.ValidationRuleImpl
		 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl#getValidationRule()
		 * @generated
		 */
		EClass VALIDATION_RULE = eINSTANCE.getValidationRule();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__SEVERITY = eINSTANCE.getValidationRule_Severity();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__MODE = eINSTANCE.getValidationRule_Mode();

		/**
		 * The meta object literal for the '<em><b>Is Enabled By Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__IS_ENABLED_BY_DEFAULT = eINSTANCE.getValidationRule_IsEnabledByDefault();

		/**
		 * The meta object literal for the '<em><b>Base Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_RULE__BASE_CONSTRAINT = eINSTANCE.getValidationRule_Base_Constraint();

		/**
		 * The meta object literal for the '<em><b>Status Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__STATUS_CODE = eINSTANCE.getValidationRule_StatusCode();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__MESSAGE = eINSTANCE.getValidationRule_Message();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__DESCRIPTION = eINSTANCE.getValidationRule_Description();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__TARGET = eINSTANCE.getValidationRule_Target();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__CLASS = eINSTANCE.getValidationRule_Class();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_RULE__ID = eINSTANCE.getValidationRule_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity <em>Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity
		 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode <em>Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode
		 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.impl.PapyrusDSMLValidationRulePackageImpl#getMode()
		 * @generated
		 */
		EEnum MODE = eINSTANCE.getMode();

	}

} //PapyrusDSMLValidationRulePackage
