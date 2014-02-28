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
package org.eclipse.papyrus.infra.gmfdiag.common.strategy;

import java.util.List;


/**
 * The Interface IStrategyManager.
 */
public interface IStrategyManager {


	/**
	 * Checks if the strategy is active.
	 *
	 * @param strategy
	 *        the strategy
	 * @return true, if is active
	 */
	boolean isActive(IStrategy strategy);

	/**
	 * Sets the strategy to isActive.
	 *
	 * @param strategy
	 *        the strategy
	 * @param isActive
	 *        the is active
	 */
	void setActive(IStrategy strategy, boolean isActive);

	/**
	 * Find priority of a strategy
	 *
	 * @param otherStrategy
	 *        the other strategy
	 * @return the int
	 */
	int findPriority(IStrategy otherStrategy);

	/**
	 * Sets the priority for a strategy.
	 *
	 * @param strategyToMove
	 *        the strategy to move
	 * @param newPriority
	 *        the new priority
	 */
	void setPriority(IStrategy strategyToMove, int newPriority);

	/**
	 * Gets the all strategies.
	 *
	 * @return the all strategies
	 */
	List<IStrategy> getAllStrategies();

	/**
	 * Restore defaults.
	 */
	void restoreDefaults();

	/**
	 * Gets all the active strategies.
	 *
	 * @return the active strategies
	 */
	List<IStrategy> getAllActiveStrategies();

}
