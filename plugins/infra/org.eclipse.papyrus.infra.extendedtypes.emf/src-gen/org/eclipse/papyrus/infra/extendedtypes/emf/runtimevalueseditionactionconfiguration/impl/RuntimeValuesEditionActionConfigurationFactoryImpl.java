/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeValuesEditionActionConfigurationFactoryImpl extends EFactoryImpl implements RuntimeValuesEditionActionConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimeValuesEditionActionConfigurationFactory init() {
		try {
			RuntimeValuesEditionActionConfigurationFactory theRuntimeValuesEditionActionConfigurationFactory = (RuntimeValuesEditionActionConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(RuntimeValuesEditionActionConfigurationPackage.eNS_URI);
			if (theRuntimeValuesEditionActionConfigurationFactory != null) {
				return theRuntimeValuesEditionActionConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimeValuesEditionActionConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionActionConfigurationFactoryImpl() {
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
			case RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION: return createRuntimeValuesEditionActionConfiguration();
			case RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY: return createViewToDisplay();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionActionConfiguration createRuntimeValuesEditionActionConfiguration() {
		RuntimeValuesEditionActionConfigurationImpl runtimeValuesEditionActionConfiguration = new RuntimeValuesEditionActionConfigurationImpl();
		return runtimeValuesEditionActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewToDisplay createViewToDisplay() {
		ViewToDisplayImpl viewToDisplay = new ViewToDisplayImpl();
		return viewToDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionActionConfigurationPackage getRuntimeValuesEditionActionConfigurationPackage() {
		return (RuntimeValuesEditionActionConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimeValuesEditionActionConfigurationPackage getPackage() {
		return RuntimeValuesEditionActionConfigurationPackage.eINSTANCE;
	}

} //RuntimeValuesEditionActionConfigurationFactoryImpl
