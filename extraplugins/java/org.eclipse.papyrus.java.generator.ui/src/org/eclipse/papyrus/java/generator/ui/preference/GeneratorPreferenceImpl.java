/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.ui.preference;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.ui.Activator;

public class GeneratorPreferenceImpl implements GeneratorPreference {

	/**
	 * allow to gather default value
	 */
	private IPreferenceStore store = Activator.getDefault().getPreferenceStore();


	public boolean implementMethodsOfIntefaces() {
		return store.getBoolean(PreferenceConstants.P_IMPLEMENT_METHODS_OF_INTERFACES_AND_ABSTRACT_CLASS);
	}

	public boolean implementMethodsOfAbstractClass() {
		return store.getBoolean(PreferenceConstants.P_IMPLEMENT_METHODS_OF_INTERFACES_AND_ABSTRACT_CLASS);
	}

	public boolean generateGetters() {
		return store.getBoolean(PreferenceConstants.P_GENERATE_GETTERS);
	}

	public boolean generateSetters() {
		return store.getBoolean(PreferenceConstants.P_GENERATE_SETTERS);
	}

	public boolean isPackageToGenerate(String packageQualifiedName) {
		if(packageQualifiedName == null || packageQualifiedName.isEmpty()) {
			return true;
		}

		// gather list of packages :
		String listStr = store.getString(PreferenceConstants.P_FILTER_OF_PACKAGE_NOT_TO_GENERATE);

		// if list of package don't exist, return true
		if(listStr == null || listStr.isEmpty()) {
			return true;
		}

		// gather list in a table
		String[] listPackage = listStr.split(";");

		for(String _package : listPackage) {
			if(_package.equals(packageQualifiedName)) {
				return false;
			}

			// if package have a *, we delete *			
			String packageWithoutStar = _package;
			if(_package.contains("*")) {
				packageWithoutStar = _package.substring(0, _package.indexOf("*") - 1);
			}

			if(packageQualifiedName.contains(packageWithoutStar)) {
				return false;
			}
		}

		// by default, return true
		return true;
	}

	public String genericClassForMultiValue() {
		return store.getString(PreferenceConstants.P_GENERIC_CLASS_FOR_MULTIVALUE);
	}

	public boolean stopOnFirstError() {
		return store.getBoolean(PreferenceConstants.P_STOP_ON_FIRST_ERROR);
	}

}
