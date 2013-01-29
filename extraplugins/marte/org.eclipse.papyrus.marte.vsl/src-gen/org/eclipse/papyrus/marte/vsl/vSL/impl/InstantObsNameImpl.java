/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.marte.vsl.vSL.InstantObsName;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instant Obs Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsNameImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.InstantObsNameImpl#getInstantId <em>Instant Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstantObsNameImpl extends MinimalEObjectImpl.Container implements InstantObsName
{
  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected QualifiedName path;

  /**
   * The cached value of the '{@link #getInstantId() <em>Instant Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstantId()
   * @generated
   * @ordered
   */
  protected TimeObservation instantId;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InstantObsNameImpl()
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
    return VSLPackage.Literals.INSTANT_OBS_NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getPath()
  {
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(QualifiedName newPath, NotificationChain msgs)
  {
    QualifiedName oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.INSTANT_OBS_NAME__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPath(QualifiedName newPath)
  {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.INSTANT_OBS_NAME__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.INSTANT_OBS_NAME__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.INSTANT_OBS_NAME__PATH, newPath, newPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeObservation getInstantId()
  {
    if (instantId != null && instantId.eIsProxy())
    {
      InternalEObject oldInstantId = (InternalEObject)instantId;
      instantId = (TimeObservation)eResolveProxy(oldInstantId);
      if (instantId != oldInstantId)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VSLPackage.INSTANT_OBS_NAME__INSTANT_ID, oldInstantId, instantId));
      }
    }
    return instantId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeObservation basicGetInstantId()
  {
    return instantId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstantId(TimeObservation newInstantId)
  {
    TimeObservation oldInstantId = instantId;
    instantId = newInstantId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.INSTANT_OBS_NAME__INSTANT_ID, oldInstantId, instantId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getFilteredParentRule(final EClass filter)
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getExpectedType()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getContextElement()
  {
    return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;
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
      case VSLPackage.INSTANT_OBS_NAME__PATH:
        return basicSetPath(null, msgs);
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
      case VSLPackage.INSTANT_OBS_NAME__PATH:
        return getPath();
      case VSLPackage.INSTANT_OBS_NAME__INSTANT_ID:
        if (resolve) return getInstantId();
        return basicGetInstantId();
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
      case VSLPackage.INSTANT_OBS_NAME__PATH:
        setPath((QualifiedName)newValue);
        return;
      case VSLPackage.INSTANT_OBS_NAME__INSTANT_ID:
        setInstantId((TimeObservation)newValue);
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
      case VSLPackage.INSTANT_OBS_NAME__PATH:
        setPath((QualifiedName)null);
        return;
      case VSLPackage.INSTANT_OBS_NAME__INSTANT_ID:
        setInstantId((TimeObservation)null);
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
      case VSLPackage.INSTANT_OBS_NAME__PATH:
        return path != null;
      case VSLPackage.INSTANT_OBS_NAME__INSTANT_ID:
        return instantId != null;
    }
    return super.eIsSet(featureID);
  }

} //InstantObsNameImpl
