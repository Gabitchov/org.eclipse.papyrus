/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

/**
 * Interface that defines constants for direct edition in Papyrus.
 */
public interface IDirectEdition {

	/**
	 * constant for undefined role. no editors have been checked for this
	 * element
	 */
	final int UNDEFINED_DIRECT_EDITOR = 0;

	/** default direct editor (in diagram edition) */
	final int DEFAULT_DIRECT_EDITOR = 1 << 1;

	/** extended editor, i.e opens a new dialog window */
	final int EXTENDED_DIRECT_EDITOR = 1 << 2;

	/**
	 * no editor for this element. this element does not respond to a direct
	 * edit request
	 */
	final int NO_DIRECT_EDITION = 1 << 3;
}
