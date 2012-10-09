/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;

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
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidFactory
 * @model kind="package"
 * @generated
 */
public interface ServicedescriptorswithidPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "servicedescriptorswithid";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.eclipse.papyrus..infra.core.servicedescriptorswithid";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "servicedescriptorswithid";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicedescriptorswithidPackage eINSTANCE = org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl <em>Registry Id Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getRegistryIdDesc()
	 * @generated
	 */
	int REGISTRY_ID_DESC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC__IS_UNIQUE = 2;

	/**
	 * The feature id for the '<em><b>Sets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC__SETS = 3;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC__EXTENDS = 4;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC__PARENTS = 5;

	/**
	 * The number of structural features of the '<em>Registry Id Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_ID_DESC_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl <em>Abstract Service Id Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getAbstractServiceIdDesc()
	 * @generated
	 */
	int ABSTRACT_SERVICE_ID_DESC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC__NAMESPACE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON = 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC__PRIORITY = 4;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID = 5;

	/**
	 * The number of structural features of the '<em>Abstract Service Id Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl <em>Service Id Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getServiceIdDesc()
	 * @generated
	 */
	int SERVICE_ID_DESC = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__NAME = ABSTRACT_SERVICE_ID_DESC__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__NAMESPACE = ABSTRACT_SERVICE_ID_DESC__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__DESCRIPTION = ABSTRACT_SERVICE_ID_DESC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__DEPENDS_ON = ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__PRIORITY = ABSTRACT_SERVICE_ID_DESC__PRIORITY;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__BUNDLE_ID = ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Start Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__START_KIND = ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__CLASSNAME = ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Injections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC__INJECTIONS = ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service Id Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_ID_DESC_FEATURE_COUNT = ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl <em>Service Set Id Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getServiceSetIdDesc()
	 * @generated
	 */
	int SERVICE_SET_ID_DESC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_ID_DESC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_ID_DESC__EXTENDS = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_ID_DESC__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Service Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS = 3;

	/**
	 * The number of structural features of the '<em>Service Set Id Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_SET_ID_DESC_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.FeatureInjectionImpl <em>Feature Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.FeatureInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getFeatureInjection()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AliasIdDescImpl <em>Alias Id Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AliasIdDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getAliasIdDesc()
	 * @generated
	 */
	int ALIAS_ID_DESC = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__NAME = ABSTRACT_SERVICE_ID_DESC__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__NAMESPACE = ABSTRACT_SERVICE_ID_DESC__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__DESCRIPTION = ABSTRACT_SERVICE_ID_DESC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__DEPENDS_ON = ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__PRIORITY = ABSTRACT_SERVICE_ID_DESC__PRIORITY;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__BUNDLE_ID = ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Aliased Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC__ALIASED_SERVICE = ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Alias Id Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALIAS_ID_DESC_FEATURE_COUNT = ABSTRACT_SERVICE_ID_DESC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.IdDescriptorsImpl <em>Id Descriptors</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.IdDescriptorsImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getIdDescriptors()
	 * @generated
	 */
	int ID_DESCRIPTORS = 6;

	/**
	 * The feature id for the '<em><b>Registries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_DESCRIPTORS__REGISTRIES = 0;

	/**
	 * The feature id for the '<em><b>Service Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_DESCRIPTORS__SERVICE_SETS = 1;

	/**
	 * The number of structural features of the '<em>Id Descriptors</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_DESCRIPTORS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.PropertyInjectionImpl <em>Property Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.PropertyInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getPropertyInjection()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedValueImpl <em>Injected Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedValueImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getInjectedValue()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractMethodInjectionImpl <em>Abstract Method Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractMethodInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getAbstractMethodInjection()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.MethodInjectionImpl <em>Method Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.MethodInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getMethodInjection()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ParameterInjectionImpl <em>Parameter Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ParameterInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getParameterInjection()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedServiceImpl <em>Injected Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedServiceImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getInjectedService()
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
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_SERVICE__SERVICE_NAME = INJECTED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Injected Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTED_SERVICE_FEATURE_COUNT = INJECTED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.OpaqueInjectedValueImpl <em>Opaque Injected Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.OpaqueInjectedValueImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getOpaqueInjectedValue()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ConstructorInjectionImpl <em>Constructor Injection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ConstructorInjectionImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getConstructorInjection()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceFactoryIdDescImpl <em>Service Factory Id Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceFactoryIdDescImpl
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getServiceFactoryIdDesc()
	 * @generated
	 */
	int SERVICE_FACTORY_ID_DESC = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__NAME = SERVICE_ID_DESC__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__NAMESPACE = SERVICE_ID_DESC__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__DESCRIPTION = SERVICE_ID_DESC__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__DEPENDS_ON = SERVICE_ID_DESC__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__PRIORITY = SERVICE_ID_DESC__PRIORITY;

	/**
	 * The feature id for the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__BUNDLE_ID = SERVICE_ID_DESC__BUNDLE_ID;

	/**
	 * The feature id for the '<em><b>Start Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__START_KIND = SERVICE_ID_DESC__START_KIND;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__CLASSNAME = SERVICE_ID_DESC__CLASSNAME;

	/**
	 * The feature id for the '<em><b>Injections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC__INJECTIONS = SERVICE_ID_DESC__INJECTIONS;

	/**
	 * The number of structural features of the '<em>Service Factory Id Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FACTORY_ID_DESC_FEATURE_COUNT = SERVICE_ID_DESC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind <em>Startup Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getStartupKind()
	 * @generated
	 */
	int STARTUP_KIND = 16;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getString()
	 * @generated
	 */
	int STRING = 17;

	/**
	 * The meta object id for the '<em>boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getboolean()
	 * @generated
	 */
	int BOOLEAN = 18;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 19;

	/**
	 * The meta object id for the '<em>int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getint()
	 * @generated
	 */
	int INT = 20;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc <em>Registry Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registry Id Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc
	 * @generated
	 */
	EClass getRegistryIdDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getName()
	 * @see #getRegistryIdDesc()
	 * @generated
	 */
	EAttribute getRegistryIdDesc_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getDescription()
	 * @see #getRegistryIdDesc()
	 * @generated
	 */
	EAttribute getRegistryIdDesc_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#isUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#isUnique()
	 * @see #getRegistryIdDesc()
	 * @generated
	 */
	EAttribute getRegistryIdDesc_IsUnique();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getSets <em>Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sets</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getSets()
	 * @see #getRegistryIdDesc()
	 * @generated
	 */
	EAttribute getRegistryIdDesc_Sets();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Extends</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getExtends()
	 * @see #getRegistryIdDesc()
	 * @generated
	 */
	EAttribute getRegistryIdDesc_Extends();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parents</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getParents()
	 * @see #getRegistryIdDesc()
	 * @generated
	 */
	EAttribute getRegistryIdDesc_Parents();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc <em>Service Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Id Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc
	 * @generated
	 */
	EClass getServiceIdDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getStartKind <em>Start Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Kind</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getStartKind()
	 * @see #getServiceIdDesc()
	 * @generated
	 */
	EAttribute getServiceIdDesc_StartKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getClassname()
	 * @see #getServiceIdDesc()
	 * @generated
	 */
	EAttribute getServiceIdDesc_Classname();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getInjections <em>Injections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Injections</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getInjections()
	 * @see #getServiceIdDesc()
	 * @generated
	 */
	EReference getServiceIdDesc_Injections();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc <em>Abstract Service Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Service Id Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc
	 * @generated
	 */
	EClass getAbstractServiceIdDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getName()
	 * @see #getAbstractServiceIdDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceIdDesc_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Namespace</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getNamespace()
	 * @see #getAbstractServiceIdDesc()
	 * @generated
	 */
	EReference getAbstractServiceIdDesc_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getDescription()
	 * @see #getAbstractServiceIdDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceIdDesc_Description();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Depends On</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getDependsOn()
	 * @see #getAbstractServiceIdDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceIdDesc_DependsOn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getPriority()
	 * @see #getAbstractServiceIdDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceIdDesc_Priority();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getBundleID <em>Bundle ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle ID</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc#getBundleID()
	 * @see #getAbstractServiceIdDesc()
	 * @generated
	 */
	EAttribute getAbstractServiceIdDesc_BundleID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc <em>Service Set Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Set Id Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc
	 * @generated
	 */
	EClass getServiceSetIdDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getName()
	 * @see #getServiceSetIdDesc()
	 * @generated
	 */
	EAttribute getServiceSetIdDesc_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Extends</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getExtends()
	 * @see #getServiceSetIdDesc()
	 * @generated
	 */
	EAttribute getServiceSetIdDesc_Extends();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getDescription()
	 * @see #getServiceSetIdDesc()
	 * @generated
	 */
	EAttribute getServiceSetIdDesc_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getServiceDescriptors <em>Service Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Descriptors</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc#getServiceDescriptors()
	 * @see #getServiceSetIdDesc()
	 * @generated
	 */
	EReference getServiceSetIdDesc_ServiceDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection <em>Feature Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection
	 * @generated
	 */
	EClass getFeatureInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection#getDescription()
	 * @see #getFeatureInjection()
	 * @generated
	 */
	EAttribute getFeatureInjection_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc <em>Alias Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alias Id Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc
	 * @generated
	 */
	EClass getAliasIdDesc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc#getAliasedService <em>Aliased Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aliased Service</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc#getAliasedService()
	 * @see #getAliasIdDesc()
	 * @generated
	 */
	EAttribute getAliasIdDesc_AliasedService();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors <em>Id Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Descriptors</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors
	 * @generated
	 */
	EClass getIdDescriptors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors#getRegistries <em>Registries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registries</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors#getRegistries()
	 * @see #getIdDescriptors()
	 * @generated
	 */
	EReference getIdDescriptors_Registries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors#getServiceSets <em>Service Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Sets</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors#getServiceSets()
	 * @see #getIdDescriptors()
	 * @generated
	 */
	EReference getIdDescriptors_ServiceSets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection <em>Property Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection
	 * @generated
	 */
	EClass getPropertyInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getPropertyName()
	 * @see #getPropertyInjection()
	 * @generated
	 */
	EAttribute getPropertyInjection_PropertyName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getValues()
	 * @see #getPropertyInjection()
	 * @generated
	 */
	EReference getPropertyInjection_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue <em>Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injected Value</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue
	 * @generated
	 */
	EClass getInjectedValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue#getDescription()
	 * @see #getInjectedValue()
	 * @generated
	 */
	EAttribute getInjectedValue_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection <em>Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection
	 * @generated
	 */
	EClass getMethodInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.MethodInjection#getMethodName()
	 * @see #getMethodInjection()
	 * @generated
	 */
	EAttribute getMethodInjection_MethodName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection <em>Abstract Method Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Method Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection
	 * @generated
	 */
	EClass getAbstractMethodInjection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractMethodInjection#getParameters()
	 * @see #getAbstractMethodInjection()
	 * @generated
	 */
	EReference getAbstractMethodInjection_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection <em>Parameter Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection
	 * @generated
	 */
	EClass getParameterInjection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection#getParameterName()
	 * @see #getParameterInjection()
	 * @generated
	 */
	EAttribute getParameterInjection_ParameterName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ParameterInjection#getValues()
	 * @see #getParameterInjection()
	 * @generated
	 */
	EReference getParameterInjection_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService <em>Injected Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Injected Service</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService
	 * @generated
	 */
	EClass getInjectedService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedService#getServiceName()
	 * @see #getInjectedService()
	 * @generated
	 */
	EAttribute getInjectedService_ServiceName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue <em>Opaque Injected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Injected Value</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue
	 * @generated
	 */
	EClass getOpaqueInjectedValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue#getValue()
	 * @see #getOpaqueInjectedValue()
	 * @generated
	 */
	EAttribute getOpaqueInjectedValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ConstructorInjection <em>Constructor Injection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Injection</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ConstructorInjection
	 * @generated
	 */
	EClass getConstructorInjection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc <em>Service Factory Id Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Factory Id Desc</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc
	 * @generated
	 */
	EClass getServiceFactoryIdDesc();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind <em>Startup Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Startup Kind</em>'.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind
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
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

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
	ServicedescriptorswithidFactory getServicedescriptorswithidFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl <em>Registry Id Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.RegistryIdDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getRegistryIdDesc()
		 * @generated
		 */
		EClass REGISTRY_ID_DESC = eINSTANCE.getRegistryIdDesc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_ID_DESC__NAME = eINSTANCE.getRegistryIdDesc_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_ID_DESC__DESCRIPTION = eINSTANCE.getRegistryIdDesc_Description();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_ID_DESC__IS_UNIQUE = eINSTANCE.getRegistryIdDesc_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Sets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_ID_DESC__SETS = eINSTANCE.getRegistryIdDesc_Sets();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_ID_DESC__EXTENDS = eINSTANCE.getRegistryIdDesc_Extends();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTRY_ID_DESC__PARENTS = eINSTANCE.getRegistryIdDesc_Parents();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl <em>Service Id Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getServiceIdDesc()
		 * @generated
		 */
		EClass SERVICE_ID_DESC = eINSTANCE.getServiceIdDesc();

		/**
		 * The meta object literal for the '<em><b>Start Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_ID_DESC__START_KIND = eINSTANCE.getServiceIdDesc_StartKind();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_ID_DESC__CLASSNAME = eINSTANCE.getServiceIdDesc_Classname();

		/**
		 * The meta object literal for the '<em><b>Injections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_ID_DESC__INJECTIONS = eINSTANCE.getServiceIdDesc_Injections();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl <em>Abstract Service Id Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getAbstractServiceIdDesc()
		 * @generated
		 */
		EClass ABSTRACT_SERVICE_ID_DESC = eINSTANCE.getAbstractServiceIdDesc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_ID_DESC__NAME = eINSTANCE.getAbstractServiceIdDesc_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SERVICE_ID_DESC__NAMESPACE = eINSTANCE.getAbstractServiceIdDesc_Namespace();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_ID_DESC__DESCRIPTION = eINSTANCE.getAbstractServiceIdDesc_Description();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON = eINSTANCE.getAbstractServiceIdDesc_DependsOn();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_ID_DESC__PRIORITY = eINSTANCE.getAbstractServiceIdDesc_Priority();

		/**
		 * The meta object literal for the '<em><b>Bundle ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID = eINSTANCE.getAbstractServiceIdDesc_BundleID();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl <em>Service Set Id Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getServiceSetIdDesc()
		 * @generated
		 */
		EClass SERVICE_SET_ID_DESC = eINSTANCE.getServiceSetIdDesc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SET_ID_DESC__NAME = eINSTANCE.getServiceSetIdDesc_Name();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SET_ID_DESC__EXTENDS = eINSTANCE.getServiceSetIdDesc_Extends();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_SET_ID_DESC__DESCRIPTION = eINSTANCE.getServiceSetIdDesc_Description();

		/**
		 * The meta object literal for the '<em><b>Service Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS = eINSTANCE.getServiceSetIdDesc_ServiceDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.FeatureInjectionImpl <em>Feature Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.FeatureInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getFeatureInjection()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AliasIdDescImpl <em>Alias Id Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AliasIdDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getAliasIdDesc()
		 * @generated
		 */
		EClass ALIAS_ID_DESC = eINSTANCE.getAliasIdDesc();

		/**
		 * The meta object literal for the '<em><b>Aliased Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALIAS_ID_DESC__ALIASED_SERVICE = eINSTANCE.getAliasIdDesc_AliasedService();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.IdDescriptorsImpl <em>Id Descriptors</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.IdDescriptorsImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getIdDescriptors()
		 * @generated
		 */
		EClass ID_DESCRIPTORS = eINSTANCE.getIdDescriptors();

		/**
		 * The meta object literal for the '<em><b>Registries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_DESCRIPTORS__REGISTRIES = eINSTANCE.getIdDescriptors_Registries();

		/**
		 * The meta object literal for the '<em><b>Service Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_DESCRIPTORS__SERVICE_SETS = eINSTANCE.getIdDescriptors_ServiceSets();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.PropertyInjectionImpl <em>Property Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.PropertyInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getPropertyInjection()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedValueImpl <em>Injected Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedValueImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getInjectedValue()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.MethodInjectionImpl <em>Method Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.MethodInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getMethodInjection()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractMethodInjectionImpl <em>Abstract Method Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractMethodInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getAbstractMethodInjection()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ParameterInjectionImpl <em>Parameter Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ParameterInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getParameterInjection()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedServiceImpl <em>Injected Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.InjectedServiceImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getInjectedService()
		 * @generated
		 */
		EClass INJECTED_SERVICE = eINSTANCE.getInjectedService();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INJECTED_SERVICE__SERVICE_NAME = eINSTANCE.getInjectedService_ServiceName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.OpaqueInjectedValueImpl <em>Opaque Injected Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.OpaqueInjectedValueImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getOpaqueInjectedValue()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ConstructorInjectionImpl <em>Constructor Injection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ConstructorInjectionImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getConstructorInjection()
		 * @generated
		 */
		EClass CONSTRUCTOR_INJECTION = eINSTANCE.getConstructorInjection();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceFactoryIdDescImpl <em>Service Factory Id Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceFactoryIdDescImpl
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getServiceFactoryIdDesc()
		 * @generated
		 */
		EClass SERVICE_FACTORY_ID_DESC = eINSTANCE.getServiceFactoryIdDesc();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind <em>Startup Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getStartupKind()
		 * @generated
		 */
		EEnum STARTUP_KIND = eINSTANCE.getStartupKind();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getboolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getboolean();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidPackageImpl#getint()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getint();

	}

} //ServicedescriptorswithidPackage
