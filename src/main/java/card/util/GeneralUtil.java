package card.util;

import org.apache.commons.validator.routines.EmailValidator;

public class GeneralUtil {

    public static boolean invalidEmail(String email) {
        if (stringIsNullOrEmpty(email)) return true;

        return !EmailValidator.getInstance().isValid(email);
    }

    public static boolean stringIsNullOrEmpty(String arg) {
        if ((arg == null)) return true;
        else
            return ("".equals(arg)) || (arg.trim().length() == 0);

    }
}
