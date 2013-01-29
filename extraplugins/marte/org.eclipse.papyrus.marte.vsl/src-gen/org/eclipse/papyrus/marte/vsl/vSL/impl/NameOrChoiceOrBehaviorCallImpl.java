/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Or Choice Or Behavior Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.NameOrChoiceOrBehaviorCallImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameOrChoiceOrBehaviorCallImpl extends ValueSpecificationImpl implements NameOrChoiceOrBehaviorCall
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
   * The cached value of the '{@link #getId() <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected NamedElement id;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected ListOfValues arguments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameOrChoiceOrBehaviorCallImpl()
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
    return VSLPackage.Literals.NAME_OR_CHOICE_OR_BEHAVIOR_CALL;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH, oldPath, newPath);
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
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH, newPath, newPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getId()
  {
    if (id != null && id.eIsProxy())
    {
      InternalEObject oldId = (InternalEObject)id;
      id = (NamedElement)eResolveProxy(oldId);
      if (id != oldId)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID, oldId, id));
      }
    }
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(NamedElement newId)
  {
    NamedElement oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfValues getArguments()
  {
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArguments(ListOfValues newArguments, NotificationChain msgs)
  {
    ListOfValues oldArguments = arguments;
    arguments = newArguments;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, oldArguments, newArguments);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArguments(ListOfValues newArguments)
  {
    if (newArguments != arguments)
    {
      NotificationChain msgs = null;
      if (arguments != null)
        msgs = ((InternalEObject)arguments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, null, msgs);
      if (newArguments != null)
        msgs = ((InternalEObject)newArguments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, null, msgs);
      msgs = basicSetArguments(newArguments, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS, newArguments, newArguments));
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
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH:
        return basicSetPath(null, msgs);
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS:
        return basicSetArguments(null, msgs);
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
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH:
        return getPath();
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID:
        if (resolve) return getId();
        return basicGetId();
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS:
        return getArguments();
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
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH:
        setPath((QualifiedName)newValue);
        return;
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID:
        setId((NamedElement)newValue);
        return;
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS:
        setArguments((ListOfValues)newValue);
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
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH:
        setPath((QualifiedName)null);
        return;
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID:
        setId((NamedElement)null);
        return;
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS:
        setArguments((ListOfValues)null);
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
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__PATH:
        return path != null;
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ID:
        return id != null;
      case VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL__ARGUMENTS:
        return arguments != null;
    }
    return super.eIsSet(featureID);
  }

} //NameOrChoiceOrBehaviorCallImpl
