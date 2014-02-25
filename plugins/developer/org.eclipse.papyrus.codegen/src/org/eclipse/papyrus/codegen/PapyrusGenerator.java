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
 *		Vincent Lorenzo (CEA - LIST) - minor change
 *****************************************************************************/
package org.eclipse.papyrus.codegen;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.xtend.ui.handlers.GeneratorWithXtend2;
import org.eclipse.gmf.common.UnexpectedBehaviourException;


public class PapyrusGenerator extends GeneratorWithXtend2 {




	public PapyrusGenerator(GenEditorGenerator genModel, PapyrusCodegenEmitters emitters) {
		super(genModel, emitters);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
		super.customRun();
	}


}
