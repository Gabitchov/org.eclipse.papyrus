/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mobile Robot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.MobileRobot#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getMobileRobot()
 * @model
 * @generated
 */
public interface MobileRobot extends Robot {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.MobileRobotKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.MobileRobotKind
	 * @see #setKind(MobileRobotKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getMobileRobot_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MobileRobotKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.MobileRobot#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.MobileRobotKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MobileRobotKind value);

} // MobileRobot
