/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.widgets;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.views.modelexplorer.widgets.MetaclassContentProvider;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;



public class StereotypeContentProvider extends MetaclassContentProvider {

	public StereotypeContentProvider(Object type, List<Object> metaclassNotWanted) {
		super(type, metaclassNotWanted);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof EPackage) {
			return super.getElements(inputElement);
		}

		if(type == null) {
			return new Object[0];
		}
		//Type : Stereotype or EClass
		if(!(type instanceof Stereotype || type instanceof EClass)) {
			return new Object[0];
		}

		Profile profile;
		if(inputElement instanceof Profile) {
			profile = (Profile)inputElement;
		} else {
			return new Object[0];
		}

		List<Stereotype> result = new LinkedList<Stereotype>();
		result.addAll(profile.getOwnedStereotypes());
		result.removeAll(metaclassNotWanted);

		Collections.sort(result, new NamedElementComparator());

		return result.toArray();
	}

}
