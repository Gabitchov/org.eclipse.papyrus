/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/


package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.jface.action.IAction;

/**
 * This action allows to set the field Needs Title in the Selected Compartments to true
 * 
 * This action was created for the bug 343092.
 * 
 */
public class SetCompartmentNeedsTitleToTrueAction extends Action {


	public void run(IAction action) {

		CompoundCommand command = new CompoundCommand();
		List<EObject> selection = getSelectedEObject();
		if(!selection.isEmpty()) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(selection.get(0));
			Assert.isNotNull(domain);
			Iterator<EObject> iter = selection.iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				if(current instanceof GenCompartment) {
					GenCompartment compartment = (GenCompartment)current;
					//we set that the compartment needs to have a Title
					Command cmd = SetCommand.create(domain, compartment, GMFGenPackage.eINSTANCE.getGenCompartment_NeedsTitle(), true);
					if(cmd.canExecute()) {
						command.append(cmd);
					}
				}
			}

			if(command.canExecute()) {
				domain.getCommandStack().execute(command);
			}
		}
	}
}
