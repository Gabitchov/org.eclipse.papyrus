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
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocated</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl#getAllocatedTo <em>Allocated To</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl#getAllocatedFrom <em>Allocated From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocatedImpl extends EObjectImpl implements Allocated {
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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final AllocationEndKind KIND_EDEFAULT = AllocationEndKind.UNDEF;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected AllocationEndKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocatedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocPackage.Literals.ALLOCATED;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocPackage.ALLOCATED__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ALLOCATED__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Allocated> getAllocatedTo() {
		// TODO: implement this method to return the 'Allocated To' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		// throw new UnsupportedOperationException();
		
		EList<Allocated> allocatedTo = new BasicEList<Allocated>();

		if(getBase_NamedElement() != null) {
			Iterator<Dependency> absIter = getBase_NamedElement().getClientDependencies().iterator();
			while(absIter.hasNext()) {
				Dependency currentDependency = absIter.next();
				Allocate currentAllocate = (Allocate) ElementUtil.
										hasStereotype(currentDependency, AllocPackage.eINSTANCE.getAllocate());
				if(currentAllocate != null) {
					EList<Element> targets = currentAllocate.getBase_Abstraction().getTargets();
					Iterator<Element> it = targets.iterator();
					while (it.hasNext()) {
						Element currentElt = it.next();
						Allocated currentAllocated = (Allocated) ElementUtil.
										hasStereotype(currentElt, AllocPackage.eINSTANCE.getAllocated());
						if(currentAllocated != null) {
							allocatedTo.add(currentAllocated);
						}
					}
				}
			}
		}

		return new BasicInternalEList<Allocated>(
				Allocated.class, 
				allocatedTo.size(), 
				allocatedTo.toArray());

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Allocated> getAllocatedFrom() {
		// TODO: implement this method to return the 'Allocated From' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		// throw new UnsupportedOperationException();
		
		EList<Allocated> allocatedFrom = new BasicEList<Allocated>();

		if(getBase_NamedElement() != null) {
			Iterator<DirectedRelationship> absIter = getBase_NamedElement().getTargetDirectedRelationships().iterator();
			while(absIter.hasNext()) {
				DirectedRelationship currentDependency = absIter.next();
				Allocate currentAllocate = (Allocate) ElementUtil.
										hasStereotype(currentDependency, AllocPackage.eINSTANCE.getAllocate());
				if(currentAllocate != null) {
					EList<Element> sources = currentAllocate.getBase_Abstraction().getSources();
					Iterator<Element> it = sources.iterator();
					while (it.hasNext()) {
						Element currentElt = it.next();
						Allocated currentAllocated = (Allocated) ElementUtil.
										hasStereotype(currentElt, AllocPackage.eINSTANCE.getAllocated());
						if(currentAllocated != null) {
							allocatedFrom.add(currentAllocated);
						}
					}
				}
			}
		}

		return new BasicInternalEList<Allocated>(
				Allocated.class, 
				allocatedFrom.size(), 
				allocatedFrom.toArray());

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationEndKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(AllocationEndKind newKind) {
		AllocationEndKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ALLOCATED__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocPackage.ALLOCATED__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
			case AllocPackage.ALLOCATED__ALLOCATED_TO:
				return getAllocatedTo();
			case AllocPackage.ALLOCATED__ALLOCATED_FROM:
				return getAllocatedFrom();
			case AllocPackage.ALLOCATED__KIND:
				return getKind();
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
			case AllocPackage.ALLOCATED__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
				return;
			case AllocPackage.ALLOCATED__ALLOCATED_TO:
				getAllocatedTo().clear();
				getAllocatedTo().addAll((Collection<? extends Allocated>)newValue);
				return;
			case AllocPackage.ALLOCATED__ALLOCATED_FROM:
				getAllocatedFrom().clear();
				getAllocatedFrom().addAll((Collection<? extends Allocated>)newValue);
				return;
			case AllocPackage.ALLOCATED__KIND:
				setKind((AllocationEndKind)newValue);
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
			case AllocPackage.ALLOCATED__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
				return;
			case AllocPackage.ALLOCATED__ALLOCATED_TO:
				getAllocatedTo().clear();
				return;
			case AllocPackage.ALLOCATED__ALLOCATED_FROM:
				getAllocatedFrom().clear();
				return;
			case AllocPackage.ALLOCATED__KIND:
				setKind(KIND_EDEFAULT);
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
			case AllocPackage.ALLOCATED__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
			case AllocPackage.ALLOCATED__ALLOCATED_TO:
				return !getAllocatedTo().isEmpty();
			case AllocPackage.ALLOCATED__ALLOCATED_FROM:
				return !getAllocatedFrom().isEmpty();
			case AllocPackage.ALLOCATED__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //AllocatedImpl
