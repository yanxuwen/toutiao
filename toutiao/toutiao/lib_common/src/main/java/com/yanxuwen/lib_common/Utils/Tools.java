package com.yanxuwen.lib_common.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

	public static List<String> getString(String str,String star, String end){
		Pattern pattern = Pattern.compile("(?<="+star+")(\\S+?)(?="+end+")");
        Matcher matcher = pattern.matcher(str);
        List<String> data = new ArrayList<String>();
        while(matcher.find())
            data.add(matcher.group());
        return data;
	}
	public static List<String> getString(String str,String pre,String star, String end){
		Pattern pattern = Pattern.compile("(?<="+star+")"+pre+"(?="+end+")");
        Matcher matcher = pattern.matcher(str);
        List<String> data = new ArrayList<String>();

		for(String ss:data){

		}
        while(matcher.find())
            data.add(matcher.group());
        return data;
	}
	
	public static void main(String[] args) {
		String str = "ok=\"review-body\" class=\"a-size-base review-text\">Love these insoles, have them for all my shoes. Great support and cushion. I work on hard floors on my feet for 8 hrs. a day.  Feet feel great.</span></div><div class=\"a-row review-comments comments-for-RNE0SFUMQ5FBA\"><div";
		List<String> s = Tools.getString(str, "([\\s\\S]*?)", "class=\"a-size-base review-text\">", "</span></div><div class=\"a-row review-comments comments-for");
		System.out.println(s.get(0));
	}
}
