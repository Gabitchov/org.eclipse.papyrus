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
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * This class is used to create a containment link view.
 * It construct the link and the semantic transformation the target become an owned element
 * 
 */
public class CustomCreateContainmentLinkCommand extends CommonDeferredCreateConnectionViewCommand {

	private final View sourceView;

	private final View targetView;

	/**
	 * {@inheritDoc}
	 */
	public CustomCreateContainmentLinkCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, command);
		sourceView = null;
		targetView = (View) targetViewAdapter.getAdapter(View.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public CustomCreateContainmentLinkCommand(TransactionalEditingDomain editingDomain, String semanticHint, View source, IAdaptable sourceCircleViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint,
			ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceCircleViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
		sourceView = source;
		targetView = (View) targetViewAdapter.getAdapter(View.class);
	}

	@Override
	public boolean canExecute() {
		// check for proper edit parts, e.g. ClassEditPart, not child
		if (sourceView == null && targetView == null) {
			return false;
		}
		if (sourceView != null) {
			if (sourceView.getElement() == null || false == sourceView.getElement() instanceof Element) {
				return false;
			}
		}
		if (targetView != null) {
			if (targetView.getElement() == null || false == targetView.getElement() instanceof Element) {
				return false;
			}
		}
		Element source = getSourceElement();
		Element target = getTargetElement();
		if (source != null && target != null) {
			return !containsLoop(source, target);
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}
		Map<?, ?> epRegistry = viewer.getEditPartRegistry();
		IGraphicalEditPart targetEP = (IGraphicalEditPart) epRegistry.get(targetViewAdapter.getAdapter(View.class));
		IGraphicalEditPart sourceContainmentCircleEP = getSourceContainmentCircleEP(epRegistry);
		if (sourceContainmentCircleEP == null) {
			return null;
		}
		View targetView = (View) targetViewAdapter.getAdapter(View.class);
		View sourceView = (View) sourceContainmentCircleEP.getParent().getAdapter(View.class);
		PackageableElement targetElement = (PackageableElement) targetView.getElement();
		PackageableElement sourceElement = (PackageableElement) sourceView.getElement();
		EditPart sourceEP = sourceContainmentCircleEP.getParent();
		// only top level classes can serve as a source
		// if(sourceEP instanceof ClassEdiart) {
		if (sourceElement instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class container = (org.eclipse.uml2.uml.Class) sourceElement;
			container.getNestedClassifiers().add((Classifier) targetElement);
			// } else if(sourceEP instanceof PackageEditPart && !(sourceEP instanceof ModelEditPart)) {
		} else if (sourceElement instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Package container = (org.eclipse.uml2.uml.Package) sourceElement;
			container.getPackagedElements().add((PackageableElement) targetElement);
		} else {
			throw new ExecutionException("Invalid source " + sourceEP);
		}
		return super.doExecuteWithResult(progressMonitor, info, sourceContainmentCircleEP, targetEP);
	}

	private boolean containsLoop(Element sourceElement, Element targetElement) {
		if (sourceElement.equals(targetElement)) {
			return true;
		}
		return EcoreUtil.isAncestor(targetElement, sourceElement);
	}

	private IGraphicalEditPart getSourceContainmentCircleEP(Map<?, ?> epRegistry) {
		if (command != null) {
			return (IGraphicalEditPart) epRegistry.get(command.getCommandResult().getReturnValue());
		}
		return (IGraphicalEditPart) epRegistry.get(sourceViewAdapter.getAdapter(View.class));
	}

	private Element getSourceElement() {
		return (Element) sourceView.getElement();
	}

	private Element getTargetElement() {
		return (Element) targetView.getElement();
	}
}
