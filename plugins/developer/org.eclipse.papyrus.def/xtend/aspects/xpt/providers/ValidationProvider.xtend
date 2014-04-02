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
 *    Artem Tikhomirov (Borland) - introduced GenAuditContext entity
 *                                 straightforward and simple #validate() implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.providers

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget
import xpt.Common
import xpt.Common_qvto
import xpt.GenAuditRoot_qvto
import xpt.editor.VisualIDRegistry

@Singleton class ValidationProvider extends xpt.providers.ValidationProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension GenAuditRoot_qvto; 
	
	@Inject VisualIDRegistry xptVisualIDRegistry;



	override selectors(GenAuditRoot it) '''
	«IF it !=null»
	«IF it.clientContexts !=null»
	«FOR ctx : it.clientContexts»
		«generatedMemberComment»
		public static class «ctx.className» implements org.eclipse.emf.validation.model.IClientSelector {
			
			«generatedMemberComment»
			public boolean selects(Object object) {
			«IF ctx.ruleTargets.filter(typeof(GenDiagramElementTarget)).notEmpty»
				if (isInDefaultEditorContext(object) && object instanceof org.eclipse.gmf.runtime.notation.View) {
					final int id = «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»((org.eclipse.gmf.runtime.notation.View) object);
					boolean result = false;
				«FOR e : getTargetDiagramElements(ctx)»
					result = result || id == «VisualIDRegistry::visualID(e)»;
				«ENDFOR»
					return result;
				}
				return false;
			«ELSE»
				return isInDefaultEditorContext(object);
			«ENDIF»
			}
		}
	«ENDFOR»
	«ENDIF»
	«ENDIF»
	'''

	override constraintAdapters(GenAuditRoot it, GenDiagram diagram) '''
		«IF it !=null»
		«IF diagram.editorGen.expressionProviders != null»
		«FOR next : it.rules.filter[a | a.requiresConstraintAdapter]»
			«constraintAdapter(next, diagram.editorGen.expressionProviders)»
		«ENDFOR»
		
		«IF it.rules.exists[a | a.requiresConstraintAdapter]»
		«constraintAdapters_formatMethod(it)»
		«ENDIF»
		«ENDIF»
		«ENDIF»
	'''
}
