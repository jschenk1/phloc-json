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
package com.phloc.json2.serialize;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.phloc.commons.string.ToStringGenerator;
import com.phloc.json2.IJsonValueSerializer;

/**
 * A special {@link IJsonValueSerializer} that writes an escaped string.
 * 
 * @author Philip Helger
 */
public final class JsonValueSerializerEscaped implements IJsonValueSerializer
{
  private static final JsonValueSerializerEscaped s_aInstance = new JsonValueSerializerEscaped ();

  private JsonValueSerializerEscaped ()
  {}

  @Nonnull
  public static JsonValueSerializerEscaped getInstance ()
  {
    return s_aInstance;
  }

  public static void appendEscapedJsonString (@Nonnull final String sValue, @Nonnull final Writer aWriter) throws IOException
  {
    aWriter.append ('"');
    JsonHelper.jsonEscape (sValue, aWriter);
    aWriter.append ('"');
  }

  public void appendAsJsonString (@Nullable final Object aValue, @Nonnull final Writer aWriter) throws IOException
  {
    appendEscapedJsonString (String.valueOf (aValue), aWriter);
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).toString ();
  }
}
