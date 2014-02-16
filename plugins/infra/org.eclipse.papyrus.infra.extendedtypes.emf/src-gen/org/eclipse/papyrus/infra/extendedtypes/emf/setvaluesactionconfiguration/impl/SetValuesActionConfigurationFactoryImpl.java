/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SetValuesActionConfigurationFactoryImpl extends EFactoryImpl implements SetValuesActionConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SetValuesActionConfigurationFactory init() {
		try {
			SetValuesActionConfigurationFactory theSetValuesActionConfigurationFactory = (SetValuesActionConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(SetValuesActionConfigurationPackage.eNS_URI);
			if (theSetValuesActionConfigurationFactory != null) {
				return theSetValuesActionConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SetValuesActionConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetValuesActionConfigurationFactoryImpl() {
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
			case SetValuesActionConfigurationPackage.SET_VALUES_ACTION_CONFIGURATION: return createSetValuesActionConfiguration();
			case SetValuesActionConfigurationPackage.FEATURE_TO_SET: return createFeatureToSet();
			case SetValuesActionConfigurationPackage.CONSTANT_VALUE: return createConstantValue();
			case SetValuesActionConfigurationPackage.LIST_VALUE: return createListValue();
			case SetValuesActionConfigurationPackage.QUERY_EXECUTION_VALUE: return createQueryExecutionValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetValuesActionConfiguration createSetValuesActionConfiguration() {
		SetValuesActionConfigurationImpl setValuesActionConfiguration = new SetValuesActionConfigurationImpl();
		return setValuesActionConfiguration;
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
	public SetValuesActionConfigurationPackage getSetValuesActionConfigurationPackage() {
		return (SetValuesActionConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SetValuesActionConfigurationPackage getPackage() {
		return SetValuesActionConfigurationPackage.eINSTANCE;
	}

} //SetValuesActionConfigurationFactoryImpl
