/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.commands;

import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;


/**
 * Create a layer stack to a diagram.
 * This is performed on the current LayerStack Viewer.
 * 
 * @author cedric dumoulin
 * 
 */
public class CreateRegExpLayerHandler extends 
AbstractCreateLayerExpressionHandler implements IHandler {


	/**
	 * @see org.eclipse.papyrus.layers2.ui.view.commands.AbstractLayerCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Create RegExp Layer";
	}
	

	/**
	 * @return
	 */
	@Override
	protected LayerExpression createLayer() {
		RegExpLayer layer = LayersFactory.eINSTANCE.createRegExpLayer();
		return layer;
	}

}
