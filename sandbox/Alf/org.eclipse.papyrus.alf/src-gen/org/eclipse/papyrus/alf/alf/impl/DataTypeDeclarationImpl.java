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
import org.eclipse.papyrus.alf.alf.ClassifierSignature;
import org.eclipse.papyrus.alf.alf.DataTypeDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.DataTypeDeclarationImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.DataTypeDeclarationImpl#getClassifierSignature <em>Classifier Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeDeclarationImpl extends MinimalEObjectImpl.Container implements DataTypeDeclaration
{
  /**
   * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean IS_ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsAbstract()
   * @generated
   * @ordered
   */
  protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getClassifierSignature() <em>Classifier Signature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifierSignature()
   * @generated
   * @ordered
   */
  protected ClassifierSignature classifierSignature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataTypeDeclarationImpl()
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
    return AlfPackage.eINSTANCE.getDataTypeDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsAbstract()
  {
    return isAbstract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsAbstract(boolean newIsAbstract)
  {
    boolean oldIsAbstract = isAbstract;
    isAbstract = newIsAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DECLARATION__IS_ABSTRACT, oldIsAbstract, isAbstract));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierSignature getClassifierSignature()
  {
    return classifierSignature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassifierSignature(ClassifierSignature newClassifierSignature, NotificationChain msgs)
  {
    ClassifierSignature oldClassifierSignature = classifierSignature;
    classifierSignature = newClassifierSignature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE, oldClassifierSignature, newClassifierSignature);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassifierSignature(ClassifierSignature newClassifierSignature)
  {
    if (newClassifierSignature != classifierSignature)
    {
      NotificationChain msgs = null;
      if (classifierSignature != null)
        msgs = ((InternalEObject)classifierSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE, null, msgs);
      if (newClassifierSignature != null)
        msgs = ((InternalEObject)newClassifierSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE, null, msgs);
      msgs = basicSetClassifierSignature(newClassifierSignature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE, newClassifierSignature, newClassifierSignature));
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
      case AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE:
        return basicSetClassifierSignature(null, msgs);
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
      case AlfPackage.DATA_TYPE_DECLARATION__IS_ABSTRACT:
        return isIsAbstract();
      case AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE:
        return getClassifierSignature();
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
      case AlfPackage.DATA_TYPE_DECLARATION__IS_ABSTRACT:
        setIsAbstract((Boolean)newValue);
        return;
      case AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE:
        setClassifierSignature((ClassifierSignature)newValue);
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
      case AlfPackage.DATA_TYPE_DECLARATION__IS_ABSTRACT:
        setIsAbstract(IS_ABSTRACT_EDEFAULT);
        return;
      case AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE:
        setClassifierSignature((ClassifierSignature)null);
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
      case AlfPackage.DATA_TYPE_DECLARATION__IS_ABSTRACT:
        return isAbstract != IS_ABSTRACT_EDEFAULT;
      case AlfPackage.DATA_TYPE_DECLARATION__CLASSIFIER_SIGNATURE:
        return classifierSignature != null;
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
    result.append(" (isAbstract: ");
    result.append(isAbstract);
    result.append(')');
    return result.toString();
  }

} //DataTypeDeclarationImpl
