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
package org.eclipse.papyrus.team.collaborative.core.utils.funtions;

import java.io.File;

import org.eclipse.core.resources.IResource;

import com.google.common.base.Function;


/**
 * The Class IFileToFile.
 * Function used to convert {@link IResource} to {@link File}
 * 
 * @param <T>
 *        the generic type
 */
public class IFileToFile<T extends IResource> implements Function<T, File> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public File apply(T from) {
		return from.getFullPath().toFile();
	}



}
