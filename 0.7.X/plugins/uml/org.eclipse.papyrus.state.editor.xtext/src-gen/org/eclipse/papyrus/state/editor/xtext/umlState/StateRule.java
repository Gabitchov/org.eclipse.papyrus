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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getDo <em>Do</em>}</li>
 *   <li>{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getExit <em>Exit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.state.editor.xtext.umlState.UmlStatePackage#getStateRule()
 * @model
 * @generated
 */
public interface StateRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.UmlStatePackage#getStateRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Entry</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry</em>' containment reference.
   * @see #setEntry(EntryRule)
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.UmlStatePackage#getStateRule_Entry()
   * @model containment="true"
   * @generated
   */
  EntryRule getEntry();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getEntry <em>Entry</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entry</em>' containment reference.
   * @see #getEntry()
   * @generated
   */
  void setEntry(EntryRule value);

  /**
   * Returns the value of the '<em><b>Do</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Do</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Do</em>' containment reference.
   * @see #setDo(DoRule)
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.UmlStatePackage#getStateRule_Do()
   * @model containment="true"
   * @generated
   */
  DoRule getDo();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getDo <em>Do</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Do</em>' containment reference.
   * @see #getDo()
   * @generated
   */
  void setDo(DoRule value);

  /**
   * Returns the value of the '<em><b>Exit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit</em>' containment reference.
   * @see #setExit(ExitRule)
   * @see org.eclipse.papyrus.state.editor.xtext.umlState.UmlStatePackage#getStateRule_Exit()
   * @model containment="true"
   * @generated
   */
  ExitRule getExit();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.state.editor.xtext.umlState.StateRule#getExit <em>Exit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exit</em>' containment reference.
   * @see #getExit()
   * @generated
   */
  void setExit(ExitRule value);

} // StateRule
