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
 *  
 */
package org.eclipse.papyrus.emf.facet.efacet.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.papyrus.emf.facet.efacet.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetPackage
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
// generated code
@SuppressWarnings("all")
public class EFacetAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected static EFacetPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EFacetAdapterFactory() {
		if (EFacetAdapterFactory.modelPackage == null) {
			EFacetAdapterFactory.modelPackage = EFacetPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public boolean isFactoryForType(final Object object) {
		if (object == EFacetAdapterFactory.modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == EFacetAdapterFactory.modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected EFacetSwitch<Adapter> modelSwitch =
			new EFacetSwitch<Adapter>() {
		@Override
		public Adapter caseFacetAttribute(final FacetAttribute object) {
			return createFacetAttributeAdapter();
		}
		@Override
		public Adapter caseFacetReference(final FacetReference object) {
			return createFacetReferenceAdapter();
		}
		@Override
		public Adapter caseFacetOperation(final FacetOperation object) {
			return createFacetOperationAdapter();
		}
		@Override
		public Adapter caseFacetSet(final FacetSet object) {
			return createFacetSetAdapter();
		}
		@Override
		public Adapter caseFacet(final Facet object) {
			return createFacetAdapter();
		}
		@Override
		public Adapter caseQuery(final Query object) {
			return createQueryAdapter();
		}
		@Override
		public Adapter caseQueryResult(final QueryResult object) {
			return createQueryResultAdapter();
		}
		@Override
		public Adapter caseCategory(final Category object) {
			return createCategoryAdapter();
		}
		@Override
		public Adapter caseFacetElement(final FacetElement object) {
			return createFacetElementAdapter();
		}
		@Override
		public Adapter caseQueryFacetElement(final QueryFacetElement object) {
			return createQueryFacetElementAdapter();
		}
		@Override
		public Adapter caseOppositeReference(final OppositeReference object) {
			return createOppositeReferenceAdapter();
		}
		@Override
		public Adapter caseQuerySet(final QuerySet object) {
			return createQuerySetAdapter();
		}
		@Override
		public Adapter caseLiteral(final Literal object) {
			return createLiteralAdapter();
		}
		@Override
		public Adapter caseTypedElementRef(final TypedElementRef object) {
			return createTypedElementRefAdapter();
		}
		@Override
		public Adapter caseParameter(final Parameter object) {
			return createParameterAdapter();
		}
		@Override
		public Adapter caseParameterValue(final ParameterValue object) {
			return createParameterValueAdapter();
		}
		@Override
		public Adapter caseQueryContext(final QueryContext object) {
			return createQueryContextAdapter();
		}
		@Override
		public Adapter caseEModelElement(final EModelElement object) {
			return createEModelElementAdapter();
		}
		@Override
		public Adapter caseENamedElement(final ENamedElement object) {
			return createENamedElementAdapter();
		}
		@Override
		public Adapter caseETypedElement(final ETypedElement object) {
			return createETypedElementAdapter();
		}
		@Override
		public Adapter caseEStructuralFeature(final EStructuralFeature object) {
			return createEStructuralFeatureAdapter();
		}
		@Override
		public Adapter caseEAttribute(final EAttribute object) {
			return createEAttributeAdapter();
		}
		@Override
		public Adapter caseEReference(final EReference object) {
			return createEReferenceAdapter();
		}
		@Override
		public Adapter caseEOperation(final EOperation object) {
			return createEOperationAdapter();
		}
		@Override
		public Adapter caseEPackage(final EPackage object) {
			return createEPackageAdapter();
		}
		@Override
		public Adapter caseEClassifier(final EClassifier object) {
			return createEClassifierAdapter();
		}
		@Override
		public Adapter defaultCase(final EObject object) {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public Adapter createAdapter(final Notifier target) {
		return this.modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetAttribute <em>Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetAttribute
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createFacetAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetReference <em>Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetReference
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createFacetReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetOperation <em>Facet Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetOperation
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createFacetOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetSet
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createFacetSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.Facet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Facet
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createFacetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Query
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult <em>Query Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createQueryResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Category
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetElement <em>Facet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetElement
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createFacetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement <em>Query Facet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createQueryFacetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.OppositeReference <em>Opposite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.OppositeReference
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createOppositeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.QuerySet <em>Query Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QuerySet
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createQuerySetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Literal
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.TypedElementRef <em>Typed Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.TypedElementRef
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createTypedElementRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Parameter
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.ParameterValue
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createParameterValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.QueryContext <em>Query Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryContext
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createQueryContextAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createENamedElementAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createETypedElementAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEStructuralFeatureAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEAttributeAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EOperation <em>EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EOperation
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEOperationAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEPackageAdapter() {
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EFacetAdapterFactory
