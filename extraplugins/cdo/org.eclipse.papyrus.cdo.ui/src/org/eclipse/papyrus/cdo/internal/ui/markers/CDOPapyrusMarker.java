/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.markers;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.edit.ProblemEditUtil;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsManager;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;

/**
 * This is the CDOPapyrusMarker type. Enjoy.
 */
public class CDOPapyrusMarker implements IPapyrusMarker {

	private final ProblemEditUtil util;

	private final Resource resource;

	private final EProblem problem;

	CDOPapyrusMarker(EProblem problem, ProblemEditUtil util) {
		super();

		this.util = util;
		this.resource = problem.getElement().eResource();
		this.problem = problem;
	}

	public static Function<EProblem, CDOPapyrusMarker> wrap(final ProblemEditUtil util) {

		return new Function<EProblem, CDOPapyrusMarker>() {

			public CDOPapyrusMarker apply(EProblem input) {
				return new CDOPapyrusMarker(input, util);
			}
		};
	}

	public Resource getResource() {
		return resource;
	}

	public EObject getEObject() {
		return problem.getElement();
	}

	public boolean exists() {
		EObject element = getEObject();
		return (element != null) && (element.eResource() != null);
	}

	public String getType() {
		return EValidator.MARKER;
	}

	public String getTypeLabel() throws CoreException {

		return util.getProblemType(problem);
	}

	public void delete() {
		ProblemsManager.delete(problem);
	}

	public Object getAttribute(String name) throws CoreException {

		Object result = null;

		if(name.equals(EValidator.URI_ATTRIBUTE)) {
			result = EcoreUtil.getURI(getEObject()).toString();
		} else if(name.equals(SEVERITY)) {
			result = getMarkerSeverity();
		} else if(name.equals(MESSAGE)) {
			result = problem.getMessage();
		} else {
			throw new CoreException(error("No such marker attribute: " + name)); //$NON-NLS-1$
		}

		return result;
	}

	protected final IStatus error(String message) {
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message);
	}

	protected int getMarkerSeverity() {
		int result;

		switch(problem.getSeverity()) {
		case OK:
		case INFO:
			result = SEVERITY_INFO;
			break;
		case WARNING:
			result = SEVERITY_WARNING;
			break;
		default:
			result = SEVERITY_ERROR;
			break;
		}

		return result;
	}

	public String getAttribute(String name, String defaultValue) {
		String result = null;

		if(name.equals(EValidator.URI_ATTRIBUTE)) {
			result = EcoreUtil.getURI(getEObject()).toString();
		} else if(name.equals(MESSAGE)) {
			result = problem.getMessage();
		} else {
			result = defaultValue;
		}

		return (result != null) ? result : defaultValue;
	}

	public boolean getAttribute(String name, boolean defaultValue) {
		// we don't have any boolean attributes, yet
		return defaultValue;
	}

	public int getAttribute(String name, int defaultValue) {
		int result;

		if(name.equals(SEVERITY)) {
			result = getMarkerSeverity();
		} else {
			result = defaultValue;
		}

		return result;
	}

	public Map<String, ?> getAttributes() throws CoreException {

		Map<String, Object> result = Maps.newHashMap();

		result.put(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(getEObject()).toString());
		result.put(SEVERITY, getMarkerSeverity());
		result.put(MESSAGE, problem.getMessage());

		return result;

	}

	public void setAttribute(String name, Object value) throws CoreException {

		if(name.equals(EValidator.URI_ATTRIBUTE)) {
			throw new CoreException(error("Cannot set URI of a CDOPapyrusMarker.")); //$NON-NLS-1$
		} else if(name.equals(SEVERITY)) {
			setMarkerSeverity(((Number)value).intValue());
		} else if(name.equals(MESSAGE)) {
			problem.setMessage((String)value);
		} else {
			throw new CoreException(error("No such marker attribute: " + name)); //$NON-NLS-1$
		}
	}

	protected void setMarkerSeverity(int severity) throws CoreException {
		switch(severity) {
		case SEVERITY_INFO:
			problem.setSeverity(ESeverity.INFO);
			break;
		case SEVERITY_WARNING:
			problem.setSeverity(ESeverity.WARNING);
			break;
		case SEVERITY_ERROR:
			problem.setSeverity(ESeverity.ERROR);
			break;
		default:
			throw new CoreException(error("Invalid marker severity: " //$NON-NLS-1$
				+ severity));
		}
	}

	public void setAttribute(String name, String value) throws CoreException {

		if(name.equals(EValidator.URI_ATTRIBUTE)) {
			throw new CoreException(error("Cannot set URI of a CDOPapyrusMarker.")); //$NON-NLS-1$
		} else if(name.equals(MESSAGE)) {
			problem.setMessage(value);
		} else {
			throw new CoreException(error("No such marker attribute: " + name)); //$NON-NLS-1$
		}
	}

	public void setAttribute(String name, boolean value) throws CoreException {

		throw new CoreException(error("No such marker attribute: " + name)); //$NON-NLS-1$
	}

	public void setAttribute(String name, int value) throws CoreException {

		if(name.equals(SEVERITY)) {
			setMarkerSeverity(value);
		} else {
			throw new CoreException(error("No such marker attribute: " + name)); //$NON-NLS-1$
		}
	}

	public void setAttributes(Map<String, ?> attributes) throws CoreException {

		for(Map.Entry<String, ?> next : attributes.entrySet()) {
			String name = next.getKey();
			Object value = next.getValue();

			if(name.equals(EValidator.URI_ATTRIBUTE)) {
				throw new CoreException(error("Cannot set URI of a CDOPapyrusMarker.")); //$NON-NLS-1$
			} else if(name.equals(SEVERITY)) {
				setMarkerSeverity(((Number)value).intValue());
			} else if(name.equals(MESSAGE)) {
				problem.setMessage((String)value);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CDOPapyrusMarker) && Objects.equal(((CDOPapyrusMarker)obj).problem, problem);
	}

	@Override
	public int hashCode() {
		return (problem == null) ? 0 : problem.hashCode();
	}

	@Override
	public String toString() {
		return String.format("CDOPapyrusMarker:%s:%s", getResource(), hashCode()); //$NON-NLS-1$
	}

	public boolean isSubtypeOf(String type) throws CoreException {
		// FIXME 404441: [CDO] Implement "marker type" hierarchy in CDO markers https://bugs.eclipse.org/bugs/show_bug.cgi?id=404441
		if(type == null || IMarker.PROBLEM.equals(type))
			return true;
		return false;
	}
}
