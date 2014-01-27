/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.ServicePort#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getServicePort()
 * @model
 * @generated
 */
public interface ServicePort extends Port {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.ServiceFlowKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
	 * @see #setKind(ServiceFlowKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getServicePort_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ServiceFlowKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.ServicePort#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ServiceFlowKind value);

} // ServicePort
