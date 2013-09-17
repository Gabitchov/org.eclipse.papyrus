/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.swt.widgets.Display;


/**
 * Attach a property to the selected Layer
 * 
 * @author cedric dumoulin
 *
 */
public class AttachPropertyToLayer extends AbstractLayersCommand {

	/**
	 * Constructor.
	 *
	 */
	public AttachPropertyToLayer() {
	}

	/**
	 * @see org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Attach a property";
	}

	/**
	 * @see org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand#doExecute(org.eclipse.core.commands.ExecutionEvent, org.eclipse.core.expressions.IEvaluationContext, java.util.List)
	 *
	 * @param event
	 * @param context
	 * @param selections
	 */
	@Override
	protected void doExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) {
		// check enable
		if( ! isEnabled(context, selections)) {
			return;
		}

		// Open the dialog to ask the new name
		// TODO dialog should not be in the transaction !! put it outside !
		String currentName = "";
		String newName = null;
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Attach a Property to Layer", "Enter the name of an existing property", currentName, null);
		if(dialog.open() == Window.OK) {
			newName = dialog.getValue();
			if(newName == null || newName.length() <= 0) {
				return;
			}
		} else {
			// cancelled
			return;
		}

		try {
			LayersStackApplication application = lookupLayersStackApplicationChecked(context);
			Property property = application.getPropertyRegistry().getProperty(newName);
			// Get the layer
			AbstractLayer layer = (AbstractLayer)getSelections(context).get(0);
			layer.addPropertyInstance(property);
		} catch (LayersException e) {
			// silently fails
			e.printStackTrace();
		} catch (org.eclipse.papyrus.infra.core.resource.NotFoundException e) {
			// silently fails
			e.printStackTrace();
		} catch (ServiceException e) {
			// silently fails
			e.printStackTrace();
		}
		

	}

	/**
	 * Return true if it is possible to attach a property.
	 */
	@Override
	public boolean isEnabled(IEvaluationContext context, List<Object> selections) {

		return selectionFirstElementInstanceOf(selections, AbstractLayer.class);
	}

	
}
