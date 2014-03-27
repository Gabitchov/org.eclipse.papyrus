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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.layers.notationmodel.edit.NotationItemProviderAdapterFactory;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

import static org.eclipse.papyrus.layers.ui.Activator.log;


/**
 * Handler used to select multiples views to attach to the selected Layer.
 * Property are proposed in a selectable tree dialog.
 * 
 * @author cedric dumoulin
 *
 */
public class AttachDiagramViewsToLayer extends AbstractLayersCommand {

	/**
	 * Constructor.
	 *
	 */
	public AttachDiagramViewsToLayer() {
	}

	/**
	 * @see org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Attach multiple views";
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
			@SuppressWarnings("unused")
			LayersStackApplication application = lookupLayersStackApplicationChecked(context);
			AbstractLayer layer = (AbstractLayer)getSelections(context).get(0);

			// Get the diagram and the views
			Diagram diagram = layer.getOwningLayersStack().getDiagram();
			

			// Label and content providers

			AdapterFactory domainAdapterFactory = new UMLItemProviderAdapterFactory();
			AdapterFactory adapterFactory = new NotationItemProviderAdapterFactory(domainAdapterFactory);
			ITreeContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory);
			ILabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

			// Test of SpecificViewContentProvider that do exatly the same filtering
//			final Diagram diag2 = diagram;
//			ILabelProvider labelProvider = ServiceUtilsForIEvaluationContext.getInstance().getService(LabelProviderService.class, context).getLabelProvider();
//			ITreeContentProvider  contentProvider  = new SpecificViewContentProvider() {
//				@Override
//				public Object[] getElements(Object inputElement) {
//					// TODO Auto-generated method stub
//					return new EObject[]{ diag2};
//				}
//			};

			
			CheckedTreeSelectionDialog dialog = new CheckedTreeSelectionDialog(Display.getCurrent().getActiveShell(), labelProvider, contentProvider);

			dialog.setTitle("Diagram Views Selection");
			dialog.setMessage("Select Views to attach to the current layer:");
			dialog.setInput(diagram);
			List<View> initialSelection = layer.getViews();
			dialog.setInitialSelections(initialSelection.toArray(new View[0]));

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
			List<View> finalSelection = new ArrayList<View>(res.length);
			List<View> unchangedProperties = new ArrayList<View>(initialSelection.size());			
			List<View> setProperties = new ArrayList<View>(finalSelection.size());
	
			for( Object o : res ) {
				// Create a clone list of the result
				finalSelection.add((View)o);
				// Create the unchanged and set list
				if( initialSelection.contains(o)) {
					unchangedProperties.add((View)o);
				} 
				else {
					setProperties.add((View)o);
				}
			}
			
			// We also need the unset list
			// Obtain it by removing unchanged from initialSelection
			List<View> unsetProperties = new ArrayList<View>(initialSelection);
			unsetProperties.removeAll(unchangedProperties);
			
			// Remove unset views
			for( View property : unsetProperties) {
				if(log.isDebugEnabled()) {
					log.debug("unset view " + property.getElement());
				}
				layer.getViews().remove(property);
			}

			// add set instances
			for( View property : setProperties) {
				if(log.isDebugEnabled()) {
					log.debug("set Property " + property.getElement());
				}
				layer.getViews().add(property);
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

}
