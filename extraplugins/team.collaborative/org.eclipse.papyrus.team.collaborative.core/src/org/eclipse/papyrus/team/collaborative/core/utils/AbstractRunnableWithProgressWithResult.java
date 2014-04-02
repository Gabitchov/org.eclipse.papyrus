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
package org.eclipse.papyrus.team.collaborative.core.utils;



/**
 * Default implementation for {@link IRunnableWithProgressWithResult}
 */
public abstract class AbstractRunnableWithProgressWithResult<T> implements IRunnableWithProgressWithResult<T> {

	/** The result. */
	protected T result;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.utils.IRunnableWithProgressWithResult#getResult()
	 */
	@Override
	public T getResult() {
		return result;
	}

}
