/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenEditorView
import xpt.Common

@Singleton class ActionBarContributor extends xpt.editor.ActionBarContributor {
	@Inject extension Common;
	@Inject Editor xptEditor;

	override def ActionBarContributor(GenEditorView it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
		
			«generatedMemberComment»
			
			protected Class<«xptEditor.qualifiedClassName(it)»> getEditorClass() {
				return «xptEditor.qualifiedClassName(it)».class;
			}
		
			«generatedMemberComment»
			protected String getEditorId() {
				return «xptEditor.qualifiedClassName(it)».ID;
			}
			«initMethod(it)»
			«additions(it)»
		}
	'''


}
