/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Odometer Linear Left Right</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_left <em>Odometer linear left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_right <em>Odometer linear right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage#getOdometer_Linear_Left_Right()
 * @model
 * @generated
 */
public interface Odometer_Linear_Left_Right extends EObject {
	/**
	 * Returns the value of the '<em><b>Odometer linear left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Odometer linear left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Odometer linear left</em>' containment reference.
	 * @see #setOdometer_linear_left(Metric)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage#getOdometer_Linear_Left_Right_Odometer_linear_left()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Metric getOdometer_linear_left();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_left <em>Odometer linear left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Odometer linear left</em>' containment reference.
	 * @see #getOdometer_linear_left()
	 * @generated
	 */
	void setOdometer_linear_left(Metric value);

	/**
	 * Returns the value of the '<em><b>Odometer linear right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Odometer linear right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Odometer linear right</em>' containment reference.
	 * @see #setOdometer_linear_right(Metric)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage#getOdometer_Linear_Left_Right_Odometer_linear_right()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Metric getOdometer_linear_right();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_right <em>Odometer linear right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Odometer linear right</em>' containment reference.
	 * @see #getOdometer_linear_right()
	 * @generated
	 */
	void setOdometer_linear_right(Metric value);

} // Odometer_Linear_Left_Right
