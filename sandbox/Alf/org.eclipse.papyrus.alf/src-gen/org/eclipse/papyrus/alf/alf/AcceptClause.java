/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accept Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptClause#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AcceptClause#getQualifiedNameList <em>Qualified Name List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptClause()
 * @model
 * @generated
 */
public interface AcceptClause extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptClause_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptClause#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Qualified Name List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name List</em>' containment reference.
   * @see #setQualifiedNameList(QualifiedNameList)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAcceptClause_QualifiedNameList()
   * @model containment="true"
   * @generated
   */
  QualifiedNameList getQualifiedNameList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AcceptClause#getQualifiedNameList <em>Qualified Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name List</em>' containment reference.
   * @see #getQualifiedNameList()
   * @generated
   */
  void setQualifiedNameList(QualifiedNameList value);

} // AcceptClause
