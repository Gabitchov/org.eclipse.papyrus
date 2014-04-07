/**
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Patrick Tessier (CEA) - initial API and implementation
 *    Thibault Landre (Atos Origin) - initial API and implementation
 *    Vincent Lorenzo (CEA-LIST) - Bug 335987 [General][Enhancement] Show/Hide Connectors Labels and External Nodes Labels
 */
package aspects.impl.diagram.editparts

import aspects.xpt.editor.VisualIDRegistry
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView
import org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator
import utils.EditPartsUtils_qvto
import xpt.Common
import xpt.diagram.editparts.EditPartFactory
import xpt.diagram.editparts.Utils_qvto

@Singleton class NodeEditPart extends impl.diagram.editparts.NodeEditPart {
	@Inject extension Common;

	@Inject extension EditPartsUtils_qvto;
	@Inject extension  VisualIDRegistry;
	
	@Inject extension Utils_qvto;
	@Inject extension xpt.diagram.Utils_qvto;
	@Inject EditPartFactory xptEditPartFactory;
		@Inject impl.diagram.editparts.TextAware xptTextAware;
	
//---------
//   GMF
//---------
	
	override extendsListContents (GenNode it)'''
«««BEGIN: PapyrusGenCode
«««Add own extension
«IF it.eResource.allContents.filter(typeof(ExtendedGenView)).filter[v |v.genView.contains(it) && v.superOwnedEditPart!=null].size != 0»
«FOR extendedObject : it.eResource.allContents.filter(typeof(ExtendedGenView)).filter[v |v.genView.contains(it) && v.superOwnedEditPart!=null].toIterable»
«specifyInheritance(extendedObject as ExtendedGenView)»
«ENDFOR»
«««END: BEGIN: PapyrusGenCode
«ELSE»
	«IF hasBorderItems(it)»org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart«ELSE»«IF it instanceof GenChildSideAffixedNode»org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart«ELSE»org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart«ENDIF»«ENDIF»
«ENDIF»
'''

def extendsListContents (GenChildSideAffixedNode it)'''
«««BEGIN: PapyrusGenCode
«««Add own extension
«IF it.eResource.allContents.filter(typeof(ExtendedGenView)).filter[v |v.genView.contains(it) && v.superOwnedEditPart!=null].size != 0»
«FOR extendedObject : it.eResource.allContents.filter(typeof(ExtendedGenView)).filter[v |v.genView.contains(it) && v.superOwnedEditPart!=null].toIterable»
«specifyInheritance(extendedObject)»
«ENDFOR»
«««END: BEGIN: PapyrusGenCode
«ELSE»
	«IF hasBorderItems(it)»org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart«ELSE»org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart«ENDIF»
«ENDIF»
'''
override addFixedChild (GenNode it)'''
	«generatedMemberComment»
	protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {
«FOR label:getInnerFixedLabels(it)»«var childViewmap = label.viewmap as ParentAssignedViewmap»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(label)») {
			((«xptEditPartFactory.getEditPartQualifiedClassName(label)») childEditPart).«xptTextAware.labelSetterName(childViewmap)»(getPrimaryShape().«childViewmap.getterName»());
			return true;
		}
«ENDFOR»

«FOR compartment : getPinnedCompartments(it)»«var childViewmap = compartment.viewmap as ParentAssignedViewmap»

		if (childEditPart instanceof «compartment.getEditPartQualifiedClassName()») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«childViewmap.getterName»();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((«compartment.getEditPartQualifiedClassName()») childEditPart).getFigure());
			return true;
		}	
«ENDFOR»

«FOR  child:getSideAffixedChildren(it)»
	«««	BEGIN PapyrusGencode
	«««	adding IF else end in order to take in account the case where a specific locator is added
	

	«IF  it.eResource.allContents.filter(typeof (SpecificLocator)).filter[v | v.genChildSideAffixedNode.contains(child)].size !=0»
	 «FOR extendedObject : it.eResource.allContents.filter(typeof (SpecificLocator)).filter[v |v.genChildSideAffixedNode.contains(child)].toIterable»
	 	«genSpecificLocator(extendedObject,child)»
	 «ENDFOR»

	 «ELSE»
	 «««END PapyrusGencode«ENDREM
		if (childEditPart instanceof «child.getEditPartQualifiedClassName()») {
			org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator locator = new org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator(getMainFigure(), org.eclipse.draw2d.PositionConstants.«child.preferredSideName»);
			getBorderedFigure().getBorderItemContainer().add(((«child.getEditPartQualifiedClassName()») childEditPart).getFigure(), locator);
			return true;
		}
	«««	BEGIN PapyrusGencode
	«ENDIF»
	«««END PapyrusGencode
«ENDFOR»
		return false;
	}
'''

