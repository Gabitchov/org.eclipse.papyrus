/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Factory Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.ModelElementFactoryDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.impl.ModelElementFactoryDescriptorImpl#getFactoryClass <em>Factory Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementFactoryDescriptorImpl extends EObjectImpl implements ModelElementFactoryDescriptor {
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
	 * The default value of the '{@link #getFactoryClass() <em>Factory Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryClass()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactoryClass() <em>Factory Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryClass()
	 * @generated
	 * @ordered
	 */
	protected String factoryClass = FACTORY_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementFactoryDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnvironmentPackage.Literals.MODEL_ELEMENT_FACTORY_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactoryClass() {
		return factoryClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactoryClass(String newFactoryClass) {
		String oldFactoryClass = factoryClass;
		factoryClass = newFactoryClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS, oldFactoryClass, factoryClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME:
				return getName();
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS:
				return getFactoryClass();
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
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS:
				setFactoryClass((String)newValue);
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
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS:
				setFactoryClass(FACTORY_CLASS_EDEFAULT);
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
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EnvironmentPackage.MODEL_ELEMENT_FACTORY_DESCRIPTOR__FACTORY_CLASS:
				return FACTORY_CLASS_EDEFAULT == null ? factoryClass != null : !FACTORY_CLASS_EDEFAULT.equals(factoryClass);
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
		result.append(", factoryClass: ");
		result.append(factoryClass);
		result.append(')');
		return result.toString();
	}

} //ModelElementFactoryDescriptorImpl
