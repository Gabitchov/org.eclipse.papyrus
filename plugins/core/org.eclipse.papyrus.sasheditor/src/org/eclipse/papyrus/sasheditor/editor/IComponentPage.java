/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;


/**
 * Allows to access to properties of a Sash ComponentPage.
 * This interface allows to read the data. User should not attent to modifiy or write the data in anyway.
 * This interface is provided as parameter of the {@link IPageChangedListener#pageChanged(IPage)} event and
 * in the SashContainer Visitor.
 * 
 * @author cedric dumoulin
 * 
 */
public interface IComponentPage extends IPage {

}
