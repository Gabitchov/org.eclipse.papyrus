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
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;
import org.eclipse.swt.widgets.Shell;


public class EditStyleHandler extends AbstractStyleHandler {

	@Override
	protected AbstractStyleDialog createStyleDialog(Shell shell, Map<Declaration, Boolean> declarations, Map<Attribute, Boolean> conditions, String selectorName, View context) {
		return new StyleEditionDialog(shell, conditions, declarations, selectorName, context);
	}

	@Override
	protected Ruleset getRuleset(AbstractStyleDialog dialog) {
		Ruleset ruleset = ((StyleEditionDialog)dialog).getSelectedRuleset();
		ruleset.getSelectors().clear();
		ruleset.getProperties().clear();
		return ruleset;
	}

	@Override
	protected Stylesheet getStyleSheet(AbstractStyleDialog dialog, View contextView) {
		return ((StyleEditionDialog)dialog).getStylesheet();
	}

}
