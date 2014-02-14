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
package org.eclipse.emf.facet.efacet.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.facet.efacet.Category;
import org.eclipse.emf.facet.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.Literal;
import org.eclipse.emf.facet.efacet.OppositeReference;
import org.eclipse.emf.facet.efacet.Parameter;
import org.eclipse.emf.facet.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.QueryContext;
import org.eclipse.emf.facet.efacet.QueryFacetElement;
import org.eclipse.emf.facet.efacet.QueryResult;
import org.eclipse.emf.facet.efacet.QuerySet;
import org.eclipse.emf.facet.efacet.TypedElementRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class EFacetPackageImpl extends EPackageImpl implements EFacetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass facetAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass facetReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass facetOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass facetSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass facetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass queryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass queryResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass facetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass queryFacetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass oppositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass querySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass typedElementRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass parameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EClass queryContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EDataType javaExceptionEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.facet.efacet.EFacetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private EFacetPackageImpl() {
		super(EFacetPackage.eNS_URI, EFacetFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EFacetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public static EFacetPackage init() {
		if (EFacetPackageImpl.isInited) {
			return (EFacetPackage)EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI);
		}

		// Obtain or create and register package
		EFacetPackageImpl theEFacetPackage = (EFacetPackageImpl)(EPackage.Registry.INSTANCE.get(EFacetPackage.eNS_URI) instanceof EFacetPackageImpl ? EPackage.Registry.INSTANCE.get(EFacetPackage.eNS_URI) : new EFacetPackageImpl());

		EFacetPackageImpl.isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEFacetPackage.createPackageContents();

		// Initialize created meta-data
		theEFacetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEFacetPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EFacetPackage.eNS_URI, theEFacetPackage);
		return theEFacetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getFacetAttribute() {
		return this.facetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getFacetReference() {
		return this.facetReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getFacetOperation() {
		return this.facetOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getFacetSet() {
		return this.facetSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacetSet_Facets() {
		return (EReference)this.facetSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacetSet_Categories() {
		return (EReference)this.facetSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacetSet_ExtendedEPackage() {
		return (EReference)this.facetSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getFacet() {
		return this.facetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacet_FacetSet() {
		return (EReference)this.facetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacet_ConformanceQuery() {
		return (EReference)this.facetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacet_ExtendedMetaclass() {
		return (EReference)this.facetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacet_FacetElements() {
		return (EReference)this.facetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getQuery() {
		return this.queryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQuery_Scope() {
		return (EReference)this.queryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getQuery_HasSideEffect() {
		return (EAttribute)this.queryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getQuery_CanBeCached() {
		return (EAttribute)this.queryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQuery_Parameters() {
		return (EReference)this.queryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getQueryResult() {
		return this.queryResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQueryResult_Query() {
		return (EReference)this.queryResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQueryResult_Scope() {
		return (EReference)this.queryResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQueryResult_ParameterValues() {
		return (EReference)this.queryResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getQueryResult_Result() {
		return (EAttribute)this.queryResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getQueryResult_Exception() {
		return (EAttribute)this.queryResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQueryResult_Source() {
		return (EReference)this.queryResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getCategory() {
		return this.categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getFacetElement() {
		return this.facetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacetElement_Categories() {
		return (EReference)this.facetElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacetElement_Facet() {
		return (EReference)this.facetElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFacetElement_Override() {
		return (EReference)this.facetElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getQueryFacetElement() {
		return this.queryFacetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQueryFacetElement_Query() {
		return (EReference)this.queryFacetElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getOppositeReference() {
		return this.oppositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getOppositeReference_FOpposite() {
		return (EReference)this.oppositeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getQuerySet() {
		return this.querySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQuerySet_Queries() {
		return (EReference)this.querySetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getQuerySet_Name() {
		return (EAttribute)this.querySetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getLiteral() {
		return this.literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getLiteral_Value() {
		return (EAttribute)this.literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getTypedElementRef() {
		return this.typedElementRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getTypedElementRef_TypedElement() {
		return (EReference)this.typedElementRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getParameter() {
		return this.parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getParameterValue() {
		return this.parameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getParameterValue_Parameter() {
		return (EReference)this.parameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getParameterValue_Value() {
		return (EAttribute)this.parameterValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getQueryContext() {
		return this.queryContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getQueryContext_SelectedModelElements() {
		return (EReference)this.queryContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EAttribute getQueryContext_SelectedModels() {
		return (EAttribute)this.queryContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EDataType getJavaException() {
		return this.javaExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EFacetFactory getEFacetFactory() {
		return (EFacetFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void createPackageContents() {
		if (this.isCreated) {
			return;
		}
		this.isCreated = true;

		// Create classes and their features
		this.facetAttributeEClass = createEClass(EFacetPackage.FACET_ATTRIBUTE);

		this.facetReferenceEClass = createEClass(EFacetPackage.FACET_REFERENCE);

		this.facetOperationEClass = createEClass(EFacetPackage.FACET_OPERATION);

		this.facetSetEClass = createEClass(EFacetPackage.FACET_SET);
		createEReference(this.facetSetEClass, EFacetPackage.FACET_SET__FACETS);
		createEReference(this.facetSetEClass, EFacetPackage.FACET_SET__CATEGORIES);
		createEReference(this.facetSetEClass, EFacetPackage.FACET_SET__EXTENDED_EPACKAGE);

		this.facetEClass = createEClass(EFacetPackage.FACET);
		createEReference(this.facetEClass, EFacetPackage.FACET__FACET_SET);
		createEReference(this.facetEClass, EFacetPackage.FACET__CONFORMANCE_QUERY);
		createEReference(this.facetEClass, EFacetPackage.FACET__EXTENDED_METACLASS);
		createEReference(this.facetEClass, EFacetPackage.FACET__FACET_ELEMENTS);

		this.queryEClass = createEClass(EFacetPackage.QUERY);
		createEReference(this.queryEClass, EFacetPackage.QUERY__SCOPE);
		createEAttribute(this.queryEClass, EFacetPackage.QUERY__HAS_SIDE_EFFECT);
		createEAttribute(this.queryEClass, EFacetPackage.QUERY__CAN_BE_CACHED);
		createEReference(this.queryEClass, EFacetPackage.QUERY__PARAMETERS);

		this.queryResultEClass = createEClass(EFacetPackage.QUERY_RESULT);
		createEReference(this.queryResultEClass, EFacetPackage.QUERY_RESULT__QUERY);
		createEReference(this.queryResultEClass, EFacetPackage.QUERY_RESULT__SCOPE);
		createEReference(this.queryResultEClass, EFacetPackage.QUERY_RESULT__PARAMETER_VALUES);
		createEAttribute(this.queryResultEClass, EFacetPackage.QUERY_RESULT__RESULT);
		createEAttribute(this.queryResultEClass, EFacetPackage.QUERY_RESULT__EXCEPTION);
		createEReference(this.queryResultEClass, EFacetPackage.QUERY_RESULT__SOURCE);

		this.categoryEClass = createEClass(EFacetPackage.CATEGORY);

		this.facetElementEClass = createEClass(EFacetPackage.FACET_ELEMENT);
		createEReference(this.facetElementEClass, EFacetPackage.FACET_ELEMENT__CATEGORIES);
		createEReference(this.facetElementEClass, EFacetPackage.FACET_ELEMENT__FACET);
		createEReference(this.facetElementEClass, EFacetPackage.FACET_ELEMENT__OVERRIDE);

		this.queryFacetElementEClass = createEClass(EFacetPackage.QUERY_FACET_ELEMENT);
		createEReference(this.queryFacetElementEClass, EFacetPackage.QUERY_FACET_ELEMENT__QUERY);

		this.oppositeReferenceEClass = createEClass(EFacetPackage.OPPOSITE_REFERENCE);
		createEReference(this.oppositeReferenceEClass, EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE);

		this.querySetEClass = createEClass(EFacetPackage.QUERY_SET);
		createEReference(this.querySetEClass, EFacetPackage.QUERY_SET__QUERIES);
		createEAttribute(this.querySetEClass, EFacetPackage.QUERY_SET__NAME);

		this.literalEClass = createEClass(EFacetPackage.LITERAL);
		createEAttribute(this.literalEClass, EFacetPackage.LITERAL__VALUE);

		this.typedElementRefEClass = createEClass(EFacetPackage.TYPED_ELEMENT_REF);
		createEReference(this.typedElementRefEClass, EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT);

		this.parameterEClass = createEClass(EFacetPackage.PARAMETER);

		this.parameterValueEClass = createEClass(EFacetPackage.PARAMETER_VALUE);
		createEReference(this.parameterValueEClass, EFacetPackage.PARAMETER_VALUE__PARAMETER);
		createEAttribute(this.parameterValueEClass, EFacetPackage.PARAMETER_VALUE__VALUE);

		this.queryContextEClass = createEClass(EFacetPackage.QUERY_CONTEXT);
		createEReference(this.queryContextEClass, EFacetPackage.QUERY_CONTEXT__SELECTED_MODEL_ELEMENTS);
		createEAttribute(this.queryContextEClass, EFacetPackage.QUERY_CONTEXT__SELECTED_MODELS);

		// Create data types
		this.javaExceptionEDataType = createEDataType(EFacetPackage.JAVA_EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void initializePackageContents() {
		if (this.isInitialized) {
			return;
		}
		this.isInitialized = true;

		// Initialize package
		setName(EFacetPackage.eNAME);
		setNsPrefix(EFacetPackage.eNS_PREFIX);
		setNsURI(EFacetPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		this.facetAttributeEClass.getESuperTypes().add(this.ecorePackage.getEAttribute());
		this.facetAttributeEClass.getESuperTypes().add(getQueryFacetElement());
		this.facetReferenceEClass.getESuperTypes().add(this.ecorePackage.getEReference());
		this.facetReferenceEClass.getESuperTypes().add(getQueryFacetElement());
		this.facetOperationEClass.getESuperTypes().add(this.ecorePackage.getEOperation());
		this.facetOperationEClass.getESuperTypes().add(getQueryFacetElement());
		this.facetSetEClass.getESuperTypes().add(this.ecorePackage.getEPackage());
		this.facetEClass.getESuperTypes().add(this.ecorePackage.getEClassifier());
		this.queryEClass.getESuperTypes().add(this.ecorePackage.getETypedElement());
		this.facetElementEClass.getESuperTypes().add(this.ecorePackage.getETypedElement());
		this.queryFacetElementEClass.getESuperTypes().add(getFacetElement());
		this.oppositeReferenceEClass.getESuperTypes().add(getFacetElement());
		this.literalEClass.getESuperTypes().add(getQuery());
		this.typedElementRefEClass.getESuperTypes().add(getQuery());
		this.parameterEClass.getESuperTypes().add(this.ecorePackage.getETypedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(this.facetAttributeEClass, FacetAttribute.class, "FacetAttribute", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(this.facetReferenceEClass, FacetReference.class, "FacetReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(this.facetOperationEClass, FacetOperation.class, "FacetOperation", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(this.facetSetEClass, FacetSet.class, "FacetSet", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFacetSet_Facets(), getFacet(), getFacet_FacetSet(), "facets", null, 0, -1, FacetSet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacetSet_Categories(), getCategory(), null, "categories", null, 0, -1, FacetSet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacetSet_ExtendedEPackage(), this.ecorePackage.getEPackage(), null, "extendedEPackage", null, 1, 1, FacetSet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.facetEClass, Facet.class, "Facet", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFacet_FacetSet(), getFacetSet(), getFacetSet_Facets(), "facetSet", null, 0, 1, Facet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_ConformanceQuery(), getQuery(), null, "conformanceQuery", null, 0, 1, Facet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_ExtendedMetaclass(), this.ecorePackage.getEClass(), null, "extendedMetaclass", null, 0, 1, Facet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_FacetElements(), getFacetElement(), getFacetElement_Facet(), "facetElements", null, 0, -1, Facet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.queryEClass, Query.class, "Query", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQuery_Scope(), this.ecorePackage.getEClass(), null, "scope", null, 0, 1, Query.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getQuery_HasSideEffect(), this.ecorePackage.getEBoolean(), "hasSideEffect", "false", 0, 1, Query.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getQuery_CanBeCached(), this.ecorePackage.getEBoolean(), "canBeCached", "false", 0, 1, Query.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getQuery_Parameters(), getParameter(), null, "parameters", null, 0, -1, Query.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.queryResultEClass, QueryResult.class, "QueryResult", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQueryResult_Query(), getQuery(), null, "query", null, 1, 1, QueryResult.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getQueryResult_Scope(), this.ecorePackage.getEObject(), null, "scope", null, 1, 1, QueryResult.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getQueryResult_ParameterValues(), getParameterValue(), null, "parameterValues", null, 0, -1, QueryResult.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getQueryResult_Result(), this.ecorePackage.getEJavaObject(), "result", null, 0, 1, QueryResult.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getQueryResult_Exception(), getJavaException(), "exception", null, 0, 1, QueryResult.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getQueryResult_Source(), this.ecorePackage.getEObject(), null, "source", null, 0, 1, QueryResult.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.categoryEClass, Category.class, "Category", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(this.facetElementEClass, FacetElement.class, "FacetElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFacetElement_Categories(), getCategory(), null, "categories", null, 0, -1, FacetElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacetElement_Facet(), getFacet(), getFacet_FacetElements(), "facet", null, 1, 1, FacetElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacetElement_Override(), this.ecorePackage.getETypedElement(), null, "override", null, 0, 1, FacetElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.queryFacetElementEClass, QueryFacetElement.class, "QueryFacetElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQueryFacetElement_Query(), getQuery(), null, "query", null, 0, 1, QueryFacetElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.oppositeReferenceEClass, OppositeReference.class, "OppositeReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOppositeReference_FOpposite(), this.ecorePackage.getEReference(), null, "fOpposite", null, 0, 1, OppositeReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.querySetEClass, QuerySet.class, "QuerySet", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQuerySet_Queries(), getQuery(), null, "queries", null, 0, -1, QuerySet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getQuerySet_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, QuerySet.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.literalEClass, Literal.class, "Literal", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLiteral_Value(), this.ecorePackage.getEString(), "value", null, 0, 1, Literal.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.typedElementRefEClass, TypedElementRef.class, "TypedElementRef", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedElementRef_TypedElement(), this.ecorePackage.getETypedElement(), null, "typedElement", null, 1, 1, TypedElementRef.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.parameterEClass, Parameter.class, "Parameter", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(this.parameterValueEClass, ParameterValue.class, "ParameterValue", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterValue_Parameter(), getParameter(), null, "parameter", null, 1, 1, ParameterValue.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getParameterValue_Value(), this.ecorePackage.getEJavaObject(), "value", null, 0, -1, ParameterValue.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.queryContextEClass, QueryContext.class, "QueryContext", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQueryContext_SelectedModelElements(), this.ecorePackage.getEObject(), null, "selectedModelElements", null, 0, -1, QueryContext.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getQueryContext_SelectedModels(), this.ecorePackage.getEResource(), "selectedModels", null, 0, -1, QueryContext.class, EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		// Initialize data types
		initEDataType(this.javaExceptionEDataType, Exception.class, "JavaException", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(EFacetPackage.eNS_URI);

		// Create annotations
		// GenModel
		createGenModel_1Annotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected void createGenModel_1Annotations() {
		String source = "GenModel"; //$NON-NLS-1$					
		addAnnotation
		(this.facetSetEClass, 
				source, 
				new String[] {
				"documentation", "A \"FacetSet\" is the root element of a facet model. It contains a list of \"Facet\"." //$NON-NLS-1$ //$NON-NLS-2$ 
		});					
		addAnnotation
		(getFacet_ConformanceQuery(), 
				source, 
				new String[] {
			"documentation", "The \"conformanceQuery\" references points to the ModelQuery class. The model queries pointed to by the \"conformanceQuery\" reference must return a Boolean. Those queries are used to specify how to decide whether an instance conforms to a facet. If the \"conditionQuery\" is empty then all the instances of the class referred to by the facet instance through the eSuperType reference conform to this facet. " //$NON-NLS-1$ //$NON-NLS-2$ 
		});		
		addAnnotation
		(getFacet_ExtendedMetaclass(), 
				source, 
				new String[] {
			"documentation", "The \"extendedMetaclass\" reference references the virtually subtyped EClass." //$NON-NLS-1$ //$NON-NLS-2$ 
		});																				
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$						
		addAnnotation
		(this.facetEClass, 
				source, 
				new String[] {
				"validationDelegates", "( self.query.scope = self.facet.extendedMetaClass ) and ( self.query.name = self.name )" //$NON-NLS-1$ //$NON-NLS-2$
		});			
		addAnnotation
		(this.facetEClass, 
				source, 
				new String[] {
				"validationDelegates", "self.conformanceQuery.scope = self.extendedMetaClass" //$NON-NLS-1$ //$NON-NLS-2$
		});																	
		addAnnotation
		(this.querySetEClass, 
				source, 
				new String[] {
				"validationDelegates", "not(self.queries->exists(q1|self.queries->exists(q2|q2&lt;>q1 and q2.name = q1.name and q2.scope=q1.scope and q2.parameters = q1.parameters) and self.queries->forAll(q|q.scope = null)" //$NON-NLS-1$ //$NON-NLS-2$
		});						
	}

} //EFacetPackageImpl
