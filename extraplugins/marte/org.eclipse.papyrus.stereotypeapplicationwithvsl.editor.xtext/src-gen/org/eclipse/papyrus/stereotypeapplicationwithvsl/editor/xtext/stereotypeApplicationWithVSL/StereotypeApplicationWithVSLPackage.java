/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL;

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
 * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLFactory
 * @model kind="package"
 * @generated
 */
public interface StereotypeApplicationWithVSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "stereotypeApplicationWithVSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/stereotypeapplicationwithvsl/editor/xtext/StereotypeApplicationWithVSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "stereotypeApplicationWithVSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StereotypeApplicationWithVSLPackage eINSTANCE = org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationsRuleImpl <em>Stereotype Applications Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationsRuleImpl
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getStereotypeApplicationsRule()
   * @generated
   */
  int STEREOTYPE_APPLICATIONS_RULE = 0;

  /**
   * The feature id for the '<em><b>Stereotype Applications</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS = 0;

  /**
   * The number of structural features of the '<em>Stereotype Applications Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STEREOTYPE_APPLICATIONS_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationRuleImpl <em>Stereotype Application Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationRuleImpl
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getStereotypeApplicationRule()
   * @generated
   */
  int STEREOTYPE_APPLICATION_RULE = 1;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STEREOTYPE_APPLICATION_RULE__STEREOTYPE = 0;

  /**
   * The feature id for the '<em><b>Tag Specification</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION = 1;

  /**
   * The number of structural features of the '<em>Stereotype Application Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STEREOTYPE_APPLICATION_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.TagSpecificationRuleImpl <em>Tag Specification Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.TagSpecificationRuleImpl
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getTagSpecificationRule()
   * @generated
   */
  int TAG_SPECIFICATION_RULE = 2;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_SPECIFICATION_RULE__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_SPECIFICATION_RULE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Tag Specification Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_SPECIFICATION_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.ExpressionValueRuleImpl <em>Expression Value Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.ExpressionValueRuleImpl
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getExpressionValueRule()
   * @generated
   */
  int EXPRESSION_VALUE_RULE = 3;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_VALUE_RULE__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Expression Value Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_VALUE_RULE_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule <em>Stereotype Applications Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stereotype Applications Rule</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule
   * @generated
   */
  EClass getStereotypeApplicationsRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule#getStereotypeApplications <em>Stereotype Applications</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stereotype Applications</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule#getStereotypeApplications()
   * @see #getStereotypeApplicationsRule()
   * @generated
   */
  EReference getStereotypeApplicationsRule_StereotypeApplications();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule <em>Stereotype Application Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stereotype Application Rule</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule
   * @generated
   */
  EClass getStereotypeApplicationRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Stereotype</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getStereotype()
   * @see #getStereotypeApplicationRule()
   * @generated
   */
  EReference getStereotypeApplicationRule_Stereotype();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getTagSpecification <em>Tag Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tag Specification</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule#getTagSpecification()
   * @see #getStereotypeApplicationRule()
   * @generated
   */
  EReference getStereotypeApplicationRule_TagSpecification();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule <em>Tag Specification Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tag Specification Rule</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule
   * @generated
   */
  EClass getTagSpecificationRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getProperty()
   * @see #getTagSpecificationRule()
   * @generated
   */
  EReference getTagSpecificationRule_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule#getValue()
   * @see #getTagSpecificationRule()
   * @generated
   */
  EReference getTagSpecificationRule_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule <em>Expression Value Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Value Rule</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule
   * @generated
   */
  EClass getExpressionValueRule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule#getExpression()
   * @see #getExpressionValueRule()
   * @generated
   */
  EReference getExpressionValueRule_Expression();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StereotypeApplicationWithVSLFactory getStereotypeApplicationWithVSLFactory();

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
     * The meta object literal for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationsRuleImpl <em>Stereotype Applications Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationsRuleImpl
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getStereotypeApplicationsRule()
     * @generated
     */
    EClass STEREOTYPE_APPLICATIONS_RULE = eINSTANCE.getStereotypeApplicationsRule();

    /**
     * The meta object literal for the '<em><b>Stereotype Applications</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS = eINSTANCE.getStereotypeApplicationsRule_StereotypeApplications();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationRuleImpl <em>Stereotype Application Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationRuleImpl
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getStereotypeApplicationRule()
     * @generated
     */
    EClass STEREOTYPE_APPLICATION_RULE = eINSTANCE.getStereotypeApplicationRule();

    /**
     * The meta object literal for the '<em><b>Stereotype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STEREOTYPE_APPLICATION_RULE__STEREOTYPE = eINSTANCE.getStereotypeApplicationRule_Stereotype();

    /**
     * The meta object literal for the '<em><b>Tag Specification</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION = eINSTANCE.getStereotypeApplicationRule_TagSpecification();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.TagSpecificationRuleImpl <em>Tag Specification Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.TagSpecificationRuleImpl
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getTagSpecificationRule()
     * @generated
     */
    EClass TAG_SPECIFICATION_RULE = eINSTANCE.getTagSpecificationRule();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_SPECIFICATION_RULE__PROPERTY = eINSTANCE.getTagSpecificationRule_Property();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_SPECIFICATION_RULE__VALUE = eINSTANCE.getTagSpecificationRule_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.ExpressionValueRuleImpl <em>Expression Value Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.ExpressionValueRuleImpl
     * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl.StereotypeApplicationWithVSLPackageImpl#getExpressionValueRule()
     * @generated
     */
    EClass EXPRESSION_VALUE_RULE = eINSTANCE.getExpressionValueRule();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_VALUE_RULE__EXPRESSION = eINSTANCE.getExpressionValueRule_Expression();

  }

} //StereotypeApplicationWithVSLPackage
