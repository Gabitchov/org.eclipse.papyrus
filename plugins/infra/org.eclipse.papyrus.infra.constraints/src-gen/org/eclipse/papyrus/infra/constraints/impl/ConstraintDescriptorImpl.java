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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl#getDisplay <em>Display</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl#isOverrideable <em>Overrideable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl#getOverriddenConstraints <em>Overridden Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConstraintDescriptorImpl extends EObjectImpl implements ConstraintDescriptor {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isOverrideable() <em>Overrideable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverrideable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERRIDEABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOverrideable() <em>Overrideable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverrideable()
	 * @generated
	 * @ordered
	 */
	protected boolean overrideable = OVERRIDEABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverriddenConstraints() <em>Overridden Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverriddenConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleConstraint> overriddenConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.CONSTRAINT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisplayUnit getDisplay() {
		if (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY) return null;
		return (DisplayUnit)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDisplay(DisplayUnit newDisplay, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDisplay, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplay(DisplayUnit newDisplay) {
		if (newDisplay != eInternalContainer() || (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY && newDisplay != null)) {
			if (EcoreUtil.isAncestor(this, newDisplay))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDisplay != null)
				msgs = ((InternalEObject)newDisplay).eInverseAdd(this, ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS, DisplayUnit.class, msgs);
			msgs = basicSetDisplay(newDisplay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY, newDisplay, newDisplay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverrideable() {
		return overrideable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverrideable(boolean newOverrideable) {
		boolean oldOverrideable = overrideable;
		overrideable = newOverrideable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDEABLE, oldOverrideable, overrideable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleConstraint> getOverriddenConstraints() {
		if (overriddenConstraints == null) {
			overriddenConstraints = new EObjectResolvingEList<SimpleConstraint>(SimpleConstraint.class, this, ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS);
		}
		return overriddenConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDisplay((DisplayUnit)otherEnd, msgs);
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
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return basicSetDisplay(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return eInternalContainer().eInverseRemove(this, ConstraintsPackage.DISPLAY_UNIT__CONSTRAINTS, DisplayUnit.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				return getName();
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return getDisplay();
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDEABLE:
				return isOverrideable();
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				return getOverriddenConstraints();
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
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				setDisplay((DisplayUnit)newValue);
				return;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDEABLE:
				setOverrideable((Boolean)newValue);
				return;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				getOverriddenConstraints().clear();
				getOverriddenConstraints().addAll((Collection<? extends SimpleConstraint>)newValue);
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
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				setDisplay((DisplayUnit)null);
				return;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDEABLE:
				setOverrideable(OVERRIDEABLE_EDEFAULT);
				return;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				getOverriddenConstraints().clear();
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
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__DISPLAY:
				return getDisplay() != null;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDEABLE:
				return overrideable != OVERRIDEABLE_EDEFAULT;
			case ConstraintsPackage.CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS:
				return overriddenConstraints != null && !overriddenConstraints.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", overrideable: ");
		result.append(overrideable);
		result.append(')');
		return result.toString();
	}

} //ConstraintDescriptorImpl
