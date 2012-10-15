/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage
 * @generated
 */
public class UmlEFacetAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmlEFacetPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlEFacetAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlEFacetPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UmlEFacetSwitch<Adapter> modelSwitch =
		new UmlEFacetSwitch<Adapter>() {
			@Override
			public Adapter caseProfileFacetSet(ProfileFacetSet object) {
				return createProfileFacetSetAdapter();
			}
			@Override
			public Adapter caseStereotypeFacet(StereotypeFacet object) {
				return createStereotypeFacetAdapter();
			}
			@Override
			public Adapter caseStereotypePropertyElement(StereotypePropertyElement object) {
				return createStereotypePropertyElementAdapter();
			}
			@Override
			public Adapter caseStereotypePropertyFacetReference(StereotypePropertyFacetReference object) {
				return createStereotypePropertyFacetReferenceAdapter();
			}
			@Override
			public Adapter caseStereotypePropertyFacetAttribute(StereotypePropertyFacetAttribute object) {
				return createStereotypePropertyFacetAttributeAdapter();
			}
			@Override
			public Adapter caseEModelElement(EModelElement object) {
				return createEModelElementAdapter();
			}
			@Override
			public Adapter caseENamedElement(ENamedElement object) {
				return createENamedElementAdapter();
			}
			@Override
			public Adapter caseEPackage(EPackage object) {
				return createEPackageAdapter();
			}
			@Override
			public Adapter caseDocumentedElement(DocumentedElement object) {
				return createDocumentedElementAdapter();
			}
			@Override
			public Adapter caseFacetSet(FacetSet object) {
				return createFacetSetAdapter();
			}
			@Override
			public Adapter caseEClassifier(EClassifier object) {
				return createEClassifierAdapter();
			}
			@Override
			public Adapter caseFacet(Facet object) {
				return createFacetAdapter();
			}
			@Override
			public Adapter caseETypedElement(ETypedElement object) {
				return createETypedElementAdapter();
			}
			@Override
			public Adapter caseFacetElement(FacetElement object) {
				return createFacetElementAdapter();
			}
			@Override
			public Adapter caseEStructuralFeature(EStructuralFeature object) {
				return createEStructuralFeatureAdapter();
			}
			@Override
			public Adapter caseEReference(EReference object) {
				return createEReferenceAdapter();
			}
			@Override
			public Adapter caseDerivedTypedElement(DerivedTypedElement object) {
				return createDerivedTypedElementAdapter();
			}
			@Override
			public Adapter caseFacetReference(FacetReference object) {
				return createFacetReferenceAdapter();
			}
			@Override
			public Adapter caseEAttribute(EAttribute object) {
				return createEAttributeAdapter();
			}
			@Override
			public Adapter caseFacetAttribute(FacetAttribute object) {
				return createFacetAttributeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet <em>Profile Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet
	 * @generated
	 */
	public Adapter createProfileFacetSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypeFacet <em>Stereotype Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypeFacet
	 * @generated
	 */
	public Adapter createStereotypeFacetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyElement <em>Stereotype Property Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyElement
	 * @generated
	 */
	public Adapter createStereotypePropertyElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetReference <em>Stereotype Property Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetReference
	 * @generated
	 */
	public Adapter createStereotypePropertyFacetReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetAttribute <em>Stereotype Property Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetAttribute
	 * @generated
	 */
	public Adapter createStereotypePropertyFacetAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EModelElement
	 * @generated
	 */
	public Adapter createEModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.ENamedElement <em>ENamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.ENamedElement
	 * @generated
	 */
	public Adapter createENamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EPackage <em>EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EPackage
	 * @generated
	 */
	public Adapter createEPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement <em>Documented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement
	 * @generated
	 */
	public Adapter createDocumentedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet
	 * @generated
	 */
	public Adapter createFacetSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EClassifier <em>EClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EClassifier
	 * @generated
	 */
	public Adapter createEClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet
	 * @generated
	 */
	public Adapter createFacetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.ETypedElement <em>ETyped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.ETypedElement
	 * @generated
	 */
	public Adapter createETypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement <em>Facet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement
	 * @generated
	 */
	public Adapter createFacetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EStructuralFeature
	 * @generated
	 */
	public Adapter createEStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EReference <em>EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EReference
	 * @generated
	 */
	public Adapter createEReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement <em>Derived Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement
	 * @generated
	 */
	public Adapter createDerivedTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference <em>Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference
	 * @generated
	 */
	public Adapter createFacetReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EAttribute <em>EAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EAttribute
	 * @generated
	 */
	public Adapter createEAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute <em>Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute
	 * @generated
	 */
	public Adapter createFacetAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UmlEFacetAdapterFactory
