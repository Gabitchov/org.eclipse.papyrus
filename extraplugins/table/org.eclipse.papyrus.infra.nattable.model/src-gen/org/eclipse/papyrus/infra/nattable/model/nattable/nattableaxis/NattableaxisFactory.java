/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage
 * @generated
 */
public interface NattableaxisFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattableaxisFactory eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.NattableaxisFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EObject Axis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Axis</em>'.
	 * @generated
	 */
	EObjectAxis createEObjectAxis();

	/**
	 * Returns a new object of class '<em>Feature Id Axis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Id Axis</em>'.
	 * @generated
	 */
	FeatureIdAxis createFeatureIdAxis();

	/**
	 * Returns a new object of class '<em>EStructural Feature Axis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EStructural Feature Axis</em>'.
	 * @generated
	 */
	EStructuralFeatureAxis createEStructuralFeatureAxis();

	/**
	 * Returns a new object of class '<em>Object Id Axis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Id Axis</em>'.
	 * @generated
	 */
	ObjectIdAxis createObjectIdAxis();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NattableaxisPackage getNattableaxisPackage();

} //NattableaxisFactory
