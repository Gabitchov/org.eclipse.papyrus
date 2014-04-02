/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste;

import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.StrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategyManager;

/**
 * Singleton instance. This class is used to read and manage the various
 * Drop Strategies
 */
public class PasteStrategyManager extends StrategyManager {

	
	/**
	 * The paste strategy extension point
	 */
	public static final String EXTENSION_ID = Activator.ID + ".pasteStrategy";	
	
	public static final PasteStrategyManager instance = new PasteStrategyManager(EXTENSION_ID);

	private PasteStrategyManager(String todo) {
		super(EXTENSION_ID);
	}

	public static IStrategyManager getInstance() {
		return instance;
	}
	
	


}
