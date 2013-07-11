/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AliasIdDescImpl#getAliasedService <em>Aliased Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AliasIdDescImpl extends AbstractServiceIdDescImpl implements AliasIdDesc {
	/**
	 * The default value of the '{@link #getAliasedService() <em>Aliased Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasedService()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIASED_SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAliasedService() <em>Aliased Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasedService()
	 * @generated
	 * @ordered
	 */
	protected String aliasedService = ALIASED_SERVICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AliasIdDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorswithidPackage.Literals.ALIAS_ID_DESC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAliasedService() {
		return aliasedService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasedService(String newAliasedService) {
		String oldAliasedService = aliasedService;
		aliasedService = newAliasedService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.ALIAS_ID_DESC__ALIASED_SERVICE, oldAliasedService, aliasedService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicedescriptorswithidPackage.ALIAS_ID_DESC__ALIASED_SERVICE:
				return getAliasedService();
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
			case ServicedescriptorswithidPackage.ALIAS_ID_DESC__ALIASED_SERVICE:
				setAliasedService((String)newValue);
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
			case ServicedescriptorswithidPackage.ALIAS_ID_DESC__ALIASED_SERVICE:
				setAliasedService(ALIASED_SERVICE_EDEFAULT);
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
			case ServicedescriptorswithidPackage.ALIAS_ID_DESC__ALIASED_SERVICE:
				return ALIASED_SERVICE_EDEFAULT == null ? aliasedService != null : !ALIASED_SERVICE_EDEFAULT.equals(aliasedService);
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
		result.append(" (aliasedService: ");
		result.append(aliasedService);
		result.append(')');
		return result.toString();
	}

} //AliasIdDescImpl
