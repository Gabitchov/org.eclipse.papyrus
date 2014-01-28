/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Steered Wheel System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelRadius <em>Wheel Radius</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelWidth <em>Wheel Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionRestLength <em>Suspension Rest Length</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelConnectionHeight <em>Wheel Connection Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getTypeOfWheel <em>Type Of Wheel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelFriction <em>Wheel Friction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionStiffness <em>Suspension Stiffness</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionDamping <em>Suspension Damping</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionCompression <em>Suspension Compression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem()
 * @model
 * @generated
 */
public interface SteeredWheelSystem extends LocomotionSystem {
	/**
	 * Returns the value of the '<em><b>Wheel Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Radius</em>' attribute.
	 * @see #setWheelRadius(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelRadius()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelRadius();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelRadius <em>Wheel Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Radius</em>' attribute.
	 * @see #getWheelRadius()
	 * @generated
	 */
	void setWheelRadius(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Width</em>' attribute.
	 * @see #setWheelWidth(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelWidth()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelWidth <em>Wheel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Width</em>' attribute.
	 * @see #getWheelWidth()
	 * @generated
	 */
	void setWheelWidth(float value);

	/**
	 * Returns the value of the '<em><b>Suspension Rest Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Rest Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Rest Length</em>' attribute.
	 * @see #setSuspensionRestLength(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionRestLength()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getSuspensionRestLength();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionRestLength <em>Suspension Rest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Rest Length</em>' attribute.
	 * @see #getSuspensionRestLength()
	 * @generated
	 */
	void setSuspensionRestLength(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Connection Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Connection Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Connection Height</em>' attribute.
	 * @see #setWheelConnectionHeight(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelConnectionHeight()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelConnectionHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelConnectionHeight <em>Wheel Connection Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Connection Height</em>' attribute.
	 * @see #getWheelConnectionHeight()
	 * @generated
	 */
	void setWheelConnectionHeight(float value);

	/**
	 * Returns the value of the '<em><b>Type Of Wheel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Of Wheel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Of Wheel</em>' attribute.
	 * @see #setTypeOfWheel(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_TypeOfWheel()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getTypeOfWheel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getTypeOfWheel <em>Type Of Wheel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Of Wheel</em>' attribute.
	 * @see #getTypeOfWheel()
	 * @generated
	 */
	void setTypeOfWheel(String value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dkp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dkp</em>' attribute.
	 * @see #setWheelVelocityPIDkp(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDkp()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelVelocityPIDkp();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dkp</em>' attribute.
	 * @see #getWheelVelocityPIDkp()
	 * @generated
	 */
	void setWheelVelocityPIDkp(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dki</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dki</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dki</em>' attribute.
	 * @see #setWheelVelocityPIDki(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDki()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelVelocityPIDki();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dki</em>' attribute.
	 * @see #getWheelVelocityPIDki()
	 * @generated
	 */
	void setWheelVelocityPIDki(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dkd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dkd</em>' attribute.
	 * @see #setWheelVelocityPIDkd(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDkd()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelVelocityPIDkd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dkd</em>' attribute.
	 * @see #getWheelVelocityPIDkd()
	 * @generated
	 */
	void setWheelVelocityPIDkd(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Steering PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Steering PI Dkp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Steering PI Dkp</em>' attribute.
	 * @see #setWheelSteeringPIDkp(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelSteeringPIDkp()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelSteeringPIDkp();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Steering PI Dkp</em>' attribute.
	 * @see #getWheelSteeringPIDkp()
	 * @generated
	 */
	void setWheelSteeringPIDkp(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Steering PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Steering PI Dkd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Steering PI Dkd</em>' attribute.
	 * @see #setWheelSteeringPIDkd(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelSteeringPIDkd()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelSteeringPIDkd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Steering PI Dkd</em>' attribute.
	 * @see #getWheelSteeringPIDkd()
	 * @generated
	 */
	void setWheelSteeringPIDkd(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Friction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Friction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Friction</em>' attribute.
	 * @see #setWheelFriction(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelFriction()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelFriction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelFriction <em>Wheel Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Friction</em>' attribute.
	 * @see #getWheelFriction()
	 * @generated
	 */
	void setWheelFriction(float value);

	/**
	 * Returns the value of the '<em><b>Suspension Stiffness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Stiffness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Stiffness</em>' attribute.
	 * @see #setSuspensionStiffness(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionStiffness()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getSuspensionStiffness();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionStiffness <em>Suspension Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Stiffness</em>' attribute.
	 * @see #getSuspensionStiffness()
	 * @generated
	 */
	void setSuspensionStiffness(float value);

	/**
	 * Returns the value of the '<em><b>Suspension Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Damping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Damping</em>' attribute.
	 * @see #setSuspensionDamping(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionDamping()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getSuspensionDamping();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionDamping <em>Suspension Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Damping</em>' attribute.
	 * @see #getSuspensionDamping()
	 * @generated
	 */
	void setSuspensionDamping(float value);

	/**
	 * Returns the value of the '<em><b>Suspension Compression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Compression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Compression</em>' attribute.
	 * @see #setSuspensionCompression(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionCompression()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getSuspensionCompression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionCompression <em>Suspension Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Compression</em>' attribute.
	 * @see #getSuspensionCompression()
	 * @generated
	 */
	void setSuspensionCompression(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dmax Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dmax Sum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dmax Sum</em>' attribute.
	 * @see #setWheelVelocityPIDmaxSum(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDmaxSum()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelVelocityPIDmaxSum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dmax Sum</em>' attribute.
	 * @see #getWheelVelocityPIDmaxSum()
	 * @generated
	 */
	void setWheelVelocityPIDmaxSum(float value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dmax Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dmax Val</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dmax Val</em>' attribute.
	 * @see #setWheelVelocityPIDmaxVal(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDmaxVal()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWheelVelocityPIDmaxVal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dmax Val</em>' attribute.
	 * @see #getWheelVelocityPIDmaxVal()
	 * @generated
	 */
	void setWheelVelocityPIDmaxVal(float value);

} // SteeredWheelSystem
