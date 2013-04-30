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
import org.eclipse.papyrus.alf.alf.BehaviorInvocation;
import org.eclipse.papyrus.alf.alf.ClassExtentExpressionCompletion;
import org.eclipse.papyrus.alf.alf.LinkOperationCompletion;
import org.eclipse.papyrus.alf.alf.NameToPrimaryExpression;
import org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name To Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameToPrimaryExpressionImpl#getLinkOperationCompletion <em>Link Operation Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameToPrimaryExpressionImpl#getClassExtentExpressionCompletion <em>Class Extent Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameToPrimaryExpressionImpl#getSequenceConstructionCompletion <em>Sequence Construction Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NameToPrimaryExpressionImpl#getBehaviorInvocation <em>Behavior Invocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameToPrimaryExpressionImpl extends MinimalEObjectImpl.Container implements NameToPrimaryExpression
{
  /**
   * The cached value of the '{@link #getLinkOperationCompletion() <em>Link Operation Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkOperationCompletion()
   * @generated
   * @ordered
   */
  protected LinkOperationCompletion linkOperationCompletion;

  /**
   * The cached value of the '{@link #getClassExtentExpressionCompletion() <em>Class Extent Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassExtentExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ClassExtentExpressionCompletion classExtentExpressionCompletion;

  /**
   * The cached value of the '{@link #getSequenceConstructionCompletion() <em>Sequence Construction Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceConstructionCompletion()
   * @generated
   * @ordered
   */
  protected SequenceConstructionExpressionCompletion sequenceConstructionCompletion;

  /**
   * The cached value of the '{@link #getBehaviorInvocation() <em>Behavior Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorInvocation()
   * @generated
   * @ordered
   */
  protected BehaviorInvocation behaviorInvocation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameToPrimaryExpressionImpl()
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
    return AlfPackage.eINSTANCE.getNameToPrimaryExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationCompletion getLinkOperationCompletion()
  {
    return linkOperationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLinkOperationCompletion(LinkOperationCompletion newLinkOperationCompletion, NotificationChain msgs)
  {
    LinkOperationCompletion oldLinkOperationCompletion = linkOperationCompletion;
    linkOperationCompletion = newLinkOperationCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION, oldLinkOperationCompletion, newLinkOperationCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLinkOperationCompletion(LinkOperationCompletion newLinkOperationCompletion)
  {
    if (newLinkOperationCompletion != linkOperationCompletion)
    {
      NotificationChain msgs = null;
      if (linkOperationCompletion != null)
        msgs = ((InternalEObject)linkOperationCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION, null, msgs);
      if (newLinkOperationCompletion != null)
        msgs = ((InternalEObject)newLinkOperationCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION, null, msgs);
      msgs = basicSetLinkOperationCompletion(newLinkOperationCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION, newLinkOperationCompletion, newLinkOperationCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassExtentExpressionCompletion getClassExtentExpressionCompletion()
  {
    return classExtentExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassExtentExpressionCompletion(ClassExtentExpressionCompletion newClassExtentExpressionCompletion, NotificationChain msgs)
  {
    ClassExtentExpressionCompletion oldClassExtentExpressionCompletion = classExtentExpressionCompletion;
    classExtentExpressionCompletion = newClassExtentExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION, oldClassExtentExpressionCompletion, newClassExtentExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassExtentExpressionCompletion(ClassExtentExpressionCompletion newClassExtentExpressionCompletion)
  {
    if (newClassExtentExpressionCompletion != classExtentExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (classExtentExpressionCompletion != null)
        msgs = ((InternalEObject)classExtentExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION, null, msgs);
      if (newClassExtentExpressionCompletion != null)
        msgs = ((InternalEObject)newClassExtentExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetClassExtentExpressionCompletion(newClassExtentExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION, newClassExtentExpressionCompletion, newClassExtentExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionExpressionCompletion getSequenceConstructionCompletion()
  {
    return sequenceConstructionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceConstructionCompletion(SequenceConstructionExpressionCompletion newSequenceConstructionCompletion, NotificationChain msgs)
  {
    SequenceConstructionExpressionCompletion oldSequenceConstructionCompletion = sequenceConstructionCompletion;
    sequenceConstructionCompletion = newSequenceConstructionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, oldSequenceConstructionCompletion, newSequenceConstructionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceConstructionCompletion(SequenceConstructionExpressionCompletion newSequenceConstructionCompletion)
  {
    if (newSequenceConstructionCompletion != sequenceConstructionCompletion)
    {
      NotificationChain msgs = null;
      if (sequenceConstructionCompletion != null)
        msgs = ((InternalEObject)sequenceConstructionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, null, msgs);
      if (newSequenceConstructionCompletion != null)
        msgs = ((InternalEObject)newSequenceConstructionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, null, msgs);
      msgs = basicSetSequenceConstructionCompletion(newSequenceConstructionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, newSequenceConstructionCompletion, newSequenceConstructionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorInvocation getBehaviorInvocation()
  {
    return behaviorInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviorInvocation(BehaviorInvocation newBehaviorInvocation, NotificationChain msgs)
  {
    BehaviorInvocation oldBehaviorInvocation = behaviorInvocation;
    behaviorInvocation = newBehaviorInvocation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION, oldBehaviorInvocation, newBehaviorInvocation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehaviorInvocation(BehaviorInvocation newBehaviorInvocation)
  {
    if (newBehaviorInvocation != behaviorInvocation)
    {
      NotificationChain msgs = null;
      if (behaviorInvocation != null)
        msgs = ((InternalEObject)behaviorInvocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION, null, msgs);
      if (newBehaviorInvocation != null)
        msgs = ((InternalEObject)newBehaviorInvocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION, null, msgs);
      msgs = basicSetBehaviorInvocation(newBehaviorInvocation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION, newBehaviorInvocation, newBehaviorInvocation));
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
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION:
        return basicSetLinkOperationCompletion(null, msgs);
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION:
        return basicSetClassExtentExpressionCompletion(null, msgs);
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        return basicSetSequenceConstructionCompletion(null, msgs);
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION:
        return basicSetBehaviorInvocation(null, msgs);
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
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION:
        return getLinkOperationCompletion();
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION:
        return getClassExtentExpressionCompletion();
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        return getSequenceConstructionCompletion();
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION:
        return getBehaviorInvocation();
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
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION:
        setLinkOperationCompletion((LinkOperationCompletion)newValue);
        return;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION:
        setClassExtentExpressionCompletion((ClassExtentExpressionCompletion)newValue);
        return;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        setSequenceConstructionCompletion((SequenceConstructionExpressionCompletion)newValue);
        return;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION:
        setBehaviorInvocation((BehaviorInvocation)newValue);
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
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION:
        setLinkOperationCompletion((LinkOperationCompletion)null);
        return;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION:
        setClassExtentExpressionCompletion((ClassExtentExpressionCompletion)null);
        return;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        setSequenceConstructionCompletion((SequenceConstructionExpressionCompletion)null);
        return;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION:
        setBehaviorInvocation((BehaviorInvocation)null);
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
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__LINK_OPERATION_COMPLETION:
        return linkOperationCompletion != null;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__CLASS_EXTENT_EXPRESSION_COMPLETION:
        return classExtentExpressionCompletion != null;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        return sequenceConstructionCompletion != null;
      case AlfPackage.NAME_TO_PRIMARY_EXPRESSION__BEHAVIOR_INVOCATION:
        return behaviorInvocation != null;
    }
    return super.eIsSet(featureID);
  }

} //NameToPrimaryExpressionImpl
