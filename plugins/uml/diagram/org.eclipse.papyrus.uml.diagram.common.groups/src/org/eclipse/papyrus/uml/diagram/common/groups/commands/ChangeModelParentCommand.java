/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.common.groups.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.internal.l10n.EMFTypeCoreMessages;

/**
 * This command will change the model parent of child to the IAdaptable parent.
 * 
 * @author adaussy
 * 
 */
public class ChangeModelParentCommand extends AbstractTransactionalCommand {

	/**
	 * Child to add to the IAdaptable parent
	 */
	private Map<EObject, EReference> chilrendToMove;

	private EObject targetContainer;

	private IAdaptable elementAdapter;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param parentGroupAdapter
	 * @param chilrendToMove
	 * @param anyPart
	 * @param groupDescriptor
	 */
	public ChangeModelParentCommand(TransactionalEditingDomain domain, IAdaptable parentGroupAdapter, Map<EObject, EReference> chilrendToMove, IGraphicalEditPart anyPart) {
		super(domain, "Change model parent command", null);
		this.chilrendToMove = chilrendToMove;
		this.elementAdapter = parentGroupAdapter;
		targetContainer = null;
		//		if(anyPart != null) {
		//			this.editPartRegistery = anyPart.getViewer().getEditPartRegistry();
		//		}

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		if(targetContainer == null) {
			Object group = elementAdapter.getAdapter(EObject.class);
			if(group instanceof EObject) {
				targetContainer = (EObject)group;
			}
		}
		if(targetContainer == null) {
			return CommandResult.newErrorCommandResult("Unable to change the model parent of the object because the system was enable to find the EObject of the parent group");
		}

		for(Iterator<EObject> i = getElementsToMove().keySet().iterator(); i.hasNext();) {
			EObject element = (EObject)i.next();
			EReference feature = getTargetFeature(element);
			if(feature != null && targetContainer.eClass().getEAllReferences().contains(feature)) {
				if(feature.isMany()) {
					@SuppressWarnings("rawtypes")
					Collection coll = (Collection)targetContainer.eGet(feature);
					coll.add(element);
				} else {
					targetContainer.eSet(feature, element);
				}
			} else {
				return CommandResult.newErrorCommandResult(EMFTypeCoreMessages.moveElementsCommand_noTargetFeature);
			}
		}

		return CommandResult.newOKCommandResult();
	}

	private Map<EObject, EReference> getElementsToMove() {
		return chilrendToMove;
	}

	protected EReference getTargetFeature(EObject element) {
		EReference feature = (EReference)getElementsToMove().get(element);
		if(feature == null) {
			EReference oldContainmentFeature = element.eContainmentFeature();
			if(getTargetContainer().eClass().getEAllReferences().contains(oldContainmentFeature)) {
				getElementsToMove().put(element, oldContainmentFeature);
				feature = oldContainmentFeature;
			}
		}
		if(feature == null) {
			feature = PackageUtil.findFeature(getTargetContainer().eClass(), element.eClass());
			setTargetFeature(element, feature);
		}

		return feature;
	}

	private EObject getTargetContainer() {
		return targetContainer;
	}

	protected void setTargetFeature(EObject element, EReference targetFeature) {
		getElementsToMove().put(element, targetFeature);
	}



}
