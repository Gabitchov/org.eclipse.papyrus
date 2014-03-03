/**
 * Copyright (c) 2007-2013 Borland Software Corporation && others
 * 
 * All rights reserved. This program && the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, && is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API && implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *  							- #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies;

import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd;

@Singleton
@SuppressWarnings("all")
public class Utils_qvto extends xpt.diagram.editpolicies.Utils_qvto {
  public Boolean containsCreateStartLinkCommand(final GenLinkEnd it) {
    Iterable<GenLink> _allPotentialLinks = this.getAllPotentialLinks(it);
    for (final GenLink l : _allPotentialLinks) {
      boolean _createStartLinkCommand = this.createStartLinkCommand(l, it);
      if (_createStartLinkCommand) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public Boolean containsCreateCompleteLinkCommand(final GenLinkEnd it) {
    Iterable<GenLink> _allPotentialLinks = this.getAllPotentialLinks(it);
    for (final GenLink l : _allPotentialLinks) {
      boolean _createCompleteLinkCommand = this.createCompleteLinkCommand(l, it);
      if (_createCompleteLinkCommand) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
}
