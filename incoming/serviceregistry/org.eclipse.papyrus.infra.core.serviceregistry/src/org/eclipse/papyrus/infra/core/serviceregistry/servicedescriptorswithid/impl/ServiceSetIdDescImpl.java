/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Set Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceSetIdDescImpl#getServiceDescriptors <em>Service Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceSetIdDescImpl extends EObjectImpl implements ServiceSetIdDesc {
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
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<String> extends_;

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
	 * The cached value of the '{@link #getServiceDescriptors() <em>Service Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractServiceIdDesc> serviceDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceSetIdDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorswithidPackage.Literals.SERVICE_SET_ID_DESC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExtends() {
		if (extends_ == null) {
			extends_ = new EDataTypeUniqueEList<String>(String.class, this, ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__EXTENDS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractServiceIdDesc> getServiceDescriptors() {
		if (serviceDescriptors == null) {
			serviceDescriptors = new EObjectContainmentWithInverseEList<AbstractServiceIdDesc>(AbstractServiceIdDesc.class, this, ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE);
		}
		return serviceDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractServiceIdDesc getService(Object serviceId) {
		// Ensure that you remove @generated or mark it @generated NOT
		if(serviceId == null) {
			return null;
		}
		
		for( AbstractServiceIdDesc desc : getServiceDescriptors()) {
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
	public boolean containsService(Object serviceId) {
		return getService(serviceId) != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractServiceIdDesc getService(AbstractServiceIdDesc serviceDesc) {
		return getService( serviceDesc.getName() );
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsService(AbstractServiceIdDesc serviceDesc) {
		return getService( serviceDesc.getName() ) != null;
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
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getServiceDescriptors()).basicAdd(otherEnd, msgs);
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
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS:
				return ((InternalEList<?>)getServiceDescriptors()).basicRemove(otherEnd, msgs);
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
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__NAME:
				return getName();
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__EXTENDS:
				return getExtends();
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__DESCRIPTION:
				return getDescription();
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS:
				return getServiceDescriptors();
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
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__NAME:
				setName((String)newValue);
				return;
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends String>)newValue);
				return;
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS:
				getServiceDescriptors().clear();
				getServiceDescriptors().addAll((Collection<? extends AbstractServiceIdDesc>)newValue);
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
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__EXTENDS:
				getExtends().clear();
				return;
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS:
				getServiceDescriptors().clear();
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
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS:
				return serviceDescriptors != null && !serviceDescriptors.isEmpty();
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
		result.append(", extends: ");
		result.append(extends_);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ServiceSetIdDescImpl
