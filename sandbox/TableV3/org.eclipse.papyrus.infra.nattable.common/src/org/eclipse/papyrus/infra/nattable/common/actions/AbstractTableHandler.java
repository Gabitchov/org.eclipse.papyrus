package org.eclipse.papyrus.infra.nattable.common.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.ui.IEditorPart;


public abstract class AbstractTableHandler extends AbstractHandler {

	protected IEditorPart getCurrentTableEditor(final ExecutionEvent event) {
		try {
			return ServiceUtilsForHandlers.getInstance().getNestedActiveIEditorPart(event);
		} catch (final ServiceException e) {
			Activator.log.error("Current Editor can't be found", e);
		}
		return null;
	}

	protected NatTable getCurrentNattable(final ExecutionEvent event) {
		final AbstractEMFNattableEditor editor = (AbstractEMFNattableEditor)getCurrentTableEditor(event);
		if(editor != null) {
			return (NatTable)editor.getAdapter(NatTable.class);
		}
		return null;

	}
}
