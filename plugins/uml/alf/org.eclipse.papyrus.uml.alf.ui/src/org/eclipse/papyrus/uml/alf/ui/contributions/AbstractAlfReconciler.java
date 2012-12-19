/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.ui.contributions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

/**
 * A default, abstract reconciliation strategy for Alf.
 * Introduces a new method reconcileWithError, which only adds a textual representation comment to the edit element 
 * 
 * @author CEA LIST - Initial contribution and API 
 *
 */
public abstract class AbstractAlfReconciler implements IXtextEMFReconciler{
	
	protected IGraphicalEditPart graphicalEditPart = null;
	protected String textualRepresentationWithErrors = "" ;

	/**
	 * Adds a textual representation comment to the edit modelObject, if this eObject is a uml Element
	 * 
	 * @param graphicalEditPart
	 * @param modelObject
	 * @param newTextualRepresentation
	 */
	public void reconcileWithError(IGraphicalEditPart graphicalEditPart, EObject modelObject, String newTextualRepresentation) {
		this.graphicalEditPart = graphicalEditPart ;
		Element umlElement = null ;
		if (! (modelObject instanceof Element))
			return ;
		umlElement = (Element)modelObject ;
		this.textualRepresentationWithErrors += newTextualRepresentation ; 
		UpdateElementCommand updateCommand = new UpdateElementCommand(umlElement);
		TransactionalEditingDomain domain = graphicalEditPart.getEditingDomain() ;
		domain.getCommandStack().execute(updateCommand) ;
	}
	
	public abstract void reconcile(EObject modelObject, EObject xtextObject) ;

	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class UpdateElementCommand extends RecordingCommand {

		private Element element;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected void doExecute() {
			Comment textualRepresentation = null ;
			for (Comment comment : element.getOwnedComments()) {
				if (comment.getBody() != null && comment.getBody().startsWith("<<TextualRepresentation>>")) {
					textualRepresentation = comment ;
					break ;
				}
			}
			if (textualRepresentation == null)
				textualRepresentation = element.createOwnedComment() ;
			String commentBody = "<<TextualRepresentation>>" ;
			commentBody += textualRepresentationWithErrors ;
			textualRepresentation.setBody(commentBody) ;
		}

		public UpdateElementCommand(Element element) {
			super(graphicalEditPart.getEditingDomain()) ;
			this.element = element;
		}
	}
	
}
