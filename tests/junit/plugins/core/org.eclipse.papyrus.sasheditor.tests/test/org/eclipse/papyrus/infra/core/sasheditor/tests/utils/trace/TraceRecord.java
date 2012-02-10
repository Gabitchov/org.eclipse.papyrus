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

import java.util.List;


/**
 * This interface represent one record
 * @author Cedric Dumoulin
 *
 */
public abstract class TraceRecord {

	public String namespace;
	public String trace;
	
	
	/**
	 * Constructor.
	 *
	 * @param namespace
	 * @param trace
	 */
	public TraceRecord(String namespace, String trace) {
		this.namespace = namespace;
		this.trace = trace;
	}

	/**
	 * Get the full name, i.e. : the namespace, name
	 * @return
	 */
	public String getFullName() {
		return namespace + "," + trace;
	}

	/**
	 * Get the first  value associated to this record.
	 * @return
	 */
	public abstract Object getValue();
	
	/**
	 * Get all values associated to this record
	 * @return
	 */
	public abstract List<Object> getValues();

	/**
	 * Return true if this object's trace equal the provided values.
	 * 
	 * @param trace
	 * @return
	 */
	public boolean isEqualsToTrace( String trace) {
		
		return (this.trace.equals(trace)) ;
	}
	
	/**
	 * Return true if this object's namespace equal the provided values.
	 * 
	 * @param namespace
	 * @return
	 */
	public boolean isEqualsToNameSpace( String namespace) {
		
		return this.namespace.equals(namespace) ;
	}
	
	/**
	 * Return true if this object's namespace and trace equal the provided values.
	 * If a provided value is null, it is consider as a wildcard.
	 * 
	 * @param namespace
	 * @param trace
	 * @return
	 */
	public boolean isEqualsTo( String namespace, String trace) {
		
		return (namespace != null ? namespace.equals(this.namespace) : true)
				&& (trace != null ? trace.equals(this.trace) : true) ;
	}
	
	/**
	 * Return true if this object's namespace and trace equal the provided values.
	 * If a provided value is null, it is consider as a wildcard.
	 * 
	 * @param namespace
	 * @param trace
	 * @return
	 */
	public boolean isEqualsTo( String namespace, String trace, Object value) {
		
		return (namespace != null ? namespace.equals(this.namespace) : true)
				&& (trace != null ? trace.equals(this.trace) : true) 
				&& (value != null ? value.equals(getValue()) : true);
	}
	
	/**
	 * Clear the record. It will not be used anymore. This is mainly to avoid memory leak.
	 */
	public void clear() {
		namespace = null;
		trace = null;
	}
	
}
