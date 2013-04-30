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
import org.eclipse.papyrus.alf.alf.PropertyDefinition;
import org.eclipse.papyrus.alf.alf.StereotypeAnnotations;
import org.eclipse.papyrus.alf.alf.StructuredMember;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StructuredMemberImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StructuredMemberImpl#getStreotypeAnnotations <em>Streotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StructuredMemberImpl#isIsPublic <em>Is Public</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.StructuredMemberImpl#getPropertyDefinition <em>Property Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructuredMemberImpl extends MinimalEObjectImpl.Container implements StructuredMember
{
  /**
   * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment()
   * @generated
   * @ordered
   */
  protected static final String COMMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComment()
   * @generated
   * @ordered
   */
  protected String comment = COMMENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getStreotypeAnnotations() <em>Streotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStreotypeAnnotations()
   * @generated
   * @ordered
   */
  protected StereotypeAnnotations streotypeAnnotations;

  /**
   * The default value of the '{@link #isIsPublic() <em>Is Public</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPublic()
   * @generated
   * @ordered
   */
  protected static final boolean IS_PUBLIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsPublic() <em>Is Public</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPublic()
   * @generated
   * @ordered
   */
  protected boolean isPublic = IS_PUBLIC_EDEFAULT;

  /**
   * The cached value of the '{@link #getPropertyDefinition() <em>Property Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyDefinition()
   * @generated
   * @ordered
   */
  protected PropertyDefinition propertyDefinition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructuredMemberImpl()
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
    return AlfPackage.eINSTANCE.getStructuredMember();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getComment()
  {
    return comment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComment(String newComment)
  {
    String oldComment = comment;
    comment = newComment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.STRUCTURED_MEMBER__COMMENT, oldComment, comment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeAnnotations getStreotypeAnnotations()
  {
    return streotypeAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStreotypeAnnotations(StereotypeAnnotations newStreotypeAnnotations, NotificationChain msgs)
  {
    StereotypeAnnotations oldStreotypeAnnotations = streotypeAnnotations;
    streotypeAnnotations = newStreotypeAnnotations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS, oldStreotypeAnnotations, newStreotypeAnnotations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStreotypeAnnotations(StereotypeAnnotations newStreotypeAnnotations)
  {
    if (newStreotypeAnnotations != streotypeAnnotations)
    {
      NotificationChain msgs = null;
      if (streotypeAnnotations != null)
        msgs = ((InternalEObject)streotypeAnnotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS, null, msgs);
      if (newStreotypeAnnotations != null)
        msgs = ((InternalEObject)newStreotypeAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS, null, msgs);
      msgs = basicSetStreotypeAnnotations(newStreotypeAnnotations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS, newStreotypeAnnotations, newStreotypeAnnotations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsPublic()
  {
    return isPublic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsPublic(boolean newIsPublic)
  {
    boolean oldIsPublic = isPublic;
    isPublic = newIsPublic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.STRUCTURED_MEMBER__IS_PUBLIC, oldIsPublic, isPublic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyDefinition getPropertyDefinition()
  {
    return propertyDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPropertyDefinition(PropertyDefinition newPropertyDefinition, NotificationChain msgs)
  {
    PropertyDefinition oldPropertyDefinition = propertyDefinition;
    propertyDefinition = newPropertyDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION, oldPropertyDefinition, newPropertyDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropertyDefinition(PropertyDefinition newPropertyDefinition)
  {
    if (newPropertyDefinition != propertyDefinition)
    {
      NotificationChain msgs = null;
      if (propertyDefinition != null)
        msgs = ((InternalEObject)propertyDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION, null, msgs);
      if (newPropertyDefinition != null)
        msgs = ((InternalEObject)newPropertyDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION, null, msgs);
      msgs = basicSetPropertyDefinition(newPropertyDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION, newPropertyDefinition, newPropertyDefinition));
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
      case AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS:
        return basicSetStreotypeAnnotations(null, msgs);
      case AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION:
        return basicSetPropertyDefinition(null, msgs);
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
      case AlfPackage.STRUCTURED_MEMBER__COMMENT:
        return getComment();
      case AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS:
        return getStreotypeAnnotations();
      case AlfPackage.STRUCTURED_MEMBER__IS_PUBLIC:
        return isIsPublic();
      case AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION:
        return getPropertyDefinition();
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
      case AlfPackage.STRUCTURED_MEMBER__COMMENT:
        setComment((String)newValue);
        return;
      case AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS:
        setStreotypeAnnotations((StereotypeAnnotations)newValue);
        return;
      case AlfPackage.STRUCTURED_MEMBER__IS_PUBLIC:
        setIsPublic((Boolean)newValue);
        return;
      case AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION:
        setPropertyDefinition((PropertyDefinition)newValue);
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
      case AlfPackage.STRUCTURED_MEMBER__COMMENT:
        setComment(COMMENT_EDEFAULT);
        return;
      case AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS:
        setStreotypeAnnotations((StereotypeAnnotations)null);
        return;
      case AlfPackage.STRUCTURED_MEMBER__IS_PUBLIC:
        setIsPublic(IS_PUBLIC_EDEFAULT);
        return;
      case AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION:
        setPropertyDefinition((PropertyDefinition)null);
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
      case AlfPackage.STRUCTURED_MEMBER__COMMENT:
        return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
      case AlfPackage.STRUCTURED_MEMBER__STREOTYPE_ANNOTATIONS:
        return streotypeAnnotations != null;
      case AlfPackage.STRUCTURED_MEMBER__IS_PUBLIC:
        return isPublic != IS_PUBLIC_EDEFAULT;
      case AlfPackage.STRUCTURED_MEMBER__PROPERTY_DEFINITION:
        return propertyDefinition != null;
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
    result.append(" (comment: ");
    result.append(comment);
    result.append(", isPublic: ");
    result.append(isPublic);
    result.append(')');
    return result.toString();
  }

} //StructuredMemberImpl
