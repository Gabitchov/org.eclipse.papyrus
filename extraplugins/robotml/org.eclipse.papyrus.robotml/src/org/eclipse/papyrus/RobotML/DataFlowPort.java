/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.DataFlowPort#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.DataFlowPort#getBufferSize <em>Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataFlowPort()
 * @model
 * @generated
 */
public interface DataFlowPort extends Port {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
	 * @see #setDirection(DataFlowDirectionKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataFlowPort_Direction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataFlowDirectionKind getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DataFlowPort#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DataFlowDirectionKind value);

	/**
	 * Returns the value of the '<em><b>Buffer Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Size</em>' attribute.
	 * @see #setBufferSize(int)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataFlowPort_BufferSize()
	 * @model default="0" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getBufferSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DataFlowPort#getBufferSize <em>Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Size</em>' attribute.
	 * @see #getBufferSize()
	 * @generated
	 */
	void setBufferSize(int value);

} // DataFlowPort
