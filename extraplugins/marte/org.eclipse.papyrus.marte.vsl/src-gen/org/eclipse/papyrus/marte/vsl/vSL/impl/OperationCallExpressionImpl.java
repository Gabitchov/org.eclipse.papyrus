/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.OperationCallExpressionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.OperationCallExpressionImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpressionImpl extends SuffixExpressionImpl implements OperationCallExpression
{
  /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected Operation operation;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected ListOfValues arguments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationCallExpressionImpl()
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
    return VSLPackage.Literals.OPERATION_CALL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation getOperation()
  {
    if (operation != null && operation.eIsProxy())
    {
      InternalEObject oldOperation = (InternalEObject)operation;
      operation = (Operation)eResolveProxy(oldOperation);
      if (operation != oldOperation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION, oldOperation, operation));
      }
    }
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation basicGetOperation()
  {
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperation(Operation newOperation)
  {
    Operation oldOperation = operation;
    operation = newOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION, oldOperation, operation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfValues getArguments()
  {
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArguments(ListOfValues newArguments, NotificationChain msgs)
  {
    ListOfValues oldArguments = arguments;
    arguments = newArguments;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, oldArguments, newArguments);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArguments(ListOfValues newArguments)
  {
    if (newArguments != arguments)
    {
      NotificationChain msgs = null;
      if (arguments != null)
        msgs = ((InternalEObject)arguments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, null, msgs);
      if (newArguments != null)
        msgs = ((InternalEObject)newArguments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, null, msgs);
      msgs = basicSetArguments(newArguments, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS, newArguments, newArguments));
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
      case VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS:
        return basicSetArguments(null, msgs);
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
      case VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION:
        if (resolve) return getOperation();
        return basicGetOperation();
      case VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS:
        return getArguments();
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
      case VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION:
        setOperation((Operation)newValue);
        return;
      case VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS:
        setArguments((ListOfValues)newValue);
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
      case VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION:
        setOperation((Operation)null);
        return;
      case VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS:
        setArguments((ListOfValues)null);
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
      case VSLPackage.OPERATION_CALL_EXPRESSION__OPERATION:
        return operation != null;
      case VSLPackage.OPERATION_CALL_EXPRESSION__ARGUMENTS:
        return arguments != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationCallExpressionImpl
