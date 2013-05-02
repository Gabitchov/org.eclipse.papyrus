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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.emf.Activator;

/**
 * An abstract helper to replace references to EObjects (represented by their URI) with a label (related to this EObject).
 * 
 * It is typically used to introduce dynamic references to object's labels in free text areas (e.g. in a description)
 * 
 * The reference can be introduced with {@link #insertReference(EObject, String, int)}
 * 
 * The parsed string can be retrieved with {@link #replaceReferences(String)}
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class TextReferencesHelper {

	public static final String URI_CHARS = "[^#]"; //Almost everything is allowed in a URI. It's simpler to exclude the fragment separator

	public static final String FRAGMENT_CHARS = "[-A-Za-z0-9_/]"; //In Papyrus this is sufficient. Do we need a more complex expression?

	public static final String URI_REGEX = String.format("%s*#%s+", URI_CHARS, FRAGMENT_CHARS); //The base uri is optional. The fragment is required.

	public static String UNKNOWN_ELEMENT = "UNKNOWN"; //Replacement text for unknown elements

	public static String PROXY_ELEMENT = "PROXY"; //Replacement text for proxy elements

	protected Resource baseResource;

	protected ResourceSet resourceSet;

	protected TextReferencesHelper() {
		//Empty
	}

	/**
	 * 
	 * @param baseResource
	 *        The resource against which the link uris will be resolved
	 */
	protected TextReferencesHelper(Resource baseResource) {

		if(baseResource != null) {
			this.baseResource = baseResource;
			this.resourceSet = baseResource.getResourceSet();
		}
	}

	/**
	 * Parses the specified text, and replace all references with their replacement String
	 * 
	 * @param text
	 * @return
	 * 
	 * @see {@link #getReplacement(EObject, String)}
	 */
	public String replaceReferences(String text) {
		if(text == null) {
			return null;
		}

		if("".equals(text)) {
			return text;
		}

		//Javadoc-like @link tag
		String replaceRegex = String.format("\\{@link (%s)(\\|([^}]*))?\\}", URI_REGEX);

		Pattern pattern = Pattern.compile(replaceRegex);
		Matcher matcher = pattern.matcher(text);

		String newText = text;

		while(matcher.find()) {
			String uriToReplace = matcher.group(1); //0 is the full pattern (e.g. {link myUri#myFragment}, 1 is the first group (e.g. myUri#myFragment)
			String cachedValue = matcher.group(3); //group 2 is |CachedValue, group 3 is CachedValue

			String replacement = decorate(getReplacement(uriToReplace, cachedValue));

			newText = matcher.replaceFirst(replacement);
			matcher = pattern.matcher(newText);
		}

		return newText;
	}

	/**
	 * Insert a reference to the given element in the specified text, at the specified position
	 * 
	 * @param toElement
	 *        The element to reference
	 * @param inText
	 *        The text in which the reference must be inserted
	 * @param atPosition
	 *        The position at which the reference must be inserted. 0 is the beginning, while text.length() is the end. For all "invalid" indexes (<0
	 *        and > length()), the reference will be inserted at the end of the string
	 * @return
	 *         The text containing the new reference
	 */
	public String insertReference(EObject toElement, String inText, int atPosition) {
		String result = inText;
		if(inText == null) {
			return null; //No change
		}

		if(toElement == null) {
			return inText; //No change
		}

		//Use a Javadoc-like @link tag
		URI elementURI = EcoreUtil.getURI(toElement);
		if(baseResource != null) {
			URI baseURI = baseResource.getURI();
			if(baseURI != null) {
				elementURI = elementURI.deresolve(baseURI);
			}
		}
		String reference = "{@link " + elementURI + "}"; //The URI is already encoded 

		if(atPosition == 0) {
			return reference + result; //At the beginning
		}

		if(atPosition < 0 || atPosition >= inText.length()) {
			result += reference; //Insert at the end
		} else {
			//Hello, world
			//The whitespace is the character at position 6. Insert the reference at position 7 to add it after the whitespace
			//It will result in Hello, <Replacement>world
			result = inText.substring(0, atPosition); //Include the "afterPosition" character
			result += reference; //Add the reference
			result += inText.substring(atPosition, inText.length()); //Complete the string (Exclude the afterPosition character, as it has already been copied in the first part of the result string)
		}

		return result;
	}

	/**
	 * Adds a (text) decoration to the replacement string.
	 * This can be used for e.g. html-based texts, to add tags around the replaced string
	 * 
	 * The default implementation does nothing.
	 */
	protected String decorate(String text) {
		return text;
	}

	protected String getReplacement(String uriToReplace, String cachedValue) {
		String uri, fragment;

		if(baseResource == null || resourceSet == null || baseResource.getURI() == null) {
			return UNKNOWN_ELEMENT;
		}

		if(uriToReplace.contains("#")) {
			uri = uriToReplace.substring(0, uriToReplace.indexOf('#'));
			fragment = uriToReplace.substring(uriToReplace.indexOf('#') + 1, uriToReplace.length());
		} else {
			return UNKNOWN_ELEMENT;
		}

		URI targetURI;

		URI resourceURI;

		resourceURI = baseResource.getURI();

		targetURI = URI.createURI(uri); //The URI must already be encoded

		targetURI = targetURI.resolve(resourceURI);

		if(targetURI == null) {
			return UNKNOWN_ELEMENT;
		}

		targetURI = targetURI.appendFragment(fragment);

		return getReplacement(targetURI, cachedValue);
	}

	protected String getReplacement(URI uriToReplace, String cachedValue) {
		try {
			EObject targetElement = resourceSet.getEObject(uriToReplace, true);
			return getReplacement(targetElement, cachedValue);
		} catch (Exception ex) {
			//Log the error? If it happens once, it will happen many times (after each refresh). The UNKNOWN keyword may be enough.
			//This error happens when the reference is broken (e.g. an element has been deleted). This is a "normal" behavior
			Activator.log.debug("An error occurred while loading the following URI: " + uriToReplace + ". The reference cannot be replaced");
		}

		return UNKNOWN_ELEMENT;
	}

	protected abstract String getReplacement(EObject elementToReplace, String cachedValue);

}
