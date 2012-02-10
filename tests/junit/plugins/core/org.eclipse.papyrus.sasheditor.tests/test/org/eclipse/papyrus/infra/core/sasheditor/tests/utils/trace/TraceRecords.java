/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace;

import java.util.ArrayList;
import java.util.List;


/**
 * A list of trace records.
 * 
 * @author cedric dumoulin
 *
 */
public class TraceRecords implements ITraceRecords {

	public List<TraceRecord>traces = new ArrayList<TraceRecord>();
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String trace) {
		addTrace(null, trace, (Object)null);
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String name, String trace) {
		addTrace(name, trace, (Object)null);
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String name, String trace, Object value) {
		traces.add(new SimpleTraceRecord( name, trace, value));
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String name, String trace, Object ... values) {
		traces.add(new MultiValuesTraceRecord( name, trace, values));
	}
	
	/**
	 * Return the namespace and the trace in one concatenated string ("namespace,trace").
	 * @param i Index of the requested trace
	 * @return
	 */
	public String getFullName(int i) {
		return traces.get(i).getFullName();
	}

	/**
	 * Get the value
	 * @param i
	 * @return
	 */
	public Object getValue(int i) {
		return traces.get(i).getValue();
	}

	/**
	 * Return true if the trace contains the specified events.
	 * @return
	 */
	public boolean contains( String name, String trace) {
		
		return indexOfNamespaceTrace(name, trace) >= 0;
	}
	
    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOf(String name, String trace, Object value) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( record.isEqualsTo(name, trace, value) )
    			return i;
    	}

    	return -1;
      }

    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOfNamespaceTrace(String name, String trace) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( record.isEqualsTo(name, trace) )
    			return i;
    	}

    	return -1;
      }

    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOfTrace(String trace) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( record.isEqualsToTrace(trace) )
    			return i;
    	}

    	return -1;
      }

    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOfNamespace(String namespace) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( record.isEqualsToNameSpace(namespace)  )
    			return i;
    	}

    	return -1;
      }

	/**
	 * Reset the trace.
	 */
	public void reset() {
		for( TraceRecord record : traces) {
			record.clear();
		}
		traces.clear();
	}

	
	/**
	 * @return the traces
	 */
	public List<TraceRecord> getTraces() {
		return traces;
	}
	

}
