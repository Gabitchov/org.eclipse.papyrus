/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Class Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub#getActiveClassDeclaration <em>Active Class Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub#getActiveClassBody <em>Active Class Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActiveClassDefinitionOrStub()
 * @model
 * @generated
 */
public interface ActiveClassDefinitionOrStub extends ClassifierDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Active Class Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active Class Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Active Class Declaration</em>' containment reference.
   * @see #setActiveClassDeclaration(ActiveClassDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActiveClassDefinitionOrStub_ActiveClassDeclaration()
   * @model containment="true"
   * @generated
   */
  ActiveClassDeclaration getActiveClassDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub#getActiveClassDeclaration <em>Active Class Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Active Class Declaration</em>' containment reference.
   * @see #getActiveClassDeclaration()
   * @generated
   */
  void setActiveClassDeclaration(ActiveClassDeclaration value);

  /**
   * Returns the value of the '<em><b>Active Class Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active Class Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Active Class Body</em>' containment reference.
   * @see #setActiveClassBody(ActiveClassBody)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActiveClassDefinitionOrStub_ActiveClassBody()
   * @model containment="true"
   * @generated
   */
  ActiveClassBody getActiveClassBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub#getActiveClassBody <em>Active Class Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Active Class Body</em>' containment reference.
   * @see #getActiveClassBody()
   * @generated
   */
  void setActiveClassBody(ActiveClassBody value);

} // ActiveClassDefinitionOrStub
