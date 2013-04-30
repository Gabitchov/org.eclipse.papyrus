/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AcceptBlock;
import org.eclipse.papyrus.alf.alf.AcceptClause;
import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Block;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accept Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptBlockImpl#getAcceptClause <em>Accept Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AcceptBlockImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AcceptBlockImpl extends MinimalEObjectImpl.Container implements AcceptBlock
{
  /**
   * The cached value of the '{@link #getAcceptClause() <em>Accept Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAcceptClause()
   * @generated
   * @ordered
   */
  protected AcceptClause acceptClause;

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
  protected AcceptBlockImpl()
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
    return AlfPackage.eINSTANCE.getAcceptBlock();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AcceptClause getAcceptClause()
  {
    return acceptClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAcceptClause(AcceptClause newAcceptClause, NotificationChain msgs)
  {
    AcceptClause oldAcceptClause = acceptClause;
    acceptClause = newAcceptClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE, oldAcceptClause, newAcceptClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAcceptClause(AcceptClause newAcceptClause)
  {
    if (newAcceptClause != acceptClause)
    {
      NotificationChain msgs = null;
      if (acceptClause != null)
        msgs = ((InternalEObject)acceptClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE, null, msgs);
      if (newAcceptClause != null)
        msgs = ((InternalEObject)newAcceptClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE, null, msgs);
      msgs = basicSetAcceptClause(newAcceptClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE, newAcceptClause, newAcceptClause));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_BLOCK__BLOCK, oldBlock, newBlock);
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
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_BLOCK__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ACCEPT_BLOCK__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ACCEPT_BLOCK__BLOCK, newBlock, newBlock));
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
      case AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE:
        return basicSetAcceptClause(null, msgs);
      case AlfPackage.ACCEPT_BLOCK__BLOCK:
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
      case AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE:
        return getAcceptClause();
      case AlfPackage.ACCEPT_BLOCK__BLOCK:
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
      case AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE:
        setAcceptClause((AcceptClause)newValue);
        return;
      case AlfPackage.ACCEPT_BLOCK__BLOCK:
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
      case AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE:
        setAcceptClause((AcceptClause)null);
        return;
      case AlfPackage.ACCEPT_BLOCK__BLOCK:
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
      case AlfPackage.ACCEPT_BLOCK__ACCEPT_CLAUSE:
        return acceptClause != null;
      case AlfPackage.ACCEPT_BLOCK__BLOCK:
        return block != null;
    }
    return super.eIsSet(featureID);
  }

} //AcceptBlockImpl
