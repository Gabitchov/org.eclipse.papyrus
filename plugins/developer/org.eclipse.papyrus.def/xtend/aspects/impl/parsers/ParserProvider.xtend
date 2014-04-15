/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [235113] alternative parser access
 *                                 [244419] custom parsers
 *                                 [138179] expression-backed labels
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.parsers

import com.google.inject.Inject
import com.google.inject.Singleton
import impl.parsers.expression_qvto
import metamodel.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.CustomParser
import org.eclipse.gmf.codegen.gmfgen.ExpressionLabelParser
import org.eclipse.gmf.codegen.gmfgen.ExternalParser
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation
import org.eclipse.gmf.codegen.gmfgen.GenParsers
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.LabelTextAccessMethod
import org.eclipse.gmf.codegen.gmfgen.OclChoiceParser
import org.eclipse.gmf.codegen.gmfgen.PredefinedEnumParser
import org.eclipse.gmf.codegen.gmfgen.PredefinedParser
import org.eclipse.gmf.codegen.gmfgen.ValueExpression
import plugin.Activator
import xpt.Common
import xpt.Common_qvto
import xpt.editor.VisualIDRegistry
import xpt.expressions.OclTracker_qvto
import xpt.expressions.getExpression
import xpt.providers.ElementTypes
import xpt.providers.ParserUtils_qvto

@Singleton class ParserProvider extends impl.parsers.ParserProvider {
	@Inject extension Common
	@Inject extension Common_qvto

	@Inject extension OclTracker_qvto
	@Inject extension ParserUtils_qvto
	@Inject extension expression_qvto

	@Inject extension parsers.ExpressionLabelParser;
	@Inject extension parsers.PredefinedParser;

	@Inject getExpression xptGetExpression;
	@Inject MetaModel xptMetaModel;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject ElementTypes xptElementTypes;
	@Inject parsers.ParserProvider xptParsers;
	@Inject Activator xptActivator;

	override def HintAdapterClass(GenParsers it) '''
			«generatedMemberComment()»
			private static class HintAdapter extends org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter {
		
				«generatedMemberComment()»
				private final org.eclipse.gmf.runtime.emf.type.core.IElementType elementType;
		
				«generatedMemberComment()»
				public HintAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType type,
						org.eclipse.emf.ecore.EObject object, String parserHint) {
				super(object, parserHint);
				«_assert('type != null')»
				elementType = type;
				}
		
				«generatedMemberComment()»
				public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
					if (org.eclipse.gmf.runtime.emf.type.core.IElementType.class.equals(adapter)) {
						return elementType;
					}
					return super.getAdapter(adapter);
				}
			}
	'''

	override dispatch dispatch_parsers(GenNode it) ''' 
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«dispatch_parser(label.modelFacet.parser, label.modelFacet, label)»
			«ENDIF»
		«ENDFOR»
	'''

	override dispatch dispatch_parsers(GenLink it) '''
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«dispatch_parser(label.modelFacet.parser, label.modelFacet, label)»
			«ENDIF»
		«ENDFOR»
	'''

	override dispatch dispatch_getParsers(GenNode it) // 
	'''
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«doGetParser(label.modelFacet.parser, label)»
			«ENDIF»
		«ENDFOR»
		
	'''

	override dispatch dispatch_getParsers(GenLink it) // 
	'''
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«doGetParser(label.modelFacet.parser, label)»
			«ENDIF»
		«ENDFOR»
		
	'''

	override dispatch dispatch_getParsers(GenChildLabelNode it) '''
		«IF it.modelFacet != null»
			«doGetParser(it.labelModelFacet.parser, it)»
		«ENDIF»
	'''

}
