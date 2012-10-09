/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Set Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl#getOwnedServices <em>Owned Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.ServiceSetDescImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceSetDescImpl extends EObjectImpl implements ServiceSetDesc {
	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractServiceDesc> services;

	/**
	 * The cached value of the '{@link #getOwnedServices() <em>Owned Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedServices()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractServiceDesc> ownedServices;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSetDesc> extends_;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceSetDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorsPackage.Literals.SERVICE_SET_DESC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractServiceDesc> getServices() {
		if (services == null) {
			services = new EObjectResolvingEList<AbstractServiceDesc>(AbstractServiceDesc.class, this, ServicedescriptorsPackage.SERVICE_SET_DESC__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractServiceDesc> getOwnedServices() {
		if (ownedServices == null) {
			ownedServices = new EObjectContainmentWithInverseEList<AbstractServiceDesc>(AbstractServiceDesc.class, this, ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT);
		}
		return ownedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.SERVICE_SET_DESC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSetDesc> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectResolvingEList<ServiceSetDesc>(ServiceSetDesc.class, this, ServicedescriptorsPackage.SERVICE_SET_DESC__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.SERVICE_SET_DESC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractServiceDesc getServiceDesc(String serviceId) {
		if(serviceId == null) {
			return null;
		}
		
		for( AbstractServiceDesc desc : getServices()) {
			if( serviceId.equals(desc.getName() ) ) {
				return desc;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean servicesContains(String serviceId) {
		return getServiceDesc(serviceId) != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedServices()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES:
				return ((InternalEList<?>)getOwnedServices()).basicRemove(otherEnd, msgs);
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
			case ServicedescriptorsPackage.SERVICE_SET_DESC__SERVICES:
				return getServices();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES:
				return getOwnedServices();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__NAME:
				return getName();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__EXTENDS:
				return getExtends();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__DESCRIPTION:
				return getDescription();
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
			case ServicedescriptorsPackage.SERVICE_SET_DESC__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends AbstractServiceDesc>)newValue);
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES:
				getOwnedServices().clear();
				getOwnedServices().addAll((Collection<? extends AbstractServiceDesc>)newValue);
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__NAME:
				setName((String)newValue);
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends ServiceSetDesc>)newValue);
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__DESCRIPTION:
				setDescription((String)newValue);
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
			case ServicedescriptorsPackage.SERVICE_SET_DESC__SERVICES:
				getServices().clear();
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES:
				getOwnedServices().clear();
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__EXTENDS:
				getExtends().clear();
				return;
			case ServicedescriptorsPackage.SERVICE_SET_DESC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case ServicedescriptorsPackage.SERVICE_SET_DESC__SERVICES:
				return services != null && !services.isEmpty();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES:
				return ownedServices != null && !ownedServices.isEmpty();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicedescriptorsPackage.SERVICE_SET_DESC__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case ServicedescriptorsPackage.SERVICE_SET_DESC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ServiceSetDescImpl
