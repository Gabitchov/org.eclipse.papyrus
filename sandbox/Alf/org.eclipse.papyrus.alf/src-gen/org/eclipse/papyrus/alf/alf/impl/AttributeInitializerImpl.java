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
import org.eclipse.papyrus.alf.alf.AttributeInitializer;
import org.eclipse.papyrus.alf.alf.InitializationExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AttributeInitializerImpl#getInitializationExpression <em>Initialization Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeInitializerImpl extends MinimalEObjectImpl.Container implements AttributeInitializer
{
  /**
   * The cached value of the '{@link #getInitializationExpression() <em>Initialization Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializationExpression()
   * @generated
   * @ordered
   */
  protected InitializationExpression initializationExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeInitializerImpl()
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
    return AlfPackage.eINSTANCE.getAttributeInitializer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitializationExpression getInitializationExpression()
  {
    return initializationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitializationExpression(InitializationExpression newInitializationExpression, NotificationChain msgs)
  {
    InitializationExpression oldInitializationExpression = initializationExpression;
    initializationExpression = newInitializationExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION, oldInitializationExpression, newInitializationExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitializationExpression(InitializationExpression newInitializationExpression)
  {
    if (newInitializationExpression != initializationExpression)
    {
      NotificationChain msgs = null;
      if (initializationExpression != null)
        msgs = ((InternalEObject)initializationExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION, null, msgs);
      if (newInitializationExpression != null)
        msgs = ((InternalEObject)newInitializationExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION, null, msgs);
      msgs = basicSetInitializationExpression(newInitializationExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION, newInitializationExpression, newInitializationExpression));
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
      case AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION:
        return basicSetInitializationExpression(null, msgs);
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
      case AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION:
        return getInitializationExpression();
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
      case AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION:
        setInitializationExpression((InitializationExpression)newValue);
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
      case AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION:
        setInitializationExpression((InitializationExpression)null);
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
      case AlfPackage.ATTRIBUTE_INITIALIZER__INITIALIZATION_EXPRESSION:
        return initializationExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributeInitializerImpl
