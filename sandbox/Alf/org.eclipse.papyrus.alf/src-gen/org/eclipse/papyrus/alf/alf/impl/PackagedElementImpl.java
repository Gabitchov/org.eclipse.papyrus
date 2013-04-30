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
import org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator;
import org.eclipse.papyrus.alf.alf.PackagedElement;
import org.eclipse.papyrus.alf.alf.PackagedElementDefinition;
import org.eclipse.papyrus.alf.alf.StereotypeAnnotations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packaged Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackagedElementImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackagedElementImpl#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackagedElementImpl#getImportVisibilityIndicator <em>Import Visibility Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.PackagedElementImpl#getPackagedElementDefinition <em>Packaged Element Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackagedElementImpl extends MinimalEObjectImpl.Container implements PackagedElement
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
   * The default value of the '{@link #getImportVisibilityIndicator() <em>Import Visibility Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportVisibilityIndicator()
   * @generated
   * @ordered
   */
  protected static final ImportVisibilityIndicator IMPORT_VISIBILITY_INDICATOR_EDEFAULT = ImportVisibilityIndicator.PUBLIC;

  /**
   * The cached value of the '{@link #getImportVisibilityIndicator() <em>Import Visibility Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportVisibilityIndicator()
   * @generated
   * @ordered
   */
  protected ImportVisibilityIndicator importVisibilityIndicator = IMPORT_VISIBILITY_INDICATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getPackagedElementDefinition() <em>Packaged Element Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackagedElementDefinition()
   * @generated
   * @ordered
   */
  protected PackagedElementDefinition packagedElementDefinition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackagedElementImpl()
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
    return AlfPackage.eINSTANCE.getPackagedElement();
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGED_ELEMENT__COMMENT, oldComment, comment));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS, oldStereotypeAnnotations, newStereotypeAnnotations);
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
        msgs = ((InternalEObject)stereotypeAnnotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS, null, msgs);
      if (newStereotypeAnnotations != null)
        msgs = ((InternalEObject)newStereotypeAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS, null, msgs);
      msgs = basicSetStereotypeAnnotations(newStereotypeAnnotations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS, newStereotypeAnnotations, newStereotypeAnnotations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportVisibilityIndicator getImportVisibilityIndicator()
  {
    return importVisibilityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImportVisibilityIndicator(ImportVisibilityIndicator newImportVisibilityIndicator)
  {
    ImportVisibilityIndicator oldImportVisibilityIndicator = importVisibilityIndicator;
    importVisibilityIndicator = newImportVisibilityIndicator == null ? IMPORT_VISIBILITY_INDICATOR_EDEFAULT : newImportVisibilityIndicator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGED_ELEMENT__IMPORT_VISIBILITY_INDICATOR, oldImportVisibilityIndicator, importVisibilityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackagedElementDefinition getPackagedElementDefinition()
  {
    return packagedElementDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackagedElementDefinition(PackagedElementDefinition newPackagedElementDefinition, NotificationChain msgs)
  {
    PackagedElementDefinition oldPackagedElementDefinition = packagedElementDefinition;
    packagedElementDefinition = newPackagedElementDefinition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION, oldPackagedElementDefinition, newPackagedElementDefinition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackagedElementDefinition(PackagedElementDefinition newPackagedElementDefinition)
  {
    if (newPackagedElementDefinition != packagedElementDefinition)
    {
      NotificationChain msgs = null;
      if (packagedElementDefinition != null)
        msgs = ((InternalEObject)packagedElementDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION, null, msgs);
      if (newPackagedElementDefinition != null)
        msgs = ((InternalEObject)newPackagedElementDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION, null, msgs);
      msgs = basicSetPackagedElementDefinition(newPackagedElementDefinition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION, newPackagedElementDefinition, newPackagedElementDefinition));
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
      case AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS:
        return basicSetStereotypeAnnotations(null, msgs);
      case AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION:
        return basicSetPackagedElementDefinition(null, msgs);
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
      case AlfPackage.PACKAGED_ELEMENT__COMMENT:
        return getComment();
      case AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS:
        return getStereotypeAnnotations();
      case AlfPackage.PACKAGED_ELEMENT__IMPORT_VISIBILITY_INDICATOR:
        return getImportVisibilityIndicator();
      case AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION:
        return getPackagedElementDefinition();
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
      case AlfPackage.PACKAGED_ELEMENT__COMMENT:
        setComment((String)newValue);
        return;
      case AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)newValue);
        return;
      case AlfPackage.PACKAGED_ELEMENT__IMPORT_VISIBILITY_INDICATOR:
        setImportVisibilityIndicator((ImportVisibilityIndicator)newValue);
        return;
      case AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION:
        setPackagedElementDefinition((PackagedElementDefinition)newValue);
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
      case AlfPackage.PACKAGED_ELEMENT__COMMENT:
        setComment(COMMENT_EDEFAULT);
        return;
      case AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS:
        setStereotypeAnnotations((StereotypeAnnotations)null);
        return;
      case AlfPackage.PACKAGED_ELEMENT__IMPORT_VISIBILITY_INDICATOR:
        setImportVisibilityIndicator(IMPORT_VISIBILITY_INDICATOR_EDEFAULT);
        return;
      case AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION:
        setPackagedElementDefinition((PackagedElementDefinition)null);
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
      case AlfPackage.PACKAGED_ELEMENT__COMMENT:
        return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
      case AlfPackage.PACKAGED_ELEMENT__STEREOTYPE_ANNOTATIONS:
        return stereotypeAnnotations != null;
      case AlfPackage.PACKAGED_ELEMENT__IMPORT_VISIBILITY_INDICATOR:
        return importVisibilityIndicator != IMPORT_VISIBILITY_INDICATOR_EDEFAULT;
      case AlfPackage.PACKAGED_ELEMENT__PACKAGED_ELEMENT_DEFINITION:
        return packagedElementDefinition != null;
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
    result.append(", importVisibilityIndicator: ");
    result.append(importVisibilityIndicator);
    result.append(')');
    return result.toString();
  }

} //PackagedElementImpl
