/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Frederic MADIOT (Mia-Software) - meta-model design
 *     Gregoire DUPE (Mia-Software) - design and implementation
 * 
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.facet.infra.facet.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FacetFactoryImpl extends EFactoryImpl implements FacetFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FacetFactory init() {
		try {
			FacetFactory theFacetFactory = (FacetFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/EmfFacet/infra/facet/0.8.incubation"); 
			if (theFacetFactory != null) {
				return theFacetFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FacetFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FacetPackage.FACET: return createFacet();
			case FacetPackage.FACET_ATTRIBUTE: return createFacetAttribute();
			case FacetPackage.FACET_REFERENCE: return createFacetReference();
			case FacetPackage.FACET_SET: return createFacetSet();
			case FacetPackage.SHORTCUT: return createShortcut();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facet createFacet() {
		FacetImpl facet = new FacetImpl();
		return facet;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FacetAttribute createFacetAttribute() {
		FacetAttribute facetAttribute = new FacetAttributeImpl();
		facetAttribute.setVolatile(true);
		facetAttribute.setUnsettable(true);
		return facetAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FacetReference createFacetReference() {
		FacetReferenceImpl facetReference = new FacetReferenceImpl();
		facetReference.setVolatile(true);
		facetReference.setUnsettable(true);
		return facetReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetSet createFacetSet() {
		FacetSetImpl facetSet = new FacetSetImpl();
		return facetSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shortcut createShortcut() {
		ShortcutImpl shortcut = new ShortcutImpl();
		return shortcut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetPackage getFacetPackage() {
		return (FacetPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FacetPackage getPackage() {
		return FacetPackage.eINSTANCE;
	}

} //FacetFactoryImpl
