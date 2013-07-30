/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.DuplicateViewsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * this command is used to copy view and to reassociate to a new container
 */
@SuppressWarnings("restriction")
public class PapyrusDuplicateViewsCommand extends DuplicateViewsCommand implements ICommand {

	// the new container
	protected View container = null;

	@SuppressWarnings("rawtypes")
	public PapyrusDuplicateViewsCommand(TransactionalEditingDomain editingDomain, String label, DuplicateRequest request, List viewsToDuplicate, Map duplicatedElements, Point offset, View container) {
		super(editingDomain, label, request, viewsToDuplicate, duplicatedElements, offset);
		this.container = container;
	}

	/**
	 * Verifies that the container of all the original objects can contain
	 * multiple objects.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean canExecute() {
		for(Iterator iter = getObjectsToBeDuplicated().iterator(); iter.hasNext();) {
			EObject original = (EObject)iter.next();
			// In the case of cut the owner does not exist
			if(original.eContainer() == null) {
				return true;

			} else {
				EReference reference = original.eContainmentFeature();
				if(reference == null || !FeatureMapUtil.isMany(original.eContainer(), reference)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.internal.commands.DuplicateViewsCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@SuppressWarnings("rawtypes")
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult result = super.doExecuteWithResult(progressMonitor, info);
		// reassociation to the new container
		if(result.getReturnValue() instanceof List) {
			List duplicatedObject = (List)result.getReturnValue();
			Iterator iterator = duplicatedObject.iterator();
			while(iterator.hasNext()) {
				Object object = (Object)iterator.next();
				if(object instanceof View) {
					View duplicatedView = (View)object;
					if(duplicatedView.eContainer() == null && container != null) {

						ViewUtil.insertChildView(container, duplicatedView, -1, true);

					}
				}

			}
		}
		return result;
	}
}
