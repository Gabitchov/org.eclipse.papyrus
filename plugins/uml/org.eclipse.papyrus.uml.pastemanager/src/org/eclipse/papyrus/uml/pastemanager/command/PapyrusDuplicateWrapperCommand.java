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
package org.eclipse.papyrus.uml.pastemanager.command;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


/**
 * this command is used to wrap a copy command. it allows set a new owner for views.
 */
public class PapyrusDuplicateWrapperCommand extends AbstractTransactionalCommand {

	/** the new container for the shape */
	protected View container = null;

	/** Command that owns this duplicate command */
	protected ICommand duplicateEObjectsCommandOwner = null;

	/** list of object to duplicate */
	protected List<Object> eObjectsToBeDuplicated = null;

	/** Constant used as a key for the parameters map of the duplication request */
	public static final String ADDITIONAL_DUPLICATED_ELEMENTS = "Additional_Duplicated_Elements";

	/**
	 * Constructor.
	 * 
	 * @param editingDomain
	 * @param label
	 * @param eObjectsToBeDuplicated
	 * @param subCommand
	 * @param container
	 */
	public PapyrusDuplicateWrapperCommand(TransactionalEditingDomain editingDomain, String label, List<Object> eObjectsToBeDuplicated, ICommandProxy subCommand, View container) {
		super(editingDomain, label, null);
		this.container = container;
		this.eObjectsToBeDuplicated = eObjectsToBeDuplicated;
		this.duplicateEObjectsCommandOwner = lookForDuplicateCommandOwner(subCommand);
	}

	/**
	 * Verifies that the container of all the original objects can contain
	 * multiple objects.
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
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
						Object object = iterator.next();
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
		} else if(result.getReturnValue() instanceof Map) { // perhaps not a list in case of simple ICommand, result value should be a map
			Map duplicatedObject = (Map)result.getReturnValue();
			Iterator iterator = duplicatedObject.values().iterator();
			// for each view, a container is set if it is null 
			// if this is a shape a new position is set in order to avoid superposition
			while(iterator.hasNext()) {
				Object object = iterator.next();
				if(object instanceof Diagram) {
					Diagram diagramView = (Diagram)object;
					if(container != null && container.eResource() != null) {
						container.eResource().getContents().add(diagramView);
					}

				} else if(object instanceof View) {
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

			ICommand externalObjectsDuplicateCommand = getExternalObjectsDuplicateCommand((Map<?, ?>)result.getReturnValue());
			if(externalObjectsDuplicateCommand != null && externalObjectsDuplicateCommand.canExecute()) {
				IStatus status = externalObjectsDuplicateCommand.execute(progressMonitor, info);
				if(!status.isOK()) {
					return CommandResult.newErrorCommandResult(status.getException());
				}
			}
		}

		return result;
	}

	/**
	 * this class is used to look for the basic eobject duplicate command
	 * 
	 * @param command
	 *        that contains normally the duplicated command
	 * @return the duplicate command
	 */
	protected ICommand lookForDuplicateCommandOwner(ICommandProxy command) {
		return command.getICommand();
	}

	/**
	 * Returns the list of external objects to duplicate
	 * 
	 * @return the list of external objects to duplicate or an empty list if not elements are found to add.
	 */
	protected ICommand getExternalObjectsDuplicateCommand(Map duplicatedElementsMap) {
		CompositeCommand result = new CompositeCommand("Duplicate External Objects");
		Set<Object> duplicatedExternalElements = new HashSet<Object>();

		for(Object o : duplicatedElementsMap.keySet()) {
			if(o instanceof EObject) {
				EObject object = (EObject)o;
				DuplicateElementsRequest request = new DuplicateElementsRequest(Collections.singletonList(object));
				request.setAllDuplicatedElementsMap(duplicatedElementsMap);
				request.setParameter(PapyrusDuplicateWrapperCommand.ADDITIONAL_DUPLICATED_ELEMENTS, duplicatedExternalElements);
				request.setParameter("Target_Owner", BusinessModelResolver.getInstance().getBusinessModel(container));
				IElementEditService service = ElementEditServiceUtils.getCommandProvider(object);
				ICommand command = service.getEditCommand(request);
				if(command != null) {
					result.add(command);
				}
			}
		}

		return (result.isEmpty()) ? null : result.reduce();
	}
}
