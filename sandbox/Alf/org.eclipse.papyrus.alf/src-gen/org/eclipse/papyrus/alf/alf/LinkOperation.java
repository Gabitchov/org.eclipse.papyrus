/**
 */
package org.eclipse.papyrus.alf.alf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Link Operation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperation()
 * @model
 * @generated
 */
public enum LinkOperation implements Enumerator
{
  /**
   * The '<em><b>CREATE LINK</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CREATE_LINK_VALUE
   * @generated
   * @ordered
   */
  CREATE_LINK(0, "CREATE_LINK", "createLink"),

  /**
   * The '<em><b>DESTROY LINK</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DESTROY_LINK_VALUE
   * @generated
   * @ordered
   */
  DESTROY_LINK(1, "DESTROY_LINK", "destroyLink"),

  /**
   * The '<em><b>CLEAR ASSOC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLEAR_ASSOC_VALUE
   * @generated
   * @ordered
   */
  CLEAR_ASSOC(2, "CLEAR_ASSOC", "clearAssoc");

  /**
   * The '<em><b>CREATE LINK</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CREATE LINK</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CREATE_LINK
   * @model literal="createLink"
   * @generated
   * @ordered
   */
  public static final int CREATE_LINK_VALUE = 0;

  /**
   * The '<em><b>DESTROY LINK</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DESTROY LINK</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DESTROY_LINK
   * @model literal="destroyLink"
   * @generated
   * @ordered
   */
  public static final int DESTROY_LINK_VALUE = 1;

  /**
   * The '<em><b>CLEAR ASSOC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CLEAR ASSOC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CLEAR_ASSOC
   * @model literal="clearAssoc"
   * @generated
   * @ordered
   */
  public static final int CLEAR_ASSOC_VALUE = 2;

  /**
   * An array of all the '<em><b>Link Operation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final LinkOperation[] VALUES_ARRAY =
    new LinkOperation[]
    {
      CREATE_LINK,
      DESTROY_LINK,
      CLEAR_ASSOC,
    };

  /**
   * A public read-only list of all the '<em><b>Link Operation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<LinkOperation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Link Operation</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LinkOperation get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      LinkOperation result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Link Operation</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LinkOperation getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      LinkOperation result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Link Operation</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LinkOperation get(int value)
  {
    switch (value)
    {
      case CREATE_LINK_VALUE: return CREATE_LINK;
      case DESTROY_LINK_VALUE: return DESTROY_LINK;
      case CLEAR_ASSOC_VALUE: return CLEAR_ASSOC;
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
  private LinkOperation(int value, String name, String literal)
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
  
} //LinkOperation
