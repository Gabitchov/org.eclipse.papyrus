/**
 */
package org.eclipse.papyrus.uml.alf.alf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AssignmentCompletion;
import org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.VariableDeclarationCompletionImpl#isMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.VariableDeclarationCompletionImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.impl.VariableDeclarationCompletionImpl#getInitValue <em>Init Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationCompletionImpl extends MinimalEObjectImpl.Container implements VariableDeclarationCompletion
{
  /**
   * The default value of the '{@link #isMultiplicityIndicator() <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMultiplicityIndicator()
   * @generated
   * @ordered
   */
  protected static final boolean MULTIPLICITY_INDICATOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMultiplicityIndicator() <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMultiplicityIndicator()
   * @generated
   * @ordered
   */
  protected boolean multiplicityIndicator = MULTIPLICITY_INDICATOR_EDEFAULT;

  /**
   * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected static final String VARIABLE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableName()
   * @generated
   * @ordered
   */
  protected String variableName = VARIABLE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInitValue() <em>Init Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitValue()
   * @generated
   * @ordered
   */
  protected AssignmentCompletion initValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableDeclarationCompletionImpl()
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
    return AlfPackage.Literals.VARIABLE_DECLARATION_COMPLETION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMultiplicityIndicator()
  {
    return multiplicityIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicityIndicator(boolean newMultiplicityIndicator)
  {
    boolean oldMultiplicityIndicator = multiplicityIndicator;
    multiplicityIndicator = newMultiplicityIndicator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.VARIABLE_DECLARATION_COMPLETION__MULTIPLICITY_INDICATOR, oldMultiplicityIndicator, multiplicityIndicator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVariableName()
  {
    return variableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableName(String newVariableName)
  {
    String oldVariableName = variableName;
    variableName = newVariableName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.VARIABLE_DECLARATION_COMPLETION__VARIABLE_NAME, oldVariableName, variableName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentCompletion getInitValue()
  {
    return initValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitValue(AssignmentCompletion newInitValue, NotificationChain msgs)
  {
    AssignmentCompletion oldInitValue = initValue;
    initValue = newInitValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE, oldInitValue, newInitValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitValue(AssignmentCompletion newInitValue)
  {
    if (newInitValue != initValue)
    {
      NotificationChain msgs = null;
      if (initValue != null)
        msgs = ((InternalEObject)initValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE, null, msgs);
      if (newInitValue != null)
        msgs = ((InternalEObject)newInitValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE, null, msgs);
      msgs = basicSetInitValue(newInitValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE, newInitValue, newInitValue));
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
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE:
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
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__MULTIPLICITY_INDICATOR:
        return isMultiplicityIndicator();
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__VARIABLE_NAME:
        return getVariableName();
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE:
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
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator((Boolean)newValue);
        return;
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__VARIABLE_NAME:
        setVariableName((String)newValue);
        return;
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE:
        setInitValue((AssignmentCompletion)newValue);
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
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__MULTIPLICITY_INDICATOR:
        setMultiplicityIndicator(MULTIPLICITY_INDICATOR_EDEFAULT);
        return;
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__VARIABLE_NAME:
        setVariableName(VARIABLE_NAME_EDEFAULT);
        return;
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE:
        setInitValue((AssignmentCompletion)null);
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
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__MULTIPLICITY_INDICATOR:
        return multiplicityIndicator != MULTIPLICITY_INDICATOR_EDEFAULT;
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__VARIABLE_NAME:
        return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
      case AlfPackage.VARIABLE_DECLARATION_COMPLETION__INIT_VALUE:
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
    result.append(" (multiplicityIndicator: ");
    result.append(multiplicityIndicator);
    result.append(", variableName: ");
    result.append(variableName);
    result.append(')');
    return result.toString();
  }

} //VariableDeclarationCompletionImpl
