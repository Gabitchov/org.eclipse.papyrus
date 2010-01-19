/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;

/**
 * Document provider for embedded editors
 */
public class EmbeddedEditorDocumentProvider extends AbstractDocumentProvider {

	/** text editor that uses this document provider */
	protected EmbeddedTextEditor textEditor;

	/**
	 * Creates a new EmbeddedEditorDocumentProvider.
	 * 
	 * @param textEditor
	 *        the editor linked to this document provider
	 */
	public EmbeddedEditorDocumentProvider(EmbeddedTextEditor textEditor) {
		super();
		this.textEditor = textEditor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		return new AnnotationModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		Document result = new Document();
		result.set(getLabelToEdit(element));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isModifiable(Object element) {
		return true;
	}

	/**
	 * Returns the string label to edit.
	 * 
	 * @param element
	 *        the edited element
	 * @return the text corresponding to the edited element
	 */
	protected String getLabelToEdit(Object element) {
		if(element instanceof EmbeddedEditorInput) {
			EObject object = ((EmbeddedEditorInput)element).getEditedObject();
			return textEditor.getDirectEditorConfiguration().getTextToEdit(object);
		}
		return element.toString();
	}

	/**
	 * Applies changes to the model, given the new text
	 * 
	 * @param element
	 *        the element modified
	 * @return the result of the modification
	 */
	protected Object applyChanges(Object element) {
		if(element instanceof EmbeddedEditorInput) {
			EObject object = ((EmbeddedEditorInput)element).getEditedObject();
			return textEditor.getDirectEditorConfiguration().postEditAction(object, getDocument(((EmbeddedEditorInput)element)).get());
		}
		return element.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		throw new RuntimeException("Impossible to save the content of an embedded editor.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}

}
