/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.ShowHideRelatedLinkRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.ShowHideRelatedLinkRequest.ShowHideKind;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.papyrus.uml.diagram.menu.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * 
 * Abstract class for the show/hide related links actions
 * 
 */
public class ShowHideRelatedLinkHandler extends AbstractHandler implements IExecutableExtension {

	/** the current selection */
	protected final List<EditPart> selection = new ArrayList<EditPart>();

	/**
	 * the parameter for this handler
	 */
	private final String parameterID = "showHideRelatedLinkParameter"; //$NON-NLS-1$

	/**
	 * the kind of Show/Hide
	 */
	private ShowHideKind kind;

	/**
	 * 
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if(data instanceof Hashtable<?, ?> && this.parameterID != null) {
			this.kind = ShowHideKind.valueOf((String)((Hashtable<?, ?>)data).get(this.parameterID));
		}
	}

	/**
	 * 
	 * @param ep
	 *        an editPart
	 * @param editPolicyRole
	 *        the wanted edit policy identifier
	 * @return
	 */
	protected boolean hasRequiredEditPolicy(final EditPart ep, final String editPolicyRole) {
		return ep.getEditPolicy(editPolicyRole) != null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Request request = buildRequest();
		final DiagramEditPart diagramEP = DiagramEditPartsUtil.getDiagramEditPart(this.selection.get(0));
		final TransactionalEditingDomain domain = getEditingDomain();
		if(diagramEP != null && domain != null) {
			final Command cmd = diagramEP.getCommand(request);
			domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(cmd));
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the request required to do the action
	 */
	protected Request buildRequest() {
		switch(this.kind) {
		case SHOW_ALL_LINK_IN_DIAGRAM:
			return new ShowHideRelatedLinkRequest(getAllTopSemanticEditParts(), this.kind);
		default:
			return new ShowHideRelatedLinkRequest(this.selection, this.kind);
		}

	}

	/**
	 * 
	 * @return
	 *         the list of all top semantic edit part in the diagram
	 */
	protected Collection<EditPart> getAllTopSemanticEditParts() {
		final DiagramEditPart diagramEP = DiagramEditPartsUtil.getDiagramEditPart(this.selection.get(0));
		return DiagramEditPartsUtil.getAllTopSemanticEditPart(diagramEP);
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		buildSelection();
		final DiagramEditPart diagramEP = DiagramEditPartsUtil.getDiagramEditPart(this.selection.get(0));
		if(this.kind.equals(ShowHideKind.SHOW_ALL_LINK_IN_DIAGRAM)) {
			setBaseEnabled(!getAllTopSemanticEditParts().isEmpty() && hasRequiredEditPolicy(diagramEP, AbstractShowHideRelatedLinkEditPolicy.SHOW_HIDE_RELATED_LINK_ROLE));
		} else {
			setBaseEnabled(!this.selection.isEmpty() && hasRequiredEditPolicy(diagramEP, AbstractShowHideRelatedLinkEditPolicy.SHOW_HIDE_RELATED_LINK_ROLE));
		}
	}

	/**
	 * build the selection with the top edit part of the selected edit parts
	 */
	protected void buildSelection() {
		this.selection.clear();
		final ISelection selection = getSelectionInCurrentEditor();
		if(selection instanceof IStructuredSelection) {
			final Collection<EObject> eobjectsAlreadyManaged = new ArrayList<EObject>();
			final Iterator<?> iter = ((IStructuredSelection)selection).iterator();
			while(iter.hasNext()) {
				final Object current = iter.next();
				if(current instanceof EditPart) {
					final EditPart top = DiagramEditPartsUtil.getTopSemanticEditPart((EditPart)current);
					if(top instanceof IGraphicalEditPart) {
						final EObject currentEObject = EMFHelper.getEObject(top);
						if(!eobjectsAlreadyManaged.contains(currentEObject)) {//to avoid duplicated semantic element
							this.selection.add((IGraphicalEditPart)top);
							eobjectsAlreadyManaged.add(currentEObject);
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @return
	 *         the selection for the current editor
	 */
	public static final ISelection getSelectionInCurrentEditor() {
		final IEditorPart editorPart = EditorHelper.getCurrentEditor();
		if(editorPart != null) {
			final IWorkbenchPartSite site = editorPart.getSite();
			if(site != null) {
				final ISelectionProvider selectionProvider = site.getSelectionProvider();
				if(selectionProvider != null) {
					return selectionProvider.getSelection();
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the editing domain to use or <code>null</code> if not found
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		if(!this.selection.isEmpty()) {
			try {
				return ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(this.selection.get(0));
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}
}
