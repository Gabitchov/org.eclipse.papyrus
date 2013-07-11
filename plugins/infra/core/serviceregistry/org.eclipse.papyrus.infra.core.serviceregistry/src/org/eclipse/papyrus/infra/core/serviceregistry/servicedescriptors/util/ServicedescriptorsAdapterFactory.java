/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage
 * @generated
 */
public class ServicedescriptorsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ServicedescriptorsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ServicedescriptorsPackage.eINSTANCE;
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
	protected ServicedescriptorsSwitch<Adapter> modelSwitch =
		new ServicedescriptorsSwitch<Adapter>() {
			@Override
			public Adapter caseRegistryDesc(RegistryDesc object) {
				return createRegistryDescAdapter();
			}
			@Override
			public Adapter caseServiceSetDesc(ServiceSetDesc object) {
				return createServiceSetDescAdapter();
			}
			@Override
			public Adapter caseAbstractServiceDesc(AbstractServiceDesc object) {
				return createAbstractServiceDescAdapter();
			}
			@Override
			public Adapter caseServiceDesc(ServiceDesc object) {
				return createServiceDescAdapter();
			}
			@Override
			public Adapter caseFeatureInjection(FeatureInjection object) {
				return createFeatureInjectionAdapter();
			}
			@Override
			public Adapter caseAliasDesc(AliasDesc object) {
				return createAliasDescAdapter();
			}
			@Override
			public Adapter caseDescriptors(Descriptors object) {
				return createDescriptorsAdapter();
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
			public Adapter caseServiceFactoryDesc(ServiceFactoryDesc object) {
				return createServiceFactoryDescAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc <em>Registry Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc
	 * @generated
	 */
	public Adapter createRegistryDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc <em>Service Set Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc
	 * @generated
	 */
	public Adapter createServiceSetDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc <em>Abstract Service Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc
	 * @generated
	 */
	public Adapter createAbstractServiceDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc <em>Service Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc
	 * @generated
	 */
	public Adapter createServiceDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection <em>Feature Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection
	 * @generated
	 */
	public Adapter createFeatureInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc <em>Alias Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc
	 * @generated
	 */
	public Adapter createAliasDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors
	 * @generated
	 */
	public Adapter createDescriptorsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection <em>Property Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection
	 * @generated
	 */
	public Adapter createPropertyInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue <em>Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue
	 * @generated
	 */
	public Adapter createInjectedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection <em>Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection
	 * @generated
	 */
	public Adapter createMethodInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection <em>Abstract Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection
	 * @generated
	 */
	public Adapter createAbstractMethodInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection <em>Parameter Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection
	 * @generated
	 */
	public Adapter createParameterInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService <em>Injected Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService
	 * @generated
	 */
	public Adapter createInjectedServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue <em>Opaque Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue
	 * @generated
	 */
	public Adapter createOpaqueInjectedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ConstructorInjection <em>Constructor Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ConstructorInjection
	 * @generated
	 */
	public Adapter createConstructorInjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceFactoryDesc <em>Service Factory Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceFactoryDesc
	 * @generated
	 */
	public Adapter createServiceFactoryDescAdapter() {
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

} //ServicedescriptorsAdapterFactory
