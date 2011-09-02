package org.eclipse.papyrus.widgets.databinding;

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
	 * @param value
	 *        The IObservable to aggregate to the current IObservable
	 * @return
	 *         The aggregated IObservable, or null if the aggregation is not
	 *         possible
	 */
	public AggregatedObservable aggregate(IObservable observable);

	/**
	 * Tests if the sub-observables have different values
	 */
	public boolean hasDifferentValues();
}
