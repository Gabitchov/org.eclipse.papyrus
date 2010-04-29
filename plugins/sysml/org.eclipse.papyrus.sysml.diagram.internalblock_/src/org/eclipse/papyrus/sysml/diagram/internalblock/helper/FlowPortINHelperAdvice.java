/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;


public class FlowPortINHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Returns a command that initialize a FlowPort with IN direction.
	 * It complete the creation command provided by the specialized Metamodel
	 * element helper by applying the FlowPort stereotype, setting direction and initializing the
	 * new element name.
	 */
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				Port newElement = (Port)request.getElementToConfigure();

				// Set the element name (should bound by a separated AdviceHelper)
				String baseName = getElementType().getDisplayName();
				String newElementName = NamedElementUtil.getNewUMLElementName((Element)getElementToEdit(), baseName);
				newElement.setName(newElementName);

				// Apply stereotype
				Stereotype st = newElement.getApplicableStereotype("SysML::PortAndFlows::FlowPort");
				FlowPort fp = (FlowPort)newElement.applyStereotype(st);
				fp.setDirection(FlowDirection.IN);

				return CommandResult.newOKCommandResult();
			}
		};
	}

}
