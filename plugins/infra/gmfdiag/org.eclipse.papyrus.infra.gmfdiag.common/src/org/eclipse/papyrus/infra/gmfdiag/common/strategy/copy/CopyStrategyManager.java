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
package org.eclipse.papyrus.infra.gmfdiag.common.strategy.copy;

import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.StrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategyManager;

/**
 * Singleton instance. This class is used to read and manage the various Copy Strategies
 */
public class CopyStrategyManager extends StrategyManager {

	/**
	 * The copy strategy extension point
	 */
	public static final String EXTENSION_ID = Activator.ID + ".copyStrategy";	
	
	public static final CopyStrategyManager instance = new CopyStrategyManager(EXTENSION_ID);

	private CopyStrategyManager(String todo) {
		super(EXTENSION_ID);
	}

	public static IStrategyManager getInstance() {
		return instance;
	}
	
	


}
