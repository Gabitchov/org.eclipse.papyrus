/**
 * Copyright CEA-LIST 2009
 * available under EPL 1.0 licence
 * 
 * This file is part of the Qompass tool chain (www.ec3m.net)
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */

package org.eclipse.papyrus.qompass.designer.core.acceleo;

import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.AcceleoException;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Element;

public class AcceleoDriverWrapper {

	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2) and has additional
	 * imports (currently none).
	 * 
	 * @param template
	 *        The template in string form
	 * @param element
	 *        The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String bind(String templateStr, Element element) throws TransformationException {
		try {
			return AcceleoDriver.evaluate(templateStr, element, null);
		} catch (AcceleoException e) {
			throw new TransformationException(e.getMessage());
		}
	}

	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2) and has additional
	 * imports (currently none).
	 * 
	 * @param template
	 *        The template in string form
	 * @param element
	 *        The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String evaluate(String templateStr, Element element, Object args[]) throws TransformationException {
		try {
			return AcceleoDriver.evaluate(templateStr, element, args);
		} catch (AcceleoException e) {
			throw new TransformationException(e.getMessage());
		}
	}

	/**
     * Evaluate an Acceleo template
     * 
     * @param templateStr
     *        The template in string form
     * @param templateName
     *        name of the template. Used to identify template when errors occur. Must be a legal Acceleo template name, i.e. may only
     *        contain alpha-numerical characters and '_'
     * @param element
     *        The UML element to which the template is applied
     * @param args
     *        an array of arguments that are passed to the template. Each argument
     *        must be either an EObject, a String, an Integer or a Boolean
     *        (TODO: currently not evaluated)
     * @return the evaluated template
     */
	public static String evaluate(String templateStr, String templateName, Element element, Object args[]) throws TransformationException {
		try {
			return AcceleoDriver.evaluate(templateStr, templateName, element, args);
		} catch (AcceleoException e) {
			throw new TransformationException(e.getMessage());
		}
	}
}
