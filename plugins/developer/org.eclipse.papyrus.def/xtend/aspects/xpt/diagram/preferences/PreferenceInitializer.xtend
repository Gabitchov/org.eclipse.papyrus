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
 * 	  Thibault Landre (Atos Origin) - initial API and implementation
 *    Patrick Tessier (CEA LIST)
 */
package aspects.xpt.diagram.preferences

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenNode
import plugin.Activator
import xpt.Common

@Singleton class PreferenceInitializer extends xpt.diagram.preferences.PreferenceInitializer {
	@Inject extension Common;

	@Inject Activator xptActivator;

//	override PreferenceInitializer(GenDiagram it) '''
//		«copyright(editorGen)»
//		package «packageName(it)»;
//		
//		«generatedClassComment»
//		public class «className(it)» extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
//		
//			«generatedMemberComment»
//			public void initializeDefaultPreferences() {
//				org.eclipse.jface.preference.IPreferenceStore store = getPreferenceStore();
//				«FOR GenNode node : getAllNodes()»
//					«IF !('UNDEFINED'.equals(node.elementType.displayName.toUpperCase()))»
//						«it.preferencesPackageName».«node.elementType.displayName»PreferencePage.initDefaults(store);
//					«ENDIF»
//				«ENDFOR»
//				
//				«FOR GenNode node : getAllNodes()»
//					«IF !('UNDEFINED'.equals(node.elementType.displayName.toUpperCase()))»
//						«it.preferencesPackageName».«node.elementType.displayName»PreferencePage.initDefaults(store);
//					«ENDIF»
//				«ENDFOR»
//			}
//		
//			«generatedMemberComment»
//			protected org.eclipse.jface.preference.IPreferenceStore getPreferenceStore() {
//				return «xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getPreferenceStore();
//			}
//		} 
//	'''

}
