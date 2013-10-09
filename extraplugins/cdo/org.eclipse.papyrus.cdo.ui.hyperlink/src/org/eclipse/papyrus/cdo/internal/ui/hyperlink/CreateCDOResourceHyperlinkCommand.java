/*****************************************************************************
 * Copyright (c) 2009, 2013 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - adapted for CDO repository resource hyperlinks
 *
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


/**
 * A command that creates hyperlinks in the model to resources in a CDO repository.
 */
public class CreateCDOResourceHyperlinkCommand extends CreateEAnnotationCommand {

	private final String tooltipText;

	private final URI resourceURI;

	private final boolean isDefault;

	/**
	 * Instantiates a new creates the hyper link command.
	 * 
	 * @param domain
	 *        the editing domain in which to create the command
	 * @param object
	 *        the object to which to attach the hyperlink
	 * @param tooltipText
	 *        the hyperlink's user-friendly tooltip text
	 * @param resourceURI
	 *        the URI of the resource that is the hyperlink target
	 * @param isDefault
	 *        to set this hyperlink as default
	 */
	public CreateCDOResourceHyperlinkCommand(TransactionalEditingDomain domain, EModelElement object, String tooltipText, URI resourceURI, boolean isDefault) {
		super(domain, object, CDOHyperlinkConstants.HYPERLINK_ANNOTATION_SOURCE);
		this.tooltipText = tooltipText;
		this.resourceURI = resourceURI;
		this.isDefault = isDefault;
	}

	@Override
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, tooltipText);
		eAnnotation.getDetails().put(CDOHyperlinkConstants.HYPERLINK_DETAIL_URI, resourceURI.toString());
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, Boolean.toString(isDefault));
		attachEannotation(eAnnotation, getObject());
	}

}
