/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicedescriptorsFactoryImpl extends EFactoryImpl implements ServicedescriptorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServicedescriptorsFactory init() {
		try {
			ServicedescriptorsFactory theServicedescriptorsFactory = (ServicedescriptorsFactory)EPackage.Registry.INSTANCE.getEFactory("org.eclipse.papyrus..infra.core.servicedescriptors"); 
			if (theServicedescriptorsFactory != null) {
				return theServicedescriptorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServicedescriptorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorsFactoryImpl() {
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
			case ServicedescriptorsPackage.REGISTRY_DESC: return createRegistryDesc();
			case ServicedescriptorsPackage.SERVICE_SET_DESC: return createServiceSetDesc();
			case ServicedescriptorsPackage.SERVICE_DESC: return createServiceDesc();
			case ServicedescriptorsPackage.ALIAS_DESC: return createAliasDesc();
			case ServicedescriptorsPackage.DESCRIPTORS: return createDescriptors();
			case ServicedescriptorsPackage.PROPERTY_INJECTION: return createPropertyInjection();
			case ServicedescriptorsPackage.METHOD_INJECTION: return createMethodInjection();
			case ServicedescriptorsPackage.PARAMETER_INJECTION: return createParameterInjection();
			case ServicedescriptorsPackage.INJECTED_SERVICE: return createInjectedService();
			case ServicedescriptorsPackage.OPAQUE_INJECTED_VALUE: return createOpaqueInjectedValue();
			case ServicedescriptorsPackage.CONSTRUCTOR_INJECTION: return createConstructorInjection();
			case ServicedescriptorsPackage.SERVICE_FACTORY_DESC: return createServiceFactoryDesc();
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
			case ServicedescriptorsPackage.STARTUP_KIND:
				return createStartupKindFromString(eDataType, initialValue);
			case ServicedescriptorsPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case ServicedescriptorsPackage.BOOLEAN:
				return createbooleanFromString(eDataType, initialValue);
			case ServicedescriptorsPackage.INT:
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
			case ServicedescriptorsPackage.STARTUP_KIND:
				return convertStartupKindToString(eDataType, instanceValue);
			case ServicedescriptorsPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case ServicedescriptorsPackage.BOOLEAN:
				return convertbooleanToString(eDataType, instanceValue);
			case ServicedescriptorsPackage.INT:
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
	public RegistryDesc createRegistryDesc() {
		RegistryDescImpl registryDesc = new RegistryDescImpl();
		return registryDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSetDesc createServiceSetDesc() {
		ServiceSetDescImpl serviceSetDesc = new ServiceSetDescImpl();
		return serviceSetDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDesc createServiceDesc() {
		ServiceDescImpl serviceDesc = new ServiceDescImpl();
		return serviceDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AliasDesc createAliasDesc() {
		AliasDescImpl aliasDesc = new AliasDescImpl();
		return aliasDesc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Descriptors createDescriptors() {
		DescriptorsImpl descriptors = new DescriptorsImpl();
		return descriptors;
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
	public ServiceFactoryDesc createServiceFactoryDesc() {
		ServiceFactoryDescImpl serviceFactoryDesc = new ServiceFactoryDescImpl();
		return serviceFactoryDesc;
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
	public ServicedescriptorsPackage getServicedescriptorsPackage() {
		return (ServicedescriptorsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServicedescriptorsPackage getPackage() {
		return ServicedescriptorsPackage.eINSTANCE;
	}

} //ServicedescriptorsFactoryImpl
