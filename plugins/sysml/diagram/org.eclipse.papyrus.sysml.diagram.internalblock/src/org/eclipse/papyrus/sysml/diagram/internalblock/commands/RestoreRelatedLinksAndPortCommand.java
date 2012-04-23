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
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.commands;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.FixPortsLocationOnOpening;
import org.eclipse.papyrus.sysml.diagram.internalblock.utils.RestoreElementHelper;
import org.eclipse.papyrus.uml.diagram.common.requests.ArrangeAffixedNodeRequest;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;
import org.eclipse.papyrus.uml.diagram.common.util.functions.EObjectToViewFunction;
import org.eclipse.papyrus.uml.diagram.common.util.functions.SettingToEObjectFunction;
import org.eclipse.papyrus.uml.diagram.common.util.predicates.ReferencingViewPredicate;

import com.google.common.collect.Iterables;

/**
 * Command to restore related links and port of the selection
 */
public class RestoreRelatedLinksAndPortCommand extends AbstractTransactionalCommand {

	/**
	 * Selection
	 */
	protected List<? extends IAdaptable> adapters;

	/**
	 * Containing diagram
	 */
	protected Diagram diagram;

	/**
	 * Diagram edit part
	 */
	protected DiagramEditPart hostDiagram;

	/**
	 * Constructor
	 * 
	 * @param diagramEditPart
	 *        Diagram edit part
	 * @param selection
	 */
	public RestoreRelatedLinksAndPortCommand(DiagramEditPart diagramEditPart, List<? extends IAdaptable> selection) {
		super(diagramEditPart.getEditingDomain(), "Restore related links", null);
		this.hostDiagram = diagramEditPart;
		this.diagram = hostDiagram.getDiagramView();
		this.adapters = selection;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// To register all EditPart in the global visualIDRegistry
		host().refresh();
		for(Object object : adapters) {
			View view = getSelectectedView(object);
			IGraphicalEditPart host = getGraphicalEditPartHost(object);
			if(view != null && host != null) {
				/*
				 * Restore child node elements
				 */
				RestoreElementHelper.restoreRelatedPort(view, host, hostDiagram);
				/*
				 * Restore links
				 * Restore link from the node and it's child
				 */
				RestoreElementHelper.restoreRelatedLinks(view, hostDiagram);
				/*
				 * Arrange port location
				 */
				Command arrangeCommand = host.getCommand(new ArrangeAffixedNodeRequest());
				if(arrangeCommand != null && arrangeCommand.canExecute()) {
					CommandUtil.executeCommand(arrangeCommand, host);
					host.addNotify();
				}
				/**
				 * Fix port location
				 */
				FixPortsLocationOnOpening fixer = new FixPortsLocationOnOpening();
				fixer.fix(getHostDiagram(hostDiagram));
			}
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * get the {@link Diagram} element from its edit part
	 * 
	 * @param hostDiagram
	 * @return
	 */
	protected static Diagram getHostDiagram(DiagramEditPart hostDiagram) {
		if(hostDiagram != null) {
			View notationView = hostDiagram.getNotationView();
			if(notationView instanceof Diagram) {
				return (Diagram)notationView;
			}
		}
		return null;
	}

	/**
	 * get the first referencing view of the elemnt which is in the diagram passed in argument
	 * 
	 * @param element
	 * @param diag
	 * @return
	 */
	public static View getFirstReferencingView(EObject element, Diagram diag) {
		Resource eResource = element.eResource();
		if(eResource != null) {
			ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eResource.getResourceSet());
			if(adapter == null) {
				adapter = new ECrossReferenceAdapter();
			}
			Collection<Setting> inverseReferences = adapter.getInverseReferences(element);
			Iterable<EObject> settings = Iterables.transform(inverseReferences, new SettingToEObjectFunction());
			Iterable<EObject> eObjects = Iterables.filter(settings, new ReferencingViewPredicate(element));
			Iterable<View> views = Iterables.transform(eObjects, new EObjectToViewFunction());
			Iterator<View> ite = views.iterator();
			/*
			 * Take the first view which in the in the diagram
			 */
			while(ite.hasNext()) {
				View v = ite.next();
				if(EcoreUtil.isAncestor(diag, v)) {
					return v;
				}
			}
		}
		return null;
	}

	/**
	 * Get the referencing view of an element
	 * 
	 * @param element
	 * @return
	 */
	public Iterable<View> getReferencingView(EObject element) {
		Resource eResource = element.eResource();
		if(eResource != null) {
			ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eResource.getResourceSet());
			if(adapter == null) {
				adapter = new ECrossReferenceAdapter();
			}
			Collection<Setting> inverseReferences = adapter.getInverseReferences(element);
			Iterable<EObject> settings = Iterables.transform(inverseReferences, new SettingToEObjectFunction());
			Iterable<EObject> eObjects = Iterables.filter(settings, new ReferencingViewPredicate(element));
			Iterable<View> views = Iterables.transform(eObjects, new EObjectToViewFunction());
			return views;
		}
		return Collections.emptyList();
	}

	/**
	 * @param object
	 * @return IGraphicalEditPart of the host
	 */
	private IGraphicalEditPart getGraphicalEditPartHost(Object object) {
		if(object instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)object;
		}
		return null;
	}

	/**
	 * return all selected views
	 * 
	 * @param object
	 * @return
	 */
	private View getSelectectedView(Object object) {
		View v = null;
		if(object instanceof IAdaptable) {
			IAdaptable ad = (IAdaptable)object;
			View view = (View)ad.getAdapter(View.class);
			if(view != null) {
				v = view;
			}
		} else if(object instanceof View) {
			v = (View)object;
		}
		return v;
	}

	/**
	 * @return <code>(IGraphicalEditPart)host()</code>.
	 */
	protected final IGraphicalEditPart host() {
		return hostDiagram;
	}
}
