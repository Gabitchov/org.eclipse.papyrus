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
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OperatorConfigImpl extends InstanciableElementImpl implements OperatorConfig {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersconfigPackage.Literals.OPERATOR_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyOperator createOperatorDescriptor() throws InstanciationException {

		switch(getClassnameKind()) {
		case UNDEFINED:
			// Try to find the exact type of classname
			PropertyOperator res;
			
			// Try as EMF instance
			try {
				res = createEmfInstance();
				setClassnameKind(ClassnameKind.EMF_CLASSNAME);
				return res;
			} catch (InstanciationException e) {
				// Not an EMF name. Try other solutions.
			} catch (ClassCastException e) {
				// specified class name is of wrong type
				setClassnameKind(ClassnameKind.NOT_FOUND);
				throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. Bad EMF type.");
			}
			
			// Try as java pojo
			try {
				res = createPojoInstance();
				setClassnameKind(ClassnameKind.POJO_CLASSNAME);
				return res;
			} catch (InstanciationException e) {
				setClassnameKind(ClassnameKind.NOT_FOUND);
				throw e;
			}
			

		case EMF_CLASSNAME:
			return createEmfInstance();
			
		case POJO_CLASSNAME:
			// Try to load a java class
			return createPojoInstance();
			
			
		case NOT_FOUND:
			// We already are in error. Do nothing
			
			break;

		default:
			break;
		}

		throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'.");

	}

	/**
	 * @return
	 * @throws InstanciationException
	 */
	protected PropertyOperator createPojoInstance() throws InstanciationException {
		try {
			Class<?> opClass = loadClass();
			CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();
			operator.setOperatorInstance((CustomPropertyOperatorsInstance)opClass.newInstance() );
			operator.setName(getName());
			
			return operator;
		} catch (Exception e) {
			setClassnameKind(ClassnameKind.NOT_FOUND);
			throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. " + e.getMessage());
		}
	}

	/**
	 * Create an EMF instance from the classname.
	 * @return
	 * @throws InstanciationException
	 */
	protected PropertyOperator createEmfInstance() throws InstanciationException {
		// Try to load an EMF type
		EClassifier classifier = LayersPackage.eINSTANCE.getEClassifier(getClassname());
		if(classifier == null) {
			throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. Bad classname.");
		}
		PropertyOperator res;
		try {
			res = (PropertyOperator)LayersFactory.eINSTANCE.create((EClass)classifier);
		} catch (ClassCastException e) {
			// specified class name is of
			throw new InstanciationException("Can't create PropertyOperator for name '" + getClassname() + "'. Bad type.");
		}
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersconfigPackage.OPERATOR_CONFIG___CREATE_OPERATOR_DESCRIPTOR:
				try {
					return createOperatorDescriptor();
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
				String bundleID = getBundleID();
				Bundle bundle = Platform.getBundle(bundleID);
				classDesc = bundle.loadClass(classname);
			} catch (ClassNotFoundException e2) {
				throw new LayersException("Can't find class for the name '" + classname + "'.", e2);
			} catch (NullPointerException e) {
				throw new LayersException("Can't find bundle '"+ getBundleID() 
						+ "' for class for the name '" + classname + "'.", e);
			}
		}
	
		return classDesc;
	}

	
	
} //OperatorConfigImpl
