/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.SignalDeclaration;
import org.eclipse.papyrus.alf.alf.SignalDefinitionOrStub;
import org.eclipse.papyrus.alf.alf.StructuredBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SignalDefinitionOrStubImpl#getSignalDeclaration <em>Signal Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SignalDefinitionOrStubImpl#getStructuredBody <em>Structured Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements SignalDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getSignalDeclaration() <em>Signal Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignalDeclaration()
   * @generated
   * @ordered
   */
  protected SignalDeclaration signalDeclaration;

  /**
   * The cached value of the '{@link #getStructuredBody() <em>Structured Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructuredBody()
   * @generated
   * @ordered
   */
  protected StructuredBody structuredBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SignalDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getSignalDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDeclaration getSignalDeclaration()
  {
    return signalDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSignalDeclaration(SignalDeclaration newSignalDeclaration, NotificationChain msgs)
  {
    SignalDeclaration oldSignalDeclaration = signalDeclaration;
    signalDeclaration = newSignalDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION, oldSignalDeclaration, newSignalDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignalDeclaration(SignalDeclaration newSignalDeclaration)
  {
    if (newSignalDeclaration != signalDeclaration)
    {
      NotificationChain msgs = null;
      if (signalDeclaration != null)
        msgs = ((InternalEObject)signalDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION, null, msgs);
      if (newSignalDeclaration != null)
        msgs = ((InternalEObject)newSignalDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION, null, msgs);
      msgs = basicSetSignalDeclaration(newSignalDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION, newSignalDeclaration, newSignalDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructuredBody getStructuredBody()
  {
    return structuredBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStructuredBody(StructuredBody newStructuredBody, NotificationChain msgs)
  {
    StructuredBody oldStructuredBody = structuredBody;
    structuredBody = newStructuredBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY, oldStructuredBody, newStructuredBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStructuredBody(StructuredBody newStructuredBody)
  {
    if (newStructuredBody != structuredBody)
    {
      NotificationChain msgs = null;
      if (structuredBody != null)
        msgs = ((InternalEObject)structuredBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY, null, msgs);
      if (newStructuredBody != null)
        msgs = ((InternalEObject)newStructuredBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY, null, msgs);
      msgs = basicSetStructuredBody(newStructuredBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY, newStructuredBody, newStructuredBody));
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
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION:
        return basicSetSignalDeclaration(null, msgs);
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY:
        return basicSetStructuredBody(null, msgs);
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
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION:
        return getSignalDeclaration();
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY:
        return getStructuredBody();
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
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION:
        setSignalDeclaration((SignalDeclaration)newValue);
        return;
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY:
        setStructuredBody((StructuredBody)newValue);
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
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION:
        setSignalDeclaration((SignalDeclaration)null);
        return;
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY:
        setStructuredBody((StructuredBody)null);
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
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__SIGNAL_DECLARATION:
        return signalDeclaration != null;
      case AlfPackage.SIGNAL_DEFINITION_OR_STUB__STRUCTURED_BODY:
        return structuredBody != null;
    }
    return super.eIsSet(featureID);
  }

} //SignalDefinitionOrStubImpl
