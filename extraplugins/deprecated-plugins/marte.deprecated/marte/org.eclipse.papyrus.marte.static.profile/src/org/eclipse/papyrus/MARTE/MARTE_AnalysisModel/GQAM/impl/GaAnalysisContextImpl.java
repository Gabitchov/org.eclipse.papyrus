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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaResourcesPlatform;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaWorkloadBehavior;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.ExpressionContext;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.VariablesPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.ConfigurationImpl;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Analysis Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl#getWorkload <em>Workload</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl#getPlatform <em>Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaAnalysisContextImpl extends ConfigurationImpl implements GaAnalysisContext {
	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EList<String> context;

	/**
	 * The cached value of the '{@link #getWorkload() <em>Workload</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkload()
	 * @generated
	 * @ordered
	 */
	protected EList<GaWorkloadBehavior> workload;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected EList<GaResourcesPlatform> platform;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaAnalysisContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_ANALYSIS_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if (base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if (base_NamedElement != oldBase_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContext() {
		if (context == null) {
			context = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT);
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaWorkloadBehavior> getWorkload() {
		if (workload == null) {
			workload = new EObjectResolvingEList<GaWorkloadBehavior>(GaWorkloadBehavior.class, this, GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD);
		}
		return workload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaResourcesPlatform> getPlatform() {
		if (platform == null) {
			platform = new EObjectResolvingEList<GaResourcesPlatform>(GaResourcesPlatform.class, this, GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM);
		}
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
			case GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT:
				return getContext();
			case GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD:
				return getWorkload();
			case GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM:
				return getPlatform();
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
			case GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
				return;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT:
				getContext().clear();
				getContext().addAll((Collection<? extends String>)newValue);
				return;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD:
				getWorkload().clear();
				getWorkload().addAll((Collection<? extends GaWorkloadBehavior>)newValue);
				return;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM:
				getPlatform().clear();
				getPlatform().addAll((Collection<? extends GaResourcesPlatform>)newValue);
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
			case GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
				return;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT:
				getContext().clear();
				return;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD:
				getWorkload().clear();
				return;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM:
				getPlatform().clear();
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
			case GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
			case GQAMPackage.GA_ANALYSIS_CONTEXT__CONTEXT:
				return context != null && !context.isEmpty();
			case GQAMPackage.GA_ANALYSIS_CONTEXT__WORKLOAD:
				return workload != null && !workload.isEmpty();
			case GQAMPackage.GA_ANALYSIS_CONTEXT__PLATFORM:
				return platform != null && !platform.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionContext.class) {
			switch (derivedFeatureID) {
				case GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT: return VariablesPackage.EXPRESSION_CONTEXT__BASE_NAMED_ELEMENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionContext.class) {
			switch (baseFeatureID) {
				case VariablesPackage.EXPRESSION_CONTEXT__BASE_NAMED_ELEMENT: return GQAMPackage.GA_ANALYSIS_CONTEXT__BASE_NAMED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (context: ");
		result.append(context);
		result.append(')');
		return result.toString();
	}

} //GaAnalysisContextImpl
