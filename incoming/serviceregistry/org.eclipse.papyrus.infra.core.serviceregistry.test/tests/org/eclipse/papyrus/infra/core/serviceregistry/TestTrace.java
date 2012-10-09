/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.ArrayList;
import java.util.List;


/**
 * A class used to record traces for tests
 * 
 * @author cedric dumoulin
 *
 */
public class TestTrace {

	public List<TraceRecord>traces = new ArrayList<TraceRecord>();
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String trace) {
		addTrace(null, trace, null);
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String name, String trace) {
		addTrace(name, trace, null);
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void addTrace(String name, String trace, Object value) {
		traces.add(new TraceRecord( name, trace, value));
	}
	
	/**
	 * Return the name and the trace in one concatenated string ("name,trace").
	 * @param i Index of the requested trace
	 * @return
	 */
	public String getNameTrace(int i) {
		return traces.get(i).getNameTrace();
	}

	/**
	 * Get the value
	 * @param i
	 * @return
	 */
	public Object getValue(int i) {
		return traces.get(i).value;
	}

	/**
	 * Return true if the trace contains the specified events.
	 * @return
	 */
	public boolean contains( String name, String trace) {
		
		return indexOfNameTrace(name, trace) >= 0;
	}
	
    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOf(String name, String trace, Object value) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( name.equals(record.name) && trace.equals(record.trace) )
    			return i;
    	}

    	return -1;
      }

    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOfNameTrace(String name, String trace) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( name.equals(record.name) && trace.equals(record.trace) )
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

    		if( trace.equals(record.trace) )
    			return i;
    	}

    	return -1;
      }

    /**
     * Returns the index of the first occurrence of the specified elements
     * in these lists, or -1 if this list does not contain the element.
     */
    public int indexOfName(String name) {

    	for (int i = 0; i < traces.size(); i++) {
    		TraceRecord record = traces.get(i);

    		if( name.equals(record.name)  )
    			return i;
    	}

    	return -1;
      }

	/**
	 * Reset the trace.
	 */
	public void reset() {
		traces.clear();
	}

	
	/**
	 * @return the traces
	 */
	public List<TraceRecord> getTraces() {
		return traces;
	}
	
	/**
	 * A Record of the trace.
	 */
	public class TraceRecord {
		public String name;
		public String trace;
		public Object value;
		/**
		 * Constructor.
		 *
		 * @param name
		 * @param trace
		 * @param value
		 */
		public TraceRecord(String name, String trace, Object value) {
			this.name = name;
			this.trace = trace;
			this.value = value;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getNameTrace() {
			// TODO Auto-generated method stub
			return name + "," + trace;
		}
		
	}

}
