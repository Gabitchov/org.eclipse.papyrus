/**
 */
package org.eclipse.papyrus.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.alf.alf.AlfPackage;
import org.eclipse.papyrus.alf.alf.AnnotatedStatement;
import org.eclipse.papyrus.alf.alf.Annotations;
import org.eclipse.papyrus.alf.alf.Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotated Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AnnotatedStatementImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AnnotatedStatementImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotatedStatementImpl extends StatementImpl implements AnnotatedStatement
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected Annotations annotations;

  /**
   * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatement()
   * @generated
   * @ordered
   */
  protected Statement statement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotatedStatementImpl()
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
    return AlfPackage.eINSTANCE.getAnnotatedStatement();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotations getAnnotations()
  {
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnnotations(Annotations newAnnotations, NotificationChain msgs)
  {
    Annotations oldAnnotations = annotations;
    annotations = newAnnotations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS, oldAnnotations, newAnnotations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotations(Annotations newAnnotations)
  {
    if (newAnnotations != annotations)
    {
      NotificationChain msgs = null;
      if (annotations != null)
        msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS, null, msgs);
      if (newAnnotations != null)
        msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS, null, msgs);
      msgs = basicSetAnnotations(newAnnotations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS, newAnnotations, newAnnotations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getStatement()
  {
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatement(Statement newStatement, NotificationChain msgs)
  {
    Statement oldStatement = statement;
    statement = newStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATED_STATEMENT__STATEMENT, oldStatement, newStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatement(Statement newStatement)
  {
    if (newStatement != statement)
    {
      NotificationChain msgs = null;
      if (statement != null)
        msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ANNOTATED_STATEMENT__STATEMENT, null, msgs);
      if (newStatement != null)
        msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ANNOTATED_STATEMENT__STATEMENT, null, msgs);
      msgs = basicSetStatement(newStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATED_STATEMENT__STATEMENT, newStatement, newStatement));
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
      case AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS:
        return basicSetAnnotations(null, msgs);
      case AlfPackage.ANNOTATED_STATEMENT__STATEMENT:
        return basicSetStatement(null, msgs);
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
      case AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS:
        return getAnnotations();
      case AlfPackage.ANNOTATED_STATEMENT__STATEMENT:
        return getStatement();
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
      case AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS:
        setAnnotations((Annotations)newValue);
        return;
      case AlfPackage.ANNOTATED_STATEMENT__STATEMENT:
        setStatement((Statement)newValue);
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
      case AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS:
        setAnnotations((Annotations)null);
        return;
      case AlfPackage.ANNOTATED_STATEMENT__STATEMENT:
        setStatement((Statement)null);
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
      case AlfPackage.ANNOTATED_STATEMENT__ANNOTATIONS:
        return annotations != null;
      case AlfPackage.ANNOTATED_STATEMENT__STATEMENT:
        return statement != null;
    }
    return super.eIsSet(featureID);
  }

} //AnnotatedStatementImpl
