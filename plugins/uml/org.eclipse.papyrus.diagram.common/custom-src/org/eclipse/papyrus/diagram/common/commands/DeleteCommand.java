/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.ui.PlatformUI;

// TODO: Auto-generated Javadoc
/**
 * A <DeleteCommand> that deletes a <Collection> of <EObject>s and their associated <Diagram>s.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class DeleteCommand extends AbstractCommonTransactionalCommmand {

	/** The diagrams resource. */
	private Resource diagramsResource = null;

	/** The affected diagrams. */
	private List<Diagram> affectedDiagrams = null;

	/** The active diagram. */
	private Diagram activeDiagram = null;

	/**
	 * Elements to be deleted
	 */
	private Collection<Object> elementsToDelete = null;

	/**
	 * Instantiates a new delete command.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public DeleteCommand(TransactionalEditingDomain domain, String label, List affectedFiles, Collection<Object> elementsToDelete) {
		super(domain, label, affectedFiles);
		this.elementsToDelete = elementsToDelete;
	}

	/**
	 * Gets the affected diagrams.
	 * 
	 * @return the affected diagrams
	 */
	public List<Diagram> getAffectedDiagrams() {
		if (affectedDiagrams == null) {
			affectedDiagrams = new ArrayList<Diagram>();
		}
		return affectedDiagrams;
	}

	/**
	 * Gets the diagrams resource.
	 * 
	 * @return the diagrams resource
	 */
	public Resource getDiagramsResource() {
		return diagramsResource;
	}

	/**
	 * Gets the active diagram.
	 * 
	 * @return the active diagram
	 */
	public Diagram getActiveDiagram() {
		return activeDiagram;
	}

	public Collection<Object> getElementsToDelete() {
		if (elementsToDelete == null) {
			elementsToDelete = Collections.EMPTY_LIST;
		}
		return elementsToDelete;
	}

	/**
	 * Deletes the selected elements. Checks whether the elements to be deleted have any <Diagram>s associated and deletes those <Diagram>s too.
	 * 
	 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
	 */
	@Override
	public CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
		// search for affected <Diagram>s if elements in collection are deleted
		for (Object object : getElementsToDelete()) {
			if (object instanceof IGraphicalEditPart) {
				object = ((IGraphicalEditPart) object).resolveSemanticElement();
			}
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				for (Diagram diagram : MDTUtil.getDiagramsInHierarchy(eObject, null)) {
					if (getAffectedDiagrams().contains(diagram) == false) {
						getAffectedDiagrams().add(diagram);
					}
				}
			}
		}
		// if there's any <Diagram> affected, prompt the user
		boolean performDelete = true;
		if (getAffectedDiagrams().size() > 0) {
			String message = createMessage(getAffectedDiagrams());
			performDelete = MessageDialog.openConfirm(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Some diagrams will be deleted", message);
		}
		// if the user agrees or there are no affected <Diagram>s, delete all
		// affected <Diagram>s and perform default delete
		if (performDelete) {
			// if the active <Diagram> is to be deleted, we must have another
			// <Diagram> to open
			Diagram diagramToOpen = null;
			boolean checkActiveDiagram = false;
			if (getAffectedDiagrams().size() > 0) {
				// CompoundCommand cc = new CompoundCommand("Delete diagrams");
				for (Diagram diagram : getAffectedDiagrams()) {
					diagramsResource = diagram.eResource();
					if (MultiDiagramUtil.isDiagramActive(diagram)) {
						diagramToOpen = MultiDiagramUtil.getUpperDiagram(diagram);
						checkActiveDiagram = true;
						activeDiagram = diagram;
						break;
					}
				}
				// if the diagram to open is to be deleted, look for one that
				// won't be deleted
				while (diagramToOpen != null && getAffectedDiagrams().contains(diagramToOpen)) {
					diagramToOpen = MultiDiagramUtil.getUpperDiagram(diagramToOpen);
				}
				// not ready to delete diagrams; all delete aborted
				if (checkActiveDiagram && diagramToOpen == null) {
					errorActiveDiagram();
					getAffectedDiagrams().clear();
					return CommandResult.newErrorCommandResult("No diagram to open");
				}
				// open new diagram
				if (diagramToOpen != null) {
					try {
						MultiDiagramUtil.openDiagram(diagramToOpen);
					} catch (ExecutionException ex) {
						IStatus status = new Status(IStatus.ERROR, Activator.ID, "Cannot open diagram: " + ex.getLocalizedMessage());
						Activator.getDefault().getLog().log(status);
						return CommandResult.newErrorCommandResult("Cannot open diagram");
					}
				}
				// all ready, delete affected diagrams
				for (Diagram diagram : getAffectedDiagrams()) {
					MultiDiagramUtil.deleteDiagramFromResource(diagram, diagram.eResource());
				}
				// close affected diagrams, if was opened
				for (Diagram diagram : getAffectedDiagrams()) {
					MultiDiagramUtil.closeEditorsThatShowDiagram(diagram);
				}
			}
			// delete elements
			Request request = new EditCommandRequestWrapper(new DestroyElementRequest(getEditingDomain(), false));
			CompoundCommand cc = new CompoundCommand("Remove elements");
			for (Object object : getElementsToDelete()) {
				if (object instanceof IGraphicalEditPart) {
					Command command = ((IGraphicalEditPart) object).getCommand(request);
					cc.add(command);
				} else if (object instanceof EObject) {
					Command command = new EMFtoGEFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(), Collections.singletonList(object)));
					cc.add(command);
				}
			}
			if (cc.canExecute()) {
				cc.execute();
			}
			return CommandResult.newOKCommandResult();
		} else {
			return CommandResult.newErrorCommandResult("Cannot delete elements");
		}
	}

	/**
	 * Undo must reopen the last active diagram.
	 */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = super.doUndo(monitor, info);
		// in case we changed diagrams when the delete occurred, we'll return to
		// that diagram.
		if (getActiveDiagram() != null) {
			try {
				MultiDiagramUtil.openDiagram(getActiveDiagram());
			} catch (ExecutionException ex) {
				IStatus logStatus = new Status(IStatus.ERROR, Activator.ID, "Cannot open diagram: " + ex.getLocalizedMessage());
				Activator.getDefault().getLog().log(logStatus);
			}
		}
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.CompoundCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		boolean needsResource = getAffectedDiagrams().size() > 0;
		return super.canUndo() && (needsResource ? getDiagramsResource() != null : true);
	}

	/**
	 * Creates the message.
	 * 
	 * @param diagrams
	 *            the diagrams
	 * 
	 * @return the string
	 */
	protected String createMessage(List<Diagram> diagrams) {
		if (diagrams.size() <= 0) {
			return "Some diagrams will be deleted";
		}
		if (diagrams.size() == 1) {
			return "This diagram:\n\t" + MDTUtil.getDiagramName(diagrams.get(0)) + "\nwill be deleted";
		}
		String message = "These diagrams: ";
		Iterator<Diagram> iterator = diagrams.iterator();
		message += "\n\t" + MDTUtil.getDiagramName(iterator.next());
		while (iterator.hasNext()) {
			message += ",\n\t" + MDTUtil.getDiagramName(iterator.next());
		}
		message += "\nwill be deleted";
		return message;
	}

	/**
	 * A message that informs the user that the elements can't be deleted.
	 */
	protected void errorActiveDiagram() {
		MessageDialog.openInformation(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Cannot delete elements", "A root active Diagram would be deleted");
	}
}
