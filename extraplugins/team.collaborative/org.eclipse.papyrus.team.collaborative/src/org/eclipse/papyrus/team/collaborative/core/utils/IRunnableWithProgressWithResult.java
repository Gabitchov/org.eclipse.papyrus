/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.utils;

import org.eclipse.jface.operation.IRunnableWithProgress;


/**
 * The Class AbstractRunnableWithProgressWithResult.
 * Runnable used to return a result
 * 
 * @param <T>
 *        the generic type
 */
public interface IRunnableWithProgressWithResult<T> extends IRunnableWithProgress {

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public T getResult();

}
