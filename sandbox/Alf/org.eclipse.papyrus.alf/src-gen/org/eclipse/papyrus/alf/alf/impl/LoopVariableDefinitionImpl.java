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
import org.eclipse.papyrus.alf.alf.Expression;
import org.eclipse.papyrus.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.QualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LoopVariableDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LoopVariableDefinitionImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LoopVariableDefinitionImpl#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LoopVariableDefinitionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LoopVariableDefinitionImpl#getExpression3 <em>Expression3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopVariableDefinitionImpl extends MinimalEObjectImpl.Container implements LoopVariableDefinition
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getExpression1() <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected Expression expression1;

  /**
   * The cached value of the '{@link #getExpression2() <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression2()
   * @generated
   * @ordered
   */
  protected Expression expression2;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected QualifiedName typeName;

  /**
   * The cached value of the '{@link #getExpression3() <em>Expression3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression3()
   * @generated
   * @ordered
   */
  protected Expression expression3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LoopVariableDefinitionImpl()
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
    return AlfPackage.eINSTANCE.getLoopVariableDefinition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Name newName, NotificationChain msgs)
  {
    Name oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Name newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression1()
  {
    return expression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression1(Expression newExpression1, NotificationChain msgs)
  {
    Expression oldExpression1 = expression1;
    expression1 = newExpression1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1, oldExpression1, newExpression1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression1(Expression newExpression1)
  {
    if (newExpression1 != expression1)
    {
      NotificationChain msgs = null;
      if (expression1 != null)
        msgs = ((InternalEObject)expression1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1, null, msgs);
      if (newExpression1 != null)
        msgs = ((InternalEObject)newExpression1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1, null, msgs);
      msgs = basicSetExpression1(newExpression1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1, newExpression1, newExpression1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression2()
  {
    return expression2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression2(Expression newExpression2, NotificationChain msgs)
  {
    Expression oldExpression2 = expression2;
    expression2 = newExpression2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2, oldExpression2, newExpression2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression2(Expression newExpression2)
  {
    if (newExpression2 != expression2)
    {
      NotificationChain msgs = null;
      if (expression2 != null)
        msgs = ((InternalEObject)expression2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2, null, msgs);
      if (newExpression2 != null)
        msgs = ((InternalEObject)newExpression2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2, null, msgs);
      msgs = basicSetExpression2(newExpression2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2, newExpression2, newExpression2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeName(QualifiedName newTypeName, NotificationChain msgs)
  {
    QualifiedName oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME, oldTypeName, newTypeName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(QualifiedName newTypeName)
  {
    if (newTypeName != typeName)
    {
      NotificationChain msgs = null;
      if (typeName != null)
        msgs = ((InternalEObject)typeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME, null, msgs);
      if (newTypeName != null)
        msgs = ((InternalEObject)newTypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME, null, msgs);
      msgs = basicSetTypeName(newTypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME, newTypeName, newTypeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression3()
  {
    return expression3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression3(Expression newExpression3, NotificationChain msgs)
  {
    Expression oldExpression3 = expression3;
    expression3 = newExpression3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3, oldExpression3, newExpression3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression3(Expression newExpression3)
  {
    if (newExpression3 != expression3)
    {
      NotificationChain msgs = null;
      if (expression3 != null)
        msgs = ((InternalEObject)expression3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3, null, msgs);
      if (newExpression3 != null)
        msgs = ((InternalEObject)newExpression3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3, null, msgs);
      msgs = basicSetExpression3(newExpression3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3, newExpression3, newExpression3));
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
      case AlfPackage.LOOP_VARIABLE_DEFINITION__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1:
        return basicSetExpression1(null, msgs);
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2:
        return basicSetExpression2(null, msgs);
      case AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME:
        return basicSetTypeName(null, msgs);
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3:
        return basicSetExpression3(null, msgs);
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
      case AlfPackage.LOOP_VARIABLE_DEFINITION__NAME:
        return getName();
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1:
        return getExpression1();
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2:
        return getExpression2();
      case AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME:
        return getTypeName();
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3:
        return getExpression3();
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
      case AlfPackage.LOOP_VARIABLE_DEFINITION__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1:
        setExpression1((Expression)newValue);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2:
        setExpression2((Expression)newValue);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME:
        setTypeName((QualifiedName)newValue);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3:
        setExpression3((Expression)newValue);
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
      case AlfPackage.LOOP_VARIABLE_DEFINITION__NAME:
        setName((Name)null);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1:
        setExpression1((Expression)null);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2:
        setExpression2((Expression)null);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME:
        setTypeName((QualifiedName)null);
        return;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3:
        setExpression3((Expression)null);
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
      case AlfPackage.LOOP_VARIABLE_DEFINITION__NAME:
        return name != null;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION1:
        return expression1 != null;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION2:
        return expression2 != null;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__TYPE_NAME:
        return typeName != null;
      case AlfPackage.LOOP_VARIABLE_DEFINITION__EXPRESSION3:
        return expression3 != null;
    }
    return super.eIsSet(featureID);
  }

} //LoopVariableDefinitionImpl
