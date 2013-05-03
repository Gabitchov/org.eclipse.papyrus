/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

/**
 * This class extends XtextSourceViewer with the method getContentAssistant()
 * This method was available on XtextSourceViewer in Xtext 1.0, and used
 * for integration in Papyrus.
 * 
 * @author CEA LIST - Initial contribution and API
 */
public class CustomXtextSourceViewer extends XtextSourceViewer {

	/**
	 * @param parent 
	 * @param ruler 
	 * @param overviewRuler 
	 * @param showsAnnotationOverview 
	 * @param styles 
	 *
	 */
	public CustomXtextSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}

	/**
	 * Used in papyrus integration for managing content assist in popup editors.
	 * @return the content assistant
	 *
	 */
	public IContentAssistant getContentAssistant() {
		return fContentAssistant;
	}

	@Override
	protected void customizeDocumentCommand(DocumentCommand command) {
		// TODO: TextViewer.customizeDocumentCommand generates exceptions. Why?
		//super.customizeDocumentCommand(command);
	}
	
	
	
}
