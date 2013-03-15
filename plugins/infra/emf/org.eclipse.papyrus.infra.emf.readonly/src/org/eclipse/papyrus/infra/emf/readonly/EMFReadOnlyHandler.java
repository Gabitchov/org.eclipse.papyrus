package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Optional;


public class EMFReadOnlyHandler extends AbstractReadOnlyHandler {

	public Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain) {
		for(URI uri : uris) {
			if(!uri.isPlatformResource()) {
				return Optional.of(Boolean.TRUE);
			}
		}

		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(URI[] uris, EditingDomain editingDomain) {
		return Optional.absent(); //We cannot change the read-only status
	}

}
