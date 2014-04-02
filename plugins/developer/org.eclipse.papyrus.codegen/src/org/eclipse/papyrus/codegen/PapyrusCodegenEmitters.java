/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.codegen;

import org.eclipse.gmf.codegen.xtend.ui.handlers.CodegenEmittersWithXtend2;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.JavaClassEmitter;

@SuppressWarnings("restriction")
public class PapyrusCodegenEmitters extends CodegenEmittersWithXtend2 {

	public PapyrusCodegenEmitters(boolean useBaseTemplatesOnly, String templateDirectory, boolean includeDynamicModelTemplates) {
		super(useBaseTemplatesOnly, templateDirectory, includeDynamicModelTemplates);
	}

	@Override
	public JavaClassEmitter getModelingAssistantProviderEmitter() throws UnexpectedBehaviourException {
		return null;
	}

	@Override
	public JavaClassEmitter getNodeEditPartModelingAssistantProviderEmitter() {
		return null;
	}

	@Override
	public JavaClassEmitter getDeleteElementActionEmitter() {
		return null;
	}
}