	override def setLineWidth(GenNode it) '''
		«generatedMemberComment»
		protected void setLineWidth(int width) {
«««			if (primaryShape instanceof org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure) {	
«««				((org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure) primaryShape).setLineWidth(«IF getDiagram().isPixelMapMode()»width«ELSE»getMapMode().DPtoLP(width)«ENDIF»);
«««			}
			super.setLineWidth(width);
		}
	'''
	
		override def setLineStyle(GenNode it) '''
		«generatedMemberComment»
		protected void setLineType(int style) {
			if (primaryShape instanceof org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure) {	
				((org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure) primaryShape).setLineStyle(style);
			}
		}
	'''
	
	override createFigure(GenNode it) '''
		«generatedMemberComment(
			'Creates figure for this edit part.\n' + 
			'\n' + 
			'Body of this method does not depend on settings in generation model\n' + 
			'so you may safely remove <i>generated</i> tag and modify it.\n'
		)»
		protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure create«IF hasBorderItems(it)»Main«ELSE»Node«ENDIF»Figure() {
			«IF it instanceof GenChildSideAffixedNode»
				org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure figure = createNodePlate();
				figure.setLayoutManager(new org.eclipse.draw2d.StackLayout());
				org.eclipse.draw2d.IFigure shape = createNodeShape();
				figure.add(shape);
				contentPane = setupContentPane(shape);
				return figure;
			«ELSE»
				return new org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SelectableBorderedNodeFigure(createMainFigureWithSVG());
			«ENDIF»
			
		}
	'''

//	override createNodePlate (GenNode it)'''
//		«generatedMemberComment»
//		protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodePlate() {
//			String prefElementId="«elementType.displayName»";
//			org.eclipse.jface.preference.IPreferenceStore store =«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore();
//			String preferenceConstantWitdh=org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId,  org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.WIDTH);
//			String preferenceConstantHeight=org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId,  org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.HEIGHT);
//			org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure result = new org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
//			
//			«setupNodePlate(it)»
//			return result;
//		}
//	'''

override borderItemSelectionEditPolicy(GenNode it)'''
	«IF hasBorderItems(it)»
	org.eclipse.gmf.runtime.notation.View childView = (org.eclipse.gmf.runtime.notation.View) child.getModel();
	switch («getVisualIDMethodCall(getDiagram())»(childView)) {
	«IF getExternalLabels(it).size > 0»
	«FOR nextLabel : getExternalLabels(it) »
	«caseVisualID(nextLabel)»
	«ENDFOR»
		return «borderItemSelectionEP(it)»;
	«ENDIF»
	«IF getSideAffixedChildren(it).size > 0»
	«FOR nextBorderItem : getSideAffixedChildren(it)»
		«caseVisualID(nextBorderItem)»
	«ENDFOR»
		«««	BEGIN PapyrusGenCode
		«««	The purprose is to add replace GMF edit prolicy by an new editPolicy that allows to resize BorderItem
		return new org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy();
		««« END PapyrusGenCode
	«ENDIF»
	}
«ENDIF»
'''
	
//---------
// PAPYRUS
//---------

//BEGIN: PapyrusGenCode
//definition of the inheritance
def specifyInheritance (ExtendedGenView it)'''«superOwnedEditPart»'''
//END: PapyrusGenCode


def genSpecificLocator(GenCommonBase it, GenChildSideAffixedNode child) ''''''

def genSpecificLocator(ToolEntry it, GenChildSideAffixedNode child) ''''''

def genSpecificLocator(GenNavigatorChildReference it,GenChildSideAffixedNode child)''''''

def genSpecificLocator(SpecificLocator it, GenChildSideAffixedNode child)'''
//Papyrus Gencode :«it.comment»
	if (childEditPart instanceof «child.getEditPartQualifiedClassName()») {
			org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator locator = new «it.classpath»(getMainFigure(), org.eclipse.draw2d.PositionConstants.«child.preferredSideName»);
			getBorderedFigure().getBorderItemContainer().add(((«child.getEditPartQualifiedClassName()») childEditPart).getFigure(), locator);
			return true;
		}
		
'''

