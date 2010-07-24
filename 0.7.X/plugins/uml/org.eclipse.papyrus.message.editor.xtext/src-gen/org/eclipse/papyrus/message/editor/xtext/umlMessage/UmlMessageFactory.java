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
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.message.editor.xtext.umlMessage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.message.editor.xtext.umlMessage.UmlMessagePackage
 * @generated
 */
public interface UmlMessageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlMessageFactory eINSTANCE = org.eclipse.papyrus.message.editor.xtext.umlMessage.impl.UmlMessageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Message Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Rule</em>'.
   * @generated
   */
  MessageRule createMessageRule();

  /**
   * Returns a new object of class '<em>Sequence Term Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Term Rule</em>'.
   * @generated
   */
  SequenceTermRule createSequenceTermRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UmlMessagePackage getUmlMessagePackage();

} //UmlMessageFactory
