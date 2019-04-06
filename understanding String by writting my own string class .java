


import java.io.ObjectStreamField;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.lang.String ;

public final class StringClone {
	
	public final char value[];
	 /** Cache the hash code for the string */
    private int hash; // Default to 0
    
	public StringClone() {
        this.value = new char[0];
    }
	
	 public StringClone(char value[]) {
	        this.value = Arrays.copyOf(value, value.length);
	 }
	 
	 public StringClone replace(char oldChar, char newChar) {
		 
	        if (oldChar != newChar) {
	            int len = value.length;
	            int i = -1;
	            char[] val = value; /* avoid getfield opcode */

	            while (++i < len) {
	                if (val[i] == oldChar) { 
	                	// found i ,place where i would place newchar
	                    break;
	                }
	            }
	            
	            if (i < len) {
	                while (i < len) {
	                    char c = val[i];
	                    val[i] = (c == oldChar) ? newChar : c;
	                    i++;
	                }
	                return this ;
	            }
	        }
	        
	        return this;
	    }
	 
	 @Override
	 public String toString() { 
	        return String.valueOf(value);
	 } 
	 
	 public static void main(String[] args) {
		 char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
		 StringClone clone = new StringClone(charArray);
		 clone.replace('a', 'b');
		 System.out.println(clone);
	 }
	 
	
}
