/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.provider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLStereotypePropertyAxisManager;
import org.eclipse.papyrus.uml.tools.providers.UMLStereotypePropertyContentProvider;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Restricted Content Provider for the properties of Stereotypes
 * 
 * @author JC236769
 * 
 */
public class UMLStereotypeRestrictedPropertyContentProvider extends UMLStereotypePropertyContentProvider implements IRestrictedContentProvider {

	private boolean isRestricted;

	private UMLStereotypePropertyAxisManager umlStereotypePropertyManager;

	public UMLStereotypeRestrictedPropertyContentProvider(UMLStereotypePropertyAxisManager umlStereotypePropertyManager, List<Profile> profiles) {
		super(profiles);
		this.umlStereotypePropertyManager = umlStereotypePropertyManager;
	}

	public void setRestriction(boolean isRestricted) {
		this.isRestricted = isRestricted;
	}

	/**
	 * 
	 * @return
	 *         the other axis provider
	 */
	protected AbstractAxisProvider getOtherAxisProvider() {
		AbstractAxisProvider currentProvider = this.umlStereotypePropertyManager.getRepresentedContentProvider();
		if(currentProvider == this.umlStereotypePropertyManager.getTableManager().getVerticalAxisProvider()) {
			return this.umlStereotypePropertyManager.getTableManager().getHorizontalAxisProvider();
		} else {
			return this.umlStereotypePropertyManager.getTableManager().getVerticalAxisProvider();
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLStereotypePropertyContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Profile) {
			Profile profile = (Profile)parentElement;
			Set<Stereotype> restrictedStereotypes = new HashSet<Stereotype>();
			if(this.isRestricted && !profile.getOwnedStereotypes().isEmpty()) {
				AbstractAxisProvider otherAxisProvider = getOtherAxisProvider();
				final List<Object> elementsList = this.umlStereotypePropertyManager.getTableManager().getElementsList(otherAxisProvider);
				for(Object object : elementsList) {
					if(object instanceof Element) {
						Element typedElement = (Element)object;
						EList<Stereotype> appliedStereotypes = typedElement.getAppliedStereotypes();
						restrictedStereotypes.addAll(appliedStereotypes);
					}
				}
				Set<Stereotype> superSte = new HashSet<Stereotype>();
				for(Stereotype ste : restrictedStereotypes) {
					for(final Classifier classifier : ste.getGenerals()) {
						if(classifier instanceof Stereotype) {
							superSte.add((Stereotype)classifier);
						}
					}
				}
				restrictedStereotypes.addAll(superSte);
				List<Stereotype> toReturn = new ArrayList<Stereotype>(profile.getOwnedStereotypes());
				List<Stereotype> toRemove = new ArrayList<Stereotype>();
				for(Object object : toReturn) {
					if(object instanceof Stereotype) {
						Stereotype stereotype = (Stereotype)object;
						if(!restrictedStereotypes.contains(stereotype)) {
							toRemove.add(stereotype);
						}

					}
				}
				toReturn.removeAll(toRemove);
				return toReturn.toArray();
			}
			Object[] children = super.getChildren(parentElement);
			return children;
		}
		Object[] children = super.getChildren(parentElement);
		return children;

	}

}
