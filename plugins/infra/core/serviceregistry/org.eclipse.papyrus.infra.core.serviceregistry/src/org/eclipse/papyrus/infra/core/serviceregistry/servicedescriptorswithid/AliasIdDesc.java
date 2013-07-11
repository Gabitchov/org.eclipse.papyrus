/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc#getAliasedService <em>Aliased Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getAliasIdDesc()
 * @model
 * @generated
 */
public interface AliasIdDesc extends AbstractServiceIdDesc {
	/**
	 * Returns the value of the '<em><b>Aliased Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aliased Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aliased Service</em>' attribute.
	 * @see #setAliasedService(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getAliasIdDesc_AliasedService()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String" required="true" ordered="false"
	 * @generated
	 */
	String getAliasedService();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc#getAliasedService <em>Aliased Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aliased Service</em>' attribute.
	 * @see #getAliasedService()
	 * @generated
	 */
	void setAliasedService(String value);

} // AliasIdDesc
