/**
 */
package Cpp.impl;

import Cpp.CppInclude;
import Cpp.CppPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.PackageImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cpp.impl.CppIncludeImpl#getBody <em>Body</em>}</li>
 *   <li>{@link Cpp.impl.CppIncludeImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link Cpp.impl.CppIncludeImpl#getBase_package <em>Base package</em>}</li>
 *   <li>{@link Cpp.impl.CppIncludeImpl#getBase_class <em>Base class</em>}</li>
 *   <li>{@link Cpp.impl.CppIncludeImpl#getBase_PackageImport <em>Base Package Import</em>}</li>
 *   <li>{@link Cpp.impl.CppIncludeImpl#getPreBody <em>Pre Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppIncludeImpl extends EObjectImpl implements CppInclude {
	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected String body = BODY_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected String header = HEADER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_package() <em>Base package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_package;

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
	 * The cached value of the '{@link #getBase_PackageImport() <em>Base Package Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_PackageImport()
	 * @generated
	 * @ordered
	 */
	protected PackageImport base_PackageImport;

	/**
	 * The default value of the '{@link #getPreBody() <em>Pre Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreBody()
	 * @generated
	 * @ordered
	 */
	protected static final String PRE_BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPreBody() <em>Pre Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreBody()
	 * @generated
	 * @ordered
	 */
	protected String preBody = PRE_BODY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppIncludeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CppPackage.Literals.CPP_INCLUDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(String newBody) {
		String oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_INCLUDE__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(String newHeader) {
		String oldHeader = header;
		header = newHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_INCLUDE__HEADER, oldHeader, header));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_package() {
		if (base_package != null && base_package.eIsProxy()) {
			InternalEObject oldBase_package = (InternalEObject)base_package;
			base_package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_package);
			if (base_package != oldBase_package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_INCLUDE__BASE_PACKAGE, oldBase_package, base_package));
			}
		}
		return base_package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_package() {
		return base_package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_package(org.eclipse.uml2.uml.Package newBase_package) {
		org.eclipse.uml2.uml.Package oldBase_package = base_package;
		base_package = newBase_package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_INCLUDE__BASE_PACKAGE, oldBase_package, base_package));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_INCLUDE__BASE_CLASS, oldBase_class, base_class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_INCLUDE__BASE_CLASS, oldBase_class, base_class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageImport getBase_PackageImport() {
		if (base_PackageImport != null && base_PackageImport.eIsProxy()) {
			InternalEObject oldBase_PackageImport = (InternalEObject)base_PackageImport;
			base_PackageImport = (PackageImport)eResolveProxy(oldBase_PackageImport);
			if (base_PackageImport != oldBase_PackageImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_INCLUDE__BASE_PACKAGE_IMPORT, oldBase_PackageImport, base_PackageImport));
			}
		}
		return base_PackageImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageImport basicGetBase_PackageImport() {
		return base_PackageImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_PackageImport(PackageImport newBase_PackageImport) {
		PackageImport oldBase_PackageImport = base_PackageImport;
		base_PackageImport = newBase_PackageImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_INCLUDE__BASE_PACKAGE_IMPORT, oldBase_PackageImport, base_PackageImport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreBody() {
		return preBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreBody(String newPreBody) {
		String oldPreBody = preBody;
		preBody = newPreBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_INCLUDE__PRE_BODY, oldPreBody, preBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CppPackage.CPP_INCLUDE__BODY:
				return getBody();
			case CppPackage.CPP_INCLUDE__HEADER:
				return getHeader();
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE:
				if (resolve) return getBase_package();
				return basicGetBase_package();
			case CppPackage.CPP_INCLUDE__BASE_CLASS:
				if (resolve) return getBase_class();
				return basicGetBase_class();
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE_IMPORT:
				if (resolve) return getBase_PackageImport();
				return basicGetBase_PackageImport();
			case CppPackage.CPP_INCLUDE__PRE_BODY:
				return getPreBody();
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
			case CppPackage.CPP_INCLUDE__BODY:
				setBody((String)newValue);
				return;
			case CppPackage.CPP_INCLUDE__HEADER:
				setHeader((String)newValue);
				return;
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE:
				setBase_package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case CppPackage.CPP_INCLUDE__BASE_CLASS:
				setBase_class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE_IMPORT:
				setBase_PackageImport((PackageImport)newValue);
				return;
			case CppPackage.CPP_INCLUDE__PRE_BODY:
				setPreBody((String)newValue);
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
			case CppPackage.CPP_INCLUDE__BODY:
				setBody(BODY_EDEFAULT);
				return;
			case CppPackage.CPP_INCLUDE__HEADER:
				setHeader(HEADER_EDEFAULT);
				return;
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE:
				setBase_package((org.eclipse.uml2.uml.Package)null);
				return;
			case CppPackage.CPP_INCLUDE__BASE_CLASS:
				setBase_class((org.eclipse.uml2.uml.Class)null);
				return;
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE_IMPORT:
				setBase_PackageImport((PackageImport)null);
				return;
			case CppPackage.CPP_INCLUDE__PRE_BODY:
				setPreBody(PRE_BODY_EDEFAULT);
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
			case CppPackage.CPP_INCLUDE__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case CppPackage.CPP_INCLUDE__HEADER:
				return HEADER_EDEFAULT == null ? header != null : !HEADER_EDEFAULT.equals(header);
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE:
				return base_package != null;
			case CppPackage.CPP_INCLUDE__BASE_CLASS:
				return base_class != null;
			case CppPackage.CPP_INCLUDE__BASE_PACKAGE_IMPORT:
				return base_PackageImport != null;
			case CppPackage.CPP_INCLUDE__PRE_BODY:
				return PRE_BODY_EDEFAULT == null ? preBody != null : !PRE_BODY_EDEFAULT.equals(preBody);
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
		result.append(" (body: ");
		result.append(body);
		result.append(", header: ");
		result.append(header);
		result.append(", preBody: ");
		result.append(preBody);
		result.append(')');
		return result.toString();
	}

} //CppIncludeImpl
