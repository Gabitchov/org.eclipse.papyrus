package org.eclipse.papyrus.readonly;

import org.eclipse.core.resources.IFile;

public interface IReadOnlyHandler {

	boolean isReadOnly(IFile[] files);

	boolean enableWrite(IFile[] files);
}
