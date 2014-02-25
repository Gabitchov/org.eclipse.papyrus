/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.decoration;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * An IPapyrusMarker for GMF Shapes, which is activated when the graphical container is different
 * from the semantic container (i.e. highlight external references / imported elements)
 * 
 * This marker is volatile (created/deleted by EditPolicies on EditParts). It cannot be removed directly by the user
 *
 * @author Camille Letavernier
 *
 * @see {@link org.eclipse.papyrus.infra.gmfdiag.common.decoration.ExternalReferenceDecoration}
 * @see {@link org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.ExternalReferenceEditPolicy}
 */
public class ExternalReferenceMarker implements IPapyrusMarker {

	public static final String MARKER_TYPE = "org.eclipse.papyrus.infra.gmfdiag.common.externalref"; //$NON-NLS-1$

	protected View notationElement;

	public ExternalReferenceMarker(View notationElement) {
		this.notationElement = notationElement;
	}

	@Override
	public Resource getResource() {
		return notationElement.eResource();
	}

	@Override
	public EObject getEObject() {
		return notationElement;
	}

	@Override
	public boolean exists() {
		return NotationHelper.isExternalRef(notationElement);
	}

	@Override
	public String getType() throws CoreException {
		return MARKER_TYPE;
	}

	@Override
	public String getTypeLabel() throws CoreException {
		return "External reference";
	}

	@Override
	public void delete() throws CoreException {
		//Do nothing: the user cannot manually remove the marker
	}


	///
	//The marker doesn't have any attribute: default implementation does nothing
	///

	@Override
	public Object getAttribute(String name) throws CoreException {
		return null;
	}

	@Override
	public String getAttribute(String name, String defaultValue) {
		return defaultValue;
	}

	@Override
	public boolean getAttribute(String name, boolean defaultValue) {
		return defaultValue;
	}

	@Override
	public int getAttribute(String name, int defaultValue) {
		return defaultValue;
	}

	@Override
	public Map<String, ?> getAttributes() throws CoreException {
		return Collections.emptyMap();
	}

	@Override
	public boolean isSubtypeOf(String type) throws CoreException {
		return false;
	}

	@Override
	public void setAttribute(String name, Object value) throws CoreException {
		//Nothing
	}

	@Override
	public void setAttribute(String name, String value) throws CoreException {
		//Nothing
	}

	@Override
	public void setAttribute(String name, boolean value) throws CoreException {
		//Nothing
	}

	@Override
	public void setAttribute(String name, int value) throws CoreException {
		//Nothing
	}

	@Override
	public void setAttributes(Map<String, ?> attributes) throws CoreException {
		//Nothing
	}

}
