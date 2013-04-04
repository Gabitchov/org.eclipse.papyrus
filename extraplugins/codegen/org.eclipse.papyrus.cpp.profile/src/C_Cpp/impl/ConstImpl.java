/**
 */
package C_Cpp.impl;

import C_Cpp.C_CppPackage;
import C_Cpp.Const;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Const</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link C_Cpp.impl.ConstImpl#getBase_parameter <em>Base parameter</em>}</li>
 *   <li>{@link C_Cpp.impl.ConstImpl#getBase_property <em>Base property</em>}</li>
 *   <li>{@link C_Cpp.impl.ConstImpl#getBase_operation <em>Base operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstImpl extends EObjectImpl implements Const {
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
	 * The cached value of the '{@link #getBase_operation() <em>Base operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.CONST;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.CONST__BASE_PARAMETER, oldBase_parameter, base_parameter));
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
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.CONST__BASE_PARAMETER, oldBase_parameter, base_parameter));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.CONST__BASE_PROPERTY, oldBase_property, base_property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.CONST__BASE_PROPERTY, oldBase_property, base_property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBase_operation() {
		if (base_operation != null && base_operation.eIsProxy()) {
			InternalEObject oldBase_operation = (InternalEObject)base_operation;
			base_operation = (Operation)eResolveProxy(oldBase_operation);
			if (base_operation != oldBase_operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.CONST__BASE_OPERATION, oldBase_operation, base_operation));
			}
		}
		return base_operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_operation() {
		return base_operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_operation(Operation newBase_operation) {
		Operation oldBase_operation = base_operation;
		base_operation = newBase_operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.CONST__BASE_OPERATION, oldBase_operation, base_operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.CONST__BASE_PARAMETER:
				if (resolve) return getBase_parameter();
				return basicGetBase_parameter();
			case C_CppPackage.CONST__BASE_PROPERTY:
				if (resolve) return getBase_property();
				return basicGetBase_property();
			case C_CppPackage.CONST__BASE_OPERATION:
				if (resolve) return getBase_operation();
				return basicGetBase_operation();
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
			case C_CppPackage.CONST__BASE_PARAMETER:
				setBase_parameter((Parameter)newValue);
				return;
			case C_CppPackage.CONST__BASE_PROPERTY:
				setBase_property((Property)newValue);
				return;
			case C_CppPackage.CONST__BASE_OPERATION:
				setBase_operation((Operation)newValue);
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
			case C_CppPackage.CONST__BASE_PARAMETER:
				setBase_parameter((Parameter)null);
				return;
			case C_CppPackage.CONST__BASE_PROPERTY:
				setBase_property((Property)null);
				return;
			case C_CppPackage.CONST__BASE_OPERATION:
				setBase_operation((Operation)null);
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
			case C_CppPackage.CONST__BASE_PARAMETER:
				return base_parameter != null;
			case C_CppPackage.CONST__BASE_PROPERTY:
				return base_property != null;
			case C_CppPackage.CONST__BASE_OPERATION:
				return base_operation != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstImpl
