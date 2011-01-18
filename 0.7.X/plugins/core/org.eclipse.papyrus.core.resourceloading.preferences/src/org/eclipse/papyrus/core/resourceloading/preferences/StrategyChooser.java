/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.preferences;

import org.eclipse.papyrus.core.resourceloading.IStrategyChooser;
import org.eclipse.papyrus.preferences.Activator;


/**
 * The Class StrategyChooser.
 */
public class StrategyChooser implements IStrategyChooser {

	/** The current strategy. */
	private static Integer currentStrategy = -1;

	/**
	 * Instantiates a new strategy chooser.
	 */
	public StrategyChooser() {
	}

	/**
	 * @see org.eclipse.papyrus.core.resourceloading.IStrategyChooser#getCurrentStrategy()
	 */
	public int getCurrentStrategy() {
		if(currentStrategy == -1) {
			// set the current strategy at the first time
			currentStrategy = Activator.getDefault().getPreferenceStore().getInt(ICorePreferenceConstants.PREF_CORE_DEFINE_LOADING_STRATEGY);
		}
		return currentStrategy;
	}

	/**
	 * Sets the current strategy.
	 * 
	 * @param strategy
	 *        the new current strategy ID
	 */
	public static void setCurrentStrategy(int strategy) {
		currentStrategy = strategy;
		if(Activator.getDefault().getPreferenceStore().getInt(ICorePreferenceConstants.PREF_CORE_DEFINE_LOADING_STRATEGY) != strategy) {
			Activator.getDefault().getPreferenceStore().setValue(ICorePreferenceConstants.PREF_CORE_DEFINE_LOADING_STRATEGY, String.valueOf(strategy));
		}
	}



}
