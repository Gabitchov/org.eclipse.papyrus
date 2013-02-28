package org.eclipse.papyrus.infra.nattable.views.editor.managers;

import java.util.List;

import org.eclipse.papyrus.infra.nattable.manager.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;

public class EditorFeatureAxisManager extends AbstractAxisManager {

	@Override
	public synchronized void updateAxisContents() {
		final List<Object> elements = getTableManager().getElementsList(
				getRepresentedContentProvider());
		for (final IAxis current : getRepresentedContentProvider().getAxis()) {
			if (current instanceof IdAxis) {
				final String id = (String) current.getElement();
				if (id.startsWith("nattable_editor_pages:/")
						&& !elements.contains(id)) {
					elements.add(id);
				}
			}
		}
	}
}
