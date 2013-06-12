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

import org.eclipse.nebula.widgets.nattable.copy.command.CopyDataCommandHandler;
import org.eclipse.nebula.widgets.nattable.copy.command.CopyDataToClipboardCommand;
import org.eclipse.nebula.widgets.nattable.layer.IUniqueIndexLayer;
import org.eclipse.nebula.widgets.nattable.selection.ISelectionModel;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;

/**
 * Papyrus selection layer
 * 
 * @author vl222926
 * 
 */
public class PapyrusSelectionLayer extends SelectionLayer {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param underlyingLayer
	 * @param useDefaultConfiguration
	 */
	public PapyrusSelectionLayer(IUniqueIndexLayer underlyingLayer, boolean useDefaultConfiguration) {
		super(underlyingLayer, useDefaultConfiguration);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param underlyingLayer
	 * @param selectionModel
	 * @param useDefaultConfiguration
	 * @param registerDefaultEventHandler
	 */
	public PapyrusSelectionLayer(IUniqueIndexLayer underlyingLayer, ISelectionModel selectionModel, boolean useDefaultConfiguration, boolean registerDefaultEventHandler) {
		super(underlyingLayer, selectionModel, useDefaultConfiguration, registerDefaultEventHandler);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param underlyingLayer
	 * @param selectionModel
	 * @param useDefaultConfiguration
	 */
	public PapyrusSelectionLayer(IUniqueIndexLayer underlyingLayer, ISelectionModel selectionModel, boolean useDefaultConfiguration) {
		super(underlyingLayer, selectionModel, useDefaultConfiguration);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param underlyingLayer
	 */
	public PapyrusSelectionLayer(IUniqueIndexLayer underlyingLayer) {
		super(underlyingLayer);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.selection.SelectionLayer#registerCommandHandlers()
	 * 
	 */
	protected void registerCommandHandlers() {
		super.registerCommandHandlers();
		unregisterCommandHandler(CopyDataToClipboardCommand.class);
		final CopyDataCommandHandler handler = new CopyDataCommandHandler(this);
		handler.setCopyFormattedText(true);
		registerCommandHandler(handler);
	}


}
