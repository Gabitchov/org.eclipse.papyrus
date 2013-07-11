/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory
 * @model kind="package"
 * @generated
 */
public interface ServicedescriptorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "servicedescriptors";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.eclipse.papyrus..infra.core.servicedescriptors";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.papyrus..infra.core.serviceregistry.servicedescriptors";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicedescriptorsPackage eINSTANCE = org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl <em>Registry Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getRegistryDesc()
	 * @generated
	 */
	int REGISTRY_DESC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__PARENTS = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__EXTENDS = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Service Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__SERVICE_SETS = 5;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__IS_UNIQUE = 6;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC__SERVICES = 7;

	/**
	 * The number of structural features of the '<em>Registry Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_DESC_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl <em>Service Set Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getServiceSetDesc()
	 * @generated
	 */
	int SERVICE_SET_DESC = 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_DESC__SERVICES = 0;

	/**
	 * The feature id for the '<em><b>Owned Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_DESC__OWNED_SERVICES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_DESC__NAME = 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_DESC__EXTENDS = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_DESC__DESCRIPTION = 4;

	/**
	 * The number of structural features of the '<em>Service Set Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_DESC_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl <em>Abstract Service Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getAbstractServiceDesc()
	 * @generated
	 */
	int ABSTRACT_SERVICE_DESC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__DEPENDS_ON = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__PRIORITY = 3;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__BUNDLE_ID = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__PARENT = 5;

	/**
	 * The feature id for the '<em><b>Depends On Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS = 6;

	/**
	 * The number of structural features of the '<em>Abstract Service Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_DESC_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceDescImpl <em>Service Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getServiceDesc()
	 * @generated
	 */
	int SERVICE_DESC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__NAME = ABSTRACT_SERVICE_DESC__NAME;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__DEPENDS_ON = ABSTRACT_SERVICE_DESC__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__DESCRIPTION = ABSTRACT_SERVICE_DESC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__PRIORITY = ABSTRACT_SERVICE_DESC__PRIORITY;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__BUNDLE_ID = ABSTRACT_SERVICE_DESC__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__PARENT = ABSTRACT_SERVICE_DESC__PARENT;

	/**
	 * The feature id for the '<em><b>Depends On Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__DEPENDS_ON_IDS = ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS;

	/**
	 * The feature id for the '<em><b>Start Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__START_KIND = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__CLASSNAME = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Injections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC__INJECTIONS = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESC_FEATURE_COUNT = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.FeatureInjectionImpl <em>Feature Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.FeatureInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getFeatureInjection()
	 * @generated
	 */
	int FEATURE_INJECTION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INJECTION__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Feature Injection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INJECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AliasDescImpl <em>Alias Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AliasDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getAliasDesc()
	 * @generated
	 */
	int ALIAS_DESC = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__NAME = ABSTRACT_SERVICE_DESC__NAME;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__DEPENDS_ON = ABSTRACT_SERVICE_DESC__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__DESCRIPTION = ABSTRACT_SERVICE_DESC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__PRIORITY = ABSTRACT_SERVICE_DESC__PRIORITY;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__BUNDLE_ID = ABSTRACT_SERVICE_DESC__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__PARENT = ABSTRACT_SERVICE_DESC__PARENT;

	/**
	 * The feature id for the '<em><b>Depends On Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__DEPENDS_ON_IDS = ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS;

	/**
	 * The feature id for the '<em><b>Aliased Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__ALIASED_SERVICE = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aliased Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC__ALIASED_SERVICE_ID = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alias Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_DESC_FEATURE_COUNT = ABSTRACT_SERVICE_DESC_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.DescriptorsImpl <em>Descriptors</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.DescriptorsImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getDescriptors()
	 * @generated
	 */
	int DESCRIPTORS = 6;

	/**
	 * The feature id for the '<em><b>Registries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTORS__REGISTRIES = 0;

	/**
	 * The feature id for the '<em><b>Service Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTORS__SERVICE_SETS = 1;

	/**
	 * The number of structural features of the '<em>Descriptors</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTORS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.PropertyInjectionImpl <em>Property Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.PropertyInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getPropertyInjection()
	 * @generated
	 */
	int PROPERTY_INJECTION = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INJECTION__DESCRIPTION = FEATURE_INJECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INJECTION__PROPERTY_NAME = FEATURE_INJECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INJECTION__VALUES = FEATURE_INJECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Injection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_INJECTION_FEATURE_COUNT = FEATURE_INJECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedValueImpl <em>Injected Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedValueImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getInjectedValue()
	 * @generated
	 */
	int INJECTED_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_VALUE__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Injected Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractMethodInjectionImpl <em>Abstract Method Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractMethodInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getAbstractMethodInjection()
	 * @generated
	 */
	int ABSTRACT_METHOD_INJECTION = 10;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_METHOD_INJECTION__DESCRIPTION = FEATURE_INJECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_METHOD_INJECTION__PARAMETERS = FEATURE_INJECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Method Injection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_METHOD_INJECTION_FEATURE_COUNT = FEATURE_INJECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.MethodInjectionImpl <em>Method Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.MethodInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getMethodInjection()
	 * @generated
	 */
	int METHOD_INJECTION = 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_INJECTION__DESCRIPTION = ABSTRACT_METHOD_INJECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_INJECTION__PARAMETERS = ABSTRACT_METHOD_INJECTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_INJECTION__METHOD_NAME = ABSTRACT_METHOD_INJECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Method Injection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_INJECTION_FEATURE_COUNT = ABSTRACT_METHOD_INJECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ParameterInjectionImpl <em>Parameter Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ParameterInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getParameterInjection()
	 * @generated
	 */
	int PARAMETER_INJECTION = 11;

	/**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_INJECTION__PARAMETER_NAME = 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_INJECTION__VALUES = 1;

	/**
	 * The number of structural features of the '<em>Parameter Injection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_INJECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedServiceImpl <em>Injected Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedServiceImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getInjectedService()
	 * @generated
	 */
	int INJECTED_SERVICE = 12;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_SERVICE__DESCRIPTION = INJECTED_VALUE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_SERVICE__SERVICE = INJECTED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Injected Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_SERVICE_FEATURE_COUNT = INJECTED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.OpaqueInjectedValueImpl <em>Opaque Injected Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.OpaqueInjectedValueImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getOpaqueInjectedValue()
	 * @generated
	 */
	int OPAQUE_INJECTED_VALUE = 13;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_INJECTED_VALUE__DESCRIPTION = INJECTED_VALUE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_INJECTED_VALUE__VALUE = INJECTED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opaque Injected Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_INJECTED_VALUE_FEATURE_COUNT = INJECTED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ConstructorInjectionImpl <em>Constructor Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ConstructorInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getConstructorInjection()
	 * @generated
	 */
	int CONSTRUCTOR_INJECTION = 14;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_INJECTION__DESCRIPTION = ABSTRACT_METHOD_INJECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_INJECTION__PARAMETERS = ABSTRACT_METHOD_INJECTION__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Constructor Injection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_INJECTION_FEATURE_COUNT = ABSTRACT_METHOD_INJECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceFactoryDescImpl <em>Service Factory Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceFactoryDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getServiceFactoryDesc()
	 * @generated
	 */
	int SERVICE_FACTORY_DESC = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__NAME = SERVICE_DESC__NAME;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__DEPENDS_ON = SERVICE_DESC__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__DESCRIPTION = SERVICE_DESC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__PRIORITY = SERVICE_DESC__PRIORITY;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__BUNDLE_ID = SERVICE_DESC__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__PARENT = SERVICE_DESC__PARENT;

	/**
	 * The feature id for the '<em><b>Depends On Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__DEPENDS_ON_IDS = SERVICE_DESC__DEPENDS_ON_IDS;

	/**
	 * The feature id for the '<em><b>Start Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__START_KIND = SERVICE_DESC__START_KIND;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__CLASSNAME = SERVICE_DESC__CLASSNAME;

	/**
	 * The feature id for the '<em><b>Injections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC__INJECTIONS = SERVICE_DESC__INJECTIONS;

	/**
	 * The number of structural features of the '<em>Service Factory Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_DESC_FEATURE_COUNT = SERVICE_DESC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind <em>Startup Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getStartupKind()
	 * @generated
	 */
	int STARTUP_KIND = 16;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getString()
	 * @generated
	 */
	int STRING = 17;

	/**
	 * The meta object id for the '<em>boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getboolean()
	 * @generated
	 */
	int BOOLEAN = 18;

	/**
	 * The meta object id for the '<em>int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getint()
	 * @generated
	 */
	int INT = 19;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc <em>Registry Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registry Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc
	 * @generated
	 */
	EClass getRegistryDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getName()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EAttribute getRegistryDesc_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parents</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getParents()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EReference getRegistryDesc_Parents();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getChildren()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EReference getRegistryDesc_Children();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getExtends()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EReference getRegistryDesc_Extends();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getDescription()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EAttribute getRegistryDesc_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getServiceSets <em>Service Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Service Sets</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getServiceSets()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EReference getRegistryDesc_ServiceSets();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#isUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#isUnique()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EAttribute getRegistryDesc_IsUnique();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getServices()
	 * @see #getRegistryDesc()
	 * @generated
	 */
	EReference getRegistryDesc_Services();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc <em>Service Set Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Set Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc
	 * @generated
	 */
	EClass getServiceSetDesc();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getServices()
	 * @see #getServiceSetDesc()
	 * @generated
	 */
	EReference getServiceSetDesc_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getOwnedServices <em>Owned Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Services</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getOwnedServices()
	 * @see #getServiceSetDesc()
	 * @generated
	 */
	EReference getServiceSetDesc_OwnedServices();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getName()
	 * @see #getServiceSetDesc()
	 * @generated
	 */
	EAttribute getServiceSetDesc_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getExtends()
	 * @see #getServiceSetDesc()
	 * @generated
	 */
	EReference getServiceSetDesc_Extends();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getDescription()
	 * @see #getServiceSetDesc()
	 * @generated
	 */
	EAttribute getServiceSetDesc_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc <em>Abstract Service Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Service Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc
	 * @generated
	 */
	EClass getAbstractServiceDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getName()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceDesc_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDependsOn()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EReference getAbstractServiceDesc_DependsOn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDescription()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceDesc_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getPriority()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceDesc_Priority();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getBundleID <em>Bundle ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle ID</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getBundleID()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceDesc_BundleID();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getParent()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EReference getAbstractServiceDesc_Parent();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDependsOnIds <em>Depends On Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Depends On Ids</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDependsOnIds()
	 * @see #getAbstractServiceDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceDesc_DependsOnIds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc <em>Service Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc
	 * @generated
	 */
	EClass getServiceDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc#getStartKind <em>Start Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Kind</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc#getStartKind()
	 * @see #getServiceDesc()
	 * @generated
	 */
	EAttribute getServiceDesc_StartKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc#getClassname()
	 * @see #getServiceDesc()
	 * @generated
	 */
	EAttribute getServiceDesc_Classname();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc#getInjections <em>Injections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Injections</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc#getInjections()
	 * @see #getServiceDesc()
	 * @generated
	 */
	EReference getServiceDesc_Injections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection <em>Feature Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection
	 * @generated
	 */
	EClass getFeatureInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.FeatureInjection#getDescription()
	 * @see #getFeatureInjection()
	 * @generated
	 */
	EAttribute getFeatureInjection_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc <em>Alias Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alias Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc
	 * @generated
	 */
	EClass getAliasDesc();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedService <em>Aliased Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Aliased Service</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedService()
	 * @see #getAliasDesc()
	 * @generated
	 */
	EReference getAliasDesc_AliasedService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedServiceId <em>Aliased Service Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aliased Service Id</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedServiceId()
	 * @see #getAliasDesc()
	 * @generated
	 */
	EAttribute getAliasDesc_AliasedServiceId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptors</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors
	 * @generated
	 */
	EClass getDescriptors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors#getRegistries <em>Registries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registries</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors#getRegistries()
	 * @see #getDescriptors()
	 * @generated
	 */
	EReference getDescriptors_Registries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors#getServiceSets <em>Service Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Sets</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors#getServiceSets()
	 * @see #getDescriptors()
	 * @generated
	 */
	EReference getDescriptors_ServiceSets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection <em>Property Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection
	 * @generated
	 */
	EClass getPropertyInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection#getPropertyName()
	 * @see #getPropertyInjection()
	 * @generated
	 */
	EAttribute getPropertyInjection_PropertyName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.PropertyInjection#getValues()
	 * @see #getPropertyInjection()
	 * @generated
	 */
	EReference getPropertyInjection_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue <em>Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injected Value</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue
	 * @generated
	 */
	EClass getInjectedValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedValue#getDescription()
	 * @see #getInjectedValue()
	 * @generated
	 */
	EAttribute getInjectedValue_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection <em>Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection
	 * @generated
	 */
	EClass getMethodInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.MethodInjection#getMethodName()
	 * @see #getMethodInjection()
	 * @generated
	 */
	EAttribute getMethodInjection_MethodName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection <em>Abstract Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Method Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection
	 * @generated
	 */
	EClass getAbstractMethodInjection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractMethodInjection#getParameters()
	 * @see #getAbstractMethodInjection()
	 * @generated
	 */
	EReference getAbstractMethodInjection_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection <em>Parameter Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection
	 * @generated
	 */
	EClass getParameterInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection#getParameterName()
	 * @see #getParameterInjection()
	 * @generated
	 */
	EAttribute getParameterInjection_ParameterName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ParameterInjection#getValues()
	 * @see #getParameterInjection()
	 * @generated
	 */
	EReference getParameterInjection_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService <em>Injected Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injected Service</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService
	 * @generated
	 */
	EClass getInjectedService();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.InjectedService#getService()
	 * @see #getInjectedService()
	 * @generated
	 */
	EReference getInjectedService_Service();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue <em>Opaque Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Injected Value</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue
	 * @generated
	 */
	EClass getOpaqueInjectedValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.OpaqueInjectedValue#getValue()
	 * @see #getOpaqueInjectedValue()
	 * @generated
	 */
	EAttribute getOpaqueInjectedValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ConstructorInjection <em>Constructor Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ConstructorInjection
	 * @generated
	 */
	EClass getConstructorInjection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceFactoryDesc <em>Service Factory Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Factory Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceFactoryDesc
	 * @generated
	 */
	EClass getServiceFactoryDesc();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind <em>Startup Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Startup Kind</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind
	 * @generated
	 */
	EEnum getStartupKind();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '<em>boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>boolean</em>'.
	 * @model instanceClass="boolean"
	 * @generated
	 */
	EDataType getboolean();

	/**
	 * Returns the meta object for data type '<em>int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>int</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServicedescriptorsFactory getServicedescriptorsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl <em>Registry Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getRegistryDesc()
		 * @generated
		 */
		EClass REGISTRY_DESC = eINSTANCE.getRegistryDesc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_DESC__NAME = eINSTANCE.getRegistryDesc_Name();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY_DESC__PARENTS = eINSTANCE.getRegistryDesc_Parents();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY_DESC__CHILDREN = eINSTANCE.getRegistryDesc_Children();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY_DESC__EXTENDS = eINSTANCE.getRegistryDesc_Extends();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_DESC__DESCRIPTION = eINSTANCE.getRegistryDesc_Description();

		/**
		 * The meta object literal for the '<em><b>Service Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY_DESC__SERVICE_SETS = eINSTANCE.getRegistryDesc_ServiceSets();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_DESC__IS_UNIQUE = eINSTANCE.getRegistryDesc_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY_DESC__SERVICES = eINSTANCE.getRegistryDesc_Services();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl <em>Service Set Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getServiceSetDesc()
		 * @generated
		 */
		EClass SERVICE_SET_DESC = eINSTANCE.getServiceSetDesc();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_SET_DESC__SERVICES = eINSTANCE.getServiceSetDesc_Services();

		/**
		 * The meta object literal for the '<em><b>Owned Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_SET_DESC__OWNED_SERVICES = eINSTANCE.getServiceSetDesc_OwnedServices();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SET_DESC__NAME = eINSTANCE.getServiceSetDesc_Name();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_SET_DESC__EXTENDS = eINSTANCE.getServiceSetDesc_Extends();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SET_DESC__DESCRIPTION = eINSTANCE.getServiceSetDesc_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl <em>Abstract Service Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getAbstractServiceDesc()
		 * @generated
		 */
		EClass ABSTRACT_SERVICE_DESC = eINSTANCE.getAbstractServiceDesc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_DESC__NAME = eINSTANCE.getAbstractServiceDesc_Name();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SERVICE_DESC__DEPENDS_ON = eINSTANCE.getAbstractServiceDesc_DependsOn();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_DESC__DESCRIPTION = eINSTANCE.getAbstractServiceDesc_Description();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_DESC__PRIORITY = eINSTANCE.getAbstractServiceDesc_Priority();

		/**
		 * The meta object literal for the '<em><b>Bundle ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_DESC__BUNDLE_ID = eINSTANCE.getAbstractServiceDesc_BundleID();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SERVICE_DESC__PARENT = eINSTANCE.getAbstractServiceDesc_Parent();

		/**
		 * The meta object literal for the '<em><b>Depends On Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS = eINSTANCE.getAbstractServiceDesc_DependsOnIds();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceDescImpl <em>Service Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getServiceDesc()
		 * @generated
		 */
		EClass SERVICE_DESC = eINSTANCE.getServiceDesc();

		/**
		 * The meta object literal for the '<em><b>Start Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESC__START_KIND = eINSTANCE.getServiceDesc_StartKind();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESC__CLASSNAME = eINSTANCE.getServiceDesc_Classname();

		/**
		 * The meta object literal for the '<em><b>Injections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_DESC__INJECTIONS = eINSTANCE.getServiceDesc_Injections();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.FeatureInjectionImpl <em>Feature Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.FeatureInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getFeatureInjection()
		 * @generated
		 */
		EClass FEATURE_INJECTION = eINSTANCE.getFeatureInjection();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INJECTION__DESCRIPTION = eINSTANCE.getFeatureInjection_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AliasDescImpl <em>Alias Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AliasDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getAliasDesc()
		 * @generated
		 */
		EClass ALIAS_DESC = eINSTANCE.getAliasDesc();

		/**
		 * The meta object literal for the '<em><b>Aliased Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALIAS_DESC__ALIASED_SERVICE = eINSTANCE.getAliasDesc_AliasedService();

		/**
		 * The meta object literal for the '<em><b>Aliased Service Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALIAS_DESC__ALIASED_SERVICE_ID = eINSTANCE.getAliasDesc_AliasedServiceId();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.DescriptorsImpl <em>Descriptors</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.DescriptorsImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getDescriptors()
		 * @generated
		 */
		EClass DESCRIPTORS = eINSTANCE.getDescriptors();

		/**
		 * The meta object literal for the '<em><b>Registries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTORS__REGISTRIES = eINSTANCE.getDescriptors_Registries();

		/**
		 * The meta object literal for the '<em><b>Service Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTORS__SERVICE_SETS = eINSTANCE.getDescriptors_ServiceSets();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.PropertyInjectionImpl <em>Property Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.PropertyInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getPropertyInjection()
		 * @generated
		 */
		EClass PROPERTY_INJECTION = eINSTANCE.getPropertyInjection();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_INJECTION__PROPERTY_NAME = eINSTANCE.getPropertyInjection_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_INJECTION__VALUES = eINSTANCE.getPropertyInjection_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedValueImpl <em>Injected Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedValueImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getInjectedValue()
		 * @generated
		 */
		EClass INJECTED_VALUE = eINSTANCE.getInjectedValue();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INJECTED_VALUE__DESCRIPTION = eINSTANCE.getInjectedValue_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.MethodInjectionImpl <em>Method Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.MethodInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getMethodInjection()
		 * @generated
		 */
		EClass METHOD_INJECTION = eINSTANCE.getMethodInjection();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_INJECTION__METHOD_NAME = eINSTANCE.getMethodInjection_MethodName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractMethodInjectionImpl <em>Abstract Method Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractMethodInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getAbstractMethodInjection()
		 * @generated
		 */
		EClass ABSTRACT_METHOD_INJECTION = eINSTANCE.getAbstractMethodInjection();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_METHOD_INJECTION__PARAMETERS = eINSTANCE.getAbstractMethodInjection_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ParameterInjectionImpl <em>Parameter Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ParameterInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getParameterInjection()
		 * @generated
		 */
		EClass PARAMETER_INJECTION = eINSTANCE.getParameterInjection();

		/**
		 * The meta object literal for the '<em><b>Parameter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_INJECTION__PARAMETER_NAME = eINSTANCE.getParameterInjection_ParameterName();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_INJECTION__VALUES = eINSTANCE.getParameterInjection_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedServiceImpl <em>Injected Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.InjectedServiceImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getInjectedService()
		 * @generated
		 */
		EClass INJECTED_SERVICE = eINSTANCE.getInjectedService();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INJECTED_SERVICE__SERVICE = eINSTANCE.getInjectedService_Service();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.OpaqueInjectedValueImpl <em>Opaque Injected Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.OpaqueInjectedValueImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getOpaqueInjectedValue()
		 * @generated
		 */
		EClass OPAQUE_INJECTED_VALUE = eINSTANCE.getOpaqueInjectedValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_INJECTED_VALUE__VALUE = eINSTANCE.getOpaqueInjectedValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ConstructorInjectionImpl <em>Constructor Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ConstructorInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getConstructorInjection()
		 * @generated
		 */
		EClass CONSTRUCTOR_INJECTION = eINSTANCE.getConstructorInjection();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceFactoryDescImpl <em>Service Factory Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceFactoryDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getServiceFactoryDesc()
		 * @generated
		 */
		EClass SERVICE_FACTORY_DESC = eINSTANCE.getServiceFactoryDesc();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind <em>Startup Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getStartupKind()
		 * @generated
		 */
		EEnum STARTUP_KIND = eINSTANCE.getStartupKind();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getboolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getboolean();

		/**
		 * The meta object literal for the '<em>int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsPackageImpl#getint()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getint();

	}

} //ServicedescriptorsPackage
