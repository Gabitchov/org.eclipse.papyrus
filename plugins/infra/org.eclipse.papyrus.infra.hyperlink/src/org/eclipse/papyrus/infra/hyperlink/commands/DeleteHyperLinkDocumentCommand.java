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
package org.eclipse.papyrus.infra.hyperlink.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


/**
 * The Class DeleteHyperLinkCommand. it can be used also to remove an hyperlink
 * web. It will remove the first eannotation that corresponds to the link or the
 * localization of the hyperlink
 */

public class DeleteHyperLinkDocumentCommand extends AbstractDeleteHyperLinkCommand{

	/** The localization. */
	public String link;

	/**
	 * Instantiates a new delete hyper link command used to suppress a link in
	 * the view
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object
	 * @param link
	 *        the localization of the link
	 */
	public DeleteHyperLinkDocumentCommand(TransactionalEditingDomain domain, EModelElement object, String link) {
		super(domain, object);//TODO an error?
		this.link = link;
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.commands.AbstractDeleteHyperLinkCommand#getEAnnotationsToRemove()
	 *
	 * @return
	 */
	@Override
	protected List<EAnnotation> getEAnnotationsToRemove() {
		List<EAnnotation> toRemove = super.getEAnnotationsToRemove();
		Iterator<EAnnotation> iter = getObject().getEAnnotations().iterator();
		// look for interesting eannotations
		while(iter.hasNext()) {
			EAnnotation currentAnnotation = iter.next();
			if(currentAnnotation.getSource().equals(HyperLinkConstants.HYPERLINK_DOCUMENT) || currentAnnotation.getSource().equals(HyperLinkConstants.HYPERLINK_WEB)) {
				if(currentAnnotation.getDetails().containsValue(link)) {
					toRemove.add(currentAnnotation);
				}
			}
		}
		return toRemove;
	}
}
