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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;

/**
 * 
 * This command is used to set visible the Stereotype <<Metaclass>> on a metaclass after a drop.
 * 
 * We call this command when we can't call directly AppliedStereotypeHelper.getAddAppliedStereotypeCommand, because the view is not yet created!
 * 
 */
public class SetStereotypeVisibleOnMetaclassCommand extends AbstractTransactionalCommand {

	/** the semantic link */
	private Element semanticLink;

	/** the view descriptor */
	private CreateViewRequest.ViewDescriptor cmdResult = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the {@link TransactionalEditingDomain}
	 * @param label
	 *        the label for the command
	 * @param affectedFiles
	 *        the affected files
	 * @param semanticLink
	 *        the link
	 * @param descriptor
	 *        the view descriptor for the metaclass
	 */
	public SetStereotypeVisibleOnMetaclassCommand(TransactionalEditingDomain domain, String label, List<?> affectedFiles, Element semanticLink, CreateViewRequest.ViewDescriptor descriptor) {
		super(domain, label, affectedFiles);
		this.semanticLink = semanticLink;
		this.cmdResult = descriptor;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(semanticLink instanceof ElementImport) {
			Class metaclass = (Class)((ElementImport)semanticLink).getImportedElement();
			View node = (View)(this.cmdResult).getAdapter(View.class);
			Element UMLelement = metaclass;
			String stereotypeName = UMLelement.getAppliedStereotypes().get(0).getQualifiedName();
			Command command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getEditingDomain(), node, stereotypeName, VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION);
			if(command.canExecute()) {
				command.execute();
			}
		}
		return CommandResult.newOKCommandResult();
	}

}
