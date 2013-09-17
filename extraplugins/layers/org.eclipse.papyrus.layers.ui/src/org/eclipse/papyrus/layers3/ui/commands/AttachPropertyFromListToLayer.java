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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ListSelectionDialog;


/**
 * Attach a property to the selected Layer.
 * Property are proposed in a list.
 * 
 * @author cedric dumoulin
 *
 */
public class AttachPropertyFromListToLayer extends AbstractLayersCommand {

	/**
	 * Constructor.
	 *
	 */
	public AttachPropertyFromListToLayer() {
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
		
		try {
			// Get the layer and application
			LayersStackApplication application = lookupLayersStackApplicationChecked(context);
			AbstractLayer layer = (AbstractLayer)getSelections(context).get(0);

			// Get the list of available properties
			Property[] properties = application.getPropertyRegistry().getProperties().toArray(new Property[0]);

			IStructuredContentProvider contentProvider = new MyContentProvider();
			ILabelProvider labelProvider = new MyLabelProvider();

			ListSelectionDialog dialog = new ListSelectionDialog(Display.getCurrent().getActiveShell(), properties, contentProvider, labelProvider, "Select properties to attach");

			List<Property> initialSelection = layer.getAttachedProperties();
			dialog.setInitialSelections(initialSelection.toArray(new Property[initialSelection.size()]));

			if(dialog.open() != Window.OK) {
				return;
			} 

			// TODO: improve algorithm:
			// use only the two list (or arrays) of initialSelection and finalSelection
			// Walk the first, for each element, 
			// 		if the element is in the second list
			// 			remove element in both list (set list[i]=null)
			//   	else
			//			remove element from first list
			// At the end, 
			// initialCollection contains unsetted elements (with nulls)
			// finalSelection contains set elements (with nulls)
			// Walk each array/list, and skip nulls.
			
			
			
			// Process selected Properties
			Object[] res = dialog.getResult();
			// Create a list from the array. No better way ...
			// In the same time, create unchanged and set lists
			List<Property> finalSelection = new ArrayList<Property>(res.length);
			List<Property> unchangedProperties = new ArrayList<Property>(initialSelection.size());			
			List<Property> setProperties = new ArrayList<Property>(finalSelection.size());
	
			for( Object o : res ) {
				// Create a clone list of the result
				finalSelection.add((Property)o);
				// Create the unchanged and set list
				if( initialSelection.contains(o)) {
					unchangedProperties.add((Property)o);
				} 
				else {
					setProperties.add((Property)o);
				}
			}
			
			// We also need the unset list
			// Obtain it by removing unchanged from initialSelection
			List<Property> unsetProperties = new ArrayList<Property>(initialSelection);
			unsetProperties.removeAll(unchangedProperties);
			
			// Remove unset instances
			for( Property property : unsetProperties) {
				System.out.println("unset Property " + property.getName());
				layer.removePropertyInstance(property);
			}

			// add set instances
			for( Property property : setProperties) {
				System.out.println("set Property " + property.getName());
				layer.addPropertyInstance(property);
			}

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

	private class MyContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return (Property[])inputElement;
		}

		public void dispose() {
			
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}
		
	}

	private class MyLabelProvider extends LabelProvider {


		@Override
		public String getText(Object element) {
			return ((Property)element).getName();
		}
		
	}
}
