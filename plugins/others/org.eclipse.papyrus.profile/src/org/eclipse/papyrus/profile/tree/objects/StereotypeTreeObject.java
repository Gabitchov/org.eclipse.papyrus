/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;


//TODO: Auto-generated Javadoc
/**
 * The Class StereotypeTreeObject.
 */
public class StereotypeTreeObject extends ParentTreeObject {

	/**
	 * The Constructor.
	 * 
	 * @param stereotype the stereotype
	 * @param parent the parent
	 */
	public StereotypeTreeObject(RootElementTreeObject parent, Element stereotype) {
		super(parent, stereotype);
	}

	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		Iterator<Property> propIt = getStereotype().getAllAttributes().iterator();		
		while (propIt.hasNext()) {
			final Property currentProp = propIt.next();
			// Select authorized properties
			//if(currentProp.isComposite() || (currentProp.getAssociation() == null)) {
			if(currentProp.getAssociation()!=null){
				if(!currentProp.getName().startsWith("base_"))
					addChild(new PropertyTreeObject(this, currentProp));
			}
			else {
				addChild(new PropertyTreeObject(this, currentProp));
			}
			//}
		}
	}

	/**
	 * Gets the stereotype.
	 * 
	 * @return the stereotype
	 */
	public Stereotype getStereotype() {
		return (Stereotype) element;
	}

	/**
	 * Removes the me.
	 */
	public void removeMe() {

		Element element = getParent().getElement();
		Stereotype stereotype = getStereotype();

		try {			
			element.unapplyStereotype(stereotype);

			getParent().removeChild(this);
			// Force model change
			Util.touchModel(element);
		}
		catch (IllegalArgumentException requiredEx) {
			Message.warning(
					(stereotype).getName()
					+ " stereotype is required for this element");
			requiredEx.printStackTrace();
		}
	}

	/**
	 * Move me up.
	 */
	public void moveMeUp() {

		RootElementTreeObject rTO = (RootElementTreeObject) getParent();
		Stereotype stereotype = getStereotype();
		Element root  = rTO.getElement();

		EList stereotypes = new BasicEList();
		stereotypes.addAll(root.getAppliedStereotypes());

		int index = stereotypes.indexOf(stereotype);
		if (index < 1) {
			// Not found of already on top...
			return;
		}

		stereotypes.move(index - 1, stereotype);
		Util.reorderStereotypeApplications(root, stereotypes);
		// Refresh - move tree elements						
		getParent().moveChildUp(this);
		// Force model change
		Util.touchModel(element);
	}

	/**
	 * Move me down.
	 */
	public void moveMeDown() {

		RootElementTreeObject rTO = (RootElementTreeObject) getParent();
		Stereotype stereotype = getStereotype();
		Element root  = rTO.getElement();

		EList stereotypes = new BasicEList();
		stereotypes.addAll(root.getAppliedStereotypes());

		int index = stereotypes.indexOf(stereotype);
		if ((index == -1) || (index >= stereotypes.size() - 1)) {
			// Not found of already on top...
			return;
		}

		stereotypes.move(index + 1, stereotype);
		Util.reorderStereotypeApplications(root, stereotypes);
		// Refresh - move tree elements						
		getParent().moveChildDown(this);
		// Force model change
		Util.touchModel(element);
	}
}
