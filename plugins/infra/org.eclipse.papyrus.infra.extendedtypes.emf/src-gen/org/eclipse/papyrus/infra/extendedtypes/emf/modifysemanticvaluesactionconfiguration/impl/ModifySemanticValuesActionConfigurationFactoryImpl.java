/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifySemanticValuesActionConfigurationFactoryImpl extends EFactoryImpl implements ModifySemanticValuesActionConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifySemanticValuesActionConfigurationFactory init() {
		try {
			ModifySemanticValuesActionConfigurationFactory theModifySemanticValuesActionConfigurationFactory = (ModifySemanticValuesActionConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/diagram/types/modifysemanticvaluesactionconfiguration/0.8"); 
			if (theModifySemanticValuesActionConfigurationFactory != null) {
				return theModifySemanticValuesActionConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifySemanticValuesActionConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifySemanticValuesActionConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModifySemanticValuesActionConfigurationPackage.MODIFY_SEMANTIC_VALUES_ACTION_CONFIGURATION: return createModifySemanticValuesActionConfiguration();
			case ModifySemanticValuesActionConfigurationPackage.FEATURE_TO_SET: return createFeatureToSet();
			case ModifySemanticValuesActionConfigurationPackage.DYNAMIC_VALUE: return createDynamicValue();
			case ModifySemanticValuesActionConfigurationPackage.CONSTANT_VALUE: return createConstantValue();
			case ModifySemanticValuesActionConfigurationPackage.LIST_VALUE: return createListValue();
			case ModifySemanticValuesActionConfigurationPackage.QUERY_EXECUTION_VALUE: return createQueryExecutionValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifySemanticValuesActionConfiguration createModifySemanticValuesActionConfiguration() {
		ModifySemanticValuesActionConfigurationImpl modifySemanticValuesActionConfiguration = new ModifySemanticValuesActionConfigurationImpl();
		return modifySemanticValuesActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureToSet createFeatureToSet() {
		FeatureToSetImpl featureToSet = new FeatureToSetImpl();
		return featureToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicValue createDynamicValue() {
		DynamicValueImpl dynamicValue = new DynamicValueImpl();
		return dynamicValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantValue createConstantValue() {
		ConstantValueImpl constantValue = new ConstantValueImpl();
		return constantValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListValue createListValue() {
		ListValueImpl listValue = new ListValueImpl();
		return listValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryExecutionValue createQueryExecutionValue() {
		QueryExecutionValueImpl queryExecutionValue = new QueryExecutionValueImpl();
		return queryExecutionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifySemanticValuesActionConfigurationPackage getModifySemanticValuesActionConfigurationPackage() {
		return (ModifySemanticValuesActionConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifySemanticValuesActionConfigurationPackage getPackage() {
		return ModifySemanticValuesActionConfigurationPackage.eINSTANCE;
	}

} //ModifySemanticValuesActionConfigurationFactoryImpl
