/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;



public class Constants {

	private Constants() {
		//to prevent instanciation
	}

	public static final String BEGIN_OF_COLLECTION = "["; //$NON-NLS-1$

	public static final String END_OF_COLLECTION = "]"; //$NON-NLS-1$

	public static final String SEPARATOR = ", "; //$NON-NLS-1$

	public static final String NOT_AVALAIBLE = "N/A";//$NON-NLS-1$

	public static final String INFINITY_STAR = "*";

	public static final String INFINITE_MINUS_ONE = "-1";

	/**
	 * the context to use to find the label provider used to display values in cells and headers
	 */
	public static final String TABLE_LABEL_PROVIDER_CONTEXT = "org.eclipse.papyrus.infra.nattable.full.labelprovider";

	/**
	 * the context to use to find the label provider used to display values in the headers
	 */
	public static final String HEADER_LABEL_PROVIDER_CONTEXT = "org.eclipse.papyrus.infra.nattable.header.labelprovider";

	/**
	 * the context to use to find the label provider used to display values in the body of the table
	 */

	public static final String BODY_LABEL_PROVIDER_CONTEXT = "org.eclipse.papyrus.infra.nattable.body.labelprovider";

}
