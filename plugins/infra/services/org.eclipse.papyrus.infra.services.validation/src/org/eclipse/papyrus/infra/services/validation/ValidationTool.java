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

package org.eclipse.papyrus.infra.services.validation;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;

@SuppressWarnings("restriction")
public class ValidationTool {

	/** Current element */
	private Object element;

	/** current eobject */
	private EObject eObject;

	/** current editing domain */
	private EditingDomain domain;

	protected Resource resource;

	/**
	 * Constructor:
	 * create a new instance of the validation tool for a specific model element
	 * 
	 * @param eObject
	 *        a model element
	 */
	public ValidationTool(EObject eObject) {
		this.resource = ValidationUtils.getValidationResource(eObject);
		setEObject(eObject);
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

	public IMarker[] getMarkers() {
		if(getEObject() != null) {
			if(getEObject().eResource() != null) {
				URI uri = resource.getURI();
				String platformResourceString = uri.toPlatformString(true);
				IFile file = (platformResourceString != null ?
					ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourceString)) : null);
				if(file != null) {
					try {
						// TODO: quite inefficient, since requested for each element (could cache markers, already done
						// by findMarkers operation?)
						return file.findMarkers(IMarker.PROBLEM, true, 0);
					} catch (CoreException e) {
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param marker
	 * @return
	 */
	public EObject eObjectOfMarker(IMarker marker) {
		if(getEObject() != null) {
			domain = AdapterFactoryEditingDomain.getEditingDomainFor(getEObject());
			try {
				if(marker.isSubtypeOf((EValidator.MARKER)) /* || marker.isSubtypeOf(MarkerConstants.modelrefMarkerID) */) {
					return ValidationUtils.eObjectFromMarkerOrMap(marker, null, domain);
				}
			} catch (CoreException e) {
				// only reason: marker does not exist
			}
		}
		return null;
	}

	/**
	 * Delete all markers that refer to eObjects owned by the passed parentEObj
	 */
	public void deleteSubMarkers() {
		for(IMarker marker : getMarkers()) {
			EObject eObjOfMarker = eObjectOfMarker(marker);
			if(isContainedBy(eObjOfMarker, getEObject())) {
				try {
					marker.delete();
				} catch (CoreException e) {
				}
			}
		}
	}

	private boolean isContainedBy(EObject subEObj, EObject eObj) {
		if(eObj == subEObj)
			return true;
		else if(subEObj != null) {
			return isContainedBy(subEObj.eContainer(), eObj);
		}
		// reached, if subEObj == null
		return false;
	}
}
