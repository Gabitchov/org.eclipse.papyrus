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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registry Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getServiceSets <em>Service Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.RegistryDescImpl#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistryDescImpl extends EObjectImpl implements RegistryDesc {
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
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistryDesc> parents;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistryDesc> children;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistryDesc> extends_;

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
	 * The cached value of the '{@link #getServiceSets() <em>Service Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSetDesc> serviceSets;

	/**
	 * The default value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistryDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorsPackage.Literals.REGISTRY_DESC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.REGISTRY_DESC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistryDesc> getParents() {
		if (parents == null) {
			parents = new EObjectWithInverseResolvingEList.ManyInverse<RegistryDesc>(RegistryDesc.class, this, ServicedescriptorsPackage.REGISTRY_DESC__PARENTS, ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistryDesc> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList.ManyInverse<RegistryDesc>(RegistryDesc.class, this, ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN, ServicedescriptorsPackage.REGISTRY_DESC__PARENTS);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistryDesc> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectResolvingEList<RegistryDesc>(RegistryDesc.class, this, ServicedescriptorsPackage.REGISTRY_DESC__EXTENDS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.REGISTRY_DESC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSetDesc> getServiceSets() {
		if (serviceSets == null) {
			serviceSets = new EObjectResolvingEList<ServiceSetDesc>(ServiceSetDesc.class, this, ServicedescriptorsPackage.REGISTRY_DESC__SERVICE_SETS);
		}
		return serviceSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.REGISTRY_DESC__IS_UNIQUE, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractServiceDesc> getServices() {
		if (services == null) {
			services = new EObjectResolvingEList<AbstractServiceDesc>(AbstractServiceDesc.class, this, ServicedescriptorsPackage.REGISTRY_DESC__SERVICES);
		}
		return services;
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
	public ServiceSetDesc getServiceSetDesc(String serviceSetsId) {
		if(serviceSetsId == null) {
			return null;
		}
		
		for( ServiceSetDesc desc : getServiceSets()) {
			if( serviceSetsId.equals(desc.getName() ) ) {
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
	 * @generated NOT
	 */
	public boolean serviceSetsContains(String serviceSetsId) {
		return getServiceSetDesc(serviceSetsId) != null;
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
			case ServicedescriptorsPackage.REGISTRY_DESC__PARENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParents()).basicAdd(otherEnd, msgs);
			case ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
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
			case ServicedescriptorsPackage.REGISTRY_DESC__PARENTS:
				return ((InternalEList<?>)getParents()).basicRemove(otherEnd, msgs);
			case ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case ServicedescriptorsPackage.REGISTRY_DESC__NAME:
				return getName();
			case ServicedescriptorsPackage.REGISTRY_DESC__PARENTS:
				return getParents();
			case ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN:
				return getChildren();
			case ServicedescriptorsPackage.REGISTRY_DESC__EXTENDS:
				return getExtends();
			case ServicedescriptorsPackage.REGISTRY_DESC__DESCRIPTION:
				return getDescription();
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICE_SETS:
				return getServiceSets();
			case ServicedescriptorsPackage.REGISTRY_DESC__IS_UNIQUE:
				return isUnique();
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICES:
				return getServices();
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
			case ServicedescriptorsPackage.REGISTRY_DESC__NAME:
				setName((String)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends RegistryDesc>)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends RegistryDesc>)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends RegistryDesc>)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICE_SETS:
				getServiceSets().clear();
				getServiceSets().addAll((Collection<? extends ServiceSetDesc>)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends AbstractServiceDesc>)newValue);
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
			case ServicedescriptorsPackage.REGISTRY_DESC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__PARENTS:
				getParents().clear();
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN:
				getChildren().clear();
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__EXTENDS:
				getExtends().clear();
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICE_SETS:
				getServiceSets().clear();
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICES:
				getServices().clear();
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
			case ServicedescriptorsPackage.REGISTRY_DESC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicedescriptorsPackage.REGISTRY_DESC__PARENTS:
				return parents != null && !parents.isEmpty();
			case ServicedescriptorsPackage.REGISTRY_DESC__CHILDREN:
				return children != null && !children.isEmpty();
			case ServicedescriptorsPackage.REGISTRY_DESC__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case ServicedescriptorsPackage.REGISTRY_DESC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICE_SETS:
				return serviceSets != null && !serviceSets.isEmpty();
			case ServicedescriptorsPackage.REGISTRY_DESC__IS_UNIQUE:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case ServicedescriptorsPackage.REGISTRY_DESC__SERVICES:
				return services != null && !services.isEmpty();
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
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(')');
		return result.toString();
	}

} //RegistryDescImpl
