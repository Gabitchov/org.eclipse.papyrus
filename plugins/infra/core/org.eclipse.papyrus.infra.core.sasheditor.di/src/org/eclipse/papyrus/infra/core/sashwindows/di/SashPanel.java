/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sash Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getSashPosition <em>Sash Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashPanel()
 * @model
 * @generated
 */
public interface SashPanel extends AbstractPanel, PanelParent {

	/**
	 * Returns the value of the '<em><b>Sash Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Position of the sash in the panel. The position is in percent. The value should be between 0 and 100.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sash Position</em>' attribute.
	 * @see #setSashPosition(float)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashPanel_SashPosition()
	 * @model unique="false" dataType="org.eclipse.papyrus.infra.core.sashwindows.di.Float" required="true" ordered="false"
	 * @generated
	 */
	float getSashPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getSashPosition <em>Sash Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sash Position</em>' attribute.
	 * @see #getSashPosition()
	 * @generated
	 */
	void setSashPosition(float value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see #setDirection(int)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashPanel_Direction()
	 * @model unique="false" dataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" required="true" ordered="false"
	 * @generated
	 */
	int getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model leftChildRequired="true" leftChildOrdered="false" rightChildRequired="true" rightChildOrdered="false" directionDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" directionRequired="true" directionOrdered="false"
	 * @generated
	 */
	void setChildren(AbstractPanel leftChild, AbstractPanel rightChild, int direction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model childToDeleteRequired="true" childToDeleteOrdered="false"
	 * @generated
	 */
	void delete(AbstractPanel childToDelete);

} // SashPanel
