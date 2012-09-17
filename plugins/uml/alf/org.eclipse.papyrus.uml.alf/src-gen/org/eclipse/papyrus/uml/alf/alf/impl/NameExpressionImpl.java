/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNamePath;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionOrAccessCompletion;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;
import org.eclipse.papyrus.uml.alf.alf.Tuple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getPrefixOp <em>Prefix Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getInvocationCompletion <em>Invocation Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getSequenceConstructionCompletion <em>Sequence Construction Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getPostfixOp <em>Postfix Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.NameExpressionImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameExpressionImpl extends ValueSpecificationImpl implements NameExpression
{
  /**
   * The default value of the '{@link #getPrefixOp() <em>Prefix Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefixOp()
   * @generated
   * @ordered
   */
  protected static final String PREFIX_OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPrefixOp() <em>Prefix Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefixOp()
   * @generated
   * @ordered
   */
  protected String prefixOp = PREFIX_OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected QualifiedNamePath path;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getInvocationCompletion() <em>Invocation Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvocationCompletion()
   * @generated
   * @ordered
   */
  protected Tuple invocationCompletion;

  /**
   * The cached value of the '{@link #getSequenceConstructionCompletion() <em>Sequence Construction Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceConstructionCompletion()
   * @generated
   * @ordered
   */
  protected SequenceConstructionOrAccessCompletion sequenceConstructionCompletion;

  /**
   * The default value of the '{@link #getPostfixOp() <em>Postfix Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixOp()
   * @generated
   * @ordered
   */
  protected static final String POSTFIX_OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPostfixOp() <em>Postfix Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixOp()
   * @generated
   * @ordered
   */
  protected String postfixOp = POSTFIX_OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuffix()
   * @generated
   * @ordered
   */
  protected SuffixExpression suffix;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameExpressionImpl()
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
    return AlfPackage.Literals.NAME_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPrefixOp()
  {
    return prefixOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrefixOp(String newPrefixOp)
  {
    String oldPrefixOp = prefixOp;
    prefixOp = newPrefixOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__PREFIX_OP, oldPrefixOp, prefixOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNamePath getPath()
  {
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(QualifiedNamePath newPath, NotificationChain msgs)
  {
    QualifiedNamePath oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPath(QualifiedNamePath newPath)
  {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__PATH, newPath, newPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple getInvocationCompletion()
  {
    return invocationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvocationCompletion(Tuple newInvocationCompletion, NotificationChain msgs)
  {
    Tuple oldInvocationCompletion = invocationCompletion;
    invocationCompletion = newInvocationCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION, oldInvocationCompletion, newInvocationCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvocationCompletion(Tuple newInvocationCompletion)
  {
    if (newInvocationCompletion != invocationCompletion)
    {
      NotificationChain msgs = null;
      if (invocationCompletion != null)
        msgs = ((InternalEObject)invocationCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION, null, msgs);
      if (newInvocationCompletion != null)
        msgs = ((InternalEObject)newInvocationCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION, null, msgs);
      msgs = basicSetInvocationCompletion(newInvocationCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION, newInvocationCompletion, newInvocationCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceConstructionOrAccessCompletion getSequenceConstructionCompletion()
  {
    return sequenceConstructionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceConstructionCompletion(SequenceConstructionOrAccessCompletion newSequenceConstructionCompletion, NotificationChain msgs)
  {
    SequenceConstructionOrAccessCompletion oldSequenceConstructionCompletion = sequenceConstructionCompletion;
    sequenceConstructionCompletion = newSequenceConstructionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, oldSequenceConstructionCompletion, newSequenceConstructionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceConstructionCompletion(SequenceConstructionOrAccessCompletion newSequenceConstructionCompletion)
  {
    if (newSequenceConstructionCompletion != sequenceConstructionCompletion)
    {
      NotificationChain msgs = null;
      if (sequenceConstructionCompletion != null)
        msgs = ((InternalEObject)sequenceConstructionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, null, msgs);
      if (newSequenceConstructionCompletion != null)
        msgs = ((InternalEObject)newSequenceConstructionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, null, msgs);
      msgs = basicSetSequenceConstructionCompletion(newSequenceConstructionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION, newSequenceConstructionCompletion, newSequenceConstructionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPostfixOp()
  {
    return postfixOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostfixOp(String newPostfixOp)
  {
    String oldPostfixOp = postfixOp;
    postfixOp = newPostfixOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__POSTFIX_OP, oldPostfixOp, postfixOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuffixExpression getSuffix()
  {
    return suffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuffix(SuffixExpression newSuffix, NotificationChain msgs)
  {
    SuffixExpression oldSuffix = suffix;
    suffix = newSuffix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__SUFFIX, oldSuffix, newSuffix);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuffix(SuffixExpression newSuffix)
  {
    if (newSuffix != suffix)
    {
      NotificationChain msgs = null;
      if (suffix != null)
        msgs = ((InternalEObject)suffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__SUFFIX, null, msgs);
      if (newSuffix != null)
        msgs = ((InternalEObject)newSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NAME_EXPRESSION__SUFFIX, null, msgs);
      msgs = basicSetSuffix(newSuffix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NAME_EXPRESSION__SUFFIX, newSuffix, newSuffix));
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
      case AlfPackage.NAME_EXPRESSION__PATH:
        return basicSetPath(null, msgs);
      case AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION:
        return basicSetInvocationCompletion(null, msgs);
      case AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        return basicSetSequenceConstructionCompletion(null, msgs);
      case AlfPackage.NAME_EXPRESSION__SUFFIX:
        return basicSetSuffix(null, msgs);
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
      case AlfPackage.NAME_EXPRESSION__PREFIX_OP:
        return getPrefixOp();
      case AlfPackage.NAME_EXPRESSION__PATH:
        return getPath();
      case AlfPackage.NAME_EXPRESSION__ID:
        return getId();
      case AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION:
        return getInvocationCompletion();
      case AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        return getSequenceConstructionCompletion();
      case AlfPackage.NAME_EXPRESSION__POSTFIX_OP:
        return getPostfixOp();
      case AlfPackage.NAME_EXPRESSION__SUFFIX:
        return getSuffix();
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
      case AlfPackage.NAME_EXPRESSION__PREFIX_OP:
        setPrefixOp((String)newValue);
        return;
      case AlfPackage.NAME_EXPRESSION__PATH:
        setPath((QualifiedNamePath)newValue);
        return;
      case AlfPackage.NAME_EXPRESSION__ID:
        setId((String)newValue);
        return;
      case AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION:
        setInvocationCompletion((Tuple)newValue);
        return;
      case AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        setSequenceConstructionCompletion((SequenceConstructionOrAccessCompletion)newValue);
        return;
      case AlfPackage.NAME_EXPRESSION__POSTFIX_OP:
        setPostfixOp((String)newValue);
        return;
      case AlfPackage.NAME_EXPRESSION__SUFFIX:
        setSuffix((SuffixExpression)newValue);
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
      case AlfPackage.NAME_EXPRESSION__PREFIX_OP:
        setPrefixOp(PREFIX_OP_EDEFAULT);
        return;
      case AlfPackage.NAME_EXPRESSION__PATH:
        setPath((QualifiedNamePath)null);
        return;
      case AlfPackage.NAME_EXPRESSION__ID:
        setId(ID_EDEFAULT);
        return;
      case AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION:
        setInvocationCompletion((Tuple)null);
        return;
      case AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        setSequenceConstructionCompletion((SequenceConstructionOrAccessCompletion)null);
        return;
      case AlfPackage.NAME_EXPRESSION__POSTFIX_OP:
        setPostfixOp(POSTFIX_OP_EDEFAULT);
        return;
      case AlfPackage.NAME_EXPRESSION__SUFFIX:
        setSuffix((SuffixExpression)null);
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
      case AlfPackage.NAME_EXPRESSION__PREFIX_OP:
        return PREFIX_OP_EDEFAULT == null ? prefixOp != null : !PREFIX_OP_EDEFAULT.equals(prefixOp);
      case AlfPackage.NAME_EXPRESSION__PATH:
        return path != null;
      case AlfPackage.NAME_EXPRESSION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case AlfPackage.NAME_EXPRESSION__INVOCATION_COMPLETION:
        return invocationCompletion != null;
      case AlfPackage.NAME_EXPRESSION__SEQUENCE_CONSTRUCTION_COMPLETION:
        return sequenceConstructionCompletion != null;
      case AlfPackage.NAME_EXPRESSION__POSTFIX_OP:
        return POSTFIX_OP_EDEFAULT == null ? postfixOp != null : !POSTFIX_OP_EDEFAULT.equals(postfixOp);
      case AlfPackage.NAME_EXPRESSION__SUFFIX:
        return suffix != null;
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
    result.append(" (prefixOp: ");
    result.append(prefixOp);
    result.append(", id: ");
    result.append(id);
    result.append(", postfixOp: ");
    result.append(postfixOp);
    result.append(')');
    return result.toString();
  }

} //NameExpressionImpl
