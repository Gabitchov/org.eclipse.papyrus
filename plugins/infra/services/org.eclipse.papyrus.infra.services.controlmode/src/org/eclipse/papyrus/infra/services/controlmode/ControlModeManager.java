/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.infra.services.controlmode.commands.BasicControlCommand;
import org.eclipse.papyrus.infra.services.controlmode.commands.BasicUncontrolCommand;
import org.eclipse.papyrus.infra.services.controlmode.commands.CreateControlResource;
import org.eclipse.papyrus.infra.services.controlmode.commands.RemoveControlResourceCommand;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlModeParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;

/**
 * Implementation of {@link IControlModeManager} This manager used register participants to compute a control command
 * 
 * @author adaussy
 * 
 */
public class ControlModeManager implements IControlModeManager {

	/**
	 * Comparator that will sort the participant by priority
	 * 
	 */
	protected final class PartipantComparator implements Comparator<IControlModeParticipant> {

		public int compare(IControlModeParticipant arg0, IControlModeParticipant arg1) {
			int i = arg1.getPriority();
			int j = arg0.getPriority();
			return i >= j ? ((int) (i != j ? 1 : 0)) : -1;
		}
	}

	/**
	 * Singleton holder
	 * 
	 * @author adaussy
	 * 
	 */
	private static class SingletonHolder {

		private static ControlModeManager INSTANCE = new ControlModeManager();
	}

	/**
	 * Extension if for registering participants
	 */
	protected static String EXTENSION_ID = "org.eclipse.papyrus.infra.services.controlmode.participant";////$NON-NLS-0$

	/**
	 * Extension propertyy refering to the participant implementaion class
	 */
	protected static String PARTICPANT_ATTRIBUTE = "class";

	/**
	 * @return the unique instance of the manager
	 */
	public static IControlModeManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Hold all the {@link IControlCommandParticipant}
	 */
	protected ArrayList<IControlCommandParticipant> controlCommandParticipants = new ArrayList<IControlCommandParticipant>();

	/**
	 * Hold all the {@link IUncontrolCommandParticipant}
	 */
	protected ArrayList<IUncontrolCommandParticipant> uncontrolCommandParticipants = new ArrayList<IUncontrolCommandParticipant>();

	/**
	 * 
	 */
	public ControlModeManager() {
		initParticipants();
	}

	public ICommand getControlCommand(ControlModeRequest request) {
		boolean isOK = verifCorrectCommand(request);
		if(!isOK) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(request.getEditingDomain(), "Control command [Composite parent]");
		ICompositeCommand preCommand = getPreCommand(request);
		if(preCommand != null && !preCommand.isEmpty()) {
			cc.compose(preCommand);
		}
		cc.compose(new CreateControlResource(request));
		cc.compose(new BasicControlCommand(request));
		ICompositeCommand postCommand = getPostCommand(request);
		if(postCommand != null && !postCommand.isEmpty()) {
			cc.compose(postCommand);
		}
		return cc;
	}

