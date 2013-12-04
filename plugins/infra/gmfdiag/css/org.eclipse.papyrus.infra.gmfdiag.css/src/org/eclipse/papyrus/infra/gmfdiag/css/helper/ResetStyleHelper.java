package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.command.ResetStyleCommand;


public class ResetStyleHelper {

	public static void resetStyle(IStructuredSelection selection) {
		if(selection == null || selection.isEmpty()) {
			return;
		}

		Iterator<?> selectionIterator = selection.iterator();

		TransactionalEditingDomain editingDomain = getEditingDomain(selectionIterator);

		resetStyle(editingDomain, selection.iterator());
	}

	public static void resetStyle(Collection<?> selection) {
		if(selection == null) {
			return;
		}

		TransactionalEditingDomain editingDomain = getEditingDomain(selection.iterator());

		resetStyle(editingDomain, selection.iterator());
	}

	public static void resetStyle(TransactionalEditingDomain domain, Iterator<?> iterator) {
		if(domain == null || iterator == null || !iterator.hasNext()) {
			return;
		}

		Command command = new ResetStyleCommand(domain, iterator);
		domain.getCommandStack().execute(command);
	}

	private static TransactionalEditingDomain getEditingDomain(Iterator<?> iterator) {
		while(iterator.hasNext()) {
			Object selectedItem = iterator.next();
			View view = NotationHelper.findView(selectedItem);
			if(view == null) {
				continue;
			}

			EditingDomain editingDomain = EMFHelper.resolveEditingDomain(view);
			if(editingDomain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain)editingDomain;
			}
			break;
		}

		return null;
	}

}
