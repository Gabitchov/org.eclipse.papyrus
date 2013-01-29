/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.TupleImpl#getListOfValueNamePairs <em>List Of Value Name Pairs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleImpl extends ValueSpecificationImpl implements Tuple
{
  /**
   * The cached value of the '{@link #getListOfValueNamePairs() <em>List Of Value Name Pairs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListOfValueNamePairs()
   * @generated
   * @ordered
   */
  protected ListOfValueNamePairs listOfValueNamePairs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleImpl()
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
    return VSLPackage.Literals.TUPLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfValueNamePairs getListOfValueNamePairs()
  {
    return listOfValueNamePairs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetListOfValueNamePairs(ListOfValueNamePairs newListOfValueNamePairs, NotificationChain msgs)
  {
    ListOfValueNamePairs oldListOfValueNamePairs = listOfValueNamePairs;
    listOfValueNamePairs = newListOfValueNamePairs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS, oldListOfValueNamePairs, newListOfValueNamePairs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setListOfValueNamePairs(ListOfValueNamePairs newListOfValueNamePairs)
  {
    if (newListOfValueNamePairs != listOfValueNamePairs)
    {
      NotificationChain msgs = null;
      if (listOfValueNamePairs != null)
        msgs = ((InternalEObject)listOfValueNamePairs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS, null, msgs);
      if (newListOfValueNamePairs != null)
        msgs = ((InternalEObject)newListOfValueNamePairs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS, null, msgs);
      msgs = basicSetListOfValueNamePairs(newListOfValueNamePairs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS, newListOfValueNamePairs, newListOfValueNamePairs));
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
      case VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS:
        return basicSetListOfValueNamePairs(null, msgs);
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
      case VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS:
        return getListOfValueNamePairs();
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
      case VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS:
        setListOfValueNamePairs((ListOfValueNamePairs)newValue);
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
      case VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS:
        setListOfValueNamePairs((ListOfValueNamePairs)null);
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
      case VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS:
        return listOfValueNamePairs != null;
    }
    return super.eIsSet(featureID);
  }

} //TupleImpl
