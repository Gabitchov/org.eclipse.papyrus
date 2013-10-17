/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.NonLiteralValueSpecification;
import org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parenthesized Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ParenthesizedExpressionImpl#getExpOrTypeCast <em>Exp Or Type Cast</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ParenthesizedExpressionImpl#getCasted <em>Casted</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ParenthesizedExpressionImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParenthesizedExpressionImpl extends ValueSpecificationImpl implements ParenthesizedExpression
{
  /**
   * The cached value of the '{@link #getExpOrTypeCast() <em>Exp Or Type Cast</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpOrTypeCast()
   * @generated
   * @ordered
   */
  protected Expression expOrTypeCast;

  /**
   * The cached value of the '{@link #getCasted() <em>Casted</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCasted()
   * @generated
   * @ordered
   */
  protected NonLiteralValueSpecification casted;

  /**
   * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuffix()
   * @generated
   * @ordered
   */
  protected SuffixExpression suffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParenthesizedExpressionImpl()
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
    return AlfPackage.Literals.PARENTHESIZED_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpOrTypeCast()
  {
    return expOrTypeCast;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpOrTypeCast(Expression newExpOrTypeCast, NotificationChain msgs)
  {
    Expression oldExpOrTypeCast = expOrTypeCast;
    expOrTypeCast = newExpOrTypeCast;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST, oldExpOrTypeCast, newExpOrTypeCast);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpOrTypeCast(Expression newExpOrTypeCast)
  {
    if (newExpOrTypeCast != expOrTypeCast)
    {
      NotificationChain msgs = null;
      if (expOrTypeCast != null)
        msgs = ((InternalEObject)expOrTypeCast).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST, null, msgs);
      if (newExpOrTypeCast != null)
        msgs = ((InternalEObject)newExpOrTypeCast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST, null, msgs);
      msgs = basicSetExpOrTypeCast(newExpOrTypeCast, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST, newExpOrTypeCast, newExpOrTypeCast));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonLiteralValueSpecification getCasted()
  {
    return casted;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCasted(NonLiteralValueSpecification newCasted, NotificationChain msgs)
  {
    NonLiteralValueSpecification oldCasted = casted;
    casted = newCasted;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PARENTHESIZED_EXPRESSION__CASTED, oldCasted, newCasted);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCasted(NonLiteralValueSpecification newCasted)
  {
    if (newCasted != casted)
    {
      NotificationChain msgs = null;
      if (casted != null)
        msgs = ((InternalEObject)casted).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PARENTHESIZED_EXPRESSION__CASTED, null, msgs);
      if (newCasted != null)
        msgs = ((InternalEObject)newCasted).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PARENTHESIZED_EXPRESSION__CASTED, null, msgs);
      msgs = basicSetCasted(newCasted, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PARENTHESIZED_EXPRESSION__CASTED, newCasted, newCasted));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuffixExpression getSuffix()
  {
    return suffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuffix(SuffixExpression newSuffix, NotificationChain msgs)
  {
    SuffixExpression oldSuffix = suffix;
    suffix = newSuffix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX, oldSuffix, newSuffix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuffix(SuffixExpression newSuffix)
  {
    if (newSuffix != suffix)
    {
      NotificationChain msgs = null;
      if (suffix != null)
        msgs = ((InternalEObject)suffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX, null, msgs);
      if (newSuffix != null)
        msgs = ((InternalEObject)newSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX, null, msgs);
      msgs = basicSetSuffix(newSuffix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX, newSuffix, newSuffix));
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
      case AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST:
        return basicSetExpOrTypeCast(null, msgs);
      case AlfPackage.PARENTHESIZED_EXPRESSION__CASTED:
        return basicSetCasted(null, msgs);
      case AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX:
        return basicSetSuffix(null, msgs);
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
      case AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST:
        return getExpOrTypeCast();
      case AlfPackage.PARENTHESIZED_EXPRESSION__CASTED:
        return getCasted();
      case AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX:
        return getSuffix();
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
      case AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST:
        setExpOrTypeCast((Expression)newValue);
        return;
      case AlfPackage.PARENTHESIZED_EXPRESSION__CASTED:
        setCasted((NonLiteralValueSpecification)newValue);
        return;
      case AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX:
        setSuffix((SuffixExpression)newValue);
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
      case AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST:
        setExpOrTypeCast((Expression)null);
        return;
      case AlfPackage.PARENTHESIZED_EXPRESSION__CASTED:
        setCasted((NonLiteralValueSpecification)null);
        return;
      case AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX:
        setSuffix((SuffixExpression)null);
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
      case AlfPackage.PARENTHESIZED_EXPRESSION__EXP_OR_TYPE_CAST:
        return expOrTypeCast != null;
      case AlfPackage.PARENTHESIZED_EXPRESSION__CASTED:
        return casted != null;
      case AlfPackage.PARENTHESIZED_EXPRESSION__SUFFIX:
        return suffix != null;
    }
    return super.eIsSet(featureID);
  }

} //ParenthesizedExpressionImpl
