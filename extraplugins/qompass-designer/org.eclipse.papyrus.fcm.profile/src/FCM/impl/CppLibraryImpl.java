/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import FCM.CppLibrary;
import FCM.FCMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cpp Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link FCM.impl.CppLibraryImpl#getMacros <em>Macros</em>}</li>
 *   <li>{@link FCM.impl.CppLibraryImpl#getLibs <em>Libs</em>}</li>
 *   <li>{@link FCM.impl.CppLibraryImpl#getLibPaths <em>Lib Paths</em>}</li>
 *   <li>{@link FCM.impl.CppLibraryImpl#getIncludePaths <em>Include Paths</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppLibraryImpl extends ExternalLibraryImpl implements CppLibrary {
	/**
	 * The cached value of the '{@link #getMacros() <em>Macros</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMacros()
	 * @generated
	 * @ordered
	 */
	protected EList<String> macros;

	/**
	 * The cached value of the '{@link #getLibs() <em>Libs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> libs;

	/**
	 * The cached value of the '{@link #getLibPaths() <em>Lib Paths</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<String> libPaths;

	/**
	 * The cached value of the '{@link #getIncludePaths() <em>Include Paths</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludePaths()
	 * @generated
	 * @ordered
	 */
	protected EList<String> includePaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.CPP_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMacros() {
		if (macros == null) {
			macros = new EDataTypeEList<String>(String.class, this, FCMPackage.CPP_LIBRARY__MACROS);
		}
		return macros;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLibs() {
		if (libs == null) {
			libs = new EDataTypeEList<String>(String.class, this, FCMPackage.CPP_LIBRARY__LIBS);
		}
		return libs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLibPaths() {
		if (libPaths == null) {
			libPaths = new EDataTypeEList<String>(String.class, this, FCMPackage.CPP_LIBRARY__LIB_PATHS);
		}
		return libPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIncludePaths() {
		if (includePaths == null) {
			includePaths = new EDataTypeEList<String>(String.class, this, FCMPackage.CPP_LIBRARY__INCLUDE_PATHS);
		}
		return includePaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.CPP_LIBRARY__MACROS:
				return getMacros();
			case FCMPackage.CPP_LIBRARY__LIBS:
				return getLibs();
			case FCMPackage.CPP_LIBRARY__LIB_PATHS:
				return getLibPaths();
			case FCMPackage.CPP_LIBRARY__INCLUDE_PATHS:
				return getIncludePaths();
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
			case FCMPackage.CPP_LIBRARY__MACROS:
				getMacros().clear();
				getMacros().addAll((Collection<? extends String>)newValue);
				return;
			case FCMPackage.CPP_LIBRARY__LIBS:
				getLibs().clear();
				getLibs().addAll((Collection<? extends String>)newValue);
				return;
			case FCMPackage.CPP_LIBRARY__LIB_PATHS:
				getLibPaths().clear();
				getLibPaths().addAll((Collection<? extends String>)newValue);
				return;
			case FCMPackage.CPP_LIBRARY__INCLUDE_PATHS:
				getIncludePaths().clear();
				getIncludePaths().addAll((Collection<? extends String>)newValue);
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
			case FCMPackage.CPP_LIBRARY__MACROS:
				getMacros().clear();
				return;
			case FCMPackage.CPP_LIBRARY__LIBS:
				getLibs().clear();
				return;
			case FCMPackage.CPP_LIBRARY__LIB_PATHS:
				getLibPaths().clear();
				return;
			case FCMPackage.CPP_LIBRARY__INCLUDE_PATHS:
				getIncludePaths().clear();
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
			case FCMPackage.CPP_LIBRARY__MACROS:
				return macros != null && !macros.isEmpty();
			case FCMPackage.CPP_LIBRARY__LIBS:
				return libs != null && !libs.isEmpty();
			case FCMPackage.CPP_LIBRARY__LIB_PATHS:
				return libPaths != null && !libPaths.isEmpty();
			case FCMPackage.CPP_LIBRARY__INCLUDE_PATHS:
				return includePaths != null && !includePaths.isEmpty();
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
		result.append(" (macros: ");
		result.append(macros);
		result.append(", libs: ");
		result.append(libs);
		result.append(", libPaths: ");
		result.append(libPaths);
		result.append(", includePaths: ");
		result.append(includePaths);
		result.append(')');
		return result.toString();
	}

} //CppLibraryImpl
