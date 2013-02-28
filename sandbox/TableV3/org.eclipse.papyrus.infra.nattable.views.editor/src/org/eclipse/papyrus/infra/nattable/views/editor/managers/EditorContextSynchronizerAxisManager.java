package org.eclipse.papyrus.infra.nattable.views.editor.managers;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.manager.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.*;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;

public class EditorContextSynchronizerAxisManager extends AbstractAxisManager {

	@Override
	public synchronized void updateAxisContents() {
		final List<Object> elements = getTableManager().getElementsList(
				getRepresentedContentProvider());
		final EObject tableContext = getTable().getContext();
		IPageManager pageManager = null;
		try {
			pageManager = ServiceUtilsForResource.getInstance()
					.getIPageManager(getTable().eResource());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (final Object current : pageManager.allPages()) {
			if (current instanceof EObject) {
				final EObject eobject = (EObject) current;
				final EStructuralFeature feature = eobject.eClass()
						.getEStructuralFeature("context");
				if (feature != null) {
					final EObject value = (EObject) eobject.eGet(feature);
					if (value == tableContext) {
						if (!elements.contains(current)) {
							elements.add(current);
						}
					}
					final TreeIterator<EObject> tree = tableContext
							.eAllContents();
					while (tree.hasNext()) {
						if (tree.next().equals(value)) {
							if (!elements.contains(current)) {
								elements.add(current);
							}
							break;
						}
					}
				}
			}

		}

		//
		// for (final IAxis current : getRepresentedContentProvider().getAxis())
		// {
		// if (current instanceof IdAxis) {
		// final String id = (String) current.getElement();
		// if (id.startsWith("nattable_editor_pages:/")
		// && !elements.contains(id)) {
		// elements.add(id);
		// }
		// }
		// }
	}
}
