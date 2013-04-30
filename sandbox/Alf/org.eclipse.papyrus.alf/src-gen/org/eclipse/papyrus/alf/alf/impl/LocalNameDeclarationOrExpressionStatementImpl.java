/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationOrExpressionStatement;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatementCompletion;
import org.eclipse.papyrus.alf.alf.MultiplicityIndicator;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.NameToExpressionCompletion;
import org.eclipse.papyrus.alf.alf.NonNameExpression;
import org.eclipse.papyrus.alf.alf.QualifiedName;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Name Declaration Or Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationOrExpressionStatementImpl#getPotentiallyAmbiguousName <em>Potentially Ambiguous Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationOrExpressionStatementImpl#getMultiplicaityIndicator <em>Multiplicaity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationOrExpressionStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationOrExpressionStatementImpl#getLocalNameDeclarationCompletion <em>Local Name Declaration Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationOrExpressionStatementImpl#getNameToExpressionCompletion <em>Name To Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationOrExpressionStatementImpl#getNonNameExpression <em>Non Name Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalNameDeclarationOrExpressionStatementImpl extends StatementImpl implements LocalNameDeclarationOrExpressionStatement
{
  /**
   * The cached value of the '{@link #getPotentiallyAmbiguousName() <em>Potentially Ambiguous Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPotentiallyAmbiguousName()
   * @generated
   * @ordered
   */
  protected QualifiedName potentiallyAmbiguousName;

  /**
   * The cached value of the '{@link #getMultiplicaityIndicator() <em>Multiplicaity Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicaityIndicator()
   * @generated
   * @ordered
   */
  protected MultiplicityIndicator multiplicaityIndicator;

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
   * The cached value of the '{@link #getLocalNameDeclarationCompletion() <em>Local Name Declaration Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalNameDeclarationCompletion()
   * @generated
   * @ordered
   */
  protected LocalNameDeclarationStatementCompletion localNameDeclarationCompletion;

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
   * The cached value of the '{@link #getNonNameExpression() <em>Non Name Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNonNameExpression()
   * @generated
   * @ordered
   */
  protected NonNameExpression nonNameExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocalNameDeclarationOrExpressionStatementImpl()
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
    return AlfPackage.eINSTANCE.getLocalNameDeclarationOrExpressionStatement();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getPotentiallyAmbiguousName()
  {
    return potentiallyAmbiguousName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPotentiallyAmbiguousName(QualifiedName newPotentiallyAmbiguousName, NotificationChain msgs)
  {
    QualifiedName oldPotentiallyAmbiguousName = potentiallyAmbiguousName;
    potentiallyAmbiguousName = newPotentiallyAmbiguousName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME, oldPotentiallyAmbiguousName, newPotentiallyAmbiguousName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPotentiallyAmbiguousName(QualifiedName newPotentiallyAmbiguousName)
  {
    if (newPotentiallyAmbiguousName != potentiallyAmbiguousName)
    {
      NotificationChain msgs = null;
      if (potentiallyAmbiguousName != null)
        msgs = ((InternalEObject)potentiallyAmbiguousName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME, null, msgs);
      if (newPotentiallyAmbiguousName != null)
        msgs = ((InternalEObject)newPotentiallyAmbiguousName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME, null, msgs);
      msgs = basicSetPotentiallyAmbiguousName(newPotentiallyAmbiguousName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME, newPotentiallyAmbiguousName, newPotentiallyAmbiguousName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityIndicator getMultiplicaityIndicator()
  {
    return multiplicaityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicaityIndicator(MultiplicityIndicator newMultiplicaityIndicator, NotificationChain msgs)
  {
    MultiplicityIndicator oldMultiplicaityIndicator = multiplicaityIndicator;
    multiplicaityIndicator = newMultiplicaityIndicator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR, oldMultiplicaityIndicator, newMultiplicaityIndicator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicaityIndicator(MultiplicityIndicator newMultiplicaityIndicator)
  {
    if (newMultiplicaityIndicator != multiplicaityIndicator)
    {
      NotificationChain msgs = null;
      if (multiplicaityIndicator != null)
        msgs = ((InternalEObject)multiplicaityIndicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR, null, msgs);
      if (newMultiplicaityIndicator != null)
        msgs = ((InternalEObject)newMultiplicaityIndicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR, null, msgs);
      msgs = basicSetMultiplicaityIndicator(newMultiplicaityIndicator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR, newMultiplicaityIndicator, newMultiplicaityIndicator));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME, oldName, newName);
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
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalNameDeclarationStatementCompletion getLocalNameDeclarationCompletion()
  {
    return localNameDeclarationCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion newLocalNameDeclarationCompletion, NotificationChain msgs)
  {
    LocalNameDeclarationStatementCompletion oldLocalNameDeclarationCompletion = localNameDeclarationCompletion;
    localNameDeclarationCompletion = newLocalNameDeclarationCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, oldLocalNameDeclarationCompletion, newLocalNameDeclarationCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocalNameDeclarationCompletion(LocalNameDeclarationStatementCompletion newLocalNameDeclarationCompletion)
  {
    if (newLocalNameDeclarationCompletion != localNameDeclarationCompletion)
    {
      NotificationChain msgs = null;
      if (localNameDeclarationCompletion != null)
        msgs = ((InternalEObject)localNameDeclarationCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, null, msgs);
      if (newLocalNameDeclarationCompletion != null)
        msgs = ((InternalEObject)newLocalNameDeclarationCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, null, msgs);
      msgs = basicSetLocalNameDeclarationCompletion(newLocalNameDeclarationCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION, newLocalNameDeclarationCompletion, newLocalNameDeclarationCompletion));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION, oldNameToExpressionCompletion, newNameToExpressionCompletion);
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
        msgs = ((InternalEObject)nameToExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION, null, msgs);
      if (newNameToExpressionCompletion != null)
        msgs = ((InternalEObject)newNameToExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetNameToExpressionCompletion(newNameToExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION, newNameToExpressionCompletion, newNameToExpressionCompletion));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION, oldNonNameExpression, newNonNameExpression);
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
        msgs = ((InternalEObject)nonNameExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION, null, msgs);
      if (newNonNameExpression != null)
        msgs = ((InternalEObject)newNonNameExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION, null, msgs);
      msgs = basicSetNonNameExpression(newNonNameExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION, newNonNameExpression, newNonNameExpression));
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
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME:
        return basicSetPotentiallyAmbiguousName(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR:
        return basicSetMultiplicaityIndicator(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        return basicSetLocalNameDeclarationCompletion(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION:
        return basicSetNameToExpressionCompletion(null, msgs);
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION:
        return basicSetNonNameExpression(null, msgs);
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
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME:
        return getPotentiallyAmbiguousName();
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR:
        return getMultiplicaityIndicator();
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME:
        return getName();
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        return getLocalNameDeclarationCompletion();
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION:
        return getNameToExpressionCompletion();
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION:
        return getNonNameExpression();
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
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME:
        setPotentiallyAmbiguousName((QualifiedName)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR:
        setMultiplicaityIndicator((MultiplicityIndicator)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        setLocalNameDeclarationCompletion((LocalNameDeclarationStatementCompletion)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION:
        setNameToExpressionCompletion((NameToExpressionCompletion)newValue);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION:
        setNonNameExpression((NonNameExpression)newValue);
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
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME:
        setPotentiallyAmbiguousName((QualifiedName)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR:
        setMultiplicaityIndicator((MultiplicityIndicator)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME:
        setName((Name)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        setLocalNameDeclarationCompletion((LocalNameDeclarationStatementCompletion)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION:
        setNameToExpressionCompletion((NameToExpressionCompletion)null);
        return;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION:
        setNonNameExpression((NonNameExpression)null);
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
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__POTENTIALLY_AMBIGUOUS_NAME:
        return potentiallyAmbiguousName != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__MULTIPLICAITY_INDICATOR:
        return multiplicaityIndicator != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME:
        return name != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__LOCAL_NAME_DECLARATION_COMPLETION:
        return localNameDeclarationCompletion != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NAME_TO_EXPRESSION_COMPLETION:
        return nameToExpressionCompletion != null;
      case AlfPackage.LOCAL_NAME_DECLARATION_OR_EXPRESSION_STATEMENT__NON_NAME_EXPRESSION:
        return nonNameExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //LocalNameDeclarationOrExpressionStatementImpl
