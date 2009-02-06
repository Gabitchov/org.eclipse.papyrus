/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CommentAnnotatedElementItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated not
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof GroupRequest && RequestConstants.REQ_DELETE.equals(request.getType())) {
			CommentAnnotatedElementEditPart ep = (CommentAnnotatedElementEditPart) getHost();
			DestroyReferenceRequest drr = new DestroyReferenceRequest(((View) ep.getSource().getModel()).getElement(), UMLPackage.eINSTANCE.getComment_AnnotatedElement(), ((View) ep.getTarget()
					.getModel()).getElement(), false);
			return getDestroyReferenceCommand(drr);
		}
		return super.getCommand(request);
	}

	/**
	 * @generated not
	 */
	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		CompoundCommand cc = new CompoundCommand();
		Comment c = (Comment) req.getContainer();

		cc.add(getGEFWrapper(new DestroyReferenceCommand(req)));

		if (c.getAnnotatedElements().size() < 2 || c.getAnnotatedElements().size() > 2) {
			Model m = (Model) c.eResource().getContents().get(0);
			SetRequest sr = new SetRequest(m, UMLPackage.eINSTANCE.getElement_OwnedComment(), c);
			cc.add(new ICommandProxy(new SetValueCommand(sr)));
		} else {
			Element e = findNewParent((Element) req.getReferencedObject(), c.getAnnotatedElements());
			SetRequest sr = new SetRequest(e, UMLPackage.eINSTANCE.getElement_OwnedComment(), c);
			cc.add(new ICommandProxy(new SetValueCommand(sr)));
		}

		return cc;
	}

	/**
	 * @not generated
	 */
	private Element findNewParent(Element oldValue, EList<Element> elements) {
		for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
			Element e = it.next();
			if (e != oldValue)
				return e;
		}

		return null;
	}

}
