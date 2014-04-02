/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceException;
import static org.eclipse.papyrus.layers.stackmodel.Activator.log;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Property Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#getOperatorInstance <em>Operator Instance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.CustomPropertyOperatorImpl#getClassBundleID <em>Class Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomPropertyOperatorImpl extends PropertyOperatorImpl implements CustomPropertyOperator {
	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatorInstance() <em>Operator Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorInstance()
	 * @generated
	 * @ordered
	 */
	protected static final CustomPropertyOperatorsInstance OPERATOR_INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperatorInstance() <em>Operator Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorInstance()
	 * @generated
	 * @ordered
	 */
	protected CustomPropertyOperatorsInstance operatorInstance = OPERATOR_INSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassBundleID() <em>Class Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassBundleID()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_BUNDLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassBundleID() <em>Class Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassBundleID()
	 * @generated
	 * @ordered
	 */
	protected String classBundleID = CLASS_BUNDLE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomPropertyOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.CUSTOM_PROPERTY_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASSNAME, oldClassname, classname));
		// Reset the actual instance
		setOperatorInstance(null);
			
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CustomPropertyOperatorsInstance getOperatorInstance() {
		if(operatorInstance == null) {
			try {
				resetOperatorInstance();
			} catch (LayersException e) {
				// TODO log the error
				log.error("LOG-" + this.getClass().getName() 
						+ "- Can't set custom operator instance '" + e.getMessage() + "'.", e);
				
			}
		}
		
		return operatorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorInstance(CustomPropertyOperatorsInstance newOperatorInstance) {
		CustomPropertyOperatorsInstance oldOperatorInstance = operatorInstance;
		operatorInstance = newOperatorInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE, oldOperatorInstance, operatorInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassBundleID() {
		return classBundleID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassBundleID(String newClassBundleID) {
		String oldClassBundleID = classBundleID;
		classBundleID = newClassBundleID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID, oldClassBundleID, classBundleID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws LayersException 
	 * @generated NOT
	 */
	public void resetOperatorInstance() throws LayersException {
		if( getClassname() == null ) {
			return;
		}
		
			Class<?> opClass = loadClass();
			try {
				setOperatorInstance((CustomPropertyOperatorsInstance)opClass.newInstance() );
			} catch (Exception e) {
				throw new LayersException("Can't create instance for CustomOperator " + getName(), e) ;
			}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyOperatorImpl#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)
	 *
	 * @param property
	 * @return
	 * @throws LayersException
	 * @generated NOT
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(EList<ComputePropertyValueCommand> property) throws LayersException {
		return getOperatorInstance().getComputePropertyValueCommand(property);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASSNAME:
				return getClassname();
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				return getOperatorInstance();
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				return getClassBundleID();
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
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASSNAME:
				setClassname((String)newValue);
				return;
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				setOperatorInstance((CustomPropertyOperatorsInstance)newValue);
				return;
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				setClassBundleID((String)newValue);
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
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				setOperatorInstance(OPERATOR_INSTANCE_EDEFAULT);
				return;
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				setClassBundleID(CLASS_BUNDLE_ID_EDEFAULT);
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
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE:
				return OPERATOR_INSTANCE_EDEFAULT == null ? operatorInstance != null : !OPERATOR_INSTANCE_EDEFAULT.equals(operatorInstance);
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID:
				return CLASS_BUNDLE_ID_EDEFAULT == null ? classBundleID != null : !CLASS_BUNDLE_ID_EDEFAULT.equals(classBundleID);
		}
		return super.eIsSet(featureID);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR___RESET_OPERATOR_INSTANCE:
				try {
					resetOperatorInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Load the Class object. Try from current ClassLoader, then try using the
	 * plugin referenced in the serviceDescriptor.PluginId
	 * 
	 * @return
	 * @throws ServiceException
	 */
	private Class<?> loadClass() throws LayersException {
		String classname = getClassname();
		Class<?> classDesc;
		try {
			classDesc = Class.forName(classname);
		} catch (ClassNotFoundException e1) {
			// Try using bundle
			try {
				String bundleID = getClassBundleID();
				Bundle bundle = Platform.getBundle(bundleID);
				classDesc = bundle.loadClass(classname);
			} catch (ClassNotFoundException e2) {
				throw new LayersException("Can't find class for the name '" + classname + "'.", e2);
			} catch (NullPointerException e) {
				throw new LayersException("Can't find bundle '"+ getClassBundleID() 
						+ "' for class for the name '" + classname + "'.", e);
			}
		}

		return classDesc;
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
		result.append(" (classname: ");
		result.append(classname);
		result.append(", operatorInstance: ");
		result.append(operatorInstance);
		result.append(", classBundleID: ");
		result.append(classBundleID);
		result.append(')');
		return result.toString();
	}

} //CustomPropertyOperatorImpl
