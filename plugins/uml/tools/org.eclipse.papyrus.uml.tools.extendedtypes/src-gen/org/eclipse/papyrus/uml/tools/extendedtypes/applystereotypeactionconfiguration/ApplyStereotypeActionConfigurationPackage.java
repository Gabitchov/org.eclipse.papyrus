/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ApplyStereotypeActionConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "applystereotypeactionconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/extendedtypes/uml/applystereotypeaction/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "applystereotypeactionconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplyStereotypeActionConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl <em>Apply Stereotype Action Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getApplyStereotypeActionConfiguration()
	 * @generated
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__NAME = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__DESCRIPTION = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__IDENTIFIER = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__ICON_ENTRY = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Stereotypes To Apply</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Apply Stereotype Action Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_STEREOTYPE_ACTION_CONFIGURATION_FEATURE_COUNT = ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl <em>Stereotype To Apply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getStereotypeToApply()
	 * @generated
	 */
	int STEREOTYPE_TO_APPLY = 1;

	/**
	 * The feature id for the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Update Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__UPDATE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Required Profiles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__REQUIRED_PROFILES = 2;

	/**
	 * The feature id for the '<em><b>Features To Set</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY__FEATURES_TO_SET = 3;

	/**
	 * The number of structural features of the '<em>Stereotype To Apply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_TO_APPLY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl <em>Feature To Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getFeatureToSet()
	 * @generated
	 */
	int FEATURE_TO_SET = 2;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET__FEATURE_NAME = 0;

	/**
	 * The feature id for the '<em><b>At Runtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET__AT_RUNTIME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Feature To Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TO_SET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureValueImpl <em>Feature Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureValueImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getFeatureValue()
	 * @generated
	 */
	int FEATURE_VALUE = 3;

	/**
	 * The number of structural features of the '<em>Feature Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ListValueImpl <em>List Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ListValueImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getListValue()
	 * @generated
	 */
	int LIST_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__VALUES = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ConstantValueImpl <em>Constant Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ConstantValueImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getConstantValue()
	 * @generated
	 */
	int CONSTANT_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE__VALUE_INSTANCE = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.DynamicValueImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getDynamicValue()
	 * @generated
	 */
	int DYNAMIC_VALUE = 6;

	/**
	 * The number of structural features of the '<em>Dynamic Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VALUE_FEATURE_COUNT = FEATURE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.QueryExecutionValueImpl
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getQueryExecutionValue()
	 * @generated
	 */
	int QUERY_EXECUTION_VALUE = 7;

	/**
	 * The number of structural features of the '<em>Query Execution Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_EXECUTION_VALUE_FEATURE_COUNT = DYNAMIC_VALUE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration <em>Apply Stereotype Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apply Stereotype Action Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration
	 * @generated
	 */
	EClass getApplyStereotypeActionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration#getStereotypesToApply <em>Stereotypes To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotypes To Apply</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration#getStereotypesToApply()
	 * @see #getApplyStereotypeActionConfiguration()
	 * @generated
	 */
	EReference getApplyStereotypeActionConfiguration_StereotypesToApply();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply <em>Stereotype To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype To Apply</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply
	 * @generated
	 */
	EClass getStereotypeToApply();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getStereotypeQualifiedName()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EAttribute getStereotypeToApply_StereotypeQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#isUpdateName <em>Update Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Update Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#isUpdateName()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EAttribute getStereotypeToApply_UpdateName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getRequiredProfiles <em>Required Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Required Profiles</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getRequiredProfiles()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EAttribute getStereotypeToApply_RequiredProfiles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getFeaturesToSet <em>Features To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features To Set</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply#getFeaturesToSet()
	 * @see #getStereotypeToApply()
	 * @generated
	 */
	EReference getStereotypeToApply_FeaturesToSet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet <em>Feature To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature To Set</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet
	 * @generated
	 */
	EClass getFeatureToSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet#getFeatureName()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EAttribute getFeatureToSet_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet#isAtRuntime <em>At Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Runtime</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet#isAtRuntime()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EAttribute getFeatureToSet_AtRuntime();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet#getValue()
	 * @see #getFeatureToSet()
	 * @generated
	 */
	EReference getFeatureToSet_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue <em>Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Value</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue
	 * @generated
	 */
	EClass getFeatureValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Value</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue
	 * @generated
	 */
	EClass getListValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue#getValues()
	 * @see #getListValue()
	 * @generated
	 */
	EReference getListValue_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Value</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue
	 * @generated
	 */
	EClass getConstantValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue#getValueInstance <em>Value Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Instance</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue#getValueInstance()
	 * @see #getConstantValue()
	 * @generated
	 */
	EReference getConstantValue_ValueInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Value</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.DynamicValue
	 * @generated
	 */
	EClass getDynamicValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.QueryExecutionValue <em>Query Execution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Execution Value</em>'.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.QueryExecutionValue
	 * @generated
	 */
	EClass getQueryExecutionValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ApplyStereotypeActionConfigurationFactory getApplyStereotypeActionConfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl <em>Apply Stereotype Action Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getApplyStereotypeActionConfiguration()
		 * @generated
		 */
		EClass APPLY_STEREOTYPE_ACTION_CONFIGURATION = eINSTANCE.getApplyStereotypeActionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stereotypes To Apply</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLY_STEREOTYPE_ACTION_CONFIGURATION__STEREOTYPES_TO_APPLY = eINSTANCE.getApplyStereotypeActionConfiguration_StereotypesToApply();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl <em>Stereotype To Apply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getStereotypeToApply()
		 * @generated
		 */
		EClass STEREOTYPE_TO_APPLY = eINSTANCE.getStereotypeToApply();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME = eINSTANCE.getStereotypeToApply_StereotypeQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Update Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_TO_APPLY__UPDATE_NAME = eINSTANCE.getStereotypeToApply_UpdateName();

		/**
		 * The meta object literal for the '<em><b>Required Profiles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_TO_APPLY__REQUIRED_PROFILES = eINSTANCE.getStereotypeToApply_RequiredProfiles();

		/**
		 * The meta object literal for the '<em><b>Features To Set</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPE_TO_APPLY__FEATURES_TO_SET = eINSTANCE.getStereotypeToApply_FeaturesToSet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl <em>Feature To Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureToSetImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getFeatureToSet()
		 * @generated
		 */
		EClass FEATURE_TO_SET = eINSTANCE.getFeatureToSet();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_TO_SET__FEATURE_NAME = eINSTANCE.getFeatureToSet_FeatureName();

		/**
		 * The meta object literal for the '<em><b>At Runtime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_TO_SET__AT_RUNTIME = eINSTANCE.getFeatureToSet_AtRuntime();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TO_SET__VALUE = eINSTANCE.getFeatureToSet_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureValueImpl <em>Feature Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.FeatureValueImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getFeatureValue()
		 * @generated
		 */
		EClass FEATURE_VALUE = eINSTANCE.getFeatureValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ListValueImpl <em>List Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ListValueImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getListValue()
		 * @generated
		 */
		EClass LIST_VALUE = eINSTANCE.getListValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_VALUE__VALUES = eINSTANCE.getListValue_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ConstantValueImpl <em>Constant Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ConstantValueImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getConstantValue()
		 * @generated
		 */
		EClass CONSTANT_VALUE = eINSTANCE.getConstantValue();

		/**
		 * The meta object literal for the '<em><b>Value Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_VALUE__VALUE_INSTANCE = eINSTANCE.getConstantValue_ValueInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.DynamicValueImpl <em>Dynamic Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.DynamicValueImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getDynamicValue()
		 * @generated
		 */
		EClass DYNAMIC_VALUE = eINSTANCE.getDynamicValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.QueryExecutionValueImpl <em>Query Execution Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.QueryExecutionValueImpl
		 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ApplyStereotypeActionConfigurationPackageImpl#getQueryExecutionValue()
		 * @generated
		 */
		EClass QUERY_EXECUTION_VALUE = eINSTANCE.getQueryExecutionValue();

	}

} //ApplyStereotypeActionConfigurationPackage
