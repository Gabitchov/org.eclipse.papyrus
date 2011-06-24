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
package org.eclipse.papyrus.pastemanager.command;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;


/**
 * this command is used to wrap a copy command. it allows set a new owner for views.
 */
@SuppressWarnings("restriction")
public class PapyrusDuplicateWrapperCommand extends AbstractTransactionalCommand {

	// the new container
	protected View container = null;

	protected CompositeTransactionalCommand duplicateEObjectsCommandOwner = null;

	@SuppressWarnings("rawtypes")
	protected List eObjectsToBeDuplicated = null;


	@SuppressWarnings("rawtypes")
	public PapyrusDuplicateWrapperCommand(TransactionalEditingDomain editingDomain, String label, List eObjectsToBeDuplicated, ICommandProxy subCommand, View container) {
		super(editingDomain, label, null);
		this.container = container;
		this.eObjectsToBeDuplicated = eObjectsToBeDuplicated;
		this.duplicateEObjectsCommandOwner = lookForDuplicateCommandOwner(subCommand);
	}

	/**
	 * Verifies that the container of all the original objects can contain
	 * multiple objects.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean canExecute() {
		for(Iterator iter = eObjectsToBeDuplicated.iterator(); iter.hasNext();) {
			EObject original = (EObject)iter.next();
			//In the case of cut the owner does not exist 
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
		duplicateEObjectsCommandOwner.execute(progressMonitor, info);
		CommandResult result = duplicateEObjectsCommandOwner.getCommandResult();
		//reassociation to the new container
		if(result.getReturnValue() instanceof List) {
			Iterator resultIterator = ((List)result.getReturnValue()).iterator();
			while(resultIterator.hasNext()) {
				Object currentResult = resultIterator.next();

				// the result of a copy is a map
				if(currentResult instanceof Map) {
					Map duplicatedObject = (Map)currentResult;
					Iterator iterator = duplicatedObject.values().iterator();
					// for each view, a container is set if it is null 
					// if this is a shape a new position is set in order to avoid superposition
					while(iterator.hasNext()) {
						Object object = (Object)iterator.next();
						if(object instanceof View) {
							View duplicatedView = (View)object;
							if(object instanceof Shape) {
								LayoutConstraint layoutConstraint = ((Shape)object).getLayoutConstraint();
								if(layoutConstraint instanceof Bounds) {
									((Bounds)layoutConstraint).setX(((Bounds)layoutConstraint).getX() + 10);
									((Bounds)layoutConstraint).setY(((Bounds)layoutConstraint).getY() + 10);

								}
							}
							if(duplicatedView.eContainer() == null && container != null) {

								ViewUtil.insertChildView(container, duplicatedView, -1, true);

							}
						}
					}
				}
			}
		}
		return result;
	}
/**
 * this class is used to look for the basic eobject duplicate command
 * @param command that contains normally the duplicated command
 * @return the duplicate command
 */
	protected CompositeTransactionalCommand lookForDuplicateCommandOwner(ICommandProxy command) {
		if(command.getICommand() instanceof CompositeTransactionalCommand) {
			return (CompositeTransactionalCommand)command.getICommand();
		}
		return null;
	}
}
