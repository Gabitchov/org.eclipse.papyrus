/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.AbstractPanel#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sashwindows.di.AbstractPanel#getWindow <em>Window</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#getAbstractPanel()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPanel extends AbstractNode {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(AbstractNode)
	 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#getAbstractPanel_Parent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sashwindows.di.AbstractPanel#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(AbstractNode value);

	/**
	 * Returns the value of the '<em><b>Window</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.sashwindows.di.Window#getPanel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Window</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Window</em>' container reference.
	 * @see #setWindow(Window)
	 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#getAbstractPanel_Window()
	 * @see org.eclipse.papyrus.sashwindows.di.Window#getPanel
	 * @model opposite="panel" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Window getWindow();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sashwindows.di.AbstractPanel#getWindow <em>Window</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Window</em>' container reference.
	 * @see #getWindow()
	 * @generated
	 */
	void setWindow(Window value);

} // AbstractPanel
