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
 *  Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QueryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueryFactory eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Navigation Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Query</em>'.
	 * @generated
	 */
	NavigationQuery createNavigationQuery();

	/**
	 * Returns a new object of class '<em>Is One Of Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is One Of Query</em>'.
	 * @generated
	 */
	IsOneOfQuery createIsOneOfQuery();

	/**
	 * Returns a new object of class '<em>String Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Query</em>'.
	 * @generated
	 */
	StringLiteralQuery createStringLiteralQuery();

	/**
	 * Returns a new object of class '<em>True Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Literal Query</em>'.
	 * @generated
	 */
	TrueLiteralQuery createTrueLiteralQuery();

	/**
	 * Returns a new object of class '<em>False Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Literal Query</em>'.
	 * @generated
	 */
	FalseLiteralQuery createFalseLiteralQuery();

	/**
	 * Returns a new object of class '<em>Null Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal Query</em>'.
	 * @generated
	 */
	NullLiteralQuery createNullLiteralQuery();

	/**
	 * Returns a new object of class '<em>Integer Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal Query</em>'.
	 * @generated
	 * @since 0.2
	 */
	IntegerLiteralQuery createIntegerLiteralQuery();

	/**
	 * Returns a new object of class '<em>Float Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Float Literal Query</em>'.
	 * @generated
	 * @since 0.2
	 */
	FloatLiteralQuery createFloatLiteralQuery();

	/**
	 * Returns a new object of class '<em>EObject Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Literal Query</em>'.
	 * @generated
	 * @since 0.2
	 */
	EObjectLiteralQuery createEObjectLiteralQuery();

	/**
	 * Returns a new object of class '<em>Operation Call Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Call Query</em>'.
	 * @generated
	 * @since 0.2
	 */
	OperationCallQuery createOperationCallQuery();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QueryPackage getQueryPackage();

} //QueryFactory
