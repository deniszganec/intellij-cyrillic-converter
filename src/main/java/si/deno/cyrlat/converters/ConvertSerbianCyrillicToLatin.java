package si.deno.cyrlat.converters;


import si.deno.cyrlat.AbstractConverter;
import si.deno.cyrlat.CyrillicLatinTextConverter;

/**
 * Implementation of a cyrillic to latin converter.
 *
 * @version 1.0
 * @author: Denis Žganec
 */
public class ConvertSerbianCyrillicToLatin extends AbstractConverter {
    @Override
    protected String convert(String text) {
        return CyrillicLatinTextConverter.cyrilicToLatin(text);
    }
}
