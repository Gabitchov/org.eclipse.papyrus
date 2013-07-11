package org.eclipse.papyrus.infra.table.efacet.queries;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;

/**
 * 
 * An abstract class to get the pageMngr
 * 
 */
//TODO duplicated code from modelexplorer.views
//TODO should be refactored and store into an upper plugin like oep.infra.core.xxx
public abstract class AbstractEditorContainerQuery {//we don't need to implements IJavaModelQuery  here

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	protected IPageMngr getPageMngr() throws ServiceException {
		// pageMngr can't be static, because there is a new IPageMngr each time we open a Papyrus Editor
		final IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
		if(papyrusEditor != null) {
			final ServicesRegistry serviceRegistry = papyrusEditor.getServicesRegistry();
			return ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
		}
		throw new ServiceException("Can't retrieve the IPageMngr"); //$NON-NLS-1$
	}
}
