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
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.VSLContentAssistProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Use this class to register components to be used within the IDE.
 */
public class StereotypeApplicationWithVSLUiModule extends org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.AbstractStereotypeApplicationWithVSLUiModule {
	public StereotypeApplicationWithVSLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return VSLContentAssistProcessor.class;
	}
}