	/**
	 * Check that the request is well formed
	 * 
	 * @param request
	 * @return
	 */
	protected boolean verifCorrectCommand(ControlModeRequest request) {
		EObject objectToControl = request.getTargetObject();
		if(objectToControl != null) {
			EObject container = objectToControl.eContainer();
			if(container != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return {@link ControlModeManager#controlCommandParticipants}
	 */
	protected List<IControlCommandParticipant> getControlCommandParticipants() {
		return controlCommandParticipants;
	}

	/**
	 * Compute the post command for the request
	 * 
	 * @param request
	 * @return
	 */
	protected ICompositeCommand getPostCommand(ControlModeRequest request) {
		boolean isControlRequest = request.isControlRequest();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(request.getEditingDomain(), isControlRequest ? "Control Command [ Post commands]" : "UnControl Command [ post commands]");////$NON-NLS-0$////$NON-NLS-1$
		if(isControlRequest) {
			getPostControlCommand(request, cc);
		} else {
			getPostUncontrolMethod(request, cc);
		}
		return cc;
	}

	/**
	 * Compute the post control command
	 * 
	 * @param request
	 * @param cc
	 *        new command will be composoed in it
	 */
	protected void getPostControlCommand(ControlModeRequest request, CompositeTransactionalCommand cc) {
		ListIterator<IControlCommandParticipant> participantIterator = getControlCommandParticipants().listIterator(getControlCommandParticipants().size());
		while(participantIterator.hasPrevious()) {
			IControlCommandParticipant iControlCommandParticipant = (IControlCommandParticipant)participantIterator.previous();
			if(iControlCommandParticipant.provideControlCommand(request)) {
				ICommand cmd = iControlCommandParticipant.getPostControlCommand(request);
				if(cmd != null) {
					cc.compose(cmd);
				}
			}
		}
	}

	/**
	 * Compute the post Uncontrol command
	 * 
	 * @param request
	 * @param cc
	 *        new command will be composoed in it
	 */
	protected void getPostUncontrolMethod(ControlModeRequest request, CompositeTransactionalCommand cc) {
		ListIterator<IUncontrolCommandParticipant> participantIterator = getUncontrolCommandParticipants().listIterator(getUncontrolCommandParticipants().size());
		while(participantIterator.hasPrevious()) {
			IUncontrolCommandParticipant iControlCommandParticipant = (IUncontrolCommandParticipant)participantIterator.previous();
			if(iControlCommandParticipant.provideUnControlCommand(request)) {
				ICommand cmd = iControlCommandParticipant.getPostUncontrolCommand(request);
				if(cmd != null) {
					cc.compose(cmd);
				}
			}
		}
	}

	/**
	 * Compute the Pre command for this {@link ControlModeRequest}
	 * 
	 * @param request
	 * @return
	 */
	protected ICompositeCommand getPreCommand(ControlModeRequest request) {
		boolean isControlRequest = request.isControlRequest();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(request.getEditingDomain(), isControlRequest ? "Control Command [ Pre commands]" : "UnControl Command [ Pre commands]");////$NON-NLS-0$////$NON-NLS-1$
		if(isControlRequest) {
			getPreControlCommand(request, cc);
		} else {
			getPreUncontrolCommand(request, cc);
		}
		return cc;
	}

	/**
	 * Comute the command for pre control command
	 * 
	 * @param request
	 * @param cc
	 *        new command will be composoed in it
	 */
	protected void getPreControlCommand(ControlModeRequest request, CompositeTransactionalCommand cc) {
		Iterator<IControlCommandParticipant> participantIterator = getControlCommandParticipants().iterator();
		while(participantIterator.hasNext()) {
			IControlCommandParticipant iControlCommandParticipant = (IControlCommandParticipant)participantIterator.next();
			if(iControlCommandParticipant.provideControlCommand(request)) {
				ICommand cmd = iControlCommandParticipant.getPreControlCommand(request);
				if(cmd != null) {
					cc.compose(cmd);
				}
			}
		}
	}

	/**
	 * Compute the command to pre uncontrol command
	 * 
	 * @param request
	 * @param cc
	 *        new command will be composoed in it
	 */
	protected void getPreUncontrolCommand(ControlModeRequest request, CompositeTransactionalCommand cc) {
		Iterator<IUncontrolCommandParticipant> participantIterator = getUncontrolCommandParticipants().iterator();
		while(participantIterator.hasNext()) {
			IUncontrolCommandParticipant iControlCommandParticipant = (IUncontrolCommandParticipant)participantIterator.next();
			if(iControlCommandParticipant.provideUnControlCommand(request)) {
				ICommand cmd = iControlCommandParticipant.getPreUncontrolCommand(request);
				if(cmd != null) {
					cc.compose(cmd);
				}
			}
		}
	}

	public ICommand getUncontrolCommand(ControlModeRequest request) {
		boolean isOK = verifCorrectCommand(request);
		if(!isOK) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(request.getEditingDomain(), "Uncontrol command [Composite parent]");
		ICompositeCommand preCommand = getPreCommand(request);
		if(preCommand != null && !preCommand.isEmpty()) {
			cc.compose(preCommand);
		}
		cc.compose(new BasicUncontrolCommand(request));
		cc.compose(new RemoveControlResourceCommand(request));
		ICompositeCommand postCommand = getPostCommand(request);
		if(postCommand != null && !postCommand.isEmpty()) {
			cc.compose(postCommand);
		}
		return cc;
	}

	/**
	 * @return {@link ControlModeManager#uncontrolCommandParticipants}
	 */
	protected List<IUncontrolCommandParticipant> getUncontrolCommandParticipants() {
		return uncontrolCommandParticipants;
	}

	/**
	 * Init the manager with all particpants
	 */
	protected void initParticipants() {
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(IConfigurationElement e : extensions) {
			try {
				Object particpant = e.createExecutableExtension(PARTICPANT_ATTRIBUTE);
				if(particpant instanceof IControlCommandParticipant) {
					getControlCommandParticipants().add((IControlCommandParticipant)particpant);
				}
				if(particpant instanceof IUncontrolCommandParticipant) {
					getUncontrolCommandParticipants().add((IUncontrolCommandParticipant)particpant);
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		PartipantComparator comparator = new PartipantComparator();
		Collections.sort(uncontrolCommandParticipants,comparator);
		Collections.sort(controlCommandParticipants,comparator);
	}
}
