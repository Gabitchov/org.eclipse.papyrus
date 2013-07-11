/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ConstructorInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceFactoryDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicedescriptorsPackageImpl extends EPackageImpl implements ServicedescriptorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registryDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceSetDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractServiceDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceDescEClass = null;

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
	private EClass aliasDescEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorsEClass = null;

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
	private EClass serviceFactoryDescEClass = null;

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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServicedescriptorsPackageImpl() {
		super(eNS_URI, ServicedescriptorsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ServicedescriptorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServicedescriptorsPackage init() {
		if (isInited) return (ServicedescriptorsPackage)EPackage.Registry.INSTANCE.getEPackage(ServicedescriptorsPackage.eNS_URI);

		// Obtain or create and register package
		ServicedescriptorsPackageImpl theServicedescriptorsPackage = (ServicedescriptorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ServicedescriptorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ServicedescriptorsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theServicedescriptorsPackage.createPackageContents();

		// Initialize created meta-data
		theServicedescriptorsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServicedescriptorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServicedescriptorsPackage.eNS_URI, theServicedescriptorsPackage);
		return theServicedescriptorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistryDesc() {
		return registryDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryDesc_Name() {
		return (EAttribute)registryDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistryDesc_Parents() {
		return (EReference)registryDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistryDesc_Children() {
		return (EReference)registryDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistryDesc_Extends() {
		return (EReference)registryDescEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryDesc_Description() {
		return (EAttribute)registryDescEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistryDesc_ServiceSets() {
		return (EReference)registryDescEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryDesc_IsUnique() {
		return (EAttribute)registryDescEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistryDesc_Services() {
		return (EReference)registryDescEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceSetDesc() {
		return serviceSetDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceSetDesc_Services() {
		return (EReference)serviceSetDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceSetDesc_OwnedServices() {
		return (EReference)serviceSetDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSetDesc_Name() {
		return (EAttribute)serviceSetDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceSetDesc_Extends() {
		return (EReference)serviceSetDescEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceSetDesc_Description() {
		return (EAttribute)serviceSetDescEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractServiceDesc() {
		return abstractServiceDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceDesc_Name() {
		return (EAttribute)abstractServiceDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractServiceDesc_DependsOn() {
		return (EReference)abstractServiceDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceDesc_Description() {
		return (EAttribute)abstractServiceDescEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceDesc_Priority() {
		return (EAttribute)abstractServiceDescEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceDesc_BundleID() {
		return (EAttribute)abstractServiceDescEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractServiceDesc_Parent() {
		return (EReference)abstractServiceDescEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractServiceDesc_DependsOnIds() {
		return (EAttribute)abstractServiceDescEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceDesc() {
		return serviceDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDesc_StartKind() {
		return (EAttribute)serviceDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDesc_Classname() {
		return (EAttribute)serviceDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceDesc_Injections() {
		return (EReference)serviceDescEClass.getEStructuralFeatures().get(2);
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
	public EClass getAliasDesc() {
		return aliasDescEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAliasDesc_AliasedService() {
		return (EReference)aliasDescEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAliasDesc_AliasedServiceId() {
		return (EAttribute)aliasDescEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptors() {
		return descriptorsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptors_Registries() {
		return (EReference)descriptorsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptors_ServiceSets() {
		return (EReference)descriptorsEClass.getEStructuralFeatures().get(1);
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
	public EReference getInjectedService_Service() {
		return (EReference)injectedServiceEClass.getEStructuralFeatures().get(0);
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
	public EClass getServiceFactoryDesc() {
		return serviceFactoryDescEClass;
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
	public EDataType getint() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicedescriptorsFactory getServicedescriptorsFactory() {
		return (ServicedescriptorsFactory)getEFactoryInstance();
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
		registryDescEClass = createEClass(REGISTRY_DESC);
		createEAttribute(registryDescEClass, REGISTRY_DESC__NAME);
		createEReference(registryDescEClass, REGISTRY_DESC__PARENTS);
		createEReference(registryDescEClass, REGISTRY_DESC__CHILDREN);
		createEReference(registryDescEClass, REGISTRY_DESC__EXTENDS);
		createEAttribute(registryDescEClass, REGISTRY_DESC__DESCRIPTION);
		createEReference(registryDescEClass, REGISTRY_DESC__SERVICE_SETS);
		createEAttribute(registryDescEClass, REGISTRY_DESC__IS_UNIQUE);
		createEReference(registryDescEClass, REGISTRY_DESC__SERVICES);

		serviceSetDescEClass = createEClass(SERVICE_SET_DESC);
		createEReference(serviceSetDescEClass, SERVICE_SET_DESC__SERVICES);
		createEReference(serviceSetDescEClass, SERVICE_SET_DESC__OWNED_SERVICES);
		createEAttribute(serviceSetDescEClass, SERVICE_SET_DESC__NAME);
		createEReference(serviceSetDescEClass, SERVICE_SET_DESC__EXTENDS);
		createEAttribute(serviceSetDescEClass, SERVICE_SET_DESC__DESCRIPTION);

		abstractServiceDescEClass = createEClass(ABSTRACT_SERVICE_DESC);
		createEAttribute(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__NAME);
		createEReference(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__DEPENDS_ON);
		createEAttribute(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__DESCRIPTION);
		createEAttribute(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__PRIORITY);
		createEAttribute(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__BUNDLE_ID);
		createEReference(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__PARENT);
		createEAttribute(abstractServiceDescEClass, ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS);

		serviceDescEClass = createEClass(SERVICE_DESC);
		createEAttribute(serviceDescEClass, SERVICE_DESC__START_KIND);
		createEAttribute(serviceDescEClass, SERVICE_DESC__CLASSNAME);
		createEReference(serviceDescEClass, SERVICE_DESC__INJECTIONS);

		featureInjectionEClass = createEClass(FEATURE_INJECTION);
		createEAttribute(featureInjectionEClass, FEATURE_INJECTION__DESCRIPTION);

		aliasDescEClass = createEClass(ALIAS_DESC);
		createEReference(aliasDescEClass, ALIAS_DESC__ALIASED_SERVICE);
		createEAttribute(aliasDescEClass, ALIAS_DESC__ALIASED_SERVICE_ID);

		descriptorsEClass = createEClass(DESCRIPTORS);
		createEReference(descriptorsEClass, DESCRIPTORS__REGISTRIES);
		createEReference(descriptorsEClass, DESCRIPTORS__SERVICE_SETS);

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
		createEReference(injectedServiceEClass, INJECTED_SERVICE__SERVICE);

		opaqueInjectedValueEClass = createEClass(OPAQUE_INJECTED_VALUE);
		createEAttribute(opaqueInjectedValueEClass, OPAQUE_INJECTED_VALUE__VALUE);

		constructorInjectionEClass = createEClass(CONSTRUCTOR_INJECTION);

		serviceFactoryDescEClass = createEClass(SERVICE_FACTORY_DESC);

		// Create enums
		startupKindEEnum = createEEnum(STARTUP_KIND);

		// Create data types
		stringEDataType = createEDataType(STRING);
		booleanEDataType = createEDataType(BOOLEAN);
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
		serviceDescEClass.getESuperTypes().add(this.getAbstractServiceDesc());
		aliasDescEClass.getESuperTypes().add(this.getAbstractServiceDesc());
		propertyInjectionEClass.getESuperTypes().add(this.getFeatureInjection());
		methodInjectionEClass.getESuperTypes().add(this.getAbstractMethodInjection());
		abstractMethodInjectionEClass.getESuperTypes().add(this.getFeatureInjection());
		injectedServiceEClass.getESuperTypes().add(this.getInjectedValue());
		opaqueInjectedValueEClass.getESuperTypes().add(this.getInjectedValue());
		constructorInjectionEClass.getESuperTypes().add(this.getAbstractMethodInjection());
		serviceFactoryDescEClass.getESuperTypes().add(this.getServiceDesc());

		// Initialize classes and features; add operations and parameters
		initEClass(registryDescEClass, RegistryDesc.class, "RegistryDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegistryDesc_Name(), this.getString(), "name", null, 1, 1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRegistryDesc_Parents(), this.getRegistryDesc(), this.getRegistryDesc_Children(), "parents", null, 0, -1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRegistryDesc_Children(), this.getRegistryDesc(), this.getRegistryDesc_Parents(), "children", null, 0, -1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRegistryDesc_Extends(), this.getRegistryDesc(), null, "extends", null, 0, -1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegistryDesc_Description(), this.getString(), "description", null, 1, 1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRegistryDesc_ServiceSets(), this.getServiceSetDesc(), null, "serviceSets", null, 0, -1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegistryDesc_IsUnique(), this.getboolean(), "isUnique", null, 1, 1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRegistryDesc_Services(), this.getAbstractServiceDesc(), null, "services", null, 0, -1, RegistryDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(registryDescEClass, this.getAbstractServiceDesc(), "getServiceDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "serviceId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(registryDescEClass, this.getServiceSetDesc(), "getServiceSetDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "serviceSetsId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(registryDescEClass, this.getboolean(), "serviceSetsContains", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "serviceSetsId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(registryDescEClass, this.getboolean(), "servicesContains", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "serviceId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(serviceSetDescEClass, ServiceSetDesc.class, "ServiceSetDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceSetDesc_Services(), this.getAbstractServiceDesc(), null, "services", null, 0, -1, ServiceSetDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceSetDesc_OwnedServices(), this.getAbstractServiceDesc(), this.getAbstractServiceDesc_Parent(), "ownedServices", null, 0, -1, ServiceSetDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getServiceSetDesc_Name(), this.getString(), "name", null, 1, 1, ServiceSetDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceSetDesc_Extends(), this.getServiceSetDesc(), null, "extends", null, 0, -1, ServiceSetDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getServiceSetDesc_Description(), this.getString(), "description", null, 1, 1, ServiceSetDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(serviceSetDescEClass, this.getAbstractServiceDesc(), "getServiceDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "serviceId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(serviceSetDescEClass, this.getboolean(), "servicesContains", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "serviceId", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(abstractServiceDescEClass, AbstractServiceDesc.class, "AbstractServiceDesc", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractServiceDesc_Name(), this.getString(), "name", null, 1, 1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractServiceDesc_DependsOn(), this.getAbstractServiceDesc(), null, "dependsOn", null, 0, -1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceDesc_Description(), this.getString(), "description", null, 1, 1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceDesc_Priority(), this.getint(), "priority", null, 1, 1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceDesc_BundleID(), this.getString(), "bundleID", null, 1, 1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractServiceDesc_Parent(), this.getServiceSetDesc(), this.getServiceSetDesc_OwnedServices(), "parent", null, 1, 1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractServiceDesc_DependsOnIds(), this.getString(), "dependsOnIds", null, 0, -1, AbstractServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceDescEClass, ServiceDesc.class, "ServiceDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceDesc_StartKind(), this.getStartupKind(), "startKind", "lazy", 1, 1, ServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getServiceDesc_Classname(), this.getString(), "classname", null, 1, 1, ServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceDesc_Injections(), this.getFeatureInjection(), null, "injections", null, 0, -1, ServiceDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(featureInjectionEClass, FeatureInjection.class, "FeatureInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureInjection_Description(), this.getString(), "description", null, 1, 1, FeatureInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(aliasDescEClass, AliasDesc.class, "AliasDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAliasDesc_AliasedService(), this.getServiceDesc(), null, "aliasedService", null, 1, 1, AliasDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAliasDesc_AliasedServiceId(), this.getString(), "aliasedServiceId", null, 1, 1, AliasDesc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(descriptorsEClass, Descriptors.class, "Descriptors", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptors_Registries(), this.getRegistryDesc(), null, "registries", null, 0, -1, Descriptors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDescriptors_ServiceSets(), this.getServiceSetDesc(), null, "serviceSets", null, 0, -1, Descriptors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(descriptorsEClass, this.getRegistryDesc(), "getRegistryDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(descriptorsEClass, this.getServiceSetDesc(), "getServiceSetDesc", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

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
		initEReference(getInjectedService_Service(), this.getAbstractServiceDesc(), null, "service", null, 1, 1, InjectedService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(opaqueInjectedValueEClass, OpaqueInjectedValue.class, "OpaqueInjectedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpaqueInjectedValue_Value(), this.getString(), "value", null, 1, 1, OpaqueInjectedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constructorInjectionEClass, ConstructorInjection.class, "ConstructorInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serviceFactoryDescEClass, ServiceFactoryDesc.class, "ServiceFactoryDesc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(startupKindEEnum, StartupKind.class, "StartupKind");
		addEEnumLiteral(startupKindEEnum, StartupKind.LAZY);
		addEEnumLiteral(startupKindEEnum, StartupKind.STARTUP);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ServicedescriptorsPackageImpl
