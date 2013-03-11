/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.exporter;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.papyrus.cdo.internal.core.exporter.ModelExporterFactory;

/**
 * This is the IModelExporter type. Enjoy.
 */
public interface IModelExporter {

	Diagnostic exportModels(IModelExportMapping mapping);

	interface Factory {

		Factory DEFAULT = new ModelExporterFactory();

		IModelExporter create();
	}
}
