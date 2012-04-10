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
package org.eclipse.papyrus.xwt.javabean.metadata;

import org.eclipse.papyrus.xwt.IXWTLoader;
import org.eclipse.papyrus.xwt.XWTLoaderManager;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class Metaclass extends AbstractMetaclass {

	/**
	 * 
	 * @param type
	 * @param superClass
	 * @param initialize
	 */
	public Metaclass(Class<?> type, IMetaclass superClass, boolean initialize) {
		this(type, superClass, XWTLoaderManager.getDefault());
	}

	/**
	 * 
	 * @param type
	 * @param superClass
	 * @param initialize
	 * @param xwtLoader
	 */
	public Metaclass(Class<?> type, IMetaclass superClass, boolean initialize, IXWTLoader xwtLoader) {
		this.type = type;
		this.name = type.getSimpleName();
		this.superClass = superClass;
		this.xwtLoader = xwtLoader;
		if(initialize) {
			initialize(type, superClass);
		}
	}

	/**
	 * Default initialize it
	 * 
	 * @param type
	 * @param superClass
	 */
	public Metaclass(Class<?> type, IMetaclass superClass) {
		this(type, superClass, false, XWTLoaderManager.getDefault());
	}

	/**
	 * Default initialize it
	 * 
	 * @param type
	 * @param superClass
	 */
	public Metaclass(Class<?> type, IMetaclass superClass, IXWTLoader xwtLoader) {
		this(type, superClass, false, xwtLoader);
	}
}
