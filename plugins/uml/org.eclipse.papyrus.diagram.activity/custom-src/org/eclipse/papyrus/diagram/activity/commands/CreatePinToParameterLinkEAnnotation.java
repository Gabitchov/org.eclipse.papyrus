/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : [Activitydiagram] Papyrus should provide a way to manually resynchronize pins and parameters on Call Actions
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.commands;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.diagram.activity.helper.IPinToParameterLinkCommand;
import org.eclipse.papyrus.diagram.activity.helper.datastructure.LinkPinToParameter;
import org.eclipse.papyrus.umlutils.ui.command.CreateEAnnotationCommand;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Pin;

/**
 * Command to create or update the EAnnoation which store the link from a {@link Pin} to a {@link Parameter}
 * 
 * @author arthur daussy
 * 
 */
public class CreatePinToParameterLinkEAnnotation extends CreateEAnnotationCommand implements IPinToParameterLinkCommand {

	/**
	 * {@link Parameter}
	 */
	private Parameter parameter;

	/**
	 * {@link EAnnotation}
	 */
	protected EAnnotation eAnnotation;

	/**
	 * Pin which will old the {@link EAnnotation}
	 */
	protected EModelElement modelOwner;

	public CreatePinToParameterLinkEAnnotation(TransactionalEditingDomain domain, Pin object, Parameter parameter) {
		super(domain, object, PIN_TO_PARAMETER_LINK);
		this.parameter = parameter;
		this.modelOwner = object;
	}

	public CreatePinToParameterLinkEAnnotation(TransactionalEditingDomain domain, LinkPinToParameter link) {
		super(domain, link.getPin(), PIN_TO_PARAMETER_LINK);
		this.parameter = link.getParameter();
		this.modelOwner = link.getPin();
	}

	@Override
	protected EAnnotation createEAnnotation() {
		eAnnotation = super.createEAnnotation();
		return eAnnotation;
	}

	@Override
	protected void doExecute() {
		//try to get an old EAnnotation
		eAnnotation = modelOwner.getEAnnotation(PIN_TO_PARAMETER_LINK);
		if(eAnnotation == null) {
			super.doExecute();
		}
		EMap<String, String> details = eAnnotation.getDetails();
		if(details != null) {
			details.put(PIN_TO_PARAMETER_LINK, getXmiID(parameter));
		}
	}

	/**
	 * Get the XMI id to identify the parameter
	 * 
	 * @param p
	 *        {@link Parameter} to identify
	 * @return XMI id og the {@link Parameter}
	 */
	protected String getXmiID(Parameter p) {
		Resource ressource = p.eResource();
		if(ressource instanceof XMIResource) {
			return ((XMIResource)ressource).getID(p);
		}
		return NO_PARAMETER_ID;
	}

	@Override
	public boolean canExecute() {
		return super.canExecute() && modelOwner != null && parameter != null;
	}
}
