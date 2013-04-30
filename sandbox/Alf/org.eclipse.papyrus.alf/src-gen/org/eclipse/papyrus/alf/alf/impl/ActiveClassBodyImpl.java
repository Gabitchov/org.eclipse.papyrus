/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.ActiveClassBody;
import org.eclipse.papyrus.alf.alf.ActiveClassMember;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.BehaviorClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Class Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActiveClassBodyImpl#getActiveClassMember <em>Active Class Member</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActiveClassBodyImpl#getBehaviorClasue <em>Behavior Clasue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveClassBodyImpl extends MinimalEObjectImpl.Container implements ActiveClassBody
{
  /**
   * The cached value of the '{@link #getActiveClassMember() <em>Active Class Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActiveClassMember()
   * @generated
   * @ordered
   */
  protected EList<ActiveClassMember> activeClassMember;

  /**
   * The cached value of the '{@link #getBehaviorClasue() <em>Behavior Clasue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviorClasue()
   * @generated
   * @ordered
   */
  protected BehaviorClause behaviorClasue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActiveClassBodyImpl()
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
    return AlfPackage.eINSTANCE.getActiveClassBody();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActiveClassMember> getActiveClassMember()
  {
    if (activeClassMember == null)
    {
      activeClassMember = new EObjectContainmentEList<ActiveClassMember>(ActiveClassMember.class, this, AlfPackage.ACTIVE_CLASS_BODY__ACTIVE_CLASS_MEMBER);
    }
    return activeClassMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorClause getBehaviorClasue()
  {
    return behaviorClasue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBehaviorClasue(BehaviorClause newBehaviorClasue, NotificationChain msgs)
  {
    BehaviorClause oldBehaviorClasue = behaviorClasue;
    behaviorClasue = newBehaviorClasue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE, oldBehaviorClasue, newBehaviorClasue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehaviorClasue(BehaviorClause newBehaviorClasue)
  {
    if (newBehaviorClasue != behaviorClasue)
    {
      NotificationChain msgs = null;
      if (behaviorClasue != null)
        msgs = ((InternalEObject)behaviorClasue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE, null, msgs);
      if (newBehaviorClasue != null)
        msgs = ((InternalEObject)newBehaviorClasue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE, null, msgs);
      msgs = basicSetBehaviorClasue(newBehaviorClasue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE, newBehaviorClasue, newBehaviorClasue));
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
      case AlfPackage.ACTIVE_CLASS_BODY__ACTIVE_CLASS_MEMBER:
        return ((InternalEList<?>)getActiveClassMember()).basicRemove(otherEnd, msgs);
      case AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE:
        return basicSetBehaviorClasue(null, msgs);
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
      case AlfPackage.ACTIVE_CLASS_BODY__ACTIVE_CLASS_MEMBER:
        return getActiveClassMember();
      case AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE:
        return getBehaviorClasue();
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
      case AlfPackage.ACTIVE_CLASS_BODY__ACTIVE_CLASS_MEMBER:
        getActiveClassMember().clear();
        getActiveClassMember().addAll((Collection<? extends ActiveClassMember>)newValue);
        return;
      case AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE:
        setBehaviorClasue((BehaviorClause)newValue);
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
      case AlfPackage.ACTIVE_CLASS_BODY__ACTIVE_CLASS_MEMBER:
        getActiveClassMember().clear();
        return;
      case AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE:
        setBehaviorClasue((BehaviorClause)null);
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
      case AlfPackage.ACTIVE_CLASS_BODY__ACTIVE_CLASS_MEMBER:
        return activeClassMember != null && !activeClassMember.isEmpty();
      case AlfPackage.ACTIVE_CLASS_BODY__BEHAVIOR_CLASUE:
        return behaviorClasue != null;
    }
    return super.eIsSet(featureID);
  }

} //ActiveClassBodyImpl
