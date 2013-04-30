/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.ActivityDeclaration;
import org.eclipse.papyrus.alf.alf.ActivityDefinitionOrStub;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Block;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActivityDefinitionOrStubImpl#getActivityDeclaration <em>Activity Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ActivityDefinitionOrStubImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityDefinitionOrStubImpl extends ClassifierDefinitionOrStubImpl implements ActivityDefinitionOrStub
{
  /**
   * The cached value of the '{@link #getActivityDeclaration() <em>Activity Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivityDeclaration()
   * @generated
   * @ordered
   */
  protected ActivityDeclaration activityDeclaration;

  /**
   * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlock()
   * @generated
   * @ordered
   */
  protected Block block;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActivityDefinitionOrStubImpl()
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
    return AlfPackage.eINSTANCE.getActivityDefinitionOrStub();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityDeclaration getActivityDeclaration()
  {
    return activityDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActivityDeclaration(ActivityDeclaration newActivityDeclaration, NotificationChain msgs)
  {
    ActivityDeclaration oldActivityDeclaration = activityDeclaration;
    activityDeclaration = newActivityDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION, oldActivityDeclaration, newActivityDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivityDeclaration(ActivityDeclaration newActivityDeclaration)
  {
    if (newActivityDeclaration != activityDeclaration)
    {
      NotificationChain msgs = null;
      if (activityDeclaration != null)
        msgs = ((InternalEObject)activityDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION, null, msgs);
      if (newActivityDeclaration != null)
        msgs = ((InternalEObject)newActivityDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION, null, msgs);
      msgs = basicSetActivityDeclaration(newActivityDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION, newActivityDeclaration, newActivityDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getBlock()
  {
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs)
  {
    Block oldBlock = block;
    block = newBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK, oldBlock, newBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlock(Block newBlock)
  {
    if (newBlock != block)
    {
      NotificationChain msgs = null;
      if (block != null)
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK, newBlock, newBlock));
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
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION:
        return basicSetActivityDeclaration(null, msgs);
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK:
        return basicSetBlock(null, msgs);
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
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION:
        return getActivityDeclaration();
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK:
        return getBlock();
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
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION:
        setActivityDeclaration((ActivityDeclaration)newValue);
        return;
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK:
        setBlock((Block)newValue);
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
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION:
        setActivityDeclaration((ActivityDeclaration)null);
        return;
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK:
        setBlock((Block)null);
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
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__ACTIVITY_DECLARATION:
        return activityDeclaration != null;
      case AlfPackage.ACTIVITY_DEFINITION_OR_STUB__BLOCK:
        return block != null;
    }
    return super.eIsSet(featureID);
  }

} //ActivityDefinitionOrStubImpl
