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
package org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogFactory;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogPackage;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.FacetSetCatalog;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class EfacetcatalogFactoryImpl extends EFactoryImpl implements EfacetcatalogFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EfacetcatalogFactory init() {
		try {
			EfacetcatalogFactory theEfacetcatalogFactory = (EfacetcatalogFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/emf/facet/eFacetCatalog/0.1.incubation"); //$NON-NLS-1$ 
			if (theEfacetcatalogFactory != null) {
				return theEfacetcatalogFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EfacetcatalogFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EfacetcatalogFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EfacetcatalogPackage.QUERY_SET_CATALOG: return createQuerySetCatalog();
			case EfacetcatalogPackage.FACET_SET_CATALOG: return createFacetSetCatalog();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuerySetCatalog createQuerySetCatalog() {
		QuerySetCatalogImpl querySetCatalog = new QuerySetCatalogImpl();
		return querySetCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetSetCatalog createFacetSetCatalog() {
		FacetSetCatalogImpl facetSetCatalog = new FacetSetCatalogImpl();
		return facetSetCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EfacetcatalogPackage getEfacetcatalogPackage() {
		return (EfacetcatalogPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EfacetcatalogPackage getPackage() {
		return EfacetcatalogPackage.eINSTANCE;
	}

} //EfacetcatalogFactoryImpl
