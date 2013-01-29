/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.marte.vsl.vSL.DataTypeName;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl#getVariableDeclaration <em>Variable Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.VariableDeclarationImpl#getInitValue <em>Init Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationImpl extends ValueSpecificationImpl implements VariableDeclaration
{
  /**
   * The default value of the '{@link #getVariableDeclaration() <em>Variable Declaration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableDeclaration()
   * @generated
   * @ordered
   */
  protected static final String VARIABLE_DECLARATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVariableDeclaration() <em>Variable Declaration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableDeclaration()
   * @generated
   * @ordered
   */
  protected String variableDeclaration = VARIABLE_DECLARATION_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected DataTypeName type;

  /**
   * The cached value of the '{@link #getInitValue() <em>Init Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitValue()
   * @generated
   * @ordered
   */
  protected Expression initValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableDeclarationImpl()
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
    return VSLPackage.Literals.VARIABLE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVariableDeclaration()
  {
    return variableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableDeclaration(String newVariableDeclaration)
  {
    String oldVariableDeclaration = variableDeclaration;
    variableDeclaration = newVariableDeclaration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.VARIABLE_DECLARATION__VARIABLE_DECLARATION, oldVariableDeclaration, variableDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.VARIABLE_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeName getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(DataTypeName newType, NotificationChain msgs)
  {
    DataTypeName oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.VARIABLE_DECLARATION__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(DataTypeName newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.VARIABLE_DECLARATION__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.VARIABLE_DECLARATION__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.VARIABLE_DECLARATION__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInitValue()
  {
    return initValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitValue(Expression newInitValue, NotificationChain msgs)
  {
    Expression oldInitValue = initValue;
    initValue = newInitValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.VARIABLE_DECLARATION__INIT_VALUE, oldInitValue, newInitValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitValue(Expression newInitValue)
  {
    if (newInitValue != initValue)
    {
      NotificationChain msgs = null;
      if (initValue != null)
        msgs = ((InternalEObject)initValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.VARIABLE_DECLARATION__INIT_VALUE, null, msgs);
      if (newInitValue != null)
        msgs = ((InternalEObject)newInitValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.VARIABLE_DECLARATION__INIT_VALUE, null, msgs);
      msgs = basicSetInitValue(newInitValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.VARIABLE_DECLARATION__INIT_VALUE, newInitValue, newInitValue));
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
      case VSLPackage.VARIABLE_DECLARATION__TYPE:
        return basicSetType(null, msgs);
      case VSLPackage.VARIABLE_DECLARATION__INIT_VALUE:
        return basicSetInitValue(null, msgs);
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
      case VSLPackage.VARIABLE_DECLARATION__VARIABLE_DECLARATION:
        return getVariableDeclaration();
      case VSLPackage.VARIABLE_DECLARATION__NAME:
        return getName();
      case VSLPackage.VARIABLE_DECLARATION__TYPE:
        return getType();
      case VSLPackage.VARIABLE_DECLARATION__INIT_VALUE:
        return getInitValue();
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
      case VSLPackage.VARIABLE_DECLARATION__VARIABLE_DECLARATION:
        setVariableDeclaration((String)newValue);
        return;
      case VSLPackage.VARIABLE_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case VSLPackage.VARIABLE_DECLARATION__TYPE:
        setType((DataTypeName)newValue);
        return;
      case VSLPackage.VARIABLE_DECLARATION__INIT_VALUE:
        setInitValue((Expression)newValue);
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
      case VSLPackage.VARIABLE_DECLARATION__VARIABLE_DECLARATION:
        setVariableDeclaration(VARIABLE_DECLARATION_EDEFAULT);
        return;
      case VSLPackage.VARIABLE_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VSLPackage.VARIABLE_DECLARATION__TYPE:
        setType((DataTypeName)null);
        return;
      case VSLPackage.VARIABLE_DECLARATION__INIT_VALUE:
        setInitValue((Expression)null);
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
      case VSLPackage.VARIABLE_DECLARATION__VARIABLE_DECLARATION:
        return VARIABLE_DECLARATION_EDEFAULT == null ? variableDeclaration != null : !VARIABLE_DECLARATION_EDEFAULT.equals(variableDeclaration);
      case VSLPackage.VARIABLE_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VSLPackage.VARIABLE_DECLARATION__TYPE:
        return type != null;
      case VSLPackage.VARIABLE_DECLARATION__INIT_VALUE:
        return initValue != null;
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
    result.append(" (variableDeclaration: ");
    result.append(variableDeclaration);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //VariableDeclarationImpl
