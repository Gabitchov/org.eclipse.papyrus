/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.requirements.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.papyrus.resource.impl.ResourceEObjectImpl;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementRelated;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.papyrus.uml.standard.Refine;
import org.eclipse.papyrus.uml.standard.StandardPackage;
import org.eclipse.papyrus.uml.standard.Trace;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Requirement Related</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.impl.RequirementRelatedImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.impl.RequirementRelatedImpl#getTracedFrom <em>Traced From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.impl.RequirementRelatedImpl#getSatisfies <em>Satisfies</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.impl.RequirementRelatedImpl#getRefines <em>Refines</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.impl.RequirementRelatedImpl#getVerifies <em>Verifies</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RequirementRelatedImpl extends ResourceEObjectImpl implements RequirementRelated {

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RequirementRelatedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT_RELATED__BASE_NAMED_ELEMENT:
			if(resolve)
				return getBase_NamedElement();
			return basicGetBase_NamedElement();
		case RequirementsPackage.REQUIREMENT_RELATED__TRACED_FROM:
			return getTracedFrom();
		case RequirementsPackage.REQUIREMENT_RELATED__SATISFIES:
			return getSatisfies();
		case RequirementsPackage.REQUIREMENT_RELATED__REFINES:
			return getRefines();
		case RequirementsPackage.REQUIREMENT_RELATED__VERIFIES:
			return getVerifies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT_RELATED__BASE_NAMED_ELEMENT:
			return base_NamedElement != null;
		case RequirementsPackage.REQUIREMENT_RELATED__TRACED_FROM:
			return !getTracedFrom().isEmpty();
		case RequirementsPackage.REQUIREMENT_RELATED__SATISFIES:
			return !getSatisfies().isEmpty();
		case RequirementsPackage.REQUIREMENT_RELATED__REFINES:
			return !getRefines().isEmpty();
		case RequirementsPackage.REQUIREMENT_RELATED__VERIFIES:
			return !getVerifies().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT_RELATED__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQUIREMENT_RELATED;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT_RELATED__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if(base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if(base_NamedElement != oldBase_NamedElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENT_RELATED__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getRefines() {
		// This should return the Requirement(s) refined by current element
		EList<Requirement> refines = new BasicEList<Requirement>();
		Refine currentRefine = null;

		if(getBase_NamedElement() != null) {
			// Find Refine link
			Iterator<Dependency> itDep = getBase_NamedElement().getClientDependencies().iterator();

			while(itDep.hasNext()) {
				Dependency currentDependency = itDep.next();
				currentRefine = (Refine)ElementUtil.hasStereotype(currentDependency, StandardPackage.eINSTANCE
						.getRefine());

				if(currentRefine != null) {
					EList<NamedElement> suppliers = currentRefine.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = (Requirement)ElementUtil.hasStereotype(it.next(),
								RequirementsPackage.eINSTANCE.getRequirement());
						if(currentRequirement != null) {
							refines.add(currentRequirement);
						}
					}
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<Requirement>(Requirement.class, refines.size(), refines.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getSatisfies() {
		// This should return the Requirement(s) satisfied by current element
		EList<Requirement> satisfies = new BasicEList<Requirement>();
		Satisfy currentSatisfy = null;

		if(getBase_NamedElement() != null) {
			// Find Satisfy link
			Iterator<Dependency> itDep = getBase_NamedElement().getClientDependencies().iterator();

			while(itDep.hasNext()) {
				Dependency currentDependency = itDep.next();
				currentSatisfy = (Satisfy)ElementUtil.hasStereotype(currentDependency, RequirementsPackage.eINSTANCE
						.getSatisfy());

				if(currentSatisfy != null) {
					EList<NamedElement> suppliers = currentSatisfy.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = (Requirement)ElementUtil.hasStereotype(it.next(),
								RequirementsPackage.eINSTANCE.getRequirement());
						if(currentRequirement != null) {
							satisfies.add(currentRequirement);
						}
					}
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<Requirement>(Requirement.class, satisfies.size(), satisfies.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getTracedFrom() {
		// This should return the Requirement clients of any Trace link targeting current
		// RequirementRelated
		EList<Requirement> tracedFrom = new BasicEList<Requirement>();
		Trace currentTrace = null;

		if(getBase_NamedElement() != null) {
			// Find Trace link
			EList<DirectedRelationship> relationships = getBase_NamedElement().getTargetDirectedRelationships();
			Iterator<DirectedRelationship> itDep = relationships.iterator();

			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentTrace = (Trace)ElementUtil.hasStereotype(currentDRelationship, StandardPackage.eINSTANCE
						.getTrace());

				if(currentTrace != null) {
					EList<NamedElement> clients = currentTrace.getBase_Abstraction().getClients();
					Iterator<NamedElement> it = clients.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = (Requirement)ElementUtil.hasStereotype(it.next(),
								RequirementsPackage.eINSTANCE.getRequirement());
						if(currentRequirement != null) {
							tracedFrom.add(currentRequirement);
						}
					}
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<Requirement>(Requirement.class, tracedFrom.size(), tracedFrom.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getVerifies() {
		// This should return the Requirement(s) verified by current element
		EList<Requirement> verifies = new BasicEList<Requirement>();
		Verify currentVerify = null;

		if(getBase_NamedElement() != null) {
			// Find Satisfy link
			Iterator<Dependency> itDep = getBase_NamedElement().getClientDependencies().iterator();

			while(itDep.hasNext()) {
				Dependency currentDependency = itDep.next();
				currentVerify = (Verify)ElementUtil.hasStereotype(currentDependency, RequirementsPackage.eINSTANCE
						.getVerify());

				if(currentVerify != null) {
					EList<NamedElement> suppliers = currentVerify.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = (Requirement)ElementUtil.hasStereotype(it.next(),
								RequirementsPackage.eINSTANCE.getRequirement());
						if(currentRequirement != null) {
							verifies.add(currentRequirement);
						}
					}
				}
			}
		}
		// Convert to InternalEList<?>
		return new BasicInternalEList<Requirement>(Requirement.class, verifies.size(), verifies.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT_RELATED__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

} // RequirementRelatedImpl
