/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GPS System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.GPSSystem#getOriginPosition <em>Origin Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getGPSSystem()
 * @model
 * @generated
 */
public interface GPSSystem extends LocalizationSensorSystem {
	/**
	 * Returns the value of the '<em><b>Origin Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Position</em>' containment reference.
	 * @see #setOriginPosition(Point32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getGPSSystem_OriginPosition()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Point32 getOriginPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.GPSSystem#getOriginPosition <em>Origin Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Position</em>' containment reference.
	 * @see #getOriginPosition()
	 * @generated
	 */
	void setOriginPosition(Point32 value);

} // GPSSystem
