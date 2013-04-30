/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion;
import org.eclipse.papyrus.alf.alf.EqualityExpressionCompletion;
import org.eclipse.papyrus.alf.alf.EqualityOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equality Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.EqualityExpressionCompletionImpl#getClassificationExpressionCompletion <em>Classification Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.EqualityExpressionCompletionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.EqualityExpressionCompletionImpl#getClassificationExpression <em>Classification Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EqualityExpressionCompletionImpl extends MinimalEObjectImpl.Container implements EqualityExpressionCompletion
{
  /**
   * The cached value of the '{@link #getClassificationExpressionCompletion() <em>Classification Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassificationExpressionCompletion()
   * @generated
   * @ordered
   */
  protected ClassificationExpressionCompletion classificationExpressionCompletion;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected EList<EqualityOperator> operator;

  /**
   * The cached value of the '{@link #getClassificationExpression() <em>Classification Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassificationExpression()
   * @generated
   * @ordered
   */
  protected EList<ClassificationExpression> classificationExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EqualityExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getEqualityExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationExpressionCompletion getClassificationExpressionCompletion()
  {
    return classificationExpressionCompletion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassificationExpressionCompletion(ClassificationExpressionCompletion newClassificationExpressionCompletion, NotificationChain msgs)
  {
    ClassificationExpressionCompletion oldClassificationExpressionCompletion = classificationExpressionCompletion;
    classificationExpressionCompletion = newClassificationExpressionCompletion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION, oldClassificationExpressionCompletion, newClassificationExpressionCompletion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassificationExpressionCompletion(ClassificationExpressionCompletion newClassificationExpressionCompletion)
  {
    if (newClassificationExpressionCompletion != classificationExpressionCompletion)
    {
      NotificationChain msgs = null;
      if (classificationExpressionCompletion != null)
        msgs = ((InternalEObject)classificationExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION, null, msgs);
      if (newClassificationExpressionCompletion != null)
        msgs = ((InternalEObject)newClassificationExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetClassificationExpressionCompletion(newClassificationExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION, newClassificationExpressionCompletion, newClassificationExpressionCompletion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EqualityOperator> getOperator()
  {
    if (operator == null)
    {
      operator = new EDataTypeEList<EqualityOperator>(EqualityOperator.class, this, AlfPackage.EQUALITY_EXPRESSION_COMPLETION__OPERATOR);
    }
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ClassificationExpression> getClassificationExpression()
  {
    if (classificationExpression == null)
    {
      classificationExpression = new EObjectContainmentEList<ClassificationExpression>(ClassificationExpression.class, this, AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION);
    }
    return classificationExpression;
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
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION:
        return basicSetClassificationExpressionCompletion(null, msgs);
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION:
        return ((InternalEList<?>)getClassificationExpression()).basicRemove(otherEnd, msgs);
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
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION:
        return getClassificationExpressionCompletion();
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__OPERATOR:
        return getOperator();
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION:
        return getClassificationExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION:
        setClassificationExpressionCompletion((ClassificationExpressionCompletion)newValue);
        return;
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        getOperator().addAll((Collection<? extends EqualityOperator>)newValue);
        return;
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION:
        getClassificationExpression().clear();
        getClassificationExpression().addAll((Collection<? extends ClassificationExpression>)newValue);
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
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION:
        setClassificationExpressionCompletion((ClassificationExpressionCompletion)null);
        return;
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__OPERATOR:
        getOperator().clear();
        return;
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION:
        getClassificationExpression().clear();
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
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION_COMPLETION:
        return classificationExpressionCompletion != null;
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__OPERATOR:
        return operator != null && !operator.isEmpty();
      case AlfPackage.EQUALITY_EXPRESSION_COMPLETION__CLASSIFICATION_EXPRESSION:
        return classificationExpression != null && !classificationExpression.isEmpty();
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

} //EqualityExpressionCompletionImpl
