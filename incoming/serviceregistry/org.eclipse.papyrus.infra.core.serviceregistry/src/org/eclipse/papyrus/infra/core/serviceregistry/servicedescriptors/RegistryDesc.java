/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registry Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getParents <em>Parents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getServiceSets <em>Service Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc()
 * @model
 * @generated
 */
public interface RegistryDesc extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_Name()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_Parents()
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getChildren
	 * @model opposite="children" ordered="false"
	 * @generated
	 */
	EList<RegistryDesc> getParents();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_Children()
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getParents
	 * @model opposite="parents" ordered="false"
	 * @generated
	 */
	EList<RegistryDesc> getChildren();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_Extends()
	 * @model ordered="false"
	 * @generated
	 */
	EList<RegistryDesc> getExtends();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_Description()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Service Sets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Sets</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_ServiceSets()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ServiceSetDesc> getServiceSets();

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_IsUnique()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc#isUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getRegistryDesc_Services()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AbstractServiceDesc> getServices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" serviceIdDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" serviceIdRequired="true" serviceIdOrdered="false"
	 * @generated
	 */
	AbstractServiceDesc getServiceDesc(String serviceId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" serviceSetsIdDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" serviceSetsIdRequired="true" serviceSetsIdOrdered="false"
	 * @generated
	 */
	ServiceSetDesc getServiceSetDesc(String serviceSetsId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.boolean" required="true" ordered="false" serviceIdDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" serviceIdRequired="true" serviceIdOrdered="false"
	 * @generated
	 */
	boolean servicesContains(String serviceId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.boolean" required="true" ordered="false" serviceSetsIdDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" serviceSetsIdRequired="true" serviceSetsIdOrdered="false"
	 * @generated
	 */
	boolean serviceSetsContains(String serviceSetsId);

} // RegistryDesc
