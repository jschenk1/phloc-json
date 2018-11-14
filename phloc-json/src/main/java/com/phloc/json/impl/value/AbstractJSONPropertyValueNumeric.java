/**
 * Copyright (C) 2006-2015 phloc systems
 * http://www.phloc.com
 * office[at]phloc[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phloc.json.impl.value;

import javax.annotation.Nonnull;

import com.phloc.json.IJSONPropertyValue;

/**
 * Implementation of {@link IJSONPropertyValue} with a numeric internal data
 * type
 * 
 * @author Philip Helger
 */
public abstract class AbstractJSONPropertyValueNumeric <DATATYPE extends Number> extends AbstractJSONPropertyValue <DATATYPE>
{
  private static final long serialVersionUID = 1527021852598398711L;

  protected AbstractJSONPropertyValueNumeric (@Nonnull final DATATYPE aData)
  {
    super (aData);
  }

  @Override
  public final void appendJSONString (@Nonnull final StringBuilder aResult,
                                      final boolean bAlignAndIndent,
                                      final int nLevel)
  {
    aResult.append (getData ().toString ());
  }
}
