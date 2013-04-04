/**
 */
package C_Cpp.impl;

import C_Cpp.C_CppPackage;
import C_Cpp.Default;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link C_Cpp.impl.DefaultImpl#getValue <em>Value</em>}</li>
 *   <li>{@link C_Cpp.impl.DefaultImpl#getBase_parameter <em>Base parameter</em>}</li>
 *   <li>{@link C_Cpp.impl.DefaultImpl#getBase_property <em>Base property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefaultImpl extends EObjectImpl implements Default {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_parameter() <em>Base parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_parameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter base_parameter;

	/**
	 * The cached value of the '{@link #getBase_property() <em>Base property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_property()
	 * @generated
	 * @ordered
	 */
	protected Property base_property;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.DEFAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.DEFAULT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getBase_parameter() {
		if (base_parameter != null && base_parameter.eIsProxy()) {
			InternalEObject oldBase_parameter = (InternalEObject)base_parameter;
			base_parameter = (Parameter)eResolveProxy(oldBase_parameter);
			if (base_parameter != oldBase_parameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.DEFAULT__BASE_PARAMETER, oldBase_parameter, base_parameter));
			}
		}
		return base_parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetBase_parameter() {
		return base_parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_parameter(Parameter newBase_parameter) {
		Parameter oldBase_parameter = base_parameter;
		base_parameter = newBase_parameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.DEFAULT__BASE_PARAMETER, oldBase_parameter, base_parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_property() {
		if (base_property != null && base_property.eIsProxy()) {
			InternalEObject oldBase_property = (InternalEObject)base_property;
			base_property = (Property)eResolveProxy(oldBase_property);
			if (base_property != oldBase_property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.DEFAULT__BASE_PROPERTY, oldBase_property, base_property));
			}
		}
		return base_property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_property() {
		return base_property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_property(Property newBase_property) {
		Property oldBase_property = base_property;
		base_property = newBase_property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.DEFAULT__BASE_PROPERTY, oldBase_property, base_property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.DEFAULT__VALUE:
				return getValue();
			case C_CppPackage.DEFAULT__BASE_PARAMETER:
				if (resolve) return getBase_parameter();
				return basicGetBase_parameter();
			case C_CppPackage.DEFAULT__BASE_PROPERTY:
				if (resolve) return getBase_property();
				return basicGetBase_property();
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
			case C_CppPackage.DEFAULT__VALUE:
				setValue((String)newValue);
				return;
			case C_CppPackage.DEFAULT__BASE_PARAMETER:
				setBase_parameter((Parameter)newValue);
				return;
			case C_CppPackage.DEFAULT__BASE_PROPERTY:
				setBase_property((Property)newValue);
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
			case C_CppPackage.DEFAULT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case C_CppPackage.DEFAULT__BASE_PARAMETER:
				setBase_parameter((Parameter)null);
				return;
			case C_CppPackage.DEFAULT__BASE_PROPERTY:
				setBase_property((Property)null);
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
			case C_CppPackage.DEFAULT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case C_CppPackage.DEFAULT__BASE_PARAMETER:
				return base_parameter != null;
			case C_CppPackage.DEFAULT__BASE_PROPERTY:
				return base_property != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //DefaultImpl
