/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.structure.systemmodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl#getFunctionalAnalysisArchitecture <em>Functional Analysis
 * Architecture</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AnalysisLevelImpl extends ContextImpl implements AnalysisLevel {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The cached value of the '{@link #getFunctionalAnalysisArchitecture() <em>Functional Analysis Architecture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunctionalAnalysisArchitecture()
	 * @generated
	 * @ordered
	 */
	protected AnalysisFunctionPrototype functionalAnalysisArchitecture;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AnalysisLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalysisFunctionPrototype basicGetFunctionalAnalysisArchitecture() {
		return functionalAnalysisArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
		case SystemmodelingPackage.ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE:
			if(resolve)
				return getFunctionalAnalysisArchitecture();
			return basicGetFunctionalAnalysisArchitecture();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_CLASS:
			return base_Class != null;
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_PACKAGE:
			return base_Package != null;
		case SystemmodelingPackage.ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE:
			return functionalAnalysisArchitecture != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
			return;
		case SystemmodelingPackage.ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE:
			setFunctionalAnalysisArchitecture((AnalysisFunctionPrototype)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemmodelingPackage.Literals.ANALYSIS_LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.ANALYSIS_LEVEL__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.ANALYSIS_LEVEL__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if(base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if(base_Package != oldBase_Package) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.ANALYSIS_LEVEL__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.ANALYSIS_LEVEL__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case SystemmodelingPackage.ANALYSIS_LEVEL__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
			return;
		case SystemmodelingPackage.ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE:
			setFunctionalAnalysisArchitecture((AnalysisFunctionPrototype)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalysisFunctionPrototype getFunctionalAnalysisArchitecture() {
		if(functionalAnalysisArchitecture != null && functionalAnalysisArchitecture.eIsProxy()) {
			InternalEObject oldFunctionalAnalysisArchitecture = (InternalEObject)functionalAnalysisArchitecture;
			functionalAnalysisArchitecture = (AnalysisFunctionPrototype)eResolveProxy(oldFunctionalAnalysisArchitecture);
			if(functionalAnalysisArchitecture != oldFunctionalAnalysisArchitecture) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemmodelingPackage.ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE, oldFunctionalAnalysisArchitecture, functionalAnalysisArchitecture));
			}
		}
		return functionalAnalysisArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFunctionalAnalysisArchitecture(AnalysisFunctionPrototype newFunctionalAnalysisArchitecture) {
		AnalysisFunctionPrototype oldFunctionalAnalysisArchitecture = functionalAnalysisArchitecture;
		functionalAnalysisArchitecture = newFunctionalAnalysisArchitecture;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemmodelingPackage.ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE, oldFunctionalAnalysisArchitecture, functionalAnalysisArchitecture));
	}

} //AnalysisLevelImpl
