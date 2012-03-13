/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.table.assign.utils;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Comment;

/**
 * Used to delete comments with the stereotype assign, 
 * when the features from and to are empty.
 * @author omelois
 *
 */
public class AssignCommentDeleter {

	public static void deleteCommentWhenToAndFromAreEmpty(EditingDomain editingDomain, Comment comment){
		Assign assign = (Assign)comment.getStereotypeApplication(comment.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign"));
		int fromSize = assign.getFrom().size();
		int toSize = assign.getTo().size();
		//If from and to are empty, the comment has to be destroyed.
		if (fromSize == 0 && toSize == 0){
			//Creating a destroy request for the context.
			DestroyElementRequest destroyElementRequest = new DestroyElementRequest(comment, false);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(comment);	
			if(provider != null) {
				// Retrieving the right command from the Element Edit service
				ICommand GMFDeleteCommand = provider.getEditCommand(destroyElementRequest);
				if(GMFDeleteCommand != null) {
					editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(GMFDeleteCommand));
				}
			}
		}
	}
	
}
