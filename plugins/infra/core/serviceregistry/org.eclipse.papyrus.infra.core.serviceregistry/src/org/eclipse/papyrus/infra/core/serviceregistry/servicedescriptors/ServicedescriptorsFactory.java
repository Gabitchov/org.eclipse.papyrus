/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage
 * @generated
 */
public interface ServicedescriptorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicedescriptorsFactory eINSTANCE = org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServicedescriptorsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Registry Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registry Desc</em>'.
	 * @generated
	 */
	RegistryDesc createRegistryDesc();

	/**
	 * Returns a new object of class '<em>Service Set Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Set Desc</em>'.
	 * @generated
	 */
	ServiceSetDesc createServiceSetDesc();

	/**
	 * Returns a new object of class '<em>Service Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Desc</em>'.
	 * @generated
	 */
	ServiceDesc createServiceDesc();

	/**
	 * Returns a new object of class '<em>Alias Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alias Desc</em>'.
	 * @generated
	 */
	AliasDesc createAliasDesc();

	/**
	 * Returns a new object of class '<em>Descriptors</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptors</em>'.
	 * @generated
	 */
	Descriptors createDescriptors();

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
	 * Returns a new object of class '<em>Service Factory Desc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Factory Desc</em>'.
	 * @generated
	 */
	ServiceFactoryDesc createServiceFactoryDesc();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ServicedescriptorsPackage getServicedescriptorsPackage();

} //ServicedescriptorsFactory
