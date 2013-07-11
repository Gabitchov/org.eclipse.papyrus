/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage
 * @generated
 */
public class ServicedescriptorswithidSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ServicedescriptorswithidPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorswithidSwitch() {
		if (modelPackage == null) {
			modelPackage = ServicedescriptorswithidPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC: {
				RegistryIdDesc registryIdDesc = (RegistryIdDesc)theEObject;
				T result = caseRegistryIdDesc(registryIdDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC: {
				ServiceIdDesc serviceIdDesc = (ServiceIdDesc)theEObject;
				T result = caseServiceIdDesc(serviceIdDesc);
				if (result == null) result = caseAbstractServiceIdDesc(serviceIdDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC: {
				AbstractServiceIdDesc abstractServiceIdDesc = (AbstractServiceIdDesc)theEObject;
				T result = caseAbstractServiceIdDesc(abstractServiceIdDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC: {
				ServiceSetIdDesc serviceSetIdDesc = (ServiceSetIdDesc)theEObject;
				T result = caseServiceSetIdDesc(serviceSetIdDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.FEATURE_INJECTION: {
				FeatureInjection featureInjection = (FeatureInjection)theEObject;
				T result = caseFeatureInjection(featureInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.ALIAS_ID_DESC: {
				AliasIdDesc aliasIdDesc = (AliasIdDesc)theEObject;
				T result = caseAliasIdDesc(aliasIdDesc);
				if (result == null) result = caseAbstractServiceIdDesc(aliasIdDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS: {
				IdDescriptors idDescriptors = (IdDescriptors)theEObject;
				T result = caseIdDescriptors(idDescriptors);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.PROPERTY_INJECTION: {
				PropertyInjection propertyInjection = (PropertyInjection)theEObject;
				T result = casePropertyInjection(propertyInjection);
				if (result == null) result = caseFeatureInjection(propertyInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.INJECTED_VALUE: {
				InjectedValue injectedValue = (InjectedValue)theEObject;
				T result = caseInjectedValue(injectedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.METHOD_INJECTION: {
				MethodInjection methodInjection = (MethodInjection)theEObject;
				T result = caseMethodInjection(methodInjection);
				if (result == null) result = caseAbstractMethodInjection(methodInjection);
				if (result == null) result = caseFeatureInjection(methodInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.ABSTRACT_METHOD_INJECTION: {
				AbstractMethodInjection abstractMethodInjection = (AbstractMethodInjection)theEObject;
				T result = caseAbstractMethodInjection(abstractMethodInjection);
				if (result == null) result = caseFeatureInjection(abstractMethodInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.PARAMETER_INJECTION: {
				ParameterInjection parameterInjection = (ParameterInjection)theEObject;
				T result = caseParameterInjection(parameterInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.INJECTED_SERVICE: {
				InjectedService injectedService = (InjectedService)theEObject;
				T result = caseInjectedService(injectedService);
				if (result == null) result = caseInjectedValue(injectedService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.OPAQUE_INJECTED_VALUE: {
				OpaqueInjectedValue opaqueInjectedValue = (OpaqueInjectedValue)theEObject;
				T result = caseOpaqueInjectedValue(opaqueInjectedValue);
				if (result == null) result = caseInjectedValue(opaqueInjectedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.CONSTRUCTOR_INJECTION: {
				ConstructorInjection constructorInjection = (ConstructorInjection)theEObject;
				T result = caseConstructorInjection(constructorInjection);
				if (result == null) result = caseAbstractMethodInjection(constructorInjection);
				if (result == null) result = caseFeatureInjection(constructorInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorswithidPackage.SERVICE_FACTORY_ID_DESC: {
				ServiceFactoryIdDesc serviceFactoryIdDesc = (ServiceFactoryIdDesc)theEObject;
				T result = caseServiceFactoryIdDesc(serviceFactoryIdDesc);
				if (result == null) result = caseServiceIdDesc(serviceFactoryIdDesc);
				if (result == null) result = caseAbstractServiceIdDesc(serviceFactoryIdDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registry Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registry Id Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistryIdDesc(RegistryIdDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Id Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceIdDesc(ServiceIdDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Service Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Service Id Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractServiceIdDesc(AbstractServiceIdDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Set Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Set Id Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceSetIdDesc(ServiceSetIdDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Injection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Injection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureInjection(FeatureInjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alias Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alias Id Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAliasIdDesc(AliasIdDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Descriptors</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Descriptors</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdDescriptors(IdDescriptors object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Injection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Injection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyInjection(PropertyInjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Injected Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Injected Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInjectedValue(InjectedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Injection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Injection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodInjection(MethodInjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Method Injection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Method Injection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractMethodInjection(AbstractMethodInjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Injection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Injection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterInjection(ParameterInjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Injected Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Injected Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInjectedService(InjectedService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Injected Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Injected Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueInjectedValue(OpaqueInjectedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Injection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Injection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructorInjection(ConstructorInjection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Factory Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Factory Id Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceFactoryIdDesc(ServiceFactoryIdDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ServicedescriptorswithidSwitch
