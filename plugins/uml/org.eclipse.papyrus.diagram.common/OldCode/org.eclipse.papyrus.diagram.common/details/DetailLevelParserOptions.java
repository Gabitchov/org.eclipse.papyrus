/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.details;

import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;

public interface DetailLevelParserOptions {

	int LEVEL_IMPLEMENTATION = 0;

	int LEVEL_ANALYSIS = 1;

	int LEVEL_DETAILS_SUPPRESSED = 2;

	ParserOptions OPTION_IMPLEMENTATION = new ParserOptions(LEVEL_IMPLEMENTATION);

	ParserOptions OPTION_ANALYSIS = new ParserOptions(LEVEL_ANALYSIS);

	ParserOptions OPTION_DETAILS_SUPPRESSED = new ParserOptions(LEVEL_DETAILS_SUPPRESSED);

}
