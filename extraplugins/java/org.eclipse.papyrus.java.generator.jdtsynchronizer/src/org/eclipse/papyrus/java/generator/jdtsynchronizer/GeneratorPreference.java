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

package org.eclipse.papyrus.java.generator.jdtsynchronizer;

public interface GeneratorPreference {

	/**
	 * indicate if methods of inherits interfaces must be implement in a class
	 * 
	 * @return
	 */
	public boolean implementMethodsOfIntefaces();

	/**
	 * indicate if methods of inherit abstract class must be implement in a class
	 * 
	 * @return
	 */
	public boolean implementMethodsOfAbstractClass();

	/**
	 * indicate if getters must be create
	 * 
	 * @return
	 */
	public boolean generateGetters();

	/**
	 * indicate if setters must be create
	 * 
	 * @return
	 */
	public boolean generateSetters();

	/**
	 * indicate if a package must be generate
	 * 
	 * @param packageQualifiedName
	 *        package to generate
	 * @return
	 */
	public boolean isPackageToGenerate(String packageQualifiedName);

	/**
	 * 
	 * @return generic class to use for the association * (multi-value)
	 */
	public String genericClassForMultiValue();

}
