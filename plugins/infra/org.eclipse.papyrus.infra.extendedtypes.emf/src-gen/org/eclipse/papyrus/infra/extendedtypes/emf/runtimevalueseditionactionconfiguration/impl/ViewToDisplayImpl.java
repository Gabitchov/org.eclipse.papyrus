/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.RuntimeValuesEditionActionConfigurationPackage;
import org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.ViewToDisplay;

import org.eclipse.papyrus.views.properties.contexts.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View To Display</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.impl.ViewToDisplayImpl#getView <em>View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewToDisplayImpl extends MinimalEObjectImpl.Container implements ViewToDisplay {
	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected View view;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewToDisplayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimeValuesEditionActionConfigurationPackage.Literals.VIEW_TO_DISPLAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View getView() {
		if (view != null && view.eIsProxy()) {
			InternalEObject oldView = (InternalEObject)view;
			view = (View)eResolveProxy(oldView);
			if (view != oldView) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY__VIEW, oldView, view));
			}
		}
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View basicGetView() {
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setView(View newView) {
		View oldView = view;
		view = newView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY__VIEW, oldView, view));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY__VIEW:
				if (resolve) return getView();
				return basicGetView();
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
			case RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY__VIEW:
				setView((View)newValue);
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
			case RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY__VIEW:
				setView((View)null);
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
			case RuntimeValuesEditionActionConfigurationPackage.VIEW_TO_DISPLAY__VIEW:
				return view != null;
		}
		return super.eIsSet(featureID);
	}

} //ViewToDisplayImpl
