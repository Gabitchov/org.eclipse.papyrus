/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class Common extends xpt.Common {
  public CharSequence copyright(final GenEditorGenerator it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _copyrightText = it.getCopyrightText();
      boolean _notEquals = (!Objects.equal(_copyrightText, null));
      if (_notEquals) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        String _copyrightText_1 = it.getCopyrightText();
        String _replaceAll = _copyrightText_1.replaceAll("\n", "\n * ");
        _builder.append(_replaceAll, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
