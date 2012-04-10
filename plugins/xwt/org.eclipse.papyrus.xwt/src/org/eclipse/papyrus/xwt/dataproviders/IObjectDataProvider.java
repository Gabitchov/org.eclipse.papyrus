/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.dataproviders;

import java.util.List;

import org.eclipse.papyrus.xwt.IDataProvider;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public interface IObjectDataProvider extends IDataProvider {

	void setObjectType(Class<?> objectType);

	Class<?> getObjectType();

	void setObjectInstance(Object objectInstance);

	Object getObjectInstance();

	void setMethodName(String methodName);

	String getMethodName();

	List<Object> getMethodParameters();

	void setMethodParameters(List<Object> parameters);
}
