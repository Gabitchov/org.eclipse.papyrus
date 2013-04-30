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
import org.eclipse.papyrus.alf.alf.LinkOperation;
import org.eclipse.papyrus.alf.alf.LinkOperationCompletion;
import org.eclipse.papyrus.alf.alf.LinkOperationTuple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Operation Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationCompletionImpl#getLinkOperation <em>Link Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationCompletionImpl#getLinkOperationTuple <em>Link Operation Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkOperationCompletionImpl extends MinimalEObjectImpl.Container implements LinkOperationCompletion
{
  /**
   * The default value of the '{@link #getLinkOperation() <em>Link Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkOperation()
   * @generated
   * @ordered
   */
  protected static final LinkOperation LINK_OPERATION_EDEFAULT = LinkOperation.CREATE_LINK;

  /**
   * The cached value of the '{@link #getLinkOperation() <em>Link Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkOperation()
   * @generated
   * @ordered
   */
  protected LinkOperation linkOperation = LINK_OPERATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getLinkOperationTuple() <em>Link Operation Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkOperationTuple()
   * @generated
   * @ordered
   */
  protected LinkOperationTuple linkOperationTuple;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkOperationCompletionImpl()
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
    return AlfPackage.eINSTANCE.getLinkOperationCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperation getLinkOperation()
  {
    return linkOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLinkOperation(LinkOperation newLinkOperation)
  {
    LinkOperation oldLinkOperation = linkOperation;
    linkOperation = newLinkOperation == null ? LINK_OPERATION_EDEFAULT : newLinkOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION, oldLinkOperation, linkOperation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkOperationTuple getLinkOperationTuple()
  {
    return linkOperationTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLinkOperationTuple(LinkOperationTuple newLinkOperationTuple, NotificationChain msgs)
  {
    LinkOperationTuple oldLinkOperationTuple = linkOperationTuple;
    linkOperationTuple = newLinkOperationTuple;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE, oldLinkOperationTuple, newLinkOperationTuple);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLinkOperationTuple(LinkOperationTuple newLinkOperationTuple)
  {
    if (newLinkOperationTuple != linkOperationTuple)
    {
      NotificationChain msgs = null;
      if (linkOperationTuple != null)
        msgs = ((InternalEObject)linkOperationTuple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE, null, msgs);
      if (newLinkOperationTuple != null)
        msgs = ((InternalEObject)newLinkOperationTuple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE, null, msgs);
      msgs = basicSetLinkOperationTuple(newLinkOperationTuple, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE, newLinkOperationTuple, newLinkOperationTuple));
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
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE:
        return basicSetLinkOperationTuple(null, msgs);
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
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION:
        return getLinkOperation();
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE:
        return getLinkOperationTuple();
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
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION:
        setLinkOperation((LinkOperation)newValue);
        return;
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE:
        setLinkOperationTuple((LinkOperationTuple)newValue);
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
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION:
        setLinkOperation(LINK_OPERATION_EDEFAULT);
        return;
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE:
        setLinkOperationTuple((LinkOperationTuple)null);
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
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION:
        return linkOperation != LINK_OPERATION_EDEFAULT;
      case AlfPackage.LINK_OPERATION_COMPLETION__LINK_OPERATION_TUPLE:
        return linkOperationTuple != null;
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
    result.append(" (linkOperation: ");
    result.append(linkOperation);
    result.append(')');
    return result.toString();
  }

} //LinkOperationCompletionImpl
