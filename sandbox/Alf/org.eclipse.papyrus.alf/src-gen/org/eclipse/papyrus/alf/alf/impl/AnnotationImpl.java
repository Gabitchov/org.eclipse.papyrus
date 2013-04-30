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
import org.eclipse.papyrus.alf.alf.Annotation;
import org.eclipse.papyrus.alf.alf.NameList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AnnotationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.impl.AnnotationImpl#getNameList <em>Name List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends MinimalEObjectImpl.Container implements Annotation
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getNameList() <em>Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameList()
   * @generated
   * @ordered
   */
  protected NameList nameList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationImpl()
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
    return AlfPackage.eINSTANCE.getAnnotation();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATION__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameList getNameList()
  {
    return nameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNameList(NameList newNameList, NotificationChain msgs)
  {
    NameList oldNameList = nameList;
    nameList = newNameList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATION__NAME_LIST, oldNameList, newNameList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameList(NameList newNameList)
  {
    if (newNameList != nameList)
    {
      NotificationChain msgs = null;
      if (nameList != null)
        msgs = ((InternalEObject)nameList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ANNOTATION__NAME_LIST, null, msgs);
      if (newNameList != null)
        msgs = ((InternalEObject)newNameList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.ANNOTATION__NAME_LIST, null, msgs);
      msgs = basicSetNameList(newNameList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.ANNOTATION__NAME_LIST, newNameList, newNameList));
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
      case AlfPackage.ANNOTATION__NAME_LIST:
        return basicSetNameList(null, msgs);
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
      case AlfPackage.ANNOTATION__ID:
        return getId();
      case AlfPackage.ANNOTATION__NAME_LIST:
        return getNameList();
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
      case AlfPackage.ANNOTATION__ID:
        setId((String)newValue);
        return;
      case AlfPackage.ANNOTATION__NAME_LIST:
        setNameList((NameList)newValue);
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
      case AlfPackage.ANNOTATION__ID:
        setId(ID_EDEFAULT);
        return;
      case AlfPackage.ANNOTATION__NAME_LIST:
        setNameList((NameList)null);
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
      case AlfPackage.ANNOTATION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case AlfPackage.ANNOTATION__NAME_LIST:
        return nameList != null;
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //AnnotationImpl
