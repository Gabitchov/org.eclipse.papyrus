/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.*;

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
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage
 * @generated
 */
public class ServicedescriptorsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ServicedescriptorsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorsSwitch() {
		if (modelPackage == null) {
			modelPackage = ServicedescriptorsPackage.eINSTANCE;
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
			case ServicedescriptorsPackage.REGISTRY_DESC: {
				RegistryDesc registryDesc = (RegistryDesc)theEObject;
				T result = caseRegistryDesc(registryDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.SERVICE_SET_DESC: {
				ServiceSetDesc serviceSetDesc = (ServiceSetDesc)theEObject;
				T result = caseServiceSetDesc(serviceSetDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC: {
				AbstractServiceDesc abstractServiceDesc = (AbstractServiceDesc)theEObject;
				T result = caseAbstractServiceDesc(abstractServiceDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.SERVICE_DESC: {
				ServiceDesc serviceDesc = (ServiceDesc)theEObject;
				T result = caseServiceDesc(serviceDesc);
				if (result == null) result = caseAbstractServiceDesc(serviceDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.FEATURE_INJECTION: {
				FeatureInjection featureInjection = (FeatureInjection)theEObject;
				T result = caseFeatureInjection(featureInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.ALIAS_DESC: {
				AliasDesc aliasDesc = (AliasDesc)theEObject;
				T result = caseAliasDesc(aliasDesc);
				if (result == null) result = caseAbstractServiceDesc(aliasDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.DESCRIPTORS: {
				Descriptors descriptors = (Descriptors)theEObject;
				T result = caseDescriptors(descriptors);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.PROPERTY_INJECTION: {
				PropertyInjection propertyInjection = (PropertyInjection)theEObject;
				T result = casePropertyInjection(propertyInjection);
				if (result == null) result = caseFeatureInjection(propertyInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.INJECTED_VALUE: {
				InjectedValue injectedValue = (InjectedValue)theEObject;
				T result = caseInjectedValue(injectedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.METHOD_INJECTION: {
				MethodInjection methodInjection = (MethodInjection)theEObject;
				T result = caseMethodInjection(methodInjection);
				if (result == null) result = caseAbstractMethodInjection(methodInjection);
				if (result == null) result = caseFeatureInjection(methodInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.ABSTRACT_METHOD_INJECTION: {
				AbstractMethodInjection abstractMethodInjection = (AbstractMethodInjection)theEObject;
				T result = caseAbstractMethodInjection(abstractMethodInjection);
				if (result == null) result = caseFeatureInjection(abstractMethodInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.PARAMETER_INJECTION: {
				ParameterInjection parameterInjection = (ParameterInjection)theEObject;
				T result = caseParameterInjection(parameterInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.INJECTED_SERVICE: {
				InjectedService injectedService = (InjectedService)theEObject;
				T result = caseInjectedService(injectedService);
				if (result == null) result = caseInjectedValue(injectedService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.OPAQUE_INJECTED_VALUE: {
				OpaqueInjectedValue opaqueInjectedValue = (OpaqueInjectedValue)theEObject;
				T result = caseOpaqueInjectedValue(opaqueInjectedValue);
				if (result == null) result = caseInjectedValue(opaqueInjectedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.CONSTRUCTOR_INJECTION: {
				ConstructorInjection constructorInjection = (ConstructorInjection)theEObject;
				T result = caseConstructorInjection(constructorInjection);
				if (result == null) result = caseAbstractMethodInjection(constructorInjection);
				if (result == null) result = caseFeatureInjection(constructorInjection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicedescriptorsPackage.SERVICE_FACTORY_DESC: {
				ServiceFactoryDesc serviceFactoryDesc = (ServiceFactoryDesc)theEObject;
				T result = caseServiceFactoryDesc(serviceFactoryDesc);
				if (result == null) result = caseServiceDesc(serviceFactoryDesc);
				if (result == null) result = caseAbstractServiceDesc(serviceFactoryDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registry Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registry Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistryDesc(RegistryDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Set Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Set Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceSetDesc(ServiceSetDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Service Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Service Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractServiceDesc(AbstractServiceDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceDesc(ServiceDesc object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Alias Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alias Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAliasDesc(AliasDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptors</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptors</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptors(Descriptors object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Service Factory Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Factory Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceFactoryDesc(ServiceFactoryDesc object) {
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

} //ServicedescriptorsSwitch
