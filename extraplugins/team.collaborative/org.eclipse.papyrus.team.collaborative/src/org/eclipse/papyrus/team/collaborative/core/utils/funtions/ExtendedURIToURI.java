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

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.team.collaborative.core.ExtendedURI;

import com.google.common.base.Function;


/**
 * The Class ExtendedURIToURI.
 * Function used to convert {@link ExtendedURI} to {@link URI}
 */
public class ExtendedURIToURI implements Function<ExtendedURI, URI> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	public URI apply(ExtendedURI from) {
		return from.getUri();
	}

}
