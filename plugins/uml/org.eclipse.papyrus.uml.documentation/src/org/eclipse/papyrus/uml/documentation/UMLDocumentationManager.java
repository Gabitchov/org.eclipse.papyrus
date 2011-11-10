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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.documentation.profile.IUMLDocumentationConstants;
import org.eclipse.papyrus.views.documentation.DocumentationUnsupportedException;
import org.eclipse.papyrus.views.documentation.IDocumentationChangedListener;
import org.eclipse.papyrus.views.documentation.IDocumentationManager;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class UMLDocumentationManager implements IDocumentationManager {
	
	private static class UMLDocumentationManagerHolder {

		public static final UMLDocumentationManager instance = new UMLDocumentationManager();
	}

	public static UMLDocumentationManager getInstance() {
		return UMLDocumentationManagerHolder.instance;
	}

	private static Set<IDocumentationChangedListener> documentationChangedListeners = new HashSet<IDocumentationChangedListener>();

	/**
	 * {@inheritDoc}
	 */
	public Command getChangeDocumentationCommand(EObject eObject, String newDocumentation) {
		if (getUnsupportedErrorMessage(eObject) == null) {
			return new UMLChangeDocumentationCommand((Element)eObject, newDocumentation, documentationChangedListeners);
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDocumentation(EObject eObject) throws DocumentationUnsupportedException {
		String errorMsg = getUnsupportedErrorMessage(eObject);
		if (errorMsg == null) {
			EList<Comment> ownedComments = ((Element)eObject).getOwnedComments();

			for(Comment comment : ownedComments) {
				if(comment.getAppliedStereotype(IUMLDocumentationConstants.STEREOTYPE_QUALIFIED_NAME) != null) {
					return comment.getBody();
				}
			}
			return null;
		} else {
			throw new DocumentationUnsupportedException(errorMsg);
		}
	}

	@SuppressWarnings("unchecked")
	public List<URI> getAssociatedResources(EObject eObject) throws DocumentationUnsupportedException {
		String errorMsg = getUnsupportedErrorMessage(eObject);
		if (errorMsg == null) {
			List<URI> URIs = new LinkedList<URI>();
			EList<Comment> ownedComments = ((Element)eObject).getOwnedComments();

			for(Comment comment : ownedComments) {
				Stereotype docStereotype = comment.getAppliedStereotype(IUMLDocumentationConstants.STEREOTYPE_QUALIFIED_NAME);
				if(docStereotype != null) {
					List<String> stringURIs = (List<String>)comment.getValue(docStereotype, IUMLDocumentationConstants.RESOURCE_PROPERTY_NAME);
					for (String stringURI : stringURIs) {
						URIs.add(URI.createURI(stringURI));
					}
				}
			}
			return URIs;
		} else {
			throw new DocumentationUnsupportedException(errorMsg);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void registerDocumentationChangedListener(IDocumentationChangedListener listener) {
		documentationChangedListeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void unregisterDocumentationChangedListener(IDocumentationChangedListener listener) {
		documentationChangedListeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<IDocumentationChangedListener> getRegisteredDocumentationChangedListeners() {
		return documentationChangedListeners;
	}

	/**
	 * get an error message if eObject is unsupported by this implementation
	 * @param eObject
	 * @return null if documentation is supported or an error message if not
	 */
	private static String getUnsupportedErrorMessage(EObject eObject) {
		// can't have a documentation on a documentation comment
		if(eObject instanceof Comment && ((Comment)eObject).getAppliedStereotype(IUMLDocumentationConstants.STEREOTYPE_QUALIFIED_NAME) != null) {
			return Messages.UMLDocumentationManager_DocOnDocCommentError;
		} else if(eObject instanceof Element) {
			// OK, return null
			return null;
		} else {
			return Messages.UMLDocumentationManager_NonUMLElementError;
		}
	}

	public Command getAddAssociatedResourceCommand(EObject eObject, URI resourceURI) {
		if (getUnsupportedErrorMessage(eObject) == null) {
			return new UMLAddOrRemoveAssociatedResourceCommand(false, (Element)eObject, resourceURI, documentationChangedListeners);
		} else {
			return null;
		}
	}

	public Command getRemoveAssociatedResourceCommand(EObject eObject, URI resourceURI) {
		if (getUnsupportedErrorMessage(eObject) == null) {
			return new UMLAddOrRemoveAssociatedResourceCommand(true, (Element)eObject, resourceURI, documentationChangedListeners);
		} else {
			return null;
		}
	}
}
