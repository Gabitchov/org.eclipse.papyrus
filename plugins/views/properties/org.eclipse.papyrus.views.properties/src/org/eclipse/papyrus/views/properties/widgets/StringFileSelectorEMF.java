package org.eclipse.papyrus.views.properties.widgets;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.emf.utils.EMFFileUtil;
import org.eclipse.papyrus.infra.widgets.editors.StringFileSelector;
import org.eclipse.swt.widgets.Composite;


public class StringFileSelectorEMF extends StringFileSelector {

	public StringFileSelectorEMF(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void setResult(IFile file) {
		text.setText(EMFFileUtil.getPath(file));
		notifyChange();
	}

	@Override
	protected void setResult(File file) {
		setResult(file.getAbsolutePath());
	}

	@Override
	protected void setResult(String path) {
		URI uri = URI.createFileURI(path);
		text.setText(uri.toString());
		notifyChange();
	}

	@Override
	protected IFile getIFile(String path) {
		return EMFFileUtil.getIFile(path);
	}

	@Override
	protected File getFile(String path) {
		return EMFFileUtil.getFile(path);
	}

}
