/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage;
import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay;

import org.eclipse.papyrus.infra.extendedtypes.impl.SemanticActionConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runtime Values Edition Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.RuntimeValuesEditionActionConfigurationImpl#getViewsToDisplay <em>Views To Display</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuntimeValuesEditionActionConfigurationImpl extends SemanticActionConfigurationImpl implements RuntimeValuesEditionActionConfiguration {
	/**
	 * The cached value of the '{@link #getViewsToDisplay() <em>Views To Display</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewsToDisplay()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewToDisplay> viewsToDisplay;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuntimeValuesEditionActionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimeValuesEditionActionConfigurationPackage.Literals.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewToDisplay> getViewsToDisplay() {
		if (viewsToDisplay == null) {
			viewsToDisplay = new EObjectContainmentEList<ViewToDisplay>(ViewToDisplay.class, this, RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY);
		}
		return viewsToDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY:
				return ((InternalEList<?>)getViewsToDisplay()).basicRemove(otherEnd, msgs);
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
			case RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY:
				return getViewsToDisplay();
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
			case RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY:
				getViewsToDisplay().clear();
				getViewsToDisplay().addAll((Collection<? extends ViewToDisplay>)newValue);
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
			case RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY:
				getViewsToDisplay().clear();
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
			case RuntimeValuesEditionActionConfigurationPackage.RUNTIME_VALUES_EDITION_ACTION_CONFIGURATION__VIEWS_TO_DISPLAY:
				return viewsToDisplay != null && !viewsToDisplay.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RuntimeValuesEditionActionConfigurationImpl
