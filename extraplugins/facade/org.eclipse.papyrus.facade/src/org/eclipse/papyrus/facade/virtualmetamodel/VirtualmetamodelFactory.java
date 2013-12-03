/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage
 * @generated
 */
public interface VirtualmetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VirtualmetamodelFactory eINSTANCE = org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualmetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Virtual Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Metamodel</em>'.
	 * @generated
	 */
	VirtualMetamodel createVirtualMetamodel();

	/**
	 * Returns a new object of class '<em>Virtual Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Metaclass</em>'.
	 * @generated
	 */
	VirtualMetaclass createVirtualMetaclass();

	/**
	 * Returns a new object of class '<em>Virtual Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Property</em>'.
	 * @generated
	 */
	VirtualProperty createVirtualProperty();

	/**
	 * Returns a new object of class '<em>Virtual Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Operation</em>'.
	 * @generated
	 */
	VirtualOperation createVirtualOperation();

	/**
	 * Returns a new object of class '<em>Virtual Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Parameter</em>'.
	 * @generated
	 */
	VirtualParameter createVirtualParameter();

	/**
	 * Returns a new object of class '<em>Virtual Datatype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Datatype</em>'.
	 * @generated
	 */
	VirtualDatatype createVirtualDatatype();

	/**
	 * Returns a new object of class '<em>Virtual Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Enum</em>'.
	 * @generated
	 */
	VirtualEnum createVirtualEnum();

	/**
	 * Returns a new object of class '<em>Virtual Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Literal</em>'.
	 * @generated
	 */
	VirtualLiteral createVirtualLiteral();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VirtualmetamodelPackage getVirtualmetamodelPackage();

} //VirtualmetamodelFactory
