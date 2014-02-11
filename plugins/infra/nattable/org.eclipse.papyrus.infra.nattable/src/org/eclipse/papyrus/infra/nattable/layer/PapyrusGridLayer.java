/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.layer;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.command.ILayerCommandHandler;
import org.eclipse.nebula.widgets.nattable.edit.command.EditCellCommand;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.papyrus.infra.nattable.configuration.PapyrusGridLayerConfiguration;
import org.eclipse.papyrus.infra.nattable.handler.TransactionalEditCellCommandHandler;

/**
 * This grid layer ovverride the default edition behavior
 * 
 * @author Vincent Lorenzo
 * 
 */
public class PapyrusGridLayer extends GridLayer {

	private final TransactionalEditingDomain domain;
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param bodyLayer
	 * @param columnHeaderLayer
	 * @param rowHeaderLayer
	 * @param cornerLayer
	 */
	public PapyrusGridLayer(TransactionalEditingDomain domain, ILayer bodyLayer, ILayer columnHeaderLayer, ILayer rowHeaderLayer, ILayer cornerLayer) {
		super(bodyLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer);
		
		this.domain = domain;
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
	public PapyrusGridLayer(TransactionalEditingDomain domain, ILayer bodyLayer, ILayer columnHeaderLayer, ILayer rowHeaderLayer, ILayer cornerLayer, boolean useDefaultConfiguration) {
		super(bodyLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer, useDefaultConfiguration);
		
		this.domain = domain;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param useDefaultConfiguration
	 */
	public PapyrusGridLayer(TransactionalEditingDomain domain, boolean useDefaultConfiguration) {
		super(useDefaultConfiguration);
		
		this.domain = domain;
	}

	@Override
	protected void init(boolean useDefaultConfiguration) {
		registerCommandHandlers();

		if(useDefaultConfiguration) {
			addConfiguration(new PapyrusGridLayerConfiguration(this));
		}
	}

	@Override
	public void registerCommandHandler(ILayerCommandHandler<?> commandHandler) {
		// Override the default edit handler
		if(commandHandler.getCommandClass() == EditCellCommand.class) {
			commandHandler = new TransactionalEditCellCommandHandler(domain);
		}

		super.registerCommandHandler(commandHandler);
	}

}
