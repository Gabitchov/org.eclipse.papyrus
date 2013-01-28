/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM.impl;

import FCM.ConfigOption;
import FCM.FCMPackage;
import FCM.OperatingSystem;
import FCM.Target;
import FCM.TargetArchitecture;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link FCM.impl.TargetImpl#getTargetArch <em>Target Arch</em>}</li>
 *   <li>{@link FCM.impl.TargetImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link FCM.impl.TargetImpl#getBase_Node <em>Base Node</em>}</li>
 *   <li>{@link FCM.impl.TargetImpl#getUsedOS <em>Used OS</em>}</li>
 *   <li>{@link FCM.impl.TargetImpl#getAvailRAM <em>Avail RAM</em>}</li>
 *   <li>{@link FCM.impl.TargetImpl#getAvailROM <em>Avail ROM</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetImpl extends EObjectImpl implements Target {
	/**
	 * The cached value of the '{@link #getTargetArch() <em>Target Arch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetArch()
	 * @generated
	 * @ordered
	 */
	protected TargetArchitecture targetArch;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigOption> options;

	/**
	 * The cached value of the '{@link #getBase_Node() <em>Base Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Node()
	 * @generated
	 * @ordered
	 */
	protected Node base_Node;

	/**
	 * The cached value of the '{@link #getUsedOS() <em>Used OS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedOS()
	 * @generated
	 * @ordered
	 */
	protected OperatingSystem usedOS;

	/**
	 * The default value of the '{@link #getAvailRAM() <em>Avail RAM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailRAM()
	 * @generated
	 * @ordered
	 */
	protected static final int AVAIL_RAM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAvailRAM() <em>Avail RAM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailRAM()
	 * @generated
	 * @ordered
	 */
	protected int availRAM = AVAIL_RAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getAvailROM() <em>Avail ROM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailROM()
	 * @generated
	 * @ordered
	 */
	protected static final int AVAIL_ROM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAvailROM() <em>Avail ROM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailROM()
	 * @generated
	 * @ordered
	 */
	protected int availROM = AVAIL_ROM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetArchitecture getTargetArch() {
		if (targetArch != null && targetArch.eIsProxy()) {
			InternalEObject oldTargetArch = (InternalEObject)targetArch;
			targetArch = (TargetArchitecture)eResolveProxy(oldTargetArch);
			if (targetArch != oldTargetArch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.TARGET__TARGET_ARCH, oldTargetArch, targetArch));
			}
		}
		return targetArch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetArchitecture basicGetTargetArch() {
		return targetArch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetArch(TargetArchitecture newTargetArch) {
		TargetArchitecture oldTargetArch = targetArch;
		targetArch = newTargetArch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TARGET__TARGET_ARCH, oldTargetArch, targetArch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigOption> getOptions() {
		if (options == null) {
			options = new EObjectResolvingEList<ConfigOption>(ConfigOption.class, this, FCMPackage.TARGET__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getBase_Node() {
		if (base_Node != null && base_Node.eIsProxy()) {
			InternalEObject oldBase_Node = (InternalEObject)base_Node;
			base_Node = (Node)eResolveProxy(oldBase_Node);
			if (base_Node != oldBase_Node) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.TARGET__BASE_NODE, oldBase_Node, base_Node));
			}
		}
		return base_Node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetBase_Node() {
		return base_Node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Node(Node newBase_Node) {
		Node oldBase_Node = base_Node;
		base_Node = newBase_Node;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TARGET__BASE_NODE, oldBase_Node, base_Node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystem getUsedOS() {
		if (usedOS != null && usedOS.eIsProxy()) {
			InternalEObject oldUsedOS = (InternalEObject)usedOS;
			usedOS = (OperatingSystem)eResolveProxy(oldUsedOS);
			if (usedOS != oldUsedOS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.TARGET__USED_OS, oldUsedOS, usedOS));
			}
		}
		return usedOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystem basicGetUsedOS() {
		return usedOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedOS(OperatingSystem newUsedOS) {
		OperatingSystem oldUsedOS = usedOS;
		usedOS = newUsedOS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TARGET__USED_OS, oldUsedOS, usedOS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAvailRAM() {
		return availRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailRAM(int newAvailRAM) {
		int oldAvailRAM = availRAM;
		availRAM = newAvailRAM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TARGET__AVAIL_RAM, oldAvailRAM, availRAM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAvailROM() {
		return availROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailROM(int newAvailROM) {
		int oldAvailROM = availROM;
		availROM = newAvailROM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.TARGET__AVAIL_ROM, oldAvailROM, availROM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.TARGET__TARGET_ARCH:
				if (resolve) return getTargetArch();
				return basicGetTargetArch();
			case FCMPackage.TARGET__OPTIONS:
				return getOptions();
			case FCMPackage.TARGET__BASE_NODE:
				if (resolve) return getBase_Node();
				return basicGetBase_Node();
			case FCMPackage.TARGET__USED_OS:
				if (resolve) return getUsedOS();
				return basicGetUsedOS();
			case FCMPackage.TARGET__AVAIL_RAM:
				return getAvailRAM();
			case FCMPackage.TARGET__AVAIL_ROM:
				return getAvailROM();
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
			case FCMPackage.TARGET__TARGET_ARCH:
				setTargetArch((TargetArchitecture)newValue);
				return;
			case FCMPackage.TARGET__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends ConfigOption>)newValue);
				return;
			case FCMPackage.TARGET__BASE_NODE:
				setBase_Node((Node)newValue);
				return;
			case FCMPackage.TARGET__USED_OS:
				setUsedOS((OperatingSystem)newValue);
				return;
			case FCMPackage.TARGET__AVAIL_RAM:
				setAvailRAM((Integer)newValue);
				return;
			case FCMPackage.TARGET__AVAIL_ROM:
				setAvailROM((Integer)newValue);
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
			case FCMPackage.TARGET__TARGET_ARCH:
				setTargetArch((TargetArchitecture)null);
				return;
			case FCMPackage.TARGET__OPTIONS:
				getOptions().clear();
				return;
			case FCMPackage.TARGET__BASE_NODE:
				setBase_Node((Node)null);
				return;
			case FCMPackage.TARGET__USED_OS:
				setUsedOS((OperatingSystem)null);
				return;
			case FCMPackage.TARGET__AVAIL_RAM:
				setAvailRAM(AVAIL_RAM_EDEFAULT);
				return;
			case FCMPackage.TARGET__AVAIL_ROM:
				setAvailROM(AVAIL_ROM_EDEFAULT);
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
			case FCMPackage.TARGET__TARGET_ARCH:
				return targetArch != null;
			case FCMPackage.TARGET__OPTIONS:
				return options != null && !options.isEmpty();
			case FCMPackage.TARGET__BASE_NODE:
				return base_Node != null;
			case FCMPackage.TARGET__USED_OS:
				return usedOS != null;
			case FCMPackage.TARGET__AVAIL_RAM:
				return availRAM != AVAIL_RAM_EDEFAULT;
			case FCMPackage.TARGET__AVAIL_ROM:
				return availROM != AVAIL_ROM_EDEFAULT;
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
		result.append(" (availRAM: ");
		result.append(availRAM);
		result.append(", availROM: ");
		result.append(availROM);
		result.append(')');
		return result.toString();
	}

} //TargetImpl
