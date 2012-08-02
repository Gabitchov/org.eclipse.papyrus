/**
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.compare.diff.uml_diff_extension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionPackage
 * @generated
 */
public interface Uml_diff_extensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Uml_diff_extensionFactory eINSTANCE = org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generalization Target Changed Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generalization Target Changed Extension</em>'.
	 * @generated
	 */
	GeneralizationTargetChangedExtension createGeneralizationTargetChangedExtension();

	/**
	 * Returns a new object of class '<em>Generalization Source Changed Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generalization Source Changed Extension</em>'.
	 * @generated
	 */
	GeneralizationSourceChangedExtension createGeneralizationSourceChangedExtension();

	/**
	 * Returns a new object of class '<em>UML Diff Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Diff Extension</em>'.
	 * @generated
	 */
	UMLDiffExtension createUMLDiffExtension();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Uml_diff_extensionPackage getUml_diff_extensionPackage();

} //Uml_diff_extensionFactory
