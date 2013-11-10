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
package org.eclipse.papyrus.layers.stackmodel;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;


/**
 * @author cedric dumoulin
 *
 */
public class PropertyValueFactory {

	/**
	 * Constructor.
	 *
	 */
	public PropertyValueFactory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create an instance of the specified class, located in the specified plugin.
	 * 
	 * @param pluginId
	 * @param classname
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Object newInstance(String pluginId, String classname) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		
		Class<?> classType = loadClass(pluginId, classname);
		
		return classType.newInstance();
	}
	
	/**
	 * Load requested class from the current classloader. If not found, try to get it from the
	 * specified plugin.
	 * @param declaringID
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> loadClass(String declaringID, String className) throws ClassNotFoundException {
		Class<?> factoryClass;
		try {
			factoryClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// try another way
			try {
				Bundle bundle = Platform.getBundle(declaringID);
				factoryClass = bundle.loadClass(className);
			} catch (ClassNotFoundException e1) {
				throw new ClassNotFoundException("Can't find class " + className 
						             + "in plugin " + declaringID
						             , e1);
			} catch (NullPointerException e1) {
				throw new ClassNotFoundException("Can't find plugin " + declaringID, e1);
}
		}
		return factoryClass;

	}
	
	/**
	 * Create an instance of the specified model concept.
	 * @param nsURI
	 * @param propertyName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public EObject newEClassInstance(String nsURI, String propertyName) throws ClassNotFoundException {
		
		
		
		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		if( modelPackage == null) {
			throw new ClassNotFoundException("Can't get EPAckage for model '" + nsURI + "'");
		}
	
		EClass classifier = (EClass)modelPackage.getEClassifier(propertyName);
		if( classifier == null) {
			throw new ClassNotFoundException("Can't get classifier '" + propertyName + "' in model '" + nsURI + "'");
		}
		
		return modelPackage.getEFactoryInstance().create(classifier);
	}
	
	public Object getEObjectPropertyValue(EObject eObject, String propertyName) {
		return eObject.eGet(eObject.eClass().getEStructuralFeature(propertyName));
	}

	public void setEObjectPropertyValue(EObject eObject, String propertyName, Object value) {
		eObject.eSet(eObject.eClass().getEStructuralFeature(propertyName), value);
	}

}
