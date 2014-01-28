/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement;
import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.DynamicValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.QueryExecutionValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage
 * @generated
 */
public class ApplyStereotypeActionConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ApplyStereotypeActionConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ApplyStereotypeActionConfigurationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplyStereotypeActionConfigurationSwitch<Adapter> modelSwitch =
		new ApplyStereotypeActionConfigurationSwitch<Adapter>() {
			@Override
			public Adapter caseApplyStereotypeActionConfiguration(ApplyStereotypeActionConfiguration object) {
				return createApplyStereotypeActionConfigurationAdapter();
			}
			@Override
			public Adapter caseStereotypeToApply(StereotypeToApply object) {
				return createStereotypeToApplyAdapter();
			}
			@Override
			public Adapter caseFeatureToSet(FeatureToSet object) {
				return createFeatureToSetAdapter();
			}
			@Override
			public Adapter caseFeatureValue(FeatureValue object) {
				return createFeatureValueAdapter();
			}
			@Override
			public Adapter caseListValue(ListValue object) {
				return createListValueAdapter();
			}
			@Override
			public Adapter caseConstantValue(ConstantValue object) {
				return createConstantValueAdapter();
			}
			@Override
			public Adapter caseDynamicValue(DynamicValue object) {
				return createDynamicValueAdapter();
			}
			@Override
			public Adapter caseQueryExecutionValue(QueryExecutionValue object) {
				return createQueryExecutionValueAdapter();
			}
			@Override
			public Adapter caseConfigurationElement(ConfigurationElement object) {
				return createConfigurationElementAdapter();
			}
			@Override
			public Adapter caseActionConfiguration(ActionConfiguration object) {
				return createActionConfigurationAdapter();
			}
			@Override
			public Adapter caseSemanticActionConfiguration(SemanticActionConfiguration object) {
				return createSemanticActionConfigurationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration <em>Apply Stereotype Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration
	 * @generated
	 */
	public Adapter createApplyStereotypeActionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply <em>Stereotype To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply
	 * @generated
	 */
	public Adapter createStereotypeToApplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet <em>Feature To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet
	 * @generated
	 */
	public Adapter createFeatureToSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue <em>Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue
	 * @generated
	 */
	public Adapter createFeatureValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue
	 * @generated
	 */
	public Adapter createListValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue
	 * @generated
	 */
	public Adapter createConstantValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.DynamicValue
	 * @generated
	 */
	public Adapter createDynamicValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.QueryExecutionValue <em>Query Execution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.QueryExecutionValue
	 * @generated
	 */
	public Adapter createQueryExecutionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement
	 * @generated
	 */
	public Adapter createConfigurationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration <em>Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration
	 * @generated
	 */
	public Adapter createActionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration <em>Semantic Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration
	 * @generated
	 */
	public Adapter createSemanticActionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ApplyStereotypeActionConfigurationAdapterFactory
