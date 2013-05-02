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

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.common.IAcceleoConstants;
import org.eclipse.acceleo.engine.AcceleoEnginePlugin;
import org.eclipse.acceleo.engine.AcceleoEvaluationException;
import org.eclipse.acceleo.engine.generation.AcceleoEngine;
import org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy;
import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.acceleo.model.mtl.ModuleElement;
import org.eclipse.acceleo.model.mtl.Template;
import org.eclipse.acceleo.model.mtl.resource.AcceleoResourceSetImpl;
import org.eclipse.acceleo.parser.AcceleoParser;
import org.eclipse.acceleo.parser.AcceleoSourceBuffer;
import org.eclipse.acceleo.parser.cst.ModuleImportsValue;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.AcceleoException;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

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
