/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedService <em>Aliased Service</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedServiceId <em>Aliased Service Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAliasDesc()
 * @model
 * @generated
 */
public interface AliasDesc extends AbstractServiceDesc {
	/**
	 * Returns the value of the '<em><b>Aliased Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aliased Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aliased Service</em>' reference.
	 * @see #setAliasedService(ServiceDesc)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAliasDesc_AliasedService()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ServiceDesc getAliasedService();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedService <em>Aliased Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aliased Service</em>' reference.
	 * @see #getAliasedService()
	 * @generated
	 */
	void setAliasedService(ServiceDesc value);

	/**
	 * Returns the value of the '<em><b>Aliased Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aliased Service Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aliased Service Id</em>' attribute.
	 * @see #setAliasedServiceId(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAliasDesc_AliasedServiceId()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getAliasedServiceId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc#getAliasedServiceId <em>Aliased Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aliased Service Id</em>' attribute.
	 * @see #getAliasedServiceId()
	 * @generated
	 */
	void setAliasedServiceId(String value);

} // AliasDesc
