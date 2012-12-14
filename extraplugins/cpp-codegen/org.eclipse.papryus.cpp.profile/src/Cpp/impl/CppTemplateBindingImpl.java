/**
 */
package Cpp.impl;

import Cpp.CppPackage;
import Cpp.CppTemplateBinding;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cpp.impl.CppTemplateBindingImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link Cpp.impl.CppTemplateBindingImpl#getBase_templatebinding <em>Base templatebinding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppTemplateBindingImpl extends EObjectImpl implements CppTemplateBinding {
	/**
	 * The default value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected static final String BINDING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected String binding = BINDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_templatebinding() <em>Base templatebinding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_templatebinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBinding base_templatebinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppTemplateBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CppPackage.Literals.CPP_TEMPLATE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(String newBinding) {
		String oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_TEMPLATE_BINDING__BINDING, oldBinding, binding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding getBase_templatebinding() {
		if (base_templatebinding != null && base_templatebinding.eIsProxy()) {
			InternalEObject oldBase_templatebinding = (InternalEObject)base_templatebinding;
			base_templatebinding = (TemplateBinding)eResolveProxy(oldBase_templatebinding);
			if (base_templatebinding != oldBase_templatebinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING, oldBase_templatebinding, base_templatebinding));
			}
		}
		return base_templatebinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding basicGetBase_templatebinding() {
		return base_templatebinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_templatebinding(TemplateBinding newBase_templatebinding) {
		TemplateBinding oldBase_templatebinding = base_templatebinding;
		base_templatebinding = newBase_templatebinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING, oldBase_templatebinding, base_templatebinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CppPackage.CPP_TEMPLATE_BINDING__BINDING:
				return getBinding();
			case CppPackage.CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				if (resolve) return getBase_templatebinding();
				return basicGetBase_templatebinding();
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
			case CppPackage.CPP_TEMPLATE_BINDING__BINDING:
				setBinding((String)newValue);
				return;
			case CppPackage.CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				setBase_templatebinding((TemplateBinding)newValue);
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
			case CppPackage.CPP_TEMPLATE_BINDING__BINDING:
				setBinding(BINDING_EDEFAULT);
				return;
			case CppPackage.CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				setBase_templatebinding((TemplateBinding)null);
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
			case CppPackage.CPP_TEMPLATE_BINDING__BINDING:
				return BINDING_EDEFAULT == null ? binding != null : !BINDING_EDEFAULT.equals(binding);
			case CppPackage.CPP_TEMPLATE_BINDING__BASE_TEMPLATEBINDING:
				return base_templatebinding != null;
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
		result.append(" (binding: ");
		result.append(binding);
		result.append(')');
		return result.toString();
	}

} //CppTemplateBindingImpl
