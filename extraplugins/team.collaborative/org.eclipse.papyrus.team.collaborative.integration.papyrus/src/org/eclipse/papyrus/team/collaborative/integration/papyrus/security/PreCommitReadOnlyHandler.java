package org.eclipse.papyrus.team.collaborative.integration.papyrus.security;

import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.actions.LockAction;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.utils.CollabFunctionsFactory;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;


/**
 * This model snippet will register a new {@link ResourceSetListener} that will provide a new security on modifed resources.
 * Each time a resource will be set to modified this listener will check that the resources has been locked. If the resources is not lock then it will
 * try to rollback the current transaction
 * 
 * @author adaussy
 * 
 */
public class PreCommitReadOnlyHandler implements IModelSetSnippet {

	/**
	 * This {@link ResourceSetListener} will listen each time a resource is modified to check that it has been locked or will ask for lock
	 * 
	 * @author adaussy
	 * 
	 */
	private static class ResourceSetListener extends ResourceSetListenerImpl {

		@Override
		public boolean isPostcommitOnly() {
			return false;
		}

		@Override
		public boolean isPrecommitOnly() {
			return true;
		}

		@Override
		public boolean isAggregatePrecommitListener() {
			return false;
		}

		/**
		 * Filter only IS_MODIFIED notification
		 */
		private static NotificationFilter filter = NotificationFilter.createFeatureFilter(Resource.class, Resource.RESOURCE__IS_MODIFIED);

		@Override
		public NotificationFilter getFilter() {
			return filter;
		}


		@Override
		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			final Set<Resource> resourceToTest = new HashSet<Resource>();
			for(Notification n : event.getNotifications()) {
				if(n.getNewBooleanValue()) {
					Resource resource = (Resource)n.getNotifier();
					//Filtered out any DI resource. Those resource are not collaborative resources
					if(!DiModel.MODEL_FILE_EXTENSION.equals(resource.getURI().fileExtension())) {
						resourceToTest.add(resource);
					}
				}
			}
			if(!resourceToTest.isEmpty()) {
				TransactionalEditingDomain editingDomain = event.getEditingDomain();
				ResourceSet resourceSet = editingDomain.getResourceSet();
				HashSet<IExtendedURI> uriToTest = Sets.newHashSet(Collections2.transform(resourceToTest, CollabFunctionsFactory.getResourceToExtendedURIWithContainment()));
				if(ICollaborativeManager.INSTANCE.isCollab(uriToTest, resourceSet)) {
					Set<IExtendedURI> uriToLock = new HashSet<IExtendedURI>();
					ILocker locker = ICollaborativeManager.INSTANCE.getLocker(uriToTest, resourceSet);
					if(locker == null) {
						return null;
					}
					for(IExtendedURI extendURI : locker.getExtendedSet()) {
						if(!locker.isLocked(extendURI).isOK()) {
							uriToLock.add(extendURI);
						}
					}
					if(!uriToLock.isEmpty()) {
						final IStatus status = LockAction.doSafeLock(resourceSet, uriToLock, true);
						if(!status.isOK()) {
							UIUtils.errorDialog(status, "Unable to lock");
							throw new RollbackException(status);

						}
					}
				}
			}
			return null;
		}
	}

	public PreCommitReadOnlyHandler() {
	}


	private WeakHashMap<EditingDomain, ResourceSetListener> link = new WeakHashMap<EditingDomain, PreCommitReadOnlyHandler.ResourceSetListener>();

	public void start(ModelSet modelsManager) {
		TransactionalEditingDomain transactionalEditingDomain = modelsManager.getTransactionalEditingDomain();
		ResourceSetListener listener = new ResourceSetListener();
		link.put(transactionalEditingDomain, listener);
		transactionalEditingDomain.addResourceSetListener(listener);

	}

	public void dispose(ModelSet modelsManager) {
		TransactionalEditingDomain transactionalEditingDomain = modelsManager.getTransactionalEditingDomain();
		transactionalEditingDomain.removeResourceSetListener(link.get(transactionalEditingDomain));

	}



}
