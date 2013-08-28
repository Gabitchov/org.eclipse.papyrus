/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.alf.SequenceElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Construction Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceConstructionExpressionImpl#getSequenceElement <em>Sequence Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.SequenceConstructionExpressionImpl#getRangeUpper <em>Range Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceConstructionExpressionImpl extends SequenceElementImpl implements SequenceConstructionExpression
{
  /**
   * The cached value of the '{@link #getSequenceElement() <em>Sequence Element</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceElement()
   * @generated
   * @ordered
   */
  protected EList<SequenceElement> sequenceElement;

  /**
   * The cached value of the '{@link #getRangeUpper() <em>Range Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRangeUpper()
   * @generated
   * @ordered
   */
  protected Expression rangeUpper;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SequenceConstructionExpressionImpl()
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
    return AlfPackage.Literals.SEQUENCE_CONSTRUCTION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SequenceElement> getSequenceElement()
  {
    if (sequenceElement == null)
    {
      sequenceElement = new EObjectContainmentEList<SequenceElement>(SequenceElement.class, this, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT);
    }
    return sequenceElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getRangeUpper()
  {
    return rangeUpper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRangeUpper(Expression newRangeUpper, NotificationChain msgs)
  {
    Expression oldRangeUpper = rangeUpper;
    rangeUpper = newRangeUpper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER, oldRangeUpper, newRangeUpper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRangeUpper(Expression newRangeUpper)
  {
    if (newRangeUpper != rangeUpper)
    {
      NotificationChain msgs = null;
      if (rangeUpper != null)
        msgs = ((InternalEObject)rangeUpper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER, null, msgs);
      if (newRangeUpper != null)
        msgs = ((InternalEObject)newRangeUpper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER, null, msgs);
      msgs = basicSetRangeUpper(newRangeUpper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER, newRangeUpper, newRangeUpper));
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT:
        return ((InternalEList<?>)getSequenceElement()).basicRemove(otherEnd, msgs);
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER:
        return basicSetRangeUpper(null, msgs);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT:
        return getSequenceElement();
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER:
        return getRangeUpper();
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT:
        getSequenceElement().clear();
        getSequenceElement().addAll((Collection<? extends SequenceElement>)newValue);
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER:
        setRangeUpper((Expression)newValue);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT:
        getSequenceElement().clear();
        return;
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER:
        setRangeUpper((Expression)null);
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
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__SEQUENCE_ELEMENT:
        return sequenceElement != null && !sequenceElement.isEmpty();
      case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION__RANGE_UPPER:
        return rangeUpper != null;
    }
    return super.eIsSet(featureID);
  }

} //SequenceConstructionExpressionImpl
