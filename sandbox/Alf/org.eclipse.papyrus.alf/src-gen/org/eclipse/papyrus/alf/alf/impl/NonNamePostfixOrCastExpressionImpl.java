/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.BaseExpression;
import org.eclipse.papyrus.alf.alf.CastCompletion;
import org.eclipse.papyrus.alf.alf.NameToExpressionCompletion;
import org.eclipse.papyrus.alf.alf.NonNameExpression;
import org.eclipse.papyrus.alf.alf.NonNamePostfixOrCastExpression;
import org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion;
import org.eclipse.papyrus.alf.alf.QualifiedNameWithoutBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Name Postfix Or Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#isAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getCastCompletion <em>Cast Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getPotentiallyAmbiguousQualifiedName <em>Potentially Ambiguous Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getPostifixExpressionCompletion <em>Postifix Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getNameToExpressionCompletion <em>Name To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getPostfixExpressionCompletion <em>Postfix Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getNonNameExpression <em>Non Name Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.NonNamePostfixOrCastExpressionImpl#getBaseExpression <em>Base Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonNamePostfixOrCastExpressionImpl extends NonNameUnaryExpressionImpl implements NonNamePostfixOrCastExpression
{
  /**
   * The default value of the '{@link #isAny() <em>Any</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAny()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAny() <em>Any</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAny()
   * @generated
   * @ordered
   */
  protected boolean any = ANY_EDEFAULT;

  /**
   * The cached value of the '{@link #getCastCompletion() <em>Cast Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCastCompletion()
   * @generated
   * @ordered
   */
  protected CastCompletion castCompletion;

  /**
   * The cached value of the '{@link #getPotentiallyAmbiguousQualifiedName() <em>Potentially Ambiguous Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPotentiallyAmbiguousQualifiedName()
   * @generated
   * @ordered
   */
  protected QualifiedNameWithoutBinding potentiallyAmbiguousQualifiedName;

  /**
   * The cached value of the '{@link #getPostifixExpressionCompletion() <em>Postifix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostifixExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PostfixExpressionCompletion postifixExpressionCompletion;

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
   * The cached value of the '{@link #getPostfixExpressionCompletion() <em>Postfix Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixExpressionCompletion()
   * @generated
   * @ordered
   */
  protected PostfixExpressionCompletion postfixExpressionCompletion;

  /**
   * The cached value of the '{@link #getNonNameExpression() <em>Non Name Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonNameExpression()
   * @generated
   * @ordered
   */
  protected NonNameExpression nonNameExpression;

  /**
   * The cached value of the '{@link #getBaseExpression() <em>Base Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseExpression()
   * @generated
   * @ordered
   */
  protected BaseExpression baseExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NonNamePostfixOrCastExpressionImpl()
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
    return AlfPackage.eINSTANCE.getNonNamePostfixOrCastExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAny()
  {
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAny(boolean newAny)
  {
    boolean oldAny = any;
    any = newAny;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__ANY, oldAny, any));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CastCompletion getCastCompletion()
  {
    return castCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCastCompletion(CastCompletion newCastCompletion, NotificationChain msgs)
  {
    CastCompletion oldCastCompletion = castCompletion;
    castCompletion = newCastCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION, oldCastCompletion, newCastCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCastCompletion(CastCompletion newCastCompletion)
  {
    if (newCastCompletion != castCompletion)
    {
      NotificationChain msgs = null;
      if (castCompletion != null)
        msgs = ((InternalEObject)castCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION, null, msgs);
      if (newCastCompletion != null)
        msgs = ((InternalEObject)newCastCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION, null, msgs);
      msgs = basicSetCastCompletion(newCastCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION, newCastCompletion, newCastCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedNameWithoutBinding getPotentiallyAmbiguousQualifiedName()
  {
    return potentiallyAmbiguousQualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding newPotentiallyAmbiguousQualifiedName, NotificationChain msgs)
  {
    QualifiedNameWithoutBinding oldPotentiallyAmbiguousQualifiedName = potentiallyAmbiguousQualifiedName;
    potentiallyAmbiguousQualifiedName = newPotentiallyAmbiguousQualifiedName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, oldPotentiallyAmbiguousQualifiedName, newPotentiallyAmbiguousQualifiedName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding newPotentiallyAmbiguousQualifiedName)
  {
    if (newPotentiallyAmbiguousQualifiedName != potentiallyAmbiguousQualifiedName)
    {
      NotificationChain msgs = null;
      if (potentiallyAmbiguousQualifiedName != null)
        msgs = ((InternalEObject)potentiallyAmbiguousQualifiedName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, null, msgs);
      if (newPotentiallyAmbiguousQualifiedName != null)
        msgs = ((InternalEObject)newPotentiallyAmbiguousQualifiedName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, null, msgs);
      msgs = basicSetPotentiallyAmbiguousQualifiedName(newPotentiallyAmbiguousQualifiedName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME, newPotentiallyAmbiguousQualifiedName, newPotentiallyAmbiguousQualifiedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpressionCompletion getPostifixExpressionCompletion()
  {
    return postifixExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPostifixExpressionCompletion(PostfixExpressionCompletion newPostifixExpressionCompletion, NotificationChain msgs)
  {
    PostfixExpressionCompletion oldPostifixExpressionCompletion = postifixExpressionCompletion;
    postifixExpressionCompletion = newPostifixExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION, oldPostifixExpressionCompletion, newPostifixExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostifixExpressionCompletion(PostfixExpressionCompletion newPostifixExpressionCompletion)
  {
    if (newPostifixExpressionCompletion != postifixExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (postifixExpressionCompletion != null)
        msgs = ((InternalEObject)postifixExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION, null, msgs);
      if (newPostifixExpressionCompletion != null)
        msgs = ((InternalEObject)newPostifixExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPostifixExpressionCompletion(newPostifixExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION, newPostifixExpressionCompletion, newPostifixExpressionCompletion));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION, oldNameToExpressionCompletion, newNameToExpressionCompletion);
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
        msgs = ((InternalEObject)nameToExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION, null, msgs);
      if (newNameToExpressionCompletion != null)
        msgs = ((InternalEObject)newNameToExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetNameToExpressionCompletion(newNameToExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION, newNameToExpressionCompletion, newNameToExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpressionCompletion getPostfixExpressionCompletion()
  {
    return postfixExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPostfixExpressionCompletion(PostfixExpressionCompletion newPostfixExpressionCompletion, NotificationChain msgs)
  {
    PostfixExpressionCompletion oldPostfixExpressionCompletion = postfixExpressionCompletion;
    postfixExpressionCompletion = newPostfixExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION, oldPostfixExpressionCompletion, newPostfixExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostfixExpressionCompletion(PostfixExpressionCompletion newPostfixExpressionCompletion)
  {
    if (newPostfixExpressionCompletion != postfixExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (postfixExpressionCompletion != null)
        msgs = ((InternalEObject)postfixExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION, null, msgs);
      if (newPostfixExpressionCompletion != null)
        msgs = ((InternalEObject)newPostfixExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetPostfixExpressionCompletion(newPostfixExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION, newPostfixExpressionCompletion, newPostfixExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonNameExpression getNonNameExpression()
  {
    return nonNameExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNonNameExpression(NonNameExpression newNonNameExpression, NotificationChain msgs)
  {
    NonNameExpression oldNonNameExpression = nonNameExpression;
    nonNameExpression = newNonNameExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION, oldNonNameExpression, newNonNameExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonNameExpression(NonNameExpression newNonNameExpression)
  {
    if (newNonNameExpression != nonNameExpression)
    {
      NotificationChain msgs = null;
      if (nonNameExpression != null)
        msgs = ((InternalEObject)nonNameExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION, null, msgs);
      if (newNonNameExpression != null)
        msgs = ((InternalEObject)newNonNameExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION, null, msgs);
      msgs = basicSetNonNameExpression(newNonNameExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION, newNonNameExpression, newNonNameExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseExpression getBaseExpression()
  {
    return baseExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaseExpression(BaseExpression newBaseExpression, NotificationChain msgs)
  {
    BaseExpression oldBaseExpression = baseExpression;
    baseExpression = newBaseExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION, oldBaseExpression, newBaseExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaseExpression(BaseExpression newBaseExpression)
  {
    if (newBaseExpression != baseExpression)
    {
      NotificationChain msgs = null;
      if (baseExpression != null)
        msgs = ((InternalEObject)baseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION, null, msgs);
      if (newBaseExpression != null)
        msgs = ((InternalEObject)newBaseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION, null, msgs);
      msgs = basicSetBaseExpression(newBaseExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION, newBaseExpression, newBaseExpression));
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
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION:
        return basicSetCastCompletion(null, msgs);
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        return basicSetPotentiallyAmbiguousQualifiedName(null, msgs);
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION:
        return basicSetPostifixExpressionCompletion(null, msgs);
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION:
        return basicSetNameToExpressionCompletion(null, msgs);
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION:
        return basicSetPostfixExpressionCompletion(null, msgs);
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION:
        return basicSetNonNameExpression(null, msgs);
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION:
        return basicSetBaseExpression(null, msgs);
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
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__ANY:
        return isAny();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION:
        return getCastCompletion();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        return getPotentiallyAmbiguousQualifiedName();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION:
        return getPostifixExpressionCompletion();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION:
        return getNameToExpressionCompletion();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION:
        return getPostfixExpressionCompletion();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION:
        return getNonNameExpression();
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION:
        return getBaseExpression();
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
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__ANY:
        setAny((Boolean)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION:
        setCastCompletion((CastCompletion)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        setPotentiallyAmbiguousQualifiedName((QualifiedNameWithoutBinding)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION:
        setPostifixExpressionCompletion((PostfixExpressionCompletion)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION:
        setNameToExpressionCompletion((NameToExpressionCompletion)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION:
        setPostfixExpressionCompletion((PostfixExpressionCompletion)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION:
        setNonNameExpression((NonNameExpression)newValue);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION:
        setBaseExpression((BaseExpression)newValue);
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
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__ANY:
        setAny(ANY_EDEFAULT);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION:
        setCastCompletion((CastCompletion)null);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        setPotentiallyAmbiguousQualifiedName((QualifiedNameWithoutBinding)null);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION:
        setPostifixExpressionCompletion((PostfixExpressionCompletion)null);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION:
        setNameToExpressionCompletion((NameToExpressionCompletion)null);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION:
        setPostfixExpressionCompletion((PostfixExpressionCompletion)null);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION:
        setNonNameExpression((NonNameExpression)null);
        return;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION:
        setBaseExpression((BaseExpression)null);
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
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__ANY:
        return any != ANY_EDEFAULT;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__CAST_COMPLETION:
        return castCompletion != null;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POTENTIALLY_AMBIGUOUS_QUALIFIED_NAME:
        return potentiallyAmbiguousQualifiedName != null;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTIFIX_EXPRESSION_COMPLETION:
        return postifixExpressionCompletion != null;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NAME_TO_EXPRESSION_COMPLETION:
        return nameToExpressionCompletion != null;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__POSTFIX_EXPRESSION_COMPLETION:
        return postfixExpressionCompletion != null;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__NON_NAME_EXPRESSION:
        return nonNameExpression != null;
      case AlfPackage.NON_NAME_POSTFIX_OR_CAST_EXPRESSION__BASE_EXPRESSION:
        return baseExpression != null;
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
    result.append(" (any: ");
    result.append(any);
    result.append(')');
    return result.toString();
  }

} //NonNamePostfixOrCastExpressionImpl
