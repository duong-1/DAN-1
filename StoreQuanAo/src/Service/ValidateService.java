/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author TB
 */
public class ValidateService {

    public boolean checkPhone(String str) {

        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

        boolean kt = str.matches(reg);

        if (kt == false) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkGmail(String str) {

        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(str);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public boolean checkRong(String payload) {
        if (payload.equals("")) {
            return false;
        }
        return true;
    }

    public boolean checkRongMang(String[] payload) {
        for (String i : payload) {
            if (i.equals("")) {
                return false;
            }
        }
        return true;
    }

    public boolean checkKiTu(String str) {

        String regex = "\\d+%"; // \\d+ đại diện cho một hoặc nhiều chữ số, tiếp theo là ký tự %

        return str.matches(regex) && str.indexOf('%') == str.lastIndexOf('%');

    }

    public boolean checkTrung(String str, String str1) {
        if (str.equals(str1)) {
            return false;
        }
        return true;
    }

    public boolean checkSoNguyen(String payload) {
        try {
            int so = Integer.parseInt(payload);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
