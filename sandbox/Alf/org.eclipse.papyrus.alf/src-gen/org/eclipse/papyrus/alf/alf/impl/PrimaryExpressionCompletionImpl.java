/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index;
import org.eclipse.papyrus.alf.alf.PrimaryExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PrimaryExpressionCompletionImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionCompletionImpl extends MinimalEObjectImpl.Container implements PrimaryExpressionCompletion
{
  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index> content;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryExpressionCompletionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AlfPackage.eINSTANCE.getPrimaryExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index> getContent()
  {
    if (content == null)
    {
      content = new EObjectContainmentEList<Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index>(Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index.class, this, AlfPackage.PRIMARY_EXPRESSION_COMPLETION__CONTENT);
    }
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION__CONTENT:
        return getContent();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION__CONTENT:
        getContent().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AlfPackage.PRIMARY_EXPRESSION_COMPLETION__CONTENT:
        return content != null && !content.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PrimaryExpressionCompletionImpl
