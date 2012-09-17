/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.properties.generation.fieldselection.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionFactory;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.TernaryButton.State;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.impl.PropertyDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.impl.PropertyDefinitionImpl#getValueSingle <em>Value Single</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.generation.fieldselection.impl.PropertyDefinitionImpl#getValueMultiple <em>Value Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyDefinitionImpl extends EObjectImpl implements PropertyDefinition {

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
	 * The default value of the '{@link #getValueSingle() <em>Value Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueSingle()
	 * @generated
	 * @ordered
	 */
	protected static final State VALUE_SINGLE_EDEFAULT = (State)FieldSelectionFactory.eINSTANCE.createFromString(FieldSelectionPackage.eINSTANCE.getValue(), "DEFAULT");

	/**
	 * The cached value of the '{@link #getValueSingle() <em>Value Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueSingle()
	 * @generated
	 * @ordered
	 */
	protected State valueSingle = VALUE_SINGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueMultiple() <em>Value Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueMultiple()
	 * @generated
	 * @ordered
	 */
	protected static final State VALUE_MULTIPLE_EDEFAULT = (State)FieldSelectionFactory.eINSTANCE.createFromString(FieldSelectionPackage.eINSTANCE.getValue(), "DEFAULT");

	/**
	 * The cached value of the '{@link #getValueMultiple() <em>Value Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueMultiple()
	 * @generated
	 * @ordered
	 */
	protected State valueMultiple = VALUE_MULTIPLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FieldSelectionPackage.Literals.PROPERTY_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FieldSelectionPackage.PROPERTY_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getValueSingle() {
		return valueSingle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueSingle(State newValueSingle) {
		State oldValueSingle = valueSingle;
		valueSingle = newValueSingle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_SINGLE, oldValueSingle, valueSingle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getValueMultiple() {
		return valueMultiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueMultiple(State newValueMultiple) {
		State oldValueMultiple = valueMultiple;
		valueMultiple = newValueMultiple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_MULTIPLE, oldValueMultiple, valueMultiple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FieldSelectionPackage.PROPERTY_DEFINITION__NAME:
				return getName();
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_SINGLE:
				return getValueSingle();
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_MULTIPLE:
				return getValueMultiple();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FieldSelectionPackage.PROPERTY_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_SINGLE:
				setValueSingle((State)newValue);
				return;
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_MULTIPLE:
				setValueMultiple((State)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case FieldSelectionPackage.PROPERTY_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_SINGLE:
				setValueSingle(VALUE_SINGLE_EDEFAULT);
				return;
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_MULTIPLE:
				setValueMultiple(VALUE_MULTIPLE_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FieldSelectionPackage.PROPERTY_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_SINGLE:
				return VALUE_SINGLE_EDEFAULT == null ? valueSingle != null : !VALUE_SINGLE_EDEFAULT.equals(valueSingle);
			case FieldSelectionPackage.PROPERTY_DEFINITION__VALUE_MULTIPLE:
				return VALUE_MULTIPLE_EDEFAULT == null ? valueMultiple != null : !VALUE_MULTIPLE_EDEFAULT.equals(valueMultiple);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", valueSingle: ");
		result.append(valueSingle);
		result.append(", valueMultiple: ");
		result.append(valueMultiple);
		result.append(')');
		return result.toString();
	}

} //PropertyDefinitionImpl
