/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage
 * @generated
 */
public class ServicedescriptorswithidAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ServicedescriptorswithidPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorswithidAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ServicedescriptorswithidPackage.eINSTANCE;
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
	protected ServicedescriptorswithidSwitch<Adapter> modelSwitch =
		new ServicedescriptorswithidSwitch<Adapter>() {
			@Override
			public Adapter caseRegistryIdDesc(RegistryIdDesc object) {
				return createRegistryIdDescAdapter();
			}
			@Override
			public Adapter caseServiceIdDesc(ServiceIdDesc object) {
				return createServiceIdDescAdapter();
			}
			@Override
			public Adapter caseAbstractServiceIdDesc(AbstractServiceIdDesc object) {
				return createAbstractServiceIdDescAdapter();
			}
			@Override
			public Adapter caseServiceSetIdDesc(ServiceSetIdDesc object) {
				return createServiceSetIdDescAdapter();
			}
			@Override
			public Adapter caseFeatureInjection(FeatureInjection object) {
				return createFeatureInjectionAdapter();
			}
			@Override
			public Adapter caseAliasIdDesc(AliasIdDesc object) {
				return createAliasIdDescAdapter();
			}
			@Override
			public Adapter caseIdDescriptors(IdDescriptors object) {
				return createIdDescriptorsAdapter();
			}
			@Override
			public Adapter casePropertyInjection(PropertyInjection object) {
				return createPropertyInjectionAdapter();
			}
			@Override
			public Adapter caseInjectedValue(InjectedValue object) {
				return createInjectedValueAdapter();
			}
			@Override
			public Adapter caseMethodInjection(MethodInjection object) {
				return createMethodInjectionAdapter();
			}
			@Override
			public Adapter caseAbstractMethodInjection(AbstractMethodInjection object) {
				return createAbstractMethodInjectionAdapter();
			}
			@Override
			public Adapter caseParameterInjection(ParameterInjection object) {
				return createParameterInjectionAdapter();
			}
			@Override
			public Adapter caseInjectedService(InjectedService object) {
				return createInjectedServiceAdapter();
			}
			@Override
			public Adapter caseOpaqueInjectedValue(OpaqueInjectedValue object) {
				return createOpaqueInjectedValueAdapter();
			}
			@Override
			public Adapter caseConstructorInjection(ConstructorInjection object) {
				return createConstructorInjectionAdapter();
			}
			@Override
			public Adapter caseServiceFactoryIdDesc(ServiceFactoryIdDesc object) {
				return createServiceFactoryIdDescAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc <em>Registry Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc
	 * @generated
	 */
	public Adapter createRegistryIdDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc <em>Service Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc
	 * @generated
	 */
	public Adapter createServiceIdDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc <em>Abstract Service Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc
	 * @generated
	 */
	public Adapter createAbstractServiceIdDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc <em>Service Set Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc
	 * @generated
	 */
	public Adapter createServiceSetIdDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection <em>Feature Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection
	 * @generated
	 */
	public Adapter createFeatureInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc <em>Alias Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc
	 * @generated
	 */
	public Adapter createAliasIdDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors <em>Id Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors
	 * @generated
	 */
	public Adapter createIdDescriptorsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection <em>Property Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection
	 * @generated
	 */
	public Adapter createPropertyInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue <em>Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue
	 * @generated
	 */
	public Adapter createInjectedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection <em>Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection
	 * @generated
	 */
	public Adapter createMethodInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection <em>Abstract Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection
	 * @generated
	 */
	public Adapter createAbstractMethodInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection <em>Parameter Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection
	 * @generated
	 */
	public Adapter createParameterInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService <em>Injected Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService
	 * @generated
	 */
	public Adapter createInjectedServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue <em>Opaque Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue
	 * @generated
	 */
	public Adapter createOpaqueInjectedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ConstructorInjection <em>Constructor Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ConstructorInjection
	 * @generated
	 */
	public Adapter createConstructorInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc <em>Service Factory Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc
	 * @generated
	 */
	public Adapter createServiceFactoryIdDescAdapter() {
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

} //ServicedescriptorswithidAdapterFactory
