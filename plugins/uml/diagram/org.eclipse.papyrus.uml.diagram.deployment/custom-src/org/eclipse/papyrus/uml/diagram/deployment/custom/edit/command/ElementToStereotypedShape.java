/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.deployment.custom.edit.command;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLViewProvider;

/**
 * this is the specific command in charge to transform an element editpart into a shape_namedElement Editpart
 * 
 */
public class ElementToStereotypedShape extends RecordingCommand {

	protected GraphicalEditPart elementEditPart;

	/**
	 * 
	 * Constructor of this command
	 * 
	 * @param domain
	 *        the transactional editing domain to execute transaction
	 * @param classView
	 *        the editpart that will be transformed
	 */
	public ElementToStereotypedShape(TransactionalEditingDomain domain, GraphicalEditPart classView) {
		super(domain);
		this.elementEditPart = classView;
	}

	@Override
	protected void doExecute() {

		//creation of the node
		UMLViewProvider umlViewProvider = new UMLViewProvider();
		Node packageview = umlViewProvider.createNamedElement_2012(elementEditPart.resolveSemanticElement(), (View)elementEditPart.getNotationView().eContainer(), -1, true, elementEditPart.getDiagramPreferencesHint());
		packageview.setLayoutConstraint(((Node)elementEditPart.getNotationView()).getLayoutConstraint());

		//copy of all eannotations
		Iterator<EAnnotation> iter = elementEditPart.getNotationView().getEAnnotations().iterator();
		while(iter.hasNext()) {
			EAnnotation annotation = EcoreUtil.copy(iter.next());
			packageview.getEAnnotations().add(annotation);

		}

	}

}
