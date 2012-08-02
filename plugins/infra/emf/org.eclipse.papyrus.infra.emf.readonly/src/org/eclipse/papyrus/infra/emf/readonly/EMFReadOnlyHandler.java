package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;


public class EMFReadOnlyHandler implements IReadOnlyHandler {

	public boolean isReadOnly(URI[] uris, EditingDomain editingDomain) {
		for(URI uri : uris) {
			if(!uri.isPlatformResource()) {
				return true;
			}
		}

		return false;
	}

	public boolean enableWrite(URI[] uris, EditingDomain editingDomain) {
		return false; //We cannot change the read-only status
	}

}
