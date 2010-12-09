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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class StereotypeTreeObject is the first-level child of a StereotypedElementTreeObject.
 * It references a certain stereotype that is applied to an object.
 */
public class AppliedStereotypeTreeObject extends ParentTreeObject {

	protected Stereotype stereotype;
	
	/**
	 * The Constructor.
	 * 
	 * @param stereotype
	 *        the stereotype
	 * @param parent
	 *        the parent
	 */
	public AppliedStereotypeTreeObject(StereotypedElementTreeObject parent, Stereotype stereotype) {
		super(parent);
		this.stereotype = stereotype;
	}

	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		Iterator<Property> propIt = getStereotype().getAllAttributes().iterator();
		while(propIt.hasNext()) {
			final Property currentProp = propIt.next();
			// Select authorized properties
			if(currentProp.getAssociation() != null) {
				if(!currentProp.getName().startsWith("base_"))
					addChild(new AppliedStereotypePropertyTreeObject(this, currentProp));
			} else {
				addChild(new AppliedStereotypePropertyTreeObject(this, currentProp));
			}
		}
	}

	/**
	 * Gets the stereotype.
	 * 
	 * @return the stereotype
	 */
	public Stereotype getStereotype() {
		return stereotype;
	}

	/**
	 * Removes me. Only done on tree level (not on model level)
	 */
	public void removeMe() {

		Stereotype stereotype = getStereotype();

		try {
			getParent().removeChild(this);
		} catch (IllegalArgumentException requiredEx) {
			Message.warning((stereotype).getName() + " stereotype is required for this element");
			requiredEx.printStackTrace();
		}
	}

	/**
	 * Move me up. This is first done on model level (@see Util.reoderStereotypeApplications)
	 * then on tree level.
	 */
	public void moveMeUp() {

		StereotypedElementTreeObject rTO = (StereotypedElementTreeObject)getParent();
		Stereotype stereotype = getStereotype();
		Element root = rTO.getElement();

		EList<Stereotype> stereotypes = new BasicEList<Stereotype>();
		stereotypes.addAll(root.getAppliedStereotypes());

		int index = stereotypes.indexOf(stereotype);
		if(index < 1) {
			// Not found or already on top...
			return;
		}

		stereotypes.move(index - 1, stereotype);
		Util.reorderStereotypeApplications(root, stereotypes);
		// Refresh - move tree elements
		getParent().moveChildUp(this);
	}

	/**
	 * Move me down. This is first done on model level (@see Util.reoderStereotypeApplications)
	 * then on tree level.
	 */
	public void moveMeDown() {

		StereotypedElementTreeObject rTO = (StereotypedElementTreeObject)getParent();
		Stereotype stereotype = getStereotype();
		Element root = rTO.getElement();

		EList<Stereotype> stereotypes = new BasicEList<Stereotype> ();
		stereotypes.addAll(root.getAppliedStereotypes());

		int index = stereotypes.indexOf(stereotype);
		if((index == -1) || (index >= stereotypes.size() - 1)) {
			// Not found of already on top...
			return;
		}

		stereotypes.move(index + 1, stereotype);
		Util.reorderStereotypeApplications(root, stereotypes);
		// Refresh - move tree elements
		getParent().moveChildDown(this);
	}
}
