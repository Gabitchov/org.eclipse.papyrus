/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Operation Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getIndexNamedExpressionListCompletion <em>Index Named Expression List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getPrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getPositionalTupleExpressionListCompletion <em>Positional Tuple Expression List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getIndexedNamedExpressionListCompletion <em>Indexed Named Expression List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getNameToExpressionCompletion <em>Name To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getPositionalTupleExpressionList <em>Positional Tuple Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple()
 * @model
 * @generated
 */
public interface LinkOperationTuple extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' containment reference.
   * @see #setIndex(Index)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_Index()
   * @model containment="true"
   * @generated
   */
  Index getIndex();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getIndex <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' containment reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(Index value);

  /**
   * Returns the value of the '<em><b>Index Named Expression List Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index Named Expression List Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index Named Expression List Completion</em>' containment reference.
   * @see #setIndexNamedExpressionListCompletion(IndexedNamedExpressionListCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_IndexNamedExpressionListCompletion()
   * @model containment="true"
   * @generated
   */
  IndexedNamedExpressionListCompletion getIndexNamedExpressionListCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getIndexNamedExpressionListCompletion <em>Index Named Expression List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index Named Expression List Completion</em>' containment reference.
   * @see #getIndexNamedExpressionListCompletion()
   * @generated
   */
  void setIndexNamedExpressionListCompletion(IndexedNamedExpressionListCompletion value);

  /**
   * Returns the value of the '<em><b>Primary To Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary To Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary To Expression Completion</em>' containment reference.
   * @see #setPrimaryToExpressionCompletion(PrimaryToExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_PrimaryToExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PrimaryToExpressionCompletion getPrimaryToExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getPrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary To Expression Completion</em>' containment reference.
   * @see #getPrimaryToExpressionCompletion()
   * @generated
   */
  void setPrimaryToExpressionCompletion(PrimaryToExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Positional Tuple Expression List Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Positional Tuple Expression List Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Positional Tuple Expression List Completion</em>' containment reference.
   * @see #setPositionalTupleExpressionListCompletion(PositionalTupleExpressionListCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_PositionalTupleExpressionListCompletion()
   * @model containment="true"
   * @generated
   */
  PositionalTupleExpressionListCompletion getPositionalTupleExpressionListCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getPositionalTupleExpressionListCompletion <em>Positional Tuple Expression List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Positional Tuple Expression List Completion</em>' containment reference.
   * @see #getPositionalTupleExpressionListCompletion()
   * @generated
   */
  void setPositionalTupleExpressionListCompletion(PositionalTupleExpressionListCompletion value);

  /**
   * Returns the value of the '<em><b>Indexed Named Expression List Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indexed Named Expression List Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indexed Named Expression List Completion</em>' containment reference.
   * @see #setIndexedNamedExpressionListCompletion(IndexedNamedExpressionListCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_IndexedNamedExpressionListCompletion()
   * @model containment="true"
   * @generated
   */
  IndexedNamedExpressionListCompletion getIndexedNamedExpressionListCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getIndexedNamedExpressionListCompletion <em>Indexed Named Expression List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indexed Named Expression List Completion</em>' containment reference.
   * @see #getIndexedNamedExpressionListCompletion()
   * @generated
   */
  void setIndexedNamedExpressionListCompletion(IndexedNamedExpressionListCompletion value);

  /**
   * Returns the value of the '<em><b>Name To Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name To Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name To Expression Completion</em>' containment reference.
   * @see #setNameToExpressionCompletion(NameToExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_NameToExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  NameToExpressionCompletion getNameToExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getNameToExpressionCompletion <em>Name To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name To Expression Completion</em>' containment reference.
   * @see #getNameToExpressionCompletion()
   * @generated
   */
  void setNameToExpressionCompletion(NameToExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Positional Tuple Expression List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Positional Tuple Expression List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Positional Tuple Expression List</em>' containment reference.
   * @see #setPositionalTupleExpressionList(PositionalTupleExpressionList)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationTuple_PositionalTupleExpressionList()
   * @model containment="true"
   * @generated
   */
  PositionalTupleExpressionList getPositionalTupleExpressionList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationTuple#getPositionalTupleExpressionList <em>Positional Tuple Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Positional Tuple Expression List</em>' containment reference.
   * @see #getPositionalTupleExpressionList()
   * @generated
   */
  void setPositionalTupleExpressionList(PositionalTupleExpressionList value);

} // LinkOperationTuple
