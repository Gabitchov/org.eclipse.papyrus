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
package org.eclipse.papyrus.eastadl.annex.needs.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement;
import org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Comment;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Opportunity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl#getProblemStatement <em>Problem Statement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl#getProductPositioning <em>Product Positioning</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.BusinessOpportunityImpl#getBusinessOpportunity <em>Business Opportunity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessOpportunityImpl extends TraceableSpecificationImpl implements BusinessOpportunity {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getProblemStatement() <em>Problem Statement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblemStatement()
	 * @generated
	 * @ordered
	 */
	protected EList<ProblemStatement> problemStatement;

	/**
	 * The cached value of the '{@link #getProductPositioning() <em>Product Positioning</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductPositioning()
	 * @generated
	 * @ordered
	 */
	protected EList<ProductPositioning> productPositioning;

	/**
	 * The default value of the '{@link #getBusinessOpportunity() <em>Business Opportunity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessOpportunity()
	 * @generated
	 * @ordered
	 */
	protected static final String BUSINESS_OPPORTUNITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusinessOpportunity() <em>Business Opportunity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessOpportunity()
	 * @generated
	 * @ordered
	 */
	protected String businessOpportunity = BUSINESS_OPPORTUNITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessOpportunityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NeedsPackage.BUSINESS_OPPORTUNITY__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case NeedsPackage.BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT:
				return getProblemStatement();
			case NeedsPackage.BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING:
				return getProductPositioning();
			case NeedsPackage.BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY:
				return getBusinessOpportunity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NeedsPackage.BUSINESS_OPPORTUNITY__BASE_CLASS:
				return base_Class != null;
			case NeedsPackage.BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT:
				return problemStatement != null && !problemStatement.isEmpty();
			case NeedsPackage.BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING:
				return productPositioning != null && !productPositioning.isEmpty();
			case NeedsPackage.BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY:
				return BUSINESS_OPPORTUNITY_EDEFAULT == null ? businessOpportunity != null : !BUSINESS_OPPORTUNITY_EDEFAULT.equals(businessOpportunity);
		}
		return super.eIsSet(featureID);
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
			case NeedsPackage.BUSINESS_OPPORTUNITY__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case NeedsPackage.BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT:
				getProblemStatement().clear();
				getProblemStatement().addAll((Collection<? extends ProblemStatement>)newValue);
				return;
			case NeedsPackage.BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING:
				getProductPositioning().clear();
				getProductPositioning().addAll((Collection<? extends ProductPositioning>)newValue);
				return;
			case NeedsPackage.BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY:
				setBusinessOpportunity((String)newValue);
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
	protected EClass eStaticClass() {
		return NeedsPackage.Literals.BUSINESS_OPPORTUNITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NeedsPackage.BUSINESS_OPPORTUNITY__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.BUSINESS_OPPORTUNITY__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NeedsPackage.BUSINESS_OPPORTUNITY__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case NeedsPackage.BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT:
				getProblemStatement().clear();
				return;
			case NeedsPackage.BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING:
				getProductPositioning().clear();
				return;
			case NeedsPackage.BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY:
				setBusinessOpportunity(BUSINESS_OPPORTUNITY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBusinessOpportunity() {
		return businessOpportunity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProblemStatement> getProblemStatement() {
		if (problemStatement == null) {
			problemStatement = new EObjectResolvingEList<ProblemStatement>(ProblemStatement.class, this, NeedsPackage.BUSINESS_OPPORTUNITY__PROBLEM_STATEMENT);
		}
		return problemStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProductPositioning> getProductPositioning() {
		if (productPositioning == null) {
			productPositioning = new EObjectResolvingEList<ProductPositioning>(ProductPositioning.class, this, NeedsPackage.BUSINESS_OPPORTUNITY__PRODUCT_POSITIONING);
		}
		return productPositioning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusinessOpportunity(String newBusinessOpportunity) {
		String oldBusinessOpportunity = businessOpportunity;
		businessOpportunity = newBusinessOpportunity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.BUSINESS_OPPORTUNITY__BUSINESS_OPPORTUNITY, oldBusinessOpportunity, businessOpportunity));
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
		result.append(" (businessOpportunity: ");
		result.append(businessOpportunity);
		result.append(')');
		return result.toString();
	}

	@Override
	public PackageableElement getBase_PackageableElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBase_PackageableElement(PackageableElement value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Comment> getOwnedComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamedElement getBase_NamedElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBase_NamedElement(NamedElement value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}

} //BusinessOpportunityImpl
