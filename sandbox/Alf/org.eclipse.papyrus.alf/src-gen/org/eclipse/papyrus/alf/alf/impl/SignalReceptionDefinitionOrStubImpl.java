/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.SignalReceptionDeclaration;
import org.eclipse.papyrus.alf.alf.SignalReceptionDefinitionOrStub;
import org.eclipse.papyrus.alf.alf.StructuredBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal Reception Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SignalReceptionDefinitionOrStubImpl#getSignalReceptionOrDeclaration <em>Signal Reception Or Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SignalReceptionDefinitionOrStubImpl#getStructuredBody <em>Structured Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalReceptionDefinitionOrStubImpl extends ActiveFeatureDefinitionOrStubImpl implements SignalReceptionDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getSignalReceptionOrDeclaration() <em>Signal Reception Or Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignalReceptionOrDeclaration()
   * @generated
   * @ordered
   */
  protected SignalReceptionDeclaration signalReceptionOrDeclaration;

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
  protected SignalReceptionDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getSignalReceptionDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalReceptionDeclaration getSignalReceptionOrDeclaration()
  {
    return signalReceptionOrDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSignalReceptionOrDeclaration(SignalReceptionDeclaration newSignalReceptionOrDeclaration, NotificationChain msgs)
  {
    SignalReceptionDeclaration oldSignalReceptionOrDeclaration = signalReceptionOrDeclaration;
    signalReceptionOrDeclaration = newSignalReceptionOrDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION, oldSignalReceptionOrDeclaration, newSignalReceptionOrDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignalReceptionOrDeclaration(SignalReceptionDeclaration newSignalReceptionOrDeclaration)
  {
    if (newSignalReceptionOrDeclaration != signalReceptionOrDeclaration)
    {
      NotificationChain msgs = null;
      if (signalReceptionOrDeclaration != null)
        msgs = ((InternalEObject)signalReceptionOrDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION, null, msgs);
      if (newSignalReceptionOrDeclaration != null)
        msgs = ((InternalEObject)newSignalReceptionOrDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION, null, msgs);
      msgs = basicSetSignalReceptionOrDeclaration(newSignalReceptionOrDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION, newSignalReceptionOrDeclaration, newSignalReceptionOrDeclaration));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY, oldStructuredBody, newStructuredBody);
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
        msgs = ((InternalEObject)structuredBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY, null, msgs);
      if (newStructuredBody != null)
        msgs = ((InternalEObject)newStructuredBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY, null, msgs);
      msgs = basicSetStructuredBody(newStructuredBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY, newStructuredBody, newStructuredBody));
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
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION:
        return basicSetSignalReceptionOrDeclaration(null, msgs);
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION:
        return getSignalReceptionOrDeclaration();
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION:
        setSignalReceptionOrDeclaration((SignalReceptionDeclaration)newValue);
        return;
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION:
        setSignalReceptionOrDeclaration((SignalReceptionDeclaration)null);
        return;
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__SIGNAL_RECEPTION_OR_DECLARATION:
        return signalReceptionOrDeclaration != null;
      case AlfPackage.SIGNAL_RECEPTION_DEFINITION_OR_STUB__STRUCTURED_BODY:
        return structuredBody != null;
    }
    return super.eIsSet(featureID);
  }

} //SignalReceptionDefinitionOrStubImpl
