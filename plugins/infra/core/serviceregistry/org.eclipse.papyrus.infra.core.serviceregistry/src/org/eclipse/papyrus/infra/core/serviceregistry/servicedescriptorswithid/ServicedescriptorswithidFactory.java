/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage
 * @generated
 */
public interface ServicedescriptorswithidFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicedescriptorswithidFactory eINSTANCE = org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServicedescriptorswithidFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Registry Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registry Id Desc</em>'.
	 * @generated
	 */
	RegistryIdDesc createRegistryIdDesc();

	/**
	 * Returns a new object of class '<em>Service Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Id Desc</em>'.
	 * @generated
	 */
	ServiceIdDesc createServiceIdDesc();

	/**
	 * Returns a new object of class '<em>Service Set Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Set Id Desc</em>'.
	 * @generated
	 */
	ServiceSetIdDesc createServiceSetIdDesc();

	/**
	 * Returns a new object of class '<em>Alias Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alias Id Desc</em>'.
	 * @generated
	 */
	AliasIdDesc createAliasIdDesc();

	/**
	 * Returns a new object of class '<em>Id Descriptors</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Descriptors</em>'.
	 * @generated
	 */
	IdDescriptors createIdDescriptors();

	/**
	 * Returns a new object of class '<em>Property Injection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Injection</em>'.
	 * @generated
	 */
	PropertyInjection createPropertyInjection();

	/**
	 * Returns a new object of class '<em>Method Injection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Injection</em>'.
	 * @generated
	 */
	MethodInjection createMethodInjection();

	/**
	 * Returns a new object of class '<em>Parameter Injection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Injection</em>'.
	 * @generated
	 */
	ParameterInjection createParameterInjection();

	/**
	 * Returns a new object of class '<em>Injected Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Injected Service</em>'.
	 * @generated
	 */
	InjectedService createInjectedService();

	/**
	 * Returns a new object of class '<em>Opaque Injected Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opaque Injected Value</em>'.
	 * @generated
	 */
	OpaqueInjectedValue createOpaqueInjectedValue();

	/**
	 * Returns a new object of class '<em>Constructor Injection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructor Injection</em>'.
	 * @generated
	 */
	ConstructorInjection createConstructorInjection();

	/**
	 * Returns a new object of class '<em>Service Factory Id Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Factory Id Desc</em>'.
	 * @generated
	 */
	ServiceFactoryIdDesc createServiceFactoryIdDesc();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServicedescriptorswithidPackage getServicedescriptorswithidPackage();

} //ServicedescriptorswithidFactory
