/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Operation Or Reduction Or Expansion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getTuple <em>Tuple</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#isIsReduce <em>Is Reduce</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getTemplateBinding <em>Template Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion()
 * @model
 * @generated
 */
public interface SequenceOperationOrReductionOrExpansion extends EObject
{
  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' containment reference.
   * @see #setQualifiedName(EObject)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_QualifiedName()
   * @model containment="true"
   * @generated
   */
  EObject getQualifiedName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getQualifiedName <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' containment reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(EObject value);

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference.
   * @see #setTuple(Tuple)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_Tuple()
   * @model containment="true"
   * @generated
   */
  Tuple getTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(Tuple value);

  /**
   * Returns the value of the '<em><b>Is Reduce</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Reduce</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Reduce</em>' attribute.
   * @see #setIsReduce(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_IsReduce()
   * @model
   * @generated
   */
  boolean isIsReduce();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#isIsReduce <em>Is Reduce</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Reduce</em>' attribute.
   * @see #isIsReduce()
   * @generated
   */
  void setIsReduce(boolean value);

  /**
   * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Ordered</em>' attribute.
   * @see #setIsOrdered(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_IsOrdered()
   * @model
   * @generated
   */
  boolean isIsOrdered();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#isIsOrdered <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Ordered</em>' attribute.
   * @see #isIsOrdered()
   * @generated
   */
  void setIsOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Template Binding</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Binding</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Binding</em>' containment reference.
   * @see #setTemplateBinding(TemplateBinding)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_TemplateBinding()
   * @model containment="true"
   * @generated
   */
  TemplateBinding getTemplateBinding();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getTemplateBinding <em>Template Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template Binding</em>' containment reference.
   * @see #getTemplateBinding()
   * @generated
   */
  void setTemplateBinding(TemplateBinding value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

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
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceOperationOrReductionOrExpansion_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // SequenceOperationOrReductionOrExpansion
