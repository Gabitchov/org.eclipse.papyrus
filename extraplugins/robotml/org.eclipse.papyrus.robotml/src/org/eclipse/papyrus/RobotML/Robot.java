/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.Robot#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.Robot#getMass <em>Mass</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.Robot#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.Robot#getUgvKind <em>Ugv Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRobot()
 * @model
 * @generated
 */
public interface Robot extends Agent, org.eclipse.papyrus.RobotML.System {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"UGVcar"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.RobotKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.RobotKind
	 * @see #setKind(RobotKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRobot_Kind()
	 * @model default="UGVcar" required="true" ordered="false"
	 * @generated
	 */
	RobotKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Robot#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.RobotKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(RobotKind value);

	/**
	 * Returns the value of the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mass</em>' attribute.
	 * @see #setMass(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRobot_Mass()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getMass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Robot#getMass <em>Mass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mass</em>' attribute.
	 * @see #getMass()
	 * @generated
	 */
	void setMass(float value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRobot_Width()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Robot#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(float value);

	/**
	 * Returns the value of the '<em><b>Ugv Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.UGVKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ugv Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ugv Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.UGVKind
	 * @see #setUgvKind(UGVKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRobot_UgvKind()
	 * @model ordered="false"
	 * @generated
	 */
	UGVKind getUgvKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Robot#getUgvKind <em>Ugv Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ugv Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.UGVKind
	 * @see #getUgvKind()
	 * @generated
	 */
	void setUgvKind(UGVKind value);

} // Robot
