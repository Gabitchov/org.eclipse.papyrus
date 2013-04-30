/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub#getDataTypeDeclaration <em>Data Type Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub#getStructureBody <em>Structure Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getDataTypeDefinitionOrStub()
 * @model
 * @generated
 */
public interface DataTypeDefinitionOrStub extends ClassifierDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Data Type Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Type Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Type Declaration</em>' containment reference.
   * @see #setDataTypeDeclaration(DataTypeDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getDataTypeDefinitionOrStub_DataTypeDeclaration()
   * @model containment="true"
   * @generated
   */
  DataTypeDeclaration getDataTypeDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub#getDataTypeDeclaration <em>Data Type Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Type Declaration</em>' containment reference.
   * @see #getDataTypeDeclaration()
   * @generated
   */
  void setDataTypeDeclaration(DataTypeDeclaration value);

  /**
   * Returns the value of the '<em><b>Structure Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Structure Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Structure Body</em>' containment reference.
   * @see #setStructureBody(StructuredBody)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getDataTypeDefinitionOrStub_StructureBody()
   * @model containment="true"
   * @generated
   */
  StructuredBody getStructureBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub#getStructureBody <em>Structure Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structure Body</em>' containment reference.
   * @see #getStructureBody()
   * @generated
   */
  void setStructureBody(StructuredBody value);

} // DataTypeDefinitionOrStub
