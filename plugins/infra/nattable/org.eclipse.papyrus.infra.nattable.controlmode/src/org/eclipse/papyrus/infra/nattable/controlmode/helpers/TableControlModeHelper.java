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
package org.eclipse.papyrus.infra.nattable.controlmode.helpers;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;


public class TableControlModeHelper {

	/**
	 * Creates an iterable containing all the Papyrus Tables that are descending from the context.
	 */
	public static Iterable<EObject> createDescendantTablesIterable(EObject context) {

		Set<EObject> result = Sets.newHashSet();

		TreeIterator<EObject> eAllContents = EcoreUtil.getAllProperContents(context, true); // was context.eAllContents().
		Iterator<EObject> contextAndDescendants = Iterators.concat(eAllContents, Iterators.singletonIterator(context));

		/*
		 * Predicate used to keep the usages which are PapyrusTableInstances
		 */
		Predicate<Setting> keepTableInstances = new Predicate<Setting>() {

			public boolean apply(Setting setting) {
				boolean result = true;
				if(setting != null) {
					EObject settingEObject = setting.getEObject();
					result &= settingEObject instanceof Table;
				} else {
					result = false;
				}
				return result;
			}
		};

		/*
		 * Function to get the eObject from a setting
		 */
		Function<Setting, EObject> getEObject = new Function<Setting, EObject>() {

			public EObject apply(Setting input) {
				EObject settingEObject = input.getEObject();
				return settingEObject;
			}

		};

		/*
		 * For the context and his descendants :
		 */
		while(contextAndDescendants.hasNext()) {
			EObject current = contextAndDescendants.next();
			//Usages
			Iterable<Setting> usages = EMFHelper.getUsages(current);
			//Filtering to keep only papyrus table instances.
			Iterable<Setting> tableInstanceSettings = Iterables.filter(usages, keepTableInstances);
			//Getting the eObjects
			Iterable<EObject> papyrusTableInstances = Iterables.transform(tableInstanceSettings, getEObject);
			//Adding all the kept usages.
			Iterables.addAll(result, papyrusTableInstances);
		}

		return result;
	}

}
