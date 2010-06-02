/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.groupcontainment;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.diagram.common.groups.core.GroupManagementListener;
import org.eclipse.papyrus.diagram.common.groups.core.PendingGroupNotificationsManager;

/**
 * Service for configuring the group framework from external plugins
 * 
 * @author vhemery
 */
public class EditingDomainRegisteringService {

	/**
	 * Add the group framework for the given editing domain
	 * 
	 * @param domain
	 *        editing domain of the diagram with groups
	 * @param diagramEditPart
	 *        the diagram edit part
	 */
	public static void addGroupFrameworkForEditingDomain(final TransactionalEditingDomain domain, final DiagramEditPart diagramEditPart) {
		final GroupManagementListener groupManagementListener = new GroupManagementListener(diagramEditPart);
		domain.addResourceSetListener(groupManagementListener);
		diagramEditPart.addEditPartListener(new EditPartListener.Stub() {

			@Override
			public void partDeactivated(EditPart editpart) {
				PendingGroupNotificationsManager.removeInstanceForDiagram(diagramEditPart);
				domain.removeResourceSetListener(groupManagementListener);
				editpart.removeEditPartListener(this);
			}
		});
	}
}
