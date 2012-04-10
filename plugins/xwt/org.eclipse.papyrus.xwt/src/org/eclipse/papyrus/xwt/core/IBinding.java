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
package org.eclipse.papyrus.xwt.core;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public interface IBinding {

	/**
	 * The argument is used to determine the filtering. If type is null, no filtering
	 * 
	 * @return
	 */
	Object getValue(Class<?> type);

	void reset();
}
