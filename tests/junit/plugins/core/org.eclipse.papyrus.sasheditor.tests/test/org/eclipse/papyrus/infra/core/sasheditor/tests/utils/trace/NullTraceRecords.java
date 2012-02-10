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
 * A {@link ITraceRecords} recording nothing.
 * 
 * @author Cedric Dumoulin
 *
 */
public class NullTraceRecords implements ITraceRecords {

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#addTrace(java.lang.String)
	 *
	 * @param trace
	 */
	public void addTrace(String trace) {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#addTrace(java.lang.String, java.lang.String)
	 *
	 * @param name
	 * @param trace
	 */
	public void addTrace(String name, String trace) {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#addTrace(java.lang.String, java.lang.String, java.lang.Object)
	 *
	 * @param name
	 * @param trace
	 * @param value
	 */
	public void addTrace(String name, String trace, Object value) {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#addTrace(java.lang.String, java.lang.String, java.lang.Object[])
	 *
	 * @param name
	 * @param trace
	 * @param values
	 */
	public void addTrace(String name, String trace, Object... values) {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#getFullName(int)
	 *
	 * @param i
	 * @return
	 */
	public String getFullName(int i) {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#getValue(int)
	 *
	 * @param i
	 * @return
	 */
	public Object getValue(int i) {
		throw new UnsupportedOperationException("Not available");
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#contains(java.lang.String, java.lang.String)
	 *
	 * @param name
	 * @param trace
	 * @return
	 */
	public boolean contains(String name, String trace) {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#indexOf(java.lang.String, java.lang.String, java.lang.Object)
	 *
	 * @param name
	 * @param trace
	 * @param value
	 * @return
	 */
	public int indexOf(String name, String trace, Object value) {
		return -1;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#indexOfNamespaceTrace(java.lang.String, java.lang.String)
	 *
	 * @param name
	 * @param trace
	 * @return
	 */
	public int indexOfNamespaceTrace(String name, String trace) {
		return -1;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#indexOfTrace(java.lang.String)
	 *
	 * @param trace
	 * @return
	 */
	public int indexOfTrace(String trace) {
		return -1;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#indexOfNamespace(java.lang.String)
	 *
	 * @param namespace
	 * @return
	 */
	public int indexOfNamespace(String namespace) {
		return -1;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#reset()
	 *
	 */
	public void reset() {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords#getTraces()
	 *
	 * @return
	 */
	public List<TraceRecord> getTraces() {
		throw new UnsupportedOperationException("Not available");
	}

}
