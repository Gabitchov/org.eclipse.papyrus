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
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.documentation;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.uml.documentation.profile.IUMLDocumentationConstants;
import org.eclipse.papyrus.views.documentation.IDocumentationChangedListener;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * A GEF Command use to update documentation using profiled Comment.
 * 
 */
public class UMLChangeDocumentationCommand extends AbstractCommand {

	private Element element;

	private String newComment;

	private String oldComment;

	private Comment documentationComment = null;

	private Stereotype documentationStereotype = null;

	private boolean profileWasAlreadyApplied = false;

	private Set<IDocumentationChangedListener> documentationChangedListeners;

	public UMLChangeDocumentationCommand(Element element, String newDocumentation, Set<IDocumentationChangedListener> documentationChangedListeners) {
		super(org.eclipse.papyrus.views.documentation.Messages.ChangeDocCommandLabel);
		this.element = element;
		this.newComment = newDocumentation;
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

		profileWasAlreadyApplied = element.getNearestPackage().getAppliedProfile(IUMLDocumentationConstants.PROFILE_NAME, true) != null;

		// stores the previous doc
		oldComment = null;

		EList<Comment> ownedComments = element.getOwnedComments();

		for(Comment comment : ownedComments) {
			documentationStereotype = comment.getAppliedStereotype(IUMLDocumentationConstants.STEREOTYPE_QUALIFIED_NAME);
			if(documentationStereotype != null) {
				documentationComment = comment;
				break;
			}
		}

		if(documentationComment != null) {
			oldComment = documentationComment.getBody();
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
		changeDocumentation(newComment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		changeDocumentation(oldComment);
	}

	private IStatus changeDocumentation(String newDoc) {
		if(newDoc != null) {
			if(documentationComment == null) {
				documentationComment = UMLFactory.eINSTANCE.createComment();
				element.getOwnedComments().add(documentationComment);
				applyDocumentationStereotype(documentationComment);
			}

			documentationComment.setBody(newDoc);
		} else {
			removeDocumentation();
		}
		notifyListeners();
		return Status.OK_STATUS;
	}

	private void removeDocumentation() {
		if(documentationComment != null) {
			Stereotype documentationStereotype = documentationComment.getAppliedStereotype(IUMLDocumentationConstants.STEREOTYPE_QUALIFIED_NAME);
			if(documentationStereotype != null) {
				documentationComment.unapplyStereotype(documentationStereotype);
			}
			element.getOwnedComments().remove(documentationComment);
			documentationComment = null;
		}

		// remove profile application if not applied before
		if(!profileWasAlreadyApplied) {
			Profile documentationProfile = element.getNearestPackage().getAppliedProfile(IUMLDocumentationConstants.PROFILE_NAME, true);
			if(documentationProfile != null) {
				element.getNearestPackage().unapplyProfile(documentationProfile);
			}
		}
	}

	public void applyDocumentationStereotype(Comment comment) {

		Profile documentationProfile = element.getNearestPackage().getAppliedProfile(IUMLDocumentationConstants.PROFILE_NAME, true);

		if(documentationProfile == null) {
			ResourceSet rs = null;
			Resource resource = element.eResource();
			if(resource != null) {
				rs = resource.getResourceSet();
			}
			if (rs == null) {
				rs = new ResourceSetImpl();
			}

			Resource papyrusProfileResource = rs.getResource(URI.createURI(IUMLDocumentationConstants.PROFILE_URI), true);

			if(papyrusProfileResource != null && !papyrusProfileResource.getContents().isEmpty() && papyrusProfileResource.getContents().get(0) instanceof Profile) {
				Profile papyrusProfile = (Profile)papyrusProfileResource.getContents().get(0);

				NamedElement possibleDocumentationProfile = papyrusProfile.getMember(IUMLDocumentationConstants.DOCUMENTATION_SUB_PROFILE_NAME);

				if (possibleDocumentationProfile instanceof Profile) {
					documentationProfile = (Profile)possibleDocumentationProfile;
					element.getNearestPackage().applyProfile(documentationProfile);
				}
			}

		}

		if (documentationProfile != null) {
			Stereotype documentationStereotype = documentationProfile.getOwnedStereotype(IUMLDocumentationConstants.STEREOTYPE_NAME);

			if(documentationStereotype != null) {
				comment.applyStereotype(documentationStereotype);
			}
		}
	}

}
