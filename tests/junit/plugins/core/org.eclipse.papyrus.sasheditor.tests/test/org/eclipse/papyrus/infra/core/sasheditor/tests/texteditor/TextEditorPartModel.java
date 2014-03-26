/*****************************************************************************
 * Copyright (c) 2009, 2014 LIFL, CEA LIST, and others. 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords;
import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.TraceRecordsFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * Description of the first page
 * 
 * @author dumoulin
 */

public class TextEditorPartModel implements IEditorModel {

	/**
	 * Records used to record traces.
	 */
	private ITraceRecords traceRecords;
	
	private String title;
	

	static private int count = 0;

	/**
	 * @param title
	 */
	public TextEditorPartModel(String title) {
		this( title, false);
	}

	/**
	 * @param title
	 */
	public TextEditorPartModel(String title, boolean isRecording) {
		this(title,  TraceRecordsFactory.createTraceRecords(isRecording));

	}

	/**
		 * 
		 */
	public TextEditorPartModel() {
		this( null, false);
	}
	
	/**
	 * @param title
	 */
	public TextEditorPartModel(String title, ITraceRecords traceRecords) {
		this.title = title;
		if( title == null) 
			this.title = "newText" + count++;
		
		this.traceRecords = traceRecords;
	}
	
	
	/**
	 * @return the traceRecords
	 */
	public ITraceRecords getTraceRecords() {
		return traceRecords;
	}

	
	/**
	 * @param traceRecords the traceRecords to set
	 */
	public void setTraceRecords(ITraceRecords traceRecords) {
		this.traceRecords = traceRecords;
	}

	public IEditorPart createIEditorPart() throws PartInitException {
		
		// Create an editor with the requested traceRecords
		TestTextEditor editor = new TestTextEditor(title, traceRecords);
		
		editor.setPartName(title);
		
		return editor;
	}

	public Image getTabIcon() {
		return null;
	}

	public String getTabTitle() {
		return title;
	}

	/**
	 * Return this. In this implementation, the rawModel and the IEditorModel are the same.
	 * 
	 */
	public Object getRawModel() {
		return this;
	}

	/**
	 * Return the ActionBarContributor dedicated to the created editor.
	 * Can return null if no particular ActionBarContributor is required.;
	 */
	public EditorActionBarContributor getActionBarContributor() {
		return null;
	}
	
	public void dispose() {
		// Pass
	}
}
