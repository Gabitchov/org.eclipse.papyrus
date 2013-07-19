package org.eclipse.papyrus.uml.modelrepair.ui.providers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.swt.graphics.Image;

import com.google.common.base.Optional;


public class ResourceLabelProvider extends ColumnLabelProvider {

	protected ResourceSet resourceSet;

	public ResourceLabelProvider(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	@Override
	public void update(ViewerCell cell) {
		switch(cell.getColumnIndex()) {
		case 0: //Resource
			updateResource(cell);
			break;
		case 1: //Location
			updateLocation(cell);
			break;
		case 2: //Read-only
			updateReadOnly(cell);
			break;
		}
	}

	protected void updateResource(ViewerCell cell) {
		cell.setText(getResourceText(cell.getElement()));
		cell.setImage(getResourceImage(cell.getElement()));
	}

	protected void updateLocation(ViewerCell cell) {
		cell.setText(getLocationText(cell.getElement()));
	}

	private String getLocationText(Object element) {
		URI uri = getURI(element);
		if(uri != null) {
			return uri.toString();
		}
		return "Unknown";
	}

	protected void updateReadOnly(ViewerCell cell) {
		cell.setText(getReadOnlyText(cell.getElement()));
	}

	private String getReadOnlyText(Object element) {
		URI uri = getURI(element);
		if(uri == null) {
			return "?";
		}

		EditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet);
		Optional<Boolean> readOnly = ReadOnlyManager.getReadOnlyHandler(domain).anyReadOnly(new URI[]{ uri });
		if(readOnly.isPresent()) {
			return readOnly.get() ? "true" : "false";
		} else {
			return "false";
		}

	}

	public String getResourceText(Object element) {
		URI uri = getURI(element);
		if(uri == null) {
			return null;
		}

		return uri.lastSegment();
	}

	protected URI getURI(Object element) {
		if(element instanceof URI) {
			return (URI)element;
		}

		if(element instanceof Resource) {
			return ((Resource)element).getURI();
		}

		return null;
	}

	public Image getResourceImage(Object element) {
		URI uri = getURI(element);
		if(uri == null) {
			return null;
		}


		String extension = uri.fileExtension();

		if("uml".equals(extension)) {

		}
		if("di".equals(extension)) {

		}
		if("notation".equals(extension)) {

		}

		return null;
	}
}
