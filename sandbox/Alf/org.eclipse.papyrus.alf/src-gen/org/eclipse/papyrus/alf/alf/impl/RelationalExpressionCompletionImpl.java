/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.RelationalExpressionCompletion;
import org.eclipse.papyrus.alf.alf.RelationalOperator;
import org.eclipse.papyrus.alf.alf.ShiftExpression;
import org.eclipse.papyrus.alf.alf.ShiftExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.RelationalExpressionCompletionImpl#getShiftExpressionCompletion <em>Shift Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.RelationalExpressionCompletionImpl#getRelationalOperator <em>Relational Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.RelationalExpressionCompletionImpl#getShiftExpression <em>Shift Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationalExpressionCompletionImpl extends MinimalEObjectImpl.Container implements RelationalExpressionCompletion
{
  /**
   * The cached value of the '{@link #getShiftExpressionCompletion() <em>Shift Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShiftExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ShiftExpressionCompletion shiftExpressionCompletion;

  /**
   * The default value of the '{@link #getRelationalOperator() <em>Relational Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationalOperator()
   * @generated
   * @ordered
   */
  protected static final RelationalOperator RELATIONAL_OPERATOR_EDEFAULT = RelationalOperator.LT;

  /**
   * The cached value of the '{@link #getRelationalOperator() <em>Relational Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationalOperator()
   * @generated
   * @ordered
   */
  protected RelationalOperator relationalOperator = RELATIONAL_OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getShiftExpression() <em>Shift Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShiftExpression()
   * @generated
   * @ordered
   */
  protected ShiftExpression shiftExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationalExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getRelationalExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpressionCompletion getShiftExpressionCompletion()
  {
    return shiftExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShiftExpressionCompletion(ShiftExpressionCompletion newShiftExpressionCompletion, NotificationChain msgs)
  {
    ShiftExpressionCompletion oldShiftExpressionCompletion = shiftExpressionCompletion;
    shiftExpressionCompletion = newShiftExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION, oldShiftExpressionCompletion, newShiftExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShiftExpressionCompletion(ShiftExpressionCompletion newShiftExpressionCompletion)
  {
    if (newShiftExpressionCompletion != shiftExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (shiftExpressionCompletion != null)
        msgs = ((InternalEObject)shiftExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION, null, msgs);
      if (newShiftExpressionCompletion != null)
        msgs = ((InternalEObject)newShiftExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetShiftExpressionCompletion(newShiftExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION, newShiftExpressionCompletion, newShiftExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator getRelationalOperator()
  {
    return relationalOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelationalOperator(RelationalOperator newRelationalOperator)
  {
    RelationalOperator oldRelationalOperator = relationalOperator;
    relationalOperator = newRelationalOperator == null ? RELATIONAL_OPERATOR_EDEFAULT : newRelationalOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__RELATIONAL_OPERATOR, oldRelationalOperator, relationalOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression getShiftExpression()
  {
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShiftExpression(ShiftExpression newShiftExpression, NotificationChain msgs)
  {
    ShiftExpression oldShiftExpression = shiftExpression;
    shiftExpression = newShiftExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION, oldShiftExpression, newShiftExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShiftExpression(ShiftExpression newShiftExpression)
  {
    if (newShiftExpression != shiftExpression)
    {
      NotificationChain msgs = null;
      if (shiftExpression != null)
        msgs = ((InternalEObject)shiftExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION, null, msgs);
      if (newShiftExpression != null)
        msgs = ((InternalEObject)newShiftExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION, null, msgs);
      msgs = basicSetShiftExpression(newShiftExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION, newShiftExpression, newShiftExpression));
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
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION:
        return basicSetShiftExpressionCompletion(null, msgs);
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION:
        return basicSetShiftExpression(null, msgs);
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
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION:
        return getShiftExpressionCompletion();
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__RELATIONAL_OPERATOR:
        return getRelationalOperator();
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION:
        return getShiftExpression();
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
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION:
        setShiftExpressionCompletion((ShiftExpressionCompletion)newValue);
        return;
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__RELATIONAL_OPERATOR:
        setRelationalOperator((RelationalOperator)newValue);
        return;
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION:
        setShiftExpression((ShiftExpression)newValue);
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
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION:
        setShiftExpressionCompletion((ShiftExpressionCompletion)null);
        return;
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__RELATIONAL_OPERATOR:
        setRelationalOperator(RELATIONAL_OPERATOR_EDEFAULT);
        return;
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION:
        setShiftExpression((ShiftExpression)null);
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
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION_COMPLETION:
        return shiftExpressionCompletion != null;
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__RELATIONAL_OPERATOR:
        return relationalOperator != RELATIONAL_OPERATOR_EDEFAULT;
      case AlfPackage.RELATIONAL_EXPRESSION_COMPLETION__SHIFT_EXPRESSION:
        return shiftExpression != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (relationalOperator: ");
    result.append(relationalOperator);
    result.append(')');
    return result.toString();
  }

} //RelationalExpressionCompletionImpl
