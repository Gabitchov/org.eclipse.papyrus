/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.editors;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditorSupport;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;

import com.google.common.collect.Maps;

/**
 * This is the DawnEditorAdapter type. Enjoy.
 */
public class DawnEditorAdapter
		implements IDawnEditor {

	private static Map<IEditorPart, IDawnEditor> ADAPTERS = Maps.newHashMap();

	private final DiagramDocumentEditor diagramEditor;

	private IDawnEditorSupport editorSupport;

	private CDOView view;

	private String contributorID;

	public DawnEditorAdapter(DiagramDocumentEditor diagramEditor) {
		this.diagramEditor = diagramEditor;

		ADAPTERS.put(diagramEditor, this);
	}

	DiagramDocumentEditor getDiagramEditor() {
		return diagramEditor;
	}

	public static IDawnEditor getDawnEditor(IEditorPart editor) {
		return ADAPTERS.get(editor);
	}

	static void removeAdapter(IEditorPart editor) {
		ADAPTERS.remove(editor);
	}

	public CDOView getView() {
		return view;
	}

	void setView(CDOView view) {
		this.view = view;
	}

	public String getContributorID() {
		if (contributorID == null) {
			contributorID = determineEditorID(diagramEditor);
		}

		return contributorID;
	}

	public void setDirty() {
		IDocumentProvider documentProvider = diagramEditor
			.getDocumentProvider();
		if (documentProvider != null) {
			documentProvider.setCanSaveDocument(getEditorInput());
		}
	}

	public Object getAdapter(@SuppressWarnings("rawtypes")
	Class adapter) {
		if ((adapter == DiagramDocumentEditor.class)
			|| (adapter == DiagramEditor.class)) {
			return diagramEditor;
		}

		return diagramEditor.getAdapter(adapter);
	}

	private String determineEditorID(DiagramDocumentEditor editor) {
		String result = null;

		// look for the generated ID constant
		for (Class<?> clazz = editor.getClass(); (clazz != null)
			&& (clazz != Object.class); clazz = clazz.getSuperclass()) {

			try {
				Field idField = clazz.getField("ID");
				int modifiers = idField.getModifiers();
				if ((idField.getType() == String.class)
					&& Modifier.isStatic(modifiers)
					&& Modifier.isFinal(modifiers)
					&& Modifier.isPublic(modifiers)) {

					result = (String) idField.get(null);
				}
			} catch (Exception e) {
				// it's OK. No such field, that's fine. Try the superclass
			}
		}

		if (result == null) {
			// this is the default ID pattern generated for Papyrus editors
			result = editor.getClass().getName() + "ID";
		}

		return result;
	}

	public void doSave(IProgressMonitor monitor) {
		CDOView view = getView();

		// the Papyrus diagram editors don't save; the multi-editor does.
		// But, we know that save is commit, so do that
		if (view instanceof CDOTransaction) {
			try {
				((CDOTransaction) view).commit(monitor);
			} catch (CommitException e) {
				Activator.log.error(
					"Failed to commit transaction to save editor.", e);
			}
		} else {
			diagramEditor.doSave(monitor);
		}
	}

	//
	// Delegation methods
	//

	public boolean isDirty() {
		return diagramEditor.isDirty();
	}

	public IDawnEditorSupport getDawnEditorSupport() {
		return editorSupport;
	}

	void setEditorSupport(IDawnEditorSupport editorSupport) {
		this.editorSupport = editorSupport;
	}

	public IEditorInput getEditorInput() {
		return diagramEditor.getEditorInput();
	}

	public IEditorSite getEditorSite() {
		return diagramEditor.getEditorSite();
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		diagramEditor.init(site, input);
	}

	public void addPropertyListener(IPropertyListener listener) {
		diagramEditor.addPropertyListener(listener);
	}

	public void createPartControl(Composite parent) {
		diagramEditor.createPartControl(parent);
	}

	public void dispose() {
		diagramEditor.dispose();
	}

	public IWorkbenchPartSite getSite() {
		return diagramEditor.getSite();
	}

	public String getTitle() {
		return diagramEditor.getTitle();
	}

	public Image getTitleImage() {
		return diagramEditor.getTitleImage();
	}

	public String getTitleToolTip() {
		return diagramEditor.getTitleToolTip();
	}

	public void removePropertyListener(IPropertyListener listener) {
		diagramEditor.removePropertyListener(listener);
	}

	public void setFocus() {
		diagramEditor.setFocus();
	}

	public void doSaveAs() {
		diagramEditor.doSaveAs();
	}

	public boolean isSaveAsAllowed() {
		return diagramEditor.isSaveAsAllowed();
	}

	public boolean isSaveOnCloseNeeded() {
		return diagramEditor.isSaveOnCloseNeeded();
	}

}
