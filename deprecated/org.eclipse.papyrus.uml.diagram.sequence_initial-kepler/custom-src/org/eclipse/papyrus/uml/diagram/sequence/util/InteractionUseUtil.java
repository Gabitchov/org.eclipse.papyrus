package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.uml2.uml.Interaction;


public class InteractionUseUtil {

	public static Diagram findDiagram(View view, Interaction refInteraction) {
		Diagram diagram = view.getDiagram();
		EList<EObject> list = diagram.eResource().getContents();
		for(EObject o : list) {
			if(o instanceof Diagram) {
				Diagram ref = (Diagram)o;
				if(refInteraction.equals(ref.getElement())) {
					return ref;
				}
			}
		}

		return null;
	}

	public static void openDiagram(Diagram diag) {
		IPageManager pageMngr;
		try {
			pageMngr = ServiceUtilsForEObject.getInstance().getIPageManager(diag);
		} catch (Exception e) {
			return;
		}
		if(pageMngr != null) {
			if(pageMngr.allPages().contains(diag)) {
				/**
				 * Close the diagram if it was already open
				 */
				if(pageMngr.isOpen(diag)) {
					pageMngr.selectPage(diag);
				} else {
					pageMngr.openPage(diag);
				}
			}
		}
	}
}
