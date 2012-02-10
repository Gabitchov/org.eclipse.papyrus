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
 * Factory to create TraceRecords.
 * @author dumoulin
 *
 */
public class TraceRecordsFactory {

	
	 /**
	  * Create a TraceRecords.
	  * 
	  * @param isRecording  true is the traceRecord should record.
	  * @return
	  */
	public static ITraceRecords createTraceRecords( boolean isRecording ) {
		
		if(isRecording) {
			return new TraceRecords();
		}
		else {
			return new NullTraceRecords();			
		}
	}
	
}
