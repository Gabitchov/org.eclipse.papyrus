/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.partialEditing;

import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;

import com.google.inject.Injector;

/**
 * 
 */
public class SourceViewerHandle {
	private IValidationIssueProcessor issueProcessor;
	private final XtextSourceViewer viewer;
	private final ISyntheticResourceProvider resourceProvider;
	private final XtextDocument document;
	private final XtextSourceViewerConfiguration configuration;

	SourceViewerHandle(XtextDocument document, XtextSourceViewer viewer, XtextSourceViewerConfiguration configuration, ISyntheticResourceProvider resourceProvider, Injector xtextInjector) {
		this.document = document;
		this.viewer = viewer;
		this.configuration = configuration;
		this.resourceProvider = resourceProvider;
	}

	/**
	 * @param issueProcessor 
	 *
	 */
	public void setIssueProcessor(IValidationIssueProcessor issueProcessor) {
		this.issueProcessor = issueProcessor;
	}
	
	/**
	 * @return IValidationIssueProcessor
	 *
	 */
	public IValidationIssueProcessor getIssueProcessor() {
		return issueProcessor;
	}
	
	/**
	 * @return XtextSourceViewer
	 *
	 */
	public XtextSourceViewer getViewer() {
		return viewer;
	}
	
	/**
	 * @return XtextDocument
	 *
	 */
	public XtextDocument getDocument() {
		return document;
	}
	
	/**
	 * @return XtextSourceViewerConfiguration
	 *
	 */
	public XtextSourceViewerConfiguration getConfiguration() {
		return configuration;
	}
	
	/**
	 * @param prefix 
	 * @param editablePart 
	 * @param suffix 
	 * @return PartialModelEditor
	 *
	 */
	public PartialModelEditor createPartialEditor(String prefix, String editablePart, String suffix) {
		PartialModelEditor result = new PartialModelEditor(viewer, resourceProvider, false);
		result.setModel(getDocument(), prefix, editablePart, suffix);
		return result;
	}
	
	/**
	 * @return PartialModelEditor
	 *
	 */
	public PartialModelEditor createPartialEditor() {
		return createPartialEditor("", "", "");
	}
}