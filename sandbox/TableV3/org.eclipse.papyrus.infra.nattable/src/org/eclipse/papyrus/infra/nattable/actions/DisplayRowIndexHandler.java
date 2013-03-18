package org.eclipse.papyrus.infra.nattable.actions;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.ui.handlers.HandlerUtil;


public class DisplayRowIndexHandler extends AbstractTableHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final AbstractAxisConfiguration configuration = getCurrentNattableModelManager().getTable().getHorizontalAxisProvider().getAxisConfiguration();
		if(configuration instanceof DefaultAxisConfiguration){
			Command command = event.getCommand();
			boolean oldValue = HandlerUtil.toggleCommandState(command);
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getCurrentNattableModelManager().getTable());
			
			final org.eclipse.emf.common.command.Command cmd = SetCommand.create(domain, configuration, NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_DisplayIndex(), !oldValue);
			domain.getCommandStack().execute(cmd);
		}


		return null;
	}

}
