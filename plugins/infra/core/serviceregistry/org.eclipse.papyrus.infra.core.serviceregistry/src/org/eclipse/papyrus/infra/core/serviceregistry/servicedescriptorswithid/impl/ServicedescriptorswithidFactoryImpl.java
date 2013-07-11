/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicedescriptorswithidFactoryImpl extends EFactoryImpl implements ServicedescriptorswithidFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServicedescriptorswithidFactory init() {
		try {
			ServicedescriptorswithidFactory theServicedescriptorswithidFactory = (ServicedescriptorswithidFactory)EPackage.Registry.INSTANCE.getEFactory("org.eclipse.papyrus..infra.core.servicedescriptorswithid"); 
			if (theServicedescriptorswithidFactory != null) {
				return theServicedescriptorswithidFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServicedescriptorswithidFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorswithidFactoryImpl() {
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
			case ServicedescriptorswithidPackage.REGISTRY_ID_DESC: return createRegistryIdDesc();
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC: return createServiceIdDesc();
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC: return createServiceSetIdDesc();
			case ServicedescriptorswithidPackage.ALIAS_ID_DESC: return createAliasIdDesc();
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS: return createIdDescriptors();
			case ServicedescriptorswithidPackage.PROPERTY_INJECTION: return createPropertyInjection();
			case ServicedescriptorswithidPackage.METHOD_INJECTION: return createMethodInjection();
			case ServicedescriptorswithidPackage.PARAMETER_INJECTION: return createParameterInjection();
			case ServicedescriptorswithidPackage.INJECTED_SERVICE: return createInjectedService();
			case ServicedescriptorswithidPackage.OPAQUE_INJECTED_VALUE: return createOpaqueInjectedValue();
			case ServicedescriptorswithidPackage.CONSTRUCTOR_INJECTION: return createConstructorInjection();
			case ServicedescriptorswithidPackage.SERVICE_FACTORY_ID_DESC: return createServiceFactoryIdDesc();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ServicedescriptorswithidPackage.STARTUP_KIND:
				return createStartupKindFromString(eDataType, initialValue);
			case ServicedescriptorswithidPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case ServicedescriptorswithidPackage.BOOLEAN:
				return createbooleanFromString(eDataType, initialValue);
			case ServicedescriptorswithidPackage.OBJECT:
				return createObjectFromString(eDataType, initialValue);
			case ServicedescriptorswithidPackage.INT:
				return createintFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ServicedescriptorswithidPackage.STARTUP_KIND:
				return convertStartupKindToString(eDataType, instanceValue);
			case ServicedescriptorswithidPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case ServicedescriptorswithidPackage.BOOLEAN:
				return convertbooleanToString(eDataType, instanceValue);
			case ServicedescriptorswithidPackage.OBJECT:
				return convertObjectToString(eDataType, instanceValue);
			case ServicedescriptorswithidPackage.INT:
				return convertintToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryIdDesc createRegistryIdDesc() {
		RegistryIdDescImpl registryIdDesc = new RegistryIdDescImpl();
		return registryIdDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceIdDesc createServiceIdDesc() {
		ServiceIdDescImpl serviceIdDesc = new ServiceIdDescImpl();
		return serviceIdDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSetIdDesc createServiceSetIdDesc() {
		ServiceSetIdDescImpl serviceSetIdDesc = new ServiceSetIdDescImpl();
		return serviceSetIdDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AliasIdDesc createAliasIdDesc() {
		AliasIdDescImpl aliasIdDesc = new AliasIdDescImpl();
		return aliasIdDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdDescriptors createIdDescriptors() {
		IdDescriptorsImpl idDescriptors = new IdDescriptorsImpl();
		return idDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyInjection createPropertyInjection() {
		PropertyInjectionImpl propertyInjection = new PropertyInjectionImpl();
		return propertyInjection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodInjection createMethodInjection() {
		MethodInjectionImpl methodInjection = new MethodInjectionImpl();
		return methodInjection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterInjection createParameterInjection() {
		ParameterInjectionImpl parameterInjection = new ParameterInjectionImpl();
		return parameterInjection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectedService createInjectedService() {
		InjectedServiceImpl injectedService = new InjectedServiceImpl();
		return injectedService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueInjectedValue createOpaqueInjectedValue() {
		OpaqueInjectedValueImpl opaqueInjectedValue = new OpaqueInjectedValueImpl();
		return opaqueInjectedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorInjection createConstructorInjection() {
		ConstructorInjectionImpl constructorInjection = new ConstructorInjectionImpl();
		return constructorInjection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFactoryIdDesc createServiceFactoryIdDesc() {
		ServiceFactoryIdDescImpl serviceFactoryIdDesc = new ServiceFactoryIdDescImpl();
		return serviceFactoryIdDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartupKind createStartupKindFromString(EDataType eDataType, String initialValue) {
		StartupKind result = StartupKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStartupKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean createbooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertbooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createintFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertintToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorswithidPackage getServicedescriptorswithidPackage() {
		return (ServicedescriptorswithidPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServicedescriptorswithidPackage getPackage() {
		return ServicedescriptorswithidPackage.eINSTANCE;
	}

} //ServicedescriptorswithidFactoryImpl
