package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Image;

public class ElementIconUtil {

	public static Image getLabelIcon(GraphicalEditPart part){
		EObject parserElement = part.resolveSemanticElement();
		if(parserElement == null) {
			return null;
		}

		List<View> views = DiagramEditPartsUtil.findViews(parserElement, part.getViewer());
		for(View view : views) {
			//if(NameLabelIconHelper.showLabelIcon(view)) {
			if(AppearanceHelper.showElementIcon(view)){
				return UMLElementTypes.getImage(parserElement.eClass());
			}
		}
		return null;	
	}
	
	public static boolean isIconNotification(Notification event){
		if(event.getNewValue() instanceof EAnnotation && VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON.equals(((EAnnotation)event.getNewValue()).getSource())) {
			return true;
		}
		return false;
	}
}
