/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Descriptors</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.DescriptorsImpl#getRegistries <em>Registries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.DescriptorsImpl#getServiceSets <em>Service Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DescriptorsImpl extends EObjectImpl implements Descriptors {
	/**
	 * The cached value of the '{@link #getRegistries() <em>Registries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistries()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistryDesc> registries;

	/**
	 * The cached value of the '{@link #getServiceSets() <em>Service Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSetDesc> serviceSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptorsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorsPackage.Literals.DESCRIPTORS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistryDesc> getRegistries() {
		if (registries == null) {
			registries = new EObjectContainmentEList<RegistryDesc>(RegistryDesc.class, this, ServicedescriptorsPackage.DESCRIPTORS__REGISTRIES);
		}
		return registries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSetDesc> getServiceSets() {
		if (serviceSets == null) {
			serviceSets = new EObjectContainmentEList<ServiceSetDesc>(ServiceSetDesc.class, this, ServicedescriptorsPackage.DESCRIPTORS__SERVICE_SETS);
		}
		return serviceSets;
	}

	/**
	 * Return the requested registry. 
	 * return null if not found.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RegistryDesc getRegistryDesc(String name) {
		
		for( RegistryDesc desc : getRegistries() ) {
			if( name.equals(desc.getName())) {
				return desc;
			}
		}
		
		return null;
	}

	/**
	 * Return the requested serviceSet. 
	 * return null if not found.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ServiceSetDesc getServiceSetDesc(String name) {
		for( ServiceSetDesc desc : getServiceSets() ) {
			if( name.equals(desc.getName())) {
				return desc;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorsPackage.DESCRIPTORS__REGISTRIES:
				return ((InternalEList<?>)getRegistries()).basicRemove(otherEnd, msgs);
			case ServicedescriptorsPackage.DESCRIPTORS__SERVICE_SETS:
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
			case ServicedescriptorsPackage.DESCRIPTORS__REGISTRIES:
				return getRegistries();
			case ServicedescriptorsPackage.DESCRIPTORS__SERVICE_SETS:
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
			case ServicedescriptorsPackage.DESCRIPTORS__REGISTRIES:
				getRegistries().clear();
				getRegistries().addAll((Collection<? extends RegistryDesc>)newValue);
				return;
			case ServicedescriptorsPackage.DESCRIPTORS__SERVICE_SETS:
				getServiceSets().clear();
				getServiceSets().addAll((Collection<? extends ServiceSetDesc>)newValue);
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
			case ServicedescriptorsPackage.DESCRIPTORS__REGISTRIES:
				getRegistries().clear();
				return;
			case ServicedescriptorsPackage.DESCRIPTORS__SERVICE_SETS:
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
			case ServicedescriptorsPackage.DESCRIPTORS__REGISTRIES:
				return registries != null && !registries.isEmpty();
			case ServicedescriptorsPackage.DESCRIPTORS__SERVICE_SETS:
				return serviceSets != null && !serviceSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DescriptorsImpl
