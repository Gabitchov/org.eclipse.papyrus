/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.export;


import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IConfiguration;
import org.eclipse.nebula.widgets.nattable.export.ILayerExporter;
import org.eclipse.nebula.widgets.nattable.export.action.ExportAction;
import org.eclipse.nebula.widgets.nattable.export.config.DefaultExportBindings;
import org.eclipse.nebula.widgets.nattable.export.excel.ExcelExporter;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.KeyEventMatcher;
import org.eclipse.swt.SWT;

public class PapyrusExportBindings extends DefaultExportBindings {

	public void configureRegistry(IConfigRegistry configRegistry) {
		configRegistry.registerConfigAttribute(ILayerExporter.CONFIG_ATTRIBUTE, new PapyrusExcelExporter());
	}


}
