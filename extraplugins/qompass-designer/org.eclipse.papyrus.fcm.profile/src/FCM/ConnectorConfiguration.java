/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.ConnectorConfiguration#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link FCM.ConnectorConfiguration#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getConnectorConfiguration()
 * @model
 * @generated
 */
public interface ConnectorConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Slot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Slot</em>' reference.
	 * @see #setBase_Slot(Slot)
	 * @see FCM.FCMPackage#getConnectorConfiguration_Base_Slot()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Slot getBase_Slot();

	/**
	 * Sets the value of the '{@link FCM.ConnectorConfiguration#getBase_Slot <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Slot</em>' reference.
	 * @see #getBase_Slot()
	 * @generated
	 */
	void setBase_Slot(Slot value);

	/**
	 * Returns the value of the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector</em>' reference.
	 * @see #setConnector(Connector)
	 * @see FCM.FCMPackage#getConnectorConfiguration_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getConnector();

	/**
	 * Sets the value of the '{@link FCM.ConnectorConfiguration#getConnector <em>Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector</em>' reference.
	 * @see #getConnector()
	 * @generated
	 */
	void setConnector(Connector value);

} // ConnectorConfiguration
