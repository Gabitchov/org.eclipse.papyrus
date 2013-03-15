package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;

import com.google.common.base.Optional;

public abstract class AbstractReadOnlyHandler implements IReadOnlyHandler {

	public Optional<Boolean> isReadOnly(EObject eObject, EditingDomain editingDomain) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return anyReadOnly(new URI[] {res.getURI()}, editingDomain);
		}
		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(EObject eObject, EditingDomain editingDomain) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return makeWritable(new URI[] {res.getURI()}, editingDomain);
		}
		return Optional.absent();
	}

}
