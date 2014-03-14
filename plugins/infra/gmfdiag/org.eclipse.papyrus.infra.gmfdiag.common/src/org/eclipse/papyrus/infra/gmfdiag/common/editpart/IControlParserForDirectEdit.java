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
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;


/**
 * Direct editors install their own parser. The objective of this interface is
 * to reset a parser within an edit part, once a direct editor is stopped.
 * This will restore the original parser
 */
public interface IControlParserForDirectEdit {
	/**
	 * install a new parser
	 * @param parser
	 */
	public void setParser(IParser parser);
}

