/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.EObjectListValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.DiagramCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;

public class CSSDiagramImpl extends DiagramImpl implements CSSDiagram {

	protected ExtendedCSSEngine engine;

	public ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = new DiagramCSSEngine(getModelEngine(), this);
		}
		return engine;
	}

	protected ExtendedCSSEngine getModelEngine() {
		if(eResource() instanceof CSSNotationResource) {
			return ((CSSNotationResource)eResource()).getEngine();
		}
		return null;
	}

	public List<StyleSheet> getStyleSheets() {
		List<StyleSheet> result = new LinkedList<StyleSheet>();

		for(Object styleObject : getStyles()) {
			if(styleObject instanceof NamedStyle) {

				NamedStyle style = (NamedStyle)styleObject;

				if(CSSAnnotations.CSS_DIAGRAM_STYLESHEETS_KEY.equals(style.getName())) {
					if(style instanceof EObjectListValueStyle) {

						EObjectListValueStyle stylesheetsStyle = (EObjectListValueStyle)style;

						for(Object eObjectValue : stylesheetsStyle.getEObjectListValue()) {
							if(eObjectValue instanceof StyleSheet) {
								result.add((StyleSheet)eObjectValue);
							}
						}
					}
				}
			}
		}

		return result;
	}

}
