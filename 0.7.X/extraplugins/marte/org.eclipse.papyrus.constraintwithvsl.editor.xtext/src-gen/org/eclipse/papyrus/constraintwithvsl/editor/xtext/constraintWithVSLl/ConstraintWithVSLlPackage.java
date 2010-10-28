/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintWithVSLlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "constraintWithVSLl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/constraintwithvsl/editor/xtext/ConstraintWithVSLl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "constraintWithVSLl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConstraintWithVSLlPackage eINSTANCE = org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintWithVSLlPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintRuleImpl <em>Constraint Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintRuleImpl
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintWithVSLlPackageImpl#getConstraintRule()
   * @generated
   */
  int CONSTRAINT_RULE = 0;

  /**
   * The feature id for the '<em><b>Specification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_RULE__SPECIFICATION = 0;

  /**
   * The number of structural features of the '<em>Constraint Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintSpecificationImpl <em>Constraint Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintSpecificationImpl
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintWithVSLlPackageImpl#getConstraintSpecification()
   * @generated
   */
  int CONSTRAINT_SPECIFICATION = 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SPECIFICATION__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Constraint Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SPECIFICATION_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintRule <em>Constraint Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Rule</em>'.
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintRule
   * @generated
   */
  EClass getConstraintRule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintRule#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specification</em>'.
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintRule#getSpecification()
   * @see #getConstraintRule()
   * @generated
   */
  EReference getConstraintRule_Specification();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification <em>Constraint Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Specification</em>'.
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification
   * @generated
   */
  EClass getConstraintSpecification();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification#getExpression()
   * @see #getConstraintSpecification()
   * @generated
   */
  EReference getConstraintSpecification_Expression();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ConstraintWithVSLlFactory getConstraintWithVSLlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintRuleImpl <em>Constraint Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintRuleImpl
     * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintWithVSLlPackageImpl#getConstraintRule()
     * @generated
     */
    EClass CONSTRAINT_RULE = eINSTANCE.getConstraintRule();

    /**
     * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_RULE__SPECIFICATION = eINSTANCE.getConstraintRule_Specification();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintSpecificationImpl <em>Constraint Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintSpecificationImpl
     * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl.ConstraintWithVSLlPackageImpl#getConstraintSpecification()
     * @generated
     */
    EClass CONSTRAINT_SPECIFICATION = eINSTANCE.getConstraintSpecification();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_SPECIFICATION__EXPRESSION = eINSTANCE.getConstraintSpecification_Expression();

  }

} //ConstraintWithVSLlPackage
