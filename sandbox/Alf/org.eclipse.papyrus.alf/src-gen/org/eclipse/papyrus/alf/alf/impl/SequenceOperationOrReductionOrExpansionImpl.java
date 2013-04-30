/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.Expression;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion;
import org.eclipse.papyrus.alf.alf.TemplateBinding;
import org.eclipse.papyrus.alf.alf.Tuple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Operation Or Reduction Or Expansion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#getTuple <em>Tuple</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#isIsReduce <em>Is Reduce</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#getTemplateBinding <em>Template Binding</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceOperationOrReductionOrExpansionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceOperationOrReductionOrExpansionImpl extends MinimalEObjectImpl.Container implements SequenceOperationOrReductionOrExpansion
{
  /**
   * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected EObject qualifiedName;

  /**
   * The cached value of the '{@link #getTuple() <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTuple()
   * @generated
   * @ordered
   */
  protected Tuple tuple;

  /**
   * The default value of the '{@link #isIsReduce() <em>Is Reduce</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsReduce()
   * @generated
   * @ordered
   */
  protected static final boolean IS_REDUCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsReduce() <em>Is Reduce</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsReduce()
   * @generated
   * @ordered
   */
  protected boolean isReduce = IS_REDUCE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean IS_ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOrdered()
   * @generated
   * @ordered
   */
  protected boolean isOrdered = IS_ORDERED_EDEFAULT;

  /**
   * The cached value of the '{@link #getTemplateBinding() <em>Template Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateBinding()
   * @generated
   * @ordered
   */
  protected TemplateBinding templateBinding;

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
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceOperationOrReductionOrExpansionImpl()
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
    return AlfPackage.eINSTANCE.getSequenceOperationOrReductionOrExpansion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getQualifiedName()
  {
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedName(EObject newQualifiedName, NotificationChain msgs)
  {
    EObject oldQualifiedName = qualifiedName;
    qualifiedName = newQualifiedName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME, oldQualifiedName, newQualifiedName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifiedName(EObject newQualifiedName)
  {
    if (newQualifiedName != qualifiedName)
    {
      NotificationChain msgs = null;
      if (qualifiedName != null)
        msgs = ((InternalEObject)qualifiedName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME, null, msgs);
      if (newQualifiedName != null)
        msgs = ((InternalEObject)newQualifiedName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME, null, msgs);
      msgs = basicSetQualifiedName(newQualifiedName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME, newQualifiedName, newQualifiedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple getTuple()
  {
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTuple(Tuple newTuple, NotificationChain msgs)
  {
    Tuple oldTuple = tuple;
    tuple = newTuple;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE, oldTuple, newTuple);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTuple(Tuple newTuple)
  {
    if (newTuple != tuple)
    {
      NotificationChain msgs = null;
      if (tuple != null)
        msgs = ((InternalEObject)tuple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE, null, msgs);
      if (newTuple != null)
        msgs = ((InternalEObject)newTuple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE, null, msgs);
      msgs = basicSetTuple(newTuple, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE, newTuple, newTuple));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsReduce()
  {
    return isReduce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsReduce(boolean newIsReduce)
  {
    boolean oldIsReduce = isReduce;
    isReduce = newIsReduce;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_REDUCE, oldIsReduce, isReduce));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsOrdered()
  {
    return isOrdered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsOrdered(boolean newIsOrdered)
  {
    boolean oldIsOrdered = isOrdered;
    isOrdered = newIsOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_ORDERED, oldIsOrdered, isOrdered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateBinding getTemplateBinding()
  {
    return templateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplateBinding(TemplateBinding newTemplateBinding, NotificationChain msgs)
  {
    TemplateBinding oldTemplateBinding = templateBinding;
    templateBinding = newTemplateBinding;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING, oldTemplateBinding, newTemplateBinding);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplateBinding(TemplateBinding newTemplateBinding)
  {
    if (newTemplateBinding != templateBinding)
    {
      NotificationChain msgs = null;
      if (templateBinding != null)
        msgs = ((InternalEObject)templateBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING, null, msgs);
      if (newTemplateBinding != null)
        msgs = ((InternalEObject)newTemplateBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING, null, msgs);
      msgs = basicSetTemplateBinding(newTemplateBinding, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING, newTemplateBinding, newTemplateBinding));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__ID, oldId, id));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION, newExpression, newExpression));
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
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME:
        return basicSetQualifiedName(null, msgs);
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE:
        return basicSetTuple(null, msgs);
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING:
        return basicSetTemplateBinding(null, msgs);
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME:
        return getQualifiedName();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE:
        return getTuple();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_REDUCE:
        return isIsReduce();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_ORDERED:
        return isIsOrdered();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING:
        return getTemplateBinding();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__ID:
        return getId();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME:
        return getName();
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION:
        return getExpression();
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
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME:
        setQualifiedName((EObject)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE:
        setTuple((Tuple)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_REDUCE:
        setIsReduce((Boolean)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_ORDERED:
        setIsOrdered((Boolean)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING:
        setTemplateBinding((TemplateBinding)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__ID:
        setId((String)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION:
        setExpression((Expression)newValue);
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
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME:
        setQualifiedName((EObject)null);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE:
        setTuple((Tuple)null);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_REDUCE:
        setIsReduce(IS_REDUCE_EDEFAULT);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_ORDERED:
        setIsOrdered(IS_ORDERED_EDEFAULT);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING:
        setTemplateBinding((TemplateBinding)null);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__ID:
        setId(ID_EDEFAULT);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME:
        setName((Name)null);
        return;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION:
        setExpression((Expression)null);
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
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__QUALIFIED_NAME:
        return qualifiedName != null;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TUPLE:
        return tuple != null;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_REDUCE:
        return isReduce != IS_REDUCE_EDEFAULT;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__IS_ORDERED:
        return isOrdered != IS_ORDERED_EDEFAULT;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__TEMPLATE_BINDING:
        return templateBinding != null;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__NAME:
        return name != null;
      case AlfPackage.SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION__EXPRESSION:
        return expression != null;
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
    result.append(" (isReduce: ");
    result.append(isReduce);
    result.append(", isOrdered: ");
    result.append(isOrdered);
    result.append(", id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //SequenceOperationOrReductionOrExpansionImpl
