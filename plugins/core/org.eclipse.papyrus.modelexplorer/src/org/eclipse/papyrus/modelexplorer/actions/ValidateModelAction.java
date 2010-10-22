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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.ValidateAction;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element reprented
 * by the shape). Delegates to PasteShapeOrElementCommand
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class ValidateModelAction extends ValidateAction
{	
	public ValidateModelAction (EditingDomain domain) {
		super();
		this.domain = domain;
	}
	
	@Override
	protected void handleDiagnostic(Diagnostic diagnostic)
	{
	    // Do not show a dialog, as in the original version since the user sees the result directly
		Resource resource = eclipseResourcesUtil != null ? domain.getResourceSet().getResources().get(0) : null;
		if (resource != null) {
			// eclipseResourcesUtil.deleteMarkers(resource);
			// the following 4 lines are required due to the uml/di manipulation 
			IPath path = new Path(resource.getURI().toPlatformString (false).replace(".uml", ".di"));
			IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = wsRoot.getFile(path);
			eclipseResourcesUtil.deleteMarkers (file);
			
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				// eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
				createMarkersOnDi (file, childDiagnostic);
			}
		}
	}

	/**
	 * create resources on di instead of on UML file. Probably already obsolete, since we want to create these files
	 * on a UML resource.
	 * @param resource
	 * @param diagnostic
	 */
	private void createMarkersOnDi (IFile file, Diagnostic diagnostic)
	{
		try {
			if (!diagnostic.getData().isEmpty()) {
				Object object = diagnostic.getData().get(0);
			
				if (object instanceof EObject) {
					if (file != null && file.exists()) {
						IMarker marker = file.createMarker(EValidator.MARKER);
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
}
