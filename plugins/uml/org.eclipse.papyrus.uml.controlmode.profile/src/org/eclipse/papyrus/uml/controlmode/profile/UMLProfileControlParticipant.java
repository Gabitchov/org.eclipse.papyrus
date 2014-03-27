/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.controlmode.profile;

import java.util.Collections;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.AskUserCommand;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;
import org.eclipse.papyrus.uml.controlmode.profile.commands.CopyProfileApplicationCommand;
import org.eclipse.papyrus.uml.controlmode.profile.commands.MoveProfileApplicationCommand;
import org.eclipse.papyrus.uml.controlmode.profile.commands.MoveStereotypeApplicationToControlResource;
import org.eclipse.papyrus.uml.controlmode.profile.commands.RemoveDuplicationProfileApplicationCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * Participant to control command handling Uml element.
 * Handle Profile applications on package
 * Handle Stereotype Application on Package
 *
 * @author adaussy
 *
 */
public class UMLProfileControlParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	/**
	 * Return the command to copy profile application
	 *
	 * @param request
	 * @return
	 */
	protected IUndoableOperation getCopyProfileApplication(final ControlModeRequest request) {
		return new CopyProfileApplicationCommand(request);
	}

	public String getID() {
		return "org.eclipse.papyrus.uml.controlmode.profile.UMLProfileControlParticipant";
	}

	private String getPreControlCommandMessage(Element objectToControl) {
		return "This element is not a package. Due to UML restrictions, the newly created model fragment is not allowed to be modified in the standalone mode";//
	}

	/**
	 * Get the command to move stereotype application
	 *
	 * @param request
	 * @return
	 */
	protected IUndoableOperation getMoveStereotypeCommand(final ControlModeRequest request) {
		return new MoveStereotypeApplicationToControlResource(Collections.singletonList(WorkspaceSynchronizer.getFile(request.getTargetObject().eResource())), request);
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		CompositeCommand cc = new CompositeCommand("Composite command for control command [UML Part]");
		//Move stereotype application
		if(request.getTargetObject() instanceof Package) {
			cc.compose(getMoveProfileAppliationCommand(request));
		}
		//Move stereotype application
		cc.compose(getMoveStereotypeCommand(request));
		//Copy profile application
		if(request.getTargetObject() instanceof Package) {
			cc.compose(getCopyProfileApplication(request));
		}
		return cc;
	}

	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		CompositeCommand cc = new CompositeCommand("Composite command for uncontrol command [UML Part]");

		if(cc.isEmpty()) {
			return null;
		}
		return cc;
	}

	/**
	 * Get the command to move profile applicaiton
	 *
	 * @param request
	 * @return
	 */
	protected ICommand getMoveProfileAppliationCommand(ControlModeRequest request) {
		return new MoveProfileApplicationCommand(request);
	}

	/**
	 * Get the command to remove profile application
	 *
	 * @param request
	 * @return
	 */
	protected ICommand getRemoveProfileApplication(final ControlModeRequest request) {
		return new RemoveDuplicationProfileApplicationCommand(request);
	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		Element elem = (Element)request.getTargetObject();
		if(request.isUIAction() && !(elem instanceof org.eclipse.uml2.uml.Package)) {
			return new AskUserCommand(request.getEditingDomain(), getPreControlCommandMessage(elem), getPreControlCommandDialogTitle(elem), true, "org.eclipse.papyrus.controlmode.umlprofiles.participants.UMLProfileParticipant.openstandalonemodeldialog");
		}
		return null;
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		CompositeCommand cc = new CompositeCommand("Composite command for pre uncontrol command [UML Part]");
		//Copy profile application
		if(request.getTargetObject() instanceof Package) {
			cc.compose(getRemoveProfileApplication(request));
		}
		cc.compose(getMoveStereotypeCommand(request));
		return cc;
	}

	public int getPriority() {
		return 100;
	}

	protected String getPreControlCommandDialogTitle(Element elem) {
		return "Warning: The element is not a Package";
	}

	public boolean provideControlCommand(ControlModeRequest request) {
		return request.getTargetObject() instanceof Element;
	}

	public boolean provideUnControlCommand(ControlModeRequest request) {
		return request.getTargetObject() instanceof Element;
	}
}
