/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotated Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AnnotatedStatement#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AnnotatedStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAnnotatedStatement()
 * @model
 * @generated
 */
public interface AnnotatedStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference.
   * @see #setAnnotations(Annotations)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAnnotatedStatement_Annotations()
   * @model containment="true"
   * @generated
   */
  Annotations getAnnotations();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AnnotatedStatement#getAnnotations <em>Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotations</em>' containment reference.
   * @see #getAnnotations()
   * @generated
   */
  void setAnnotations(Annotations value);

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(Statement)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAnnotatedStatement_Statement()
   * @model containment="true"
   * @generated
   */
  Statement getStatement();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AnnotatedStatement#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(Statement value);

} // AnnotatedStatement
