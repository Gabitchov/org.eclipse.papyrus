/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.example.infra.servicesregistry.retrieval.menu.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * A menu handler showing :
 * <ul>
 *   <li>How to retrieve a UML element from any kind of selected object (using adapters)</li>
 *   <li>How to get the ServicesRegistry from an EObject</li>
 * </ul>
 * 
 * @author Cedric dumoulin 
 * 
 */
public class LookupServiceRegistryFromEObjectHandler extends AbstractHandler implements IHandler {


	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @param event
	 * @return
	 * @throws ExecutionException
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		List<EObject> selectedProperties = getAllSelectionAdaptedToType( event, EObject.class );
		if( selectedProperties == null) {
			
			showErrorDialog(event, "No object selected", "Please select a Property First.");	
			return null;
		}
		
		
		// Get the ServiceRegistry for each of the selected object
		List<ServicesRegistry> res = new ArrayList<ServicesRegistry>();
		for( EObject selected : selectedProperties) {
			
			// Get the servicesRegistry
			try {
				ServicesRegistry registry = ServiceUtilsForResource.getInstance().getServiceRegistry(selected.eResource());
				res.add(registry);
				System.out.println(" - " + selected + " [" + registry + "]");
			} catch (ServiceException e) {
				// Not found
				res.add(null);
				System.out.println(" - " + selected + " [Can't get ServicesRegistry !!!]");
			}
            // 
		
		}

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		

		showResults( window.getShell(), selectedProperties, res);
		
		return null;
	}

	/**
	 * Show results in popup.
	 * @param selectedProperties
	 * @param res
	 */
	private void showResults(Shell shell, List<EObject> selectedProperties, List<ServicesRegistry> res) {
		
		StringBuffer buff = new StringBuffer();

		Iterator<EObject> selectedIter = selectedProperties.iterator();
		Iterator<ServicesRegistry> registryIter = res.iterator();
		while(selectedIter.hasNext()) {
			EObject selected = selectedIter.next();
			ServicesRegistry registry = registryIter.next();
			
			buff.append("\n[ServicesRegistry]\n");
			if( registry != null )
			  buff.append(registry.toString());
			else
				buff.append("Registry not found !!!");
			buff.append( "\n[EOBject]\n");
			buff.append(selected.toString());
			buff.append("\n");
			
		}
		
		String message = buff.toString();
		MessageDialog.openInformation(shell, "ServicesRegistry found for selected objects:", message);
	}

	/**
	 * Get all selected element of the specified type.
	 * 
	 * @param expectedType
	 * @return
	 * @throws ExecutionException 
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> getAllSelectionAdaptedToType(ExecutionEvent event, Class<T> expectedType) throws ExecutionException {
		
		// Get selection from the workbench
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);

		// Get the selected objects according to the type of the selected
		if(selection instanceof IStructuredSelection)
		{
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return getAllElementAdaptedToType( structuredSelection.toList(), expectedType);
		}
		else if( selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection)selection;
			return getAllElementAdaptedToType( treeSelection.toList(), expectedType );

		}
		return null;
	}

	/**
	 * Filter the list, and only retain objects that can be adapted to the specified type
	 * @param objects
	 * @param class1
	 * @return
	 */
	private <T> List<T> getAllElementAdaptedToType(List<Object> list, Class<T> expectedClassType) {
		
		List<T> res = new ArrayList<T>();
		
		for( Object cur : list) {
			
			T adapted = adapt( cur, expectedClassType);
			if( adapted != null)
				res.add(adapted);
		}
		return res;
	}

	/**
	 * Adapt the specified object to the requested type, if possible.
	 * Return null if the object can't be adapted.
	 * 
	 * @param object
	 * @param expectedClassType
	 * @return The adapted object, or null.
	 */
	@SuppressWarnings("unchecked")
	private <T> T adapt( Object object, Class<T> expectedClassType) {
		
		if( object instanceof IAdaptable ) {
			T ele = (T)((IAdaptable)object).getAdapter(expectedClassType);
			if(ele != null) {
			  return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if( EObject.class.isAssignableFrom( expectedClassType) ) {
				// to EObject
				EObject eobject = (EObject)((IAdaptable)object).getAdapter(EObject.class);
				
				if(eobject != null && expectedClassType.isInstance(eobject)) {
				  return (T)eobject;
				}
			}
		}
			
		// Try global mechanism
		{
			T ele = (T)Platform.getAdapterManager().getAdapter(object, expectedClassType);
			if(ele != null) {
				return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if( EObject.class.isAssignableFrom( expectedClassType) ) {
				// to EObject
				EObject eobject = (EObject)Platform.getAdapterManager().getAdapter(object, EObject.class);
				
				if(eobject != null && expectedClassType.isInstance(eobject)) {
				 
				  return (T)eobject;
				}
			}
		}
		// Can't be adapted
		return null;

	}
	
	
	/**
	 * 
	 * @param event
	 * @param errorMessage
	 * @throws ExecutionException
	 */
	private void showErrorDialog(ExecutionEvent event, String title, String errorMessage) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openError(
				window.getShell(),
				title,
				errorMessage);
	}
	

	/**
	 * Get the name used in the {@link RecordingCommand}. This name will be visible in 
	 * undo/redo.
	 * 
	 * @return The command name to show.
	 */
	public String getCommandName() {
		return "Show ServiceRegistry";
	}



}
