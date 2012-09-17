/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints.environment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.infra.constraints.environment.ConstraintType;
import org.eclipse.papyrus.infra.constraints.environment.EnvironmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintTypeImpl#getConstraintClass <em>Constraint Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintTypeImpl extends EObjectImpl implements ConstraintType {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraintClass() <em>Constraint Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintClass()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraintClass() <em>Constraint Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintClass()
	 * @generated
	 * @ordered
	 */
	protected String constraintClass = CONSTRAINT_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.CONSTRAINT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.CONSTRAINT_TYPE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraintClass() {
		return constraintClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintClass(String newConstraintClass) {
		String oldConstraintClass = constraintClass;
		constraintClass = newConstraintClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.CONSTRAINT_TYPE__CONSTRAINT_CLASS, oldConstraintClass, constraintClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnvironmentPackage.CONSTRAINT_TYPE__LABEL:
				return getLabel();
			case EnvironmentPackage.CONSTRAINT_TYPE__CONSTRAINT_CLASS:
				return getConstraintClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EnvironmentPackage.CONSTRAINT_TYPE__LABEL:
				setLabel((String)newValue);
				return;
			case EnvironmentPackage.CONSTRAINT_TYPE__CONSTRAINT_CLASS:
				setConstraintClass((String)newValue);
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
			case EnvironmentPackage.CONSTRAINT_TYPE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case EnvironmentPackage.CONSTRAINT_TYPE__CONSTRAINT_CLASS:
				setConstraintClass(CONSTRAINT_CLASS_EDEFAULT);
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
			case EnvironmentPackage.CONSTRAINT_TYPE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case EnvironmentPackage.CONSTRAINT_TYPE__CONSTRAINT_CLASS:
				return CONSTRAINT_CLASS_EDEFAULT == null ? constraintClass != null : !CONSTRAINT_CLASS_EDEFAULT.equals(constraintClass);
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
		result.append(" (label: ");
		result.append(label);
		result.append(", constraintClass: ");
		result.append(constraintClass);
		result.append(')');
		return result.toString();
	}

} //ConstraintTypeImpl
