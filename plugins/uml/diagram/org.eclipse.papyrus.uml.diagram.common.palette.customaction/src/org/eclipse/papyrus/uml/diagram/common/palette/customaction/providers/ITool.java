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
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.providers;

import org.eclipse.gef.EditPart;

/**
 * An ITool must run a code from a given edit part
 * @author tfaure
 *
 */
public interface ITool {

	/**
	 * Code the tool has to perform when the user has created the desired element
	 * @param editPart
	 */
	void run(EditPart editPart);

}
