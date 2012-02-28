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
package org.eclipse.papyrus.diagram.activity.activitygroup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;
import org.eclipse.papyrus.diagram.activity.activitygroup.request.IGroupRequest;

/**
 * Represent an advisor of Group Request. Should be able to handle group request
 * @author arthur daussy
 *
 */
public interface IGroupRequestAdvisor {

	public void removeListenner(IGroupNotifier editpolicy);

	public void addListenner(EObject eObject,IGroupNotifier editpolicy);
	
	public ICommand notifyGroupFramework(IGroupRequest request);
	


}
