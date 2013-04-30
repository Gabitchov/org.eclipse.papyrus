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
import org.eclipse.papyrus.alf.alf.QualifiedName;
import org.eclipse.papyrus.alf.alf.StereotypeAnnotation;
import org.eclipse.papyrus.alf.alf.TaggedValues;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StereotypeAnnotationImpl#getStereotypeName <em>Stereotype Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StereotypeAnnotationImpl#getTaggedValues <em>Tagged Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeAnnotationImpl extends MinimalEObjectImpl.Container implements StereotypeAnnotation
{
  /**
   * The cached value of the '{@link #getStereotypeName() <em>Stereotype Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypeName()
   * @generated
   * @ordered
   */
  protected QualifiedName stereotypeName;

  /**
   * The cached value of the '{@link #getTaggedValues() <em>Tagged Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaggedValues()
   * @generated
   * @ordered
   */
  protected TaggedValues taggedValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StereotypeAnnotationImpl()
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
    return AlfPackage.eINSTANCE.getStereotypeAnnotation();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getStereotypeName()
  {
    return stereotypeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStereotypeName(QualifiedName newStereotypeName, NotificationChain msgs)
  {
    QualifiedName oldStereotypeName = stereotypeName;
    stereotypeName = newStereotypeName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME, oldStereotypeName, newStereotypeName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStereotypeName(QualifiedName newStereotypeName)
  {
    if (newStereotypeName != stereotypeName)
    {
      NotificationChain msgs = null;
      if (stereotypeName != null)
        msgs = ((InternalEObject)stereotypeName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME, null, msgs);
      if (newStereotypeName != null)
        msgs = ((InternalEObject)newStereotypeName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME, null, msgs);
      msgs = basicSetStereotypeName(newStereotypeName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME, newStereotypeName, newStereotypeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TaggedValues getTaggedValues()
  {
    return taggedValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTaggedValues(TaggedValues newTaggedValues, NotificationChain msgs)
  {
    TaggedValues oldTaggedValues = taggedValues;
    taggedValues = newTaggedValues;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES, oldTaggedValues, newTaggedValues);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTaggedValues(TaggedValues newTaggedValues)
  {
    if (newTaggedValues != taggedValues)
    {
      NotificationChain msgs = null;
      if (taggedValues != null)
        msgs = ((InternalEObject)taggedValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES, null, msgs);
      if (newTaggedValues != null)
        msgs = ((InternalEObject)newTaggedValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES, null, msgs);
      msgs = basicSetTaggedValues(newTaggedValues, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES, newTaggedValues, newTaggedValues));
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
      case AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME:
        return basicSetStereotypeName(null, msgs);
      case AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES:
        return basicSetTaggedValues(null, msgs);
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
      case AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME:
        return getStereotypeName();
      case AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES:
        return getTaggedValues();
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
      case AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME:
        setStereotypeName((QualifiedName)newValue);
        return;
      case AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES:
        setTaggedValues((TaggedValues)newValue);
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
      case AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME:
        setStereotypeName((QualifiedName)null);
        return;
      case AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES:
        setTaggedValues((TaggedValues)null);
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
      case AlfPackage.STEREOTYPE_ANNOTATION__STEREOTYPE_NAME:
        return stereotypeName != null;
      case AlfPackage.STEREOTYPE_ANNOTATION__TAGGED_VALUES:
        return taggedValues != null;
    }
    return super.eIsSet(featureID);
  }

} //StereotypeAnnotationImpl
