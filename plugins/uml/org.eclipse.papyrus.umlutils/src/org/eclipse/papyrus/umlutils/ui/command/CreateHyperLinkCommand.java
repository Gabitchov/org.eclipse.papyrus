/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlutils.ui.command;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;


/**
 * The Class CreateHyperLinkCommand. this has in charge to add a new entry  list of hyperlinks
 * 
 */
public class CreateHyperLinkCommand extends CreateEAnnotationCommand {

	
	/** The hyperlink kind. */
	public String hyperlinkKind; 
	
	/** The localization. */
	public String localization;
	
	/**
	 * Instantiates a new creates the hyper link command.
	 * 
	 * @param domain the domain 
	 * @param object the object for example the view
	 * @param hyperlinkKind the hyperlink kind see {@link VisualInformationPapyrusConstant}
	 * @param localization the localization
	 */
	public CreateHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object,String hyperlinkKind, String localization) {
		super(domain, object, VisualInformationPapyrusConstant.HYPERLINK);
		this.hyperlinkKind=hyperlinkKind; 
		this.localization=localization;
	}
	
	/**
	 * {@inheritedDoc}
	 */
	protected void doExecute() {
		EAnnotation eAnnotation = getObject().getEAnnotation(VisualInformationPapyrusConstant.HYPERLINK);
		if (eAnnotation == null) {
			eAnnotation = createEAnnotation();
			attachEannotation(eAnnotation, getObject());
		}
		addEntry(eAnnotation,localization, hyperlinkKind);
	}

}
