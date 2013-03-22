package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.uml2.uml.Interaction;


public class InteractionUseUtil {
 
	public static Diagram findDiagram(View view, Interaction refInteraction) {
		Diagram diagram = view.getDiagram();
		EList<EObject> list = diagram.eResource().getContents();
		for(EObject o : list)
			if(o instanceof Diagram){
				Diagram ref = (Diagram)o;
				if(refInteraction.equals(ref.getElement()))
					return ref;
			}
		
		return null;
	}
 
	public static void openDiagram(Diagram diag){
		IPageMngr pageMngr = null;
		try {
			pageMngr = ServiceUtilsForActionHandlers.getInstance().getIPageMngr();
		} catch (Exception e) {
		}
		if(pageMngr != null) {
			if(pageMngr.allPages().contains(diag)) {
				/**
				 * Close the diagram if it was already open
				 */
				if(pageMngr.isOpen(diag)) {
					pageMngr.closePage(diag);
				}
				pageMngr.openPage(diag);
			}
		}
 	}
}
