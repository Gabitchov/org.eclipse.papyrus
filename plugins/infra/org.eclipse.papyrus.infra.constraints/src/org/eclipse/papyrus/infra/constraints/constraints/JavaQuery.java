/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.constraints.constraints;

/**
 * Represents a Java Query
 */
public interface JavaQuery {

	/**
	 * Tests whether the query matches a given object
	 * 
	 * @param selection
	 * @return
	 */
	public boolean match(Object selection);

	/**
	 * A Java query which is always false
	 * 
	 * @author Camille Letavernier
	 * 
	 */
	public class FalseQuery implements JavaQuery {

		public boolean match(Object selection) {
			return false;
		}
	}
}
