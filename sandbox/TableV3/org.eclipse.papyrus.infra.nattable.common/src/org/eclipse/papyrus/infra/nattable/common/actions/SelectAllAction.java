package org.eclipse.papyrus.infra.nattable.common.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectAllCommand;


public class SelectAllAction extends AbstractTableHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final NatTable nattable = getCurrentNattable(event);
		if(nattable != null) {
			nattable.doCommand(new SelectAllCommand());
		}
		return null;
	}

}
