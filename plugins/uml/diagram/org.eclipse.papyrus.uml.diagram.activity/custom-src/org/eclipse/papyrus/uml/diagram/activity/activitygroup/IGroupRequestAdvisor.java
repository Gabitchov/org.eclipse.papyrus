/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.request.IGroupRequest;

import com.google.common.collect.Multimap;

/**
 * Represent an advisor of Group Request. Should be able to handle group request
 * 
 * @author arthur daussy
 * 
 */
public interface IGroupRequestAdvisor {

	/**
	 * Remove the listener from the Group framework
	 * 
	 * @param editpolicy
	 */
	public void removeListenner(IGroupNotifier editpolicy);

	/**
	 * Register into the group framework
	 * 
	 * @param eObject
	 * @param editpolicy
	 */
	public void addListenner(EObject eObject, IGroupNotifier editpolicy);

	/**
	 * Notify to the group framework a change (come from a Notifing Edit policy)
	 * 
	 * @param request
	 * @return
	 */
	public ICommand notifyGroupFramework(IGroupRequest request);

	/**
	 * Return all register edit policy
	 * 
	 * @return
	 */
	public Multimap<EObject, IGroupNotifier> getListenerRegistry();
}
