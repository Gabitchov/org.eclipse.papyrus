/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackageDefinitionOrStub()
 * @model
 * @generated
 */
public interface PackageDefinitionOrStub extends PackagedElementDefinition
{
  /**
   * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' containment reference.
   * @see #setDeclaration(PackageDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackageDefinitionOrStub_Declaration()
   * @model containment="true"
   * @generated
   */
  PackageDeclaration getDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub#getDeclaration <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaration</em>' containment reference.
   * @see #getDeclaration()
   * @generated
   */
  void setDeclaration(PackageDeclaration value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(PackageBody)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPackageDefinitionOrStub_Body()
   * @model containment="true"
   * @generated
   */
  PackageBody getBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(PackageBody value);

} // PackageDefinitionOrStub
