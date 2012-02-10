package org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace;

import java.util.List;



public interface ITraceRecords {

	/**
	 * Record a new trace.
	 * @param trace
	 */
	public abstract void addTrace(String trace);

	/**
	 * Record a new trace.
	 * @param trace
	 */
	public abstract void addTrace(String name, String trace);

	/**
	 * Record a new trace.
	 * @param trace
	 */
	public abstract void addTrace(String name, String trace, Object value);

	/**
	 * Record a new trace.
	 * @param trace
	 */
	public abstract void addTrace(String name, String trace, Object... values);

	/**
	 * Return the namespace and the trace in one concatenated string ("namespace,trace").
	 * @param i Index of the requested trace
	 * @return
	 */
	public abstract String getFullName(int i);

	/**
	 * Get the value
	 * @param i
	 * @return
	 */
	public abstract Object getValue(int i);

	/**
	 * Return true if the trace contains the specified events.
	 * @return
	 */
	public abstract boolean contains(String name, String trace);

	/**
	 * Returns the index of the first occurrence of the specified elements
	 * in these lists, or -1 if this list does not contain the element.
	 */
	public abstract int indexOf(String name, String trace, Object value);

	/**
	 * Returns the index of the first occurrence of the specified elements
	 * in these lists, or -1 if this list does not contain the element.
	 */
	public abstract int indexOfNamespaceTrace(String name, String trace);

	/**
	 * Returns the index of the first occurrence of the specified elements
	 * in these lists, or -1 if this list does not contain the element.
	 */
	public abstract int indexOfTrace(String trace);

	/**
	 * Returns the index of the first occurrence of the specified elements
	 * in these lists, or -1 if this list does not contain the element.
	 */
	public abstract int indexOfNamespace(String namespace);

	/**
	 * Reset the trace.
	 */
	public abstract void reset();

	/**
	 * @return the traces
	 */
	public abstract List<TraceRecord> getTraces();

}
