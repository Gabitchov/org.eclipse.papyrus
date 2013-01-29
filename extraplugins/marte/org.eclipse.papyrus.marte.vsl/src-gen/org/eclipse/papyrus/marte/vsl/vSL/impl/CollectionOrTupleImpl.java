/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Or Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.CollectionOrTupleImpl#getListOfValues <em>List Of Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionOrTupleImpl extends ValueSpecificationImpl implements CollectionOrTuple
{
  /**
   * The cached value of the '{@link #getListOfValues() <em>List Of Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListOfValues()
   * @generated
   * @ordered
   */
  protected ListOfValues listOfValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionOrTupleImpl()
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
    return VSLPackage.Literals.COLLECTION_OR_TUPLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfValues getListOfValues()
  {
    return listOfValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetListOfValues(ListOfValues newListOfValues, NotificationChain msgs)
  {
    ListOfValues oldListOfValues = listOfValues;
    listOfValues = newListOfValues;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES, oldListOfValues, newListOfValues);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setListOfValues(ListOfValues newListOfValues)
  {
    if (newListOfValues != listOfValues)
    {
      NotificationChain msgs = null;
      if (listOfValues != null)
        msgs = ((InternalEObject)listOfValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES, null, msgs);
      if (newListOfValues != null)
        msgs = ((InternalEObject)newListOfValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES, null, msgs);
      msgs = basicSetListOfValues(newListOfValues, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES, newListOfValues, newListOfValues));
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
      case VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES:
        return basicSetListOfValues(null, msgs);
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
      case VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES:
        return getListOfValues();
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
      case VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES:
        setListOfValues((ListOfValues)newValue);
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
      case VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES:
        setListOfValues((ListOfValues)null);
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
      case VSLPackage.COLLECTION_OR_TUPLE__LIST_OF_VALUES:
        return listOfValues != null;
    }
    return super.eIsSet(featureID);
  }

} //CollectionOrTupleImpl
