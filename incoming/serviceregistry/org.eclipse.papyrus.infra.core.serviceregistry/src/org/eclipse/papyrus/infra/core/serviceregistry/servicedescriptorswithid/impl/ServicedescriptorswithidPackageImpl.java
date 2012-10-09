/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ConstructorInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidFactory;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicedescriptorswithidPackageImpl extends EPackageImpl implements ServicedescriptorswithidPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registryIdDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceIdDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractServiceIdDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceSetIdDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aliasIdDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idDescriptorsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass injectedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMethodInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass injectedServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueInjectedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorInjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceFactoryIdDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum startupKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServicedescriptorswithidPackageImpl() {
		super(eNS_URI, ServicedescriptorswithidFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ServicedescriptorswithidPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServicedescriptorswithidPackage init() {
		if (isInited) return (ServicedescriptorswithidPackage)EPackage.Registry.INSTANCE.getEPackage(ServicedescriptorswithidPackage.eNS_URI);

		// Obtain or create and register package
		ServicedescriptorswithidPackageImpl theServicedescriptorswithidPackage = (ServicedescriptorswithidPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ServicedescriptorswithidPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ServicedescriptorswithidPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theServicedescriptorswithidPackage.createPackageContents();

		// Initialize created meta-data
		theServicedescriptorswithidPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServicedescriptorswithidPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServicedescriptorswithidPackage.eNS_URI, theServicedescriptorswithidPackage);
		return theServicedescriptorswithidPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistryIdDesc() {
		return registryIdDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryIdDesc_Name() {
		return (EAttribute)registryIdDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryIdDesc_Description() {
		return (EAttribute)registryIdDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryIdDesc_IsUnique() {
		return (EAttribute)registryIdDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryIdDesc_Sets() {
		return (EAttribute)registryIdDescEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryIdDesc_Extends() {
		return (EAttribute)registryIdDescEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryIdDesc_Parents() {
		return (EAttribute)registryIdDescEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceIdDesc() {
		return serviceIdDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceIdDesc_StartKind() {
		return (EAttribute)serviceIdDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceIdDesc_Classname() {
		return (EAttribute)serviceIdDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceIdDesc_Injections() {
		return (EReference)serviceIdDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractServiceIdDesc() {
		return abstractServiceIdDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceIdDesc_Name() {
		return (EAttribute)abstractServiceIdDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractServiceIdDesc_Namespace() {
		return (EReference)abstractServiceIdDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceIdDesc_Description() {
		return (EAttribute)abstractServiceIdDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceIdDesc_DependsOn() {
		return (EAttribute)abstractServiceIdDescEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceIdDesc_Priority() {
		return (EAttribute)abstractServiceIdDescEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceIdDesc_BundleID() {
		return (EAttribute)abstractServiceIdDescEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceSetIdDesc() {
		return serviceSetIdDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSetIdDesc_Name() {
		return (EAttribute)serviceSetIdDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSetIdDesc_Extends() {
		return (EAttribute)serviceSetIdDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSetIdDesc_Description() {
		return (EAttribute)serviceSetIdDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceSetIdDesc_ServiceDescriptors() {
		return (EReference)serviceSetIdDescEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureInjection() {
		return featureInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureInjection_Description() {
		return (EAttribute)featureInjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAliasIdDesc() {
		return aliasIdDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAliasIdDesc_AliasedService() {
		return (EAttribute)aliasIdDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdDescriptors() {
		return idDescriptorsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdDescriptors_Registries() {
		return (EReference)idDescriptorsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdDescriptors_ServiceSets() {
		return (EReference)idDescriptorsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyInjection() {
		return propertyInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyInjection_PropertyName() {
		return (EAttribute)propertyInjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyInjection_Values() {
		return (EReference)propertyInjectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInjectedValue() {
		return injectedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInjectedValue_Description() {
		return (EAttribute)injectedValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodInjection() {
		return methodInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodInjection_MethodName() {
		return (EAttribute)methodInjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMethodInjection() {
		return abstractMethodInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMethodInjection_Parameters() {
		return (EReference)abstractMethodInjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterInjection() {
		return parameterInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterInjection_ParameterName() {
		return (EAttribute)parameterInjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInjection_Values() {
		return (EReference)parameterInjectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInjectedService() {
		return injectedServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInjectedService_ServiceName() {
		return (EAttribute)injectedServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueInjectedValue() {
		return opaqueInjectedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpaqueInjectedValue_Value() {
		return (EAttribute)opaqueInjectedValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorInjection() {
		return constructorInjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceFactoryIdDesc() {
		return serviceFactoryIdDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStartupKind() {
		return startupKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getboolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getint() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorswithidFactory getServicedescriptorswithidFactory() {
		return (ServicedescriptorswithidFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		registryIdDescEClass = createEClass(REGISTRY_ID_DESC);
		createEAttribute(registryIdDescEClass, REGISTRY_ID_DESC__NAME);
		createEAttribute(registryIdDescEClass, REGISTRY_ID_DESC__DESCRIPTION);
		createEAttribute(registryIdDescEClass, REGISTRY_ID_DESC__IS_UNIQUE);
		createEAttribute(registryIdDescEClass, REGISTRY_ID_DESC__SETS);
		createEAttribute(registryIdDescEClass, REGISTRY_ID_DESC__EXTENDS);
		createEAttribute(registryIdDescEClass, REGISTRY_ID_DESC__PARENTS);

		serviceIdDescEClass = createEClass(SERVICE_ID_DESC);
		createEAttribute(serviceIdDescEClass, SERVICE_ID_DESC__START_KIND);
		createEAttribute(serviceIdDescEClass, SERVICE_ID_DESC__CLASSNAME);
		createEReference(serviceIdDescEClass, SERVICE_ID_DESC__INJECTIONS);

		abstractServiceIdDescEClass = createEClass(ABSTRACT_SERVICE_ID_DESC);
		createEAttribute(abstractServiceIdDescEClass, ABSTRACT_SERVICE_ID_DESC__NAME);
		createEReference(abstractServiceIdDescEClass, ABSTRACT_SERVICE_ID_DESC__NAMESPACE);
		createEAttribute(abstractServiceIdDescEClass, ABSTRACT_SERVICE_ID_DESC__DESCRIPTION);
		createEAttribute(abstractServiceIdDescEClass, ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON);
		createEAttribute(abstractServiceIdDescEClass, ABSTRACT_SERVICE_ID_DESC__PRIORITY);
		createEAttribute(abstractServiceIdDescEClass, ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID);

		serviceSetIdDescEClass = createEClass(SERVICE_SET_ID_DESC);
		createEAttribute(serviceSetIdDescEClass, SERVICE_SET_ID_DESC__NAME);
		createEAttribute(serviceSetIdDescEClass, SERVICE_SET_ID_DESC__EXTENDS);
		createEAttribute(serviceSetIdDescEClass, SERVICE_SET_ID_DESC__DESCRIPTION);
		createEReference(serviceSetIdDescEClass, SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS);

		featureInjectionEClass = createEClass(FEATURE_INJECTION);
		createEAttribute(featureInjectionEClass, FEATURE_INJECTION__DESCRIPTION);

		aliasIdDescEClass = createEClass(ALIAS_ID_DESC);
		createEAttribute(aliasIdDescEClass, ALIAS_ID_DESC__ALIASED_SERVICE);

		idDescriptorsEClass = createEClass(ID_DESCRIPTORS);
		createEReference(idDescriptorsEClass, ID_DESCRIPTORS__REGISTRIES);
		createEReference(idDescriptorsEClass, ID_DESCRIPTORS__SERVICE_SETS);

		propertyInjectionEClass = createEClass(PROPERTY_INJECTION);
		createEAttribute(propertyInjectionEClass, PROPERTY_INJECTION__PROPERTY_NAME);
		createEReference(propertyInjectionEClass, PROPERTY_INJECTION__VALUES);

		injectedValueEClass = createEClass(INJECTED_VALUE);
		createEAttribute(injectedValueEClass, INJECTED_VALUE__DESCRIPTION);

		methodInjectionEClass = createEClass(METHOD_INJECTION);
		createEAttribute(methodInjectionEClass, METHOD_INJECTION__METHOD_NAME);

		abstractMethodInjectionEClass = createEClass(ABSTRACT_METHOD_INJECTION);
		createEReference(abstractMethodInjectionEClass, ABSTRACT_METHOD_INJECTION__PARAMETERS);

		parameterInjectionEClass = createEClass(PARAMETER_INJECTION);
		createEAttribute(parameterInjectionEClass, PARAMETER_INJECTION__PARAMETER_NAME);
		createEReference(parameterInjectionEClass, PARAMETER_INJECTION__VALUES);

		injectedServiceEClass = createEClass(INJECTED_SERVICE);
		createEAttribute(injectedServiceEClass, INJECTED_SERVICE__SERVICE_NAME);

		opaqueInjectedValueEClass = createEClass(OPAQUE_INJECTED_VALUE);
		createEAttribute(opaqueInjectedValueEClass, OPAQUE_INJECTED_VALUE__VALUE);

		constructorInjectionEClass = createEClass(CONSTRUCTOR_INJECTION);

		serviceFactoryIdDescEClass = createEClass(SERVICE_FACTORY_ID_DESC);

		// Create enums
		startupKindEEnum = createEEnum(STARTUP_KIND);

		// Create data types
		stringEDataType = createEDataType(STRING);
		booleanEDataType = createEDataType(BOOLEAN);
		objectEDataType = createEDataType(OBJECT);
		intEDataType = createEDataType(INT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		serviceIdDescEClass.getESuperTypes().add(this.getAbstractServiceIdDesc());
		aliasIdDescEClass.getESuperTypes().add(this.getAbstractServiceIdDesc());
		propertyInjectionEClass.getESuperTypes().add(this.getFeatureInjection());
		methodInjectionEClass.getESuperTypes().add(this.getAbstractMethodInjection());
		abstractMethodInjectionEClass.getESuperTypes().add(this.getFeatureInjection());
		injectedServiceEClass.getESuperTypes().add(this.getInjectedValue());
		opaqueInjectedValueEClass.getESuperTypes().add(this.getInjectedValue());
		constructorInjectionEClass.getESuperTypes().add(this.getAbstractMethodInjection());
		serviceFactoryIdDescEClass.getESuperTypes().add(this.getServiceIdDesc());

		// Initialize classes and features; add operations and parameters
		initEClass(registryIdDescEClass, RegistryIdDesc.class, "RegistryIdDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegistryIdDesc_Name(), this.getString(), "name", null, 1, 1, RegistryIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegistryIdDesc_Description(), this.getString(), "description", null, 1, 1, RegistryIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegistryIdDesc_IsUnique(), this.getboolean(), "isUnique", null, 1, 1, RegistryIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegistryIdDesc_Sets(), this.getString(), "sets", null, 0, -1, RegistryIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistryIdDesc_Extends(), this.getString(), "extends", null, 0, -1, RegistryIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistryIdDesc_Parents(), this.getString(), "parents", null, 0, -1, RegistryIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceIdDescEClass, ServiceIdDesc.class, "ServiceIdDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceIdDesc_StartKind(), this.getStartupKind(), "startKind", "lazy", 1, 1, ServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getServiceIdDesc_Classname(), this.getString(), "classname", null, 1, 1, ServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceIdDesc_Injections(), this.getFeatureInjection(), null, "injections", null, 0, -1, ServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractServiceIdDescEClass, AbstractServiceIdDesc.class, "AbstractServiceIdDesc", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractServiceIdDesc_Name(), this.getString(), "name", null, 1, 1, AbstractServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractServiceIdDesc_Namespace(), this.getServiceSetIdDesc(), this.getServiceSetIdDesc_ServiceDescriptors(), "namespace", null, 1, 1, AbstractServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceIdDesc_Description(), this.getString(), "description", null, 1, 1, AbstractServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceIdDesc_DependsOn(), this.getString(), "dependsOn", null, 0, -1, AbstractServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractServiceIdDesc_Priority(), this.getint(), "priority", null, 1, 1, AbstractServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceIdDesc_BundleID(), this.getString(), "bundleID", null, 1, 1, AbstractServiceIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(serviceSetIdDescEClass, ServiceSetIdDesc.class, "ServiceSetIdDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceSetIdDesc_Name(), this.getString(), "name", null, 1, 1, ServiceSetIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getServiceSetIdDesc_Extends(), this.getString(), "extends", null, 0, -1, ServiceSetIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceSetIdDesc_Description(), this.getString(), "description", null, 1, 1, ServiceSetIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceSetIdDesc_ServiceDescriptors(), this.getAbstractServiceIdDesc(), this.getAbstractServiceIdDesc_Namespace(), "serviceDescriptors", null, 0, -1, ServiceSetIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(serviceSetIdDescEClass, this.getAbstractServiceIdDesc(), "getService", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getObject(), "serviceId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(serviceSetIdDescEClass, this.getboolean(), "containsService", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getObject(), "serviceId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(serviceSetIdDescEClass, this.getAbstractServiceIdDesc(), "getService", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractServiceIdDesc(), "serviceDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(serviceSetIdDescEClass, this.getboolean(), "containsService", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractServiceIdDesc(), "serviceDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(featureInjectionEClass, FeatureInjection.class, "FeatureInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureInjection_Description(), this.getString(), "description", null, 1, 1, FeatureInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(aliasIdDescEClass, AliasIdDesc.class, "AliasIdDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAliasIdDesc_AliasedService(), this.getString(), "aliasedService", null, 1, 1, AliasIdDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(idDescriptorsEClass, IdDescriptors.class, "IdDescriptors", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdDescriptors_Registries(), this.getRegistryIdDesc(), null, "registries", null, 0, -1, IdDescriptors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIdDescriptors_ServiceSets(), this.getServiceSetIdDesc(), null, "serviceSets", null, 0, -1, IdDescriptors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyInjectionEClass, PropertyInjection.class, "PropertyInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyInjection_PropertyName(), this.getString(), "propertyName", null, 1, 1, PropertyInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropertyInjection_Values(), this.getInjectedValue(), null, "values", null, 0, -1, PropertyInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(injectedValueEClass, InjectedValue.class, "InjectedValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInjectedValue_Description(), this.getString(), "description", null, 1, 1, InjectedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(methodInjectionEClass, MethodInjection.class, "MethodInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethodInjection_MethodName(), this.getString(), "methodName", null, 1, 1, MethodInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractMethodInjectionEClass, AbstractMethodInjection.class, "AbstractMethodInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMethodInjection_Parameters(), this.getParameterInjection(), null, "parameters", null, 0, -1, AbstractMethodInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterInjectionEClass, ParameterInjection.class, "ParameterInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterInjection_ParameterName(), this.getString(), "parameterName", null, 1, 1, ParameterInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterInjection_Values(), this.getInjectedValue(), null, "values", null, 0, -1, ParameterInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(injectedServiceEClass, InjectedService.class, "InjectedService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInjectedService_ServiceName(), this.getString(), "serviceName", null, 1, 1, InjectedService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(opaqueInjectedValueEClass, OpaqueInjectedValue.class, "OpaqueInjectedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpaqueInjectedValue_Value(), this.getString(), "value", null, 1, 1, OpaqueInjectedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constructorInjectionEClass, ConstructorInjection.class, "ConstructorInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serviceFactoryIdDescEClass, ServiceFactoryIdDesc.class, "ServiceFactoryIdDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(startupKindEEnum, StartupKind.class, "StartupKind");
		addEEnumLiteral(startupKindEEnum, StartupKind.LAZY);
		addEEnumLiteral(startupKindEEnum, StartupKind.STARTUP);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ServicedescriptorswithidPackageImpl
