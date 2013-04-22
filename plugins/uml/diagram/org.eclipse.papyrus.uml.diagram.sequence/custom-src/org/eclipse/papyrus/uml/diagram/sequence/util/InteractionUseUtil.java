package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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

	public static void openDiagram(final Diagram diagram) {
		final IPageManager pageManager;
		TransactionalEditingDomain editingDomain;
		try {
			pageManager = ServiceUtilsForEObject.getInstance().getIPageManager(diagram);
			editingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(diagram);
		} catch (Exception e) {
			return;
		}
		if(pageManager != null) {
			if(pageManager.allPages().contains(diagram)) {
				/**
				 * Close the diagram if it was already open
				 */
				if(pageManager.isOpen(diagram)) {
					pageManager.selectPage(diagram);
				} else {
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Open diagram") {

						@Override
						protected void doExecute() {
							pageManager.openPage(diagram);
						}
					});
				}
			}
		}
	}
}
