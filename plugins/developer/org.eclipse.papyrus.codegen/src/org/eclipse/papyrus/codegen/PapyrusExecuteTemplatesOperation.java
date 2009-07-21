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

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.util.Generator;
import org.eclipse.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation;

/**
 * The Papyrus execute templates operation
 * 
 * @see org.eclipse.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation
 * @author tlandre
 */
public class PapyrusExecuteTemplatesOperation extends ExecuteTemplatesOperation {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Generator createGenerator() {
		GenEditorGenerator genModel = getGenModel();
		return new PapyrusGenerator(genModel, new PapyrusCodegenEmitters(!genModel.isDynamicTemplates(), genModel
				.getTemplateDirectory(), genModel.getModelAccess() != null));
	}

}
