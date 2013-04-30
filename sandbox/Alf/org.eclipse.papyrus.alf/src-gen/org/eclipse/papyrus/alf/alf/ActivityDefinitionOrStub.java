/**
 */
package org.eclipse.papyrus.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub#getActivityDeclaration <em>Activity Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDefinitionOrStub()
 * @model
 * @generated
 */
public interface ActivityDefinitionOrStub extends ClassifierDefinitionOrStub
{
  /**
   * Returns the value of the '<em><b>Activity Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Declaration</em>' containment reference.
   * @see #setActivityDeclaration(ActivityDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDefinitionOrStub_ActivityDeclaration()
   * @model containment="true"
   * @generated
   */
  ActivityDeclaration getActivityDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub#getActivityDeclaration <em>Activity Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Declaration</em>' containment reference.
   * @see #getActivityDeclaration()
   * @generated
   */
  void setActivityDeclaration(ActivityDeclaration value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(Block)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getActivityDefinitionOrStub_Block()
   * @model containment="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

} // ActivityDefinitionOrStub
