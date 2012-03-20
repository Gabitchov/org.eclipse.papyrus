/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assignment Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAssignmentOperator()
 * @model
 * @generated
 */
public enum AssignmentOperator implements Enumerator
{
  /**
   * The '<em><b>ASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSIGN_VALUE
   * @generated
   * @ordered
   */
  ASSIGN(0, "ASSIGN", "="),

  /**
   * The '<em><b>PLUSASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLUSASSIGN_VALUE
   * @generated
   * @ordered
   */
  PLUSASSIGN(1, "PLUSASSIGN", "+="),

  /**
   * The '<em><b>MINUSASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MINUSASSIGN_VALUE
   * @generated
   * @ordered
   */
  MINUSASSIGN(2, "MINUSASSIGN", "-="),

  /**
   * The '<em><b>MULTASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTASSIGN_VALUE
   * @generated
   * @ordered
   */
  MULTASSIGN(3, "MULTASSIGN", "*="),

  /**
   * The '<em><b>MODASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODASSIGN_VALUE
   * @generated
   * @ordered
   */
  MODASSIGN(4, "MODASSIGN", "%="),

  /**
   * The '<em><b>DIVASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVASSIGN_VALUE
   * @generated
   * @ordered
   */
  DIVASSIGN(5, "DIVASSIGN", "/="),

  /**
   * The '<em><b>ANDASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANDASSIGN_VALUE
   * @generated
   * @ordered
   */
  ANDASSIGN(6, "ANDASSIGN", "&="),

  /**
   * The '<em><b>ORASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ORASSIGN_VALUE
   * @generated
   * @ordered
   */
  ORASSIGN(7, "ORASSIGN", "|="),

  /**
   * The '<em><b>XORASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XORASSIGN_VALUE
   * @generated
   * @ordered
   */
  XORASSIGN(8, "XORASSIGN", "^="),

  /**
   * The '<em><b>LSHIFTASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LSHIFTASSIGN_VALUE
   * @generated
   * @ordered
   */
  LSHIFTASSIGN(9, "LSHIFTASSIGN", "<<="),

  /**
   * The '<em><b>RSHIFTASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RSHIFTASSIGN_VALUE
   * @generated
   * @ordered
   */
  RSHIFTASSIGN(10, "RSHIFTASSIGN", ">>="),

  /**
   * The '<em><b>URSHIFTASSIGN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #URSHIFTASSIGN_VALUE
   * @generated
   * @ordered
   */
  URSHIFTASSIGN(11, "URSHIFTASSIGN", ">>>=");

  /**
   * The '<em><b>ASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASSIGN
   * @model literal="="
   * @generated
   * @ordered
   */
  public static final int ASSIGN_VALUE = 0;

  /**
   * The '<em><b>PLUSASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PLUSASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PLUSASSIGN
   * @model literal="+="
   * @generated
   * @ordered
   */
  public static final int PLUSASSIGN_VALUE = 1;

  /**
   * The '<em><b>MINUSASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MINUSASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MINUSASSIGN
   * @model literal="-="
   * @generated
   * @ordered
   */
  public static final int MINUSASSIGN_VALUE = 2;

  /**
   * The '<em><b>MULTASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTASSIGN
   * @model literal="*="
   * @generated
   * @ordered
   */
  public static final int MULTASSIGN_VALUE = 3;

  /**
   * The '<em><b>MODASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MODASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODASSIGN
   * @model literal="%="
   * @generated
   * @ordered
   */
  public static final int MODASSIGN_VALUE = 4;

  /**
   * The '<em><b>DIVASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DIVASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVASSIGN
   * @model literal="/="
   * @generated
   * @ordered
   */
  public static final int DIVASSIGN_VALUE = 5;

  /**
   * The '<em><b>ANDASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ANDASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANDASSIGN
   * @model literal="&="
   * @generated
   * @ordered
   */
  public static final int ANDASSIGN_VALUE = 6;

  /**
   * The '<em><b>ORASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ORASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ORASSIGN
   * @model literal="|="
   * @generated
   * @ordered
   */
  public static final int ORASSIGN_VALUE = 7;

  /**
   * The '<em><b>XORASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>XORASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XORASSIGN
   * @model literal="^="
   * @generated
   * @ordered
   */
  public static final int XORASSIGN_VALUE = 8;

  /**
   * The '<em><b>LSHIFTASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LSHIFTASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LSHIFTASSIGN
   * @model literal="<<="
   * @generated
   * @ordered
   */
  public static final int LSHIFTASSIGN_VALUE = 9;

  /**
   * The '<em><b>RSHIFTASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RSHIFTASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RSHIFTASSIGN
   * @model literal=">>="
   * @generated
   * @ordered
   */
  public static final int RSHIFTASSIGN_VALUE = 10;

  /**
   * The '<em><b>URSHIFTASSIGN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>URSHIFTASSIGN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #URSHIFTASSIGN
   * @model literal=">>>="
   * @generated
   * @ordered
   */
  public static final int URSHIFTASSIGN_VALUE = 11;

  /**
   * An array of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AssignmentOperator[] VALUES_ARRAY =
    new AssignmentOperator[]
    {
      ASSIGN,
      PLUSASSIGN,
      MINUSASSIGN,
      MULTASSIGN,
      MODASSIGN,
      DIVASSIGN,
      ANDASSIGN,
      ORASSIGN,
      XORASSIGN,
      LSHIFTASSIGN,
      RSHIFTASSIGN,
      URSHIFTASSIGN,
    };

  /**
   * A public read-only list of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AssignmentOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssignmentOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssignmentOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentOperator get(int value)
  {
    switch (value)
    {
      case ASSIGN_VALUE: return ASSIGN;
      case PLUSASSIGN_VALUE: return PLUSASSIGN;
      case MINUSASSIGN_VALUE: return MINUSASSIGN;
      case MULTASSIGN_VALUE: return MULTASSIGN;
      case MODASSIGN_VALUE: return MODASSIGN;
      case DIVASSIGN_VALUE: return DIVASSIGN;
      case ANDASSIGN_VALUE: return ANDASSIGN;
      case ORASSIGN_VALUE: return ORASSIGN;
      case XORASSIGN_VALUE: return XORASSIGN;
      case LSHIFTASSIGN_VALUE: return LSHIFTASSIGN;
      case RSHIFTASSIGN_VALUE: return RSHIFTASSIGN;
      case URSHIFTASSIGN_VALUE: return URSHIFTASSIGN;
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
  private AssignmentOperator(int value, String name, String literal)
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
  
} //AssignmentOperator
