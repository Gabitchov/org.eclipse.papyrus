package org.eclipse.papyrus.table.modelexplorer.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;

/**
 * This class provides a NavigatorContentProvider used to display tables in the Model Explorer
 * 
 * 
 * 
 */
public class NavigatorTableContentProvider extends MoDiscoContentProvider {


	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		ArrayList<Object> result = new ArrayList<Object>();

		/**
		 * We look for diagrams and tables
		 */
		if(parentElement instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)parentElement).getAdapter(EObject.class);
			if(eObject != null) {
				List<TableInstance> tableList = findAllExistingTables(eObject);
				Iterator<TableInstance> iter = tableList.iterator();
				while(iter.hasNext()) {
					result.add(iter.next());
				}
			}
		}
		return result.toArray();
	}

	/**
	 * @param owner
	 *        the owner of the tables
	 * @return the list of tables contained by the given owner
	 */
	private List<TableInstance> findAllExistingTables(EObject owner) {
		ArrayList<TableInstance> tables = new ArrayList<TableInstance>();



		if(pageMngr != null) {

			// Walk on page (Table) references
			for(Object page : pageMngr.allPages()) {
				if(!(page instanceof TableInstance)) {
					continue;
				}
				// We have a Table
				TableInstance table = (TableInstance)page;
				if(owner.equals(table.getContext())) {
					tables.add(table);
				}

			}
		}
		return tables;
	}


}
