package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;

public class OrphanViewPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {

	private ArrayList notOrphanList = new ArrayList();

	private static Pattern digit = Pattern.compile("\\d*");

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		getDiagramEventBroker().addNotificationListener(((EObject) getHost().getModel()), this);
		getDiagramEventBroker().addNotificationListener(((View) getHost().getModel()).getElement(), this);
		super.activate();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(((EObject) getHost().getModel()), this);
		getDiagramEventBroker().removeNotificationListener(((View) getHost().getModel()).getElement(), this);
		super.deactivate();
	}

	/**
	 * Deletes a list of views. The views will be deleted <tt>iff</tt> their semantic element has
	 * also been deleted.
	 * 
	 * @param views
	 *            an iterator on a list of views.
	 * @return <tt>true</tt> if the host editpart should be refreshed; either one one of the
	 *         supplied views was deleted or has been reparented.
	 */
	protected final boolean deleteViews(Iterator views) {

		final CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
		while (views.hasNext()) {
			View view = (View) views.next();
			cc.add(getDeleteViewCommand(view));
		}

		boolean doDelete = !cc.isEmpty() && cc.canExecute();
		if (doDelete) {
			executeCommand(cc);
		}
		return doDelete;
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * @param cmd
	 *            command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommand(final Command cmd) {
		Map options = null;
		EditPart ep = getHost();
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if (viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer) viewer).isInitializing();
		}

		if (isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart) getHost(), false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart) getHost()).getEditingDomain(),
				StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(),
					"executeCommand", e); //$NON-NLS-1$
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING,
					"executeCommand", e); //$NON-NLS-1$
		}
	}

	private List findOrphanView(Iterator<EObject> viewChildrenIterator) {
		ArrayList<EObject> orphanView = new ArrayList<EObject>();
		while (viewChildrenIterator.hasNext()) {
			EObject view = viewChildrenIterator.next();
			if (view instanceof View) {
				if (isOrphaned((View) view)) {
					orphanView.add(view);
				}
			}
		}
		return orphanView;
	}

	/**
	 * gets a {@link Command} to delete the supplied {@link View}.
	 * 
	 * @param view
	 *            view to use
	 * @return command
	 */
	protected Command getDeleteViewCommand(View view) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return new ICommandProxy(new DeleteCommand(editingDomain, view));
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	public void init(int[] notOrphanVisualID) {
		for (int i = 0; i < notOrphanVisualID.length; i++) {
			notOrphanList.add(new Integer(notOrphanVisualID[i]));
		}
	}

	protected boolean isOrphaned(View view) {
		String semanticHint = view.getType();
		boolean t = view.isSetElement();
		if (isInteger(semanticHint) && notOrphanList.contains(new Integer(semanticHint))) {
			return false;
		}
		return !view.isSetElement();
	}

	/**
	 * Checks if the string is an integer.
	 * 
	 * @param s
	 *            the specified string
	 * 
	 * @return true, if is integer
	 */
	public static boolean isInteger(String s) {
		boolean result = false;
		Matcher matcher = digit.matcher(s);
		if (matcher != null) {
			result = matcher.matches();
		}
		return result;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		if (Notification.REMOVE == notification.getEventType() || Notification.SET == notification.getEventType()) {
			refreshViews();
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected List refreshViews() {
		Edge viewChild;
		EObject semanticChild;
		//
		// current connection views
		Iterator<EObject> viewChildrenIterator = ((EObject) getHost().getModel()).eContents().iterator();

		List orphaned = findOrphanView(viewChildrenIterator);
		//
		// delete all the remaining views
		deleteViews(orphaned.iterator());

		//
		// create a view for each remaining semantic element.
		List viewDescriptors = new ArrayList();

		return viewDescriptors;
	}
}
