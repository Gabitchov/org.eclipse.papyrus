/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sash Panel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl#getSashPosition <em>Sash Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.SashPanelImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SashPanelImpl extends AbstractPanelImpl implements SashPanel {

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractPanel> children;

	/**
	 * The default value of the '{@link #getSashPosition() <em>Sash Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSashPosition()
	 * @generated
	 * @ordered
	 */
	protected static final float SASH_POSITION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSashPosition() <em>Sash Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSashPosition()
	 * @generated
	 * @ordered
	 */
	protected float sashPosition = SASH_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final int DIRECTION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected int direction = DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SashPanelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.SASH_PANEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractPanel> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<AbstractPanel>(AbstractPanel.class, this, DiPackage.SASH_PANEL__CHILDREN, DiPackage.ABSTRACT_PANEL__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSashPosition() {
		return sashPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSashPosition(float newSashPosition) {
		float oldSashPosition = sashPosition;
		sashPosition = newSashPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.SASH_PANEL__SASH_POSITION, oldSashPosition, sashPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(int newDirection) {
		int oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.SASH_PANEL__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setChildren(AbstractPanel leftChild, AbstractPanel rightChild, int direction) {
		setDirection(direction);
		List<AbstractPanel> children = getChildren();

		if(children.size() == 0) {
			children.add(leftChild);
			children.add(rightChild);

		} else {
			children.set(0, leftChild);
			children.set(1, rightChild);
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void delete(AbstractPanel childToDelete) {
		// Get the other child
		EList<AbstractPanel> children = getChildren();
		AbstractPanel otherChild = (childToDelete == children.get(0) ? children.get(1) : children.get(0));

		PanelParent parent = getParent();
		// Change parent
		//		otherChild.setParent( parent );
		parent.replaceChild(this, otherChild);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.SASH_PANEL__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.SASH_PANEL__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiPackage.SASH_PANEL__CHILDREN:
				return getChildren();
			case DiPackage.SASH_PANEL__SASH_POSITION:
				return getSashPosition();
			case DiPackage.SASH_PANEL__DIRECTION:
				return getDirection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiPackage.SASH_PANEL__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends AbstractPanel>)newValue);
				return;
			case DiPackage.SASH_PANEL__SASH_POSITION:
				setSashPosition((Float)newValue);
				return;
			case DiPackage.SASH_PANEL__DIRECTION:
				setDirection((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiPackage.SASH_PANEL__CHILDREN:
				getChildren().clear();
				return;
			case DiPackage.SASH_PANEL__SASH_POSITION:
				setSashPosition(SASH_POSITION_EDEFAULT);
				return;
			case DiPackage.SASH_PANEL__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiPackage.SASH_PANEL__CHILDREN:
				return children != null && !children.isEmpty();
			case DiPackage.SASH_PANEL__SASH_POSITION:
				return sashPosition != SASH_POSITION_EDEFAULT;
			case DiPackage.SASH_PANEL__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PanelParent.class) {
			switch (derivedFeatureID) {
				case DiPackage.SASH_PANEL__CHILDREN: return DiPackage.PANEL_PARENT__CHILDREN;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PanelParent.class) {
			switch (baseFeatureID) {
				case DiPackage.PANEL_PARENT__CHILDREN: return DiPackage.SASH_PANEL__CHILDREN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sashPosition: ");
		result.append(sashPosition);
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Set both ends (parent and child).
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void replaceChild(AbstractPanel oldChild, AbstractPanel newChild) {

		int index = getChildren().indexOf(oldChild);
		if(index >= 0) {
			// do replace
			getChildren().set(index, newChild);
			newChild.setParent(this);
		} else
			throw new IndexOutOfBoundsException("Child '" + oldChild + "' not found in sash. Can't replace it.");
	}

} //SashPanelImpl
