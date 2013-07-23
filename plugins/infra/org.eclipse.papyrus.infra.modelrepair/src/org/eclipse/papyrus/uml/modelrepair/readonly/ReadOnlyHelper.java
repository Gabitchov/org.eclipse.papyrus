package org.eclipse.papyrus.uml.modelrepair.readonly;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;

import com.google.common.base.Optional;


public class ReadOnlyHelper {

	public static boolean isReadOnly(Resource r) {
		EditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(r.getResourceSet());
		if(domain == null && r.getResourceSet() instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider)r.getResourceSet()).getEditingDomain();
		}
		IReadOnlyHandler readOnlyHandler = ReadOnlyManager.getReadOnlyHandler(domain);

		Iterator<EObject> iterator = r.getAllContents();
		while(iterator.hasNext()) {
			Optional<Boolean> readOnly = readOnlyHandler.isReadOnly(iterator.next());
			if(!readOnly.isPresent()) {
				return false;
			}

			if(!readOnly.get()) {
				return false;
			}
		}

		//True if each element is read only
		return true;
	}
}
