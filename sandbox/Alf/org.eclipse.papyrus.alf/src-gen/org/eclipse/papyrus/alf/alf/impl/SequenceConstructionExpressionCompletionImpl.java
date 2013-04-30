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
import org.eclipse.papyrus.alf.alf.MultiplicityIndicator;
import org.eclipse.papyrus.alf.alf.SequenceConstructionExpressionCompletion;
import org.eclipse.papyrus.alf.alf.SequenceElements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Construction Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceConstructionExpressionCompletionImpl#getMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.SequenceConstructionExpressionCompletionImpl#getSequenceElements <em>Sequence Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceConstructionExpressionCompletionImpl extends MinimalEObjectImpl.Container implements SequenceConstructionExpressionCompletion
{
  /**
   * The cached value of the '{@link #getMultiplicityIndicator() <em>Multiplicity Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicityIndicator()
   * @generated
   * @ordered
   */
  protected MultiplicityIndicator multiplicityIndicator;

  /**
   * The cached value of the '{@link #getSequenceElements() <em>Sequence Elements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceElements()
   * @generated
   * @ordered
   */
  protected SequenceElements sequenceElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceConstructionExpressionCompletionImpl()
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
    return AlfPackage.eINSTANCE.getSequenceConstructionExpressionCompletion();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityIndicator getMultiplicityIndicator()
  {
    return multiplicityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicityIndicator(MultiplicityIndicator newMultiplicityIndicator, NotificationChain msgs)
  {
    MultiplicityIndicator oldMultiplicityIndicator = multiplicityIndicator;
    multiplicityIndicator = newMultiplicityIndicator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR, oldMultiplicityIndicator, newMultiplicityIndicator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicityIndicator(MultiplicityIndicator newMultiplicityIndicator)
  {
    if (newMultiplicityIndicator != multiplicityIndicator)
    {
      NotificationChain msgs = null;
      if (multiplicityIndicator != null)
        msgs = ((InternalEObject)multiplicityIndicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR, null, msgs);
      if (newMultiplicityIndicator != null)
        msgs = ((InternalEObject)newMultiplicityIndicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR, null, msgs);
      msgs = basicSetMultiplicityIndicator(newMultiplicityIndicator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR, newMultiplicityIndicator, newMultiplicityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceElements getSequenceElements()
  {
    return sequenceElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceElements(SequenceElements newSequenceElements, NotificationChain msgs)
  {
    SequenceElements oldSequenceElements = sequenceElements;
    sequenceElements = newSequenceElements;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS, oldSequenceElements, newSequenceElements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceElements(SequenceElements newSequenceElements)
  {
    if (newSequenceElements != sequenceElements)
    {
      NotificationChain msgs = null;
      if (sequenceElements != null)
        msgs = ((InternalEObject)sequenceElements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS, null, msgs);
      if (newSequenceElements != null)
        msgs = ((InternalEObject)newSequenceElements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS, null, msgs);
      msgs = basicSetSequenceElements(newSequenceElements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS, newSequenceElements, newSequenceElements));
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR:
        return basicSetMultiplicityIndicator(null, msgs);
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS:
        return basicSetSequenceElements(null, msgs);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR:
        return getMultiplicityIndicator();
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS:
        return getSequenceElements();
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator((MultiplicityIndicator)newValue);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS:
        setSequenceElements((SequenceElements)newValue);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator((MultiplicityIndicator)null);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS:
        setSequenceElements((SequenceElements)null);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__MULTIPLICITY_INDICATOR:
        return multiplicityIndicator != null;
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION_COMPLETION__SEQUENCE_ELEMENTS:
        return sequenceElements != null;
    }
    return super.eIsSet(featureID);
  }

} //SequenceConstructionExpressionCompletionImpl
