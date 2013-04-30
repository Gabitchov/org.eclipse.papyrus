/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.ActiveClassBody;
import org.eclipse.papyrus.alf.alf.ActiveClassDeclaration;
import org.eclipse.papyrus.alf.alf.ActiveClassDefinitionOrStub;
import org.eclipse.papyrus.alf.alf.AlfPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Class Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActiveClassDefinitionOrStubImpl#getActiveClassDeclaration <em>Active Class Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActiveClassDefinitionOrStubImpl#getActiveClassBody <em>Active Class Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveClassDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements ActiveClassDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getActiveClassDeclaration() <em>Active Class Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActiveClassDeclaration()
   * @generated
   * @ordered
   */
  protected ActiveClassDeclaration activeClassDeclaration;

  /**
   * The cached value of the '{@link #getActiveClassBody() <em>Active Class Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActiveClassBody()
   * @generated
   * @ordered
   */
  protected ActiveClassBody activeClassBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActiveClassDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getActiveClassDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassDeclaration getActiveClassDeclaration()
  {
    return activeClassDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActiveClassDeclaration(ActiveClassDeclaration newActiveClassDeclaration, NotificationChain msgs)
  {
    ActiveClassDeclaration oldActiveClassDeclaration = activeClassDeclaration;
    activeClassDeclaration = newActiveClassDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION, oldActiveClassDeclaration, newActiveClassDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActiveClassDeclaration(ActiveClassDeclaration newActiveClassDeclaration)
  {
    if (newActiveClassDeclaration != activeClassDeclaration)
    {
      NotificationChain msgs = null;
      if (activeClassDeclaration != null)
        msgs = ((InternalEObject)activeClassDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION, null, msgs);
      if (newActiveClassDeclaration != null)
        msgs = ((InternalEObject)newActiveClassDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION, null, msgs);
      msgs = basicSetActiveClassDeclaration(newActiveClassDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION, newActiveClassDeclaration, newActiveClassDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveClassBody getActiveClassBody()
  {
    return activeClassBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActiveClassBody(ActiveClassBody newActiveClassBody, NotificationChain msgs)
  {
    ActiveClassBody oldActiveClassBody = activeClassBody;
    activeClassBody = newActiveClassBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY, oldActiveClassBody, newActiveClassBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActiveClassBody(ActiveClassBody newActiveClassBody)
  {
    if (newActiveClassBody != activeClassBody)
    {
      NotificationChain msgs = null;
      if (activeClassBody != null)
        msgs = ((InternalEObject)activeClassBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY, null, msgs);
      if (newActiveClassBody != null)
        msgs = ((InternalEObject)newActiveClassBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY, null, msgs);
      msgs = basicSetActiveClassBody(newActiveClassBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY, newActiveClassBody, newActiveClassBody));
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
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION:
        return basicSetActiveClassDeclaration(null, msgs);
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY:
        return basicSetActiveClassBody(null, msgs);
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
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION:
        return getActiveClassDeclaration();
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY:
        return getActiveClassBody();
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
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION:
        setActiveClassDeclaration((ActiveClassDeclaration)newValue);
        return;
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY:
        setActiveClassBody((ActiveClassBody)newValue);
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
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION:
        setActiveClassDeclaration((ActiveClassDeclaration)null);
        return;
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY:
        setActiveClassBody((ActiveClassBody)null);
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
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_DECLARATION:
        return activeClassDeclaration != null;
      case AlfPackage.ACTIVE_CLASS_DEFINITION_OR_STUB__ACTIVE_CLASS_BODY:
        return activeClassBody != null;
    }
    return super.eIsSet(featureID);
  }

} //ActiveClassDefinitionOrStubImpl
