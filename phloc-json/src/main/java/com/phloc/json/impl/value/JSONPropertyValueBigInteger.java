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

import java.math.BigInteger;

import javax.annotation.Nonnull;

import com.phloc.commons.string.StringParser;

/**
 * Implementation of {@link IJSONPropertyValue} with the internal data type
 * {@link BigInteger}
 * 
 * @author Philip Helger
 */
public class JSONPropertyValueBigInteger extends AbstractJSONPropertyValueNumeric <BigInteger>
{// NOPMD
  private static final long serialVersionUID = 9120652799872699460L;

  public JSONPropertyValueBigInteger (@Nonnull final BigInteger aData)
  {
    super (aData);
  }

  @Override
  @Nonnull
  public JSONPropertyValueBigInteger getClone ()
  {
    return new JSONPropertyValueBigInteger (getData ());
  }

  /**
   * Tries to create a {@link JSONPropertyValueBigInteger} from the passed JSON
   * string
   * 
   * @param sJSON
   *        the JSON string to convert
   * @return the resulting object
   * @throws IllegalArgumentException
   *         If the passed string is not null but cannot be converted to a
   *         {@link BigInteger}
   */
  @Nonnull
  public static JSONPropertyValueBigInteger fromJSONString (final String sJSON)
  {
    final BigInteger aValue = StringParser.parseBigInteger (sJSON);
    if (sJSON != null && aValue == null)
    {
      throw new IllegalArgumentException ("Parsed JSON '" + sJSON + "' is not a BigInteger!"); //$NON-NLS-1$ //$NON-NLS-2$
    }
    return new JSONPropertyValueBigInteger (aValue);
  }
}
