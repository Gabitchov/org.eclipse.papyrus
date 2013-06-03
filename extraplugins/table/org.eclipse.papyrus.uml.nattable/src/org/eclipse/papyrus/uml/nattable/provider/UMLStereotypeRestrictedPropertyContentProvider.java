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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLStereotypePropertyAxisManager;
import org.eclipse.papyrus.uml.tools.providers.UMLStereotypePropertyContentProvider;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
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
		if(!(parentElement instanceof Package || parentElement instanceof Stereotype)) {
			return new Object[0];
		}
		final Object[] children = super.getChildren(parentElement);
		if(!isRestricted || !(parentElement instanceof Package)) {
			return children;
		} else {
			//we are restricted so we show only the elements available for the current contents of the table
			final Set<Stereotype> restrictedStereotypes = new HashSet<Stereotype>();
			final AbstractAxisProvider otherAxisProvider = getOtherAxisProvider();
			final List<Object> elementsList = this.umlStereotypePropertyManager.getTableManager().getElementsList(otherAxisProvider);
			for(Object object : elementsList) {
				Object representedElement = AxisUtils.getRepresentedElement(object);
				if(representedElement instanceof Element) {
					restrictedStereotypes.addAll(((Element)representedElement).getAppliedStereotypes());
				}
			}
			final Set<Stereotype> superSte = new HashSet<Stereotype>();
			for(Stereotype ste : restrictedStereotypes) {
				for(final Classifier classifier : ste.getGenerals()) {
					if(classifier instanceof Stereotype) {
						superSte.add((Stereotype)classifier);
					}
				}
			}
			restrictedStereotypes.addAll(superSte);

			final Collection<EObject> toKeep = new HashSet<EObject>();
			toKeep.addAll(restrictedStereotypes);
			for(Stereotype stereotype : restrictedStereotypes) {
				toKeep.addAll(EMFHelper.getContainmentPath(stereotype));
			}
			Collection<Object> returnedValues = new ArrayList<Object>();
			returnedValues.addAll(Arrays.asList(children));
			returnedValues.retainAll(toKeep);
			return returnedValues.toArray();
		}
	}

}
