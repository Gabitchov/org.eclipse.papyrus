/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.IdDescriptors;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Id Descriptors</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.IdDescriptorsImpl#getRegistries <em>Registries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.IdDescriptorsImpl#getServiceSets <em>Service Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdDescriptorsImpl extends EObjectImpl implements IdDescriptors {
	/**
	 * The cached value of the '{@link #getRegistries() <em>Registries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistries()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistryIdDesc> registries;

	/**
	 * The cached value of the '{@link #getServiceSets() <em>Service Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSetIdDesc> serviceSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdDescriptorsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorswithidPackage.Literals.ID_DESCRIPTORS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistryIdDesc> getRegistries() {
		if (registries == null) {
			registries = new EObjectContainmentEList<RegistryIdDesc>(RegistryIdDesc.class, this, ServicedescriptorswithidPackage.ID_DESCRIPTORS__REGISTRIES);
		}
		return registries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSetIdDesc> getServiceSets() {
		if (serviceSets == null) {
			serviceSets = new EObjectContainmentEList<ServiceSetIdDesc>(ServiceSetIdDesc.class, this, ServicedescriptorswithidPackage.ID_DESCRIPTORS__SERVICE_SETS);
		}
		return serviceSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__REGISTRIES:
				return ((InternalEList<?>)getRegistries()).basicRemove(otherEnd, msgs);
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__SERVICE_SETS:
				return ((InternalEList<?>)getServiceSets()).basicRemove(otherEnd, msgs);
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
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__REGISTRIES:
				return getRegistries();
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__SERVICE_SETS:
				return getServiceSets();
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
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__REGISTRIES:
				getRegistries().clear();
				getRegistries().addAll((Collection<? extends RegistryIdDesc>)newValue);
				return;
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__SERVICE_SETS:
				getServiceSets().clear();
				getServiceSets().addAll((Collection<? extends ServiceSetIdDesc>)newValue);
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
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__REGISTRIES:
				getRegistries().clear();
				return;
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__SERVICE_SETS:
				getServiceSets().clear();
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
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__REGISTRIES:
				return registries != null && !registries.isEmpty();
			case ServicedescriptorswithidPackage.ID_DESCRIPTORS__SERVICE_SETS:
				return serviceSets != null && !serviceSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IdDescriptorsImpl
