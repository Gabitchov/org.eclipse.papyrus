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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;

/**
 * 
 * <UL>The purpose of this command is to delete view by taking following situation:
 * <LI> if the view is placed direclty on the diagram, do nothing
 * <LI> if the view is placed into another container, the semantic of the container must be the parent of the semantic view 
 *</UL>
 */
public class CustomDeleteCommand extends DeleteCommand{

	public CustomDeleteCommand(TransactionalEditingDomain editingDomain, View view) {
		super(editingDomain, view);
	}
	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		String containerType = ViewUtil.getViewContainer(getView()) != null ? ViewUtil.getViewContainer(getView()).getType() : null;		
		if((containerType != null) && !ElementTypes.DIAGRAM_ID.equals(containerType)) {
			//if the associated element is different of null
			if(getView().getElement()!=null){
				//if the container is different of null
				if( ViewUtil.getContainerView(getView())!=null&& ViewUtil.getContainerView(getView()).getElement()!=null){
					//if the parent of the current element is different of the semantic element of the parent view we have to destroy
					if(!getView().getElement().eContainer().equals(ViewUtil.getContainerView(getView()).getElement()) ){
						return super.doExecute(monitor, info);
					}
					
				}
			}
		}
		return Status.OK_STATUS;
	}
}
