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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.ClassificationClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationToClause;
import org.eclipse.papyrus.uml.alf.alf.ReclassifyAllClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ClassificationClauseImpl#getClassifyFromClause <em>Classify From Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ClassificationClauseImpl#getClassifyToClause <em>Classify To Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.ClassificationClauseImpl#getReclassyAllClause <em>Reclassy All Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassificationClauseImpl extends MinimalEObjectImpl.Container implements ClassificationClause
{
  /**
   * The cached value of the '{@link #getClassifyFromClause() <em>Classify From Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifyFromClause()
   * @generated
   * @ordered
   */
  protected ClassificationFromClause classifyFromClause;

  /**
   * The cached value of the '{@link #getClassifyToClause() <em>Classify To Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifyToClause()
   * @generated
   * @ordered
   */
  protected ClassificationToClause classifyToClause;

  /**
   * The cached value of the '{@link #getReclassyAllClause() <em>Reclassy All Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReclassyAllClause()
   * @generated
   * @ordered
   */
  protected ReclassifyAllClause reclassyAllClause;

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
    return AlfPackage.Literals.CLASSIFICATION_CLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationFromClause getClassifyFromClause()
  {
    return classifyFromClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassifyFromClause(ClassificationFromClause newClassifyFromClause, NotificationChain msgs)
  {
    ClassificationFromClause oldClassifyFromClause = classifyFromClause;
    classifyFromClause = newClassifyFromClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE, oldClassifyFromClause, newClassifyFromClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassifyFromClause(ClassificationFromClause newClassifyFromClause)
  {
    if (newClassifyFromClause != classifyFromClause)
    {
      NotificationChain msgs = null;
      if (classifyFromClause != null)
        msgs = ((InternalEObject)classifyFromClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE, null, msgs);
      if (newClassifyFromClause != null)
        msgs = ((InternalEObject)newClassifyFromClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE, null, msgs);
      msgs = basicSetClassifyFromClause(newClassifyFromClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE, newClassifyFromClause, newClassifyFromClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationToClause getClassifyToClause()
  {
    return classifyToClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassifyToClause(ClassificationToClause newClassifyToClause, NotificationChain msgs)
  {
    ClassificationToClause oldClassifyToClause = classifyToClause;
    classifyToClause = newClassifyToClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE, oldClassifyToClause, newClassifyToClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassifyToClause(ClassificationToClause newClassifyToClause)
  {
    if (newClassifyToClause != classifyToClause)
    {
      NotificationChain msgs = null;
      if (classifyToClause != null)
        msgs = ((InternalEObject)classifyToClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE, null, msgs);
      if (newClassifyToClause != null)
        msgs = ((InternalEObject)newClassifyToClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE, null, msgs);
      msgs = basicSetClassifyToClause(newClassifyToClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE, newClassifyToClause, newClassifyToClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReclassifyAllClause getReclassyAllClause()
  {
    return reclassyAllClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReclassyAllClause(ReclassifyAllClause newReclassyAllClause, NotificationChain msgs)
  {
    ReclassifyAllClause oldReclassyAllClause = reclassyAllClause;
    reclassyAllClause = newReclassyAllClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE, oldReclassyAllClause, newReclassyAllClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReclassyAllClause(ReclassifyAllClause newReclassyAllClause)
  {
    if (newReclassyAllClause != reclassyAllClause)
    {
      NotificationChain msgs = null;
      if (reclassyAllClause != null)
        msgs = ((InternalEObject)reclassyAllClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE, null, msgs);
      if (newReclassyAllClause != null)
        msgs = ((InternalEObject)newReclassyAllClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE, null, msgs);
      msgs = basicSetReclassyAllClause(newReclassyAllClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE, newReclassyAllClause, newReclassyAllClause));
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE:
        return basicSetClassifyFromClause(null, msgs);
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE:
        return basicSetClassifyToClause(null, msgs);
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE:
        return basicSetReclassyAllClause(null, msgs);
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE:
        return getClassifyFromClause();
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE:
        return getClassifyToClause();
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE:
        return getReclassyAllClause();
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE:
        setClassifyFromClause((ClassificationFromClause)newValue);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE:
        setClassifyToClause((ClassificationToClause)newValue);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE:
        setReclassyAllClause((ReclassifyAllClause)newValue);
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE:
        setClassifyFromClause((ClassificationFromClause)null);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE:
        setClassifyToClause((ClassificationToClause)null);
        return;
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE:
        setReclassyAllClause((ReclassifyAllClause)null);
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
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_FROM_CLAUSE:
        return classifyFromClause != null;
      case AlfPackage.CLASSIFICATION_CLAUSE__CLASSIFY_TO_CLAUSE:
        return classifyToClause != null;
      case AlfPackage.CLASSIFICATION_CLAUSE__RECLASSY_ALL_CLAUSE:
        return reclassyAllClause != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassificationClauseImpl
