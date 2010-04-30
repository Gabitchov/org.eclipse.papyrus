/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.diagramprofile.Activator;
import org.eclipse.papyrus.resource.ResourceEObject;

public class ResourceEObjectParser implements ISemanticParser {

	private static final Pattern patternForBaseElement = Pattern.compile("base_.*");

	private final EStructuralFeature eStructuralFeature;
	
	private String oclRule = "";

	public ResourceEObjectParser(String oclRule, EStructuralFeature eStructuralFeature) {
		this.oclRule = oclRule;
		this.eStructuralFeature = eStructuralFeature;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getString(element);
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		ICommand result = null;
		if (element instanceof EObjectAdapter) {
			EObjectAdapter adapter = (EObjectAdapter) element;
			if (adapter.getRealObject() instanceof EObject) {
				Object runOcl = getEobjectFromOCLRUle(element);
				if (runOcl instanceof EObject) {
					EObject eobject = (EObject) runOcl;
					result = new SetValueCommand(new SetRequest(eobject, eStructuralFeature, newString));
				}
			}
		}
		return result;
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getString(element);
	}

	private Object getEobjectFromOCLRUle(IAdaptable element) {
		Object result = null;
		if (element instanceof EObjectAdapter) {
			EObjectAdapter adapter = (EObjectAdapter) element;
			if (adapter.getRealObject() instanceof ResourceEObject) {
				ResourceEObject rEobject = (ResourceEObject) adapter.getRealObject();
				result = org.eclipse.papyrus.diagramprofile.utils.OCLUtils.runOclRule(oclRule, rEobject);
			}
		}
		return result;
	}

	private String getString(IAdaptable element) {
		Object result = getEobjectFromOCLRUle(element);
		if (result != null && result instanceof EObject) {
			Object object = ((EObject) result).eGet(eStructuralFeature);
			return object == null ? "" : object.toString();
		}
		return "";
	}

	private EObject getBaseElement(ResourceEObject rEobject) {
		for (EStructuralFeature f : rEobject.eClass().getEAllStructuralFeatures()) {
			if (patternForBaseElement.matcher(f.getName()).matches()) {
				Object result = rEobject.eGet(f);
				if (result != null && result instanceof EObject) {
					return (EObject) result;
				}
			}
		}
		return null;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return getEStructuralFeature(event).equals(eStructuralFeature);
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		if (element instanceof EObjectAdapter) {
			EObjectAdapter eobjectAdapter = (EObjectAdapter) element;
			if (eobjectAdapter.getRealObject() instanceof ResourceEObject) {
				return new ParserEditStatus(Status.OK, Activator.PLUGIN_ID, ParserEditStatus.EDITABLE, "ok", null);
			}
		}
		return new ParserEditStatus(Status.ERROR, Activator.PLUGIN_ID, ParserEditStatus.EDITABLE, "error", null);
	}

	/**
	 * Get the EStructuralFeature of the given notification
	 * 
	 * @param notification
	 *            the notification
	 * @return the EStructuralFeature
	 */
	protected EStructuralFeature getEStructuralFeature(Object notification) {
		EStructuralFeature featureImpl = null;
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			if (feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature) feature;
			}
		}
		return featureImpl;
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		List result = new ArrayList();
		result.add(element);
		result.add(org.eclipse.papyrus.diagramprofile.utils.OCLUtils.runOclRule(oclRule, element));
		return result;
	}

}
