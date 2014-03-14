/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #372479, #386838
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.gmf.codegen.gmfgen.ValueExpression
import xpt.CodeStyle
import xpt.Common

//XXX: [MG] decide what to do with @MetaDef methods
@Singleton class VisualIDRegistry extends xpt.editor.VisualIDRegistry {

	@Inject extension MetaModel
	@Inject extension Common
	@Inject CodeStyle xptCodeStyle;

	override getDiagramVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static int «getDiagramVisualIDMethodName(it)»(org.eclipse.emf.ecore.EObject domainElement) {
			if (domainElement == null) {
				«unrecognizedVID(it)»
			}
			return «visualID»;
		}
	'''

	/**
	 * Support for extra contstraints to check about model element.
	 * Includes expression fields for interpreted constrains (like ocl or regexp).
	 * For each model element that has an associated constraint, there's a method is<DomainElement>_<UID>()
	 * that performs extra specification as defined by value expression
	 * 
	 * FIXME don't use static fields, replace with instance/separate cache (e.g. accessible from Activator)
	 */
	override constraintMethods(GenDiagram it) '''
		«IF null != editorGen.expressionProviders»
			«FOR topNode : topLevelNodes.filter[n|!n.sansDomain].filter[n|n.modelFacet.modelElementSelector != null]»«constraintMethod(
			topNode)»«ENDFOR»
			«FOR childNode : childNodes.filter[n|!n.sansDomain].filter[n|n.modelFacet.modelElementSelector != null]»«constraintMethod(
			childNode)»«ENDFOR»
			«FOR link : links.filter[n|!n.sansDomain]»«constraintMethod(link.modelFacet, link)»«ENDFOR»
		«ENDIF»
	'''

	//[ExtendedConstraint] Model selector constraint
	override checkDomainElementConstraints(TypeModelFacet it, GenCommonBase commonBase) '''
	«««	 [ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case)
	«IF commonBase instanceof GenLink»
		«««	[ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
	«IF null != modelElementSelector» && «domainElementConstraintMethodName(commonBase)»(«CastEObject(metaClass,
		'domainElement')»)«ENDIF»
	«««	[ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case) 
	«ELSE»
		«IF null != modelElementSelector» && «domainElementConstraintMethodName(commonBase)»(containerView, «CastEObject(
		metaClass, 'domainElement')»)«ENDIF»
	«ENDIF»
	«««	[ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
	'''

	//	[ExtendedConstraint] Model selector constraint
	override _domainElementConstraintMethod(GenJavaExpressionProvider it, GenCommonBase diagramElement,
		ValueExpression expression, GenClass context) '''
		«generatedMemberComment»
		«««	[ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case)
	«IF diagramElement instanceof GenLink»
			««« [ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
	private static boolean «domainElementConstraintMethodName(diagramElement)»(«QualifiedClassName(context)» domainElement) {
		««« [ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case)
	«ELSE»
			private static boolean «domainElementConstraintMethodName(diagramElement)»(org.eclipse.gmf.runtime.notation.View containerView, «QualifiedClassName(
			context)» domainElement) {
		«ENDIF»
		««« [ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
	«IF injectExpressionBody && (expression.body != null && expression.body.length() != 0)»
			«expression.body»
		«ELSEIF throwException || (injectExpressionBody && (expression.body == null || expression.body.length() == 0))»
			// FIXME: implement this method 
			// Ensure that you remove @generated or mark it @generated NOT
			throw new java.lang.UnsupportedOperationException("No java implementation provided in '« domainElementConstraintMethodName(diagramElement)»' operation");«nonNLS»
		«ELSE»
			return false;
		«ENDIF»
		}
	'''

	override runtimeTypedInstance(GenDiagram it) '''
		«generatedClassComment()»
		public static final org.eclipse.gmf.tooling.runtime.structure.DiagramStructure «runtimeTypedInstanceName(it)» = new org.eclipse.gmf.tooling.runtime.structure.DiagramStructure() {
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public int «getVisualIdMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				return «getVisualIDMethodCall(it)»(view);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public String «getModelIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				return «getModelIDMethodCall(it)»(view);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public int «getNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
				return «getNodeVisualIDMethodCall(it)»(containerView, domainElement);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public boolean «checkNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, int candidate) {
				return «checkNodeVisualIDMethodCall(it)»(containerView, domainElement, candidate);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public boolean «isCompartmentVisualIDMethodName(it)»(int visualID) {
				return «isCompartmentVisualIDMethodCall(it)»(visualID);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public boolean «isSemanticLeafVisualIDMethodName(it)»(int visualID) {
				return «isSemanticLeafVisualIDMethodCall(it)»(visualID);
			}
		};
	'''

}
