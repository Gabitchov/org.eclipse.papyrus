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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Service Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getBundleID <em>Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.impl.AbstractServiceDescImpl#getDependsOnIds <em>Depends On Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractServiceDescImpl extends EObjectImpl implements AbstractServiceDesc {
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
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractServiceDesc> dependsOn;

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
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundleID() <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleID()
	 * @generated
	 * @ordered
	 */
	protected static final String BUNDLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundleID() <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleID()
	 * @generated
	 * @ordered
	 */
	protected String bundleID = BUNDLE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependsOnIds() <em>Depends On Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOnIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> dependsOnIds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractServiceDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorsPackage.Literals.ABSTRACT_SERVICE_DESC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractServiceDesc> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectResolvingEList<AbstractServiceDesc>(AbstractServiceDesc.class, this, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON);
		}
		return dependsOn;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleID() {
		return bundleID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleID(String newBundleID) {
		String oldBundleID = bundleID;
		bundleID = newBundleID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__BUNDLE_ID, oldBundleID, bundleID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSetDesc getParent() {
		if (eContainerFeatureID() != ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT) return null;
		return (ServiceSetDesc)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(ServiceSetDesc newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ServiceSetDesc newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES, ServiceSetDesc.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDependsOnIds() {
		if (dependsOnIds == null) {
			dependsOnIds = new EDataTypeUniqueEList<String>(String.class, this, ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS);
		}
		return dependsOnIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((ServiceSetDesc)otherEnd, msgs);
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
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				return eInternalContainer().eInverseRemove(this, ServicedescriptorsPackage.SERVICE_SET_DESC__OWNED_SERVICES, ServiceSetDesc.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__NAME:
				return getName();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON:
				return getDependsOn();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DESCRIPTION:
				return getDescription();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PRIORITY:
				return getPriority();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__BUNDLE_ID:
				return getBundleID();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				return getParent();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS:
				return getDependsOnIds();
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
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__NAME:
				setName((String)newValue);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends AbstractServiceDesc>)newValue);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__BUNDLE_ID:
				setBundleID((String)newValue);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				setParent((ServiceSetDesc)newValue);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS:
				getDependsOnIds().clear();
				getDependsOnIds().addAll((Collection<? extends String>)newValue);
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
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__BUNDLE_ID:
				setBundleID(BUNDLE_ID_EDEFAULT);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				setParent((ServiceSetDesc)null);
				return;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS:
				getDependsOnIds().clear();
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
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__BUNDLE_ID:
				return BUNDLE_ID_EDEFAULT == null ? bundleID != null : !BUNDLE_ID_EDEFAULT.equals(bundleID);
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__PARENT:
				return getParent() != null;
			case ServicedescriptorsPackage.ABSTRACT_SERVICE_DESC__DEPENDS_ON_IDS:
				return dependsOnIds != null && !dependsOnIds.isEmpty();
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
		result.append(", priority: ");
		result.append(priority);
		result.append(", bundleID: ");
		result.append(bundleID);
		result.append(", dependsOnIds: ");
		result.append(dependsOnIds);
		result.append(')');
		return result.toString();
	}

} //AbstractServiceDescImpl
