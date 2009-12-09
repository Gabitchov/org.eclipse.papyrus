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
 *  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import java.util.Map;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class is used to create a connection view.
 * 
 * 
 */
public class CustomDeferredCreateConnectionViewCommand extends CommonDeferredCreateConnectionViewCommand {

	/**
	 * {@inheritDoc}
	 */
	public CustomDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, command);
	}

	/**
	 * {@inheritDoc}
	 */
	public CustomDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
	}

	/**
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult commandResult = null;

		if(command != null) {

			Map epRegistry = viewer.getEditPartRegistry();

			IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get((command).getCommandResult().getReturnValue());
			IGraphicalEditPart targetEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));
			IProgressMonitor progressMonitor1 = progressMonitor;
			View tep = (View)sourceViewAdapter.getAdapter(View.class);
			Classifier elementtep = (Classifier)tep.getElement();

			View sep = (View)sourceEP.getParent().getAdapter(View.class);
			Classifier elementsep = (Classifier)sep.getElement();
			/* only if the target EditPart is not contained by a class or only in the case of a DragDrop Request */
			if((elementtep.getOwner() instanceof Model) || (command.getLabel().equals("DragDrogContainmentViewCommand"))) {

				/* Avoid the fact that two links can be create between the same source and the target */
				if((!(elementsep.getOwnedElements().contains(elementtep))) || (command.getLabel().equals("DragDrogContainmentViewCommand"))) {
					commandResult = super.doExecuteWithResult(progressMonitor1, info, sourceEP, targetEP);
				}

				/* Set the sourceEditPart owner as the owner of the target editPart */
				if(sep.getType().equals("2008")) {
					org.eclipse.uml2.uml.Class elementt = (org.eclipse.uml2.uml.Class)elementsep;
					EList<Classifier> listnestedclassifier = elementt.getNestedClassifiers();
					listnestedclassifier.add(elementtep);
				}
			} else {
				DeleteCommand dc = new DeleteCommand(getEditingDomain(), (View)sourceEP.getModel());
				dc.execute(progressMonitor, info);
			}

		} else {

			Map epRegistry = viewer.getEditPartRegistry();

			IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get(targetViewAdapter.getAdapter(View.class));
			IGraphicalEditPart targetEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));
			IProgressMonitor progressMonitor1 = progressMonitor;
			View tep = (View)sourceViewAdapter.getAdapter(View.class);
			Classifier elementtep = (Classifier)tep.getElement();

			View sep = (View)sourceEP.getParent().getAdapter(View.class);
			Classifier elementsep = (Classifier)sep.getElement();

			/* only if the target EditPart is not contained by a class or only in the case of a DragDrop Request */
			if((elementtep.getOwner() instanceof Model) || (command.getLabel().equals("DragDrogContainmentViewCommand"))) {

				/* Avoid the fact that two links can be create between the same source and the target */
				if((!(elementsep.getOwnedElements().contains(elementtep))) || (command.getLabel().equals("DragDrogContainmentViewCommand"))) {
					commandResult = super.doExecuteWithResult(progressMonitor1, info, sourceEP, targetEP);
				}

				/* Set the sourceEditPart owner as the owner of the target editPart */
				if(sep.getType().equals("2008")) {
					org.eclipse.uml2.uml.Class elementt = (org.eclipse.uml2.uml.Class)elementsep;
					EList<Classifier> listnestedclassifier = elementt.getNestedClassifiers();
					listnestedclassifier.add(elementtep);
				}
			}

		}
		return commandResult;
	}

}
