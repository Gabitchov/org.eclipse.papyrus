/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlPackage
 * @generated
 */
public interface ConstraintWithVSLlFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConstraintWithVSLlFactory eINSTANCE = org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintWithVSLlFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Constraint Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Rule</em>'.
   * @generated
   */
  ConstraintRule createConstraintRule();

  /**
   * Returns a new object of class '<em>Constraint Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Specification</em>'.
   * @generated
   */
  ConstraintSpecification createConstraintSpecification();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ConstraintWithVSLlPackage getConstraintWithVSLlPackage();

} //ConstraintWithVSLlFactory
