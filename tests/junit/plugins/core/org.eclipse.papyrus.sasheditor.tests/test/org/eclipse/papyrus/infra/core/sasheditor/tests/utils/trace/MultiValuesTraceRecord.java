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

import java.util.ArrayList;
import java.util.List;


/**
 * @author dumoulin
 *
 */
public class MultiValuesTraceRecord extends TraceRecord {

	public List<Object> values;

	
	public MultiValuesTraceRecord(String namespace, String trace, Object ... values) {
		super(namespace, trace);
 
		// Initialie collection
		this.values = new ArrayList<Object>(values.length);
		for( Object o : values )
			this.values.add(o);
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.TraceRecord#getValue()
	 *
	 * @return
	 */
	@Override
	public Object getValue() {
		if( values.size()>0)
		  return values.get(0);
		
		// No value set.
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.TraceRecord#getValues()
	 *
	 * @return
	 */
	@Override
	public List<Object> getValues() {
		return values;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.TraceRecord#clear()
	 *
	 */
	@Override
	public void clear() {
		super.clear();
		values.clear();
	}
}
