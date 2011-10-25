/***************************************************************************

 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.Saveable;

/**
 * A {@link Saveable} that targets the {@link Saveable#doSave(IProgressMonitor)} action to the
 * active {@link IEditorPart}.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=290424">Bug 290424</a>
 * 
 */
public class ToEditorSaveable extends Saveable {

	private IEditorPart editor = null;

	private IWorkbenchPart part = null;

	public ToEditorSaveable(IEditorPart editor, IWorkbenchPart part) {
		this.editor = editor;
		this.part = part;
	}

	@Override
	public void doSave(IProgressMonitor monitor) throws CoreException {
		if(editor != null) {
			editor.doSave(monitor);
		}
	}

	public IEditorPart getEditor() {
		return editor;
	}

	public void setEditor(IEditorPart editor) {
		this.editor = editor;
	}

	public IWorkbenchPart getPart() {
		return part;
	}

	protected IEditorInput getEditorInput() {
		if(getEditor() != null && getEditor().getEditorInput() != null) {
			return getEditor().getEditorInput();
		}
		return null;
	}

	@Override
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(getPart() != null && object instanceof ToEditorSaveable) {
			return getPart().equals(((ToEditorSaveable)object).getPart());
		}
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		if(getEditor() != null) {
			return getEditor().getEditorInput().getName();
		}
		return null;
	}

	@Override
	public String getToolTipText() {
		if(getEditor() != null) {
			return "Save " + getName() + " contents";
		}
		return null;
	}

	@Override
	public int hashCode() {
		if(getPart() != null) {
			return part.hashCode();
		}
		return 0x0;
	}

	@Override
	public boolean isDirty() {
		if(getEditor() != null) {
			return getEditor().isDirty();
		}
		return false;
	}

}
