/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ansgar Radermacher - ansgar.radermacher@cea.fr CEA LIST - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.papyrus.texteditor.cdt;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

/**
 * Collection of utility operations that are used by the CDT editor.
 */
public class Utils {

	public static final String nsSep = "::";  //$NON-NLS-1$
	
	/**
	 * Decrease the indentation of a text block. This function is used during synchronization, since
	 * the code within an opaque behavior is not indented, whereas the code of an operation within a
	 * file is indented with a tab. 
	 */
	public static String decreaseIndent(char[] contents, int start, int end) {
		String newBlock = ""; //$NON-NLS-1$
		boolean newLine = true;
		int consume = 0;
		for(int i = start; i < end; i++) {
			char c = contents[i];

			// consume either a tab or 4 spaces;
			if(newLine && (c == '\t')) {
				consume = 1;
			}
			if(newLine && (c == ' ')) {
				consume = 4;
			}

			if(consume == 0) {
				newBlock += c;
			}
			else if(c == ' ') {
				consume--;
			}
			else {
				consume = 0;
			}
			if((c == '\n') || (c == '\r')) {
				newLine = true;
			}
			else {
				newLine = false;
			}
		}
		return newBlock;
	}

	/**
	 * Get an element via its qualified name. Will find elements from the root
	 * model and elements in imported models. Also supports target model in
	 * which imports have been copied (while keeping the top-level name)
	 * 
	 * @param root
	 * @param qualifiedName
	 * @return
	 */
	public static NamedElement getQualifiedElement(Package root,
		String qualifiedName) {
		NamedElement namedElement = null;
		int index = qualifiedName.indexOf(nsSep);
		if(index != -1) {
			// first try using a path without top element (since
			// getQualifiedElement is typically used for
			// imported elements)
			String remainder = qualifiedName.substring(index + 2);
			namedElement = getQualifiedElement(root, remainder, qualifiedName);
		}
		if(namedElement == null) {
			// try with complete name as path name, but assume that the element
			// has been copied into the model,
			// i.e. qualifiedName is prefixed by model name
			namedElement = getQualifiedElement(root, qualifiedName,
				root.getName() + nsSep + qualifiedName);
		}
		return namedElement;
	}

	/**
	 * Retrieve an element via its qualified name within a package The segments
	 * of the package may be non unique due to imports
	 * 
	 * @return the found element, if it exists
	 */
	public static NamedElement getQualifiedElement(Package root,
		String remainingPath, String qualifiedName) {
		if(root == null) {
			return null;
		}
		if(!remainingPath.contains(nsSep)) {
			for(NamedElement candidate : root.getMembers()) {
				String name = candidate.getName();
				if((name != null) && name.equals(remainingPath)) {
					if(candidate.getQualifiedName().equals(qualifiedName)) {
						return candidate;
					}
				}
			}
		} else {
			String segment = remainingPath.split(nsSep)[0];
			String remainder = remainingPath.substring(segment.length() + 2);
			for(Element element : root.getMembers()) {
				if(element instanceof Package) {
					if(((NamedElement)element).getName().equals(segment)) {
						NamedElement foundElement = getQualifiedElement(
							(Package)element, remainder, qualifiedName);
						// return, if not found
						if(foundElement != null) {
							return foundElement;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * return the top-level owner of an element. This function returns the same
	 * value as getModel, if the top-level element is a model. While this is the
	 * case for models, model libraries have a top-level package (not a model).
	 * In this case, getTop returns the top-level package whereas getModel would
	 * return null.
	 * 
	 * @param element
	 * @return the top-level owning package
	 */
	public static Package getTop(Element element) {
		while(element != null) {
			Element owner = element.getOwner();
			if(owner == null) {
				if(element instanceof Package) {
					return (Package)element;
				}
			}
			element = owner;
		}
		return null;
	}
}
