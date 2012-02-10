/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor;

import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords;
import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.TraceLogger;
import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.TraceRecordsFactory;
import org.eclipse.ui.editors.text.TextEditor;


/**
 * A TextEditor that can be used as Tab of a sashes window.
 * 
 * @author dumoulin
 */
public class TestTextEditor extends TextEditor {

	private TraceLogger traceLog;
	
	/**
	 * 
	 */
	public TestTextEditor() {
		this("", false);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param namespace Namespace used to associated traces
	 * @param traceRecords Records where traces should be put.
	 */
	public TestTextEditor(String name, ITraceRecords traceRecords) {
		this.traceLog = new TraceLogger(name, traceRecords);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param namespace Namespace used to associated traces
	 * @param isRecording true is the traceRecord should record.
	 */
	public TestTextEditor(String name, boolean isRecording) {
		this(name, TraceRecordsFactory.createTraceRecords(isRecording));
	}

	
	/**
	 * @return the traceLog
	 */
	public TraceLogger getTraceLog() {
		return traceLog;
	}

	/**
	 * Set the namespace of this part. {@inheritDoc}
	 */
	@Override
	public void setPartName(String partName) {
		super.setPartName(partName);
	}
	
	/**
	 * Trace the call
	 * @see org.eclipse.ui.editors.text.TextEditor#dispose()
	 *
	 */
	@Override
	public void dispose() {
		// Trace the call
		traceLog.trace("dispose");
		
		super.dispose();
	}
}
