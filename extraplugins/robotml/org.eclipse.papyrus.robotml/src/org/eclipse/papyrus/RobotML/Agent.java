/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.emf.common.util.EList;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.Agent#getMovesOver <em>Moves Over</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getAgent()
 * @model
 * @generated
 */
public interface Agent extends PhysicalObject {
	/**
	 * Returns the value of the '<em><b>Moves Over</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.RobotML.Surface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moves Over</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moves Over</em>' reference list.
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getAgent_MovesOver()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Surface> getMovesOver();

} // Agent
