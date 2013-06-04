/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;


/**
 * A fake listener implementation for testing purpose.
 * @author cedric dumoulin
 *
 */
public class FakeFolderLifeCycleEventsListener implements ITabFolderPartLifeCycleEventsListener {

	public static final String FOLDER_CREATED = "folderCreated";

	public static final String FOLDER_DISPOSED = "folderDisposed";


	/** */
	public int eventCount = 0;

	/** */
	public List<String> traces;

	/** */
	public List<TabFolderPart> events;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public FakeFolderLifeCycleEventsListener() {
		traces = new ArrayList<String>();
		events = new ArrayList<TabFolderPart>();
	}


	/**
	 * @return the eventCount
	 */
	public int getEventCount() {
		return eventCount;
	}


	/**
	 * @return the trace
	 */
	public List<String> getTraces() {
		return traces;
	}

	/**
	 * @return the trace
	 */
	public String getTrace(int index) {
		return traces.get(index);
	}

	/**
	 * @return the trace
	 */
	public List<TabFolderPart> getEvents() {
		return events;
	}

	/**
	 * @return the trace
	 */
	public TabFolderPart getEvent(int index) {
		return events.get(index);
	}

	/**
	 * 
	 */
	public void resetChangeCount() {
		eventCount = 0;
	}

	/**
	 * 
	 */
	public void resetTraces() {
		traces.clear();
		events.clear();
	}

	/* ************************** */
	/* Methods          */
	/* ************************** */


	public void folderCreated(TabFolderPart folder) {
		traces.add(FOLDER_CREATED);
		events.add(folder);
		eventCount++;
	}


	public void folderDisposed(TabFolderPart folder) {
		traces.add(FOLDER_DISPOSED);
		events.add(folder);
		eventCount++;
	}

	@Override
	public String toString() {
		
		StringBuffer buf = new StringBuffer();
		buf.append("{");
		for( int i=0; i<events.size(); i++) {
			buf.append("[")
			   .append(traces.get(i) )
			   .append("-")
			   .append( events.get(i).getClass().getSimpleName())
			   .append("]");
			
			if(i<events.size()) {
				buf.append(",");
			}
		}
		buf.append("}");
		
		return buf.toString();
	}
}
 