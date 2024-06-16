package com.example.searchfordiscount.service;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    public String searchDiscount(String text) {
        if ((text == null)) {
            text="Текст пустой";
            return text;
        }
        List<Integer> arrayDiscount = new ArrayList<>();
        String[] arrayString = text.split(" ");
        for (String e : arrayString) {
            if (e.indexOf("скидк") != -1 ) {arrayDiscount.add(-1);
            }else if (e.indexOf("процент") != -1 ) {arrayDiscount.add(-2);
            }else try {
                arrayDiscount.add(Integer.parseInt(e));
            } catch (NumberFormatException nfe){            };
        }
        return  checkDiscount(arrayDiscount);
    }
    private String checkDiscount(List<Integer> array) {
        String text=null;
        if (array.size() < 3) {
            return "not Discount";
        }
        for (int i = 3; i < array.size() - 1; i++) {
            //поиск совпадений скидка __ процентов
            if (array.get(i - 2) == -1 && array.get(i - 1) > -1 && array.get(i) == -2) {
                i=i+3; text = text +"скидкa "+array.get(i - 1)+" процентов ,";
            }
            // поиск совпадений __ скидка  процентов
            if ( array.get(i - 2) > -1 && array.get(i - 1) == -1 && array.get(i) == -2) {
                i=i+3; text = text +"скидкa "+array.get(i - 2)+" процентов ,";
            }
            // поиск совпадений  процентов скидка __
            if ( array.get(i-2) == -2 && array.get(i - 1) == -1 && array.get(i) > -1) {
                i=i+3; text = text +"скидкa "+array.get(i - 2)+" процентов ,";
            }
            // поиск совпадений  процентов __ скидка
            if ( array.get(i-2) == -2 && array.get(i-1) > -1 && array.get(i ) == -1 ) {
                i=i+3; text = text +"скидкa "+array.get(i - 2)+" процентов ,";
            }
            // поиск совпадений  скидка процентов __
            if ( array.get(i-2) == -1 && array.get(i-1) == -2 && array.get(i) > -1 ) {
                i=i+3; text = text +"скидкa "+array.get(i - 2)+" процентов ,";
            }
            // поиск совпадений  __ процентов скидка
            if ( array.get(i-2) > -1 && array.get(i - 1) == -2 && array.get(i) == -1) {
                i=i+3; text = text +"скидкa "+array.get(i - 2)+" процентов ,";
            }
        }
        return text;
    }
}
