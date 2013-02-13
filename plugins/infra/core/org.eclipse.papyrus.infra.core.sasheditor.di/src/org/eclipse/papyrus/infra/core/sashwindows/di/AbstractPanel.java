/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getAbstractPanel()
 * @model abstract="true"
 * @generated
 */
public interface AbstractPanel extends EObject {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(PanelParent)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getAbstractPanel_Parent()
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent#getChildren
	 * @model opposite="children" required="true" transient="false" ordered="false"
	 * @generated
	 */
	PanelParent getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(PanelParent value);
} // AbstractPanel