	override def borderItemSelectionEP(GenNode it) '''
	new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy() {
	
		protected java.util.List<?> createSelectionHandles() {
			org.eclipse.gef.handles.MoveHandle mh = new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());
			mh.setBorder(null);
			return java.util.Collections.singletonList(mh);
		}
	}
	'''

//BEGIN PapyrusGencode
//Overwrite an existing method to set the preference value in the editpart
//def genPreferredValue (GenNode it)'''
//
//	«generatedMemberComment»
//	@Override
//	public Object getPreferredValue(org.eclipse.emf.ecore.EStructuralFeature feature) {
//		org.eclipse.jface.preference.IPreferenceStore preferenceStore = (org.eclipse.jface.preference.IPreferenceStore) getDiagramPreferencesHint()
//				.getPreferenceStore();
//		Object result = null;
//			
//		if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFontStyle_FontColor() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFillStyle_FillColor()){
//			String prefColor = null;
//			if (feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
//				prefColor = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("«elementType.displayName»", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_LINE);
//			} else if (feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFontStyle_FontColor()) {
//				prefColor = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("«elementType.displayName»", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FONT);
//			} else if (feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFillStyle_FillColor()) {
//				prefColor = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("«elementType.displayName»", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FILL);
//			}
//			result = org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities
//						.RGBToInteger(org.eclipse.jface.preference.PreferenceConverter
//								.getColor(
//										(org.eclipse.jface.preference.IPreferenceStore) preferenceStore, prefColor));
//		} else if (feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFillStyle_Transparency() || feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFillStyle_Gradient()) {
//			String prefGradient = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant("«elementType.displayName»", org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_GRADIENT);
//			org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(
//						preferenceStore.getString(prefGradient));
//			if(feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFillStyle_Transparency()){
//				result = new Integer(gradientPreferenceConverter
//						.getTransparency());
//			} else if (feature == org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE
//					.getFillStyle_Gradient()){
//				result = gradientPreferenceConverter.getGradientData();
//			}
//		}
//		
//		if(result == null){
//			result = getStructuralFeatureValue(feature);
//		}
//		return result;
//	}
//'''
//END PapyrusGencode

//BEGIN: PapyrusGenCode
//CreateGenerator to refresh figure by taking account of event of UML element or graphical element 
def specificHandleNotificationEvent (GenNode it) '''

	«IF it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v |v.genView.contains(it)].size != 0»
		/**
		*Papyrus codeGen
		*@generated
		**/
		protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
		«IF it.labels.filter(typeof(GenExternalNodeLabel)).size != 0» 
			/*
			 * when a node have external node labels, the methods refreshChildren() remove the EditPart corresponding to the Label from the EditPart
			 * Registry. After that, we can't reset the visibility to true (using the Show/Hide Label Action)!
			 */
			if(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Visible().equals(event.getFeature())) {
				Object notifier = event.getNotifier();
				java.util.List<?> modelChildren = ((org.eclipse.gmf.runtime.notation.View)getModel()).getChildren();
				if(!(notifier instanceof org.eclipse.gmf.runtime.notation.Edge)) {
					if(modelChildren.contains(event.getNotifier())) {
						return;
					}
				}
			}
		«ENDIF»
			super.handleNotificationEvent(event);
			«FOR extendedObject : it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v |v.genView.contains(it)].toIterable»
				«IF extendedObject.propRefreshHook !=null»
					«specificHandleNotificationEventBody(extendedObject.propRefreshHook)»
				«ENDIF»
			«ENDFOR»
			
		 	}
	«ENDIF»

'''

def specificHandleNotificationEventBody(PropertyRefreshHook it)'''
«IF (it.comment !=null)»
//«it.comment»
«ENDIF»
if (resolveSemanticElement() != null) {
if(«it.triggeringCondition»){
	«it.action»;
	refreshVisuals();
}
}
'''
//END: PapyrusGenCode

override addBorderItem (GenNode it)'''
	«IF getExternalLabels(it).size > 0»
		«generatedMemberComment»
		protected void addBorderItem(org.eclipse.draw2d.IFigure borderItemContainer, org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart borderItemEditPart) {
		«IF getExternalLabelsWithoutSpecificLocator(it).size > 0»	
			if («FOR label : getExternalLabelsWithoutSpecificLocator(it) SEPARATOR ' || '»borderItemEditPart instanceof «label.getEditPartQualifiedClassName()»«ENDFOR») {
				org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator locator = new org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator(getMainFigure(), org.eclipse.draw2d.PositionConstants.SOUTH);
				locator.setBorderItemOffset(new org.eclipse.draw2d.geometry.Dimension(-20, -20));
				borderItemContainer.add(borderItemEditPart.getFigure(), locator);
			} else
		«ENDIF»
		«FOR label : getExternalLabelsWithSpecificLocator(it)»
			if (borderItemEditPart instanceof «label.getEditPartQualifiedClassName()») {
				org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator locator = new «getSpecificLocator(label)»(getMainFigure());
				borderItemContainer.add(borderItemEditPart.getFigure(), locator);
			} else
		«ENDFOR»
			{
				super.addBorderItem(borderItemContainer, borderItemEditPart);
			}
		}
	«ENDIF»
'''

override setupNodePlate (GenNode it) ''''''

def setupNodePlate (GenChildSideAffixedNode it)'''
	//FIXME: workaround for #154536
	result.getBounds().setSize(result.getPreferredSize());
'''
		
}
