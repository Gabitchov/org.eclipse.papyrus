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
import org.eclipse.papyrus.alf.alf.Feature;
import org.eclipse.papyrus.alf.alf.FeatureInvocation;
import org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index;
import org.eclipse.papyrus.alf.alf.Index;
import org.eclipse.papyrus.alf.alf.SequenceOperationOrReductionOrExpansion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl#getFeatureInvocation <em>Feature Invocation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl#getSequenceOperationOrReductionOrExpansion <em>Sequence Operation Or Reduction Or Expansion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl extends MinimalEObjectImpl.Container implements Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index
{
  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected Feature feature;

  /**
   * The cached value of the '{@link #getFeatureInvocation() <em>Feature Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureInvocation()
   * @generated
   * @ordered
   */
  protected FeatureInvocation featureInvocation;

  /**
   * The cached value of the '{@link #getSequenceOperationOrReductionOrExpansion() <em>Sequence Operation Or Reduction Or Expansion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceOperationOrReductionOrExpansion()
   * @generated
   * @ordered
   */
  protected SequenceOperationOrReductionOrExpansion sequenceOperationOrReductionOrExpansion;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected Index index;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl()
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
    return AlfPackage.eINSTANCE.getFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeature(Feature newFeature, NotificationChain msgs)
  {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE, oldFeature, newFeature);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(Feature newFeature)
  {
    if (newFeature != feature)
    {
      NotificationChain msgs = null;
      if (feature != null)
        msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE, null, msgs);
      if (newFeature != null)
        msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE, null, msgs);
      msgs = basicSetFeature(newFeature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE, newFeature, newFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureInvocation getFeatureInvocation()
  {
    return featureInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeatureInvocation(FeatureInvocation newFeatureInvocation, NotificationChain msgs)
  {
    FeatureInvocation oldFeatureInvocation = featureInvocation;
    featureInvocation = newFeatureInvocation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION, oldFeatureInvocation, newFeatureInvocation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeatureInvocation(FeatureInvocation newFeatureInvocation)
  {
    if (newFeatureInvocation != featureInvocation)
    {
      NotificationChain msgs = null;
      if (featureInvocation != null)
        msgs = ((InternalEObject)featureInvocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION, null, msgs);
      if (newFeatureInvocation != null)
        msgs = ((InternalEObject)newFeatureInvocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION, null, msgs);
      msgs = basicSetFeatureInvocation(newFeatureInvocation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION, newFeatureInvocation, newFeatureInvocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceOperationOrReductionOrExpansion getSequenceOperationOrReductionOrExpansion()
  {
    return sequenceOperationOrReductionOrExpansion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceOperationOrReductionOrExpansion(SequenceOperationOrReductionOrExpansion newSequenceOperationOrReductionOrExpansion, NotificationChain msgs)
  {
    SequenceOperationOrReductionOrExpansion oldSequenceOperationOrReductionOrExpansion = sequenceOperationOrReductionOrExpansion;
    sequenceOperationOrReductionOrExpansion = newSequenceOperationOrReductionOrExpansion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION, oldSequenceOperationOrReductionOrExpansion, newSequenceOperationOrReductionOrExpansion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceOperationOrReductionOrExpansion(SequenceOperationOrReductionOrExpansion newSequenceOperationOrReductionOrExpansion)
  {
    if (newSequenceOperationOrReductionOrExpansion != sequenceOperationOrReductionOrExpansion)
    {
      NotificationChain msgs = null;
      if (sequenceOperationOrReductionOrExpansion != null)
        msgs = ((InternalEObject)sequenceOperationOrReductionOrExpansion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION, null, msgs);
      if (newSequenceOperationOrReductionOrExpansion != null)
        msgs = ((InternalEObject)newSequenceOperationOrReductionOrExpansion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION, null, msgs);
      msgs = basicSetSequenceOperationOrReductionOrExpansion(newSequenceOperationOrReductionOrExpansion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION, newSequenceOperationOrReductionOrExpansion, newSequenceOperationOrReductionOrExpansion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Index getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndex(Index newIndex, NotificationChain msgs)
  {
    Index oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX, oldIndex, newIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(Index newIndex)
  {
    if (newIndex != index)
    {
      NotificationChain msgs = null;
      if (index != null)
        msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX, null, msgs);
      if (newIndex != null)
        msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX, null, msgs);
      msgs = basicSetIndex(newIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX, newIndex, newIndex));
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
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE:
        return basicSetFeature(null, msgs);
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION:
        return basicSetFeatureInvocation(null, msgs);
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION:
        return basicSetSequenceOperationOrReductionOrExpansion(null, msgs);
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX:
        return basicSetIndex(null, msgs);
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
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE:
        return getFeature();
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION:
        return getFeatureInvocation();
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION:
        return getSequenceOperationOrReductionOrExpansion();
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX:
        return getIndex();
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
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE:
        setFeature((Feature)newValue);
        return;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION:
        setFeatureInvocation((FeatureInvocation)newValue);
        return;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION:
        setSequenceOperationOrReductionOrExpansion((SequenceOperationOrReductionOrExpansion)newValue);
        return;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX:
        setIndex((Index)newValue);
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
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE:
        setFeature((Feature)null);
        return;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION:
        setFeatureInvocation((FeatureInvocation)null);
        return;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION:
        setSequenceOperationOrReductionOrExpansion((SequenceOperationOrReductionOrExpansion)null);
        return;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX:
        setIndex((Index)null);
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
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE:
        return feature != null;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__FEATURE_INVOCATION:
        return featureInvocation != null;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION:
        return sequenceOperationOrReductionOrExpansion != null;
      case AlfPackage.FEATURE_OR_SEQUENCE_OPERATION_OR_REDUCTION_OR_EXPANSION_OR_INDEX__INDEX:
        return index != null;
    }
    return super.eIsSet(featureID);
  }

} //Feature_Or_SequenceOperationOrReductionOrExpansion_Or_IndexImpl
