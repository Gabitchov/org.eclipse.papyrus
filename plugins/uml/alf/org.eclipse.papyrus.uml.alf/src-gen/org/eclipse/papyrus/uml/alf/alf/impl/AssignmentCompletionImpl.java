/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.uml.alf.alf.AssignmentOperator;
import org.eclipse.papyrus.uml.alf.alf.SequenceElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.AssignmentCompletionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.AssignmentCompletionImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentCompletionImpl extends MinimalEObjectImpl.Container implements AssignmentCompletion
{
  /**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final AssignmentOperator OP_EDEFAULT = AssignmentOperator.ASSIGN;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected AssignmentOperator op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getRightHandSide() <em>Right Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightHandSide()
   * @generated
   * @ordered
   */
  protected SequenceElement rightHandSide;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentCompletionImpl()
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
    return AlfPackage.Literals.ASSIGNMENT_COMPLETION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(AssignmentOperator newOp)
  {
    AssignmentOperator oldOp = op;
    op = newOp == null ? OP_EDEFAULT : newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ASSIGNMENT_COMPLETION__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElement getRightHandSide()
  {
    return rightHandSide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightHandSide(SequenceElement newRightHandSide, NotificationChain msgs)
  {
    SequenceElement oldRightHandSide = rightHandSide;
    rightHandSide = newRightHandSide;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE, oldRightHandSide, newRightHandSide);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightHandSide(SequenceElement newRightHandSide)
  {
    if (newRightHandSide != rightHandSide)
    {
      NotificationChain msgs = null;
      if (rightHandSide != null)
        msgs = ((InternalEObject)rightHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE, null, msgs);
      if (newRightHandSide != null)
        msgs = ((InternalEObject)newRightHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE, null, msgs);
      msgs = basicSetRightHandSide(newRightHandSide, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE, newRightHandSide, newRightHandSide));
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
      case AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE:
        return basicSetRightHandSide(null, msgs);
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
      case AlfPackage.ASSIGNMENT_COMPLETION__OP:
        return getOp();
      case AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE:
        return getRightHandSide();
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
      case AlfPackage.ASSIGNMENT_COMPLETION__OP:
        setOp((AssignmentOperator)newValue);
        return;
      case AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE:
        setRightHandSide((SequenceElement)newValue);
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
      case AlfPackage.ASSIGNMENT_COMPLETION__OP:
        setOp(OP_EDEFAULT);
        return;
      case AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE:
        setRightHandSide((SequenceElement)null);
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
      case AlfPackage.ASSIGNMENT_COMPLETION__OP:
        return op != OP_EDEFAULT;
      case AlfPackage.ASSIGNMENT_COMPLETION__RIGHT_HAND_SIDE:
        return rightHandSide != null;
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

} //AssignmentCompletionImpl
