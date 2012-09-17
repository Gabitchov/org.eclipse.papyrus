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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl#getNature <em>Nature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl#getImpliedConstraint <em>Implied Constraint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl#getBase_Comment <em>Base Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignImpl extends EObjectImpl implements Assign {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final AssignmentKind KIND_EDEFAULT = AssignmentKind.STRUCTURAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected AssignmentKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected static final AssignmentNature NATURE_EDEFAULT = AssignmentNature.SPATIAL_DISTRIBUTION;

	/**
	 * The cached value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected AssignmentNature nature = NATURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImpliedConstraint() <em>Implied Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpliedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<NfpConstraint> impliedConstraint;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> to;

	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocPackage.Literals.ASSIGN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(AssignmentKind newKind) {
		AssignmentKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ASSIGN__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentNature getNature() {
		return nature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNature(AssignmentNature newNature) {
		AssignmentNature oldNature = nature;
		nature = newNature == null ? NATURE_EDEFAULT : newNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ASSIGN__NATURE, oldNature, nature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NfpConstraint> getImpliedConstraint() {
		if (impliedConstraint == null) {
			impliedConstraint = new EObjectResolvingEList<NfpConstraint>(NfpConstraint.class, this, AllocPackage.ASSIGN__IMPLIED_CONSTRAINT);
		}
		return impliedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getFrom() {
		if (from == null) {
			from = new EObjectResolvingEList<Element>(Element.class, this, AllocPackage.ASSIGN__FROM);
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getTo() {
		if (to == null) {
			to = new EObjectResolvingEList<Element>(Element.class, this, AllocPackage.ASSIGN__TO);
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment getBase_Comment() {
		if (base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if (base_Comment != oldBase_Comment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocPackage.ASSIGN__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ASSIGN__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocPackage.ASSIGN__KIND:
				return getKind();
			case AllocPackage.ASSIGN__NATURE:
				return getNature();
			case AllocPackage.ASSIGN__IMPLIED_CONSTRAINT:
				return getImpliedConstraint();
			case AllocPackage.ASSIGN__FROM:
				return getFrom();
			case AllocPackage.ASSIGN__TO:
				return getTo();
			case AllocPackage.ASSIGN__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
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
			case AllocPackage.ASSIGN__KIND:
				setKind((AssignmentKind)newValue);
				return;
			case AllocPackage.ASSIGN__NATURE:
				setNature((AssignmentNature)newValue);
				return;
			case AllocPackage.ASSIGN__IMPLIED_CONSTRAINT:
				getImpliedConstraint().clear();
				getImpliedConstraint().addAll((Collection<? extends NfpConstraint>)newValue);
				return;
			case AllocPackage.ASSIGN__FROM:
				getFrom().clear();
				getFrom().addAll((Collection<? extends Element>)newValue);
				return;
			case AllocPackage.ASSIGN__TO:
				getTo().clear();
				getTo().addAll((Collection<? extends Element>)newValue);
				return;
			case AllocPackage.ASSIGN__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
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
			case AllocPackage.ASSIGN__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case AllocPackage.ASSIGN__NATURE:
				setNature(NATURE_EDEFAULT);
				return;
			case AllocPackage.ASSIGN__IMPLIED_CONSTRAINT:
				getImpliedConstraint().clear();
				return;
			case AllocPackage.ASSIGN__FROM:
				getFrom().clear();
				return;
			case AllocPackage.ASSIGN__TO:
				getTo().clear();
				return;
			case AllocPackage.ASSIGN__BASE_COMMENT:
				setBase_Comment((Comment)null);
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
			case AllocPackage.ASSIGN__KIND:
				return kind != KIND_EDEFAULT;
			case AllocPackage.ASSIGN__NATURE:
				return nature != NATURE_EDEFAULT;
			case AllocPackage.ASSIGN__IMPLIED_CONSTRAINT:
				return impliedConstraint != null && !impliedConstraint.isEmpty();
			case AllocPackage.ASSIGN__FROM:
				return from != null && !from.isEmpty();
			case AllocPackage.ASSIGN__TO:
				return to != null && !to.isEmpty();
			case AllocPackage.ASSIGN__BASE_COMMENT:
				return base_Comment != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", nature: ");
		result.append(nature);
		result.append(')');
		return result.toString();
	}

} //AssignImpl
