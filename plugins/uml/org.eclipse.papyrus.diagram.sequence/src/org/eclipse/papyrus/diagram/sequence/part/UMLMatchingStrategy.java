/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;


/**
 * @generated
 */
public class UMLMatchingStrategy implements IEditorMatchingStrategy {

	/**
	 * @generated
	 */
	public boolean matches(IEditorReference editorRef, IEditorInput input) {
		IEditorInput editorInput;
		try {
			editorInput = editorRef.getEditorInput();
		} catch (PartInitException e) {
			return false;
		}

		CachedResourcesEditorInput cachedEditorInput = null;
		if (input instanceof CachedResourcesEditorInput) {
			cachedEditorInput = (CachedResourcesEditorInput) input;
		}

		if (cachedEditorInput != null) {
			if (cachedEditorInput.isOpenInNewEditor()) {
				// we want to open in a new editor, alas if the IEditorInput is
				// exactly the same (the same resource AND diagram) we can reuse
				// this editor
				if (CachedResourcesEditorInput.checkSameEditorInputWithFragment(editorInput, cachedEditorInput)) {
					return true;
				}
				return false;
			}
		}

		if (editorInput instanceof URIEditorInput && input instanceof URIEditorInput) {
			// extra insanity check
			return ((URIEditorInput) editorInput).getURI().equals(((URIEditorInput) input).getURI());
		}
		return false;
	}

}
