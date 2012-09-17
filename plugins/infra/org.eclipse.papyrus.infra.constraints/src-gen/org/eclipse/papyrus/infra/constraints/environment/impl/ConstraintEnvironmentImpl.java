/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints.environment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintType;
import org.eclipse.papyrus.infra.constraints.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintEnvironmentImpl#getConstraintTypes <em>Constraint Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintEnvironmentImpl extends EObjectImpl implements ConstraintEnvironment {
	/**
	 * The cached value of the '{@link #getConstraintTypes() <em>Constraint Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintType> constraintTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintEnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.CONSTRAINT_ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintType> getConstraintTypes() {
		if (constraintTypes == null) {
			constraintTypes = new EObjectContainmentEList<ConstraintType>(ConstraintType.class, this, EnvironmentPackage.CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES);
		}
		return constraintTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EnvironmentPackage.CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES:
				return ((InternalEList<?>)getConstraintTypes()).basicRemove(otherEnd, msgs);
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
			case EnvironmentPackage.CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES:
				return getConstraintTypes();
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
			case EnvironmentPackage.CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES:
				getConstraintTypes().clear();
				getConstraintTypes().addAll((Collection<? extends ConstraintType>)newValue);
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
			case EnvironmentPackage.CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES:
				getConstraintTypes().clear();
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
			case EnvironmentPackage.CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES:
				return constraintTypes != null && !constraintTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConstraintEnvironmentImpl
