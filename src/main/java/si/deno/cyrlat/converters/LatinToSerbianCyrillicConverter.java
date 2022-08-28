package si.deno.cyrlat.converters;


import si.deno.cyrlat.AbstractConverter;
import si.deno.cyrlat.CyrillicLatinTextConverter;

/**
 * Implementation of a latin to cyrillic converter.
 *
 * @author: Denis Žganec
 */
public class LatinToSerbianCyrillicConverter extends AbstractConverter {
    @Override
    protected String convert(String text) {
        return CyrillicLatinTextConverter.latinToCyrillic(text);
    }
}
