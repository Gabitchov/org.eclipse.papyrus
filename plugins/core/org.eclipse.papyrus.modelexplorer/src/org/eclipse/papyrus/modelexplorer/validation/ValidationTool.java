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

package org.eclipse.papyrus.modelexplorer.validation;

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
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.papyrus.core.utils.ValidationUtils;

public class ValidationTool {
	
	public ValidationTool (Object element) {
		this.element = element;
		eObject = (EObject) Platform.getAdapterManager().getAdapter(element, EObject.class);
	}	

	public ValidationTool (EObject eObject) {
		this.eObject = eObject;
	}	

	public void tryChildIfEmpty() {
		// element has no eObject. try parent
		if (eObject == null) {
			// TODO: is it possible to access the children in another way (without internal access?)
			if (element instanceof LinkItem) {
				List<Object> items = ((LinkItem) element).getChildrenElements();
				if (items.size() > 0) {
					// element = items[0];
					if(items.get(0) instanceof EObject) {
						eObject = (EObject)items.get(0);
					}
				}
			}
		}
	}

	public EObject getEObject () {
		return eObject;
	}
	
	public IMarker [] getMarkers () {
		if (eObject != null) { 
			if (eObject.eResource () != null) {
				URI uri = eObject.eResource().getURI();
				String platformResourceString = uri.toPlatformString(true);
				IFile file = (platformResourceString != null ?
				      ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourceString)) : null);
				if (file != null) {
					try {
						// TODO: quite inefficient, since requested for each element (could cache markers, already done
						// by findMarkers operation?)
						return file.findMarkers(IMarker.PROBLEM, true, 0);
					}
					catch (CoreException e) {
					}
				}
			}
		}
		return null;
	}
	
	public EObject eObjectOfMarker (IMarker marker) {
		if (eObject != null) {
			domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
			try {
				if (marker.isSubtypeOf((EValidator.MARKER))) {
					return ValidationUtils.eObjectFromMarkerOrMap (marker, null, domain);
				}
			}
			catch (CoreException e) {
				// only reason: marker does not exist
			}
		}
		return null;
	}
	
	/**
	 * Delete all markers that refer to eObjects owned by the passed parentEObj
	 * @param eObj
	 */
	public void deleteSubMarkers() {
		for (IMarker marker : getMarkers ()) {
			EObject eObjOfMarker = eObjectOfMarker (marker);
			if (isContainedBy (eObjOfMarker, eObject)) {
				try {
					marker.delete ();
				}
				catch (CoreException e) {
				}
			}
		}
	}
	
	private boolean isContainedBy (EObject subEObj, EObject eObj) {
		if (eObj == subEObj) return true;
		else if (subEObj != null) {
			return isContainedBy (subEObj.eContainer(), eObj);
		}
		// reached, if subEObj == null
		return false;
	}
	
	private Object element;
	private EObject eObject;
	private EditingDomain domain;
}
