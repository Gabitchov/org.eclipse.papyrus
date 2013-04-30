/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.EnumerationBody;
import org.eclipse.papyrus.alf.alf.EnumerationDeclaration;
import org.eclipse.papyrus.alf.alf.EnumerationDefinitionOrStub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.EnumerationDefinitionOrStubImpl#getEnumerationDeclaration <em>Enumeration Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.EnumerationDefinitionOrStubImpl#getEnumerationBody <em>Enumeration Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements EnumerationDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getEnumerationDeclaration() <em>Enumeration Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerationDeclaration()
   * @generated
   * @ordered
   */
  protected EnumerationDeclaration enumerationDeclaration;

  /**
   * The cached value of the '{@link #getEnumerationBody() <em>Enumeration Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerationBody()
   * @generated
   * @ordered
   */
  protected EnumerationBody enumerationBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumerationDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getEnumerationDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationDeclaration getEnumerationDeclaration()
  {
    return enumerationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnumerationDeclaration(EnumerationDeclaration newEnumerationDeclaration, NotificationChain msgs)
  {
    EnumerationDeclaration oldEnumerationDeclaration = enumerationDeclaration;
    enumerationDeclaration = newEnumerationDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION, oldEnumerationDeclaration, newEnumerationDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumerationDeclaration(EnumerationDeclaration newEnumerationDeclaration)
  {
    if (newEnumerationDeclaration != enumerationDeclaration)
    {
      NotificationChain msgs = null;
      if (enumerationDeclaration != null)
        msgs = ((InternalEObject)enumerationDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION, null, msgs);
      if (newEnumerationDeclaration != null)
        msgs = ((InternalEObject)newEnumerationDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION, null, msgs);
      msgs = basicSetEnumerationDeclaration(newEnumerationDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION, newEnumerationDeclaration, newEnumerationDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationBody getEnumerationBody()
  {
    return enumerationBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnumerationBody(EnumerationBody newEnumerationBody, NotificationChain msgs)
  {
    EnumerationBody oldEnumerationBody = enumerationBody;
    enumerationBody = newEnumerationBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY, oldEnumerationBody, newEnumerationBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumerationBody(EnumerationBody newEnumerationBody)
  {
    if (newEnumerationBody != enumerationBody)
    {
      NotificationChain msgs = null;
      if (enumerationBody != null)
        msgs = ((InternalEObject)enumerationBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY, null, msgs);
      if (newEnumerationBody != null)
        msgs = ((InternalEObject)newEnumerationBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY, null, msgs);
      msgs = basicSetEnumerationBody(newEnumerationBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY, newEnumerationBody, newEnumerationBody));
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
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION:
        return basicSetEnumerationDeclaration(null, msgs);
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY:
        return basicSetEnumerationBody(null, msgs);
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
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION:
        return getEnumerationDeclaration();
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY:
        return getEnumerationBody();
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
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION:
        setEnumerationDeclaration((EnumerationDeclaration)newValue);
        return;
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY:
        setEnumerationBody((EnumerationBody)newValue);
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
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION:
        setEnumerationDeclaration((EnumerationDeclaration)null);
        return;
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY:
        setEnumerationBody((EnumerationBody)null);
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
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_DECLARATION:
        return enumerationDeclaration != null;
      case AlfPackage.ENUMERATION_DEFINITION_OR_STUB__ENUMERATION_BODY:
        return enumerationBody != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumerationDefinitionOrStubImpl
