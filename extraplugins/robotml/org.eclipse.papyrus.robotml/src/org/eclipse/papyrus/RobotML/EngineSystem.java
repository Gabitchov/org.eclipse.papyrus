/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Engine System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.EngineSystem#getVehicleTraction <em>Vehicle Traction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxEngineForce <em>Max Engine Force</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxBreakingForce <em>Max Breaking Force</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedSteering <em>Max Allowed Steering</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedVelocity <em>Max Allowed Velocity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.EngineSystem#getGear_ration <em>Gear ration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem()
 * @model
 * @generated
 */
public interface EngineSystem extends ActuatorSystem {
	/**
	 * Returns the value of the '<em><b>Vehicle Traction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle Traction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Traction</em>' attribute.
	 * @see #setVehicleTraction(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem_VehicleTraction()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getVehicleTraction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.EngineSystem#getVehicleTraction <em>Vehicle Traction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Traction</em>' attribute.
	 * @see #getVehicleTraction()
	 * @generated
	 */
	void setVehicleTraction(String value);

	/**
	 * Returns the value of the '<em><b>Max Engine Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Engine Force</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Engine Force</em>' attribute.
	 * @see #setMaxEngineForce(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem_MaxEngineForce()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getMaxEngineForce();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxEngineForce <em>Max Engine Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Engine Force</em>' attribute.
	 * @see #getMaxEngineForce()
	 * @generated
	 */
	void setMaxEngineForce(float value);

	/**
	 * Returns the value of the '<em><b>Max Breaking Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Breaking Force</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Breaking Force</em>' attribute.
	 * @see #setMaxBreakingForce(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem_MaxBreakingForce()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getMaxBreakingForce();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxBreakingForce <em>Max Breaking Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Breaking Force</em>' attribute.
	 * @see #getMaxBreakingForce()
	 * @generated
	 */
	void setMaxBreakingForce(float value);

	/**
	 * Returns the value of the '<em><b>Max Allowed Steering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Allowed Steering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Allowed Steering</em>' attribute.
	 * @see #setMaxAllowedSteering(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem_MaxAllowedSteering()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getMaxAllowedSteering();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedSteering <em>Max Allowed Steering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Allowed Steering</em>' attribute.
	 * @see #getMaxAllowedSteering()
	 * @generated
	 */
	void setMaxAllowedSteering(float value);

	/**
	 * Returns the value of the '<em><b>Max Allowed Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Allowed Velocity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Allowed Velocity</em>' attribute.
	 * @see #setMaxAllowedVelocity(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem_MaxAllowedVelocity()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getMaxAllowedVelocity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedVelocity <em>Max Allowed Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Allowed Velocity</em>' attribute.
	 * @see #getMaxAllowedVelocity()
	 * @generated
	 */
	void setMaxAllowedVelocity(float value);

	/**
	 * Returns the value of the '<em><b>Gear ration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gear ration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gear ration</em>' attribute.
	 * @see #setGear_ration(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getEngineSystem_Gear_ration()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getGear_ration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.EngineSystem#getGear_ration <em>Gear ration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gear ration</em>' attribute.
	 * @see #getGear_ration()
	 * @generated
	 */
	void setGear_ration(float value);

} // EngineSystem
