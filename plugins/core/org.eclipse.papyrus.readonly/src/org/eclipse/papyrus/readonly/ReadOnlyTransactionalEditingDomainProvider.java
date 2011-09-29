package org.eclipse.papyrus.readonly;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.IResourceUndoContextPolicy;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.commands.NotifyingWorkspaceCommandStack;
import org.eclipse.papyrus.resource.ITransactionalEditingDomainProvider;

public class ReadOnlyTransactionalEditingDomainProvider implements ITransactionalEditingDomainProvider {

	public TransactionalEditingDomain createTransactionalEditingDomain(ResourceSet resourceSet) {
		NotifyingWorkspaceCommandStack stack = new NotifyingWorkspaceCommandStack(CheckedOperationHistory.getInstance());
		stack.setResourceUndoContextPolicy(IResourceUndoContextPolicy.DEFAULT);

		TransactionalEditingDomain result = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack, resourceSet) {

			@Override
			public boolean isReadOnly(Resource resource) {
				if(resource != null) {
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resource.getURI().toPlatformString(true)));
					if(file != null) {
						return ReadOnlyManager.isReadOnly(file);
					}
				}
				return false;
			}
		};

		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(result);

		return result;
	}

}
