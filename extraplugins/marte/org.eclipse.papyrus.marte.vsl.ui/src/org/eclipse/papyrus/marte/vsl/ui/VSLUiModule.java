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
package org.eclipse.papyrus.marte.vsl.ui;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.VSLContentAssistProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalComparator;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used within the IDE.
 */
public class VSLUiModule extends org.eclipse.papyrus.marte.vsl.ui.AbstractVSLUiModule {
	public VSLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return VSLContentAssistProcessor.class;
	}
}
