/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ImportReference#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ImportReference#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ImportReference#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ImportReference#isStar <em>Star</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportReference()
 * @model
 * @generated
 */
public interface ImportReference extends EObject
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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportReference_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ImportReference#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Completion</em>' containment reference.
   * @see #setCompletion(ImportReferenceQualifiedNameCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportReference_Completion()
   * @model containment="true"
   * @generated
   */
  ImportReferenceQualifiedNameCompletion getCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ImportReference#getCompletion <em>Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Completion</em>' containment reference.
   * @see #getCompletion()
   * @generated
   */
  void setCompletion(ImportReferenceQualifiedNameCompletion value);

  /**
   * Returns the value of the '<em><b>Alias</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' containment reference.
   * @see #setAlias(AliasDefinition)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportReference_Alias()
   * @model containment="true"
   * @generated
   */
  AliasDefinition getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ImportReference#getAlias <em>Alias</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' containment reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(AliasDefinition value);

  /**
   * Returns the value of the '<em><b>Star</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Star</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Star</em>' attribute.
   * @see #setStar(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportReference_Star()
   * @model
   * @generated
   */
  boolean isStar();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ImportReference#isStar <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Star</em>' attribute.
   * @see #isStar()
   * @generated
   */
  void setStar(boolean value);

} // ImportReference
