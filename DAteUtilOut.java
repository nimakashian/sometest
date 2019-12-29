package com.textgateway.mp.plugin.client.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private class SolarCalendar {

        public String strWeekDay = "";
        public String strMonth = "";

        int date;
        int month;
        int year;
        int hour;
        int minute;
        int second;

        public SolarCalendar() {
            Date GregorianDate = new Date();
            calcSolarCalendar(GregorianDate, false);
        }

        public SolarCalendar(Date GregorianDate, boolean timeNeeded) {
            calcSolarCalendar(GregorianDate, timeNeeded);
        }

        private void calcSolarCalendar(Date GregorianDate, boolean timeNeeded) {

            int ld;

            int gregorianYear = GregorianDate.getYear() + 1900;
            int gregorianMonth = GregorianDate.getMonth() + 1;
            int gregorianDate = GregorianDate.getDate();
            int WeekDay = GregorianDate.getDay();

            if (timeNeeded) {
                hour = GregorianDate.getHours();
                minute = GregorianDate.getMinutes();
                second = GregorianDate.getSeconds();
            }

            int[] buf1 = new int[12];
            int[] buf2 = new int[12];

            buf1[0] = 0;
            buf1[1] = 31;
            buf1[2] = 59;
            buf1[3] = 90;
            buf1[4] = 120;
            buf1[5] = 151;
            buf1[6] = 181;
            buf1[7] = 212;
            buf1[8] = 243;
            buf1[9] = 273;
            buf1[10] = 304;
            buf1[11] = 334;

            buf2[0] = 0;
            buf2[1] = 31;
            buf2[2] = 60;
            buf2[3] = 91;
            buf2[4] = 121;
            buf2[5] = 152;
            buf2[6] = 182;
            buf2[7] = 213;
            buf2[8] = 244;
            buf2[9] = 274;
            buf2[10] = 305;
            buf2[11] = 335;

            if ((gregorianYear % 4) != 0) {
                date = buf1[gregorianMonth - 1] + gregorianDate;

                if (date > 79) {
                    date = date - 79;
                    if (date <= 186) {
                        switch (date % 31) {
                            case 0:
                                month = date / 31;
                                date = 31;
                                break;
                            default:
                                month = (date / 31) + 1;
                                date = (date % 31);
                                break;
                        }
                        year = gregorianYear - 621;
                    } else {
                        date = date - 186;

                        switch (date % 30) {
                            case 0:
                                month = (date / 30) + 6;
                                date = 30;
                                break;
                            default:
                                month = (date / 30) + 7;
                                date = (date % 30);
                                break;
                        }
                        year = gregorianYear - 621;
                    }
                } else {
                    if ((gregorianYear > 1996) && (gregorianYear % 4) == 1) {
                        ld = 11;
                    } else {
                        ld = 10;
                    }
                    date = date + ld;

                    switch (date % 30) {
                        case 0:
                            month = (date / 30) + 9;
                            date = 30;
                            break;
                        default:
                            month = (date / 30) + 10;
                            date = (date % 30);
                            break;
                    }
                    year = gregorianYear - 622;
                }
            } else {
                date = buf2[gregorianMonth - 1] + gregorianDate;

                if (gregorianYear >= 1996) {
                    ld = 79;
                } else {
                    ld = 80;
                }
                if (date > ld) {
                    date = date - ld;

                    if (date <= 186) {
                        switch (date % 31) {
                            case 0:
                                month = (date / 31);
                                date = 31;
                                break;
                            default:
                                month = (date / 31) + 1;
                                date = (date % 31);
                                break;
                        }
                        year = gregorianYear - 621;
                    } else {
                        date = date - 186;

                        switch (date % 30) {
                            case 0:
                                month = (date / 30) + 6;
                                date = 30;
                                break;
                            default:
                                month = (date / 30) + 7;
                                date = (date % 30);
                                break;
                        }
                        year = gregorianYear - 621;
                    }
                } else {
                    date = date + 10;

                    switch (date % 30) {
                        case 0:
                            month = (date / 30) + 9;
                            date = 30;
                            break;
                        default:
                            month = (date / 30) + 10;
                            date = (date % 30);
                            break;
                    }
                    year = gregorianYear - 622;
                }

            }

            switch (month) {
                case 1:
                    strMonth = "فروردين";
                    break;
                case 2:
                    strMonth = "ارديبهشت";
                    break;
                case 3:
                    strMonth = "خرداد";
                    break;
                case 4:
                    strMonth = "تير";
                    break;
                case 5:
                    strMonth = "مرداد";
                    break;
                case 6:
                    strMonth = "شهريور";
                    break;
                case 7:
                    strMonth = "مهر";
                    break;
                case 8:
                    strMonth = "آبان";
                    break;
                case 9:
                    strMonth = "آذر";
                    break;
                case 10:
                    strMonth = "دي";
                    break;
                case 11:
                    strMonth = "بهمن";
                    break;
                case 12:
                    strMonth = "اسفند";
                    break;
            }

            switch (WeekDay) {

                case 0:
                    strWeekDay = "يکشنبه";
                    break;
                case 1:
                    strWeekDay = "دوشنبه";
                    break;
                case 2:
                    strWeekDay = "سه شنبه";
                    break;
                case 3:
                    strWeekDay = "چهارشنبه";
                    break;
                case 4:
                    strWeekDay = "پنج شنبه";
                    break;
                case 5:
                    strWeekDay = "جمعه";
                    break;
                case 6:
                    strWeekDay = "شنبه";
                    break;
            }

        }

    }

    public static String getCurrentSolarDate(Date date, boolean timeNeeded) {
        Locale loc = new Locale("en_US");
        DateUtil util = new DateUtil();
        SolarCalendar sc = util.new SolarCalendar(date, timeNeeded);
        String result = String.format("%04d%02d%02d", sc.year, sc.month, sc.date);

        if (timeNeeded) {
            result += "," + String.format("%02d", sc.hour)
                    + String.format("%02d", sc.minute)
                    + String.format("%02d", sc.second);
        }

        return result;
    }

    public static String getCurrentSolarDate(long timestamp, boolean timeNeeded) {
        Date date = new Date(timestamp);

        Locale loc = new Locale("en_US");
        DateUtil util = new DateUtil();
        SolarCalendar sc = util.new SolarCalendar(date, timeNeeded);
        String result = String.format("%04d%02d%02d", sc.year, sc.month, sc.date);

        if (timeNeeded) {
            result += "," + String.format("%02d", sc.hour)
                    + String.format("%02d", sc.minute)
                    + String.format("%02d", sc.second);
        }

        return result;
    }

    public static String[] getCurrentSolarDate(long timestamp) {
        return getCurrentSolarDate(timestamp,"%04d%02d%02d", "%02d%02d%02d");
    }

    public static String[] getCurrentSolarDate(long timestamp, String dateFormat, String timeFormat) {
        Date date = new Date(timestamp);

        Locale loc = new Locale("en_US");
        DateUtil util = new DateUtil();
        SolarCalendar sc = util.new SolarCalendar(date, true);

        String dateStr = String.format(dateFormat, sc.year, sc.month, sc.date);
        String  timeStr = String.format(timeFormat, sc.hour, sc.minute, sc.second);

        return new String[] { dateStr, timeStr };
    }

    public static Date differDate(Date date, int differ) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, differ);
        return c.getTime();
    }

    public static Date parseDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            //logger.warn("Unable to parse date " + date, e);
        }
        return null;
    }

    public static String parseDate(Date date) {
        return sdf.format(date);
    }

    public static String format(String date) {
        String result;
        if (date.length() == 14 && date.startsWith("13")) {
            result = date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6, 8)
                    + " " + date.substring(8, 10)
                    + ":" + date.substring(10, 12)
                    + ":" + date.substring(12, 14);
        } else if (date.length() == 12) {
            result = "13" + date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 6)
                    + " " + date.substring(6, 8)
                    + ":" + date.substring(8, 10)
                    + ":" + date.substring(10, 12);
        } else {
            throw new RuntimeException("Invalid Date");
        }

        return result;
    }
}
