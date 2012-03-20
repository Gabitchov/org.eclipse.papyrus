/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.uml.alf.alf.ThisExpression;
import org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This Invocation Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ThisInvocationStatementImpl#get_this <em>this</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ThisInvocationStatementImpl#getAssignmentCompletion <em>Assignment Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThisInvocationStatementImpl extends StatementImpl implements ThisInvocationStatement
{
  /**
   * The cached value of the '{@link #get_this() <em>this</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #get_this()
   * @generated
   * @ordered
   */
  protected ThisExpression _this;

  /**
   * The cached value of the '{@link #getAssignmentCompletion() <em>Assignment Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignmentCompletion()
   * @generated
   * @ordered
   */
  protected AssignmentCompletion assignmentCompletion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ThisInvocationStatementImpl()
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
    return AlfPackage.Literals.THIS_INVOCATION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThisExpression get_this()
  {
    return _this;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSet_this(ThisExpression new_this, NotificationChain msgs)
  {
    ThisExpression old_this = _this;
    _this = new_this;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.THIS_INVOCATION_STATEMENT__THIS, old_this, new_this);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void set_this(ThisExpression new_this)
  {
    if (new_this != _this)
    {
      NotificationChain msgs = null;
      if (_this != null)
        msgs = ((InternalEObject)_this).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.THIS_INVOCATION_STATEMENT__THIS, null, msgs);
      if (new_this != null)
        msgs = ((InternalEObject)new_this).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.THIS_INVOCATION_STATEMENT__THIS, null, msgs);
      msgs = basicSet_this(new_this, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.THIS_INVOCATION_STATEMENT__THIS, new_this, new_this));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentCompletion getAssignmentCompletion()
  {
    return assignmentCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignmentCompletion(AssignmentCompletion newAssignmentCompletion, NotificationChain msgs)
  {
    AssignmentCompletion oldAssignmentCompletion = assignmentCompletion;
    assignmentCompletion = newAssignmentCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION, oldAssignmentCompletion, newAssignmentCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignmentCompletion(AssignmentCompletion newAssignmentCompletion)
  {
    if (newAssignmentCompletion != assignmentCompletion)
    {
      NotificationChain msgs = null;
      if (assignmentCompletion != null)
        msgs = ((InternalEObject)assignmentCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION, null, msgs);
      if (newAssignmentCompletion != null)
        msgs = ((InternalEObject)newAssignmentCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION, null, msgs);
      msgs = basicSetAssignmentCompletion(newAssignmentCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION, newAssignmentCompletion, newAssignmentCompletion));
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
      case AlfPackage.THIS_INVOCATION_STATEMENT__THIS:
        return basicSet_this(null, msgs);
      case AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION:
        return basicSetAssignmentCompletion(null, msgs);
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
      case AlfPackage.THIS_INVOCATION_STATEMENT__THIS:
        return get_this();
      case AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION:
        return getAssignmentCompletion();
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
      case AlfPackage.THIS_INVOCATION_STATEMENT__THIS:
        set_this((ThisExpression)newValue);
        return;
      case AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION:
        setAssignmentCompletion((AssignmentCompletion)newValue);
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
      case AlfPackage.THIS_INVOCATION_STATEMENT__THIS:
        set_this((ThisExpression)null);
        return;
      case AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION:
        setAssignmentCompletion((AssignmentCompletion)null);
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
      case AlfPackage.THIS_INVOCATION_STATEMENT__THIS:
        return _this != null;
      case AlfPackage.THIS_INVOCATION_STATEMENT__ASSIGNMENT_COMPLETION:
        return assignmentCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //ThisInvocationStatementImpl
