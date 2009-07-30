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


// TODO: Auto-generated Javadoc
/**
 * The Class DeleteHyperLinkCommand.
 */
public class DeleteHyperLinkCommand extends CreateEAnnotationCommand {


		
		/** The localization. */
		public String localization;
		
		/**
		 * Instantiates a new delete hyper link command used to suppress a link in the view
		 * 
		 * @param domain the domain
		 * @param object the object
		 * @param localization the localization of the link
		 */
		public DeleteHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, String localization) {
			super(domain, object, VisualInformationPapyrusConstant.HYPERLINK);
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
			eAnnotation.getDetails().removeKey(localization);
		}
}
