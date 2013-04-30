/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.PackageBody;
import org.eclipse.papyrus.alf.alf.PackageDeclaration;
import org.eclipse.papyrus.alf.alf.PackageDefinitionOrStub;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackageDefinitionOrStubImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackageDefinitionOrStubImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageDefinitionOrStubImpl extends PackagedElementDefinitionImpl implements PackageDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclaration()
   * @generated
   * @ordered
   */
  protected PackageDeclaration declaration;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected PackageBody body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getPackageDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration getDeclaration()
  {
    return declaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclaration(PackageDeclaration newDeclaration, NotificationChain msgs)
  {
    PackageDeclaration oldDeclaration = declaration;
    declaration = newDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION, oldDeclaration, newDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclaration(PackageDeclaration newDeclaration)
  {
    if (newDeclaration != declaration)
    {
      NotificationChain msgs = null;
      if (declaration != null)
        msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION, null, msgs);
      if (newDeclaration != null)
        msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION, null, msgs);
      msgs = basicSetDeclaration(newDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION, newDeclaration, newDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageBody getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(PackageBody newBody, NotificationChain msgs)
  {
    PackageBody oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(PackageBody newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY, newBody, newBody));
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
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION:
        return basicSetDeclaration(null, msgs);
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY:
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
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION:
        return getDeclaration();
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY:
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
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION:
        setDeclaration((PackageDeclaration)newValue);
        return;
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY:
        setBody((PackageBody)newValue);
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
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION:
        setDeclaration((PackageDeclaration)null);
        return;
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY:
        setBody((PackageBody)null);
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
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__DECLARATION:
        return declaration != null;
      case AlfPackage.PACKAGE_DEFINITION_OR_STUB__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //PackageDefinitionOrStubImpl
