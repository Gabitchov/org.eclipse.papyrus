/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerProvider;
import org.eclipse.papyrus.infra.services.markerlistener.providers.WorkspaceMarkerProvider;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;

@SuppressWarnings("restriction")
public class ValidationTool {

	/** Current element */
	private Object element;

	/** current eobject */
	private EObject eObject;

	protected Resource resource;
	
	protected IMarkerProvider provider;

	/**
	 * show progress all n marker deletions
	 */
	public static int DELETE_PMARKER_RATIO = 50;

	/**
	 * show progress all n marker creations
	 */
	public static int CREATE_PMARKER_RATIO = 20;

	/**
	 * Constructor:
	 * create a new instance of the validation tool for a specific model element
	 * 
	 * @param eObject
	 *        a model element
	 */
	public ValidationTool(EObject eObject) {
		this(eObject, ValidationUtils.getValidationResource(eObject));
	}

	/**
	 * Constructor:
	 * create a new instance of the validation tool for a specific model element
	 * 
	 * @param eObject
	 *        a model element
	 * @param resource
	 *        the resource for which we look for markers.
	 */
	public ValidationTool(EObject eObject, Resource resource) {
		this.resource = resource;
		setEObject(eObject);
		
		this.provider = (resource == null)
			? IMarkerProvider.NULL
			: MarkerListenerUtils.getMarkerProvider(resource);
	}

	public void tryChildIfEmpty() {
		// element has no eObject. try parent
		if(getEObject() == null) {
			// TODO: is it possible to access the children in another way (without internal access?)
			if(element instanceof LinkItem) {
				List<?> items = ((LinkItem)element).getChildrenElements();
				if(items.size() > 0 && items.get(0) instanceof EObject) {
					// element = items[0];
					setEObject((EObject)items.get(0));
				}
			}
		}
	}

	/**
	 * Returns the current EObject
	 * 
	 * @return the current EObject
	 */
	public EObject getEObject() {
		return eObject;
	}


	/**
	 * sets the current EObject
	 * 
	 * eObject the current EObject
	 */
	public void setEObject(EObject eObject) {
		this.eObject = eObject;
	}

	public Collection<? extends IPapyrusMarker> getMarkers() {
		try {
			// TODO: quite inefficient, since requested for each element (could cache markers, already done
			// by findMarkers operation?)
			return provider.getMarkers(resource, null, true);
		} catch (CoreException e) {
		}
		
		return Collections.emptyList();
	}

	/**
	 * Delete all markers that refer to eObjects owned by the parentEObj (passed in the constructor)
	 * 
	 * Convenience function for code that does not use a progress monitor
	 */
	public void deleteSubMarkers() {
		deleteSubMarkers(new NullProgressMonitor());
	}
	
	/**
	 * Delete all markers that refer to eObjects owned by the parentEObj (passed in the constructor)
	 * @param monitor A progress monitor
	 */
	public void deleteSubMarkers(IProgressMonitor monitor) {
		try {
			provider.deleteMarkers(getEObject(), monitor);
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
		}
	}
	
	public IRunnableWithProgress wrap(IRunnableWithProgress runnableWithProgress) {
		IRunnableWithProgress result = runnableWithProgress;

		if (isWorkspaceResource() && (MarkerListenerUtils.eclipseResourcesUtil != null)) {
			result = MarkerListenerUtils.eclipseResourcesUtil
				.getWorkspaceModifyOperation(result);
		}

		return result;
	}
	
	protected boolean isWorkspaceResource() {
		return provider instanceof WorkspaceMarkerProvider;
	}
	
	public void createMarkers(Diagnostic diagnostic, IProgressMonitor monitor) {
		try {
			provider.createMarkers(resource, diagnostic, monitor);
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
		}
	}
}
