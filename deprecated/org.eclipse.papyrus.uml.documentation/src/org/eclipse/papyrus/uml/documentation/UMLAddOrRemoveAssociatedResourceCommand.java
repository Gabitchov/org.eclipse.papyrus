/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.documentation;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.documentation.profile.IUMLDocumentationConstants;
import org.eclipse.papyrus.views.documentation.IDocumentationChangedListener;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

@SuppressWarnings("unchecked")
public class UMLAddOrRemoveAssociatedResourceCommand extends AbstractCommand {

	private Element element;

	private Comment documentationComment = null;

	private Stereotype documentationStereotype = null;

	private Set<IDocumentationChangedListener> documentationChangedListeners;

	private boolean remove;

	private String resourceURIString;

	public UMLAddOrRemoveAssociatedResourceCommand(boolean remove, Element element, URI resourceURI, Set<IDocumentationChangedListener> documentationChangedListeners) {
		super(org.eclipse.papyrus.views.documentation.Messages.AddOrRemoveAssociatedResourceCommandLabel);
		this.remove = remove;
		this.element = element;
		this.resourceURIString = resourceURI.toString();
		this.documentationChangedListeners = documentationChangedListeners;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void execute() {
		EList<Comment> ownedComments = element.getOwnedComments();

		for(Comment comment : ownedComments) {
			documentationStereotype = comment.getAppliedStereotype(IUMLDocumentationConstants.STEREOTYPE_QUALIFIED_NAME);
			if(documentationStereotype != null) {
				documentationComment = comment;
				break;
			}
		}

		redo();
	}

	private void notifyListeners() {
		for(IDocumentationChangedListener listener : documentationChangedListeners) {
			listener.documentationChanged(element);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void redo() {
		if (remove) {
			removeAssociatedResource();
		} else {
			addAssociatedResource();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		if (remove) {
			addAssociatedResource();
		} else {
			removeAssociatedResource();
		}
	}

	private void removeAssociatedResource() {
		if(documentationStereotype != null && documentationComment != null) {
			List<String> resourceURIs = (List<String>)documentationComment.getValue(documentationStereotype, IUMLDocumentationConstants.RESOURCE_PROPERTY_NAME);
			resourceURIs.remove(resourceURIString);
			notifyListeners();
		}
	}

	private void addAssociatedResource() {
		if(documentationStereotype != null && documentationComment != null) {
			List<String> resourceURIs = (List<String>)documentationComment.getValue(documentationStereotype, IUMLDocumentationConstants.RESOURCE_PROPERTY_NAME);
			resourceURIs.add(resourceURIString);
			notifyListeners();
		}
	}
}
