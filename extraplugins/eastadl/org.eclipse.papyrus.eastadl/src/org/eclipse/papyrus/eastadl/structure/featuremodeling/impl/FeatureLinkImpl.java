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
package org.eclipse.papyrus.eastadl.structure.featuremodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RelationshipImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#isIsBidirectional <em>Is Bidirectional</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#getCustomType <em>Custom Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#getBase_AssociationClass <em>Base Association Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureLinkImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureLinkImpl extends RelationshipImpl implements FeatureLink {

	/**
	 * The default value of the '{@link #isIsBidirectional() <em>Is Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsBidirectional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BIDIRECTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBidirectional() <em>Is Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsBidirectional()
	 * @generated
	 * @ordered
	 */
	protected boolean isBidirectional = IS_BIDIRECTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomType() <em>Custom Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCustomType()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomType() <em>Custom Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCustomType()
	 * @generated
	 * @ordered
	 */
	protected String customType = CUSTOM_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Dependency() <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Dependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency base_Dependency;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Feature start;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected Feature end;

	/**
	 * The cached value of the '{@link #getBase_AssociationClass() <em>Base Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_AssociationClass()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass base_AssociationClass;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final VariabilityDependencyKind KIND_EDEFAULT = VariabilityDependencyKind.NEEDS;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected VariabilityDependencyKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FeaturemodelingPackage.FEATURE_LINK__IS_BIDIRECTIONAL:
				return isIsBidirectional();
			case FeaturemodelingPackage.FEATURE_LINK__CUSTOM_TYPE:
				return getCustomType();
			case FeaturemodelingPackage.FEATURE_LINK__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case FeaturemodelingPackage.FEATURE_LINK__START:
				if (resolve) return getStart();
				return basicGetStart();
			case FeaturemodelingPackage.FEATURE_LINK__END:
				if (resolve) return getEnd();
				return basicGetEnd();
			case FeaturemodelingPackage.FEATURE_LINK__BASE_ASSOCIATION_CLASS:
				if (resolve) return getBase_AssociationClass();
				return basicGetBase_AssociationClass();
			case FeaturemodelingPackage.FEATURE_LINK__KIND:
				return getKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FeaturemodelingPackage.FEATURE_LINK__IS_BIDIRECTIONAL:
				return isBidirectional != IS_BIDIRECTIONAL_EDEFAULT;
			case FeaturemodelingPackage.FEATURE_LINK__CUSTOM_TYPE:
				return CUSTOM_TYPE_EDEFAULT == null ? customType != null : !CUSTOM_TYPE_EDEFAULT.equals(customType);
			case FeaturemodelingPackage.FEATURE_LINK__BASE_DEPENDENCY:
				return base_Dependency != null;
			case FeaturemodelingPackage.FEATURE_LINK__START:
				return start != null;
			case FeaturemodelingPackage.FEATURE_LINK__END:
				return end != null;
			case FeaturemodelingPackage.FEATURE_LINK__BASE_ASSOCIATION_CLASS:
				return base_AssociationClass != null;
			case FeaturemodelingPackage.FEATURE_LINK__KIND:
				return kind != KIND_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FeaturemodelingPackage.FEATURE_LINK__IS_BIDIRECTIONAL:
				setIsBidirectional((Boolean)newValue);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__CUSTOM_TYPE:
				setCustomType((String)newValue);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__START:
				setStart((Feature)newValue);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__END:
				setEnd((Feature)newValue);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__BASE_ASSOCIATION_CLASS:
				setBase_AssociationClass((AssociationClass)newValue);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__KIND:
				setKind((VariabilityDependencyKind)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturemodelingPackage.Literals.FEATURE_LINK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FeaturemodelingPackage.FEATURE_LINK__IS_BIDIRECTIONAL:
				setIsBidirectional(IS_BIDIRECTIONAL_EDEFAULT);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__CUSTOM_TYPE:
				setCustomType(CUSTOM_TYPE_EDEFAULT);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__START:
				setStart((Feature)null);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__END:
				setEnd((Feature)null);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__BASE_ASSOCIATION_CLASS:
				setBase_AssociationClass((AssociationClass)null);
				return;
			case FeaturemodelingPackage.FEATURE_LINK__KIND:
				setKind(KIND_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomType() {
		return customType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getEnd() {
		if (end != null && end.eIsProxy()) {
			InternalEObject oldEnd = (InternalEObject)end;
			end = (Feature)eResolveProxy(oldEnd);
			if (end != oldEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_LINK__END, oldEnd, end));
			}
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityDependencyKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getStart() {
		if (start != null && start.eIsProxy()) {
			InternalEObject oldStart = (InternalEObject)start;
			start = (Feature)eResolveProxy(oldStart);
			if (start != oldStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_LINK__START, oldStart, start));
			}
		}
		return start;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBidirectional() {
		return isBidirectional;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomType(String newCustomType) {
		String oldCustomType = customType;
		customType = newCustomType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__CUSTOM_TYPE, oldCustomType, customType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getBase_Dependency() {
		if (base_Dependency != null && base_Dependency.eIsProxy()) {
			InternalEObject oldBase_Dependency = (InternalEObject)base_Dependency;
			base_Dependency = (Dependency)eResolveProxy(oldBase_Dependency);
			if (base_Dependency != oldBase_Dependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_LINK__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
			}
		}
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetBase_Dependency() {
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Dependency(Dependency newBase_Dependency) {
		Dependency oldBase_Dependency = base_Dependency;
		base_Dependency = newBase_Dependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Feature newEnd) {
		Feature oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getBase_AssociationClass() {
		if (base_AssociationClass != null && base_AssociationClass.eIsProxy()) {
			InternalEObject oldBase_AssociationClass = (InternalEObject)base_AssociationClass;
			base_AssociationClass = (AssociationClass)eResolveProxy(oldBase_AssociationClass);
			if (base_AssociationClass != oldBase_AssociationClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_LINK__BASE_ASSOCIATION_CLASS, oldBase_AssociationClass, base_AssociationClass));
			}
		}
		return base_AssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetBase_AssociationClass() {
		return base_AssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_AssociationClass(AssociationClass newBase_AssociationClass) {
		AssociationClass oldBase_AssociationClass = base_AssociationClass;
		base_AssociationClass = newBase_AssociationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__BASE_ASSOCIATION_CLASS, oldBase_AssociationClass, base_AssociationClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBidirectional(boolean newIsBidirectional) {
		boolean oldIsBidirectional = isBidirectional;
		isBidirectional = newIsBidirectional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__IS_BIDIRECTIONAL, oldIsBidirectional, isBidirectional));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(VariabilityDependencyKind newKind) {
		VariabilityDependencyKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Feature newStart) {
		Feature oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_LINK__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isBidirectional: ");
		result.append(isBidirectional);
		result.append(", customType: ");
		result.append(customType);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} // FeatureLinkImpl
