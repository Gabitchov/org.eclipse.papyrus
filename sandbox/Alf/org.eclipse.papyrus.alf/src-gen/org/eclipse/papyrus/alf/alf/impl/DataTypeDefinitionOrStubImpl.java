/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.DataTypeDeclaration;
import org.eclipse.papyrus.alf.alf.DataTypeDefinitionOrStub;
import org.eclipse.papyrus.alf.alf.StructuredBody;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.DataTypeDefinitionOrStubImpl#getDataTypeDeclaration <em>Data Type Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.DataTypeDefinitionOrStubImpl#getStructureBody <em>Structure Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements DataTypeDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getDataTypeDeclaration() <em>Data Type Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataTypeDeclaration()
   * @generated
   * @ordered
   */
  protected DataTypeDeclaration dataTypeDeclaration;

  /**
   * The cached value of the '{@link #getStructureBody() <em>Structure Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructureBody()
   * @generated
   * @ordered
   */
  protected StructuredBody structureBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataTypeDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getDataTypeDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeDeclaration getDataTypeDeclaration()
  {
    return dataTypeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDataTypeDeclaration(DataTypeDeclaration newDataTypeDeclaration, NotificationChain msgs)
  {
    DataTypeDeclaration oldDataTypeDeclaration = dataTypeDeclaration;
    dataTypeDeclaration = newDataTypeDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION, oldDataTypeDeclaration, newDataTypeDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataTypeDeclaration(DataTypeDeclaration newDataTypeDeclaration)
  {
    if (newDataTypeDeclaration != dataTypeDeclaration)
    {
      NotificationChain msgs = null;
      if (dataTypeDeclaration != null)
        msgs = ((InternalEObject)dataTypeDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION, null, msgs);
      if (newDataTypeDeclaration != null)
        msgs = ((InternalEObject)newDataTypeDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION, null, msgs);
      msgs = basicSetDataTypeDeclaration(newDataTypeDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION, newDataTypeDeclaration, newDataTypeDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructuredBody getStructureBody()
  {
    return structureBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStructureBody(StructuredBody newStructureBody, NotificationChain msgs)
  {
    StructuredBody oldStructureBody = structureBody;
    structureBody = newStructureBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY, oldStructureBody, newStructureBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStructureBody(StructuredBody newStructureBody)
  {
    if (newStructureBody != structureBody)
    {
      NotificationChain msgs = null;
      if (structureBody != null)
        msgs = ((InternalEObject)structureBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY, null, msgs);
      if (newStructureBody != null)
        msgs = ((InternalEObject)newStructureBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY, null, msgs);
      msgs = basicSetStructureBody(newStructureBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY, newStructureBody, newStructureBody));
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
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION:
        return basicSetDataTypeDeclaration(null, msgs);
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY:
        return basicSetStructureBody(null, msgs);
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
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION:
        return getDataTypeDeclaration();
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY:
        return getStructureBody();
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
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION:
        setDataTypeDeclaration((DataTypeDeclaration)newValue);
        return;
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY:
        setStructureBody((StructuredBody)newValue);
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
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION:
        setDataTypeDeclaration((DataTypeDeclaration)null);
        return;
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY:
        setStructureBody((StructuredBody)null);
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
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__DATA_TYPE_DECLARATION:
        return dataTypeDeclaration != null;
      case AlfPackage.DATA_TYPE_DEFINITION_OR_STUB__STRUCTURE_BODY:
        return structureBody != null;
    }
    return super.eIsSet(featureID);
  }

} //DataTypeDefinitionOrStubImpl
