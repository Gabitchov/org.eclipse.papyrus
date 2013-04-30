/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.ClassificationClause;
import org.eclipse.papyrus.alf.alf.ClassifyStatement;
import org.eclipse.papyrus.alf.alf.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classify Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassifyStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassifyStatementImpl#getClassificationClause <em>Classification Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifyStatementImpl extends StatementImpl implements ClassifyStatement
{
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
   * The cached value of the '{@link #getClassificationClause() <em>Classification Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassificationClause()
   * @generated
   * @ordered
   */
  protected ClassificationClause classificationClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifyStatementImpl()
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
    return AlfPackage.eINSTANCE.getClassifyStatement();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFY_STATEMENT__EXPRESSION, oldExpression, newExpression);
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
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFY_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFY_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFY_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationClause getClassificationClause()
  {
    return classificationClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassificationClause(ClassificationClause newClassificationClause, NotificationChain msgs)
  {
    ClassificationClause oldClassificationClause = classificationClause;
    classificationClause = newClassificationClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE, oldClassificationClause, newClassificationClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassificationClause(ClassificationClause newClassificationClause)
  {
    if (newClassificationClause != classificationClause)
    {
      NotificationChain msgs = null;
      if (classificationClause != null)
        msgs = ((InternalEObject)classificationClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE, null, msgs);
      if (newClassificationClause != null)
        msgs = ((InternalEObject)newClassificationClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE, null, msgs);
      msgs = basicSetClassificationClause(newClassificationClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE, newClassificationClause, newClassificationClause));
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
      case AlfPackage.CLASSIFY_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE:
        return basicSetClassificationClause(null, msgs);
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
      case AlfPackage.CLASSIFY_STATEMENT__EXPRESSION:
        return getExpression();
      case AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE:
        return getClassificationClause();
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
      case AlfPackage.CLASSIFY_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE:
        setClassificationClause((ClassificationClause)newValue);
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
      case AlfPackage.CLASSIFY_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE:
        setClassificationClause((ClassificationClause)null);
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
      case AlfPackage.CLASSIFY_STATEMENT__EXPRESSION:
        return expression != null;
      case AlfPackage.CLASSIFY_STATEMENT__CLASSIFICATION_CLAUSE:
        return classificationClause != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassifyStatementImpl
