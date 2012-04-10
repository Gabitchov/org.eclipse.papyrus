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

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public interface IDataBinding extends IDataBindingInfo {

	/**
	 * The argument is used to determine the filtering. If type is null, no filtering
	 * 
	 * @return
	 */
	public Object getValue(Class<?> targetType);

	public Object getControl();
}
