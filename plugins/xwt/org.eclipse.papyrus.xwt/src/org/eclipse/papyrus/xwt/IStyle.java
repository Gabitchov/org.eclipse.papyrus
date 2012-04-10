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
public interface IStyle {

	/**
	 * The element to apply the style. The argument is an instance created through XML. It can be a Widget, or others such as TableViewer.
	 * 
	 * @param target
	 */
	void applyStyle(Object target);
}
