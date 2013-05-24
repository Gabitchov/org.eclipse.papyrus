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
package org.eclipse.papyrus.infra.nattable.layer;

import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.papyrus.infra.nattable.configuration.PapyrusGridLayerConfiguration;

/**
 * This grid layer ovverride the default edition behavior
 * 
 * @author Vincent Lorenzo
 * 
 */
public class PapyrusGridLayer extends GridLayer {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param bodyLayer
	 * @param columnHeaderLayer
	 * @param rowHeaderLayer
	 * @param cornerLayer
	 */
	public PapyrusGridLayer(ILayer bodyLayer, ILayer columnHeaderLayer, ILayer rowHeaderLayer, ILayer cornerLayer) {
		super(bodyLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param bodyLayer
	 * @param columnHeaderLayer
	 * @param rowHeaderLayer
	 * @param cornerLayer
	 * @param useDefaultConfiguration
	 */
	public PapyrusGridLayer(ILayer bodyLayer, ILayer columnHeaderLayer, ILayer rowHeaderLayer, ILayer cornerLayer, boolean useDefaultConfiguration) {
		super(bodyLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer, useDefaultConfiguration);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param useDefaultConfiguration
	 */
	public PapyrusGridLayer(boolean useDefaultConfiguration) {
		super(useDefaultConfiguration);
	}

	@Override
	protected void init(boolean useDefaultConfiguration) {
		registerCommandHandlers();

		if(useDefaultConfiguration) {
			addConfiguration(new PapyrusGridLayerConfiguration(this));
		}
	}




}
