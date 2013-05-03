/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing;

import java.lang.reflect.Constructor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;

import com.google.inject.Injector;

/**
 * 
 */
public class SourceViewerHandle {
	protected IValidationIssueProcessor issueProcessor;
	protected final XtextSourceViewer viewer;
	protected final ISyntheticResourceProvider resourceProvider;
	protected final XtextDocument document;
	protected final XtextSourceViewerConfiguration configuration;
	protected static Class partialModelEditorClass = null ;
	private Class defaultModelEditorClass = PartialModelEditor.class ;
	protected EObject semanticElement ;
	protected IXtextEMFReconciler modelReconciler ;
	
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
	 * @param semanticElement 
	 * @param modelReconciler 
	 * @return PartialModelEditor
	 *
	 */
	public PartialModelEditor createPartialEditor(String prefix, String editablePart, String suffix, EObject semanticElement, IXtextEMFReconciler modelReconciler) {
		//PartialModelEditor result = new PartialModelEditor(viewer, resourceProvider, false);
		PartialModelEditor result = null;
		try {
			if (partialModelEditorClass == null)
				partialModelEditorClass = defaultModelEditorClass ;
			Constructor c = partialModelEditorClass.getConstructor(SourceViewer.class, 
											   ISyntheticResourceProvider.class,
											   boolean.class,
											   EObject.class,
											   IXtextEMFReconciler.class
											   ) ;
			this.semanticElement = semanticElement ;
			this.modelReconciler = modelReconciler ;
			result = (PartialModelEditor)c.newInstance(viewer, resourceProvider, false, semanticElement, modelReconciler) ;
			result.setModel(getDocument(), prefix, editablePart, suffix);
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
		// result.setModel(getDocument(), prefix, editablePart, suffix);
		return result;
	}
	
	/**
	 * @param modelEditorClass 
	 *
	 */
	public static void bindPartialModelEditorClass(Class modelEditorClass) {
		partialModelEditorClass = modelEditorClass ;
	}
	
	/**
	 * @return PartialModelEditor
	 *
	 */
	public PartialModelEditor createPartialEditor() {
		return createPartialEditor("", "", "", null, null);
	}
}