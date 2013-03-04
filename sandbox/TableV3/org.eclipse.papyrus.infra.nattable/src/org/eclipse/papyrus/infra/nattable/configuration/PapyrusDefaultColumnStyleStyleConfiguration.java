/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.config.DefaultColumnHeaderStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.BeveledBorderDecorator;


public class PapyrusDefaultColumnStyleStyleConfiguration extends DefaultColumnHeaderStyleConfiguration {



	@Override
	public void configureRegistry(final IConfigRegistry configRegistry) {
		this.cellPainter = new BeveledBorderDecorator(new HeaderCellPainter());
		super.configureRegistry(configRegistry);
	}
}
