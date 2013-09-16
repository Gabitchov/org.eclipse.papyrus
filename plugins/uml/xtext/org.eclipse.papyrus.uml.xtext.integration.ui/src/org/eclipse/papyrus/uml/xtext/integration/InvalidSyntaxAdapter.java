package org.eclipse.papyrus.uml.xtext.integration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * {@link EContentAdapter} that listens for modifications outside the xtext cell
 * editor to remove the annotation that stores the invalid string. 
 * 
 * @author muelder
 * 
 */
public class InvalidSyntaxAdapter extends EContentAdapter {
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getFeature() != EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS) {
			Object notifier = notification.getNotifier();
			if (notifier instanceof EModelElement) {
				EModelElement eModelElement = (EModelElement) notifier;
				EAnnotation eAnnotation = eModelElement
						.getEAnnotation(DefaultXtextDirectEditorConfiguration.ANNOTATION_SOURCE);
				if (eAnnotation != null) {
					eModelElement.getEAnnotations().remove(eAnnotation);
				}
			}
		}
	}
}