/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM.impl;

import FCM.FCMPackage;
import FCM.ImplementationProperties;
import FCM.OperatingSystem;
import FCM.TargetArchitecture;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link FCM.impl.ImplementationPropertiesImpl#getSizeRAM <em>Size RAM</em>}</li>
 *   <li>{@link FCM.impl.ImplementationPropertiesImpl#getSupportedOS <em>Supported OS</em>}</li>
 *   <li>{@link FCM.impl.ImplementationPropertiesImpl#getArch <em>Arch</em>}</li>
 *   <li>{@link FCM.impl.ImplementationPropertiesImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link FCM.impl.ImplementationPropertiesImpl#getSizeROM <em>Size ROM</em>}</li>
 *   <li>{@link FCM.impl.ImplementationPropertiesImpl#getSupportedTargetArch <em>Supported Target Arch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationPropertiesImpl extends EObjectImpl implements ImplementationProperties {
	/**
	 * The default value of the '{@link #getSizeRAM() <em>Size RAM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeRAM()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_RAM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSizeRAM() <em>Size RAM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeRAM()
	 * @generated
	 * @ordered
	 */
	protected int sizeRAM = SIZE_RAM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupportedOS() <em>Supported OS</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedOS()
	 * @generated
	 * @ordered
	 */
	protected EList<OperatingSystem> supportedOS;

	/**
	 * The cached value of the '{@link #getArch() <em>Arch</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArch()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetArchitecture> arch;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getSizeROM() <em>Size ROM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeROM()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_ROM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSizeROM() <em>Size ROM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeROM()
	 * @generated
	 * @ordered
	 */
	protected int sizeROM = SIZE_ROM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupportedTargetArch() <em>Supported Target Arch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedTargetArch()
	 * @generated
	 * @ordered
	 */
	protected TargetArchitecture supportedTargetArch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.IMPLEMENTATION_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSizeRAM() {
		return sizeRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeRAM(int newSizeRAM) {
		int oldSizeRAM = sizeRAM;
		sizeRAM = newSizeRAM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_RAM, oldSizeRAM, sizeRAM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperatingSystem> getSupportedOS() {
		if (supportedOS == null) {
			supportedOS = new EObjectResolvingEList<OperatingSystem>(OperatingSystem.class, this, FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_OS);
		}
		return supportedOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetArchitecture> getArch() {
		if (arch == null) {
			arch = new EObjectResolvingEList<TargetArchitecture>(TargetArchitecture.class, this, FCMPackage.IMPLEMENTATION_PROPERTIES__ARCH);
		}
		return arch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.IMPLEMENTATION_PROPERTIES__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.IMPLEMENTATION_PROPERTIES__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSizeROM() {
		return sizeROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeROM(int newSizeROM) {
		int oldSizeROM = sizeROM;
		sizeROM = newSizeROM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_ROM, oldSizeROM, sizeROM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetArchitecture getSupportedTargetArch() {
		if (supportedTargetArch != null && supportedTargetArch.eIsProxy()) {
			InternalEObject oldSupportedTargetArch = (InternalEObject)supportedTargetArch;
			supportedTargetArch = (TargetArchitecture)eResolveProxy(oldSupportedTargetArch);
			if (supportedTargetArch != oldSupportedTargetArch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH, oldSupportedTargetArch, supportedTargetArch));
			}
		}
		return supportedTargetArch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetArchitecture basicGetSupportedTargetArch() {
		return supportedTargetArch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportedTargetArch(TargetArchitecture newSupportedTargetArch) {
		TargetArchitecture oldSupportedTargetArch = supportedTargetArch;
		supportedTargetArch = newSupportedTargetArch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH, oldSupportedTargetArch, supportedTargetArch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_RAM:
				return getSizeRAM();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_OS:
				return getSupportedOS();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__ARCH:
				return getArch();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_ROM:
				return getSizeROM();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH:
				if (resolve) return getSupportedTargetArch();
				return basicGetSupportedTargetArch();
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
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_RAM:
				setSizeRAM((Integer)newValue);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_OS:
				getSupportedOS().clear();
				getSupportedOS().addAll((Collection<? extends OperatingSystem>)newValue);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__ARCH:
				getArch().clear();
				getArch().addAll((Collection<? extends TargetArchitecture>)newValue);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_ROM:
				setSizeROM((Integer)newValue);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH:
				setSupportedTargetArch((TargetArchitecture)newValue);
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
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_RAM:
				setSizeRAM(SIZE_RAM_EDEFAULT);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_OS:
				getSupportedOS().clear();
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__ARCH:
				getArch().clear();
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_ROM:
				setSizeROM(SIZE_ROM_EDEFAULT);
				return;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH:
				setSupportedTargetArch((TargetArchitecture)null);
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
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_RAM:
				return sizeRAM != SIZE_RAM_EDEFAULT;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_OS:
				return supportedOS != null && !supportedOS.isEmpty();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__ARCH:
				return arch != null && !arch.isEmpty();
			case FCMPackage.IMPLEMENTATION_PROPERTIES__BASE_CLASS:
				return base_Class != null;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SIZE_ROM:
				return sizeROM != SIZE_ROM_EDEFAULT;
			case FCMPackage.IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH:
				return supportedTargetArch != null;
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
		result.append(" (sizeRAM: ");
		result.append(sizeRAM);
		result.append(", sizeROM: ");
		result.append(sizeROM);
		result.append(')');
		return result.toString();
	}

} //ImplementationPropertiesImpl
