/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.databinding;

import org.eclipse.core.databinding.observable.IObservable;

/**
 * An interface to aggregate many IObservables in a single one.
 * A modification on the aggregated observable should be dispatched to all
 * the encapsulated observables.
 * 
 * @author Camille Letavernier
 */
public interface AggregatedObservable extends IObservable {

	/**
	 * Aggregates the current Observable with the given observable.
	 * Returns the aggregated Observable, or null if the aggregation is not
	 * possible
	 * 
	 * Typically, only IObservable with similar ValueTypes can be
	 * aggregated.
	 * 
	 * @param observable
	 *        The IObservable to aggregate to the current IObservable
	 * @return
	 *         The aggregated IObservable, or null if the aggregation is not
	 *         possible
	 */
	public AggregatedObservable aggregate(IObservable observable);

	/**
	 * Tests if the sub-observables have different values
	 * 
	 * @return true if the sub-observables have different values
	 */
	public boolean hasDifferentValues();
}
