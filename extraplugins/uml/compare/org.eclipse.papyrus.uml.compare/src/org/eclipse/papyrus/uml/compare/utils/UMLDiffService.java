/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.eclipse.emf.compare.diff.engine.IDiffEngine;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.tools.util.ReflectHelper;
import org.eclipse.papyrus.uml.compare.Activator;

/**
 * 
 * A specific DiffService for the Nested UML Compare Editor
 * @see DiffService
 * @see bug 377154
 */
//TODO ask to EMF-Compare to open their API
public class UMLDiffService {

	private static Method fillRequiredDifferencesMethod = null;

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private UMLDiffService() {
		// prevents instantiation
	}



	/**
	 * Return a diffmodel created using the match model. This implementation is a generic and simple one.
	 * 
	 * @param match
	 *        the matching model
	 * @param threeWay
	 *        <code>True</code> if we're computing a three way comparison, <code>False</code> otherwise.
	 * @return the corresponding diff model
	 */
	public static DiffModel doDiff(MatchModel match, boolean threeWay) {
		//		final IDiffEngine engine = getBestDiffEngine(match);
		final IDiffEngine engine = new UMLDiffEngine(); //TODO verify that it is the correct diff engine for UML
		final DiffModel diff = engine.doDiff(match, threeWay);

		final Collection<AbstractDiffExtension> extensions = DiffService.getCorrespondingDiffExtensions(match);
		for(final AbstractDiffExtension ext : extensions) {
			if(ext != null) {
				ext.visit(diff);
			}
		}

		engine.reset();

		fillRequiredDifferences(diff);

		return diff;
	}

	//TODO write a JUnit test to be sue that the method called reflexively is always available
	private static void fillRequiredDifferences(final DiffModel diff) {
		if(fillRequiredDifferencesMethod == null) {
			try {
				fillRequiredDifferencesMethod = ReflectHelper.getMethod(DiffService.class, "fillRequiredDifferences", new Class<?>[]{ EObject.class });
			} catch (SecurityException e) {
				Activator.log.error(e);
			} catch (NoSuchMethodException e) {
				Activator.log.error(e);
			}
		}
		final Object[] parameters = new Object[1];
		parameters[0] = diff;
		try {
			fillRequiredDifferencesMethod.invoke(null, parameters);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}
	}
}
