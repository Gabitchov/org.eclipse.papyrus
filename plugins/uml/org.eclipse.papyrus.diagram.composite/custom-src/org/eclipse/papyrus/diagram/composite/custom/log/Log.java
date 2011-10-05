/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.log;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.log.LogHelper;

/** Log singleton class for CSD */
public class Log extends LogHelper {

	/** Singleton instance */
	private static Log instance;

	/** Access restriction on constructors */
	private Log(Plugin activator) {
		super(activator);
	}

	/** Access restriction on constructors */
	private Log() {
		super(UMLDiagramEditorPlugin.getInstance());
	}

	/** Singleton access */
	public static synchronized Log getInstance() {

		if(instance == null) {
			instance = new Log();
		}
		return instance;
	}
}
