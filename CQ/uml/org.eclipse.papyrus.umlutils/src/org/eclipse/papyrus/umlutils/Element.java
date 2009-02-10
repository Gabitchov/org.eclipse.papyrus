/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * 
 * 
 * 
 * This class represents any UML element
 */
public class Element {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Element uml2Element;

	/**
	 * Commentaire pour <code>name</code>.
	 * 
	 * @param element
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */
	// private String name;
	public Element(org.eclipse.uml2.uml.Element element) {
		uml2Element = element;
	}

	/**
     * 
     */
	public Element() {
		uml2Element = null;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Element.
	 */
	public org.eclipse.uml2.uml.Element getUml2Element() {
		return uml2Element;
	}

	/**
	 * Retrieves the model that contains this element.
	 * 
	 * @return the model that contains this element
	 */
	public org.eclipse.papyrus.umlutils.Model getModel() {
		return new org.eclipse.papyrus.umlutils.Model(uml2Element.getModel());
	}

	/**
	 * Retrieves the model that contains this element.
	 * 
	 * @return the model that contains this element
	 */
	public org.eclipse.papyrus.umlutils.Package getNearestPackage() {
		return new org.eclipse.papyrus.umlutils.Package(uml2Element.getNearestPackage());
	}

	/**
	 * Retrieves the root package from this element.
	 * 
	 * @return the root package.
	 */
	public org.eclipse.uml2.uml.Package getRootPackage() {
		org.eclipse.uml2.uml.Package thePackage = uml2Element.getNearestPackage();
		if (uml2Element.getOwner() != null) {
			Element newElement = new Element(uml2Element.getOwner());
			thePackage = newElement.getRootPackage();
		}
		return thePackage;
	}

	/**
	 * Check if the StereotypedElement has the given stereotype.
	 * 
	 * @param stereotypeName
	 *            The name of the stareotype to find.
	 * 
	 * @return true if the stereotype is found.
	 */
	public boolean hasStereotype(String stereotypeName) {
		boolean has = false;

		if (uml2Element != null) {
			// has = UML20Utils.hasStereotype(uml2Element,stereotypeName);
			Iterator i = uml2Element.getAppliedStereotypes().iterator();
			Stereotype currentStereotype;
			while (i.hasNext() && !has) {
				currentStereotype = (Stereotype) i.next();
				if (currentStereotype.getName().equals(stereotypeName)) {
					has = true;
				}
			}
		}
		return has;
	}

	/**
	 * Toggles the given stereotype for the given model.
	 * 
	 * @param stereotypeName
	 *            The stereotype to set/unset
	 * @param isStereotyped
	 *            true = set stereotype, false = unset stereotype
	 */

	public void toggleStereotype(String stereotypeName, boolean isStereotyped) {
		Stereotype st = this.getApplicableStereotype(stereotypeName);
		if (st != null) {
			if (isStereotyped) {
				if (!uml2Element.isStereotypeApplied(st)) {
					uml2Element.applyStereotype(st);
				}
			} else {
				if (uml2Element.isStereotypeApplied(st)) {
					uml2Element.unapplyStereotype(st);
				}
			}
		} else {
			// Warning stereotype not applicable
		}
	}

	/**
	 * 
	 * 
	 * @param stereotypeName
	 * @param tagName
	 * 
	 * @return
	 */
	public String getTaggedValue(String stereotypeName, String tagName) {
		String tagAsString = "";
		Stereotype st = getAppliedStereotype(stereotypeName);

		if (st == null) {
			return "";
		}

		Object tag = uml2Element.getValue(st, tagName);

		if (tag == null) {
			return "";
		}

		if (tag instanceof NamedElement) {
			tagAsString = ((NamedElement) tag).getName();
		} else if (tag instanceof String) {
			tagAsString = (String) tag;
		} else {
			tagAsString = tag.toString();
		}

		return tagAsString;
	}

	/**
	 * Retrieve obect in taggedValue.
	 * 
	 * @param stereotypeName
	 * @param tagName
	 * 
	 * @return
	 */
	public Object getTaggedValueAsObject(String stereotypeName, String tagName) {
		Object tag = null;
		Stereotype st = getAppliedStereotype(stereotypeName);
		if (st != null) {
			tag = uml2Element.getValue(st, tagName);
		}

		return tag;
	}

	/**
	 * Set the value of a tag.
	 * 
	 * @param stereotypeName
	 *            The stereotype where the tag is defined
	 * @param object
	 *            The element to tag
	 * @param newTagValue
	 *            The value to set
	 * @param tagName
	 *            The name of the tag to set
	 */
	public void setTaggedValue(String stereotypeName, String tagName, Object newTagValue) {

		final Stereotype st = getAppliedStereotype(stereotypeName);

		if (st != null) {
			uml2Element.setValue(st, tagName, newTagValue);
		}
	}

	/**
	 * Gives the comments for this object.
	 * 
	 * @return
	 */
	public String getComments() {
		String comments = "";
		Iterator commentsIterator = uml2Element.getOwnedComments().iterator();
		Comment currentComment;
		while (commentsIterator.hasNext()) {
			currentComment = (Comment) commentsIterator.next();
			comments += currentComment.getBody();
		}
		return comments;
	}

	/**
	 * Get the <code>org.eclipse.uml2.uml.Stereotype</code> with the given name from the current Element.
	 * 
	 * @param stereotypeName
	 *            The name of the stereotype to get.
	 * 
	 * @return A <code>org.eclipse.uml2.uml.Stereotype</code> with the given name or <code>null</code> if none.
	 * 
	 * @deprecated use {@link Element#getApplicableStereotype(String) <em>getApplicableStereotypes(String)</em>} instead
	 */
	@Deprecated
	public Stereotype getStereotype(String stereotypeName) {
		boolean found = false;
		Stereotype currentStereotype = null;

		Iterator i = uml2Element.getApplicableStereotypes().iterator();
		while (i.hasNext() && !found) {
			currentStereotype = (Stereotype) i.next();
			found = (currentStereotype.getName().equals(stereotypeName));
		}
		if (!found) {
			currentStereotype = null;
		}
		return currentStereotype;
	}

	/**
	 * Get the applicable <code>org.eclipse.uml2.uml.Stereotype</code> with the given name for the current Element.
	 * 
	 * @param stereotypeName
	 *            The name of the stereotype to get.
	 * 
	 * @return A <code>org.eclipse.uml2.uml.Stereotype</code> with the given name or <code>null</code> if none.
	 */
	public Stereotype getApplicableStereotype(String stereotypeName) {
		Iterator i = uml2Element.getApplicableStereotypes().iterator();
		boolean found = false;
		Stereotype currentStereotype = null;
		while (i.hasNext() && !found) {
			currentStereotype = (Stereotype) i.next();
			found = (currentStereotype.getName().equals(stereotypeName));
		}
		if (!found) {
			currentStereotype = null;
		}
		return currentStereotype;
	}

	/**
	 * Get the applied <code>org.eclipse.uml2.uml.Stereotype</code> with the given name for the current Element.
	 * 
	 * @param stereotypeName
	 *            The name of the stereotype to get.
	 * 
	 * @return A <code>org.eclipse.uml2.uml.Stereotype</code> with the given name or <code>null</code> if none.
	 */
	public Stereotype getAppliedStereotype(String stereotypeName) {
		Iterator i = uml2Element.getAppliedStereotypes().iterator();
		boolean found = false;
		Stereotype currentStereotype = null;
		while (i.hasNext() && !found) {
			currentStereotype = (Stereotype) i.next();
			found = (currentStereotype.getName().equals(stereotypeName));
		}
		if (!found) {
			currentStereotype = null;
		}
		return currentStereotype;
	}

	/**
	 * Return the shape of the first applied stereotype if it has one else returns null.
	 * 
	 * @return
	 */
	public Image getShape() {

		EList stereotypeList = getUml2Element().getAppliedStereotypes();

		if (stereotypeList.size() < 1) {
			// no applied stereotype
			return null;
		}

		org.eclipse.papyrus.umlutils.Stereotype firstSt = new org.eclipse.papyrus.umlutils.Stereotype((Stereotype) stereotypeList.get(0));

		return firstSt.getShape();
	}

	/**
	 * Return the icon of the first applied stereotype if it has one else returns null.
	 * 
	 * @return
	 */
	public Image getIcon() {

		EList stereotypeList = getUml2Element().getAppliedStereotypes();

		if (stereotypeList.size() < 1) {
			// no applied stereotype
			return null;
		}

		org.eclipse.papyrus.umlutils.Stereotype firstSt = new org.eclipse.papyrus.umlutils.Stereotype((Stereotype) stereotypeList.get(0));

		return firstSt.getIcon();
	}

	/**
	 * Return the icon of the first applied stereotype if it has one else returns null.
	 * 
	 * @return
	 */
	public boolean hasIcon() {

		EList stereotypeList = getUml2Element().getAppliedStereotypes();

		if (stereotypeList.size() < 1) {
			// no applied stereotype
			return false;
		}

		org.eclipse.papyrus.umlutils.Stereotype firstSt = new org.eclipse.papyrus.umlutils.Stereotype((Stereotype) stereotypeList.get(0));

		return firstSt.hasIcon();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean hasShape() {

		EList stereotypeList = getUml2Element().getAppliedStereotypes();

		if (stereotypeList.size() < 1) {
			// no applied stereotype
			return false;
		}

		org.eclipse.papyrus.umlutils.Stereotype firstSt = new org.eclipse.papyrus.umlutils.Stereotype((Stereotype) stereotypeList.get(0));

		return firstSt.hasShape();
	}

	/**
	 * Return the icon name of the first applied stereotype if it has one else returns null.
	 * 
	 * @return the qulified name of the stereotype thaht is associated to this icon
	 */
	public String getIconName() {

		EList stereotypeList = getUml2Element().getAppliedStereotypes();

		if (stereotypeList.size() < 1) {
			// no applied stereotype
			return null;
		}

		org.eclipse.papyrus.umlutils.Stereotype firstSt = new org.eclipse.papyrus.umlutils.Stereotype((Stereotype) stereotypeList.get(0));

		return firstSt.getIconNameForStereotype();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getShapeName() {

		EList stereotypeList = getUml2Element().getAppliedStereotypes();

		if (stereotypeList.size() < 1) {
			// no applied stereotype
			return null;
		}

		org.eclipse.papyrus.umlutils.Stereotype firstSt = new org.eclipse.papyrus.umlutils.Stereotype((Stereotype) stereotypeList.get(0));

		return firstSt.getQualifiedName() + "Shape";
	}

	/**
	 * Refresh string formatted list of stereotypes of current element.
	 * 
	 * @return
	 */
	public String getStereotypes() {

		String stereotypes = "";

		// Particular cases
		if (getUml2Element() instanceof PrimitiveType) {
			stereotypes = "primitiveType, ";
		} else if (getUml2Element() instanceof Enumeration) {
			stereotypes = "enumeration, ";
		} else if (getUml2Element() instanceof DataType) {
			stereotypes = "datatype, ";
		} else if (getUml2Element() instanceof Comment) {
			stereotypes = "comment, ";
		} else if (getUml2Element() instanceof Interface) {
			stereotypes = "interface, ";
		}

		// look for list of stereotypes
		Iterator stListIt = getUml2Element().getAppliedStereotypes().iterator();

		while (stListIt.hasNext()) {
			String name = ((Stereotype) stListIt.next()).getName();
			stereotypes = stereotypes + name.substring(0, 1).toLowerCase() + name.substring(1, name.length()) + ", ";
		}

		if (!(stereotypes.equals(""))) {
			stereotypes = stereotypes.substring(0, stereotypes.length() - 2);
		}

		return stereotypes;
	}

	/**
	 * Convert any String to a valid C identifier (with only alphanumeric characters or underscore an with only an alphabetic character or an underscore as first character of the ID).
	 * <ul>
	 * <b> Conversion rules </b>
	 * <li>Spaces are replaced by underscore.
	 * <li>Special letters (accent...) are replaced by their "simple" version.
	 * <li>Other specials characters are removed.
	 * <li>If the first character is not a letter or an underscore, an underscore is added.
	 * </ul>
	 * 
	 * @param idName
	 *            The String (probably an identifier) to convert.
	 * 
	 * @return the result : a valid C identifier.
	 */
	public String getCorrectCIdentifier(String idName) {
		// TODO might be improved
		String correctName;

		// Spaces are replaced by underscores
		correctName = idName.replace(' ', '_');

		// Special letters are replaced by the simple letter
		correctName = correctName.replaceAll("[??????]", "a");
		correctName = correctName.replaceAll("[??????]", "A");
		correctName = correctName.replaceAll("[????]", "e");
		correctName = correctName.replaceAll("[????]", "E");
		correctName = correctName.replaceAll("[????]", "i");
		correctName = correctName.replaceAll("[????]", "I");
		correctName = correctName.replaceAll("[?????]", "o");
		correctName = correctName.replaceAll("[?????]", "O");
		correctName = correctName.replaceAll("[???]", "u");
		correctName = correctName.replaceAll("[????]", "U");
		correctName = correctName.replaceAll("[??]", "y");
		correctName = correctName.replaceAll("[?]", "Y");
		correctName = correctName.replaceAll("?", "ae");
		correctName = correctName.replaceAll("?", "AE");
		correctName = correctName.replace('?', 'c');
		correctName = correctName.replace('?', 'n');
		correctName = correctName.replace('?', 'C');
		correctName = correctName.replace('?', 'N');

		// Any remaining non alpha numeric character (or underscore) is deleted
		correctName = correctName.replaceAll("[^a-zA-Z0-9_]", "");

		// if the first character is not a letter or an underscore, add an
		// underscore before
		char c = correctName.charAt(0);
		if (!Character.isLetter(c) && (c != '_')) {
			correctName = '_' + correctName;
		}

		return correctName;
	}

}