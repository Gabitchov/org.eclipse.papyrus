/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colon Qualified Name Completion Of Import Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference#isStar <em>Star</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getColonQualifiedNameCompletionOfImportReference()
 * @model
 * @generated
 */
public interface ColonQualifiedNameCompletionOfImportReference extends ImportReferenceQualifiedNameCompletion
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.Name}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getColonQualifiedNameCompletionOfImportReference_Name()
   * @model containment="true"
   * @generated
   */
  EList<Name> getName();

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getColonQualifiedNameCompletionOfImportReference_Star()
   * @model
   * @generated
   */
  boolean isStar();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference#isStar <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Star</em>' attribute.
   * @see #isStar()
   * @generated
   */
  void setStar(boolean value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getColonQualifiedNameCompletionOfImportReference_Alias()
   * @model containment="true"
   * @generated
   */
  AliasDefinition getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionOfImportReference#getAlias <em>Alias</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' containment reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(AliasDefinition value);

} // ColonQualifiedNameCompletionOfImportReference
