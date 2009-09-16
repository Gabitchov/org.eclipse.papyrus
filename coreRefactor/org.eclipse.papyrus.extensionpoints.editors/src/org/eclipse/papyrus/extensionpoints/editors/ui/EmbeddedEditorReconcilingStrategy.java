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

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy;
import org.eclipse.ui.texteditor.spelling.SpellingService;


/**
 * Reconcile strategy used for spell checking and semantic verification
 */
public class EmbeddedEditorReconcilingStrategy extends SpellingReconcileStrategy {

	/**
	 * Creates a new EmbeddedEditorReconcilingStrategy.
	 * @param viewer the source viewer containing the text to reconcile
	 * @param spellingService the service in charge of the spelling verification
	 */
	public EmbeddedEditorReconcilingStrategy(ISourceViewer viewer, SpellingService spellingService) {
		super(viewer, spellingService);
	}
	
	

}
