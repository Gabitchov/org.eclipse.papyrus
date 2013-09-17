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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.xtext.integration;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @author ac221913
 * 
 */
public class InvalidStringUtil {

	public static String ACTION_LANGUAGE_PROFILE_NAME = "ActionLanguage";

	/**
	 * The Action Language profile
	 */
	protected static Profile actionLanguageProfile;

	/**
	 * The TextualRepresentation stereotype (from the Action Language profile)
	 */
	protected static Stereotype textualRepresentationStereotype;

	/**
	 * @param element
	 * @param args
	 * @return
	 */
	public static String getTextualRepresentation(Element element) {
		Comment textualRepresentationComment = getTextualRepresentationComment(element);
		if (textualRepresentationComment == null) {
			return null;
		} else {
			return textualRepresentationComment.getBody();
		}
	}

	/**
	 * @param element
	 * @return
	 */
	public static Comment getTextualRepresentationComment(Element element) {
		Comment textualRepresentationComment = null;
		for (Comment comment : element.getOwnedComments()) {
			if (comment.getBody() != null
					&& isATextualRepresentationComment(comment)) {
				textualRepresentationComment = comment;
			}
		}
		return textualRepresentationComment;
	}

	/**
	 * @param comment
	 * @return
	 */
	public static boolean isATextualRepresentationComment(Comment comment) {
		if (textualRepresentationStereotype != null) {
			return comment.getAppliedStereotypes().contains(
					textualRepresentationStereotype);
		} else {
			// There is a chance to find it if the root model has ActionLanguage
			// profile applied
			// In this case, the stereotype is included in
			// comment.getApplicableStereotypes()
			List<Stereotype> applicableStereotypes = comment
					.getApplicableStereotypes();
			for (int i = 0; i < applicableStereotypes.size()
					&& textualRepresentationStereotype == null; i++) {
				if (applicableStereotypes.get(i).getName()
						.equals("TextualRepresentation")) {
					textualRepresentationStereotype = applicableStereotypes
							.get(i);
				}
			}
		}
		return textualRepresentationStereotype != null;
	}

	/**
	 * @param element
	 * @return
	 */
	public static boolean isActionLanguageProfileApplied(Element element) {
		if (actionLanguageProfile == null) {
			RegisteredProfile registeredActionLanguageProfile = RegisteredProfile
					.getRegisteredProfile(ACTION_LANGUAGE_PROFILE_NAME);
			URI modelUri = registeredActionLanguageProfile.uri;
			Model root = element.getModel();
			Resource modelResource = root.eResource().getResourceSet()
					.getResource(modelUri, true);
			if (modelResource.getContents().get(0) instanceof Profile) {
				actionLanguageProfile = (Profile) modelResource.getContents()
						.get(0);
			}
		}
		List<Profile> appliedProfiles = element.getModel().getAppliedProfiles();
		return appliedProfiles.contains(actionLanguageProfile);
	}

	/**
	 * @param element
	 * @return
	 */
	public static Comment createTextualRepresentationComment(Element element) {
		Comment textualRepresentationComment = element.createOwnedComment();
		if (!isActionLanguageProfileApplied(element)) {
			PackageUtil.applyProfile(
					(org.eclipse.uml2.uml.Package) element.getModel(),
					actionLanguageProfile, true);
		}
		clean();
		// This is just to force retrieval of the textual representation
		// stereotype
		isATextualRepresentationComment(textualRepresentationComment);
		textualRepresentationComment
				.applyStereotype(textualRepresentationStereotype);
		return textualRepresentationComment;
	}

	public static void clean() {
		actionLanguageProfile = null;
		textualRepresentationStereotype = null;
	}
}
