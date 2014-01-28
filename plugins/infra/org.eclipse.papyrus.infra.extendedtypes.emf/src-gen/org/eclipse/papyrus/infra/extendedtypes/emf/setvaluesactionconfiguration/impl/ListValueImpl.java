/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.impl.ListValueImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListValueImpl extends FeatureValueImpl implements ListValue {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureValue> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SetValuesActionConfigurationPackage.Literals.LIST_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureValue> getValues() {
		if (values == null) {
			values = new EObjectResolvingEList<FeatureValue>(FeatureValue.class, this, SetValuesActionConfigurationPackage.LIST_VALUE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SetValuesActionConfigurationPackage.LIST_VALUE__VALUES:
				return getValues();
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
			case SetValuesActionConfigurationPackage.LIST_VALUE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends FeatureValue>)newValue);
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
			case SetValuesActionConfigurationPackage.LIST_VALUE__VALUES:
				getValues().clear();
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
			case SetValuesActionConfigurationPackage.LIST_VALUE__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ListValueImpl
