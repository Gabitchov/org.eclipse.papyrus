package org.eclipse.papyrus.uml.xtext.integration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

/**
 * {@link EContentAdapter} that listens for modifications outside the xtext cell
 * editor to remove the text comment that stores the invalid string.
 * 
 * @author muelder
 * 
 */
public class InvalidSyntaxAdapter extends EContentAdapter {
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getNotifier() instanceof Element) {
			Element element = (Element) notification.getNotifier();
			Comment comment = InvalidStringUtil
					.getTextualRepresentationComment(element);
			if (comment != null)
				element.getOwnedComments().remove(comment);

		}
	}
}