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
package org.eclipse.papyrus.properties.util;

import org.eclipse.papyrus.properties.Activator;

public class ClassLoader {

	public Class<?> loadClass(String className) {
		try {
			Class<?> clazz = Class.forName(className);
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

	public Object newInstance(String className) {
		return newInstance(loadClass(className));
	}

	public <T extends Object> T newInstance(Class<T> theClass) {
		if(theClass == null)
			return null;

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
