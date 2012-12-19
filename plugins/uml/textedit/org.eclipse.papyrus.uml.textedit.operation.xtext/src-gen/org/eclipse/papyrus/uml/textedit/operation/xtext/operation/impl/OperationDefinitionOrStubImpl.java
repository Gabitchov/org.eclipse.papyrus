/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.alf.alf.Block;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDefinitionOrStubImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl.OperationDefinitionOrStubImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationDefinitionOrStubImpl extends MinimalEObjectImpl.Container implements OperationDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclaration()
   * @generated
   * @ordered
   */
  protected OperationDeclaration declaration;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected Block body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationDefinitionOrStubImpl()
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
    return OperationPackage.Literals.OPERATION_DEFINITION_OR_STUB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDeclaration getDeclaration()
  {
    return declaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclaration(OperationDeclaration newDeclaration, NotificationChain msgs)
  {
    OperationDeclaration oldDeclaration = declaration;
    declaration = newDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION, oldDeclaration, newDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclaration(OperationDeclaration newDeclaration)
  {
    if (newDeclaration != declaration)
    {
      NotificationChain msgs = null;
      if (declaration != null)
        msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION, null, msgs);
      if (newDeclaration != null)
        msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION, null, msgs);
      msgs = basicSetDeclaration(newDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION, newDeclaration, newDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(Block newBody, NotificationChain msgs)
  {
    Block oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(Block newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY, newBody, newBody));
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
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION:
        return basicSetDeclaration(null, msgs);
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY:
        return basicSetBody(null, msgs);
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
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION:
        return getDeclaration();
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY:
        return getBody();
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
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION:
        setDeclaration((OperationDeclaration)newValue);
        return;
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY:
        setBody((Block)newValue);
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
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION:
        setDeclaration((OperationDeclaration)null);
        return;
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY:
        setBody((Block)null);
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
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__DECLARATION:
        return declaration != null;
      case OperationPackage.OPERATION_DEFINITION_OR_STUB__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //OperationDefinitionOrStubImpl
