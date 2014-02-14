/**
 *  Copyright (c) 2012 Mia-Software.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 * 
 * 
 */
package org.eclipse.emf.facet.query.ocl.metamodel.oclquery;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage
 * @generated
 */
public interface OclQueryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclQueryFactory eINSTANCE = org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ocl Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Query</em>'.
	 * @generated
	 */
	OclQuery createOclQuery();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OclQueryPackage getOclQueryPackage();

} //OclQueryFactory
