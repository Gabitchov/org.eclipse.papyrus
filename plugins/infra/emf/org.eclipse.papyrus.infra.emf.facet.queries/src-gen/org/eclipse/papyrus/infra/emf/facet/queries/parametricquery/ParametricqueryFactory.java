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
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage
 * @generated
 */
public interface ParametricqueryFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ParametricqueryFactory eINSTANCE = org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Parametric Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Parametric Query</em>'.
	 * @generated
	 */
	ParametricQuery createParametricQuery();

	/**
	 * Returns a new object of class '<em>String Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>String Argument</em>'.
	 * @generated
	 */
	StringArgument createStringArgument();

	/**
	 * Returns a new object of class '<em>EStructural Feature Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>EStructural Feature Argument</em>'.
	 * @generated
	 */
	EStructuralFeatureArgument createEStructuralFeatureArgument();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ParametricqueryPackage getParametricqueryPackage();

} //ParametricqueryFactory
