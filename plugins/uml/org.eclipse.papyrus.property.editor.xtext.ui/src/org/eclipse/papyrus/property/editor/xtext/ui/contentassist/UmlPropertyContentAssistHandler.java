/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.property.editor.xtext.ui.contentassist;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.property.editor.xtext.ui.editor.ContextEditorUtil;
import org.eclipse.ui.ISources;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.handler.ContentAssistHandler;

/**
 * Class for customization content assist
 *
 */
public class UmlPropertyContentAssistHandler extends ContentAssistHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		new ContentAssistAction(XtextUIMessages.getResourceBundle(), "ContentAssistProposal.",
				(ITextEditor) ContextEditorUtil.currentEditor).run();
		return this;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		boolean contentAssistAvailable = false;
		if (evaluationContext instanceof IEvaluationContext) {
			Object var = ((IEvaluationContext) evaluationContext).getVariable(ISources.ACTIVE_EDITOR_NAME);
			// TODO: this is just for testing....
			var = ContextEditorUtil.currentEditor ;
			//////////////////////////////////////
			if (var instanceof XtextEditor) {
				contentAssistAvailable = ((XtextEditor) var).isContentAssistAvailable();
			}
		}
		super.setBaseEnabled(contentAssistAvailable) ;
		//super.setBaseEnabled(isEnabled() & contentAssistAvailable);
	}
	
}
