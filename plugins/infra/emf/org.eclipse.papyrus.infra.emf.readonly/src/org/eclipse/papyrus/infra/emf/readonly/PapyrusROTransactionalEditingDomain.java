/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Support object-level read/write controls (CDO)
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.IRollbackStatus;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.resource.RollbackStatus;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;


public class PapyrusROTransactionalEditingDomain extends TransactionalEditingDomainImpl {

	public PapyrusROTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		if((resource != null) && (resource.getURI() != null)) {
			return ReadOnlyManager.getReadOnlyHandler(this).anyReadOnly(ReadOnlyAxis.anyAxis(), new URI[]{ resource.getURI() }).get();
		}
		return false;
	}

	public boolean isReadOnly(EObject eObject) {
		return ReadOnlyManager.getReadOnlyHandler(this).isReadOnly(ReadOnlyAxis.anyAxis(), eObject).get();
	}
	
	@Override
	protected TransactionChangeRecorder createChangeRecorder(ResourceSet rset) {
		// Ensure that the ControlledResourceTracker gets in ahead of the change recorder so that it processes
		// notifications pertaining to sub-model unit structure, first, to ensure correct determination of
		// read-only state for cross-model-referenced objects
		ControlledResourceTracker.getInstance(this);
		
		return doCreateChangeRecorder(rset);
	}

	protected TransactionChangeRecorder doCreateChangeRecorder(ResourceSet rset) {
		return new TransactionChangeRecorder(this, rset) {
			@Override
			protected void appendNotification(Notification notification) {
				// Append to the transaction first
				super.appendNotification(notification);
				
				if (!NotificationFilter.READ.matches(notification)) {
					// Check whether we are modifying a read-only object
					assertNotReadOnly(notification.getNotifier());
				}
			}
		};
	}
	
	protected void assertNotReadOnly(Object object) {
		InternalTransaction tx = getActiveTransaction();

		// If there's no transaction, then there will be nothing to roll back.  And if it's unprotected, let the client do whatever.
		// And, of course, don't interfere with rollback!  Finally, if we're already going to roll back, don't bother
		if((tx != null) && !tx.isRollingBack() //
			&& !Boolean.TRUE.equals(tx.getOptions().get(Transaction.OPTION_UNPROTECTED)) //
			&& !willRollBack(tx)) {
			
			boolean readOnly;

			// Check for Resource first because CDO resources *are* EObjects
			if(object instanceof Resource) {
				Resource.Internal resource = (Resource.Internal)object;
				if(resource.isLoading()) {
					// We must be able to modify read-only resources in order to load them
					return;
				}
				readOnly = isReadOnly(resource) && !makeWritable(resource);
			} else if(object instanceof EObject) {
				EObject eObject = (EObject)object;
				readOnly = isReadOnly(eObject) && !makeWritable(eObject);
			} else {
				// If it's not an EMF-managed object, we don't care
				readOnly = false;
			}

			if(readOnly) {
				String message = "Attempt to modify object(s) in a read-only model."; //$NON-NLS-1$
				Collection<?> offenders = Collections.singleton(object);
				tx.abort(new RollbackStatus(Activator.PLUGIN_ID, IRollbackStatus.READ_ONLY_OBJECT, message, offenders));
			}
		}
	}

	private boolean willRollBack(Transaction tx) {
		IStatus status = tx.getStatus();
		return (status != null) && (status.getSeverity() >= IStatus.ERROR);
	}
	
	protected boolean makeWritable(Resource resource) {
		URI[] uris = getCompositeModelURIs(resource.getURI());
		IReadOnlyHandler2 handler = ReadOnlyManager.getReadOnlyHandler(this);

		if(!handler.canMakeWritable(ReadOnlyAxis.anyAxis(), uris).or(false)) {
			return false;
		}

		return handler.makeWritable(ReadOnlyAxis.anyAxis(), uris).get();
	}

	protected boolean makeWritable(EObject object) {
		boolean result;

		URI uri = EcoreUtil.getURI(object);

		// If it's a workspace resource, we don't have to worry about object-level read-only state
		if(uri.isPlatformResource()) {
			result = makeWritable(object.eResource());
		} else {
			IReadOnlyHandler2 handler = ReadOnlyManager.getReadOnlyHandler(this);

			if(!handler.canMakeWritable(ReadOnlyAxis.anyAxis(), object).or(false)) {
				result = false;
			} else {
				result = handler.makeWritable(ReadOnlyAxis.anyAxis(), object).get();
			}
		}

		return result;
	}
	
	/**
	 * Obtains the complete set of URIs for members of the composite model resource of which the given URI is one member.
	 * 
	 * @param memberURI a member of a composite Papyrus model
	 * 
	 * @return the complete set of member resources (which could just be the original {@code memberURI})
	 */
	protected URI[] getCompositeModelURIs(URI memberURI) {
		URI[] result = null;

		if(memberURI.isPlatformResource()) {
			// We don't have object-level read-only state in the workspace (perhaps in CDO repositories)
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(memberURI.trimFragment().toPlatformString(true)));
			if((file != null) && file.exists()) {
				IPapyrusFile composite = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
				Set<URI> memberURIs = new HashSet<URI>();
				for(IFile member : OneFileUtils.getAssociatedFiles(composite)) {
					memberURIs.add(URI.createPlatformResourceURI(member.getFullPath().toString(), true));
				}
				result = memberURIs.toArray(new URI[memberURIs.size()]);
			}
		}

		if(result == null) {
			result = new URI[]{ memberURI };
		}

		return result;
	}

	@Override
	public void dispose() {
		super.dispose();
		resourceSet = null;
		adapterFactory = null;
		ReadOnlyManager.roHandlers.remove(this);
	}
}
