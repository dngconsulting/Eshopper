package com.dngconsulting.demo.shared;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

public class FormatHelper {
	private static NumberFormat currencyFormatter = NumberFormat.getFormat("#,##0.00 ¤", "EUR");
    private static NumberFormat floatFormatter = NumberFormat.getFormat("0.00");

    //	private static NumberFormat currencyFormatter = NumberFormat.getSimpleCurrencyFormat("EUR");
    private static NumberFormat moisFormatter = NumberFormat.getFormat("00");
    private static NumberFormat anFormatter = NumberFormat.getFormat("0000");
    private static DateTimeFormat moisAnneeFormatter = DateTimeFormat.getFormat("MM/yyyy");
    private static DateTimeFormat anneeMoisFormatter = DateTimeFormat.getFormat("yyyyMM");
    private static DateTimeFormat anneeMoisJoursFormatter = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static DateTimeFormat anneeMoisJoursFormatter2 = DateTimeFormat.getFormat("yyyyMMdd");
    private static DateTimeFormat joursMoisAnneeFormatter = DateTimeFormat.getFormat("dd/MM/yyyy");
    private static DateTimeFormat hourFormat = DateTimeFormat.getFormat("HH'H'mm");

    public static String ERROR = "ERROR";

    public static String formatPrice(Number price){
    	if(price == null) return "";
    	return currencyFormatter.format(price);
    }


    public static String formatJourMoisAnnee(Date d){
        if(d == null) return "";
        return joursMoisAnneeFormatter.format(d);
    }

    public static Date parseMoisAnnee(int mois, int annee){
        if(annee == 0) return null;
        String date = moisFormatter.format(mois) + "/" + anFormatter.format(annee);
        return moisAnneeFormatter.parse(date);
    }

    public static Date parseMoisAnnee(String date){
        return moisAnneeFormatter.parse(date);
    }

    public static String formatMoisAnnee(int mois, int annee){
        if(annee == 0) return "";
        return moisFormatter.format(mois) + "/" + anFormatter.format(annee);
    }

    public static String formatMoisAnnee(Date d){
        if(d == null) return "";
        return moisAnneeFormatter.format(d);
    }

    public static String formatJoursMoisAnneeFromAnneeMoisJours(String d){
        if(d == null) return "";
        try{
        return joursMoisAnneeFormatter.format(anneeMoisJoursFormatter.parse(d));
        }
        catch(IllegalArgumentException e){
        	return "ERREUR FORMAT";
        }
    }

    public static DateTimeFormat getJoursMoisAnneeFormatter() {
        return joursMoisAnneeFormatter;
    }

    public static Date parseAnneMoisJours(String d){
        return anneeMoisJoursFormatter.parse(d);
    }

    public static Date parseAnneMoisJours2(String d){
        return anneeMoisJoursFormatter2.parse(d);
    }

    public static String formatRefArticle(String ref){
    	boolean endWithStar = false;
    	if(ref.substring(ref.length()-1).equals("*")){
    		endWithStar = true;
    		ref.substring(0, ref.length()-1);
    	}
        ref = ref.replaceAll("[^A-Za-z0-9]", "");
        ref = ref.toUpperCase();
        if(endWithStar) ref += "*";
        return ref;
    }

    public static Date parseAnneeMois(String date) {
        return anneeMoisFormatter.parse(date);
    }
    
    public static String formatHourMinute(Date d){
    	if(d==null) return "";
    	return hourFormat.format(d);
    }

    public static String formatNumS(String s){
        if(s.startsWith("0")){
            s = s.replaceAll("^0*", "");
        }
        return s;
    }

    public static int compareDate(Date d1, Date d2){
        if(d1 == null){
            if(d2 != null) return -1;
            else return 0;
        }else{
            if(d2 == null) return 1;
            else return d1.compareTo(d2);
        }
    }

    public static int compareString(String d1, String d2){
        if(d1 == null || d1.isEmpty()){
            if(d2 != null && !d2.isEmpty()) return -1;
            else return 0;
        }else{
            if(d2 == null || d2.isEmpty()) return 1;
            else return d1.compareTo(d2);
        }
    }

//    public static int compareEnum(Enum d1, Enum d2){
//        if(d1 == null){
//            if(d2 != null) return -1;
//            else return 0;
//        }else{
//            if(d2 == null) return 1;
//            else return d1.name().compareTo(d2.name());
//        }
//    }

    public static int compareInteger(Integer n1, Integer n2){
        if(n1 == null){
            if(n2 != null) return -1;
            else return 0;
        }else{
            if(n2 == null) return 1;
            else return n1.compareTo(n2);
        }
    }
    public static int compareLong(Long n1, Long n2){
        if(n1 == null){
            if(n2 != null) return -1;
            else return 0;
        }else{
            if(n2 == null) return 1;
            else return n1.compareTo(n2);
        }
    }

    public static int compareFloat(Float n1, Float n2) {
        if(n1 == null){
            if(n2 != null) return -1;
            else return 0;
        }else{
            if(n2 == null) return 1;
            else return n1.compareTo(n2);
        }
    }

    public static String formatIntegerString(String string) {
        if(string == null) return "";
        return string.replaceAll("[^0-9]", "");
    }

    public static String formatFloatString(double f) {
        return floatFormatter.format(f);
    }
    public static String formatFloatString(String string) {
        if(string == null) return "";
        float f = (float) floatFormatter.parse(string.replaceAll("[^0-9,]", ""));
        return floatFormatter.format(f);
    }

    public static String formatPercent(Number f) {
        return floatFormatter.format(f) + "%";
    }

    public static float parseFloat(String value){
        if(value == null || value.isEmpty()) return 0f;
        value = value.replaceAll(",", ".");
        value = value.replaceAll("[^0-9.]", "");
        return Float.valueOf(value);
    }
    public static int parseInteger(String value){
        if(value == null || value.isEmpty()) return 0;
        value = value.replaceAll("[^0-9]", "");
        return Integer.valueOf(value);
    }

    /**
     * yyyy-MM-dd
     * @param date
     * @return
     */
    public static String formatAnneeMoisJours(Date date) {
        return anneeMoisJoursFormatter.format(date);
    }

    public static String formatInteger(float qte) {
        return Integer.valueOf((int) qte).toString();
    }

    public static boolean isInteger(String value) {
        return value.matches("[0-9]+");
    }

    public static boolean isFloat(String value) {
        return value.matches("[0-9]+((.|,)?[0-9]+)?");
    }
    public static boolean isEmptyString(String s){
        return s == null || s.trim().isEmpty();
    }

    public static boolean isCP(String value) {
        return value.matches("[0-9]{5}");
    }

    public static boolean isEmail(String value) {
        return value.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
    }
    public static boolean isTel(String value) {
        return value.matches("^0[1-68]([-. ]?[0-9]{2}){4}$");
    }
    public static boolean isUrl(String value) {
        return value.matches("((https?):((//)|(\\\\\\\\))[\\w\\d:#%/;$()~_?\\-=\\\\\\.&]*)");
    }

}
