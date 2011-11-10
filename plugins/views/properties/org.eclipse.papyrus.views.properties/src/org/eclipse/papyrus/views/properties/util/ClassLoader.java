/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.util;

import org.eclipse.papyrus.views.properties.Activator;

/**
 * A Helper class for Class Loading.
 * 
 * @author Camille Letavernier
 */
//TODO : Rename that class to ClassLoaderHelper (avoir class name conflict with the standard ClassLoader)
//TODO : Change all methods to static methods
//TODO : Move that class to a more generic plug-in
public class ClassLoader {

	/**
	 * Loads the class matching the given className. Exceptions are caught and sent
	 * to the Logger.
	 * 
	 * @param className
	 *        The qualified name of the Class to load.
	 * @return
	 *         The loaded Class, or null if an error occured
	 */
	public Class<?> loadClass(String className) {
		try {
			Class<?> clazz = Activator.getDefault().getBundle().loadClass(className);
			return clazz;
		} catch (ClassNotFoundException ex) {
			Activator.log.error("The class " + className + " doesn't exist", ex); //$NON-NLS-1$
		} catch (NullPointerException ex) {
			Activator.log.error("Cannot load class " + className, ex); //$NON-NLS-1$
		}

		return null;
	}

	/**
	 * Loads and returns the class denoted by the given className.
	 * Checks that the loaded class is a subtype of the given Class.
	 * 
	 * @param className
	 *        The qualified name of the class to be loaded
	 * @param asSubClass
	 *        The interface or class that the loaded class must implement or extend
	 * @return
	 *         The loaded class, or null if the class doesn't exist or is invalid.
	 *         In such a case, the exception is logged.
	 */
	public <T> Class<? extends T> loadClass(String className, Class<T> asSubClass) {
		Class<?> theClass = loadClass(className);
		if(theClass == null) {
			return null;
		}

		try {
			Class<? extends T> typedClass = theClass.asSubclass(asSubClass);
			return typedClass;
		} catch (ClassCastException ex) {
			Activator.log.error(String.format("The class %1$s doesn't extend or implement %2$s", className, asSubClass.getName()), ex); //$NON-NLS-1$
		}

		return null;
	}

	/**
	 * Creates a new instance of class denoted by the given className.
	 * Checks that the instantiated class is a subtype of the given class
	 * 
	 * @param className
	 *        The qualified name of the class to be instantiated
	 * @param asSubclass
	 *        The interface or class that the loaded class must implement or extend
	 * @return
	 *         An instance of the loaded class, or null if a valid instance
	 *         cannot be created. In such a case, the exception is logged.
	 */
	public <T> T newInstance(String className, Class<T> asSubclass) {
		Class<? extends T> typedClass = loadClass(className, asSubclass);
		if(typedClass == null) {
			return null;
		}

		return newInstance(typedClass);
	}

	/**
	 * Returns a new Instance of the given class
	 * 
	 * @param className
	 *        The qualified name of the Class to instantiate
	 * @return
	 *         A new instance of the given class, or null if the class couldn't be
	 *         instantiated
	 */
	public Object newInstance(String className) {
		return newInstance(loadClass(className));
	}

	/**
	 * Returns a new Instance of the given class
	 * 
	 * @param theClass
	 *        The Class to instantiate
	 * @return
	 *         A new instance of the given class, or null if the class couldn't be
	 *         instantiated
	 */
	public <T extends Object> T newInstance(Class<T> theClass) {
		if(theClass == null) {
			return null;
		}

		try {
			return theClass.newInstance();
		} catch (IllegalAccessException ex) {
			Activator.log.error("Cannot find a valid public constructor for the class " + theClass.getName(), ex); //$NON-NLS-1$
		} catch (InstantiationException ex) {
			Activator.log.error(String.format("The class %s cannot be instantiated.", theClass.getName()), ex); //$NON-NLS-1$
		}

		return null;
	}
}
