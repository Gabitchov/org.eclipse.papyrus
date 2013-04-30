/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Block;
import org.eclipse.papyrus.alf.alf.FormalParameters;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.OperationDeclaration;
import org.eclipse.papyrus.alf.alf.RedefinitionClause;
import org.eclipse.papyrus.alf.alf.TypePart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.OperationDeclarationImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.OperationDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.OperationDeclarationImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.OperationDeclarationImpl#getTypePart <em>Type Part</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.OperationDeclarationImpl#getRedefinitionClause <em>Redefinition Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.OperationDeclarationImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationDeclarationImpl extends OperationDefinitionOrStubImpl implements OperationDeclaration
{
  /**
   * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean IS_ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsAbstract()
   * @generated
   * @ordered
   */
  protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParameters()
   * @generated
   * @ordered
   */
  protected FormalParameters formalParameters;

  /**
   * The cached value of the '{@link #getTypePart() <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePart()
   * @generated
   * @ordered
   */
  protected TypePart typePart;

  /**
   * The cached value of the '{@link #getRedefinitionClause() <em>Redefinition Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedefinitionClause()
   * @generated
   * @ordered
   */
  protected RedefinitionClause redefinitionClause;

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
  protected OperationDeclarationImpl()
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
    return AlfPackage.eINSTANCE.getOperationDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsAbstract()
  {
    return isAbstract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsAbstract(boolean newIsAbstract)
  {
    boolean oldIsAbstract = isAbstract;
    isAbstract = newIsAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__IS_ABSTRACT, oldIsAbstract, isAbstract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Name newName, NotificationChain msgs)
  {
    Name oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Name newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameters getFormalParameters()
  {
    return formalParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormalParameters(FormalParameters newFormalParameters, NotificationChain msgs)
  {
    FormalParameters oldFormalParameters = formalParameters;
    formalParameters = newFormalParameters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, oldFormalParameters, newFormalParameters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalParameters(FormalParameters newFormalParameters)
  {
    if (newFormalParameters != formalParameters)
    {
      NotificationChain msgs = null;
      if (formalParameters != null)
        msgs = ((InternalEObject)formalParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, null, msgs);
      if (newFormalParameters != null)
        msgs = ((InternalEObject)newFormalParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, null, msgs);
      msgs = basicSetFormalParameters(newFormalParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS, newFormalParameters, newFormalParameters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart getTypePart()
  {
    return typePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePart(TypePart newTypePart, NotificationChain msgs)
  {
    TypePart oldTypePart = typePart;
    typePart = newTypePart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__TYPE_PART, oldTypePart, newTypePart);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePart(TypePart newTypePart)
  {
    if (newTypePart != typePart)
    {
      NotificationChain msgs = null;
      if (typePart != null)
        msgs = ((InternalEObject)typePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__TYPE_PART, null, msgs);
      if (newTypePart != null)
        msgs = ((InternalEObject)newTypePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__TYPE_PART, null, msgs);
      msgs = basicSetTypePart(newTypePart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__TYPE_PART, newTypePart, newTypePart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RedefinitionClause getRedefinitionClause()
  {
    return redefinitionClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRedefinitionClause(RedefinitionClause newRedefinitionClause, NotificationChain msgs)
  {
    RedefinitionClause oldRedefinitionClause = redefinitionClause;
    redefinitionClause = newRedefinitionClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE, oldRedefinitionClause, newRedefinitionClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedefinitionClause(RedefinitionClause newRedefinitionClause)
  {
    if (newRedefinitionClause != redefinitionClause)
    {
      NotificationChain msgs = null;
      if (redefinitionClause != null)
        msgs = ((InternalEObject)redefinitionClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE, null, msgs);
      if (newRedefinitionClause != null)
        msgs = ((InternalEObject)newRedefinitionClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE, null, msgs);
      msgs = basicSetRedefinitionClause(newRedefinitionClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE, newRedefinitionClause, newRedefinitionClause));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__BLOCK, oldBlock, newBlock);
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
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.OPERATION_DECLARATION__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.OPERATION_DECLARATION__BLOCK, newBlock, newBlock));
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
      case AlfPackage.OPERATION_DECLARATION__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        return basicSetFormalParameters(null, msgs);
      case AlfPackage.OPERATION_DECLARATION__TYPE_PART:
        return basicSetTypePart(null, msgs);
      case AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE:
        return basicSetRedefinitionClause(null, msgs);
      case AlfPackage.OPERATION_DECLARATION__BLOCK:
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
      case AlfPackage.OPERATION_DECLARATION__IS_ABSTRACT:
        return isIsAbstract();
      case AlfPackage.OPERATION_DECLARATION__NAME:
        return getName();
      case AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        return getFormalParameters();
      case AlfPackage.OPERATION_DECLARATION__TYPE_PART:
        return getTypePart();
      case AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE:
        return getRedefinitionClause();
      case AlfPackage.OPERATION_DECLARATION__BLOCK:
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
      case AlfPackage.OPERATION_DECLARATION__IS_ABSTRACT:
        setIsAbstract((Boolean)newValue);
        return;
      case AlfPackage.OPERATION_DECLARATION__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)newValue);
        return;
      case AlfPackage.OPERATION_DECLARATION__TYPE_PART:
        setTypePart((TypePart)newValue);
        return;
      case AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE:
        setRedefinitionClause((RedefinitionClause)newValue);
        return;
      case AlfPackage.OPERATION_DECLARATION__BLOCK:
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
      case AlfPackage.OPERATION_DECLARATION__IS_ABSTRACT:
        setIsAbstract(IS_ABSTRACT_EDEFAULT);
        return;
      case AlfPackage.OPERATION_DECLARATION__NAME:
        setName((Name)null);
        return;
      case AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        setFormalParameters((FormalParameters)null);
        return;
      case AlfPackage.OPERATION_DECLARATION__TYPE_PART:
        setTypePart((TypePart)null);
        return;
      case AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE:
        setRedefinitionClause((RedefinitionClause)null);
        return;
      case AlfPackage.OPERATION_DECLARATION__BLOCK:
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
      case AlfPackage.OPERATION_DECLARATION__IS_ABSTRACT:
        return isAbstract != IS_ABSTRACT_EDEFAULT;
      case AlfPackage.OPERATION_DECLARATION__NAME:
        return name != null;
      case AlfPackage.OPERATION_DECLARATION__FORMAL_PARAMETERS:
        return formalParameters != null;
      case AlfPackage.OPERATION_DECLARATION__TYPE_PART:
        return typePart != null;
      case AlfPackage.OPERATION_DECLARATION__REDEFINITION_CLAUSE:
        return redefinitionClause != null;
      case AlfPackage.OPERATION_DECLARATION__BLOCK:
        return block != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (isAbstract: ");
    result.append(isAbstract);
    result.append(')');
    return result.toString();
  }

} //OperationDeclarationImpl
