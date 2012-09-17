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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.constraints.ConfigProperty;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.SimpleConstraintImpl#getConstraintType <em>Constraint Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.impl.SimpleConstraintImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleConstraintImpl extends ConstraintDescriptorImpl implements SimpleConstraint {
	/**
	 * The cached value of the '{@link #getConstraintType() <em>Constraint Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintType()
	 * @generated
	 * @ordered
	 */
	protected ConstraintType constraintType;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.SIMPLE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintType getConstraintType() {
		if (constraintType != null && constraintType.eIsProxy()) {
			InternalEObject oldConstraintType = (InternalEObject)constraintType;
			constraintType = (ConstraintType)eResolveProxy(oldConstraintType);
			if (constraintType != oldConstraintType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintsPackage.SIMPLE_CONSTRAINT__CONSTRAINT_TYPE, oldConstraintType, constraintType));
			}
		}
		return constraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintType basicGetConstraintType() {
		return constraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintType(ConstraintType newConstraintType) {
		ConstraintType oldConstraintType = constraintType;
		constraintType = newConstraintType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.SIMPLE_CONSTRAINT__CONSTRAINT_TYPE, oldConstraintType, constraintType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ConfigProperty>(ConfigProperty.class, this, ConstraintsPackage.SIMPLE_CONSTRAINT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConstraintsPackage.SIMPLE_CONSTRAINT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case ConstraintsPackage.SIMPLE_CONSTRAINT__CONSTRAINT_TYPE:
				if (resolve) return getConstraintType();
				return basicGetConstraintType();
			case ConstraintsPackage.SIMPLE_CONSTRAINT__PROPERTIES:
				return getProperties();
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
			case ConstraintsPackage.SIMPLE_CONSTRAINT__CONSTRAINT_TYPE:
				setConstraintType((ConstraintType)newValue);
				return;
			case ConstraintsPackage.SIMPLE_CONSTRAINT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ConfigProperty>)newValue);
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
			case ConstraintsPackage.SIMPLE_CONSTRAINT__CONSTRAINT_TYPE:
				setConstraintType((ConstraintType)null);
				return;
			case ConstraintsPackage.SIMPLE_CONSTRAINT__PROPERTIES:
				getProperties().clear();
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
			case ConstraintsPackage.SIMPLE_CONSTRAINT__CONSTRAINT_TYPE:
				return constraintType != null;
			case ConstraintsPackage.SIMPLE_CONSTRAINT__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimpleConstraintImpl
