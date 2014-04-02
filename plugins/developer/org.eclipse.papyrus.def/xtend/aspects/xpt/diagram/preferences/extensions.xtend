/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Thibault Landre (Atos Origin) - initial API and implementation
 */
package aspects.xpt.diagram.preferences

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages
import utils.PrefsConstant_qvto
import xpt.Common
import xpt.diagram.Utils_qvto

@Singleton class extensions extends xpt.diagram.preferences.extensions {
	@Inject extension Common;
	@Inject extension Utils_qvto;
	@Inject extension PrefsConstant_qvto;

	@Inject xpt.diagram.preferences.PreferenceInitializer xptPreferenceInitializer;

	override extensions(GenDiagram it) '''
		
		«tripleSpace(1)»<extension point="org.eclipse.core.runtime.preferences" id="prefs">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<initializer class="«xptPreferenceInitializer.qualifiedClassName(it)»"/>
		«tripleSpace(1)»</extension>
		
		«IF ! it.preferencePages.empty»
			«tripleSpace(1)»<extension point="org.eclipse.ui.preferencePages" id="prefpages">
			«tripleSpace(2)»«xmlGeneratedTag»
			      «FOR pref : allPreferencePages(it)»
			      	«IF pref instanceof GenStandardPreferencePage»
					«papyrusPreferencePage(pref as GenStandardPreferencePage)»
				«ENDIF»
			«ENDFOR»
			«tripleSpace(1)»</extension>
		«ENDIF»
	'''

	def papyrusPreferencePage(GenStandardPreferencePage it) '''
		«IF StandardPreferencePages.GENERAL_LITERAL == kind»
		      <page
		            id="«getDiagramPreferencePageCategory()».«getDiagram().editorGen.modelID»"
		            name="«getDiagram().editorGen.modelID» Diagram"
		            category="«getDiagramPreferencePageCategory()»"
		            class="«getQualifiedClassName()»">
		      </page>
		      «ELSEIF StandardPreferencePages.PRINTING_LITERAL == kind ||
				StandardPreferencePages.RULERS_AND_GRID_LITERAL == kind»
		      <page
		            id="«getQualifiedClassName()»"
		            name="%prefpage.«ID»"
		            category="«getDiagramPreferencePageCategory()».«getDiagram().editorGen.modelID»"
		            class="«getQualifiedClassName()»">
		      </page>
		«ENDIF»
	'''

}
