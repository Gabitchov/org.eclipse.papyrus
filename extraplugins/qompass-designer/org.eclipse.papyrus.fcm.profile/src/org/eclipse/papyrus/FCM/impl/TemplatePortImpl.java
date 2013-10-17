/**
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.papyrus.FCM.FCMPackage;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.FCM.TemplatePort;
import org.eclipse.papyrus.FCM.util.MapUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.TemplatePortImpl#getBoundType <em>Bound Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplatePortImpl extends PortImpl implements TemplatePort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.TEMPLATE_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind getBoundType() {
		PortKind boundType = basicGetBoundType();
		return boundType != null && boundType.eIsProxy() ? (PortKind)eResolveProxy((InternalEObject)boundType) : boundType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind basicGetBoundType() {
		// TODO: implement this method to return the 'Bound Type' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setBoundType(PortKind newBoundType) {
		// TODO: implement this method to set the 'Bound Type' reference
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void unsetBoundType() {
		// TODO: implement this method to unset the 'Bound Type' reference
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetBoundType() {
		// TODO: implement this method to return whether the 'Bound Type' reference is set
		// Ensure that you remove @generated or mark it @generated NOT
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.TEMPLATE_PORT__BOUND_TYPE:
				if (resolve) return getBoundType();
				return basicGetBoundType();
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
			case FCMPackage.TEMPLATE_PORT__BOUND_TYPE:
				setBoundType((PortKind)newValue);
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
			case FCMPackage.TEMPLATE_PORT__BOUND_TYPE:
				unsetBoundType();
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
			case FCMPackage.TEMPLATE_PORT__BOUND_TYPE:
				return isSetBoundType();
		}
		return super.eIsSet(featureID);
	}

} //TemplatePortImpl
