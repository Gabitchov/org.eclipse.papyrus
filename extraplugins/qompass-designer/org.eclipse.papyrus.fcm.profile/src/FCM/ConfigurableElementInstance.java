/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurable Element Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.ConfigurableElementInstance#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getConfigurableElementInstance()
 * @model abstract="true"
 * @generated
 */
public interface ConfigurableElementInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(InstanceSpecification)
	 * @see FCM.FCMPackage#getConfigurableElementInstance_Configuration()
	 * @model ordered="false"
	 * @generated
	 */
	InstanceSpecification getConfiguration();

	/**
	 * Sets the value of the '{@link FCM.ConfigurableElementInstance#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(InstanceSpecification value);

} // ConfigurableElementInstance
