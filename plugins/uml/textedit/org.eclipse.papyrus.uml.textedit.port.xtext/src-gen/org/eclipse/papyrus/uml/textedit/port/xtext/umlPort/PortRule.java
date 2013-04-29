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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsConjugated <em>Is Conjugated</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule()
 * @model
 * @generated
 */
public interface PortRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind
   * @see #setVisibility(VisibilityKind)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_Visibility()
   * @model
   * @generated
   */
  VisibilityKind getVisibility();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityKind value);

  /**
   * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Derived</em>' attribute.
   * @see #setIsDerived(String)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_IsDerived()
   * @model
   * @generated
   */
  String getIsDerived();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsDerived <em>Is Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Derived</em>' attribute.
   * @see #getIsDerived()
   * @generated
   */
  void setIsDerived(String value);

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
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Is Conjugated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Conjugated</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Conjugated</em>' attribute.
   * @see #setIsConjugated(String)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_IsConjugated()
   * @model
   * @generated
   */
  String getIsConjugated();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsConjugated <em>Is Conjugated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Conjugated</em>' attribute.
   * @see #getIsConjugated()
   * @generated
   */
  void setIsConjugated(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeRule)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_Type()
   * @model containment="true"
   * @generated
   */
  TypeRule getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRule value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(MultiplicityRule)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_Multiplicity()
   * @model containment="true"
   * @generated
   */
  MultiplicityRule getMultiplicity();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(MultiplicityRule value);

  /**
   * Returns the value of the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifiers</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifiers</em>' containment reference.
   * @see #setModifiers(ModifiersRule)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_Modifiers()
   * @model containment="true"
   * @generated
   */
  ModifiersRule getModifiers();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getModifiers <em>Modifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifiers</em>' containment reference.
   * @see #getModifiers()
   * @generated
   */
  void setModifiers(ModifiersRule value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' containment reference.
   * @see #setDefault(DefaultValueRule)
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getPortRule_Default()
   * @model containment="true"
   * @generated
   */
  DefaultValueRule getDefault();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(DefaultValueRule value);

} // PortRule
