/**
 * Copyright (c) 2007, 2010, 2014 Borland Software Corporation, CEA, and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime, template migrated to Xtend2
 *    Christian W. Damus (CEA) - bug 426732: override the cross-reference searches for views to use the CrossReferenceAdapter  	  
 */
package aspects.xpt.diagram.updater

import com.google.inject.Inject
import com.google.inject.Singleton

import metamodel.MetaModel

import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLink

import xpt.Common
import xpt.diagram.updater.LinkDescriptor
import xpt.diagram.updater.UpdaterLinkType
import xpt.diagram.updater.Utils_qvto
import xpt.Common_qvto
import xpt.GenModelUtils_qvto

@Singleton class DiagramUpdater extends xpt.diagram.updater.DiagramUpdater {
    @Inject extension Common;
    @Inject extension Common_qvto;
    @Inject extension Utils_qvto;
    @Inject extension GenModelUtils_qvto;
    @Inject LinkDescriptor linkDescriptor;
    
    @Inject MetaModel xptMetaModel;

    protected def typeOfCrossReferenceAdapter() '''org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter'''

    override def getConnectedLinks(GenCommonBase it, Iterable<GenLink> genLinks, UpdaterLinkType linkType, boolean needCrossReferencer) '''

    «generatedMemberComment»
    public static «listOfLinkDescriptors(it)» «linkGetterName(it, linkType)»(org.eclipse.gmf.runtime.notation.View view) {
    «IF genLinks.notEmpty»
        «xptMetaModel.DeclareAndAssign(it.metaClass, 'modelElement', 'view.getElement()')»
        «IF needCrossReferencer»
            «typeOfCrossReferenceAdapter» crossReferencer = «typeOfCrossReferenceAdapter».getCrossReferenceAdapter(view.eResource().getResourceSet());
        «ENDIF»
        «newLinkedListOfLinkDescriptors(it.diagramUpdater, 'result')»();
        «FOR link : genLinks»
            «colectConnectedLinks(link, linkType, needCrossReferencer, isExternalInterface(it.metaClass))»
        «ENDFOR»
        return result;
    «ELSE»
        return «newEmptyList()»;
    «ENDIF»
    }
    '''

    override def colectConnectedLinks(GenLink it, UpdaterLinkType linkType, boolean needCrossReferencer, boolean isExternalInterface) '''
    «IF it.modelFacet != null»
        «IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»
            if («xptMetaModel.IsInstance(it.modelFacet.getLinkEndType(linkType), 'modelElement')») {
        «ENDIF»
            result.addAll(«chooseConnectedLinksByTypeMethodName(it.modelFacet, linkType, it)»(« //
                IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»«xptMetaModel.CastEObject(it.modelFacet.getLinkEndType(linkType), 'modelElement')»«ELSE»modelElement«ENDIF»«IF needCrossReferencer», crossReferencer«ENDIF»));  
        «IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»
            }
        «ENDIF»
    «ENDIF»
    '''

    override def getIncomingLinksByTypeMethod(GenLink it) '''
    
    «generatedMemberComment»
    private static java.util.Collection<«linkDescriptor.qualifiedClassName(it.diagramUpdater)»> «getConnectedLinksByTypeMethodName(UpdaterLinkType::INCOMING)»(«xptMetaModel.QualifiedClassName(it.modelFacet.targetType)» target, «typeOfCrossReferenceAdapter» crossReferencer) {
        «newLinkedListOfLinkDescriptors(it.diagramUpdater, 'result')»();
        java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
        for (org.eclipse.emf.ecore.EStructuralFeature.Setting setting : settings) {
            «getIncomingLinksByTypeMethodBody(it.modelFacet, it)»
        }
        return result;  
    }
    '''

}