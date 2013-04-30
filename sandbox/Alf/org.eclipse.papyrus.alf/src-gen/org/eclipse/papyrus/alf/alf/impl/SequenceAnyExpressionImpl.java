/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.SequenceAnyExpression;
import org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Any Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceAnyExpressionImpl#getSequenceConstructionExpressionCompletion <em>Sequence Construction Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceAnyExpressionImpl extends BaseExpressionImpl implements SequenceAnyExpression
{
  /**
   * The cached value of the '{@link #getSequenceConstructionExpressionCompletion() <em>Sequence Construction Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceConstructionExpressionCompletion()
   * @generated
   * @ordered
   */
  protected SequenceConstructionExpressionCompletion sequenceConstructionExpressionCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceAnyExpressionImpl()
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
    return AlfPackage.eINSTANCE.getSequenceAnyExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionExpressionCompletion getSequenceConstructionExpressionCompletion()
  {
    return sequenceConstructionExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion newSequenceConstructionExpressionCompletion, NotificationChain msgs)
  {
    SequenceConstructionExpressionCompletion oldSequenceConstructionExpressionCompletion = sequenceConstructionExpressionCompletion;
    sequenceConstructionExpressionCompletion = newSequenceConstructionExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION, oldSequenceConstructionExpressionCompletion, newSequenceConstructionExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceConstructionExpressionCompletion(SequenceConstructionExpressionCompletion newSequenceConstructionExpressionCompletion)
  {
    if (newSequenceConstructionExpressionCompletion != sequenceConstructionExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (sequenceConstructionExpressionCompletion != null)
        msgs = ((InternalEObject)sequenceConstructionExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION, null, msgs);
      if (newSequenceConstructionExpressionCompletion != null)
        msgs = ((InternalEObject)newSequenceConstructionExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetSequenceConstructionExpressionCompletion(newSequenceConstructionExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION, newSequenceConstructionExpressionCompletion, newSequenceConstructionExpressionCompletion));
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
      case AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION:
        return basicSetSequenceConstructionExpressionCompletion(null, msgs);
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
      case AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION:
        return getSequenceConstructionExpressionCompletion();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION:
        setSequenceConstructionExpressionCompletion((SequenceConstructionExpressionCompletion)newValue);
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
      case AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION:
        setSequenceConstructionExpressionCompletion((SequenceConstructionExpressionCompletion)null);
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
      case AlfPackage.SEQUENCE_ANY_EXPRESSION__SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION:
        return sequenceConstructionExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //SequenceAnyExpressionImpl
