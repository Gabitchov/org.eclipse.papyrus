/**
 *
 */
package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.Activator;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.TransactionHelper;


/**
 * A content provider based on EMF di and using Transactions.
 * This implementation is a wrapper on {@link DiContentProvider}.
 * Each method is wrapped in a {@link RecordingCommand}.
 * 
 * @author cedric dumoulin
 * 
 */
public class TransactionalDiContentProvider implements ISashWindowsContentProvider {

	/**
	 * wrapped ContentProvider. All commands will use this provider.
	 */
	private DiContentProvider diContentProvider;

	private TransactionalEditingDomain editingDomain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diContentProvider
	 */
	public TransactionalDiContentProvider(DiContentProvider diContentProvider, TransactionalEditingDomain editingDomain) {
		this.diContentProvider = diContentProvider;
		this.editingDomain = editingDomain;
	}

	/**
	 * Get the editing domain used to perform transactions.
	 * 
	 * @return
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain() {
		return editingDomain;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#addPage(java.lang.Object)
	 * @param page
	 * 
	 */
	@Override
	public void addPage(final Object page) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.addPage(page);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#addPage(java.lang.Object, int)
	 * @param page
	 * @param index
	 * 
	 */
	@Override
	public void addPage(final Object page, final int index) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.addPage(page, index);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#createChildSashModel(java.lang.Object)
	 * @param root
	 * @return
	 * 
	 */
	@Override
	public IAbstractPanelModel createChildSashModel(final Object root) {
		return diContentProvider.createChildSashModel(root);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#createFolder(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel,
	 *      int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)
	 * @param tabFolder
	 * @param tabIndex
	 * @param targetFolder
	 * @param side
	 * 
	 */
	@Override
	public void createFolder(final ITabFolderModel tabFolder, final int tabIndex, final ITabFolderModel targetFolder, final int side) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.createFolder(tabFolder, tabIndex, targetFolder, side);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * Keep trace of the current folder.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#setCurrentFolder(java.lang.Object)
	 * 
	 * @param rawModel
	 */
	@Override
	public void setCurrentFolder(final Object rawModel) {
		diContentProvider.setCurrentFolder(rawModel);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#getRootModel()
	 * @return
	 * 
	 */
	@Override
	public Object getRootModel() {
		return diContentProvider.getRootModel();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#movePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel,
	 *      int, int)
	 * @param folderModel
	 * @param oldIndex
	 * @param newIndex
	 * 
	 */
	@Override
	public void movePage(final ITabFolderModel folderModel, final int oldIndex, final int newIndex) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.movePage(folderModel, oldIndex, newIndex);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#movePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel,
	 *      int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)
	 * @param srcFolderModel
	 * @param sourceIndex
	 * @param targetFolderModel
	 * @param targetIndex
	 * 
	 */
	@Override
	public void movePage(final ITabFolderModel srcFolderModel, final int sourceIndex, final ITabFolderModel targetFolderModel, final int targetIndex) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.movePage(srcFolderModel, sourceIndex, targetFolderModel, targetIndex);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(int)
	 * @param index
	 * 
	 */
	@Override
	public void removePage(final int index) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.removePage(index);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(java.lang.Object)
	 * @param page
	 * 
	 */
	@Override
	public void removePage(final Object page) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.removePage(page);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel,
	 *      int)
	 * @param parentFolder
	 * @param tabIndex
	 * 
	 */
	@Override
	public void removePage(final ITabFolderModel parentFolder, final int tabIndex) {
		try {
			TransactionHelper.run(getTransactionalEditingDomain(), new Runnable() {

				@Override
				public void run() {
					diContentProvider.removePage(parentFolder, tabIndex);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

}
