/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AliasDescImpl#getAliasedService <em>Aliased Service</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AliasDescImpl#getAliasedServiceId <em>Aliased Service Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AliasDescImpl extends AbstractServiceDescImpl implements AliasDesc {
	/**
	 * The cached value of the '{@link #getAliasedService() <em>Aliased Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasedService()
	 * @generated
	 * @ordered
	 */
	protected ServiceDesc aliasedService;

	/**
	 * The default value of the '{@link #getAliasedServiceId() <em>Aliased Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasedServiceId()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIASED_SERVICE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAliasedServiceId() <em>Aliased Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasedServiceId()
	 * @generated
	 * @ordered
	 */
	protected String aliasedServiceId = ALIASED_SERVICE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AliasDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorsPackage.Literals.ALIAS_DESC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDesc getAliasedService() {
		if (aliasedService != null && aliasedService.eIsProxy()) {
			InternalEObject oldAliasedService = (InternalEObject)aliasedService;
			aliasedService = (ServiceDesc)eResolveProxy(oldAliasedService);
			if (aliasedService != oldAliasedService) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE, oldAliasedService, aliasedService));
			}
		}
		return aliasedService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDesc basicGetAliasedService() {
		return aliasedService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasedService(ServiceDesc newAliasedService) {
		ServiceDesc oldAliasedService = aliasedService;
		aliasedService = newAliasedService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE, oldAliasedService, aliasedService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAliasedServiceId() {
		return aliasedServiceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasedServiceId(String newAliasedServiceId) {
		String oldAliasedServiceId = aliasedServiceId;
		aliasedServiceId = newAliasedServiceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE_ID, oldAliasedServiceId, aliasedServiceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE:
				if (resolve) return getAliasedService();
				return basicGetAliasedService();
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE_ID:
				return getAliasedServiceId();
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
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE:
				setAliasedService((ServiceDesc)newValue);
				return;
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE_ID:
				setAliasedServiceId((String)newValue);
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
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE:
				setAliasedService((ServiceDesc)null);
				return;
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE_ID:
				setAliasedServiceId(ALIASED_SERVICE_ID_EDEFAULT);
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
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE:
				return aliasedService != null;
			case ServicedescriptorsPackage.ALIAS_DESC__ALIASED_SERVICE_ID:
				return ALIASED_SERVICE_ID_EDEFAULT == null ? aliasedServiceId != null : !ALIASED_SERVICE_ID_EDEFAULT.equals(aliasedServiceId);
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
		result.append(" (aliasedServiceId: ");
		result.append(aliasedServiceId);
		result.append(')');
		return result.toString();
	}

} //AliasDescImpl
