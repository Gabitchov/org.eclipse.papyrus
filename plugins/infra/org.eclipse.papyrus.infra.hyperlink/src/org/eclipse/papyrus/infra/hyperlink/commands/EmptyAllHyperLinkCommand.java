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
public class EmptyAllHyperLinkCommand extends AbstractDeleteHyperLinkCommand {

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
	public EmptyAllHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object) {
		super(domain, object);
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
			String source = currentAnnotation.getSource();
			if(source.startsWith(HyperLinkConstants.PAPYRUS_HYPERLINK_PREFIX)) {
				toRemove.add(currentAnnotation);
			}
		}
		return toRemove;
	}

}
