/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getFeatureInvocation <em>Feature Invocation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getSequenceOperationOrReductionOrExpansion <em>Sequence Operation Or Reduction Or Expansion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index()
 * @model
 * @generated
 */
public interface Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index extends EObject
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' containment reference.
   * @see #setFeature(Feature)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_Feature()
   * @model containment="true"
   * @generated
   */
  Feature getFeature();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getFeature <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' containment reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(Feature value);

  /**
   * Returns the value of the '<em><b>Feature Invocation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature Invocation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature Invocation</em>' containment reference.
   * @see #setFeatureInvocation(FeatureInvocation)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_FeatureInvocation()
   * @model containment="true"
   * @generated
   */
  FeatureInvocation getFeatureInvocation();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getFeatureInvocation <em>Feature Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature Invocation</em>' containment reference.
   * @see #getFeatureInvocation()
   * @generated
   */
  void setFeatureInvocation(FeatureInvocation value);

  /**
   * Returns the value of the '<em><b>Sequence Operation Or Reduction Or Expansion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Operation Or Reduction Or Expansion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Operation Or Reduction Or Expansion</em>' containment reference.
   * @see #setSequenceOperationOrReductionOrExpansion(SequenceOperationOrReductionOrExpansion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_SequenceOperationOrReductionOrExpansion()
   * @model containment="true"
   * @generated
   */
  SequenceOperationOrReductionOrExpansion getSequenceOperationOrReductionOrExpansion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getSequenceOperationOrReductionOrExpansion <em>Sequence Operation Or Reduction Or Expansion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Operation Or Reduction Or Expansion</em>' containment reference.
   * @see #getSequenceOperationOrReductionOrExpansion()
   * @generated
   */
  void setSequenceOperationOrReductionOrExpansion(SequenceOperationOrReductionOrExpansion value);

  /**
   * Returns the value of the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' containment reference.
   * @see #setIndex(Index)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index_Index()
   * @model containment="true"
   * @generated
   */
  Index getIndex();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index#getIndex <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' containment reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(Index value);

} // Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index
