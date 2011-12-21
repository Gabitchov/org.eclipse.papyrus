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
package org.eclipse.papyrus.infra.constraints.util;

import org.eclipse.papyrus.infra.constraints.Activator;

/**
 * A Helper class for Class Loading.
 * 
 * @author Camille Letavernier
 */
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
			Activator.log.error("Cannot load class " + className, ex); //$NON-NLS-1$
		} catch (ClassCastException ex) {
			Activator.log.error("Cannot load class " + className, ex); //$NON-NLS-1$
		} catch (NullPointerException ex) {
			Activator.log.error("Cannot load class " + className, ex); //$NON-NLS-1$
		}

		return null;
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
			Activator.log.error(ex);
		} catch (InstantiationException ex) {
			Activator.log.error(ex);
		}

		return null;
	}
}
