/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
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
 */
package aspects.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView
import xpt.Common

@Singleton class CompartmentEditPart extends diagram.editparts.CompartmentEditPart {
	@Inject extension Common;

	override extendsList(GenCompartment it) '''

«««BEGIN: PapyrusGenCode
«««Add own extension
«IF it.eResource.allContents.filter(typeof(ExtendedGenView)).filter[v|v.genView.contains(it) && v.superOwnedEditPart != null].size != 0»
	extends «FOR extendedObject : it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v|v.genView.contains(it) && v.superOwnedEditPart != null].toIterable»
	«specifyInheritance(extendedObject as ExtendedGenView)»
«ENDFOR»
«««END: BEGIN: PapyrusGenCode
«ELSE»
  extends «IF listLayout»org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart«ELSE»org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart«ENDIF»
«ENDIF»
	'''

	//BEGIN: PapyrusGenCode
	//definition of the inheritance
	def specifyInheritance(ExtendedGenView it) '''«superOwnedEditPart»'''

	//END: PapyrusGenCode
	override additions(GenCompartment it) '''
		«handleSize(it)»
		«refreshbound(it)»
		«refreshvisual(it)»
	'''

	def handleSize(GenCompartment it) '''
	«generatedMemberComment»
protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification notification) {
		Object feature = notification.getFeature();
		if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width().equals(feature)
			|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height().equals(feature)
			|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X().equals(feature)
			|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y().equals(feature)) {
			refreshBounds();
		}
		super.handleNotificationEvent(notification);
	} 
'''

	def refreshbound(GenCompartment it) '''
		«generatedMemberComment»
		protected void refreshBounds() {
			int width = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width())).intValue();
			int height = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height())).intValue();
			org.eclipse.draw2d.geometry.Dimension size = new org.eclipse.draw2d.geometry.Dimension(width, height);
			int x = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int y = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			org.eclipse.draw2d.geometry.Point loc = new org.eclipse.draw2d.geometry.Point(x, y);
			((org.eclipse.gef.GraphicalEditPart) getParent()).setLayoutConstraint(
				this,
				getFigure(),
				new org.eclipse.draw2d.geometry.Rectangle(loc, size));
		}
	'''

	def refreshvisual(GenCompartment it) '''
	«generatedMemberComment»
protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBounds();
	}
'''
}
