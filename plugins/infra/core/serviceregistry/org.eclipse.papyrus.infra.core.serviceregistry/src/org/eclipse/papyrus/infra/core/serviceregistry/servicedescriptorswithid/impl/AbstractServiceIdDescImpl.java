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
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Service Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.AbstractServiceIdDescImpl#getBundleID <em>Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractServiceIdDescImpl extends EObjectImpl implements AbstractServiceIdDesc {
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
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<String> dependsOn;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractServiceIdDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorswithidPackage.Literals.ABSTRACT_SERVICE_ID_DESC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSetIdDesc getNamespace() {
		if (eContainerFeatureID() != ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE) return null;
		return (ServiceSetIdDesc)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(ServiceSetIdDesc newNamespace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNamespace, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(ServiceSetIdDesc newNamespace) {
		if (newNamespace != eInternalContainer() || (eContainerFeatureID() != ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE && newNamespace != null)) {
			if (EcoreUtil.isAncestor(this, newNamespace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNamespace != null)
				msgs = ((InternalEObject)newNamespace).eInverseAdd(this, ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS, ServiceSetIdDesc.class, msgs);
			msgs = basicSetNamespace(newNamespace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE, newNamespace, newNamespace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EDataTypeUniqueEList<String>(String.class, this, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON);
		}
		return dependsOn;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__PRIORITY, oldPriority, priority));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID, oldBundleID, bundleID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNamespace((ServiceSetIdDesc)otherEnd, msgs);
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
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				return basicSetNamespace(null, msgs);
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
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				return eInternalContainer().eInverseRemove(this, ServicedescriptorswithidPackage.SERVICE_SET_ID_DESC__SERVICE_DESCRIPTORS, ServiceSetIdDesc.class, msgs);
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
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAME:
				return getName();
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				return getNamespace();
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DESCRIPTION:
				return getDescription();
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON:
				return getDependsOn();
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__PRIORITY:
				return getPriority();
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID:
				return getBundleID();
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
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAME:
				setName((String)newValue);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				setNamespace((ServiceSetIdDesc)newValue);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends String>)newValue);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID:
				setBundleID((String)newValue);
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
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				setNamespace((ServiceSetIdDesc)null);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID:
				setBundleID(BUNDLE_ID_EDEFAULT);
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
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__NAMESPACE:
				return getNamespace() != null;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case ServicedescriptorswithidPackage.ABSTRACT_SERVICE_ID_DESC__BUNDLE_ID:
				return BUNDLE_ID_EDEFAULT == null ? bundleID != null : !BUNDLE_ID_EDEFAULT.equals(bundleID);
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
		result.append(", dependsOn: ");
		result.append(dependsOn);
		result.append(", priority: ");
		result.append(priority);
		result.append(", bundleID: ");
		result.append(bundleID);
		result.append(')');
		return result.toString();
	}

} //AbstractServiceIdDescImpl
