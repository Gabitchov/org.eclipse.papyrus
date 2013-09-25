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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EMap;
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
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;

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
		String result = problem.getType();
		return (result != null) ? result : EValidator.MARKER;
	}

	public String getTypeLabel() throws CoreException {
		String result = MarkerListenerUtils.getMarkerTypeLabel(getType());
		return ((result != null) && (result.length() > 0)) ? result : util.getProblemType(problem);
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
		} else if(problem.getAttributes().containsKey(name)) {
			result = coerce(problem.getAttributes().get(name));
		} else {
			throw new CoreException(error("No such marker attribute: " + name)); //$NON-NLS-1$
		}

		return result;
	}

	protected Object coerce(String value) {
		Object result;

		if(value == null) {
			result = value;
		} else if(isBoolean(value)) {
			result = Boolean.parseBoolean(value);
		} else if(isInteger(value)) {
			result = Integer.parseInt(value);
		} else {
			result = value;
		}

		return result;
	}

	static boolean isBoolean(String s) {
		return (s != null) && (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	static boolean isInteger(String s) {
		boolean result = (s != null) && (s.length() > 0);

		for(int i = 0; result && (i < s.length()); i++) {
			result = Character.isDigit(s.charAt(i));
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
		} else if(problem.getAttributes().containsKey(name)) {
			result = coerce(problem.getAttributes().get(name), defaultValue);
		} else {
			result = defaultValue;
		}

		return (result != null) ? result : defaultValue;
	}

	protected String coerce(String value, String defaultValue) {
		String result;

		if(value == null) {
			result = defaultValue;
		} else if(isBoolean(value) || isInteger(value)) {
			throw new IllegalArgumentException("Not a string value: " + value); //$NON-NLS-1$
		} else {
			result = value;
		}

		return result;
	}

	public boolean getAttribute(String name, boolean defaultValue) {
		boolean result;

		if(problem.getAttributes().containsKey(name)) {
			result = coerce(problem.getAttributes().get(name), defaultValue);
		} else {
			result = defaultValue;
		}

		return result;
	}

	protected boolean coerce(String value, boolean defaultValue) {
		boolean result;

		if(value == null) {
			result = defaultValue;
		} else if(!isBoolean(value)) {
			throw new IllegalArgumentException("Not a boolean value: " + value); //$NON-NLS-1$
		} else {
			result = Boolean.parseBoolean(value);
		}

		return result;
	}

	public int getAttribute(String name, int defaultValue) {
		int result;

		if(name.equals(SEVERITY)) {
			result = getMarkerSeverity();
		} else if(problem.getAttributes().containsKey(name)) {
			result = coerce(problem.getAttributes().get(name), defaultValue);
		} else {
			result = defaultValue;
		}

		return result;
	}

	protected int coerce(String value, int defaultValue) {
		int result;

		if(value == null) {
			result = defaultValue;
		} else if(!isInteger(value)) {
			throw new IllegalArgumentException("Not an integer value: " + value); //$NON-NLS-1$
		} else {
			result = Integer.parseInt(value);
		}

		return result;
	}

	public Map<String, ?> getAttributes() throws CoreException {
		Map<String, Object> result = coerce(problem.getAttributes());

		result.put(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(getEObject()).toString());
		result.put(SEVERITY, getMarkerSeverity());
		result.put(MESSAGE, problem.getMessage());

		return result;
	}

	protected Map<String, Object> coerce(EMap<String, String> attributes) {
		Map<String, Object> result = Maps.newHashMap();

		for(Map.Entry<String, String> next : attributes) {
			result.put(next.getKey(), coerce(next.getValue()));
		}

		return result;
	}

	public void setAttribute(String name, Object value) throws CoreException {
		if(name.equals(EValidator.URI_ATTRIBUTE)) {
			throw new CoreException(error("Cannot set URI of a CDOPapyrusMarker.")); //$NON-NLS-1$
		} else if(name.equals(SEVERITY)) {
			setMarkerSeverity(((Number)value).intValue());
		} else if(name.equals(MESSAGE)) {
			problem.setMessage((String)value);
		} else if(value == null) {
			problem.getAttributes().removeKey(name);
		} else {
			problem.getAttributes().put(name, value.toString());
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
		} else if(name.equals(SEVERITY)) {
			throw new CoreException(error("Severity of a CDOPapyrusMarker is not a string.")); //$NON-NLS-1$
		} else if(value == null) {
			problem.getAttributes().removeKey(name);
		} else {
			problem.getAttributes().put(name, value);
		}
	}

	public void setAttribute(String name, boolean value) throws CoreException {
		if(name.equals(EValidator.URI_ATTRIBUTE)) {
			throw new CoreException(error("URI of a CDOPapyrusMarker is not a boolean.")); //$NON-NLS-1$
		} else if(name.equals(SEVERITY)) {
			throw new CoreException(error("Severity of a CDOPapyrusMarker is not a boolean.")); //$NON-NLS-1$
		} else if(name.equals(MESSAGE)) {
			throw new CoreException(error("Message of a CDOPapyrusMarker is not a boolean.")); //$NON-NLS-1$
		} else {
			problem.getAttributes().put(name, Boolean.toString(value));
		}
	}

	public void setAttribute(String name, int value) throws CoreException {
		if(name.equals(SEVERITY)) {
			setMarkerSeverity(value);
		} else if(name.equals(EValidator.URI_ATTRIBUTE)) {
			throw new CoreException(error("URI of a CDOPapyrusMarker is not an integer.")); //$NON-NLS-1$
		} else if(name.equals(MESSAGE)) {
			throw new CoreException(error("Message of a CDOPapyrusMarker is not an integer.")); //$NON-NLS-1$
		} else {
			problem.getAttributes().put(name, Integer.toString(value));
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
			} else if(value != null) {
				problem.getAttributes().put(name, value.toString());
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
		return (type == null) || MarkerListenerUtils.isMarkerTypeSubtypeOf(getType(), type);
	}
}
