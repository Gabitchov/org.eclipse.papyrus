/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Index;
import org.eclipse.papyrus.alf.alf.IndexedNamedExpressionListCompletion;
import org.eclipse.papyrus.alf.alf.LinkOperationTuple;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.NameToExpressionCompletion;
import org.eclipse.papyrus.alf.alf.PositionalTupleExpressionList;
import org.eclipse.papyrus.alf.alf.PositionalTupleExpressionListCompletion;
import org.eclipse.papyrus.alf.alf.PrimaryToExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Operation Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getIndexNamedExpressionListCompletion <em>Index Named Expression List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getPrimaryToExpressionCompletion <em>Primary To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getPositionalTupleExpressionListCompletion <em>Positional Tuple Expression List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getIndexedNamedExpressionListCompletion <em>Indexed Named Expression List Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getNameToExpressionCompletion <em>Name To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LinkOperationTupleImpl#getPositionalTupleExpressionList <em>Positional Tuple Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkOperationTupleImpl extends MinimalEObjectImpl.Container implements LinkOperationTuple
{
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
   * The cached value of the '{@link #getIndex() <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected Index index;

  /**
   * The cached value of the '{@link #getIndexNamedExpressionListCompletion() <em>Index Named Expression List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexNamedExpressionListCompletion()
   * @generated
   * @ordered
   */
  protected IndexedNamedExpressionListCompletion indexNamedExpressionListCompletion;

  /**
   * The cached value of the '{@link #getPrimaryToExpressionCompletion() <em>Primary To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimaryToExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PrimaryToExpressionCompletion primaryToExpressionCompletion;

  /**
   * The cached value of the '{@link #getPositionalTupleExpressionListCompletion() <em>Positional Tuple Expression List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPositionalTupleExpressionListCompletion()
   * @generated
   * @ordered
   */
  protected PositionalTupleExpressionListCompletion positionalTupleExpressionListCompletion;

  /**
   * The cached value of the '{@link #getIndexedNamedExpressionListCompletion() <em>Indexed Named Expression List Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexedNamedExpressionListCompletion()
   * @generated
   * @ordered
   */
  protected IndexedNamedExpressionListCompletion indexedNamedExpressionListCompletion;

  /**
   * The cached value of the '{@link #getNameToExpressionCompletion() <em>Name To Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameToExpressionCompletion()
   * @generated
   * @ordered
   */
  protected NameToExpressionCompletion nameToExpressionCompletion;

  /**
   * The cached value of the '{@link #getPositionalTupleExpressionList() <em>Positional Tuple Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPositionalTupleExpressionList()
   * @generated
   * @ordered
   */
  protected PositionalTupleExpressionList positionalTupleExpressionList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkOperationTupleImpl()
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
    return AlfPackage.eINSTANCE.getLinkOperationTuple();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Index getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndex(Index newIndex, NotificationChain msgs)
  {
    Index oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__INDEX, oldIndex, newIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(Index newIndex)
  {
    if (newIndex != index)
    {
      NotificationChain msgs = null;
      if (index != null)
        msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__INDEX, null, msgs);
      if (newIndex != null)
        msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__INDEX, null, msgs);
      msgs = basicSetIndex(newIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__INDEX, newIndex, newIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexedNamedExpressionListCompletion getIndexNamedExpressionListCompletion()
  {
    return indexNamedExpressionListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndexNamedExpressionListCompletion(IndexedNamedExpressionListCompletion newIndexNamedExpressionListCompletion, NotificationChain msgs)
  {
    IndexedNamedExpressionListCompletion oldIndexNamedExpressionListCompletion = indexNamedExpressionListCompletion;
    indexNamedExpressionListCompletion = newIndexNamedExpressionListCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION, oldIndexNamedExpressionListCompletion, newIndexNamedExpressionListCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndexNamedExpressionListCompletion(IndexedNamedExpressionListCompletion newIndexNamedExpressionListCompletion)
  {
    if (newIndexNamedExpressionListCompletion != indexNamedExpressionListCompletion)
    {
      NotificationChain msgs = null;
      if (indexNamedExpressionListCompletion != null)
        msgs = ((InternalEObject)indexNamedExpressionListCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION, null, msgs);
      if (newIndexNamedExpressionListCompletion != null)
        msgs = ((InternalEObject)newIndexNamedExpressionListCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION, null, msgs);
      msgs = basicSetIndexNamedExpressionListCompletion(newIndexNamedExpressionListCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION, newIndexNamedExpressionListCompletion, newIndexNamedExpressionListCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryToExpressionCompletion getPrimaryToExpressionCompletion()
  {
    return primaryToExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryToExpressionCompletion(PrimaryToExpressionCompletion newPrimaryToExpressionCompletion, NotificationChain msgs)
  {
    PrimaryToExpressionCompletion oldPrimaryToExpressionCompletion = primaryToExpressionCompletion;
    primaryToExpressionCompletion = newPrimaryToExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION, oldPrimaryToExpressionCompletion, newPrimaryToExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimaryToExpressionCompletion(PrimaryToExpressionCompletion newPrimaryToExpressionCompletion)
  {
    if (newPrimaryToExpressionCompletion != primaryToExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (primaryToExpressionCompletion != null)
        msgs = ((InternalEObject)primaryToExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION, null, msgs);
      if (newPrimaryToExpressionCompletion != null)
        msgs = ((InternalEObject)newPrimaryToExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPrimaryToExpressionCompletion(newPrimaryToExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION, newPrimaryToExpressionCompletion, newPrimaryToExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositionalTupleExpressionListCompletion getPositionalTupleExpressionListCompletion()
  {
    return positionalTupleExpressionListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPositionalTupleExpressionListCompletion(PositionalTupleExpressionListCompletion newPositionalTupleExpressionListCompletion, NotificationChain msgs)
  {
    PositionalTupleExpressionListCompletion oldPositionalTupleExpressionListCompletion = positionalTupleExpressionListCompletion;
    positionalTupleExpressionListCompletion = newPositionalTupleExpressionListCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION, oldPositionalTupleExpressionListCompletion, newPositionalTupleExpressionListCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPositionalTupleExpressionListCompletion(PositionalTupleExpressionListCompletion newPositionalTupleExpressionListCompletion)
  {
    if (newPositionalTupleExpressionListCompletion != positionalTupleExpressionListCompletion)
    {
      NotificationChain msgs = null;
      if (positionalTupleExpressionListCompletion != null)
        msgs = ((InternalEObject)positionalTupleExpressionListCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION, null, msgs);
      if (newPositionalTupleExpressionListCompletion != null)
        msgs = ((InternalEObject)newPositionalTupleExpressionListCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION, null, msgs);
      msgs = basicSetPositionalTupleExpressionListCompletion(newPositionalTupleExpressionListCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION, newPositionalTupleExpressionListCompletion, newPositionalTupleExpressionListCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexedNamedExpressionListCompletion getIndexedNamedExpressionListCompletion()
  {
    return indexedNamedExpressionListCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndexedNamedExpressionListCompletion(IndexedNamedExpressionListCompletion newIndexedNamedExpressionListCompletion, NotificationChain msgs)
  {
    IndexedNamedExpressionListCompletion oldIndexedNamedExpressionListCompletion = indexedNamedExpressionListCompletion;
    indexedNamedExpressionListCompletion = newIndexedNamedExpressionListCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION, oldIndexedNamedExpressionListCompletion, newIndexedNamedExpressionListCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndexedNamedExpressionListCompletion(IndexedNamedExpressionListCompletion newIndexedNamedExpressionListCompletion)
  {
    if (newIndexedNamedExpressionListCompletion != indexedNamedExpressionListCompletion)
    {
      NotificationChain msgs = null;
      if (indexedNamedExpressionListCompletion != null)
        msgs = ((InternalEObject)indexedNamedExpressionListCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION, null, msgs);
      if (newIndexedNamedExpressionListCompletion != null)
        msgs = ((InternalEObject)newIndexedNamedExpressionListCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION, null, msgs);
      msgs = basicSetIndexedNamedExpressionListCompletion(newIndexedNamedExpressionListCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION, newIndexedNamedExpressionListCompletion, newIndexedNamedExpressionListCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameToExpressionCompletion getNameToExpressionCompletion()
  {
    return nameToExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameToExpressionCompletion(NameToExpressionCompletion newNameToExpressionCompletion, NotificationChain msgs)
  {
    NameToExpressionCompletion oldNameToExpressionCompletion = nameToExpressionCompletion;
    nameToExpressionCompletion = newNameToExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION, oldNameToExpressionCompletion, newNameToExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameToExpressionCompletion(NameToExpressionCompletion newNameToExpressionCompletion)
  {
    if (newNameToExpressionCompletion != nameToExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (nameToExpressionCompletion != null)
        msgs = ((InternalEObject)nameToExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION, null, msgs);
      if (newNameToExpressionCompletion != null)
        msgs = ((InternalEObject)newNameToExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetNameToExpressionCompletion(newNameToExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION, newNameToExpressionCompletion, newNameToExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositionalTupleExpressionList getPositionalTupleExpressionList()
  {
    return positionalTupleExpressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPositionalTupleExpressionList(PositionalTupleExpressionList newPositionalTupleExpressionList, NotificationChain msgs)
  {
    PositionalTupleExpressionList oldPositionalTupleExpressionList = positionalTupleExpressionList;
    positionalTupleExpressionList = newPositionalTupleExpressionList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, oldPositionalTupleExpressionList, newPositionalTupleExpressionList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPositionalTupleExpressionList(PositionalTupleExpressionList newPositionalTupleExpressionList)
  {
    if (newPositionalTupleExpressionList != positionalTupleExpressionList)
    {
      NotificationChain msgs = null;
      if (positionalTupleExpressionList != null)
        msgs = ((InternalEObject)positionalTupleExpressionList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, null, msgs);
      if (newPositionalTupleExpressionList != null)
        msgs = ((InternalEObject)newPositionalTupleExpressionList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, null, msgs);
      msgs = basicSetPositionalTupleExpressionList(newPositionalTupleExpressionList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST, newPositionalTupleExpressionList, newPositionalTupleExpressionList));
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
      case AlfPackage.LINK_OPERATION_TUPLE__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX:
        return basicSetIndex(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION:
        return basicSetIndexNamedExpressionListCompletion(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION:
        return basicSetPrimaryToExpressionCompletion(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION:
        return basicSetPositionalTupleExpressionListCompletion(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION:
        return basicSetIndexedNamedExpressionListCompletion(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION:
        return basicSetNameToExpressionCompletion(null, msgs);
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        return basicSetPositionalTupleExpressionList(null, msgs);
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
      case AlfPackage.LINK_OPERATION_TUPLE__NAME:
        return getName();
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX:
        return getIndex();
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION:
        return getIndexNamedExpressionListCompletion();
      case AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION:
        return getPrimaryToExpressionCompletion();
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION:
        return getPositionalTupleExpressionListCompletion();
      case AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION:
        return getIndexedNamedExpressionListCompletion();
      case AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION:
        return getNameToExpressionCompletion();
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        return getPositionalTupleExpressionList();
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
      case AlfPackage.LINK_OPERATION_TUPLE__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX:
        setIndex((Index)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION:
        setIndexNamedExpressionListCompletion((IndexedNamedExpressionListCompletion)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION:
        setPrimaryToExpressionCompletion((PrimaryToExpressionCompletion)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION:
        setPositionalTupleExpressionListCompletion((PositionalTupleExpressionListCompletion)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION:
        setIndexedNamedExpressionListCompletion((IndexedNamedExpressionListCompletion)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION:
        setNameToExpressionCompletion((NameToExpressionCompletion)newValue);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        setPositionalTupleExpressionList((PositionalTupleExpressionList)newValue);
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
      case AlfPackage.LINK_OPERATION_TUPLE__NAME:
        setName((Name)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX:
        setIndex((Index)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION:
        setIndexNamedExpressionListCompletion((IndexedNamedExpressionListCompletion)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION:
        setPrimaryToExpressionCompletion((PrimaryToExpressionCompletion)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION:
        setPositionalTupleExpressionListCompletion((PositionalTupleExpressionListCompletion)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION:
        setIndexedNamedExpressionListCompletion((IndexedNamedExpressionListCompletion)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION:
        setNameToExpressionCompletion((NameToExpressionCompletion)null);
        return;
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        setPositionalTupleExpressionList((PositionalTupleExpressionList)null);
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
      case AlfPackage.LINK_OPERATION_TUPLE__NAME:
        return name != null;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX:
        return index != null;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEX_NAMED_EXPRESSION_LIST_COMPLETION:
        return indexNamedExpressionListCompletion != null;
      case AlfPackage.LINK_OPERATION_TUPLE__PRIMARY_TO_EXPRESSION_COMPLETION:
        return primaryToExpressionCompletion != null;
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST_COMPLETION:
        return positionalTupleExpressionListCompletion != null;
      case AlfPackage.LINK_OPERATION_TUPLE__INDEXED_NAMED_EXPRESSION_LIST_COMPLETION:
        return indexedNamedExpressionListCompletion != null;
      case AlfPackage.LINK_OPERATION_TUPLE__NAME_TO_EXPRESSION_COMPLETION:
        return nameToExpressionCompletion != null;
      case AlfPackage.LINK_OPERATION_TUPLE__POSITIONAL_TUPLE_EXPRESSION_LIST:
        return positionalTupleExpressionList != null;
    }
    return super.eIsSet(featureID);
  }

} //LinkOperationTupleImpl
