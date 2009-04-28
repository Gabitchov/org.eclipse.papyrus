/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.part;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.PathsUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

/**
 * The Class CachedResourcesDiagramEditor.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public abstract class CachedResourcesDiagramEditor extends DiagramDocumentEditor {

	/**
	 * Instantiates a new cached resources diagram editor.
	 * 
	 * @param hasFlyoutPalette
	 *            the has flyout palette
	 */
	public CachedResourcesDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
	}

	/**
	 * Gets the cached resources document provider.
	 * 
	 * @return the cached resources document provider
	 */
	protected CachedResourcesDocumentProvider getCachedResourcesDocumentProvider() {
		if (getDocumentProvider() != null && getDocumentProvider() instanceof CachedResourcesDocumentProvider == true) {
			return (CachedResourcesDocumentProvider) getDocumentProvider();
		}
		return null;
	}

	/**
	 * We want the EditingDomainRegistry to listen to editors closing. At each initialization we add the EditingDomainRegistry as a PartListener.
	 * 
	 * @param site
	 *            the site
	 * @param input
	 *            the input
	 * 
	 * @throws PartInitException
	 *             the part init exception
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		site.getPage().addPartListener(EditingDomainRegistry.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#doSetInput(org.eclipse.ui.IEditorInput, boolean)
	 */
	@Override
	public void doSetInput(IEditorInput input, boolean releaseEditorContents) throws CoreException {
		IEditorInput editorInput = getEditorInput();

		if (editorInput == null) {
			// check if theres is a previously opened diagram set as a property
			// and open that diagram instead
			String filePath = PathsUtil.getRelativeWorkspaceFromEditorInput(input);
			String diagramFragment = MDTUtil.getLastOpenedDiagramProperty(filePath);
			if (diagramFragment != null) {
				URI uri = URI.createURI(filePath).appendFragment(diagramFragment);
				input = MDTUtil.copyEditorInputButUri(input, uri);
			}
		}

		if (checkSameEditorInput(input, editorInput)) {
			return;
		}
		CachedResourcesDocumentProvider documentProvider = getCachedResourcesDocumentProvider();
		if (documentProvider != null) {
			if (input instanceof CachedResourcesEditorInput) {
				if (((CachedResourcesEditorInput) input).isUnload()) {
					documentProvider.setUnloadOnDispose(true);
					removeEditingDomainFromRegistry();
				} else {
					documentProvider.setUnloadOnDispose(false);
				}
			} else {
				documentProvider.setUnloadOnDispose(true);
				removeEditingDomainFromRegistry();
			}
		}
		super.doSetInput(input, releaseEditorContents);
	}

	/**
	 * Check same editor input.
	 * 
	 * @param input1
	 *            the input1
	 * @param input2
	 *            the input2
	 * 
	 * @return true, if successful
	 */
	protected boolean checkSameEditorInput(IEditorInput input1, IEditorInput input2) {
		String uri1 = "", uri2 = "";
		if (input1 instanceof FileEditorInput) {
			uri1 = ((FileEditorInput) input1).getURI().toString();
		}
		if (input1 instanceof URIEditorInput) {
			uri1 = ((URIEditorInput) input1).getURI().toString();
		}
		if (input2 instanceof FileEditorInput) {
			uri2 = ((FileEditorInput) input2).getURI().toString();
		}
		if (input2 instanceof URIEditorInput) {
			uri2 = ((URIEditorInput) input2).getURI().toString();
		}
		if (uri1.equals(uri2)) {
			return true;
		}

		return false;
	}

	/**
	 * Removes the editing domain from registry.
	 */
	protected void removeEditingDomainFromRegistry() {
		CachedResourcesDocumentProvider documentProvider = getCachedResourcesDocumentProvider();
		if (documentProvider != null) {
			EditingDomainRegistry.getInstance().remove(documentProvider.getEditingDomainID());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#close(boolean)
	 */
	@Override
	public void close(boolean save) {
		CachedResourcesDocumentProvider documentProvider = getCachedResourcesDocumentProvider();
		if (documentProvider != null) {
			documentProvider.setUnloadOnDispose(false);
			// fjcano : the EditingDomainRegistriy takes care of disposing unused EditingDomains.
			// removeEditingDomainFromRegistry();
		}
		super.close(save);
	}

	/**
	 * Close but unload.
	 * 
	 * @param save
	 *            the save
	 */
	public void closeButUnload(boolean save) {
		CachedResourcesDocumentProvider documentProvider = getCachedResourcesDocumentProvider();
		if (documentProvider != null) {
			documentProvider.setUnloadOnDispose(false);
		}
		super.close(save);
	}

	/**
	 * Gets the editor id.
	 * 
	 * @return the editor id
	 */
	public abstract String getEditorID();

	/**
	 * Sets the unload on dispose.
	 * 
	 * @param unload
	 *            the new unload on dispose
	 */
	public void setUnloadOnDispose(boolean unload) {
		IDocumentProvider documentProvider = getDocumentProvider();
		if (documentProvider instanceof CachedResourcesDocumentProvider) {
			((CachedResourcesDocumentProvider) documentProvider).setUnloadOnDispose(unload);
		}
	}

}
