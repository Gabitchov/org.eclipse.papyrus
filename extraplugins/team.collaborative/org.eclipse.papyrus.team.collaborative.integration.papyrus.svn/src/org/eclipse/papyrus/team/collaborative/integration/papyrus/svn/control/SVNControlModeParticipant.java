/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.control;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.commands.AddFileToCollabSVN;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.commands.SaveCommand;
import org.eclipse.papyrus.team.collaborative.utils.CollabUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.PlatformUI;


/**
 * The Class SVNControlModeParticipant.
 * This {@link IControlCommandParticipant} provide mean to automatically integrate file generated after a control into a SVN repository
 * WARNING: The {@link IUncontrolCommandParticipant} is not implemented yet
 */
public class SVNControlModeParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	/**
	 * Instantiates a new sVN control mode participant.
	 */
	public SVNControlModeParticipant() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IControlModeParticipant#getID()
	 */
	@Override
	public String getID() {
		return "org.eclipse.papyrus.team.collaborative.integration.papyrus.control.SVNControlModeParticipant";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IControlModeParticipant#getPriority()
	 */
	@Override
	public int getPriority() {
		return 10000;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IUncontrolCommandParticipant#provideUnControlCommand(org.eclipse.papyrus.controlmode.request.
	 * ControlModeRequest)
	 */
	@Override
	public boolean provideUnControlCommand(ControlModeRequest request) {
		return CollabUtils.isCollab(request.getTargetObject());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IUncontrolCommandParticipant#getPreUncontrolCommand(org.eclipse.papyrus.controlmode.request.
	 * ControlModeRequest)
	 */
	@Override
	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IUncontrolCommandParticipant#getPostUncontrolCommand(org.eclipse.papyrus.controlmode.request.
	 * ControlModeRequest)
	 */
	@Override
	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IControlCommandParticipant#provideControlCommand(org.eclipse.papyrus.controlmode.request.
	 * ControlModeRequest)
	 */
	@Override
	public boolean provideControlCommand(ControlModeRequest request) {
		return CollabUtils.isCollab(request.getTargetObject());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IControlCommandParticipant#getPreControlCommand(org.eclipse.papyrus.controlmode.request.
	 * ControlModeRequest)
	 */
	@Override
	public ICommand getPreControlCommand(ControlModeRequest request) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.controlmode.interfaces.IControlCommandParticipant#getPostControlCommand(org.eclipse.papyrus.controlmode.request.
	 * ControlModeRequest)
	 */
	@Override
	public ICommand getPostControlCommand(ControlModeRequest request) {
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(request.getEditingDomain(), "Share file to SVN with need lock");
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof ISaveablePart) {
			cc.compose(new SaveCommand(request.getEditingDomain(), editor));
			cc.compose(new AddFileToCollabSVN(request.getEditingDomain(), request));
		}
		return cc;
	}

}
