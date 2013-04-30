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
import org.eclipse.papyrus.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion;
import org.eclipse.papyrus.alf.alf.UnaryExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationExpressionImpl#getUnaryExpression <em>Unary Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationExpressionImpl#getClassificationExpressionCompletion <em>Classification Expression Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationExpressionImpl extends MinimalEObjectImpl.Container implements ClassificationExpression
{
  /**
   * The cached value of the '{@link #getUnaryExpression() <em>Unary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnaryExpression()
   * @generated
   * @ordered
   */
  protected UnaryExpression unaryExpression;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationExpressionImpl()
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
    return AlfPackage.eINSTANCE.getClassificationExpression();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression getUnaryExpression()
  {
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnaryExpression(UnaryExpression newUnaryExpression, NotificationChain msgs)
  {
    UnaryExpression oldUnaryExpression = unaryExpression;
    unaryExpression = newUnaryExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION, oldUnaryExpression, newUnaryExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnaryExpression(UnaryExpression newUnaryExpression)
  {
    if (newUnaryExpression != unaryExpression)
    {
      NotificationChain msgs = null;
      if (unaryExpression != null)
        msgs = ((InternalEObject)unaryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      if (newUnaryExpression != null)
        msgs = ((InternalEObject)newUnaryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION, null, msgs);
      msgs = basicSetUnaryExpression(newUnaryExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION, newUnaryExpression, newUnaryExpression));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION, oldClassificationExpressionCompletion, newClassificationExpressionCompletion);
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
        msgs = ((InternalEObject)classificationExpressionCompletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION, null, msgs);
      if (newClassificationExpressionCompletion != null)
        msgs = ((InternalEObject)newClassificationExpressionCompletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION, null, msgs);
      msgs = basicSetClassificationExpressionCompletion(newClassificationExpressionCompletion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION, newClassificationExpressionCompletion, newClassificationExpressionCompletion));
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
      case AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION:
        return basicSetUnaryExpression(null, msgs);
      case AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION:
        return basicSetClassificationExpressionCompletion(null, msgs);
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
      case AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION:
        return getUnaryExpression();
      case AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION:
        return getClassificationExpressionCompletion();
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
      case AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)newValue);
        return;
      case AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION:
        setClassificationExpressionCompletion((ClassificationExpressionCompletion)newValue);
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
      case AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION:
        setUnaryExpression((UnaryExpression)null);
        return;
      case AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION:
        setClassificationExpressionCompletion((ClassificationExpressionCompletion)null);
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
      case AlfPackage.CLASSIFICATION_EXPRESSION__UNARY_EXPRESSION:
        return unaryExpression != null;
      case AlfPackage.CLASSIFICATION_EXPRESSION__CLASSIFICATION_EXPRESSION_COMPLETION:
        return classificationExpressionCompletion != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassificationExpressionImpl
