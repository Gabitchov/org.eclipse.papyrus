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
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomOwnerClassChangeCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.AddedLinkItemSemanticEditPolicy;
import org.eclipse.uml2.uml.PackageableElement;

public class CustomAddedLinkItemSemanticEditPolicy extends AddedLinkItemSemanticEditPolicy {


	/**
	 * / * {@inheritDoc}
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		CompositeCommand cc = new CompositeCommand(StringStatics.BLANK);
		TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain == null) {
			return null;
		}
		// Change the owner of the target class 
		cc.compose(new CustomOwnerClassChangeCommand(editingDomain, (PackageableElement)req.getReferencedObject()));


		ContainmentCircleEditPart containmentCEP = (ContainmentCircleEditPart)((ConnectionEditPart)getHost()).getSource();
		//The containment circle node is deleted only if any other link is connected 
		if(containmentCEP.getSourceConnections().size() == 1) {
			cc.compose(new DeleteCommand(editingDomain, (View)containmentCEP.getModel()));
		}
		return new ICommandProxy(cc.reduce());
	}

}
