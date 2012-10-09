/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getPropertyInjection()
 * @model
 * @generated
 */
public interface PropertyInjection extends FeatureInjection {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getPropertyInjection_PropertyName()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String" required="true" ordered="false"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.PropertyInjection#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.InjectedValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getPropertyInjection_Values()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InjectedValue> getValues();

} // PropertyInjection
