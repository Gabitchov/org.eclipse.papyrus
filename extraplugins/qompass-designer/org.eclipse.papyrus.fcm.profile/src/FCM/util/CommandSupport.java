package FCM.util;

import java.util.Collections;

import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * Utility function. Allow adaption to command stack
 *
 * @author ansgar
 *
 */
public class CommandSupport
{
	public static boolean isWriteTransactionActive(TransactionalEditingDomain domain) {
		if (domain instanceof InternalTransactionalEditingDomain) {
			InternalTransactionalEditingDomain internalDomain = (InternalTransactionalEditingDomain) domain;
			InternalTransaction transaction = internalDomain.getActiveTransaction();
			if (transaction != null && !transaction.isReadOnly()) {
				return true;
			}
 		}
		return false;
	}
	
	
	/**
	 * Execute the passed Runnable within a command
	 * @param label
	 * @param command
	 */
	public static void exec (TransactionalEditingDomain domain, String label, final Runnable command)
	{
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		try {
			AbstractTransactionalCommand transactionCommand = new AbstractTransactionalCommand (domain, label, Collections.EMPTY_LIST) {
				public CommandResult doExecuteWithResult (IProgressMonitor dummy, IAdaptable info) {
					command.run ();
		               return CommandResult.newOKCommandResult();
				}
			};

			history.execute (transactionCommand, null, null);
		}
		catch (CommandException e) {
			e.printStackTrace ();
		}
	}
}
