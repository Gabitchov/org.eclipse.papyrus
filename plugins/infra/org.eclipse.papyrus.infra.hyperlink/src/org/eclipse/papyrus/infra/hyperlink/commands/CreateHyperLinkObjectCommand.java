/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.commands;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


public class CreateHyperLinkObjectCommand extends CreateEAnnotationCommand {

	public String tooltiptext;

	public String name;

	private EObject targetElement;

	protected boolean isDefaultNavigation;


	public CreateHyperLinkObjectCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String name, EObject targetElement, boolean isDefaultNavigation) {
		super(domain, object, HyperLinkConstants.PAPYRUS_HYPERLINK_SPECIFIC_ELEMENT);
		this.tooltiptext = tooltiptext;
		this.name = name;
		this.targetElement = targetElement;
		this.isDefaultNavigation = isDefaultNavigation;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getReferences().add(targetElement);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, this.tooltiptext);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_PAGE_NAME, this.name);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, Boolean.toString(this.isDefaultNavigation));
		attachEannotation(eAnnotation, getObject());
	}

}
