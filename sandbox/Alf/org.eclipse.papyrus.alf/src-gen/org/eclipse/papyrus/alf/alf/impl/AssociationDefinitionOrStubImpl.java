/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AssociationDeclaration;
import org.eclipse.papyrus.alf.alf.AssociationDefinitionOrStub;
import org.eclipse.papyrus.alf.alf.StructuredBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AssociationDefinitionOrStubImpl#getAssociationDeclaration <em>Association Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AssociationDefinitionOrStubImpl#getStructuredBody <em>Structured Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements AssociationDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getAssociationDeclaration() <em>Association Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationDeclaration()
   * @generated
   * @ordered
   */
  protected AssociationDeclaration associationDeclaration;

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
  protected AssociationDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getAssociationDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationDeclaration getAssociationDeclaration()
  {
    return associationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssociationDeclaration(AssociationDeclaration newAssociationDeclaration, NotificationChain msgs)
  {
    AssociationDeclaration oldAssociationDeclaration = associationDeclaration;
    associationDeclaration = newAssociationDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION, oldAssociationDeclaration, newAssociationDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssociationDeclaration(AssociationDeclaration newAssociationDeclaration)
  {
    if (newAssociationDeclaration != associationDeclaration)
    {
      NotificationChain msgs = null;
      if (associationDeclaration != null)
        msgs = ((InternalEObject)associationDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION, null, msgs);
      if (newAssociationDeclaration != null)
        msgs = ((InternalEObject)newAssociationDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION, null, msgs);
      msgs = basicSetAssociationDeclaration(newAssociationDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION, newAssociationDeclaration, newAssociationDeclaration));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY, oldStructuredBody, newStructuredBody);
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
        msgs = ((InternalEObject)structuredBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY, null, msgs);
      if (newStructuredBody != null)
        msgs = ((InternalEObject)newStructuredBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY, null, msgs);
      msgs = basicSetStructuredBody(newStructuredBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY, newStructuredBody, newStructuredBody));
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
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION:
        return basicSetAssociationDeclaration(null, msgs);
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION:
        return getAssociationDeclaration();
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION:
        setAssociationDeclaration((AssociationDeclaration)newValue);
        return;
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION:
        setAssociationDeclaration((AssociationDeclaration)null);
        return;
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY:
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
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__ASSOCIATION_DECLARATION:
        return associationDeclaration != null;
      case AlfPackage.ASSOCIATION_DEFINITION_OR_STUB__STRUCTURED_BODY:
        return structuredBody != null;
    }
    return super.eIsSet(featureID);
  }

} //AssociationDefinitionOrStubImpl
