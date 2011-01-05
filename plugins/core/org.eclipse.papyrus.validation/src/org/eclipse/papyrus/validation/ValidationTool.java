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

package org.eclipse.papyrus.validation;

import java.util.List;

import org.apache.commons.lang.WordUtils;
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
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;

public class ValidationTool {

	/** Current element */
	private Object element;

	/** current eobject */
	private EObject eObject;

	/** current editing domain */
	private EditingDomain domain;


	/**
	 * Constructor:
	 * create a new instance of the validation tool for a specific model element
	 *
	 * @param element a model element
	 */
	public ValidationTool (Object element) {
		this.element = element;
		setEObject((EObject)Platform.getAdapterManager().getAdapter(element, EObject.class));
	}	

	/**
	 * Constructor:
	 * create a new instance of the validation tool for a specific model element
	 * 
	 * @param eObject
	 *        a model element
	 */
	public ValidationTool (EObject eObject) {
		setEObject(eObject);
	}	


	public void tryChildIfEmpty() {
		// element has no eObject. try parent
		if(getEObject() == null) {
			// TODO: is it possible to access the children in another way (without internal access?)
			if (element instanceof LinkItem) {
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

	public IMarker [] getMarkers () {
		if(getEObject() != null) {
			if(getEObject().eResource() != null) {
				URI uri = getEObject().eResource().getURI();
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
	
	/**
	 * 
	 * @param marker
	 * @return
	 */
	public EObject eObjectOfMarker (IMarker marker) {
		if(getEObject() != null) {
			domain = AdapterFactoryEditingDomain.getEditingDomainFor(getEObject());
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
	 */
	public void deleteSubMarkers() {
		for (IMarker marker : getMarkers ()) {
			EObject eObjOfMarker = eObjectOfMarker (marker);
			if(isContainedBy(eObjOfMarker, getEObject())) {
				try {
					marker.delete ();
				}
				catch (CoreException e) {
				}
			}
		}
	}
	
	/**
	 * @return the maximum severity of markers associated with the model element
	 * (constructor parameter of validation tool)
	 */
	public int getSeverity() {
		IMarker markers[] = getMarkers();
		int severity = 0;
		if (markers != null) {
			for (IMarker marker : markers) {
				EObject eObjectOfMarker = eObjectOfMarker(marker);
				while (eObjectOfMarker != null) {
					if (eObjectOfMarker == getEObject()) {
						try {
							Integer severityI = (Integer) marker.getAttribute(IMarker.SEVERITY);
							if (severityI.intValue () > severity) {
								severity = severityI.intValue();
							}
						}
						catch (CoreException e) {
						}
					}
					// navigate to parents, since parent folder is contaminated as well
					eObjectOfMarker = eObjectOfMarker.eContainer();
				}
			}
		}
		return severity;
	}
	
	/**
	 * @return A set of messages associated with the markers for the model element
	 * (constructor parameter of validation tool)
	 */
	public String getMarkerMessages() {
		IMarker markers[] = getMarkers();
		if (markers != null) {
			boolean examineChilds = true;
			String message = "";
			for (IMarker marker : markers) {
				EObject eObjectOfMarker = eObjectOfMarker(marker);
				if (eObjectOfMarker == getEObject()) {
					if (message.length() > 0) {
						message += "\n";
					}
					// vt.getWrappedMessage (marker);
					try {
						message += "- " + WordUtils.wrap ((String) marker.getAttribute(IMarker.MESSAGE), 100, "\n  ", true);
					}
					catch (CoreException e) {
					}
				}
				if (examineChilds && (eObjectOfMarker != null)) {
					eObjectOfMarker = eObjectOfMarker.eContainer();
					while (eObjectOfMarker != null) {
						if (eObjectOfMarker == getEObject ()) {
							if (message.length() > 0) {
								message += "\n";
							}
							message += "- Problem marker in (at least) one of the children";
							examineChilds = false;
							break;
						}
						// navigate to parents, since parent folder is contaminated as well
						eObjectOfMarker = eObjectOfMarker.eContainer();
					}
				}
			}
			return (message.length() > 0) ? message : null; 
		}
		return null;
	}
	
	private boolean isContainedBy (EObject subEObj, EObject eObj) {
		if (eObj == subEObj) return true;
		else if (subEObj != null) {
			return isContainedBy (subEObj.eContainer(), eObj);
		}
		// reached, if subEObj == null
		return false;
	}
	
}
