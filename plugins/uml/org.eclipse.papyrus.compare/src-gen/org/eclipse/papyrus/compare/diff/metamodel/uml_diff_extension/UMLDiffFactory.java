/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage
 * @generated
 */
public interface UMLDiffFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMLDiffFactory eINSTANCE = org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Tagged Value Change Left Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Value Change Left Target</em>'.
	 * @generated
	 */
	TaggedValueChangeLeftTarget createTaggedValueChangeLeftTarget();

	/**
	 * Returns a new object of class '<em>Tagged Value Change Right Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Value Change Right Target</em>'.
	 * @generated
	 */
	TaggedValueChangeRightTarget createTaggedValueChangeRightTarget();

	/**
	 * Returns a new object of class '<em>Update Tagged Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Tagged Value</em>'.
	 * @generated
	 */
	UpdateTaggedValue createUpdateTaggedValue();

	/**
	 * Returns a new object of class '<em>Add Stereotype Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Stereotype Application</em>'.
	 * @generated
	 */
	AddStereotypeApplication createAddStereotypeApplication();

	/**
	 * Returns a new object of class '<em>Remove Stereotype Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Stereotype Application</em>'.
	 * @generated
	 */
	RemoveStereotypeApplication createRemoveStereotypeApplication();

	/**
	 * Returns a new object of class '<em>Tagged Value Reference Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Value Reference Change</em>'.
	 * @generated
	 */
	TaggedValueReferenceChange createTaggedValueReferenceChange();

	/**
	 * Returns a new object of class '<em>Compare Two Elements Diff Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Two Elements Diff Model</em>'.
	 * @generated
	 */
	CompareTwoElementsDiffModel createCompareTwoElementsDiffModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UMLDiffPackage getUMLDiffPackage();

} //UMLDiffFactory
