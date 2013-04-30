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
import org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion;
import org.eclipse.papyrus.alf.alf.ClassificationOperator;
import org.eclipse.papyrus.alf.alf.QualifiedName;
import org.eclipse.papyrus.alf.alf.RelationalExpressionCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationExpressionCompletionImpl#getRelationalExpressionCompletion <em>Relational Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationExpressionCompletionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationExpressionCompletionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationExpressionCompletionImpl extends MinimalEObjectImpl.Container implements ClassificationExpressionCompletion
{
  /**
   * The cached value of the '{@link #getRelationalExpressionCompletion() <em>Relational Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationalExpressionCompletion()
   * @generated
   * @ordered
   */
  protected RelationalExpressionCompletion relationalExpressionCompletion;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final ClassificationOperator OPERATOR_EDEFAULT = ClassificationOperator.INSTANCEOF;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected ClassificationOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected QualifiedName name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getClassificationExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpressionCompletion getRelationalExpressionCompletion()
  {
    return relationalExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRelationalExpressionCompletion(RelationalExpressionCompletion newRelationalExpressionCompletion, NotificationChain msgs)
  {
    RelationalExpressionCompletion oldRelationalExpressionCompletion = relationalExpressionCompletion;
    relationalExpressionCompletion = newRelationalExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION, oldRelationalExpressionCompletion, newRelationalExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelationalExpressionCompletion(RelationalExpressionCompletion newRelationalExpressionCompletion)
  {
    if (newRelationalExpressionCompletion != relationalExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (relationalExpressionCompletion != null)
        msgs = ((InternalEObject)relationalExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION, null, msgs);
      if (newRelationalExpressionCompletion != null)
        msgs = ((InternalEObject)newRelationalExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetRelationalExpressionCompletion(newRelationalExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION, newRelationalExpressionCompletion, newRelationalExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(ClassificationOperator newOperator)
  {
    ClassificationOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(QualifiedName newName, NotificationChain msgs)
  {
    QualifiedName oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(QualifiedName newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME, newName, newName));
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
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION:
        return basicSetRelationalExpressionCompletion(null, msgs);
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME:
        return basicSetName(null, msgs);
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
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION:
        return getRelationalExpressionCompletion();
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__OPERATOR:
        return getOperator();
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME:
        return getName();
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
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION:
        setRelationalExpressionCompletion((RelationalExpressionCompletion)newValue);
        return;
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__OPERATOR:
        setOperator((ClassificationOperator)newValue);
        return;
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME:
        setName((QualifiedName)newValue);
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
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION:
        setRelationalExpressionCompletion((RelationalExpressionCompletion)null);
        return;
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME:
        setName((QualifiedName)null);
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
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__RELATIONAL_EXPRESSION_COMPLETION:
        return relationalExpressionCompletion != null;
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case AlfPackage.CLASSIFICATION_EXPRESSION_COMPLETION__NAME:
        return name != null;
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //ClassificationExpressionCompletionImpl
