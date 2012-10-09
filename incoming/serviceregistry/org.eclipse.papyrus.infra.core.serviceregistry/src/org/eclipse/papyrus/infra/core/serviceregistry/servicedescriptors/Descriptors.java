/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptors</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors#getRegistries <em>Registries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors#getServiceSets <em>Service Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getDescriptors()
 * @model
 * @generated
 */
public interface Descriptors extends EObject {
	/**
	 * Returns the value of the '<em><b>Registries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registries</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getDescriptors_Registries()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<RegistryDesc> getRegistries();

	/**
	 * Returns the value of the '<em><b>Service Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Sets</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getDescriptors_ServiceSets()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ServiceSetDesc> getServiceSets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	RegistryDesc getRegistryDesc(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	ServiceSetDesc getServiceSetDesc(String name);

} // Descriptors
