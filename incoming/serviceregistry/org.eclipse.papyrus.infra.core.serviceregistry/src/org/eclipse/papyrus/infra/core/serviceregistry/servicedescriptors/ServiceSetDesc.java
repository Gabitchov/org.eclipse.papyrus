/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Set Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getOwnedServices <em>Owned Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getServiceSetDesc()
 * @model
 * @generated
 */
public interface ServiceSetDesc extends EObject {
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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getServiceSetDesc_Services()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AbstractServiceDesc> getServices();

	/**
	 * Returns the value of the '<em><b>Owned Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Services</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getServiceSetDesc_OwnedServices()
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractServiceDesc> getOwnedServices();

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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getServiceSetDesc_Name()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getServiceSetDesc_Extends()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ServiceSetDesc> getExtends();

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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getServiceSetDesc_Description()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.boolean" required="true" ordered="false" serviceIdDataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" serviceIdRequired="true" serviceIdOrdered="false"
	 * @generated
	 */
	boolean servicesContains(String serviceId);

} // ServiceSetDesc
