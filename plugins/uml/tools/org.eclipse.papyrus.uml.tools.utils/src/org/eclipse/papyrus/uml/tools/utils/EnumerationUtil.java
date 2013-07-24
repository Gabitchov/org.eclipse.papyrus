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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * 
 * This class provides utilities for Enum
 * 
 */
public class EnumerationUtil {


	private EnumerationUtil() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @param enumeration
	 *        the uml enumeration
	 * @param enumerator
	 *        the enumerator to adapt to a uml EnumerationLiteral
	 * @return
	 */
	public static final EnumerationLiteral findEnumerationLiteral(final Enumeration enumeration, final Enumerator enumerator) {
		final EnumerationLiteral lit = enumeration.getOwnedLiteral(enumerator.getLiteral());
		if(lit != null) {
			return lit;
		}
		Activator.log.error(NLS.bind("The EnumerationLiteral for {0} has not been found", enumerator), new NullPointerException()); //$NON-NLS-1$
		return null;
	}


	/**
	 * 
	 * @param enumeration
	 *        the uml enumeration
	 * @param toAdapt
	 *        the list of the element to adapt to UML EnumerationLiteral
	 * @return
	 */
	public static final List<EnumerationLiteral> adaptToEnumerationLiteralList(final Enumeration enumeration, final Collection<?> toAdapt) {
		final List<EnumerationLiteral> returnedValue = new ArrayList<EnumerationLiteral>();
		for(Object object : toAdapt) {
			if(object instanceof EnumerationLiteral) {
				returnedValue.add((EnumerationLiteral)object);
			} else if(object instanceof Enumerator) {
				returnedValue.add(EnumerationUtil.findEnumerationLiteral(enumeration, (Enumerator)object));
			}
		}
		assert returnedValue.size() == toAdapt.size();
		return returnedValue;
	}

	/**
	 * 
	 * @param eenum
	 *        an eemf enumeration
	 * @param toConvert
	 *        a list of enumeration literal to convert
	 * @return
	 *         the list of the converted element (/!\ in case of fail, the returned list contains less elements than the initial list)
	 */
	public static final List<Enumerator> adaptToEnumeratorList(final EEnum eenum, final Collection<?> toConvert) {
		final List<Enumerator> convertedvalues = new ArrayList<Enumerator>();
		for(final Object object : toConvert) {
			if(object instanceof EnumerationLiteral) {
				final EEnumLiteral literal = eenum.getEEnumLiteral(((EnumerationLiteral)object).getName());
				if(literal != null) {
					convertedvalues.add(literal.getInstance());
				}
			}
		}
		return convertedvalues;

	}

	/**
	 * 
	 * @param eenum
	 *        an emf enumeration
	 * @param umlLiteral
	 *        a uml literal
	 * @return
	 *         the enumerator to use for this enumeration literal (/!\ can be null in case of fail)
	 */
	public static final Enumerator adaptToEnumerator(final EEnum eenum, final EnumerationLiteral umlLiteral) {
		final EEnumLiteral literal = eenum.getEEnumLiteral(umlLiteral.getName());
		if(literal != null) {
			return literal.getInstance();
		}
		return null;
	}

}
