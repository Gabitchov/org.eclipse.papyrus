/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robotic Middleware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.RoboticMiddleware#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRoboticMiddleware()
 * @model
 * @generated
 */
public interface RoboticMiddleware extends Platform {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
	 * @see #setKind(RoboticMiddlewareKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getRoboticMiddleware_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RoboticMiddlewareKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.RoboticMiddleware#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(RoboticMiddlewareKind value);

} // RoboticMiddleware
