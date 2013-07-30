/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.tools.converter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.tools.Activator;
import org.eclipse.papyrus.infra.tools.messages.Messages;

/**
 * Abstract class for Stringvakue Container
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractStringValueConverter implements IStringValueConverter {

	protected static final String THE_STRING_X_IS_NOT_VALID_TO_CREATE_Y = Messages.AbstractStringValueConverter_TheStringXIsNotValidToCreateY;

	protected static final String THE_FEATURE_X_CANT_BE_RESOLVED = Messages.AbstractStringValueConverter_TheFeatureXCantBeResolved;

	protected static final String THE_STRING_VALUE_X_CANT_BE_RESOLVED = Messages.AbstractStringValueConverter_TheStringValueXCantBeResolved;

	protected static final String SOME_STRING_ARE_NOT_VALID_TO_CREATE_X = Messages.AbstractStringValueConverter_SomeStringsAreNotValidToCreateY;

	protected static final String SOME_STRING_CANT_BE_RESOLVED_TO_FIND_X = Messages.AbstractStringValueConverter_SomeStringsCantBeResolvedToFindY;

	protected static final String NO_X_REPRESENTED_BY_Y_HAVE_BEEN_FOUND = Messages.AbstractStringValueConverter_NoXReprensentedByYHaveBeenFound;

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.tools.converter.IStringValueConverter#deduceValueFromString(java.lang.Object, java.lang.String)
	 * 
	 * @param type
	 * @param valueAsString
	 * @return
	 */
	public final ConvertedValueContainer<?> deduceValueFromString(final Object type, final String valueAsString) {
		ConvertedValueContainer<?> result = doDeduceValueFromString(type, valueAsString);
		if(result == null) {
			final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(THE_STRING_VALUE_X_CANT_BE_RESOLVED, valueAsString));
			result = new ConvertedValueContainer<Object>(null, status);
		}
		return result;
	}

	/**
	 * 
	 * @param type
	 *        the type of the object
	 * @param valueAsString
	 *        the string to resolve
	 * @return
	 *         a {@link ConvertedValueContainer} with the resolved values and a status
	 */
	protected abstract ConvertedValueContainer<?> doDeduceValueFromString(final Object type, final String valueAsString);


}
