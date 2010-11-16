/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.actions;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.modelexplorer.validation.ValidationTool;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element represented
 * by the shape). Delegates to PasteShapeOrElementCommand
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class ValidateModelAction extends ValidateAction implements IActionDelegate
{	
	public ValidateModelAction () {
		super();
		// this.domain = domain;
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled()
    {
    	// updateSelectedEObject ();
        // EObject selectedObj = getSelectedEObject ();
    	return true;
    }
    
    /**
     * {@inheritDoc}
     */
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
    	// return super.execute (event);
    	return null;
    }
    
	@Override
	protected void handleDiagnostic(Diagnostic diagnostic)
	{
	    // Do not show a dialog, as in the original version since the user sees the result directly
		// in the model explorer
		Resource resource = getResource();
		if (resource != null) {
			if (selectedObjects.size () > 0) {
				EObject selectedObject = selectedObjects.get(0);
			
				ValidationTool vt = new ValidationTool(selectedObject);
				vt.deleteSubMarkers();
			}
			
			// IPath path = new Path(resource.getURI().toPlatformString (false));
			// IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
			// IFile file = wsRoot.getFile(path);
			// eclipseResourcesUtil.deleteMarkers (file);

			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
				// createMarkersOnDi (file, childDiagnostic);
			}
		}
	}

	private Resource getResource() {
		Resource resource = eclipseResourcesUtil != null ? domain.getResourceSet().getResources().get(0) : null;
		return resource;
	}
	
	/**
	 * create resources on di instead of on UML file. Probably already obsolete, since we want to create the markers
	 * on a UML resource.
	 * @param resource
	 * @param diagnostic
	 */
	@Deprecated
	private void createMarkersOnDi (IFile file, Diagnostic diagnostic)
	{
		try {
			if (!diagnostic.getData().isEmpty()) {
				Object object = diagnostic.getData().get(0);
			
				if (object instanceof EObject) {
					if (file != null && file.exists()) {
						IMarker marker = file.createMarker(EValidator.MARKER);
						// TODO: define useful constant
						// marker.setAttribute(IDE.EDITOR_ID_ATTR, "org.eclipse.papyrus.core.papyrusEditor");
						int severity = diagnostic.getSeverity();
						if (severity < Diagnostic.WARNING) {
							marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
						}
						else if (severity < Diagnostic.ERROR) {
							marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						}
						else {
							marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
						}
						String message = diagnostic.getMessage ();
						marker.setAttribute(IMarker.MESSAGE, message);
						String uriOfMarkedObj = EcoreUtil.getURI((EObject) object).toString();
						// this URI is used by the UML model editor to jump to the right place
						marker.setAttribute(EValidator.URI_ATTRIBUTE, uriOfMarkedObj);
						
						String name;
						if (object instanceof ENamedElement) {
							name = ((ENamedElement) object).getName();
						}
						else if (object instanceof EObject) {
							name = EcoreUtil.getIdentification((EObject) object);
						}
						else {
							name = "unknown";
						}
						marker.setAttribute (IMarker.LOCATION, name);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(IAction action) {
		// TODO Auto-generated method stub
		String id = action.getId();
		if (selectedObjects.size () > 0) {
			EObject selectedObject = selectedObjects.get(0);
			domain = TransactionUtil.getEditingDomain(selectedObject);
			if (id.endsWith ("Model")) {
				// replace selection by model instead of current selection
				while (selectedObject.eContainer() != null) {
					selectedObject = selectedObject.eContainer ();
				}
				selectedObjects.set(0, selectedObject);
			}
			if (id.endsWith("ValidateSubTree") || id.endsWith("ValidateModel")) {
				run();			
			}
			else if (id.endsWith ("DeleteMarkersSubTree")) {
				ValidationTool vt = new ValidationTool(selectedObject);
				vt.deleteSubMarkers();
			}
			else if (id.endsWith("DeleteMarkersModel")) {
				Resource resource = getResource();
				if ((resource != null) && (eclipseResourcesUtil != null)) {
					eclipseResourcesUtil.deleteMarkers(getResource());
				}
			}
		}
	}

	/**
	 * Convert each selected elements from the explorer menu, or modeling view
	 * to an EObject and add it to a list
	 * 
	 * @return list of EObject
	 */
	public void updateSelectedEObject()
	{
		Vector<EObject> currentSelectedEObjects = new Vector<EObject>();

		// Retrieve selected elements
		IStructuredSelection selection = (IStructuredSelection) PlatformUI
				.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection();
		Iterator<?> eltIt = (Iterator<?>) selection.iterator();

		while (eltIt.hasNext()) {
			Object currentObject = eltIt.next();

			// If the object is an edit part, try to get semantic bridge
			if (currentObject instanceof GraphicalEditPart) {
				GraphicalEditPart editPart = (GraphicalEditPart) currentObject;
				if (editPart.getModel () instanceof View) {
					View view = (View) editPart.getModel (); 
					if (view.getElement() instanceof EObject){
						currentObject = (EObject) view.getElement();
					}
				}
			}

			// check whether part of model explorer
			if (currentObject instanceof IAdaptable) {
				// modisco ModelElementItem supports IAdaptable (cleaner than cast / dependency with modisco)
				currentObject = ((IAdaptable) currentObject).getAdapter (EObject.class);
			}

			// If element is a UML Element
			if (currentObject instanceof EObject) {
				currentSelectedEObjects.add((EObject) currentObject);
			}
	
		}
		selectedObjects = currentSelectedEObjects;
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		// method from action-delegate		
		updateSelectedEObject (); 	// required??
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
	}
}
