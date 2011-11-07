/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.utils;

/**
 * A convenient interface for providing call back operations
 * @author tfaure
 *
 * @param <T>
 */
public interface ICallback<T> {
	void callBack (T object) ;
}
