/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257119] Create views directly, not through ViewFactories
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.views

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import xpt.diagram.ViewmapAttributesUtils_qvto

/**
 * Renamed from xpt::diagram::views::Utils.xpt 
 * in order to have consistent naming between Xtend files migrated from _qvto helpers and xpt templates
 */
@Singleton class ViewStyles extends xpt.diagram.views.ViewStyles{

	@Inject extension ViewmapAttributesUtils_qvto;



	override dispatch offset(GenExternalNodeLabel it, String viewVar) '''
		«IF labelOffsetX(viewmap, 0) != 0 || labelOffsetY(viewmap, 0) != 0»
			«offset(it,viewVar, labelOffsetX(viewmap, 0), labelOffsetY(viewmap, 0))»
		«ELSE»
			«offset(it,viewVar, 0, 5)»
		«ENDIF»
	'''

}
