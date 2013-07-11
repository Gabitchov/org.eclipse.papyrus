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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Id Desc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl#getStartKind <em>Start Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.impl.ServiceIdDescImpl#getInjections <em>Injections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceIdDescImpl extends AbstractServiceIdDescImpl implements ServiceIdDesc {
	/**
	 * The default value of the '{@link #getStartKind() <em>Start Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartKind()
	 * @generated
	 * @ordered
	 */
	protected static final StartupKind START_KIND_EDEFAULT = StartupKind.LAZY;

	/**
	 * The cached value of the '{@link #getStartKind() <em>Start Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartKind()
	 * @generated
	 * @ordered
	 */
	protected StartupKind startKind = START_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInjections() <em>Injections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInjections()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureInjection> injections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceIdDescImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicedescriptorswithidPackage.Literals.SERVICE_ID_DESC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartupKind getStartKind() {
		return startKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartKind(StartupKind newStartKind) {
		StartupKind oldStartKind = startKind;
		startKind = newStartKind == null ? START_KIND_EDEFAULT : newStartKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.SERVICE_ID_DESC__START_KIND, oldStartKind, startKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicedescriptorswithidPackage.SERVICE_ID_DESC__CLASSNAME, oldClassname, classname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureInjection> getInjections() {
		if (injections == null) {
			injections = new EObjectContainmentEList<FeatureInjection>(FeatureInjection.class, this, ServicedescriptorswithidPackage.SERVICE_ID_DESC__INJECTIONS);
		}
		return injections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__INJECTIONS:
				return ((InternalEList<?>)getInjections()).basicRemove(otherEnd, msgs);
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
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__START_KIND:
				return getStartKind();
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__CLASSNAME:
				return getClassname();
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__INJECTIONS:
				return getInjections();
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
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__START_KIND:
				setStartKind((StartupKind)newValue);
				return;
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__CLASSNAME:
				setClassname((String)newValue);
				return;
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__INJECTIONS:
				getInjections().clear();
				getInjections().addAll((Collection<? extends FeatureInjection>)newValue);
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
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__START_KIND:
				setStartKind(START_KIND_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__INJECTIONS:
				getInjections().clear();
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
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__START_KIND:
				return startKind != START_KIND_EDEFAULT;
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case ServicedescriptorswithidPackage.SERVICE_ID_DESC__INJECTIONS:
				return injections != null && !injections.isEmpty();
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
		result.append(" (startKind: ");
		result.append(startKind);
		result.append(", classname: ");
		result.append(classname);
		result.append(')');
		return result.toString();
	}

} //ServiceIdDescImpl
