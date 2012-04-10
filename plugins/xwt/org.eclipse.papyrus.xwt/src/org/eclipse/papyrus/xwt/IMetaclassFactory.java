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

import org.eclipse.papyrus.xwt.metadata.IMetaclass;

/**
 * Metaclass factory provides a customizable Metaclass creation mechanism.
 * 
 * @author yyang
 * 
 */
public interface IMetaclassFactory {

	boolean isFactoryOf(Class<?> type);

	IMetaclass create(Class<?> type, IMetaclass superMetaclass, IXWTLoader xwtLoader);
}
