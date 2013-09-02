/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robotic System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalPosition <em>Local Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalOrientation <em>Local Orientation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRoboticSystem()
 * @model
 * @generated
 */
public interface RoboticSystem extends org.eclipse.papyrus.RobotML.System {
	/**
	 * Returns the value of the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Position</em>' containment reference.
	 * @see #setLocalPosition(Point32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRoboticSystem_LocalPosition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Point32 getLocalPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalPosition <em>Local Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Position</em>' containment reference.
	 * @see #getLocalPosition()
	 * @generated
	 */
	void setLocalPosition(Point32 value);

	/**
	 * Returns the value of the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Orientation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Orientation</em>' containment reference.
	 * @see #setLocalOrientation(Point32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRoboticSystem_LocalOrientation()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Point32 getLocalOrientation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalOrientation <em>Local Orientation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Orientation</em>' containment reference.
	 * @see #getLocalOrientation()
	 * @generated
	 */
	void setLocalOrientation(Point32 value);

} // RoboticSystem
