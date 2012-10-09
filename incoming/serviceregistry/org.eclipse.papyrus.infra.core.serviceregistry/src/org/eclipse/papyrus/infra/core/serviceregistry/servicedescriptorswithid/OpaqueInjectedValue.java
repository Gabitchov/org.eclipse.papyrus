/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Injected Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getOpaqueInjectedValue()
 * @model
 * @generated
 */
public interface OpaqueInjectedValue extends InjectedValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getOpaqueInjectedValue_Value()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String" required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.OpaqueInjectedValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // OpaqueInjectedValue
