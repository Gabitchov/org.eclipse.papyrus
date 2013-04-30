/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassDefinition#getClassDeclaration <em>Class Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassDefinition#getClassBody <em>Class Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassDefinition()
 * @model
 * @generated
 */
public interface ClassDefinition extends ClassifierDefinition
{
  /**
   * Returns the value of the '<em><b>Class Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Declaration</em>' containment reference.
   * @see #setClassDeclaration(ClassDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassDefinition_ClassDeclaration()
   * @model containment="true"
   * @generated
   */
  ClassDeclaration getClassDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassDefinition#getClassDeclaration <em>Class Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Declaration</em>' containment reference.
   * @see #getClassDeclaration()
   * @generated
   */
  void setClassDeclaration(ClassDeclaration value);

  /**
   * Returns the value of the '<em><b>Class Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Body</em>' containment reference.
   * @see #setClassBody(ClassBody)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassDefinition_ClassBody()
   * @model containment="true"
   * @generated
   */
  ClassBody getClassBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassDefinition#getClassBody <em>Class Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Body</em>' containment reference.
   * @see #getClassBody()
   * @generated
   */
  void setClassBody(ClassBody value);

} // ClassDefinition
