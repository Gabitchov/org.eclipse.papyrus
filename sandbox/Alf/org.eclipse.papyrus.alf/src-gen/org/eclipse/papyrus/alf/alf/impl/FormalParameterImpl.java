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
import org.eclipse.papyrus.alf.alf.FormalParameter;
import org.eclipse.papyrus.alf.alf.Name;
import org.eclipse.papyrus.alf.alf.ParameterDirection;
import org.eclipse.papyrus.alf.alf.StereotypeAnnotations;
import org.eclipse.papyrus.alf.alf.TypePart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.FormalParameterImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.FormalParameterImpl#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.FormalParameterImpl#getParameterDirection <em>Parameter Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.FormalParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.FormalParameterImpl#getTypePart <em>Type Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalParameterImpl extends MinimalEObjectImpl.Container implements FormalParameter
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
   * The default value of the '{@link #getParameterDirection() <em>Parameter Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterDirection()
   * @generated
   * @ordered
   */
  protected static final ParameterDirection PARAMETER_DIRECTION_EDEFAULT = ParameterDirection.IN;

  /**
   * The cached value of the '{@link #getParameterDirection() <em>Parameter Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterDirection()
   * @generated
   * @ordered
   */
  protected ParameterDirection parameterDirection = PARAMETER_DIRECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Name name;

  /**
   * The cached value of the '{@link #getTypePart() <em>Type Part</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePart()
   * @generated
   * @ordered
   */
  protected TypePart typePart;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FormalParameterImpl()
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
    return AlfPackage.eINSTANCE.getFormalParameter();
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__COMMENT, oldComment, comment));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS, oldStereotypeAnnotations, newStereotypeAnnotations);
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
        msgs = ((InternalEObject)stereotypeAnnotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS, null, msgs);
      if (newStereotypeAnnotations != null)
        msgs = ((InternalEObject)newStereotypeAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS, null, msgs);
      msgs = basicSetStereotypeAnnotations(newStereotypeAnnotations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS, newStereotypeAnnotations, newStereotypeAnnotations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDirection getParameterDirection()
  {
    return parameterDirection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterDirection(ParameterDirection newParameterDirection)
  {
    ParameterDirection oldParameterDirection = parameterDirection;
    parameterDirection = newParameterDirection == null ? PARAMETER_DIRECTION_EDEFAULT : newParameterDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__PARAMETER_DIRECTION, oldParameterDirection, parameterDirection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Name newName, NotificationChain msgs)
  {
    Name oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Name newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FORMAL_PARAMETER__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FORMAL_PARAMETER__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePart getTypePart()
  {
    return typePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePart(TypePart newTypePart, NotificationChain msgs)
  {
    TypePart oldTypePart = typePart;
    typePart = newTypePart;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__TYPE_PART, oldTypePart, newTypePart);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePart(TypePart newTypePart)
  {
    if (newTypePart != typePart)
    {
      NotificationChain msgs = null;
      if (typePart != null)
        msgs = ((InternalEObject)typePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FORMAL_PARAMETER__TYPE_PART, null, msgs);
      if (newTypePart != null)
        msgs = ((InternalEObject)newTypePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.FORMAL_PARAMETER__TYPE_PART, null, msgs);
      msgs = basicSetTypePart(newTypePart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.FORMAL_PARAMETER__TYPE_PART, newTypePart, newTypePart));
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
      case AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS:
        return basicSetStereotypeAnnotations(null, msgs);
      case AlfPackage.FORMAL_PARAMETER__NAME:
        return basicSetName(null, msgs);
      case AlfPackage.FORMAL_PARAMETER__TYPE_PART:
        return basicSetTypePart(null, msgs);
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
      case AlfPackage.FORMAL_PARAMETER__COMMENT:
        return getComment();
      case AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS:
        return getStereotypeAnnotations();
      case AlfPackage.FORMAL_PARAMETER__PARAMETER_DIRECTION:
        return getParameterDirection();
      case AlfPackage.FORMAL_PARAMETER__NAME:
        return getName();
      case AlfPackage.FORMAL_PARAMETER__TYPE_PART:
        return getTypePart();
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
      case AlfPackage.FORMAL_PARAMETER__COMMENT:
        setComment((String)newValue);
        return;
      case AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)newValue);
        return;
      case AlfPackage.FORMAL_PARAMETER__PARAMETER_DIRECTION:
        setParameterDirection((ParameterDirection)newValue);
        return;
      case AlfPackage.FORMAL_PARAMETER__NAME:
        setName((Name)newValue);
        return;
      case AlfPackage.FORMAL_PARAMETER__TYPE_PART:
        setTypePart((TypePart)newValue);
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
      case AlfPackage.FORMAL_PARAMETER__COMMENT:
        setComment(COMMENT_EDEFAULT);
        return;
      case AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)null);
        return;
      case AlfPackage.FORMAL_PARAMETER__PARAMETER_DIRECTION:
        setParameterDirection(PARAMETER_DIRECTION_EDEFAULT);
        return;
      case AlfPackage.FORMAL_PARAMETER__NAME:
        setName((Name)null);
        return;
      case AlfPackage.FORMAL_PARAMETER__TYPE_PART:
        setTypePart((TypePart)null);
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
      case AlfPackage.FORMAL_PARAMETER__COMMENT:
        return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
      case AlfPackage.FORMAL_PARAMETER__STEREOTYPE_ANNOTATIONS:
        return stereotypeAnnotations != null;
      case AlfPackage.FORMAL_PARAMETER__PARAMETER_DIRECTION:
        return parameterDirection != PARAMETER_DIRECTION_EDEFAULT;
      case AlfPackage.FORMAL_PARAMETER__NAME:
        return name != null;
      case AlfPackage.FORMAL_PARAMETER__TYPE_PART:
        return typePart != null;
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
    result.append(", parameterDirection: ");
    result.append(parameterDirection);
    result.append(')');
    return result.toString();
  }

} //FormalParameterImpl
