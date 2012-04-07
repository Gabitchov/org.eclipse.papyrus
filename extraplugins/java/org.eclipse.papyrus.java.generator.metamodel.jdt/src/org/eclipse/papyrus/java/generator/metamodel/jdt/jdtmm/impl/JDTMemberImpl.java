/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.core.Flags;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl#getExplicitRequiredImports <em>Explicit Required Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class JDTMemberImpl extends JDTParentJavaElementImpl implements JDTMember {

	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTTypeParameter> typeParameters;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final VisibilityKind VISIBILITY_EDEFAULT = VisibilityKind.PUBLIC;

	/**
	 * The cached value of the '{@link #getExplicitRequiredImports() <em>Explicit Required Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitRequiredImports()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTType> explicitRequiredImports;

	/**
	 * The cached value of the '{@link #getExplicitPlainTextRequiredImports() <em>Explicit Plain Text Required Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitPlainTextRequiredImports()
	 * @generated
	 * @ordered
	 */
	protected EList<String> explicitPlainTextRequiredImports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTTypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentWithInverseEList<JDTTypeParameter>(JDTTypeParameter.class, this, JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS, JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public VisibilityKind getVisibility() {

		if(Flags.isPublic(flags))
			return VisibilityKind.PUBLIC;
		else if(Flags.isProtected(flags))
			return VisibilityKind.PROTECTED;
		else if(Flags.isPrivate(flags))
			return VisibilityKind.PRIVATE;

		// default
		return VisibilityKind.PUBLIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setVisibility(VisibilityKind newVisibility) {

		switch(newVisibility) {
		case PUBLIC:
			setFlag(Flags.AccPublic, true);
			setFlag(Flags.AccProtected, false);
			setFlag(Flags.AccPrivate, false);
			break;
		case PROTECTED:
			setFlag(Flags.AccPublic, false);
			setFlag(Flags.AccProtected, true);
			setFlag(Flags.AccPrivate, false);
			break;
		case PRIVATE:
			setFlag(Flags.AccPublic, false);
			setFlag(Flags.AccProtected, false);
			setFlag(Flags.AccPrivate, true);
			break;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTType> getExplicitRequiredImports() {
		if (explicitRequiredImports == null) {
			explicitRequiredImports = new EObjectResolvingEList<JDTType>(JDTType.class, this, JdtmmPackage.JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS);
		}
		return explicitRequiredImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExplicitPlainTextRequiredImports() {
		if (explicitPlainTextRequiredImports == null) {
			explicitPlainTextRequiredImports = new EDataTypeUniqueEList<String>(String.class, this, JdtmmPackage.JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
		}
		return explicitPlainTextRequiredImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypeParameters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS:
				return getTypeParameters();
			case JdtmmPackage.JDT_MEMBER__VISIBILITY:
				return getVisibility();
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS:
				return getExplicitRequiredImports();
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return getExplicitPlainTextRequiredImports();
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
			case JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JDTTypeParameter>)newValue);
				return;
			case JdtmmPackage.JDT_MEMBER__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS:
				getExplicitRequiredImports().clear();
				getExplicitRequiredImports().addAll((Collection<? extends JDTType>)newValue);
				return;
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
				getExplicitPlainTextRequiredImports().addAll((Collection<? extends String>)newValue);
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
			case JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case JdtmmPackage.JDT_MEMBER__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS:
				getExplicitRequiredImports().clear();
				return;
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
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
			case JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case JdtmmPackage.JDT_MEMBER__VISIBILITY:
				return getVisibility() != VISIBILITY_EDEFAULT;
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS:
				return explicitRequiredImports != null && !explicitRequiredImports.isEmpty();
			case JdtmmPackage.JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return explicitPlainTextRequiredImports != null && !explicitPlainTextRequiredImports.isEmpty();
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
		result.append(" (explicitPlainTextRequiredImports: ");
		result.append(explicitPlainTextRequiredImports);
		result.append(')');
		return result.toString();
	}


} //JDTMemberImpl
