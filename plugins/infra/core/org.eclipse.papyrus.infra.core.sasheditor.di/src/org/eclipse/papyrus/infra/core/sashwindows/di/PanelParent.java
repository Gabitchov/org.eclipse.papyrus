/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Panel Parent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPanelParent()
 * @model abstract="true"
 * @generated
 */
public interface PanelParent extends EObject {

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getPanelParent_Children()
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel#getParent
	 * @model opposite="parent" containment="true" lower="2" upper="2" ordered="false"
	 * @generated
	 */
	EList<AbstractPanel> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Replace the specified child by the new value.
	 * Don't need to be implemented in TabFolder.
	 * Used to insert a new SashPanel.
	 * <!-- end-model-doc -->
	 * @model oldChildRequired="true" oldChildOrdered="false" newChildRequired="true" newChildOrdered="false"
	 * @generated
	 */
	void replaceChild(AbstractPanel oldChild, AbstractPanel newChild);

} // PanelParent
