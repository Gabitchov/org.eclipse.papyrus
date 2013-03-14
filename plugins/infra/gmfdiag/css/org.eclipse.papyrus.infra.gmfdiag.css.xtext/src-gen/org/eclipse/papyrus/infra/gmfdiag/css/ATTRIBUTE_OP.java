/*****************************************************************************
 * Copyright (c) 2012-2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ATTRIBUTE OP</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getATTRIBUTE_OP()
 * @model
 * @generated
 */
public enum ATTRIBUTE_OP implements Enumerator
{
  /**
   * The '<em><b>EQUALS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EQUALS_VALUE
   * @generated
   * @ordered
   */
  EQUALS(0, "EQUALS", "="),

  /**
   * The '<em><b>CONTAINS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONTAINS_VALUE
   * @generated
   * @ordered
   */
  CONTAINS(1, "CONTAINS", "~="),

  /**
   * The '<em><b>UNEQUALS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNEQUALS_VALUE
   * @generated
   * @ordered
   */
  UNEQUALS(2, "UNEQUALS", "!=");

  /**
   * The '<em><b>EQUALS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EQUALS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EQUALS
   * @model literal="="
   * @generated
   * @ordered
   */
  public static final int EQUALS_VALUE = 0;

  /**
   * The '<em><b>CONTAINS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONTAINS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONTAINS
   * @model literal="~="
   * @generated
   * @ordered
   */
  public static final int CONTAINS_VALUE = 1;

  /**
   * The '<em><b>UNEQUALS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNEQUALS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNEQUALS
   * @model literal="!="
   * @generated
   * @ordered
   */
  public static final int UNEQUALS_VALUE = 2;

  /**
   * An array of all the '<em><b>ATTRIBUTE OP</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ATTRIBUTE_OP[] VALUES_ARRAY =
    new ATTRIBUTE_OP[]
    {
      EQUALS,
      CONTAINS,
      UNEQUALS,
    };

  /**
   * A public read-only list of all the '<em><b>ATTRIBUTE OP</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ATTRIBUTE_OP> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>ATTRIBUTE OP</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ATTRIBUTE_OP get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ATTRIBUTE_OP result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>ATTRIBUTE OP</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ATTRIBUTE_OP getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ATTRIBUTE_OP result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>ATTRIBUTE OP</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ATTRIBUTE_OP get(int value)
  {
    switch (value)
    {
      case EQUALS_VALUE: return EQUALS;
      case CONTAINS_VALUE: return CONTAINS;
      case UNEQUALS_VALUE: return UNEQUALS;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ATTRIBUTE_OP(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ATTRIBUTE_OP
