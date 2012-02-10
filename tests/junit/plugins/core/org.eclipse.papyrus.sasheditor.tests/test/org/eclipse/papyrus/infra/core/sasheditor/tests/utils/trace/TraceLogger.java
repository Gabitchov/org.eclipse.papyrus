/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace;


/**
 * Instances of this class are used to log traces of a namespace.
 * 
 * @author Cedric Dumoulin
 *
 */
public class TraceLogger {

	/**
	 * The namespace used to tag records.
	 */
	protected String namespace;

	/**
	 * The records
	 */
	protected ITraceRecords records;
	
	/**
	 * Constructor.
	 * A logger logging nothing.
	 *
	 * @param namespace
	 */
	public TraceLogger(String namespace, boolean isRecording) {
		this.namespace = namespace;
		this.records = TraceRecordsFactory.createTraceRecords(isRecording);
	}

	/**
	 * Constructor.
	 *
	 * @param namespace
	 * @param records
	 */
	public TraceLogger(String namespace, ITraceRecords records) {
		this.namespace = namespace;
		this.records = records;
	}

	
	/**
	 * @return the records
	 */
	public ITraceRecords getTraceRecords() {
		return records;
	}

	
	/**
	 * @param records the records to set
	 */
	public void setTraceRecords(ITraceRecords records) {
		this.records = records;
	}

	
	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	
	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void trace(String trace) {
		records.addTrace(namespace, trace, (Object)null);
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void trace(String trace, Object value) {
		records.addTrace( namespace, trace, value);
	}
	
	/**
	 * Record a new trace.
	 * @param trace
	 */
	public void trace(String trace, Object ... values) {
		records.addTrace( namespace, trace, values);
	}
	

}
