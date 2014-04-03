/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.queries.core.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.queries.core.configuration.ConstantParameterValue;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ConstantParameterValueImpl#getValueInstance <em>Value Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantParameterValueImpl extends ParameterValueImpl implements ConstantParameterValue {
	/**
	 * The cached value of the '{@link #getValueInstance() <em>Value Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueInstance()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification valueInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantParameterValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.CONSTANT_PARAMETER_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getValueInstance() {
		return valueInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueInstance(ValueSpecification newValueInstance, NotificationChain msgs) {
		ValueSpecification oldValueInstance = valueInstance;
		valueInstance = newValueInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE, oldValueInstance, newValueInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueInstance(ValueSpecification newValueInstance) {
		if (newValueInstance != valueInstance) {
			NotificationChain msgs = null;
			if (valueInstance != null)
				msgs = ((InternalEObject)valueInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE, null, msgs);
			if (newValueInstance != null)
				msgs = ((InternalEObject)newValueInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE, null, msgs);
			msgs = basicSetValueInstance(newValueInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE, newValueInstance, newValueInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE:
				return basicSetValueInstance(null, msgs);
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
			case ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE:
				return getValueInstance();
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
			case ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE:
				setValueInstance((ValueSpecification)newValue);
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
			case ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE:
				setValueInstance((ValueSpecification)null);
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
			case ConfigurationPackage.CONSTANT_PARAMETER_VALUE__VALUE_INSTANCE:
				return valueInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstantParameterValueImpl
