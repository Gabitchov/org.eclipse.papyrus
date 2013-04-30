/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.SequenceElements;
import org.eclipse.papyrus.alf.alf.SequenceInitializationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Initialization Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceInitializationExpressionImpl#isIsNew <em>Is New</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceInitializationExpressionImpl#getSequenceElements <em>Sequence Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceInitializationExpressionImpl extends InitializationExpressionImpl implements SequenceInitializationExpression
{
  /**
   * The default value of the '{@link #isIsNew() <em>Is New</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNew()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NEW_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNew() <em>Is New</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNew()
   * @generated
   * @ordered
   */
  protected boolean isNew = IS_NEW_EDEFAULT;

  /**
   * The cached value of the '{@link #getSequenceElements() <em>Sequence Elements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceElements()
   * @generated
   * @ordered
   */
  protected SequenceElements sequenceElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceInitializationExpressionImpl()
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
    return AlfPackage.eINSTANCE.getSequenceInitializationExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsNew()
  {
    return isNew;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsNew(boolean newIsNew)
  {
    boolean oldIsNew = isNew;
    isNew = newIsNew;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__IS_NEW, oldIsNew, isNew));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElements getSequenceElements()
  {
    return sequenceElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceElements(SequenceElements newSequenceElements, NotificationChain msgs)
  {
    SequenceElements oldSequenceElements = sequenceElements;
    sequenceElements = newSequenceElements;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS, oldSequenceElements, newSequenceElements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceElements(SequenceElements newSequenceElements)
  {
    if (newSequenceElements != sequenceElements)
    {
      NotificationChain msgs = null;
      if (sequenceElements != null)
        msgs = ((InternalEObject)sequenceElements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS, null, msgs);
      if (newSequenceElements != null)
        msgs = ((InternalEObject)newSequenceElements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS, null, msgs);
      msgs = basicSetSequenceElements(newSequenceElements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS, newSequenceElements, newSequenceElements));
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
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS:
        return basicSetSequenceElements(null, msgs);
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
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__IS_NEW:
        return isIsNew();
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS:
        return getSequenceElements();
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
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__IS_NEW:
        setIsNew((Boolean)newValue);
        return;
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS:
        setSequenceElements((SequenceElements)newValue);
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
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__IS_NEW:
        setIsNew(IS_NEW_EDEFAULT);
        return;
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS:
        setSequenceElements((SequenceElements)null);
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
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__IS_NEW:
        return isNew != IS_NEW_EDEFAULT;
      case AlfPackage.SEQUENCE_INITIALIZATION_EXPRESSION__SEQUENCE_ELEMENTS:
        return sequenceElements != null;
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
    result.append(" (isNew: ");
    result.append(isNew);
    result.append(')');
    return result.toString();
  }

} //SequenceInitializationExpressionImpl
