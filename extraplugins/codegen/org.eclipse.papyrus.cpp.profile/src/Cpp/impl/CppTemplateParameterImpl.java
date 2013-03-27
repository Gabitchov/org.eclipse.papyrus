/**
 */
package Cpp.impl;

import Cpp.CppPackage;
import Cpp.CppTemplateParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.TemplateParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cpp.impl.CppTemplateParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link Cpp.impl.CppTemplateParameterImpl#getBase_templateparameter <em>Base templateparameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppTemplateParameterImpl extends EObjectImpl implements CppTemplateParameter {
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
	 * The cached value of the '{@link #getBase_templateparameter() <em>Base templateparameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_templateparameter()
	 * @generated
	 * @ordered
	 */
	protected TemplateParameter base_templateparameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppTemplateParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CppPackage.Literals.CPP_TEMPLATE_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_TEMPLATE_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getBase_templateparameter() {
		if (base_templateparameter != null && base_templateparameter.eIsProxy()) {
			InternalEObject oldBase_templateparameter = (InternalEObject)base_templateparameter;
			base_templateparameter = (TemplateParameter)eResolveProxy(oldBase_templateparameter);
			if (base_templateparameter != oldBase_templateparameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER, oldBase_templateparameter, base_templateparameter));
			}
		}
		return base_templateparameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetBase_templateparameter() {
		return base_templateparameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_templateparameter(TemplateParameter newBase_templateparameter) {
		TemplateParameter oldBase_templateparameter = base_templateparameter;
		base_templateparameter = newBase_templateparameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER, oldBase_templateparameter, base_templateparameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CppPackage.CPP_TEMPLATE_PARAMETER__NAME:
				return getName();
			case CppPackage.CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER:
				if (resolve) return getBase_templateparameter();
				return basicGetBase_templateparameter();
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
			case CppPackage.CPP_TEMPLATE_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case CppPackage.CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER:
				setBase_templateparameter((TemplateParameter)newValue);
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
			case CppPackage.CPP_TEMPLATE_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CppPackage.CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER:
				setBase_templateparameter((TemplateParameter)null);
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
			case CppPackage.CPP_TEMPLATE_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CppPackage.CPP_TEMPLATE_PARAMETER__BASE_TEMPLATEPARAMETER:
				return base_templateparameter != null;
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

} //CppTemplateParameterImpl
