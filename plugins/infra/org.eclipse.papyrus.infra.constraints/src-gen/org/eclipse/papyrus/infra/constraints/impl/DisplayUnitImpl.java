/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Display Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl#getElementMultiplicity <em>Element Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DisplayUnitImpl extends EObjectImpl implements DisplayUnit {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintDescriptor> constraints;

	/**
	 * The default value of the '{@link #getElementMultiplicity() <em>Element Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int ELEMENT_MULTIPLICITY_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getElementMultiplicity() <em>Element Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int elementMultiplicity = ELEMENT_MULTIPLICITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplayUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.DISPLAY_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintDescriptor> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<ConstraintDescriptor>(ConstraintDescriptor.class, this, ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getElementMultiplicity() {
		return elementMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementMultiplicity(int newElementMultiplicity) {
		int oldElementMultiplicity = elementMultiplicity;
		elementMultiplicity = newElementMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY, oldElementMultiplicity, elementMultiplicity));
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
			case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
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
			case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS:
				return getConstraints();
			case ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY:
				return getElementMultiplicity();
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
			case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstraintDescriptor>)newValue);
				return;
			case ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY:
				setElementMultiplicity((Integer)newValue);
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
			case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS:
				getConstraints().clear();
				return;
			case ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY:
				setElementMultiplicity(ELEMENT_MULTIPLICITY_EDEFAULT);
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
			case ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case ConstraintsPackage.DISPLAY_UNIT__ELEMENT_MULTIPLICITY:
				return elementMultiplicity != ELEMENT_MULTIPLICITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (elementMultiplicity: ");
		result.append(elementMultiplicity);
		result.append(')');
		return result.toString();
	}

} //DisplayUnitImpl
