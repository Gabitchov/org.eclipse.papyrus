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
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.internal.impl.ProfileImpl;

/**
 * This class is used to create a containment link view.
 * 
 * 
 */
public class CustomContainmentLinkViewCommand extends CommonDeferredCreateConnectionViewCommand {

	/**
	 * {@inheritDoc}
	 */
	public CustomContainmentLinkViewCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, command);
	}

	/**
	 * {@inheritDoc}
	 */
	public CustomContainmentLinkViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
	}

	/**
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult commandResult = null;

		if(command != null) {

			// 1. *********************************************** Initialization of variable
			Map epRegistry = viewer.getEditPartRegistry();
			IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get((command).getCommandResult().getReturnValue());
			IGraphicalEditPart targetEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));
			IProgressMonitor progressMonitor1 = progressMonitor;

			// 2. *********************************************** Creation of the dashedLine

			//verify that the view of the new element owner exists
			if(sourceEP != null) {

				// 2.1. *********************************************** Initialization of variable
				View targetEditPart = (View)sourceViewAdapter.getAdapter(View.class);
				View sourceEditPart = (View)sourceEP.getParent().getAdapter(View.class);
				PackageableElement targetElement = (PackageableElement)targetEditPart.getElement();
				PackageableElement sourceElement = (PackageableElement)sourceEditPart.getElement();

				// 2.2. *********************************************** Creation of the dashedLine
				/* only if the target EditPart is not contained by a class or only in the case of a DragDrop Request */
				if((targetElement.getOwner() instanceof Model) || (targetElement.getOwner() instanceof Profile)) {

					/* Avoid the fact that two links can be create between the same source and the target */
					if((!(sourceElement.getOwnedElements().contains(targetElement)))) {
						commandResult = super.doExecuteWithResult(progressMonitor1, info, sourceEP, targetEP);
					}


					// 3. *********************************************** Set the source element as the owner of the target element

					if(!(sourceElement.getOwnedElements().contains(targetElement))) {
						/* Set the sourceEditPart owner as the owner of the target editPart */

						if(sourceEP.getParent() instanceof ClassEditPart) {
							org.eclipse.uml2.uml.Class elementt = (org.eclipse.uml2.uml.Class)sourceElement;
							EList<Classifier> listnestedclassifier = elementt.getNestedClassifiers();
							listnestedclassifier.add((Classifier)targetElement);
						}

						if(sourceEP.getParent() instanceof PackageEditPart && !(sourceEP.getParent() instanceof ModelEditPart)) {
							org.eclipse.uml2.uml.Package elementt = (org.eclipse.uml2.uml.Package)sourceElement;
							EList<Package> listnestedpackage = elementt.getNestedPackages();
							listnestedpackage.add((Package)targetElement);
						}
					}

				} else {
					DeleteCommand dc = new DeleteCommand(getEditingDomain(), (View)sourceEP.getModel());
					dc.execute(progressMonitor, info);
				}


			}
		} else {

			// 1. *********************************************** Initialization of variable
			Map epRegistry = viewer.getEditPartRegistry();
			IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get(targetViewAdapter.getAdapter(View.class));
			IGraphicalEditPart targetEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));
			IProgressMonitor progressMonitor1 = progressMonitor;


			// 2. *********************************************** Creation of the dashedLine

			//verify that the view of the new element owner exists
			if(sourceEP != null) {

				// 2.1. *********************************************** Initialization of variable
				View tep = (View)sourceViewAdapter.getAdapter(View.class);
				View sep = (View)sourceEP.getParent().getAdapter(View.class);
				PackageableElement elementTep = (PackageableElement)tep.getElement();
				PackageableElement elementSep = (PackageableElement)sep.getElement();

				// 2.2. *********************************************** Creation of the dashedLine
				/* only if the target EditPart is not contained by a class or only in the case of a DragDrop Request */
				if((elementTep.getOwner() instanceof Model)) {

					/* Avoid the fact that two links can be create between the same source and the target */
					if((!(elementSep.getOwnedElements().contains(elementTep))) || (elementTep.getOwner() instanceof Profile)) {
						commandResult = super.doExecuteWithResult(progressMonitor1, info, sourceEP, targetEP);
					}


					// 3. *********************************************** Set the source element as the owner of the target element
					if(!(elementSep.getOwnedElements().contains(elementTep))) {
						/* Set the sourceEditPart owner as the owner of the target editPart */
						if(sourceEP.getParent() instanceof ClassEditPart) {
							org.eclipse.uml2.uml.Class element = (org.eclipse.uml2.uml.Class)elementSep;
							EList<Classifier> listnestedclassifier = element.getNestedClassifiers();
							listnestedclassifier.add((Classifier)elementTep);
						}
						if(sourceEP.getParent() instanceof PackageEditPart && !(sourceEP.getParent() instanceof ModelEditPart)) {
							org.eclipse.uml2.uml.Package elementt = (org.eclipse.uml2.uml.Package)elementSep;
							EList<Package> listnestedpackage = elementt.getNestedPackages();
							listnestedpackage.add((Package)elementTep);
						}
					}
				}

			}
		}
		return commandResult;
	}

}
