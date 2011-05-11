/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage
 * @generated
 */
public interface StereotypeApplicationWithVSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StereotypeApplicationWithVSLFactory eINSTANCE = org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Stereotype Applications Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stereotype Applications Rule</em>'.
   * @generated
   */
  StereotypeApplicationsRule createStereotypeApplicationsRule();

  /**
   * Returns a new object of class '<em>Stereotype Application Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stereotype Application Rule</em>'.
   * @generated
   */
  StereotypeApplicationRule createStereotypeApplicationRule();

  /**
   * Returns a new object of class '<em>Tag Specification Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tag Specification Rule</em>'.
   * @generated
   */
  TagSpecificationRule createTagSpecificationRule();

  /**
   * Returns a new object of class '<em>Expression Value Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Value Rule</em>'.
   * @generated
   */
  ExpressionValueRule createExpressionValueRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  StereotypeApplicationWithVSLPackage getStereotypeApplicationWithVSLPackage();

} //StereotypeApplicationWithVSLFactory
