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
import org.eclipse.papyrus.alf.alf.ClassificationClause;
import org.eclipse.papyrus.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.alf.alf.ClassificationToClause;
import org.eclipse.papyrus.alf.alf.ReclassifyAllClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationClauseImpl#getClassificationFromClause <em>Classification From Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationClauseImpl#getClassificationToClause <em>Classification To Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassificationClauseImpl#getReclassifyAllClause <em>Reclassify All Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationClauseImpl extends MinimalEObjectImpl.Container implements ClassificationClause
{
  /**
   * The cached value of the '{@link #getClassificationFromClause() <em>Classification From Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassificationFromClause()
   * @generated
   * @ordered
   */
  protected ClassificationFromClause classificationFromClause;

  /**
   * The cached value of the '{@link #getClassificationToClause() <em>Classification To Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassificationToClause()
   * @generated
   * @ordered
   */
  protected ClassificationToClause classificationToClause;

  /**
   * The cached value of the '{@link #getReclassifyAllClause() <em>Reclassify All Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReclassifyAllClause()
   * @generated
   * @ordered
   */
  protected ReclassifyAllClause reclassifyAllClause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationClauseImpl()
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
    return AlfPackage.eINSTANCE.getClassificationClause();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationFromClause getClassificationFromClause()
  {
    return classificationFromClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassificationFromClause(ClassificationFromClause newClassificationFromClause, NotificationChain msgs)
  {
    ClassificationFromClause oldClassificationFromClause = classificationFromClause;
    classificationFromClause = newClassificationFromClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE, oldClassificationFromClause, newClassificationFromClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassificationFromClause(ClassificationFromClause newClassificationFromClause)
  {
    if (newClassificationFromClause != classificationFromClause)
    {
      NotificationChain msgs = null;
      if (classificationFromClause != null)
        msgs = ((InternalEObject)classificationFromClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE, null, msgs);
      if (newClassificationFromClause != null)
        msgs = ((InternalEObject)newClassificationFromClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE, null, msgs);
      msgs = basicSetClassificationFromClause(newClassificationFromClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE, newClassificationFromClause, newClassificationFromClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationToClause getClassificationToClause()
  {
    return classificationToClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassificationToClause(ClassificationToClause newClassificationToClause, NotificationChain msgs)
  {
    ClassificationToClause oldClassificationToClause = classificationToClause;
    classificationToClause = newClassificationToClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE, oldClassificationToClause, newClassificationToClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassificationToClause(ClassificationToClause newClassificationToClause)
  {
    if (newClassificationToClause != classificationToClause)
    {
      NotificationChain msgs = null;
      if (classificationToClause != null)
        msgs = ((InternalEObject)classificationToClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE, null, msgs);
      if (newClassificationToClause != null)
        msgs = ((InternalEObject)newClassificationToClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE, null, msgs);
      msgs = basicSetClassificationToClause(newClassificationToClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE, newClassificationToClause, newClassificationToClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReclassifyAllClause getReclassifyAllClause()
  {
    return reclassifyAllClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReclassifyAllClause(ReclassifyAllClause newReclassifyAllClause, NotificationChain msgs)
  {
    ReclassifyAllClause oldReclassifyAllClause = reclassifyAllClause;
    reclassifyAllClause = newReclassifyAllClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE, oldReclassifyAllClause, newReclassifyAllClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReclassifyAllClause(ReclassifyAllClause newReclassifyAllClause)
  {
    if (newReclassifyAllClause != reclassifyAllClause)
    {
      NotificationChain msgs = null;
      if (reclassifyAllClause != null)
        msgs = ((InternalEObject)reclassifyAllClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE, null, msgs);
      if (newReclassifyAllClause != null)
        msgs = ((InternalEObject)newReclassifyAllClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE, null, msgs);
      msgs = basicSetReclassifyAllClause(newReclassifyAllClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE, newReclassifyAllClause, newReclassifyAllClause));
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE:
        return basicSetClassificationFromClause(null, msgs);
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE:
        return basicSetClassificationToClause(null, msgs);
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE:
        return basicSetReclassifyAllClause(null, msgs);
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE:
        return getClassificationFromClause();
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE:
        return getClassificationToClause();
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE:
        return getReclassifyAllClause();
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE:
        setClassificationFromClause((ClassificationFromClause)newValue);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE:
        setClassificationToClause((ClassificationToClause)newValue);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE:
        setReclassifyAllClause((ReclassifyAllClause)newValue);
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE:
        setClassificationFromClause((ClassificationFromClause)null);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE:
        setClassificationToClause((ClassificationToClause)null);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE:
        setReclassifyAllClause((ReclassifyAllClause)null);
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_FROM_CLAUSE:
        return classificationFromClause != null;
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFICATION_TO_CLAUSE:
        return classificationToClause != null;
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSIFY_ALL_CLAUSE:
        return reclassifyAllClause != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassificationClauseImpl
