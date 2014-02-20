/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *               Mathieu Velten (Atos Origin) - re-written using transactional command
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import java.util.List;
import java.util.ListIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.uml2.uml.Element;

/**
 * Unapplies all stereotypes from an Element.
 */
public class UnapplyAllStereotypesCommand extends CompositeCommand {

	public UnapplyAllStereotypesCommand(TransactionalEditingDomain domain, String label, Element element) {
		super(label);
		
		List<EObject> stereotypeApplications = element.getStereotypeApplications();
		for (ListIterator<EObject> it = stereotypeApplications.listIterator(stereotypeApplications.size()); it.hasPrevious(); ) {
			EObject stereotypeApplication = it.previous();
			DestroyElementRequest stereoReq = new DestroyElementRequest(domain, stereotypeApplication, false);
			add(new DestroyElementPapyrusCommand(stereoReq));
		}
	}
}
