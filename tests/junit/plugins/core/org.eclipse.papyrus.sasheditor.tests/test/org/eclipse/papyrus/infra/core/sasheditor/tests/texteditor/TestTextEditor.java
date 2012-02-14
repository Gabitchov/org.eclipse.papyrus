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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;


/**
 * A TextEditor that can be used as Tab of a sashes window.
 * 
 * @author dumoulin
 */
public class TestTextEditor extends TextEditor {

	private TraceLogger traceLog;
	/**
	 * Id used to register this editor in Eclipse.
	 * Can be used to open the editor.
	 */
	public static String EditorID = "org.eclipse.papyrus.infra.core.sasheditor.tests.editor.TestTextEditor";
	
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

	/**
	 * Close the specified editor.
	 * @param editor
	 */
	public static void closeEditor( TestTextEditor editor ) {
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		page.closeEditor(editor, false);
	}

	/**
	 * Return an instance of the editor inside the Eclipse framework.
	 * The Editor should be registered to Eclipse extension.
	 * The editor will contain one nested editor.
	 * @throws PartInitException 
	 */
	public static TestTextEditor openEditor() throws PartInitException {
		
		IEditorInput input = new FakeEditorInput();
		
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IEditorPart part = page.openEditor(input, EditorID);
		
		return  (TestTextEditor)part;
	}
	
	
}
