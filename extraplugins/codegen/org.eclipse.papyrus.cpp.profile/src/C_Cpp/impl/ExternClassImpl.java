/**
 */
package C_Cpp.impl;

import C_Cpp.C_CppPackage;
import C_Cpp.ExternClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extern Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link C_Cpp.impl.ExternClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link C_Cpp.impl.ExternClassImpl#getBase_class <em>Base class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternClassImpl extends EObjectImpl implements ExternClass {
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
	 * The cached value of the '{@link #getBase_class() <em>Base class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.EXTERN_CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.EXTERN_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_class() {
		if (base_class != null && base_class.eIsProxy()) {
			InternalEObject oldBase_class = (InternalEObject)base_class;
			base_class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_class);
			if (base_class != oldBase_class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.EXTERN_CLASS__BASE_CLASS, oldBase_class, base_class));
			}
		}
		return base_class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_class() {
		return base_class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_class(org.eclipse.uml2.uml.Class newBase_class) {
		org.eclipse.uml2.uml.Class oldBase_class = base_class;
		base_class = newBase_class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.EXTERN_CLASS__BASE_CLASS, oldBase_class, base_class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.EXTERN_CLASS__NAME:
				return getName();
			case C_CppPackage.EXTERN_CLASS__BASE_CLASS:
				if (resolve) return getBase_class();
				return basicGetBase_class();
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
			case C_CppPackage.EXTERN_CLASS__NAME:
				setName((String)newValue);
				return;
			case C_CppPackage.EXTERN_CLASS__BASE_CLASS:
				setBase_class((org.eclipse.uml2.uml.Class)newValue);
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
			case C_CppPackage.EXTERN_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case C_CppPackage.EXTERN_CLASS__BASE_CLASS:
				setBase_class((org.eclipse.uml2.uml.Class)null);
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
			case C_CppPackage.EXTERN_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case C_CppPackage.EXTERN_CLASS__BASE_CLASS:
				return base_class != null;
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
		result.append(')');
		return result.toString();
	}

} //ExternClassImpl
