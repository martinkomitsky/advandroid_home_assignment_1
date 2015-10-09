package ru.bmstu.tp.home_assignment_1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static java.lang.Math.round;

/**
 * Created by Martin on 21.04.2015.
 */
public class MyAdapter extends BaseAdapter {

    private List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public String getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View resultView;
        if (convertView != null) {
            resultView = convertView;
        } else {
            resultView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_element, parent, false);
        }
        if (position % 2 == 0) {
            resultView.setBackgroundColor(Color.parseColor("#aaaaaa"));
        } else {
            resultView.setBackgroundColor(Color.WHITE);
        }

        TextView textView = (TextView)resultView.findViewById(R.id.tf);
        textView.setText(numberToString(this.getItem(position)));

        return resultView;
    }

    public static String numberToString(String number) {
        String result;
        String[] catsName = {
                "Васька",
                "Кузя",
                "Барсик",
                "Мурзик",
                "Леопольд",
                "Бегемот",
                "Рыжик",
                "Матроскин"
        };
        String[] ar1 = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] ar2 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] ar3 = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
        String[] ar4 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
//        String[] ar5 = {"", "одна тысяча"};

        int numberInt = Integer.parseInt(number);
        if (numberInt < 10) {
            result = ar1[numberInt];
        } else if(numberInt == 10) {
            result = ar2[1];
        } else if (numberInt > 10 && numberInt < 20) {
            result = ar3[round(numberInt - 10)];
        } else if(numberInt > 19 && numberInt < 100) {
            if (numberInt % 10 == 0) {
                result = ar2[round(numberInt/10)];
            } else {
                result = ar2[round(numberInt/10)].concat(" ").concat(ar1[round(numberInt%10)]);
            }
        } else if (numberInt > 99 && numberInt < 1000) {
            if (numberInt % 100 > 10 && numberInt % 100 < 20) {
                result = ar4[round(numberInt/100)].concat(" ").concat(ar3[round(numberInt % 10)]);
            }
            else {
                result = ar4[round(numberInt/100)].concat(" ").concat(ar2[round(round(numberInt / 10) % 10)]).concat(" ").concat(ar1[round(numberInt % 10)]);
            }
        } else if (numberInt == 1000) {
            result = "одна тысяча";
        } else {
            result = catsName[3];
        }
        return result;
    }
}
