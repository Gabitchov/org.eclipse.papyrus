/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Stereotype;

import FCM.FCMPackage;
import FCM.Port;
import FCM.PortKind;
import FCM.util.MapUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link FCM.impl.PortImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link FCM.impl.PortImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link FCM.impl.PortImpl#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link FCM.impl.PortImpl#getRequiredInterface <em>Required Interface</em>}</li>
 *   <li>{@link FCM.impl.PortImpl#isConjugated <em>Conjugated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends ConfigurableElementInstanceImpl implements Port {

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Port base_Port;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected PortKind kind;

	/**
	 * The default value of the '{@link #isConjugated() <em>Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConjugated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONJUGATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConjugated() <em>Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConjugated()
	 * @generated
	 * @ordered
	 */
	protected boolean conjugated = CONJUGATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (org.eclipse.uml2.uml.Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.PORT__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(org.eclipse.uml2.uml.Port newBase_Port) {
		org.eclipse.uml2.uml.Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind getKind() {
		if (kind != null && kind.eIsProxy()) {
			InternalEObject oldKind = (InternalEObject)kind;
			kind = (PortKind)eResolveProxy(oldKind);
			if (kind != oldKind) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.PORT__KIND, oldKind, kind));
			}
		}
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind basicGetKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(PortKind newKind) {
		PortKind oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.PORT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getProvidedInterface() {
		Interface providedInterface = basicGetProvidedInterface();
		return providedInterface != null && providedInterface.eIsProxy() ? (Interface)eResolveProxy((InternalEObject)providedInterface) : providedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Interface basicGetProvidedInterface() {
		if(conjugated) {
			return MapUtil.getRequiredInterface(this);
		}
		else {
			return MapUtil.getProvidedInterface(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSetProvidedInterface() {
		return (getProvidedInterface() != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getRequiredInterface() {
		Interface requiredInterface = basicGetRequiredInterface();
		return requiredInterface != null && requiredInterface.eIsProxy() ? (Interface)eResolveProxy((InternalEObject)requiredInterface) : requiredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Interface basicGetRequiredInterface() {
		if(!conjugated) {
			return MapUtil.getRequiredInterface(this);
		}
		else {
			return MapUtil.getProvidedInterface(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSetRequiredInterface() {
		return (getRequiredInterface() != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConjugated() {
		return conjugated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConjugated(boolean newConjugated) {
		boolean oldConjugated = conjugated;
		conjugated = newConjugated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.PORT__CONJUGATED, oldConjugated, conjugated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.PORT__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case FCMPackage.PORT__KIND:
				if (resolve) return getKind();
				return basicGetKind();
			case FCMPackage.PORT__PROVIDED_INTERFACE:
				if (resolve) return getProvidedInterface();
				return basicGetProvidedInterface();
			case FCMPackage.PORT__REQUIRED_INTERFACE:
				if (resolve) return getRequiredInterface();
				return basicGetRequiredInterface();
			case FCMPackage.PORT__CONJUGATED:
				return isConjugated();
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
			case FCMPackage.PORT__BASE_PORT:
				setBase_Port((org.eclipse.uml2.uml.Port)newValue);
				return;
			case FCMPackage.PORT__KIND:
				setKind((PortKind)newValue);
				return;
			case FCMPackage.PORT__CONJUGATED:
				setConjugated((Boolean)newValue);
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
			case FCMPackage.PORT__BASE_PORT:
				setBase_Port((org.eclipse.uml2.uml.Port)null);
				return;
			case FCMPackage.PORT__KIND:
				setKind((PortKind)null);
				return;
			case FCMPackage.PORT__CONJUGATED:
				setConjugated(CONJUGATED_EDEFAULT);
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
			case FCMPackage.PORT__BASE_PORT:
				return base_Port != null;
			case FCMPackage.PORT__KIND:
				return kind != null;
			case FCMPackage.PORT__PROVIDED_INTERFACE:
				return isSetProvidedInterface();
			case FCMPackage.PORT__REQUIRED_INTERFACE:
				return isSetRequiredInterface();
			case FCMPackage.PORT__CONJUGATED:
				return conjugated != CONJUGATED_EDEFAULT;
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
		result.append(" (conjugated: ");
		result.append(conjugated);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * * @generated NOT
	 */
	static EList<Interface> emptyList = new BasicEList<Interface>();

	/**
	 * @return icon (serialized in port kind)
	 * @generated NOT
	 */
	public Image getIcon()
	{
		if(getKind() != null) {
			Class clazz = getKind().getBase_Class();

			if(clazz instanceof Stereotype) {
				EList<Image> icons = ((Stereotype)clazz).getIcons();
				if(isConjugated()) {
					if(icons.size() > 1) {
						// standard position for conjugated icon
						return icons.get(1);
					}
				}
				else {
					if(icons.size() > 0) {
						return icons.get(0);
					}
				}
			}
		}
		return null;
	}
}
