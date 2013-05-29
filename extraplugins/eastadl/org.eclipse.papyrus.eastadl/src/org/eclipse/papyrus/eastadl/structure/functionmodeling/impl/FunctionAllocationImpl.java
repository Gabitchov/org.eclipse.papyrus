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
package org.eclipse.papyrus.eastadl.structure.functionmodeling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AllocateableElement;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.AllocationTarget;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Function Allocation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl#getAllocatedElement <em>Allocated Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl#getAllocatedElement_path <em>Allocated Element path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionAllocationImpl#getTarget_path <em>Target path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionAllocationImpl extends EAElementImpl implements FunctionAllocation {

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
	 * The cached value of the '{@link #getAllocatedElement_path() <em>Allocated Element path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedElement_path()
	 * @generated
	 * @ordered
	 */
	protected EList<AllocateableElement> allocatedElement_path;

	/**
	 * The cached value of the '{@link #getTarget_path() <em>Target path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget_path()
	 * @generated
	 * @ordered
	 */
	protected EList<AllocationTarget> target_path;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionAllocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public AllocateableElement basicGetAllocatedElement() {
		AllocateableElement result = null;

		if(getBase_Dependency() != null) {
			Element elt = getBase_Dependency().getSources().get(0);

			if(elt != null)
				result = (AllocateableElement)UMLUtil.getStereotypeApplication(elt, AllocateableElement.class);
		}
		return result;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionmodelingPackage.FUNCTION_ALLOCATION__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.FUNCTION_ALLOCATION__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AllocateableElement> getAllocatedElement_path() {
		if (allocatedElement_path == null) {
			allocatedElement_path = new EObjectResolvingEList<AllocateableElement>(AllocateableElement.class, this, FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH);
		}
		return allocatedElement_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AllocationTarget> getTarget_path() {
		if (target_path == null) {
			target_path = new EObjectResolvingEList<AllocationTarget>(AllocationTarget.class, this, FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET_PATH);
		}
		return target_path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public AllocationTarget basicGetTarget() {
		AllocationTarget result = null;

		if(getBase_Dependency() != null) {
			Element elt = getBase_Dependency().getTargets().get(0);

			if(elt != null)
				result = (AllocationTarget)UMLUtil.getStereotypeApplication(elt, AllocationTarget.class);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT:
				if (resolve) return getAllocatedElement();
				return basicGetAllocatedElement();
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH:
				return getAllocatedElement_path();
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET_PATH:
				return getTarget_path();
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
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET:
				return basicGetTarget() != null;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT:
				return basicGetAllocatedElement() != null;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__BASE_DEPENDENCY:
				return base_Dependency != null;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH:
				return allocatedElement_path != null && !allocatedElement_path.isEmpty();
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET_PATH:
				return target_path != null && !target_path.isEmpty();
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
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH:
				getAllocatedElement_path().clear();
				getAllocatedElement_path().addAll((Collection<? extends AllocateableElement>)newValue);
				return;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET_PATH:
				getTarget_path().clear();
				getTarget_path().addAll((Collection<? extends AllocationTarget>)newValue);
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
		return FunctionmodelingPackage.Literals.FUNCTION_ALLOCATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__ALLOCATED_ELEMENT_PATH:
				getAllocatedElement_path().clear();
				return;
			case FunctionmodelingPackage.FUNCTION_ALLOCATION__TARGET_PATH:
				getTarget_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AllocateableElement getAllocatedElement() {
		AllocateableElement allocatedElement = basicGetAllocatedElement();
		return allocatedElement != null && allocatedElement.eIsProxy() ? (AllocateableElement)eResolveProxy((InternalEObject)allocatedElement) : allocatedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationTarget getTarget() {
		AllocationTarget target = basicGetTarget();
		return target != null && target.eIsProxy() ? (AllocationTarget)eResolveProxy((InternalEObject)target) : target;
	}

} // FunctionAllocationImpl
