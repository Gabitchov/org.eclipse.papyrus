/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt;

import java.net.URL;

public class DefaultLoadingContext implements ILoadingContext {

	public static final DefaultLoadingContext defaultLoadingContext = new DefaultLoadingContext();

	protected ClassLoader classLoader;

	public DefaultLoadingContext() {
	}

	public DefaultLoadingContext(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public ClassLoader getClassLoader() {
		if(classLoader == null) {
			return Thread.currentThread().getContextClassLoader();
		}
		return classLoader;
	}

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public String getNamespace() {
		return IConstants.XWT_NAMESPACE;
	}

	public Class<?> loadClass(String name) {
		Class<?> type = doLoadClass(name);
		if(type != null) {
			return type;
		}
		int index = name.lastIndexOf('.');
		while(index != -1) {
			name = name.substring(0, index) + "$" + name.substring(index + 1);
			type = doLoadClass(name);
			if(type != null) {
				return type;
			}
			index = name.lastIndexOf('.');
		}
		return null;
	}

	protected Class<?> doLoadClass(String name) {
		try {
			return getClassLoader().loadClass(name);
		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	public URL getResource(String name) {
		return getClassLoader().getResource(name);
	}
}
