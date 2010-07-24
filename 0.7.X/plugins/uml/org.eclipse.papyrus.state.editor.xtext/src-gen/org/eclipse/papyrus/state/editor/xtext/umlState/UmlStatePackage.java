/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.state.editor.xtext.umlState;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.state.editor.xtext.umlState.UmlStateFactory
 * @model kind="package"
 * @generated
 */
public interface UmlStatePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "umlState";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/state/editor/xtext/UmlState";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "umlState";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlStatePackage eINSTANCE = org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.StateRuleImpl <em>State Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.StateRuleImpl
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getStateRule()
   * @generated
   */
  int STATE_RULE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_RULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Entry</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_RULE__ENTRY = 1;

  /**
   * The feature id for the '<em><b>Do</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_RULE__DO = 2;

  /**
   * The feature id for the '<em><b>Exit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_RULE__EXIT = 3;

  /**
   * The number of structural features of the '<em>State Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_RULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.EntryRuleImpl <em>Entry Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.EntryRuleImpl
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getEntryRule()
   * @generated
   */
  int ENTRY_RULE = 1;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_RULE__KIND = 0;

  /**
   * The feature id for the '<em><b>Behavior Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_RULE__BEHAVIOR_NAME = 1;

  /**
   * The number of structural features of the '<em>Entry Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.DoRuleImpl <em>Do Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.DoRuleImpl
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getDoRule()
   * @generated
   */
  int DO_RULE = 2;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_RULE__KIND = 0;

  /**
   * The feature id for the '<em><b>Behavior Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_RULE__BEHAVIOR_NAME = 1;

  /**
   * The number of structural features of the '<em>Do Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.ExitRuleImpl <em>Exit Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.ExitRuleImpl
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getExitRule()
   * @generated
   */
  int EXIT_RULE = 3;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_RULE__KIND = 0;

  /**
   * The feature id for the '<em><b>Behavior Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_RULE__BEHAVIOR_NAME = 1;

  /**
   * The number of structural features of the '<em>Exit Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.BehaviorKind <em>Behavior Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.BehaviorKind
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getBehaviorKind()
   * @generated
   */
  int BEHAVIOR_KIND = 4;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule <em>State Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Rule</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.StateRule
   * @generated
   */
  EClass getStateRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getName()
   * @see #getStateRule()
   * @generated
   */
  EAttribute getStateRule_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Entry</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getEntry()
   * @see #getStateRule()
   * @generated
   */
  EReference getStateRule_Entry();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Do</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getDo()
   * @see #getStateRule()
   * @generated
   */
  EReference getStateRule_Do();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getExit <em>Exit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exit</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getExit()
   * @see #getStateRule()
   * @generated
   */
  EReference getStateRule_Exit();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.state.editor.xtext.umlState.EntryRule <em>Entry Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Rule</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.EntryRule
   * @generated
   */
  EClass getEntryRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.EntryRule#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.EntryRule#getKind()
   * @see #getEntryRule()
   * @generated
   */
  EAttribute getEntryRule_Kind();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.EntryRule#getBehaviorName <em>Behavior Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Behavior Name</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.EntryRule#getBehaviorName()
   * @see #getEntryRule()
   * @generated
   */
  EAttribute getEntryRule_BehaviorName();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.state.editor.xtext.umlState.DoRule <em>Do Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Do Rule</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.DoRule
   * @generated
   */
  EClass getDoRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.DoRule#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.DoRule#getKind()
   * @see #getDoRule()
   * @generated
   */
  EAttribute getDoRule_Kind();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.DoRule#getBehaviorName <em>Behavior Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Behavior Name</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.DoRule#getBehaviorName()
   * @see #getDoRule()
   * @generated
   */
  EAttribute getDoRule_BehaviorName();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.state.editor.xtext.umlState.ExitRule <em>Exit Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Rule</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.ExitRule
   * @generated
   */
  EClass getExitRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.ExitRule#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.ExitRule#getKind()
   * @see #getExitRule()
   * @generated
   */
  EAttribute getExitRule_Kind();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.state.editor.xtext.umlState.ExitRule#getBehaviorName <em>Behavior Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Behavior Name</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.ExitRule#getBehaviorName()
   * @see #getExitRule()
   * @generated
   */
  EAttribute getExitRule_BehaviorName();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.state.editor.xtext.umlState.BehaviorKind <em>Behavior Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Behavior Kind</em>'.
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.BehaviorKind
   * @generated
   */
  EEnum getBehaviorKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UmlStateFactory getUmlStateFactory();

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
     * The meta object literal for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.StateRuleImpl <em>State Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.StateRuleImpl
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getStateRule()
     * @generated
     */
    EClass STATE_RULE = eINSTANCE.getStateRule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_RULE__NAME = eINSTANCE.getStateRule_Name();

    /**
     * The meta object literal for the '<em><b>Entry</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_RULE__ENTRY = eINSTANCE.getStateRule_Entry();

    /**
     * The meta object literal for the '<em><b>Do</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_RULE__DO = eINSTANCE.getStateRule_Do();

    /**
     * The meta object literal for the '<em><b>Exit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_RULE__EXIT = eINSTANCE.getStateRule_Exit();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.EntryRuleImpl <em>Entry Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.EntryRuleImpl
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getEntryRule()
     * @generated
     */
    EClass ENTRY_RULE = eINSTANCE.getEntryRule();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY_RULE__KIND = eINSTANCE.getEntryRule_Kind();

    /**
     * The meta object literal for the '<em><b>Behavior Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY_RULE__BEHAVIOR_NAME = eINSTANCE.getEntryRule_BehaviorName();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.DoRuleImpl <em>Do Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.DoRuleImpl
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getDoRule()
     * @generated
     */
    EClass DO_RULE = eINSTANCE.getDoRule();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DO_RULE__KIND = eINSTANCE.getDoRule_Kind();

    /**
     * The meta object literal for the '<em><b>Behavior Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DO_RULE__BEHAVIOR_NAME = eINSTANCE.getDoRule_BehaviorName();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.impl.ExitRuleImpl <em>Exit Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.ExitRuleImpl
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getExitRule()
     * @generated
     */
    EClass EXIT_RULE = eINSTANCE.getExitRule();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXIT_RULE__KIND = eINSTANCE.getExitRule_Kind();

    /**
     * The meta object literal for the '<em><b>Behavior Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXIT_RULE__BEHAVIOR_NAME = eINSTANCE.getExitRule_BehaviorName();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.BehaviorKind <em>Behavior Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.BehaviorKind
     * @see org.eclipse.papyrus.state.editor.xtext.umlState.impl.UmlStatePackageImpl#getBehaviorKind()
     * @generated
     */
    EEnum BEHAVIOR_KIND = eINSTANCE.getBehaviorKind();

  }

} //UmlStatePackage
