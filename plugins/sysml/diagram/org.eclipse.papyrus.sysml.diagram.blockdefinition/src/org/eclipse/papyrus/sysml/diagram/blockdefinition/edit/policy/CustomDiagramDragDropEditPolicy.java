/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.gmf.diagram.common.commands.IdentityCommandWithNotification;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.dnd.helper.CustomLinkMappingHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.messages.Messages;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;

/**
 * Custom diagram drag drop edit policy for elements handling drop in the Block Definition Diagram.
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** Default constructor. */
	public CustomDiagramDragDropEditPolicy() {
		super(new CustomLinkMappingHelper());
		registry = new CustomGraphicalTypeRegistry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<String> getSpecificDropBehaviorTypes() {
		return Collections.emptySet();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getUnknownDropCommand(DropObjectsRequest dropRequest, EObject droppedEObject) {
		
		// Add a notification message in case an attempt to drop a UML Association in this diagram occurs.
		if ((droppedEObject instanceof Association) && !(droppedEObject instanceof AssociationClass)) {
			if (!((ISpecializationType) SysMLElementTypes.ASSOCIATION).getMatcher().matches(droppedEObject)) {
				return new IdentityCommandWithNotification(Messages.Notification_Drop_Title, NLS.bind(Messages.Notification_Drop_UMLAssociationWarning, EMFCoreUtil.getQualifiedName(droppedEObject, true)), Type.WARNING);
			}
		}
		
		return super.getUnknownDropCommand(dropRequest, droppedEObject);
	}
}
