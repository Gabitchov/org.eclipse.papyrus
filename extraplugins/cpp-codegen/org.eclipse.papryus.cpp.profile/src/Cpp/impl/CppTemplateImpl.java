/**
 */
package Cpp.impl;

import Cpp.CppPackage;
import Cpp.CppTemplate;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cpp.impl.CppTemplateImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link Cpp.impl.CppTemplateImpl#getBase_class <em>Base class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppTemplateImpl extends EObjectImpl implements CppTemplate {
	/**
	 * The default value of the '{@link #getDeclaration() <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final String DECLARATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected String declaration = DECLARATION_EDEFAULT;

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
	protected CppTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CppPackage.Literals.CPP_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(String newDeclaration) {
		String oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_TEMPLATE__DECLARATION, oldDeclaration, declaration));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_TEMPLATE__BASE_CLASS, oldBase_class, base_class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_TEMPLATE__BASE_CLASS, oldBase_class, base_class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CppPackage.CPP_TEMPLATE__DECLARATION:
				return getDeclaration();
			case CppPackage.CPP_TEMPLATE__BASE_CLASS:
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
			case CppPackage.CPP_TEMPLATE__DECLARATION:
				setDeclaration((String)newValue);
				return;
			case CppPackage.CPP_TEMPLATE__BASE_CLASS:
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
			case CppPackage.CPP_TEMPLATE__DECLARATION:
				setDeclaration(DECLARATION_EDEFAULT);
				return;
			case CppPackage.CPP_TEMPLATE__BASE_CLASS:
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
			case CppPackage.CPP_TEMPLATE__DECLARATION:
				return DECLARATION_EDEFAULT == null ? declaration != null : !DECLARATION_EDEFAULT.equals(declaration);
			case CppPackage.CPP_TEMPLATE__BASE_CLASS:
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
		result.append(" (declaration: ");
		result.append(declaration);
		result.append(')');
		return result.toString();
	}

} //CppTemplateImpl
