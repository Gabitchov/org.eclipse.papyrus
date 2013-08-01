/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.css.dom;

import org.eclipse.e4.ui.css.core.dom.IElementProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ICSSElementProviderFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.uml2.uml.Element;


/**
 * IElementProvider Factory for Diagrams related to UML Elements
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings("restriction")
public class GMFUMLElementProviderFactory implements ICSSElementProviderFactory {

	public boolean isProviderFor(CSSDiagram diagram) {
		return diagram.getElement() instanceof Element; //Provider for UML Elements
	}

	public IElementProvider createProvider(CSSDiagram diagram) {
		return new GMFUMLElementProvider();
	}

}
