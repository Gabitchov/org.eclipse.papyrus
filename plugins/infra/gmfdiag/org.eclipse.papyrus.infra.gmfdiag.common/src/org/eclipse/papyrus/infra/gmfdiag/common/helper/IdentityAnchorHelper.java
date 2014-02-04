/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import org.eclipse.gmf.runtime.notation.IdentityAnchor;

/**
 * 
 * Helper used for identity anchor
 * 
 */
public class IdentityAnchorHelper {

	/**
	 * the char starting an id of {@link IdentityAnchor}
	 */
	public static final char START_ID = '(';

	/**
	 * the char ending an id of {@link IdentityAnchor}
	 */

	public static final char END_ID = ')';

	/**
	 * the char separating percentage in ids of {@link IdentityAnchor}
	 */
	public static final char X_Y_SEPARATOR = ',';

	/**
	 * the char separating percentage as string in ids of {@link IdentityAnchor}
	 */
	public static final String X_Y_SEPARATOR_AS_STRING = new String(new char[]{ X_Y_SEPARATOR });

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private IdentityAnchorHelper() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param anchor
	 *        an anchor
	 * @return
	 *         the value of x percentage
	 */
	public static final double getXPercentage(final IdentityAnchor anchor) {
		String id = anchor.getId();
		id = id.substring(1, id.indexOf(X_Y_SEPARATOR_AS_STRING));
		return Double.parseDouble(id);
	}

	/**
	 * 
	 * @param anchor
	 *        an anchor
	 * @return
	 *         the value of y percentage
	 */
	public static final double getYPercentage(final IdentityAnchor anchor) {
		String id = anchor.getId();
		id = id.substring(id.indexOf(X_Y_SEPARATOR_AS_STRING) + 1, id.length() - 1);
		return Double.parseDouble(id);
	}


	/**
	 * 
	 * @param percentageOnX
	 *        the percentage on x
	 * @param percentageOnY
	 *        the percentage on y
	 * @return
	 *         the string representing the new id for an anchor
	 */
	public static final String createNewAnchorIdValue(final double percentageOnX, final double percentageOnY) {
		final StringBuffer buffer = new StringBuffer();
		buffer.append(START_ID);
		buffer.append(Double.toString(percentageOnX));
		buffer.append(X_Y_SEPARATOR_AS_STRING);
		buffer.append(Double.toString(percentageOnY));
		buffer.append(END_ID);
		return buffer.toString();
	}
}
