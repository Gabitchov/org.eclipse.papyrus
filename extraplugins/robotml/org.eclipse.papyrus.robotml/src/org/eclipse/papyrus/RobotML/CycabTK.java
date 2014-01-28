/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cycab TK</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.CycabTK#isUseRealTime <em>Use Real Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.CycabTK#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.CycabTK#getTimeFactor <em>Time Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getCycabTK()
 * @model
 * @generated
 */
public interface CycabTK extends RoboticSimulator {
	/**
	 * Returns the value of the '<em><b>Use Real Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Real Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Real Time</em>' attribute.
	 * @see #setUseRealTime(boolean)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getCycabTK_UseRealTime()
	 * @model dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isUseRealTime();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.CycabTK#isUseRealTime <em>Use Real Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Real Time</em>' attribute.
	 * @see #isUseRealTime()
	 * @generated
	 */
	void setUseRealTime(boolean value);

	/**
	 * Returns the value of the '<em><b>Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Step</em>' attribute.
	 * @see #setTimeStep(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getCycabTK_TimeStep()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" ordered="false"
	 * @generated
	 */
	float getTimeStep();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.CycabTK#getTimeStep <em>Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Step</em>' attribute.
	 * @see #getTimeStep()
	 * @generated
	 */
	void setTimeStep(float value);

	/**
	 * Returns the value of the '<em><b>Time Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Factor</em>' attribute.
	 * @see #setTimeFactor(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getCycabTK_TimeFactor()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" ordered="false"
	 * @generated
	 */
	float getTimeFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.CycabTK#getTimeFactor <em>Time Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Factor</em>' attribute.
	 * @see #getTimeFactor()
	 * @generated
	 */
	void setTimeFactor(float value);

} // CycabTK
