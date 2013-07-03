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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage
 * @generated
 */
public interface NattableaxisconfigurationFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	NattableaxisconfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Axis Manager Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Axis Manager Representation</em>'.
	 * @generated
	 */
	AxisManagerRepresentation createAxisManagerRepresentation();

	/**
	 * Returns a new object of class '<em>Axis Manager Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Axis Manager Configuration</em>'.
	 * @generated
	 */
	AxisManagerConfiguration createAxisManagerConfiguration();

	/**
	 * Returns a new object of class '<em>Table Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Table Header Axis Configuration</em>'.
	 * @generated
	 */
	TableHeaderAxisConfiguration createTableHeaderAxisConfiguration();

	/**
	 * Returns a new object of class '<em>Local Table Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Local Table Header Axis Configuration</em>'.
	 * @generated
	 */
	LocalTableHeaderAxisConfiguration createLocalTableHeaderAxisConfiguration();

	/**
	 * Returns a new object of class '<em>Feature Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Feature Axis Configuration</em>'.
	 * @generated
	 */
	FeatureAxisConfiguration createFeatureAxisConfiguration();

	/**
	 * Returns a new object of class '<em>EStructural Feature Value Filling Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>EStructural Feature Value Filling Configuration</em>'.
	 * @generated
	 */
	EStructuralFeatureValueFillingConfiguration createEStructuralFeatureValueFillingConfiguration();

	/**
	 * Returns a new object of class '<em>IPaste Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>IPaste Configuration</em>'.
	 * @generated
	 */
	IPasteConfiguration createIPasteConfiguration();

	/**
	 * Returns a new object of class '<em>Paste EObject Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Paste EObject Configuration</em>'.
	 * @generated
	 */
	PasteEObjectConfiguration createPasteEObjectConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	NattableaxisconfigurationPackage getNattableaxisconfigurationPackage();

} //NattableaxisconfigurationFactory
