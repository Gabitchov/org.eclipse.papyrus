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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Refactoring & simplification
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.commands;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


/**
 * The Class DeleteHyperLinkCommand. it can be used also to remove an hyperlink
 * web. It will remove the first eannotation that corresponds to the link or the
 * localization of the hyperlink
 */
public class DeleteHyperLinkPageCommand extends RecordingCommand {

	/** The hyperlink target. */
	protected EObject page;

	protected EModelElement sourceElement;

	/**
	 * Instantiates a new delete hyper link command used to suppress a link in
	 * the view
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object
	 * @param page
	 *        the target of the link
	 */
	public DeleteHyperLinkPageCommand(TransactionalEditingDomain domain, EModelElement object, EObject page) {
		super(domain);
		this.page = page;
		this.sourceElement = object;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void doExecute() {
		Iterator<EAnnotation> iter = sourceElement.getEAnnotations().iterator();

		//Remove interesting eannotations
		while(iter.hasNext()) {
			EAnnotation currentAnnotation = iter.next();
			for(String annotationName : HyperLinkConstants.validHyperLinkPageSources) {
				if(annotationName.equals(currentAnnotation.getSource())) {
					if(currentAnnotation.getReferences().contains(page)) {
						iter.remove();
					}
				}
			}
		}
	}
}
