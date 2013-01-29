/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl#getUnary <em>Unary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.UnaryExpressionImpl#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnaryExpressionImpl extends MinimalEObjectImpl.Container implements UnaryExpression
{
  /**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final String OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected String op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getUnary() <em>Unary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnary()
   * @generated
   * @ordered
   */
  protected UnaryExpression unary;

  /**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected PrimaryExpression exp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnaryExpressionImpl()
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
    return VSLPackage.Literals.UNARY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(String newOp)
  {
    String oldOp = op;
    op = newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.UNARY_EXPRESSION__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression getUnary()
  {
    return unary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnary(UnaryExpression newUnary, NotificationChain msgs)
  {
    UnaryExpression oldUnary = unary;
    unary = newUnary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.UNARY_EXPRESSION__UNARY, oldUnary, newUnary);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnary(UnaryExpression newUnary)
  {
    if (newUnary != unary)
    {
      NotificationChain msgs = null;
      if (unary != null)
        msgs = ((InternalEObject)unary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.UNARY_EXPRESSION__UNARY, null, msgs);
      if (newUnary != null)
        msgs = ((InternalEObject)newUnary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.UNARY_EXPRESSION__UNARY, null, msgs);
      msgs = basicSetUnary(newUnary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.UNARY_EXPRESSION__UNARY, newUnary, newUnary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression getExp()
  {
    return exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExp(PrimaryExpression newExp, NotificationChain msgs)
  {
    PrimaryExpression oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.UNARY_EXPRESSION__EXP, oldExp, newExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExp(PrimaryExpression newExp)
  {
    if (newExp != exp)
    {
      NotificationChain msgs = null;
      if (exp != null)
        msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.UNARY_EXPRESSION__EXP, null, msgs);
      if (newExp != null)
        msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.UNARY_EXPRESSION__EXP, null, msgs);
      msgs = basicSetExp(newExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.UNARY_EXPRESSION__EXP, newExp, newExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getFilteredParentRule(final EClass filter)
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;
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
      case VSLPackage.UNARY_EXPRESSION__UNARY:
        return basicSetUnary(null, msgs);
      case VSLPackage.UNARY_EXPRESSION__EXP:
        return basicSetExp(null, msgs);
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
      case VSLPackage.UNARY_EXPRESSION__OP:
        return getOp();
      case VSLPackage.UNARY_EXPRESSION__UNARY:
        return getUnary();
      case VSLPackage.UNARY_EXPRESSION__EXP:
        return getExp();
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
      case VSLPackage.UNARY_EXPRESSION__OP:
        setOp((String)newValue);
        return;
      case VSLPackage.UNARY_EXPRESSION__UNARY:
        setUnary((UnaryExpression)newValue);
        return;
      case VSLPackage.UNARY_EXPRESSION__EXP:
        setExp((PrimaryExpression)newValue);
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
      case VSLPackage.UNARY_EXPRESSION__OP:
        setOp(OP_EDEFAULT);
        return;
      case VSLPackage.UNARY_EXPRESSION__UNARY:
        setUnary((UnaryExpression)null);
        return;
      case VSLPackage.UNARY_EXPRESSION__EXP:
        setExp((PrimaryExpression)null);
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
      case VSLPackage.UNARY_EXPRESSION__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case VSLPackage.UNARY_EXPRESSION__UNARY:
        return unary != null;
      case VSLPackage.UNARY_EXPRESSION__EXP:
        return exp != null;
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
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //UnaryExpressionImpl
