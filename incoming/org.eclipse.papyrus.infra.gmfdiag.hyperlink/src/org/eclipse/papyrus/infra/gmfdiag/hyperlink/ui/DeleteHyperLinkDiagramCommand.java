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
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;


/**
 * The Class DeleteHyperLinkCommand. it can be used also to remove an hyperlink
 * web. It will remove the first eannotation that corresponds to the link or the
 * localization of the hyperlink
 */
public class DeleteHyperLinkDiagramCommand extends CreateEAnnotationCommand {

	/** The localization. */
	public EModelElement diagram;

	/**
	 * Instantiates a new delete hyper link command used to suppress a link in
	 * the view
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object
	 * @param diagram
	 *        the localization of the link
	 */
	public DeleteHyperLinkDiagramCommand(TransactionalEditingDomain domain, EModelElement object, EModelElement diagram) {
		super(domain, object, HyperLinkDiagramConstants.HYPERLINK_DIAGRAM);
		this.diagram = diagram;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void doExecute() {
		ArrayList<EAnnotation> eAnnotationsToRemove = new ArrayList<EAnnotation>();
		Iterator<EAnnotation> iter = getObject().getEAnnotations().iterator();
		// look for interesting eannotations
		while(iter.hasNext()) {
			EAnnotation currentAnnotation = iter.next();
			if(currentAnnotation.getSource().equals(HyperLinkDiagramConstants.HYPERLINK_DIAGRAM)) {
				if(currentAnnotation.getReferences().contains(diagram)) {
					eAnnotationsToRemove.add(currentAnnotation);
				}
			}
		}
		// remove all eannotations
		for(int i = 0; i < eAnnotationsToRemove.size(); i++) {
			getObject().getEAnnotations().remove(eAnnotationsToRemove.get(i));
		}

	}
}
