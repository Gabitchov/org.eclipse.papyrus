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
package org.eclipse.papyrus.customization.properties.model.xwt.format;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.customization.properties.model.xwt.Activator;
import org.eclipse.wst.xml.core.internal.formatter.XMLFormatterFormatProcessor;

/**
 * A Helper for formatting XML Files
 * 
 * @author Camille Letavernier
 */
public class XMLFormatter {

	public static void format(IFile file){
		XMLFormatterFormatProcessor processor = new XMLFormatterFormatProcessor();
		try {
			processor.formatFile(file);
		} catch (IOException ex) {
			Activator.log.error(ex);
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
	}
}
