/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.C_Cpp.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.ExternLibrary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extern Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl#getIncludePaths <em>Include Paths</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl#getBase_package <em>Base package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl#getLibPaths <em>Lib Paths</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl#getMacros <em>Macros</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl#getLibs <em>Libs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.ExternLibraryImpl#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternLibraryImpl extends MinimalEObjectImpl.Container implements ExternLibrary {
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
	 * The cached value of the '{@link #getBase_package() <em>Base package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_package;

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
	 * The cached value of the '{@link #getIncludes() <em>Includes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> includes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.EXTERN_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIncludePaths() {
		if (includePaths == null) {
			includePaths = new EDataTypeEList<String>(String.class, this, C_CppPackage.EXTERN_LIBRARY__INCLUDE_PATHS);
		}
		return includePaths;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.EXTERN_LIBRARY__BASE_PACKAGE, oldBase_package, base_package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.EXTERN_LIBRARY__BASE_PACKAGE, oldBase_package, base_package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLibPaths() {
		if (libPaths == null) {
			libPaths = new EDataTypeUniqueEList<String>(String.class, this, C_CppPackage.EXTERN_LIBRARY__LIB_PATHS);
		}
		return libPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMacros() {
		if (macros == null) {
			macros = new EDataTypeUniqueEList<String>(String.class, this, C_CppPackage.EXTERN_LIBRARY__MACROS);
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
			libs = new EDataTypeUniqueEList<String>(String.class, this, C_CppPackage.EXTERN_LIBRARY__LIBS);
		}
		return libs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIncludes() {
		if (includes == null) {
			includes = new EDataTypeUniqueEList<String>(String.class, this, C_CppPackage.EXTERN_LIBRARY__INCLUDES);
		}
		return includes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.EXTERN_LIBRARY__INCLUDE_PATHS:
				return getIncludePaths();
			case C_CppPackage.EXTERN_LIBRARY__BASE_PACKAGE:
				if (resolve) return getBase_package();
				return basicGetBase_package();
			case C_CppPackage.EXTERN_LIBRARY__LIB_PATHS:
				return getLibPaths();
			case C_CppPackage.EXTERN_LIBRARY__MACROS:
				return getMacros();
			case C_CppPackage.EXTERN_LIBRARY__LIBS:
				return getLibs();
			case C_CppPackage.EXTERN_LIBRARY__INCLUDES:
				return getIncludes();
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
			case C_CppPackage.EXTERN_LIBRARY__INCLUDE_PATHS:
				getIncludePaths().clear();
				getIncludePaths().addAll((Collection<? extends String>)newValue);
				return;
			case C_CppPackage.EXTERN_LIBRARY__BASE_PACKAGE:
				setBase_package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case C_CppPackage.EXTERN_LIBRARY__LIB_PATHS:
				getLibPaths().clear();
				getLibPaths().addAll((Collection<? extends String>)newValue);
				return;
			case C_CppPackage.EXTERN_LIBRARY__MACROS:
				getMacros().clear();
				getMacros().addAll((Collection<? extends String>)newValue);
				return;
			case C_CppPackage.EXTERN_LIBRARY__LIBS:
				getLibs().clear();
				getLibs().addAll((Collection<? extends String>)newValue);
				return;
			case C_CppPackage.EXTERN_LIBRARY__INCLUDES:
				getIncludes().clear();
				getIncludes().addAll((Collection<? extends String>)newValue);
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
			case C_CppPackage.EXTERN_LIBRARY__INCLUDE_PATHS:
				getIncludePaths().clear();
				return;
			case C_CppPackage.EXTERN_LIBRARY__BASE_PACKAGE:
				setBase_package((org.eclipse.uml2.uml.Package)null);
				return;
			case C_CppPackage.EXTERN_LIBRARY__LIB_PATHS:
				getLibPaths().clear();
				return;
			case C_CppPackage.EXTERN_LIBRARY__MACROS:
				getMacros().clear();
				return;
			case C_CppPackage.EXTERN_LIBRARY__LIBS:
				getLibs().clear();
				return;
			case C_CppPackage.EXTERN_LIBRARY__INCLUDES:
				getIncludes().clear();
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
			case C_CppPackage.EXTERN_LIBRARY__INCLUDE_PATHS:
				return includePaths != null && !includePaths.isEmpty();
			case C_CppPackage.EXTERN_LIBRARY__BASE_PACKAGE:
				return base_package != null;
			case C_CppPackage.EXTERN_LIBRARY__LIB_PATHS:
				return libPaths != null && !libPaths.isEmpty();
			case C_CppPackage.EXTERN_LIBRARY__MACROS:
				return macros != null && !macros.isEmpty();
			case C_CppPackage.EXTERN_LIBRARY__LIBS:
				return libs != null && !libs.isEmpty();
			case C_CppPackage.EXTERN_LIBRARY__INCLUDES:
				return includes != null && !includes.isEmpty();
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
		result.append(" (includePaths: "); //$NON-NLS-1$
		result.append(includePaths);
		result.append(", libPaths: "); //$NON-NLS-1$
		result.append(libPaths);
		result.append(", macros: "); //$NON-NLS-1$
		result.append(macros);
		result.append(", libs: "); //$NON-NLS-1$
		result.append(libs);
		result.append(", includes: "); //$NON-NLS-1$
		result.append(includes);
		result.append(')');
		return result.toString();
	}

} //ExternLibraryImpl
