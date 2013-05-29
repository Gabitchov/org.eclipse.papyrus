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
package org.eclipse.papyrus.eastadl.timing.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.timing.PrecedenceConstraint;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Precedence Constraint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.PrecedenceConstraintImpl#getSuccessive <em>Successive</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.PrecedenceConstraintImpl#getPreceding <em>Preceding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.PrecedenceConstraintImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.PrecedenceConstraintImpl#getSuccessive_path <em>Successive path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.PrecedenceConstraintImpl#getPreceding_path <em>Preceding path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrecedenceConstraintImpl extends TimingConstraintImpl implements PrecedenceConstraint {

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
	 * The cached value of the '{@link #getSuccessive_path() <em>Successive path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessive_path()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionPrototype> successive_path;

	/**
	 * The cached value of the '{@link #getPreceding_path() <em>Preceding path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreceding_path()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionPrototype> preceding_path;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PrecedenceConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FunctionPrototype basicGetPreceding() {

		FunctionPrototype preceding = null;

		if(getBase_Dependency() != null) {

			EList<Element> sources = getBase_Dependency().getSources();
			if(!sources.isEmpty()) {
				Element current = sources.get(0);

				FunctionPrototype currentFProto = (FunctionPrototype)UMLUtil.getStereotypeApplication(current,
					FunctionPrototype.class);

				if(currentFProto != null) {
					preceding = currentFProto;
				}
			}
		}

		return preceding;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingPackage.PRECEDENCE_CONSTRAINT__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.PRECEDENCE_CONSTRAINT__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionPrototype> getSuccessive_path() {
		if (successive_path == null) {
			successive_path = new EObjectResolvingEList<FunctionPrototype>(FunctionPrototype.class, this, TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE_PATH);
		}
		return successive_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionPrototype> getPreceding_path() {
		if (preceding_path == null) {
			preceding_path = new EObjectResolvingEList<FunctionPrototype>(FunctionPrototype.class, this, TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING_PATH);
		}
		return preceding_path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE:
				return getSuccessive();
			case TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING:
				if (resolve) return getPreceding();
				return basicGetPreceding();
			case TimingPackage.PRECEDENCE_CONSTRAINT__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE_PATH:
				return getSuccessive_path();
			case TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING_PATH:
				return getPreceding_path();
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
			case TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE:
				return !getSuccessive().isEmpty();
			case TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING:
				return basicGetPreceding() != null;
			case TimingPackage.PRECEDENCE_CONSTRAINT__BASE_DEPENDENCY:
				return base_Dependency != null;
			case TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE_PATH:
				return successive_path != null && !successive_path.isEmpty();
			case TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING_PATH:
				return preceding_path != null && !preceding_path.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TimingPackage.PRECEDENCE_CONSTRAINT__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE_PATH:
				getSuccessive_path().clear();
				getSuccessive_path().addAll((Collection<? extends FunctionPrototype>)newValue);
				return;
			case TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING_PATH:
				getPreceding_path().clear();
				getPreceding_path().addAll((Collection<? extends FunctionPrototype>)newValue);
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
		return TimingPackage.Literals.PRECEDENCE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TimingPackage.PRECEDENCE_CONSTRAINT__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case TimingPackage.PRECEDENCE_CONSTRAINT__SUCCESSIVE_PATH:
				getSuccessive_path().clear();
				return;
			case TimingPackage.PRECEDENCE_CONSTRAINT__PRECEDING_PATH:
				getPreceding_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionPrototype getPreceding() {
		FunctionPrototype preceding = basicGetPreceding();
		return preceding != null && preceding.eIsProxy() ? (FunctionPrototype)eResolveProxy((InternalEObject)preceding) : preceding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<FunctionPrototype> getSuccessive() {

		EList<FunctionPrototype> successives = new BasicEList<FunctionPrototype>();
		FunctionPrototype currentFProto = null;

		if(getBase_Dependency() != null) {
			Iterator<Element> it = getBase_Dependency().getTargets().iterator();

			// RequirementDescriptions in owned comments
			while(it.hasNext()) {
				Element current = it.next();
				currentFProto = (FunctionPrototype)UMLUtil.getStereotypeApplication(current, FunctionPrototype.class);

				if(currentFProto != null) {
					successives.add(currentFProto);
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<FunctionPrototype>(FunctionPrototype.class, successives.size(), successives
			.toArray());
	}

} // PrecedenceConstraintImpl
