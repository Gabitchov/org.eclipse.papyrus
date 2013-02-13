/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Window</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPanel <em>Panel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getWindow()
 * @model
 * @generated
 */
public interface Window extends PanelParent {

	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference.
	 * @see #setPosition(Position)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getWindow_Position()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Position getPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Position value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' reference.
	 * @see #setSize(Size)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getWindow_Size()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Size getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getSize <em>Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Size value);

	/**
	 * Returns the value of the '<em><b>Panel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Redefine children.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Panel</em>' reference.
	 * @see #setPanel(AbstractPanel)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getWindow_Panel()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	AbstractPanel getPanel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.Window#getPanel <em>Panel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Panel</em>' reference.
	 * @see #getPanel()
	 * @generated
	 */
	void setPanel(AbstractPanel value);

} // Window
