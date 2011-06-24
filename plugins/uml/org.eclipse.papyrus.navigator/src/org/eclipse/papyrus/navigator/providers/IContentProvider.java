package org.eclipse.papyrus.navigator.providers;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 **/
public interface IContentProvider extends ICommonContentProvider {

	public void resourceSetChanged(ResourceSetChangeEvent event);
}
