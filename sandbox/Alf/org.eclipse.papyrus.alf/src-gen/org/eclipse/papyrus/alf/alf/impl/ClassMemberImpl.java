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
import org.eclipse.papyrus.alf.alf.ClassMember;
import org.eclipse.papyrus.alf.alf.ClassMemberDefinition;
import org.eclipse.papyrus.alf.alf.StereotypeAnnotations;
import org.eclipse.papyrus.alf.alf.VisibilityIndicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassMemberImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassMemberImpl#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassMemberImpl#getVisibilityIndicator <em>Visibility Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.ClassMemberImpl#getClassMemberDefinition <em>Class Member Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassMemberImpl extends MinimalEObjectImpl.Container implements ClassMember
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
   * The cached value of the '{@link #getStereotypeAnnotations() <em>Stereotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypeAnnotations()
   * @generated
   * @ordered
   */
  protected StereotypeAnnotations stereotypeAnnotations;

  /**
   * The cached value of the '{@link #getVisibilityIndicator() <em>Visibility Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibilityIndicator()
   * @generated
   * @ordered
   */
  protected VisibilityIndicator visibilityIndicator;

  /**
   * The cached value of the '{@link #getClassMemberDefinition() <em>Class Member Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassMemberDefinition()
   * @generated
   * @ordered
   */
  protected ClassMemberDefinition classMemberDefinition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassMemberImpl()
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
    return AlfPackage.eINSTANCE.getClassMember();
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__COMMENT, oldComment, comment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeAnnotations getStereotypeAnnotations()
  {
    return stereotypeAnnotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStereotypeAnnotations(StereotypeAnnotations newStereotypeAnnotations, NotificationChain msgs)
  {
    StereotypeAnnotations oldStereotypeAnnotations = stereotypeAnnotations;
    stereotypeAnnotations = newStereotypeAnnotations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS, oldStereotypeAnnotations, newStereotypeAnnotations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStereotypeAnnotations(StereotypeAnnotations newStereotypeAnnotations)
  {
    if (newStereotypeAnnotations != stereotypeAnnotations)
    {
      NotificationChain msgs = null;
      if (stereotypeAnnotations != null)
        msgs = ((InternalEObject)stereotypeAnnotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS, null, msgs);
      if (newStereotypeAnnotations != null)
        msgs = ((InternalEObject)newStereotypeAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS, null, msgs);
      msgs = basicSetStereotypeAnnotations(newStereotypeAnnotations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS, newStereotypeAnnotations, newStereotypeAnnotations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityIndicator getVisibilityIndicator()
  {
    return visibilityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVisibilityIndicator(VisibilityIndicator newVisibilityIndicator, NotificationChain msgs)
  {
    VisibilityIndicator oldVisibilityIndicator = visibilityIndicator;
    visibilityIndicator = newVisibilityIndicator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR, oldVisibilityIndicator, newVisibilityIndicator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibilityIndicator(VisibilityIndicator newVisibilityIndicator)
  {
    if (newVisibilityIndicator != visibilityIndicator)
    {
      NotificationChain msgs = null;
      if (visibilityIndicator != null)
        msgs = ((InternalEObject)visibilityIndicator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR, null, msgs);
      if (newVisibilityIndicator != null)
        msgs = ((InternalEObject)newVisibilityIndicator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR, null, msgs);
      msgs = basicSetVisibilityIndicator(newVisibilityIndicator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR, newVisibilityIndicator, newVisibilityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassMemberDefinition getClassMemberDefinition()
  {
    return classMemberDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassMemberDefinition(ClassMemberDefinition newClassMemberDefinition, NotificationChain msgs)
  {
    ClassMemberDefinition oldClassMemberDefinition = classMemberDefinition;
    classMemberDefinition = newClassMemberDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION, oldClassMemberDefinition, newClassMemberDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassMemberDefinition(ClassMemberDefinition newClassMemberDefinition)
  {
    if (newClassMemberDefinition != classMemberDefinition)
    {
      NotificationChain msgs = null;
      if (classMemberDefinition != null)
        msgs = ((InternalEObject)classMemberDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION, null, msgs);
      if (newClassMemberDefinition != null)
        msgs = ((InternalEObject)newClassMemberDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION, null, msgs);
      msgs = basicSetClassMemberDefinition(newClassMemberDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION, newClassMemberDefinition, newClassMemberDefinition));
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
      case AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS:
        return basicSetStereotypeAnnotations(null, msgs);
      case AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR:
        return basicSetVisibilityIndicator(null, msgs);
      case AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION:
        return basicSetClassMemberDefinition(null, msgs);
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
      case AlfPackage.CLASS_MEMBER__COMMENT:
        return getComment();
      case AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS:
        return getStereotypeAnnotations();
      case AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR:
        return getVisibilityIndicator();
      case AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION:
        return getClassMemberDefinition();
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
      case AlfPackage.CLASS_MEMBER__COMMENT:
        setComment((String)newValue);
        return;
      case AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)newValue);
        return;
      case AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR:
        setVisibilityIndicator((VisibilityIndicator)newValue);
        return;
      case AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION:
        setClassMemberDefinition((ClassMemberDefinition)newValue);
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
      case AlfPackage.CLASS_MEMBER__COMMENT:
        setComment(COMMENT_EDEFAULT);
        return;
      case AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)null);
        return;
      case AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR:
        setVisibilityIndicator((VisibilityIndicator)null);
        return;
      case AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION:
        setClassMemberDefinition((ClassMemberDefinition)null);
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
      case AlfPackage.CLASS_MEMBER__COMMENT:
        return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
      case AlfPackage.CLASS_MEMBER__STEREOTYPE_ANNOTATIONS:
        return stereotypeAnnotations != null;
      case AlfPackage.CLASS_MEMBER__VISIBILITY_INDICATOR:
        return visibilityIndicator != null;
      case AlfPackage.CLASS_MEMBER__CLASS_MEMBER_DEFINITION:
        return classMemberDefinition != null;
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
    result.append(')');
    return result.toString();
  }

} //ClassMemberImpl
