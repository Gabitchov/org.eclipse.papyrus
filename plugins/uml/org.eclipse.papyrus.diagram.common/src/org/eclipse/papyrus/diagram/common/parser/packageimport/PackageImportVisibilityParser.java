/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
 * implementation.
 *
 *	Emilien Perico (Atos Origin) - use parser for class and use case diagram
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.parser.packageimport;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.papyrus.diagram.common.parser.structural.UMLStructuralFeatureParser;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Parses PackageImport visibility this way:
 * <li>public             <-> import</li>
 * <li>private            <-> access</li>
 * <li>package, protected  -> access.</li>
 * <br>
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class PackageImportVisibilityParser extends UMLStructuralFeatureParser {

	protected final String stereoBegin = "\u00AB";

	protected final String stereoEnd = "\u00BB";
	
	/**
	 * Instantiates a new package import visibility parser.
	 */
	public PackageImportVisibilityParser() {
		super(UMLPackage.eINSTANCE.getPackageImport_Visibility());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditString(IAdaptable adapter, int flags) {
		return getPrintString(adapter, flags);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable adapter, int flags) {
		String visibility = super.getPrintString(adapter, flags);
		if (visibility.toUpperCase().equals("PUBLIC")) {
			return (stereoBegin + "import" + stereoEnd);
		}
		else {
			return (stereoBegin + "access" + stereoEnd);
		}
	}
	
}
