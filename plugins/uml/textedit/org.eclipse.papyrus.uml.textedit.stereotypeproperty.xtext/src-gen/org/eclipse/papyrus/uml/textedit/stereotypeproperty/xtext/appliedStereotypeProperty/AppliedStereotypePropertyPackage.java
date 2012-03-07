/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty;

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
 * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyFactory
 * @model kind="package"
 * @generated
 */
public interface AppliedStereotypePropertyPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "appliedStereotypeProperty";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/property/xtext/StereotypeProperty";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "appliedStereotypeProperty";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AppliedStereotypePropertyPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyRuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyPackageImpl#getAppliedStereotypePropertyRule()
   * @generated
   */
  int APPLIED_STEREOTYPE_PROPERTY_RULE = 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLIED_STEREOTYPE_PROPERTY_RULE__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLIED_STEREOTYPE_PROPERTY_RULE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLIED_STEREOTYPE_PROPERTY_RULE_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule
   * @generated
   */
  EClass getAppliedStereotypePropertyRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule#getProperty()
   * @see #getAppliedStereotypePropertyRule()
   * @generated
   */
  EReference getAppliedStereotypePropertyRule_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule#getValue()
   * @see #getAppliedStereotypePropertyRule()
   * @generated
   */
  EReference getAppliedStereotypePropertyRule_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AppliedStereotypePropertyFactory getAppliedStereotypePropertyFactory();

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
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyRuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.AppliedStereotypePropertyPackageImpl#getAppliedStereotypePropertyRule()
     * @generated
     */
    EClass APPLIED_STEREOTYPE_PROPERTY_RULE = eINSTANCE.getAppliedStereotypePropertyRule();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLIED_STEREOTYPE_PROPERTY_RULE__PROPERTY = eINSTANCE.getAppliedStereotypePropertyRule_Property();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLIED_STEREOTYPE_PROPERTY_RULE__VALUE = eINSTANCE.getAppliedStereotypePropertyRule_Value();

  }

} //AppliedStereotypePropertyPackage
