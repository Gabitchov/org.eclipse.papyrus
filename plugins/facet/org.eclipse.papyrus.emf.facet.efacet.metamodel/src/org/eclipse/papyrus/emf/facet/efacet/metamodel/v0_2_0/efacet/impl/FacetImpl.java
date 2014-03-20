/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl#getExtendedMetaclass <em>Extended Metaclass</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl#getFacetElements <em>Facet Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl#getFacetOperations <em>Facet Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl#getConformanceTypedElement <em>Conformance Typed Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl#getExtendedFacets <em>Extended Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetImpl extends EClassifierImpl implements Facet {
	/**
	 * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected String documentation = DOCUMENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtendedMetaclass() <em>Extended Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedMetaclass()
	 * @generated
	 * @ordered
	 */
	protected EClass extendedMetaclass;

	/**
	 * The cached value of the '{@link #getFacetElements() <em>Facet Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> facetElements;

	/**
	 * The cached value of the '{@link #getFacetOperations() <em>Facet Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetOperation> facetOperations;

	/**
	 * The cached value of the '{@link #getConformanceTypedElement() <em>Conformance Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformanceTypedElement()
	 * @generated
	 * @ordered
	 */
	protected ETypedElement conformanceTypedElement;

	/**
	 * The cached value of the '{@link #getExtendedFacets() <em>Extended Facets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedFacets()
	 * @generated
	 * @ordered
	 */
	protected EList<Facet> extendedFacets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EFacetPackage.Literals.FACET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentation() {
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentation(String newDocumentation) {
		String oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__DOCUMENTATION, oldDocumentation, documentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FacetSet basicGetFacetSet() {
		if (getEPackage() instanceof FacetSet) {
			FacetSet facetSet = (FacetSet) getEPackage();
			return facetSet;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFacetSet(final FacetSet newFacetSet) {
		newFacetSet.getEClassifiers().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedMetaclass() {
		if (extendedMetaclass != null && extendedMetaclass.eIsProxy()) {
			InternalEObject oldExtendedMetaclass = (InternalEObject)extendedMetaclass;
			extendedMetaclass = (EClass)eResolveProxy(oldExtendedMetaclass);
			if (extendedMetaclass != oldExtendedMetaclass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET__EXTENDED_METACLASS, oldExtendedMetaclass, extendedMetaclass));
			}
		}
		return extendedMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass basicGetExtendedMetaclass() {
		if (this.extendedMetaclass != null && this.extendedMetaclass.eIsProxy()) {
			InternalEObject oldExtendedMetaclass = (InternalEObject)this.extendedMetaclass;
			this.extendedMetaclass = (EClass)eResolveProxy(oldExtendedMetaclass);
			if (this.extendedMetaclass != oldExtendedMetaclass) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET__EXTENDED_METACLASS, oldExtendedMetaclass, this.extendedMetaclass));
				}
			}
		}
		return this.extendedMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedMetaclass(EClass newExtendedMetaclass) {
		EClass oldExtendedMetaclass = extendedMetaclass;
		extendedMetaclass = newExtendedMetaclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__EXTENDED_METACLASS, oldExtendedMetaclass, extendedMetaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeature> getFacetElements() {
		if (facetElements == null) {
			facetElements = new EObjectContainmentEList<EStructuralFeature>(EStructuralFeature.class, this, EFacetPackage.FACET__FACET_ELEMENTS);
		}
		return facetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetOperation> getFacetOperations() {
		if (facetOperations == null) {
			facetOperations = new EObjectContainmentEList<FacetOperation>(FacetOperation.class, this, EFacetPackage.FACET__FACET_OPERATIONS);
		}
		return facetOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypedElement getConformanceTypedElement() {
		if (conformanceTypedElement != null && conformanceTypedElement.eIsProxy()) {
			InternalEObject oldConformanceTypedElement = (InternalEObject)conformanceTypedElement;
			conformanceTypedElement = (ETypedElement)eResolveProxy(oldConformanceTypedElement);
			if (conformanceTypedElement != oldConformanceTypedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT, oldConformanceTypedElement, conformanceTypedElement));
			}
		}
		return conformanceTypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypedElement basicGetConformanceTypedElement() {
		return conformanceTypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConformanceTypedElement(ETypedElement newConformanceTypedElement) {
		ETypedElement oldConformanceTypedElement = conformanceTypedElement;
		conformanceTypedElement = newConformanceTypedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT, oldConformanceTypedElement, conformanceTypedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Facet> getExtendedFacets() {
		if (extendedFacets == null) {
			extendedFacets = new EObjectResolvingEList<Facet>(Facet.class, this, EFacetPackage.FACET__EXTENDED_FACETS);
		}
		return extendedFacets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EFacetPackage.FACET__FACET_ELEMENTS:
				return ((InternalEList<?>)getFacetElements()).basicRemove(otherEnd, msgs);
			case EFacetPackage.FACET__FACET_OPERATIONS:
				return ((InternalEList<?>)getFacetOperations()).basicRemove(otherEnd, msgs);
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
			case EFacetPackage.FACET__DOCUMENTATION:
				return getDocumentation();
			case EFacetPackage.FACET__EXTENDED_METACLASS:
				if (resolve) return getExtendedMetaclass();
				return basicGetExtendedMetaclass();
			case EFacetPackage.FACET__FACET_ELEMENTS:
				return getFacetElements();
			case EFacetPackage.FACET__FACET_OPERATIONS:
				return getFacetOperations();
			case EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT:
				if (resolve) return getConformanceTypedElement();
				return basicGetConformanceTypedElement();
			case EFacetPackage.FACET__EXTENDED_FACETS:
				return getExtendedFacets();
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
			case EFacetPackage.FACET__DOCUMENTATION:
				setDocumentation((String)newValue);
				return;
			case EFacetPackage.FACET__EXTENDED_METACLASS:
				setExtendedMetaclass((EClass)newValue);
				return;
			case EFacetPackage.FACET__FACET_ELEMENTS:
				getFacetElements().clear();
				getFacetElements().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case EFacetPackage.FACET__FACET_OPERATIONS:
				getFacetOperations().clear();
				getFacetOperations().addAll((Collection<? extends FacetOperation>)newValue);
				return;
			case EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT:
				setConformanceTypedElement((ETypedElement)newValue);
				return;
			case EFacetPackage.FACET__EXTENDED_FACETS:
				getExtendedFacets().clear();
				getExtendedFacets().addAll((Collection<? extends Facet>)newValue);
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
			case EFacetPackage.FACET__DOCUMENTATION:
				setDocumentation(DOCUMENTATION_EDEFAULT);
				return;
			case EFacetPackage.FACET__EXTENDED_METACLASS:
				setExtendedMetaclass((EClass)null);
				return;
			case EFacetPackage.FACET__FACET_ELEMENTS:
				getFacetElements().clear();
				return;
			case EFacetPackage.FACET__FACET_OPERATIONS:
				getFacetOperations().clear();
				return;
			case EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT:
				setConformanceTypedElement((ETypedElement)null);
				return;
			case EFacetPackage.FACET__EXTENDED_FACETS:
				getExtendedFacets().clear();
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
			case EFacetPackage.FACET__DOCUMENTATION:
				return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
			case EFacetPackage.FACET__EXTENDED_METACLASS:
				return extendedMetaclass != null;
			case EFacetPackage.FACET__FACET_ELEMENTS:
				return facetElements != null && !facetElements.isEmpty();
			case EFacetPackage.FACET__FACET_OPERATIONS:
				return facetOperations != null && !facetOperations.isEmpty();
			case EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT:
				return conformanceTypedElement != null;
			case EFacetPackage.FACET__EXTENDED_FACETS:
				return extendedFacets != null && !extendedFacets.isEmpty();
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
		if (baseClass == DocumentedElement.class) {
			switch (derivedFeatureID) {
				case EFacetPackage.FACET__DOCUMENTATION: return EFacetPackage.DOCUMENTED_ELEMENT__DOCUMENTATION;
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
		if (baseClass == DocumentedElement.class) {
			switch (baseFeatureID) {
				case EFacetPackage.DOCUMENTED_ELEMENT__DOCUMENTATION: return EFacetPackage.FACET__DOCUMENTATION;
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
		result.append(" (documentation: "); //$NON-NLS-1$
		result.append(documentation);
		result.append(')');
		return result.toString();
	}

} //FacetImpl
